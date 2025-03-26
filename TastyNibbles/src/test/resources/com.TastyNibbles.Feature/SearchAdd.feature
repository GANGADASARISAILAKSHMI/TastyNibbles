Feature: Actions
Scenario Outline: User Login, Product Search, and Adding to Cart
Given User opens the Browser
And User navigate to the "https://www.tastynibbles.in/" web page
When User clicks on Account link
When User enters '<Email>' in email field
And User enters '<Password>' in password field
And User clicks on Sign In button
When User types in '<Search>' about Productname
And User selects the '<Item>' from the search results page
And User clicks on Add to Cart link
And User clicks the Cart button
Then User verifies Product is added to the cart successfully
And User closes the cart
And User closes the Browser
Examples:
|Email|Password|Search|Item|
|sailakshmireddy@gmail.com|SaiReddy@2|pickles|Chicken Pickle 200g|
