package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import factory.BaseClass;
import utilities.ExcelUtils;
import utilities.WaitUtils;

public class homeLoan extends BasePage{
	
	Properties p;
	WebDriver driver;
	
	public homeLoan(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//Locators
	
	@FindBy(id="menu-item-2696")
	WebElement menu;
	
	@FindBy(xpath="//*[@id=\"menu-item-3294\"]/a")
	WebElement homeLoanOption;
	
	@FindBy(id="homeprice")
	WebElement loanAmount;
	
	@FindBy(id="homeloaninterest")
	WebElement loanRate;
	
	@FindBy(id="homeloanterm")
	WebElement loanTenure;
	
	
	@FindBy(xpath="//*[@id='paymentschedule']//tr")
	List<WebElement> yearTableRows;
	
	@FindBy(xpath="//*[@id='paymentschedule']//tr[1]")
	WebElement headerRow;
	
	public void selectHomeLoanCalculator() {
		menu.click();
		if(homeLoanOption.isDisplayed()) {
			homeLoanOption.click();
		}
		else {
			System.out.println("Element not found");
		}
	}
	
	public void setHomeLoanAmount(String homeAmount) {
		
//		loanAmount.clear();
//		loanAmount.sendKeys(homeAmount);
		
		WaitUtils.overwriteInput(loanAmount, homeAmount);
	}
	
	public void setHomeRate(String homeRate) {
		
//		loanRate.clear();
//		loanRate.sendKeys(homeRate);
//		js.executeScript("document.getElementById(loanTenure).value = "+homeRate+";");
		
		WaitUtils.overwriteInput(loanRate, homeRate);
	}
	
	public void setHomeTenure(String homeTenure) {
		

		WaitUtils.overwriteInput(loanTenure, homeTenure);
		
//		js.executeScript("document.getElementById(loanTenure).value = "+homeTenure+";");
//
//		loanTenure.sendKeys(homeTenure);
		loanTenure.sendKeys(Keys.TAB);
	}
	
	public WebElement getFirstTableRow() {
		WaitUtils.scrollIntoView(driver, headerRow);
		return headerRow;
		
	}
	
	//read data from table.
	public List<List<String>> extractYearlyTableData(){
		
		List<List<String>> tableData = new ArrayList<>();
		
		for (WebElement row : yearTableRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			
			List<String> rowData = new ArrayList<>();
			
			for(WebElement cell : cells) {
				rowData.add(cell.getText().trim());
			}
			
			if(rowData.isEmpty()) { // Check if no td cells were found, might be a header row with th
                List<WebElement> headerCells = row.findElements(By.tagName("th"));
                for(WebElement cell : headerCells) {
                    rowData.add(cell.getText().trim());
                }
            }
			
			
			if (!rowData.isEmpty() && rowData.stream().anyMatch(s -> !s.isEmpty())) {
				tableData.add(rowData);
			}
			
			
		}
		return tableData;
	}
	
	public boolean saveDataToExcel() throws IOException {
		
		try
		{
			String filePath = BaseClass.p.getProperty("excelPath");
			List<List<String>> data = extractYearlyTableData();
			ExcelUtils.writeDataToExcel(filePath,"YearlyData",data);
			
			return true;
		}
		catch(Exception e) {
			BaseClass.getLogger().error("Error saving data to Excel: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	
	

}
