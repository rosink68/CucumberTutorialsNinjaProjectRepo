Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|Emma										|
|lastName		|Emily									|
|telephone	|12345567890						|
|password		|12345									|
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|Emma										|
|lastName		|Emily									|
|telephone	|12345567890						|
|password		|12345									|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

Scenario: User creates a duplicate account 
Given User navigates to Register Account page
When User enters the details into below fields with a duplicate email
|firstName	|Emma										|
|lastName		|Emily									|
|email			|hans.huckbein@gmail.com|
|telephone	|12345567890						|
|password		|12345									|
And User selects Privacy Policy
And User clicks on Continue button
Then User should get a proper warning message about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields
And User clicks on Continue button
Then User should get a proper warning messages for every mandatory field

