Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to Login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username									|password		|
|Max.Mustermann@gmail.com	|max12345		|
|motooriarun@gmail.com		|arun12345	|
|Anna.Karanina@gmail.com	|anna12345	|

Scenario: Login with invalid credentials
Given User navigates to Login page
When User enters invalid email address into email field
And User enters invalid password "123456" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to Login page
When User enters valid email address "hans.huckbein@gmail.com" into email field
And User enters invalid password "123456" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to Login page
When User enters invalid email address into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing credentials
Given User navigates to Login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should get a proper warning message about credentials mismatch
