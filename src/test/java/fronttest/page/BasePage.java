package fronttest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * It serves to inherit properties to new page instances
 * and also to proper pass from a page to other in a continuous flow.
 * 
 * @author Nicolas Pizarro
 *
 */
public class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}
