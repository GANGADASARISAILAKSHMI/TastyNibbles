package com.TastyNibbles.StepDefinition;
import com.TastyNibbles.Browser.Browser;
import com.TastyNibbles.Pages.Page1;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationScenario {
	@Given("User opens the Browser")
	public void user_opens_the_browser() throws Exception {
		Browser.init("Registration Process");
		Browser.openBrowser();
	
	}

	@And("User navigate to the {string} web page")
	public void user_navigate_to_the_web_page(String string) throws Exception {
		Browser.navigateToUrl(string);
		
	}

	@When("User clicks on Account link")
	public void user_clicks_on_account_link() {
		Page1.clickingAccount();
	}

	@When("user clicks on Create account link")
	public void user_clicks_on_create_account_link() {
	   Page1.clickingCreationAccount(); ;
	}

	@When("User enters {string} in FirstName")
	public void user_enters_in_first_name(String string) {
	    Page1.enterFirstName(string);
	}

	@And("User enters  {string} in LastName")
	public void user_enters_in_last_name(String string) {
	   Page1.enterLastName(string);
	}

	@And("User enters {string} in email")
	public void user_enters_in_email(String string) {
	    Page1.enterEmail(string);;
	}

	@And("User enters  {string} in password")
	public void user_enters_in_password(String string) {
	    Page1.enterPassword(string);
	}

	@And("User clicks on Create button")
	public void user_clicks_on_create_button() {
	   Page1.createAccount();
	}

	@Then("User verifies the error message")
	public void user_verifies_the_error_message() {
	   Page1.getErrorMessage();
	}

	@And("User closes the Browser")
	public void user_closes_the_browser() {
	    Browser.closeBrowser();
	}

	@Then("User verifies  registered successfully")
	public void user_verifies_registered_successfully() {
	    Page1.getSuccessMessage();
	}

}
