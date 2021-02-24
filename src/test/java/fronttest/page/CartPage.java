package fronttest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fronttest.util.WaitUtils;

public class CartPage extends BasePage {
	public CartPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		WaitUtils.waitElementClickable(webDriver, By.id("totalp"));
	}

	@FindBy(xpath = "//*[@class='btn btn-success']")
	WebElement btnPlaceOrder;

	/**
	 * Clicks Place Order button
	 * 
	 * @return Place Order Page
	 */
	public PlaceOrderPage placeOrder() {
		try {
			btnPlaceOrder.click();
			return new PlaceOrderPage(webDriver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
