Feature: Display of Car Loan Interest

  Scenario: Successful Display of Loan Interest
    Given the user navigates  home page
    And user select car loan option
    When user enter amount as "1500000" and rate as "9.5" and tenure as "1"
    And the user clicks on EMI in Arrear
    Then user should retrieve Interest and Total Amount Payable
    
    #
  Scenario: Successful Display of Loan Interest
    Given the user navigates to home page
    And user selects car loan option
    When user enters amount as "<loanAmount>" and rate as "<loanRate>" and tenure as "<loanTenure>"
    And the user clicks on EMI in Arrears
    Then user should get Interest and Total Amount Payable
    
    Examples:
    | loanAmount | loanRate | loanTenure |
    | 1500000    | 9.5      |   1       |
    | 3000000    | 7.9      | 15         |
    | 1500000    | 9.2      | 10         |