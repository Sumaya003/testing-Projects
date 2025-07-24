package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoanCalculatorPage;

public class validationSteps {

	WebDriver driver;
	LoanCalculatorPage lp;

	@Given("the user is on the Home Page")
	public void the_user_is_on_the_home_page() {
	    
		lp = new LoanCalculatorPage(BaseClass.getDriver());
		BaseClass.getLogger().info("User opens Home Page...");
		
		
	}
	
	@When("the user navigates to the {string} from the Menu")
	public void the_user_navigates_to_the_from_the_menu(String calculatorType) {
	    
		
		switch (calculatorType.toLowerCase()) {
		
		case "loan calculator":
			BaseClass.getLogger().info("User Opens Loan Calculator Menu...");
			lp.openLoanCalculatorMenu();
			
		case "emi calculator":
			BaseClass.getLogger().info("User selects EMI Calculator...");
			lp.openEMICalculator();
			
		break;
		case "loan amount calculator":
			BaseClass.getLogger().info("User opens Loan Amount Calculator..");
			lp.openLoanAmountCalculator();
			
		break;
		case "loan tenure calculator":
			BaseClass.getLogger().info("User Opens Loan Tenure Calculator...");
			lp.openLoanTenureCalculator();
		break;
		default:
			BaseClass.getLogger().info("Unknown calculator type...");
			throw new IllegalArgumentException("Unknown calculator type: " + calculatorType);
		}

		
	}
	
	@Given("the user selects {string}")
	public void the_user_selects(String string) {
	    
		
	}
	
	@Then("the text boxes for Loan Amount, Interest Rate, and Loan Tenure should be visible")
	public void the_text_boxes_for_loan_amount_interest_rate_and_loan_tenure_should_be_visible() {
	    
		BaseClass.getLogger().info("Input text boxes are getting validated...");
		boolean loanAmount = lp.validateField("loanamount");
		boolean interestRate = lp.validateField("loaninterest");
		boolean loanTenure = lp.validateField("loanterm");

		assert loanAmount && interestRate && loanTenure : "One or more fields are not visible or enabled.";
		

		
	}
	
	@Then("the scale sliders for Loan Amount, Interest Rate, and Loan Tenure should be present")
	public void the_scale_sliders_for_loan_amount_interest_rate_and_loan_tenure_should_be_present() {
	    

		boolean loanAmount = lp.validateField("loanamount");
		boolean interestRate = lp.validateField("loaninterest");
		boolean loanTenure = lp.validateField("loanterm");

		if (loanAmount && interestRate && loanTenure) {
            BaseClass.getLogger().info("All input text boxes (Loan Amount, Interest Rate, Loan Tenure) are validated successfully.");
        } else {
            // Provide more specific information about which field(s) failed
            StringBuilder failureMessage = new StringBuilder("One or more input text boxes are not validated successfully: ");
            if (!loanAmount) {
                failureMessage.append("Loan Amount (loanamount) is not valid/visible/enabled. ");
            }
            if (!interestRate) {
                failureMessage.append("Interest Rate (loaninterest) is not valid/visible/enabled. ");
            }
            if (!loanTenure) {
                failureMessage.append("Loan Tenure (loanterm) is not valid/visible/enabled. ");
            }
            BaseClass.getLogger().error(failureMessage.toString().trim()); // Use error level for failures
        }
		
		assert loanAmount && interestRate && loanTenure : "One or more sliders are not present.";
		
		

		
	}
	
	@When("the user changes the Loan Tenure unit to {string}")
	public void the_user_changes_the_loan_tenure_unit_to(String unit) {
		
		BaseClass.getLogger().info("Attempting to change Loan Tenure unit to: " + unit);
		
		if (unit.equalsIgnoreCase("Years")) {
			lp.switchTenureToYear();
			
			BaseClass.getLogger().info("Switched Loan Tenure unit to Years.");
		} 
		else if (unit.equalsIgnoreCase("Months")) {
			lp.switchTenureToMonth();
			BaseClass.getLogger().info("Switched Loan Tenure unit to Months.");
		} 
		else {
			BaseClass.getLogger().error("Invalid Loan Tenure unit specified: " + unit + ". Expected 'Years' or 'Months'.");
			throw new IllegalArgumentException("Unknown unit: " + unit);
			}

		
	}
	
	@Then("the scale should adjust accordingly to reflect yearly values")
	public void the_scale_should_adjust_accordingly_to_reflect_yearly_values() {
	    

		BaseClass.getLogger().info("Verifying if the scale adjusts to reflect yearly values.");

		String value = lp.switchTenureToYear(); // Consider renaming this method in your PageObject
        System.out.println("Yearly value: " + value);
        BaseClass.getLogger().info("Retrieved yearly value from UI: " + value);

        if (value != null && !value.isEmpty()) {
            BaseClass.getLogger().info("Yearly scale value is not null or empty as expected. Value: " + value);
        } else {
            BaseClass.getLogger().error("Yearly scale value is null or empty. Assertion will fail.");
        }
        assert value != null && !value.isEmpty() : "Yearly scale value should not be null or empty.";

	}
	
	@Then("the scale should adjust accordingly to reflect monthly values")
	public void the_scale_should_adjust_accordingly_to_reflect_monthly_values() {
	    
		BaseClass.getLogger().info("Verifying if the scale adjusts to reflect monthly values.");


		String value = lp.switchTenureToMonth(); // Consider renaming this method in your PageObject
        System.out.println("Monthly value: " + value);
        BaseClass.getLogger().info("Retrieved monthly value from UI: " + value);

        if (value != null && !value.isEmpty()) {
            BaseClass.getLogger().info("Monthly scale value is not null or empty as expected. Value: " + value);
        } else {
            BaseClass.getLogger().error("Monthly scale value is null or empty. Assertion will fail.");
        }
        assert value != null && !value.isEmpty() : "Monthly scale value should not be null or empty.";
	}


}
