Feature: Actions
Background:
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link
Scenario Outline:Checkout Process with Invalid Data Handling
When User enters '<Email>' in email field
And User enters '<Password>' in password field
And User clicks on Sign In button
When User types in '<Search>' about Productname
And User selects the '<Item>' from the search results page
And User clicks on Add to Cart link
When User slects the cart button
And user clicks the checkout buttton
When User enters '<Address>' in Address field
And User enters invalid '<InvalidPIN Code>' in pincode field
And User clicks paynow button
Then User verifies the '<error>' message
When user re enters the valid '<ValidPIN Code>' in pincode field
And User selects the radio button
And User clicks paynow button
Then User verifies the success message of navigating to further page

Examples:
|Email|Password|Search|Item|Address|InvalidPIN Code|error|ValidPIN Code|
|sailakshmireddy@gmail.com|SaiReddy@2|pickles|Chicken Pickle 200g|Nandyala,AndhraPradesh,India|22|Enter a valid postal code for Andhra Pradesh|518501|


