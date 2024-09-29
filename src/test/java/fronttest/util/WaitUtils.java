package fronttest.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
	/**
	 * Waits until the web element is visible.
	 *
	 * @param webDriver From test execution.
	 * @param locator   To find the web element.
	 */
	public static void waitElementVisible(WebDriver webDriver, By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * Wait for an alert to appear in the browser.
	 *
	 * @param webDriver From test execution.
	 */
	public static void waitAlert(WebDriver webDriver) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Waits until the element is visible and clickable.
	 *
	 * @param webDriver From test execution.
	 * @param locator   To find the web element.
	 */
	public static void waitElementClickable(WebDriver webDriver, By locator) {
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	String asdf = "//*[@class='success']"; //todo: remove this line of code
}
