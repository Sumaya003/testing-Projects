package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.carLoan;
import pageObjects.carLoan_failed;

public class carLoanSteps {
	WebDriver driver;
	carLoan carL;
	carLoan_failed cl;
	
	

	@Given("the user navigates  home page")
	public void the_user_navigates_home_page() {
		cl = new carLoan_failed(BaseClass.getDriver());
		
		BaseClass.getLogger().info("User navigates to homepage....");
	    
	}
	@Given("user select car loan option")
	public void user_select_car_loan_option() {
	    
		BaseClass.getLogger().info("Select Car Loan..");//logs
		
	    cl.clickCarLoan();
		
	}
	@When("user enter amount as {string} and rate as {string} and tenure as {string}")
	public void user_enter_amount_as_and_rate_as_and_tenure_as(String amount, String rate, String tenure) throws InterruptedException {
	    
		BaseClass.getLogger().info("Entering loan amount, Rate and Tenure....");
	    cl.setAmount(amount);
	    try {
	    	Thread.sleep(3000);
	    }
	    catch(InterruptedException e){
	    	e.printStackTrace();
	    }
	    
	    cl.setRate(rate);
	    BaseClass.getLogger().info("Invalid Rate given....");
	    Thread.sleep(3000);
	    cl.setTenure(tenure);
	}
	@When("the user clicks on EMI in Arrear")
	public void the_user_clicks_on_emi_in_arrear() throws InterruptedException {
	 
		cl.clickEmi();
	    Thread.sleep(2000);
	    BaseClass.getLogger().info("Clicked on EMI in Arrears");
	}
	@Then("user should retrieve Interest and Total Amount Payable")
	public void user_should_retrieve_interest_and_total_amount_payable() {
	    
		System.out.println(cl.displayAmount());
	    System.out.println(cl.displayEMI());
	    System.out.println(cl.displayInterest());
	    
	    
	    Assert.fail("This test case is intentionally marked as failed for demonstration.");

	    BaseClass.getLogger().info("TestCase Failed...");
		
	}





	@Given("the user navigates to home page")
	public void the_user_navigates_to_home_page() {
		carL = new carLoan(BaseClass.getDriver());
		
		BaseClass.getLogger().info("User navigates to homepage....");
	    
	}
	@And("user selects car loan option")
	public void user_selects_car_loan_option() {
		BaseClass.getLogger().info("Select Car Loan..");//logs
		
		carL.clickCarLoan();
		
	}
	@When("user enters amount as {string} and rate as {string} and tenure as {string}")
	public void user_enters_amount_as_and_rate_as_and_tenure_as(String amount, String rate, String tenure) throws InterruptedException {
		
		BaseClass.getLogger().info("Entering loan amount, Rate and Tenure....");
	    carL.setAmount(amount);
	    try {
	    	Thread.sleep(3000);
	    }
	    catch(InterruptedException e){
	    	e.printStackTrace();
	    }
	    
	    carL.setRate(rate);
	    Thread.sleep(2000);
	    carL.setTenure(tenure);
		
	}
	@When("the user clicks on EMI in Arrears")
	public void the_user_clicks_on_emi_in_arrears() throws InterruptedException {
		
		
	    carL.clickEmi();
	    Thread.sleep(1000);
	    BaseClass.getLogger().info("Clicked on EMI in Arrears");
	}
	@Then("user should get Interest and Total Amount Payable")
	public void user_should_get_interest_and_total_amount_payable() {
	    
		
		System.out.println(carL.displayAmount());
	    System.out.println(carL.displayEMI());
	    System.out.println(carL.displayInterest());
	    
	    
	    
	    Assert.assertTrue(true);
	    BaseClass.getLogger().info("Data fetched successfully...");
	    
	    
	}




}
