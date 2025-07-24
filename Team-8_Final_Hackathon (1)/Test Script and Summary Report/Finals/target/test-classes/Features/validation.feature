Feature: Loan Calculator UI and Functionality Validation

  Background:
    Given the user is on the Home Page
    When the user navigates to the "Loan Calculator" from the Menu

  Scenario: Validate UI elements and scale behavior in EMI Calculator
    Given the user selects "EMI Calculator"
    Then the text boxes for Loan Amount, Interest Rate, and Loan Tenure should be visible
    And the scale sliders for Loan Amount, Interest Rate, and Loan Tenure should be present
    When the user changes the Loan Tenure unit to "Years"
    Then the scale should adjust accordingly to reflect yearly values
    When the user changes the Loan Tenure unit to "Months"
    Then the scale should adjust accordingly to reflect monthly values

  #Scenario: Reuse UI validation for Loan Amount Calculator
    #Given the user selects "Loan Amount Calculator"
    #Then the text boxes and scale sliders should be validated as in EMI Calculator
    #When the user changes the Loan Tenure unit
    #Then the scale should reflect the correct unit and range
    
  #Scenario: Reuse UI validation for Loan Tenure Calculator
    #Given the user selects "Loan Tenure Calculator"
    #Then the text boxes and scale sliders should be validated as in EMI Calculator
    #When the user changes the Loan Tenure unit
    #Then the scale should reflect the correct unit and range
