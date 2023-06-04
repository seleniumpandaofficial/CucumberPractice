Feature: Login Functionality of TN

Scenario: Login with valid credentials
Given user navigates to login page
When user enters valid email address "seleniumpanda@gmail.com" into email field
And user enters valid password "Selenium@123" into password field
And user clicks on Login button
Then user gets successfully logged in

Scenario: Login with invalid credentials
Given user navigates to login page
When user enters invalid email address into email field
And user enters invalid password "Selenium@123456" into password field
And user clicks on Login button
Then user gets a warning message

Scenario: Login with valid email address and invalid password
Given user navigates to login page
When user enters valid email address "seleniumpanda@gmail.com" into email field
And user enters invalid password "Selenium@123456" into password field
And user clicks on Login button
Then user gets a warning message

Scenario: Login with invalid email address and valid password
Given user navigates to login page
When user enters invalid email address into email field
And user enters valid password "Selenium@123" into password field
And user clicks on Login button
Then user gets a warning message

Scenario: Login without email addess and password
Given user navigates to login page
When user keeps email address field blank
And user keeps password field blank
And user clicks on Login button
Then user gets a warning message
