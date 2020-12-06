@Regression
Feature: CCPA Test for field level validation.

  
  Scenario: Performing field level validation to verify the fields value
  META-DATA: {"dataProvider":"BuildData", "dataProviderClass":"stepdefinition.CCPAPageTest"}
  
    Given User provide details for fields 
    When User enters multiple set of values
   Then Validation of the permitted value with result is being printed in excel sheet  "", "", "", "", ""