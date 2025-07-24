package MiniProjectAlerts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertsPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public alertsPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	// Locators
	By switchToMenu = By.linkText("SwitchTo");
	By alertsLink = By.linkText("Alerts");
	By alertWithOKTab = By.xpath("//a[normalize-space()='Alert with OK']");
	By alertWithOKButton = By.xpath("//button[contains(text(),'click the button to display an')]");
	By alertWithCancelTab = By.xpath("//a[@href='#CancelTab']");
	By alertWithCancelButton = By.xpath("//div[@id='CancelTab']/button");
	By cancelMessage = By.id("demo");
	By alertWithTextboxTab = By.xpath("//a[@href='#Textbox']");
	By alertWithTextboxButton = By.xpath("//div[@id='Textbox']/button");
	By textboxMessage = By.id("demo1");

	// Actions
	public void navigateToAlertsPage() {
		driver.get("http://demo.automationtesting.in/Alerts.html");
		new Actions(driver).moveToElement(driver.findElement(switchToMenu)).perform();
		driver.findElement(alertsLink).click();
		}

	public void handleAlertWithOK() {
		driver.findElement(alertWithOKTab).click();
		driver.findElement(alertWithOKButton).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert Message: " + alert.getText());
		alert.accept();
		}

	public void handleAlertWithCancel() {
		driver.findElement(alertWithCancelTab).click();
		driver.findElement(alertWithCancelButton).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert Message: " + alert.getText());
		alert.dismiss();
		System.out.println("Message displayed: " + driver.findElement(cancelMessage).getText());
		}

	public void handleAlertWithTextbox(String inputName, String exptdOutput, String filepath, String xlsheet, int i) throws IOException {
		driver.findElement(alertWithTextboxTab).click();
		driver.findElement(alertWithTextboxButton).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Prompt Message: " + alert.getText());
		alert.sendKeys(inputName);
		alert.accept();
		String actOutput = driver.findElement(textboxMessage).getText();
		ExcelUtils.setCellData(filepath, xlsheet, i, 2, actOutput);

		if (actOutput.equals(exptdOutput)) {
			ExcelUtils.setCellData(filepath, xlsheet, i, 3, "Passed");
			ExcelUtils.fillGreenColor(filepath, xlsheet, i, 3);
		} else {
			ExcelUtils.setCellData(filepath, xlsheet, i, 3, "Failed");
			ExcelUtils.fillRedColor(filepath, xlsheet, i, 3);
		}
		System.out.println("Message displayed: " + actOutput);
		}
	public void handleAlertWithTextboxDP(String inputName) {
		driver.findElement(alertWithTextboxTab).click();
		driver.findElement(alertWithTextboxButton).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Prompt Message: " + alert.getText());
		alert.sendKeys(inputName);
		alert.accept();
	}
	}
