package stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homeLoan;
import utilities.WaitUtils;

public class homeLoanSteps {

	WebDriver driver;
	homeLoan hl;
	
//	input is not taken correctly
	
	@Given("the user navigates to the Home Loan EMI Calculator")
	public void the_user_navigates_to_the_home_loan_emi_calculator() {
		
	    hl=new homeLoan(BaseClass.getDriver());
	    
	    hl.selectHomeLoanCalculator();
	    BaseClass.getLogger().info("Select Home loan Calculator....");
		
	}

	@When("the user enters loan amount {string}, interest rate {string}, and tenure {string}")
	public void the_user_enters_loan_amount_interest_rate_and_tenure(String amount, String rate, String tenure) throws InterruptedException {
	    
		BaseClass.getLogger().info("Entering loan amount, rate and tenure....");
		hl.setHomeLoanAmount(amount);
		hl.setHomeRate(rate);
		hl.setHomeTenure(tenure);
		Thread.sleep(2000);
		
		
		
		
	}

	@When("the year-on-year amortization table is displayed")
	public void the_year_on_year_amortization_table_is_displayed() {
	    
		WaitUtils.waitForNonEmptyText(driver, hl.getFirstTableRow(), 10);
		
		
	}

	@Then("the user extracts the data from the table")
	public void the_user_extracts_the_data_from_the_table() {
	    
		BaseClass.getLogger().info("Extracting yearly data from table...");
		hl.extractYearlyTableData();
		
		
	}

	@Then("saves the data to an Excel file`")
	public void saves_the_data_to_an_excel_file() throws IOException {
	    
		BaseClass.getLogger().info("Saving table data to Excel file....");
		
		
		boolean isExcelSaved = hl.saveDataToExcel();
		Assert.assertTrue("Excel file was not saved successfully!", isExcelSaved);
		BaseClass.getLogger().info("Done with Home Loan Feature...");
		
		
	}
	



}
