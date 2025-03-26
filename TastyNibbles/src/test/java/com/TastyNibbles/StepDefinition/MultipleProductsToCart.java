package com.TastyNibbles.StepDefinition;


import com.TastyNibbles.Pages.Page5;

import io.cucumber.java.en.Then;

public class MultipleProductsToCart {
	

	@Then("Verify that the correct products and total price are displayed is {string}.")
	public void verify_that_the_correct_products_and_total_price_are_displayed_is(String string) {
        Page5.verifyTotalPrice(string);

	    
	}


}
