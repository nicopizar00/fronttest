package fronttest.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import fronttest.config.BaseConfig;
import fronttest.dataprovider.PaymentDataProvider;
import fronttest.model.Payment;
import fronttest.page.CartPage;
import fronttest.page.HomePage;
import fronttest.page.PlaceOrderPage;
import fronttest.page.ProductPage;

public class Purchase extends BaseConfig {

	@Test(description = "The complete purchase flow", dataProviderClass = PaymentDataProvider.class, dataProvider = "fromJson")
	public void purchase(Payment payment) {
		HomePage homePage = new HomePage(webDriver);
		assertNotNull(homePage, "There was a problem loading home page.");

		ProductPage productPage = homePage.goToFirstProduct();
		assertNotNull(productPage, "Failed loading product page.");
		assertTrue(productPage.addtoCart(), "Not possible to add to cart.");

		CartPage cartPage = productPage.goToCart();
		assertNotNull(cartPage, "Failed loading cart page.");

		PlaceOrderPage placeOrderPage = cartPage.placeOrder();
		assertNotNull(placeOrderPage, "Not possible to place order.");

		String[] purchaseOrder = placeOrderPage.completeFormAndPurchase(payment);
		assertEquals(purchaseOrder[0], "Thank you for your purchase!", "Order Message is not ok.");
		assertTrue(!purchaseOrder[1].isEmpty(), "The Order Details does not contain data.");
	}
}
