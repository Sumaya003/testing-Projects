
Feature: Home Loan EMI Data Extraction

  Scenario: Extract year-on-year data of Home Loan
    
		Given the user navigates to the Home Loan EMI Calculator
    When the user enters loan amount "<loanAmount>", interest rate "<loanRate>", and tenure "<loanTenure>"
    And the year-on-year amortization table is displayed
    Then the user extracts the data from the table
    And saves the data to an Excel file`
    
    Examples:
    | loanAmount | loanRate | loanTenure |
    | 5000000    | 9.5      |   1       |
    #| 3000000    | 7.9      | 4         |
    #| 1500000    | 9.2      | 3         |


