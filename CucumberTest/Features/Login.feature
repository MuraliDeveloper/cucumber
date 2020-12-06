Feature: MyAccount-Login Feature
Description: This feature will test a Login feature

  #Simple login without parameters
Scenario: Log-in with valid username and password 
	Given Open the browser
	When Enter the URL "http://www.gmail.com"
	And Click on Login Menu
	And Enter registered username and password
	And Click on login button
	Then User must successfully login to the web page
	
Scenario: Log-in with valid username and password 
	Given Open the browser
	When Enter the URL "http://www.gmail.com"
	And Click on Login Menu
	And Enter Invalid username and password
	And Click on login button
	Then User login failed	
	
#Data is getting sent here i.e. Shweta
Scenario: Log-in with valid username and password 
	Given Open the browser
	When Enter the URL "http://www.gmail.com"
	And Click on Login Menu
	And Enter Username as "shweta" and Password as "shweta"
	And Click on login button
	Then User must successfully login to the web page	
	

   		

	


   		
