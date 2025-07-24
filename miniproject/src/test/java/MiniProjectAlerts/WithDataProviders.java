package MiniProjectAlerts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WithDataProviders {
	WebDriver driver = new ChromeDriver();

    @Test(dataProvider = "dp")
    public void testAlerts(String name) throws InterruptedException, IOException {

    	driver.get("http://demo.automationtesting.in/Alerts.html");

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
		driver.findElement(By.xpath("//div[@id='Textbox']/button")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		alert.sendKeys(name);
		alert.accept();
		String actOutput = driver.findElement(By.id("demo1")).getText();
		System.out.println("Message displayed: " + actOutput);
                
    }
    
    @DataProvider(name="dp", indices = {0,1,2})
    String[] logindata() {
    	String[] data = {"Sumaya","Prakash","Mohapatra","Shradha","Amreet","Arman"};
    	return data;
    }
    
    @AfterClass
	public void tearDown(){
		if (driver != null) {
			driver.quit();
		}
	}
}
