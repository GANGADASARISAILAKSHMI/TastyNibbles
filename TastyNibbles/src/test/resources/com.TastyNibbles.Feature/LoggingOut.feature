Feature: User LogOut
 Scenario: Successful Logout and Session Verification
 Given User opens the Browser
 And User navigate to the "https://www.tastynibbles.in/" web page
 When User clicks on Account link
 When User enters the login Credentials
 |TestData.xlsx|
 And User clicks on Sign In button
 And User selects Logout option
 Then User Verify that the session ends and the user is redirected to the homepage.
And User closes the Browser
