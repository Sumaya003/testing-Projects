package MiniProjectAlerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class MultiBrowser {
	protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void setup(@Optional("chrome") String browser) {
	    switch (browser.toLowerCase()) {
	        case "chrome":	            
	            driver = new ChromeDriver();
	            break;

	        case "edge":	            
	            driver = new EdgeDriver();
	            break;

	        default:
	            throw new IllegalArgumentException("Browser \"" + browser + "\" not supported.");
	    }

	    driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown(){
		if (driver != null) {
			driver.quit();
		}
	}
}

