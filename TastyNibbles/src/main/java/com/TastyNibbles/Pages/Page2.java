package com.TastyNibbles.Pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.TastyNibbles.Browser.Browser;
import com.TastyNibbles.Locators.Page2Objects;

public class Page2 extends Browser {
    static Page2Objects obj;
    static WebDriverWait wait;
    public static String selectedProductName;
    public static void enterEmail(String email) {
   	obj=PageFactory.initElements(driver, Page2Objects.class);
    	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.login_email));

            obj.login_email.sendKeys(email);
        } catch (Exception e) {
            System.out.println("Email: " + e.getMessage());
        }
    }

    public static void enterPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.login_password));
            obj.login_password.sendKeys(password);
        } catch (Exception e) {
            System.out.println("Password: " + e.getMessage());
        }
    }

    public static void signIn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(obj.Sign_In));
            obj.Sign_In.click();
        } catch (Exception e) {
            System.out.println("Sign In Button: " + e.getMessage());
        }
    }

    public static void searchItem(String item) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.search));
            obj.search.sendKeys(item, Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Search Item: " + e.getMessage());
        }
    }

    public static void selectItem(String item) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(obj.itemInList));
            for (WebElement product : obj.itemInList) {
                if (product.getText().contains(item)) {
                    // Save only the product name
                    String productName = product.getText().split("\n")[0];  // Assuming the name is the first line
                    selectedProductName = productName; 
                    product.click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Select Item: " + e.getMessage());
        }
    }


    public static void addToCart() {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.addToCartButton));
            obj.addToCartButton.click();

        } catch (Exception e) {
            System.out.println("Add to Cart: " + e.getMessage());
        }
    }
    public static void clickCart() {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.cartbutton));
            obj.cartbutton.click();

        } catch (Exception e) {
            System.out.println("Cart button: " + e.getMessage());
        }
    }
    public static void verifyCart(String productName) {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(obj.item_in_cart));
            boolean isFound = false;
            for (WebElement product : obj.item_in_cart) {
                String cartProductText = product.getText().trim();
                System.out.println("Cart Product: " + cartProductText);
                if (cartProductText.contains(productName)) {
                    isFound = true;
                    System.out.println("Found: " + productName);
                    break;
                }
            }
            Assert.assertTrue(isFound, "Product '" + productName + "' not found in the cart.");
        } catch (Exception e) {
            System.out.println("Error in verifying cart: " + e.getMessage());
        }
    }

    public static void cartClose() {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.cart_close));
            obj.cart_close.click();

        } catch (Exception e) {
            System.out.println("Cart close: " + e.getMessage());
        }
    }
}
