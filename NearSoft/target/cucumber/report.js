$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/CCPA.feature");
formatter.feature({
  "line": 2,
  "name": "CCPA Test for field level validation.",
  "description": "",
  "id": "ccpa-test-for-field-level-validation.",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Regression"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Performing field level validation to verify the fields value",
  "description": "META-DATA: {\"dataProvider\":\"BuildData\", \"dataProviderClass\":\"stepdefinition.CCPAPageTest\"}",
  "id": "ccpa-test-for-field-level-validation.;performing-field-level-validation-to-verify-the-fields-value",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User provide details for fields",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User enters multiple set of values",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Validation of the permitted value with result is being printed in excel sheet  \"\", \"\", \"\", \"\", \"\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CCPAPageTest.formenter()"
});
formatter.result({
  "duration": 320049900,
  "status": "passed"
});
formatter.match({
  "location": "CCPAPageTest.entervalues()"
});
formatter.result({
  "duration": 245400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 80
    },
    {
      "val": "",
      "offset": 84
    },
    {
      "val": "",
      "offset": 88
    },
    {
      "val": "",
      "offset": 92
    },
    {
      "val": "",
      "offset": 96
    }
  ],
  "location": "CCPAPageTest.CCPAPageTitleTest(String,String,String,String,String)"
});
formatter.result({
  "duration": 5485162100,
  "status": "passed"
});
