Feature: Search functionality of TN

@Search
Scenario: User searches for a valid product
Given user opens the Application
When user enters valid product "HP" in search box field
And user clicks on Search button
Then user gets valid product displayed in search results

Scenario: User searches for an invalid product
Given user opens the Application
When user enters invalid product "DELL" in search box field
And user clicks on Search button
Then user gets message of no product match

Scenario: User searches without any product
Given user opens the Application
When user does not enter any product in search box field
And user clicks on Search button
Then user gets message of no product match