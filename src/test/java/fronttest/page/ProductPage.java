package fronttest.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fronttest.util.WaitUtils;

public class ProductPage extends BasePage {
	public ProductPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		WaitUtils.waitElementClickable(webDriver, By.xpath("//*[@class='btn btn-success btn-lg']"));

	}

	@FindBy(xpath = "//*[@class='btn btn-success btn-lg']")
	WebElement btnAddToCart;

	@FindBy(id = "cartur")
	WebElement navItemCart;

	/**
	 * Clicks Add to Cart button.
	 * 
	 * @return boolean true if completes ok.
	 */
	public boolean addtoCart() {
		try {
			btnAddToCart.click();
			WaitUtils.waitAlert(webDriver);
			Alert alert = webDriver.switchTo().alert();
			alert.accept();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Click Go to Cart nav item (at the top of the website)
	 * 
	 * @return Cart Page.
	 */
	public CartPage goToCart() {
		try {
			navItemCart.click();
			return new CartPage(webDriver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
