Feature: Login Page feature

Scenario: Login Page Title
Given user is on login page
When user gets the title of the page
Then page title should be "Account Login"

Scenario: Forgot Password Link
Given user is on login page
Then forgot password link should be displayed

Scenario: Login with Correct Credentials
Given user is on login page
When user enters username "samsam@gmail.com"
And user enters password "Automation123"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My Account"