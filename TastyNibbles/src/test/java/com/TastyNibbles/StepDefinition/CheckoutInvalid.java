package com.TastyNibbles.StepDefinition;
import com.TastyNibbles.Pages.Page6;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutInvalid {
	@When("User slects the cart button")
	public void user_slects_the_cart_button() {
	    Page6.clickCart();
	}

	@And("user clicks the checkout buttton")
	public void user_clicks_the_checkout_buttton() {
		Page6.checkOut();
	}

	@When("User enters {string} in Address field")
	public void user_enters_in_address_field(String string) {
		Page6.enterAddress(string);
	}
	@And("User enters invalid {string} in pincode field")
	public void user_enters_invalid_in_pincode_field(String string) {
		Page6.enterPincode(string);
	}
	@And("User selects the radio button")
	public void user_selects_the_radio_button() {
	    Page6.radioButton();
	}

	@And("User clicks paynow button")
	public void user_clicks_paynow_button() {
		Page6.payNow();
	}

	@Then("User verifies the {string} message")
	public void user_verifies_the_message(String string) {
		Page6.getErrorMessage(string);
	}

	@When("user re enters the valid {string} in pincode field")
	public void user_re_enters_the_valid_in_pincode_field(String string) {
		Page6.enterPincode(string);
	}

	@Then("User verifies the success message of navigating to further page")
	public void user_verifies_the_success_message_of_navigating_to_further_page() {
		Page6.getSuccessMessage();
	}




}
