	package hooks;
	
	import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
	
	public class Hooks {
	
		private static WebDriver driver;
		private static int scenarioCounter = 0;//static counter for unique screenshot
		Properties p;
		
		@Before
		public void setup() throws IOException {
			driver=BaseClass.initializeBrowser();
			
			p=BaseClass.getProperties();
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
		}
		
		
		@After(order = 1) // Ensuring this runs before browser close (if order 0 closes browser)
	    public void addScreenshotAfterScenario(Scenario scenario) {


			scenarioCounter++; 

	        String screenshotDir = "Screenshots/";
	        File dir = new File(screenshotDir);
	        if (!dir.exists()) {
	            dir.mkdirs(); // Creating directory if it doesn't exist
	        }

	        String screenshotFileName = "scenario" + scenarioCounter + "ss.png";
	        File screenshotFile = new File(screenshotDir + screenshotFileName);

	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);

	            scenario.attach(screenshotBytes, "image/png", scenario.getName());
	            BaseClass.getLogger().info("Attached screenshot to report for scenario: " + scenario.getName());

	            // 2. Save the screenshot to the specified file path (for external access/archiving)
	            FileUtils.writeByteArrayToFile(screenshotFile, screenshotBytes);
	            BaseClass.getLogger().info("Saved screenshot to: " + screenshotFile.getAbsolutePath());

	            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath("../" + screenshotFile.getPath());

	        } catch (IOException e) {
	            BaseClass.getLogger().error("Failed to capture or save screenshot: " + e.getMessage());
	            e.printStackTrace();
	        } catch (ClassCastException e) {
	            BaseClass.getLogger().error("WebDriver does not support TakesScreenshot: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
		
		@After(order=0)
		public void tearDown() {
			driver.quit();
		}
	
	
	}
