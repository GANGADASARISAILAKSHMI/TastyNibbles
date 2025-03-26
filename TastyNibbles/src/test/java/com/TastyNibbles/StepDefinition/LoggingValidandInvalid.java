package com.TastyNibbles.StepDefinition;
import com.TastyNibbles.Pages.Page2;
import com.TastyNibbles.Pages.Page4;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoggingValidandInvalid {
	@When("User enters {string} in the email field")
	public void user_enters_in_the_email_field(String string) {
		Page2.enterEmail(string);
	}
	

	@And("User enters {string} in the password field")
	public void user_enters_in_the_password_field(String string) {
		Page2.enterPassword(string);
	}

	@Then("User verifies the {string} message displayed above the login")
	public void user_verifies_the_message_displayed_above_the_login(String string) {
		Page4.getErrorMessage(string);
		
	}

	@Then("User verifies that My account is displayed after login")
	public void user_verifies_that_my_account_is_displayed_after_login() {
	    Page4.getSuccessMessage();
	}




}
