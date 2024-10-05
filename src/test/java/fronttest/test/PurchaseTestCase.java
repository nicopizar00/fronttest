package fronttest.test;

import fronttest.config.BaseConfig;
import fronttest.dataprovider.PaymentDataProvider;
import fronttest.model.Payment;
import fronttest.page.CartPage;
import fronttest.page.HomePage;
import fronttest.page.ProductPage;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PurchaseTestCase extends BaseConfig {

    @Test(description = "The complete purchase flow", dataProviderClass = PaymentDataProvider.class, dataProvider = "fromJson")
    public void purchase(Payment payment) {
        assertEquals(driver.getTitle(), "STORE");
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.clickFirstProduct();
        Alert alert = productPage.addToCart();
        assertEquals(alert.getText(), "Product added", "Not possible to add to cart.");
        alert.accept();
        CartPage cartPage = productPage.goToCart();

        assertTrue(cartPage.clickPlaceOrder());
        assertTrue(cartPage.completeForm(payment));
        assertEquals(cartPage.getOrderMessage().getText(),
                "Thank you for your purchase!",
                "Order Message is not ok.");
        assertFalse(cartPage.getOrderDetails().getText().isEmpty(),
                "The Order Details does not contain data.");
    }
}
