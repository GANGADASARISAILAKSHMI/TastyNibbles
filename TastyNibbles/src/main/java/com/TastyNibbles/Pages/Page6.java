package com.TastyNibbles.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TastyNibbles.Browser.Browser;
import com.TastyNibbles.Locators.Page6Objects;

public class Page6 extends Browser {
	static Page6Objects obj;
    static WebDriverWait wait;
    public static void clickCart() {
    	obj=PageFactory.initElements(driver, Page6Objects.class);
    	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(obj.cart_button));
            obj.cart_button.click();
        } catch (Exception e) {
            System.out.println("Cart Button: " + e.getMessage());
        }
    }
    public static void checkOut() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(obj.checkout));
            obj.checkout.click();
        } catch (Exception e) {
            System.out.println("Checkout Button: " + e.getMessage());
        }
    }

   
    public static void enterAddress(String userAddress) {
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id=\"shipping-address1-options\"]/li[1]")));
            List<WebElement> addresses = obj.address;
            System.out.println("Number of addresses found: " + addresses.size());

            boolean addressFound = false;
            for (WebElement addressElement : addresses) {
                System.out.println("Checking address: " + addressElement.getText());
                if (addressElement.getText().trim().equalsIgnoreCase(userAddress.trim())) {
                    wait.until(ExpectedConditions.elementToBeClickable(addressElement));
                    addressElement.click();
                    addressFound = true;
                    System.out.println("Selected Address: " + userAddress);
                    break;
                }
            }
            
            if (!addressFound) {
                System.out.println("Address not found in the list: " + userAddress);
                return;
            }

            // Add a wait to ensure autofill happens
            Thread.sleep(3000); // Let the fields populate (adjust if needed)

            // Verify autofill, if fields are empty, enter manually
            if (obj.city.getAttribute("value").isEmpty()) {
                obj.city.sendKeys("Nandyal");
            }

            if (obj.stateDropdown.getAttribute("value").isEmpty()) {
                Select stateSelect = new Select(obj.stateDropdown);
                stateSelect.selectByVisibleText("Andhra Pradesh");
            }

            if (obj.pincode.getAttribute("value").isEmpty()) {
                obj.pincode.sendKeys("518501");
            }

        } catch (Exception e) {
            System.out.println("Error selecting address: " + e.getMessage());
        }
    }



    public static void enterCity(String city) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.city));
            obj.city.sendKeys(city);
        } catch (Exception e) {
            System.out.println("City: " + e.getMessage());
        }
    }
    public static void enterState(String state) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.stateDropdown));
            Select stateSelect = new Select(obj.stateDropdown);
            stateSelect.selectByVisibleText(state);  
        } catch (Exception e) {
            System.out.println("State Selection Error: " + e.getMessage());
        }
    }

    public static void enterPhone(String phone_number) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.phone));
            obj.phone.sendKeys(phone_number);
        } catch (Exception e) {
            System.out.println("Phone Number: " + e.getMessage());
        }
    }
    public static void enterPincode(String pincode) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.pincode));
            obj.pincode.clear(); // Clear field before entering
            obj.pincode.sendKeys(pincode);
            obj.pincode.sendKeys(Keys.TAB); // Ensure focus change
            System.out.println("Entered Pincode: " + pincode);
        } catch (Exception e) {
            System.out.println("Pincode Error: " + e.getMessage());
        }
    }

    public static void radioButton() {
    	try {
            wait.until(ExpectedConditions.visibilityOf(obj.radiobutton));
    		if(obj.radiobutton.isDisplayed()) {
    			if(obj.radiobutton.isEnabled()) {
    				if(obj.radiobutton.isSelected()) {
    					System.out.println("radiobutton Toggled on");
    					
    				}
    				else {
    					obj.radiobutton.click();
    				}
    			}
    		}
    	}
    	catch (Exception e) {
            System.out.println("Radio Button: " + e.getMessage());
        }
    }
   
    public static void payNow() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(obj.paynow));
            obj.paynow.click();
        } catch (Exception e) {
            System.out.println("Pay now Button: " + e.getMessage());
        }
    }
    public static void getErrorMessage(String expectedErrorMessage) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.error));
            String actualErrorMessage = obj.error.getText();  
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"Assertion Failed: Error message does not match. Expected: " + expectedErrorMessage + ", but got: " + actualErrorMessage);
        } catch (Exception e) {
            System.out.println("Error message retrieval failed: " + e.getMessage());
        }
    }
    public static String getSuccessMessage() {
        try {
             wait.until(ExpectedConditions.visibilityOf(obj.success));
             return obj.success.getText();
         } catch (Exception e) {
             return "Success message not found.";
         }
    }

}
