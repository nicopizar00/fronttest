package fronttest.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fronttest.util.WaitUtils;

public class HomePage extends BasePage {
	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		WaitUtils.waitElementVisible(webDriver, By.xpath("//*[@class='card h-100']")); //todo: update to check when page fully load
	}

	@FindBy(xpath = "//*[@class='card h-100']")
	List<WebElement> productList;

	/**
	 * Click the first product to purchase it.
	 * 
	 * @return Product Page
	 */
	public ProductPage goToFirstProduct() {
		productList.get(0).click();
		return new ProductPage(webDriver);
	}
}
