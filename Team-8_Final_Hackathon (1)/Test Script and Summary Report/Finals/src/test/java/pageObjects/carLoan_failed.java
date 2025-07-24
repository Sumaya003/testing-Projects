package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WaitUtils;

public class carLoan_failed extends BasePage {

    WebDriver driver;

    public carLoan_failed(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"car-loan\"]/a")
    WebElement locateCar;

    @FindBy(xpath = "//*[@id=\"loanamount\"]")
    WebElement loanAmount;

    @FindBy(xpath = "//*[@id=\"loaninterest\"]")
    WebElement loanRate;

    @FindBy(xpath = "//*[@id=\"loanterm\"]")
    WebElement loanTenure;

    @FindBy(xpath ="//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div/div/label[1]")
    WebElement clickEmiArrear;

    @FindBy(xpath = "//*[@id=\"emiamount\"]/p/span")
    WebElement showEmi;

    @FindBy(xpath = "//*[@id=\"emitotalinterest\"]/p/span")
    WebElement showInterest;

    @FindBy(xpath = "//*[@id=\"emitotalamount\"]/p/span")
    WebElement showAmount;
    
    @FindBy(xpath = "//*[@id=\"leschemewrapper\"]/div/label")
    WebElement emiScheme;

    public void clickCarLoan() {
        locateCar.click();
    }

    public void setAmount(String amount) {
//    	WaitUtils.setInputValueWithJS(driver, loanAmount, amount);
    	WaitUtils.overwriteInput(loanAmount, amount);
    }

    public void setRate(String rate) {
        
//    	WaitUtils.setInputValueWithJS(driver, loanRate, rate);
    	loanRate.sendKeys(rate);
//    	WaitUtils.overwriteInput(loanRate, rate);
    }

    public void setTenure(String tenure) {
        
//    	WaitUtils.setInputValueWithJS(driver, loanTenure, tenure);
    	loanTenure.sendKeys(tenure);
//    	WaitUtils.overwriteInput(loanTenure, tenure);
    }

    public void clickEmi() {
        clickEmiArrear.click();
        WaitUtils.scrollIntoView(driver, emiScheme);
//        WaitUtils.scrollToElement(driver, clickEmiArrear);
    }

    public String displayEMI() {
//        WaitUtils.waitForNonEmptyText(driver, showEmi, 10);
        String emi = showEmi.getText();
        System.out.println("EMI: " );
        return emi;
    }

    public String displayInterest() {
//        WaitUtils.waitForNonEmptyText(driver, showInterest, 10);
        String interest = showInterest.getText();
        System.out.println("Interest: " );
        return interest;
    }

    public String displayAmount() {
//        WaitUtils.waitForNonEmptyText(driver, showAmount, 10);
        String amount = showAmount.getText();
        System.out.println("Total Amount: " );
        return amount;
    }
}

