package com.TastyNibbles.Pages;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TastyNibbles.Browser.Browser;
import com.TastyNibbles.Locators.Page4Objects;

public class Page4 extends Browser {
     static Page4Objects obj;
     static WebDriverWait wait;
    //Getting error for invalid password entered during signin
    public static void getErrorMessage(String expectedErrorMessage) {
    	obj=PageFactory.initElements(driver, Page4Objects.class);
    	wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.errorMessage));
            String actualErrorMessage = obj.errorMessage.getText();  
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage,"Assertion Failed: Error message does not match. Expected: " + expectedErrorMessage + ", but got: " + actualErrorMessage);
        } catch (Exception e) {
            System.out.println("Error message retrieval failed: " + e.getMessage());
        }
    }
    //Navigating to the nextPage after successful login credentials entered
    public static void getSuccessMessage() {
        try {
             wait.until(ExpectedConditions.visibilityOf(obj.success_Message));
             System.out.println(obj.success_Message.getText());
             String actualMessage=obj.success_Message.getText();
             Assert.assertEquals(actualMessage, "My account");
         } catch (Exception e) {
             System.out.println("Success message retrival failed: " + e.getMessage());

         }
    }


   
}
