Feature: Actions
Background:
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link

Scenario Outline:Adding Multiple Products to Cart & Validating Cart Summary
When User enters '<Email>' in email field
And User enters '<Password>' in password field
And User clicks on Sign In button
When User types in '<Search1>' about Productname
And User selects the '<Item1>' from the search results page
And User clicks on Add to Cart link
When User types in '<Search2>' about Productname
And User selects the '<Item2>' from the search results page
And User clicks on Add to Cart link
Then Verify that the correct products and total price are displayed is '<ExpectedTotal>'.
And User closes the Browser
Examples:
|Email|Password|Search1|Item1|Search2|Item2|ExpectedTotal|
|sailakshmireddy@gmail.com|SaiReddy@2|Fish|Vegetable Fish Curry 200g|Snacks|Fried Masala Prawns 50gm|30000.0|
