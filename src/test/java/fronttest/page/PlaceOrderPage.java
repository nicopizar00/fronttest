package fronttest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fronttest.model.Payment;
import fronttest.util.WaitUtils;

public class PlaceOrderPage extends BasePage {
	public PlaceOrderPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		WaitUtils.waitElementVisible(webDriver, By.id("orderModalLabel"));
	}

	@FindBy(id = "name")
	WebElement txtName;

	@FindBy(id = "country")
	WebElement txtCountry;

	@FindBy(id = "city")
	WebElement txtCity;

	@FindBy(id = "card")
	WebElement txtCard;

	@FindBy(id = "month")
	WebElement txtMonth;

	@FindBy(id = "year")
	WebElement txtYear;

	@FindBy(xpath = "//*[@class='btn btn-primary' and text()='Purchase']")
	WebElement btnPurchase;

	/**
	 * Completes the payment form and purchase verifies if the purchase completes.
	 * 
	 * @param payment The payment data to complete the form.
	 * @return The Order messages to verify it.
	 */
	public String[] completeFormAndPurchase(Payment payment) {
		try {

			txtName.sendKeys(payment.getName());
			txtCountry.sendKeys(payment.getCountry());
			txtCity.sendKeys(payment.getCity());
			txtCard.sendKeys(payment.getCreditCard());
			txtMonth.sendKeys(payment.getMonth());
			txtYear.sendKeys(payment.getYear());
			btnPurchase.click();

			WaitUtils.waitElementVisible(webDriver, By.xpath("//*[@class='sweet-alert  showSweetAlert visible']"));

			WebElement alertPurchaseOrder = webDriver
					.findElement(By.xpath("//*[@class='sweet-alert  showSweetAlert visible']"));
			WebElement orderMessage = alertPurchaseOrder
					.findElement(By.xpath("//*[text()='Thank you for your purchase!']"));
			WebElement orderDetails = alertPurchaseOrder.findElement(By.xpath("//*[@class='lead text-muted ']"));

			return new String[] { orderMessage.getText(), orderDetails.getText() };
		} catch (Exception e) {
			return null;
		}
	}
}
