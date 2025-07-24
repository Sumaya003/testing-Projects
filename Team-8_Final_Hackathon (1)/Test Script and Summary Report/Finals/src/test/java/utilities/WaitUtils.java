package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {


	public static void waitForNonEmptyText(WebDriver driver,WebElement element,int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeoutInSeconds));
		wait.until(webDriver -> {
			String text = element.getText();
			return text != null && !text.trim().isEmpty();
		});
	}


	public static void scrollIntoView(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	

	public static void overwriteInput(WebElement element, String value) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
		element.sendKeys(value); // Overwrite
		}



}
