package com.TastyNibbles.StepDefinition;

import com.TastyNibbles.Pages.Page2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchScenario {
    @When("User enters {string} in email field")
    public void user_enters_in_email_field(String email) {
        Page2.enterEmail(email);
    }

    @And("User enters {string} in password field")
    public void user_enters_in_password_field(String password) {
        Page2.enterPassword(password);
    }

    @And("User clicks on Sign In button")
    public void user_clicks_on_sign_in_button() {
        Page2.signIn();
    }

    @When("User types in {string} about Productname")
    public void user_types_in_about_productname(String product) {
        Page2.searchItem(product);
    }

    @And("User selects the {string} from the search results page")
    public void user_selects_the_from_the_search_results_page(String product) {
        Page2.selectItem(product);
    }

    @And("User clicks on Add to Cart link")
    public void user_clicks_on_add_to_cart_link() {
        Page2.addToCart();
    }
  
    @And("User clicks the Cart button")

    public void user_clicks_the_cart_button() {
    	Page2.clickCart();
    }

    @Then("User verifies Product is added to the cart successfully")
    public void user_verifies_product_is_added_to_the_cart_successfully() {
        Page2.verifyCart(Page2.selectedProductName);
    }
    @And("User closes the cart")
    public void user_closes_the_cart() {
        Page2.cartClose();

    }
}
