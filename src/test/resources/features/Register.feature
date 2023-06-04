Feature: Registration Functionality of TN

Scenario: User creates an account only with mandatory fields
Given user navigates to Register Account page
When user enters the details into below fields
|firstname| Selenium|
|lastname|Panda|

|telephone|9876543210|
|password|Selenium@123|
|confirmpassword|Selenium@123|
And user selects privacy policy checkbox
And user clicks on continue button
Then user account gets created successfully

Scenario: User creates an account only with all fields
Given user navigates to Register Account page
When user enters the details into below fields
|firstname| Selenium|
|lastname|Panda|

|telephone|9876543210|
|password|Selenium@123|
|confirmpassword|Selenium@123|
And user selects Yes for Newsletter
And user selects privacy policy checkbox
And user clicks on continue button
Then user account gets created successfully

Scenario: User creates a duplicate account 
Given user navigates to Register Account page
When user enters the details into below fields with duplicate email
|firstname| Selenium|
|lastname|Panda|
|emailid|seleniumpanda@gmail.com|
|telephone|9876543210|
|password|Selenium@123|
|confirmpassword|Selenium@123|
And user selects Yes for Newsletter
And user selects privacy policy checkbox
And user clicks on continue button
Then user gets warning message

Scenario: User creates an account without filling any details
Given user navigates to Register Account page
When user does not enter any field
And user clicks on continue button
Then user gets warning message for every mandatory field