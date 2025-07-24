package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoanCalculatorPage extends BasePage{
	
	WebDriver driver;
	WebDriverWait wait;

	public LoanCalculatorPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath="//*[@id='menu-item-dropdown-2696']")
	WebElement loanCalMenu;
	

	@FindBy(xpath="//*[@id='menu-item-2423']/a")
	WebElement emiCalculatorTab;
	

	@FindBy(xpath="//*[@id='emi-calc']/a[1]")
	WebElement emiCalcSection;
	
	
	@FindBy(xpath="//*[@id='loan-amount-calc']/a[1]")
	WebElement loanAmountCalcTab;
	

	@FindBy(xpath="//*[@id='loan-tenure-calc']/a[1]")
	WebElement loanTenureCalcTab;
	
	@FindBy(id="loanterm")
	WebElement tenureInput;
	

	@FindBy(xpath="//*[@id='ltermwrapper']/div[1]/div/div/div/div/div/label[1]")
	WebElement yearLabel;
	

	@FindBy(xpath="//*[@id='ltermwrapper']/div[1]/div/div/div/div/div/label[2]")
	WebElement monthLabel;
	

	public void openLoanCalculatorMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(loanCalMenu)).click();
	}

	

	public void openEMICalculator() {
		wait.until(ExpectedConditions.elementToBeClickable(emiCalculatorTab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(emiCalcSection)).click();
	}


	public void openLoanAmountCalculator() {
		wait.until(ExpectedConditions.elementToBeClickable(loanAmountCalcTab)).click();
	}

	public void openLoanTenureCalculator() {
		wait.until(ExpectedConditions.elementToBeClickable(loanTenureCalcTab)).click();
		}



	public String switchTenureToYear() {
		yearLabel.click();
		return tenureInput.getAttribute("value");
	}

	public String switchTenureToMonth() {
		monthLabel.click();
		return tenureInput.getAttribute("value");
		}

	public String getTenureValue() {
		
		return tenureInput.getAttribute("value");
	}


	public boolean validateField(String fieldId) {
		try {
			WebElement field = driver.findElement(By.id(fieldId));
			return field.isDisplayed() && field.isEnabled();
		} 
		catch (NoSuchElementException e) {
				return false;
		}
	}




	

}
