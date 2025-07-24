package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/Features/carLoan.feature","src/test/resources/Features/homeLoan.feature","src/test/resources/Features/validation.feature"},
    glue = {"stepDefinitions","hooks"},
    		plugin= {
					"pretty", "html:reports/myreport.html",   
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"rerun:target/rerun.txt",
				
				},
    monochrome = true,
    publish = true
    
    
)
public class TestRunner {
}
