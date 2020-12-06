Feature: MyAccount-Login Feature
Description: This feature will test a Login feature

#Login with Parameters
	
Scenario Outline: Log-in with valid username and password 
	Given Open the browser
	When Enter the URL "http://www.gmail.com"
	And Click on Login Menu
	And User enters "<username>" and "<password>"
	And Click on login button
	Then User must successfully login to the web page
	
Examples:
    	| username   | password |
    	| admin   | admin1 |
   		| testuser_1 | Test@153 |
   		| testuser_2 | Test@153 |
   		
#Using List
Scenario: Log-in with valid username and password 
	Given Open the browser
	When Enter the URL "http://www.gmail.com"
	And Click on Login Menu
	And User enters Credentials 
    | testuser_1 | Test@153 |
    | testuser_2 | Test@154 |
	And Click on login button
	Then User must successfully login to the web page
	
#using HashMaps	
Scenario: Log-in with valid username and password 
	Given Open the browser
	When Enter the URL "http://www.gmail.com"
	And Click on Login Menu
	And User enters MultiCredentials 
   | username | password |
    | testuser_12 | Test@15412 |
    | testuser_13 | Test@15413 |
	And Click on login button
	Then User must successfully login to the web page
	
#Using Object	
Scenario: Log-in with valid username and password 
	Given Open the browser
	When Enter the URL "http://www.gmail.com"
	And Click on Login Menu
	And User enters different credentials 
   | username | password |
     | testuser_10 | Test@1510 |
   	 | testuser_11 | Test@1511 |
	And Click on login button
	Then User must successfully login to the web page