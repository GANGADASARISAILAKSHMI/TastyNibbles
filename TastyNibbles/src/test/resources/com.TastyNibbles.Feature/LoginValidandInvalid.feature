Feature: User Login
Background:
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link 
Scenario Outline: User Login with Invalid Credentials
When User enters '<Email>' in the email field
And User enters '<Password>' in the password field
And User clicks on Sign In button
Then User verifies the '<error>' message displayed above the login
And User closes the Browser
Examples:
|Email|Password|error|
|sai@gmail.com|Sai|Incorrect email or password.|
Scenario Outline: User Login with valid Credentials
 When User enters '<Email>' in the email field
 And User enters '<Password>' in the password field
 And User clicks on Sign In button
 Then User verifies that My account is displayed after login
 And User closes the Browser
Examples:
|Email|Password|
|anureddy@gmail.com|Anu@3422|
