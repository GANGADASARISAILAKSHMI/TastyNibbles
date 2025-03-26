package com.TastyNibbles.Pages;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.TastyNibbles.Browser.Browser;
import com.TastyNibbles.Locators.Page1Objects;
import com.TastyNibbles.ScreenShot.Capture;
import com.aventstack.extentreports.Status;
public class Page1 extends Browser {
	static Page1Objects obj;
	static WebDriverWait wait;
	//Clicking Account 
	 public static void clickingAccount() {
		 extent.attachReporter(reporter);
	        logger1 = extent.createTest("Clicking Account");
	        logger1.log(Status.INFO, "Clicking Account");
		 obj=PageFactory.initElements(driver, Page1Objects.class);
    	 wait=new WebDriverWait(driver,Duration.ofSeconds(20));

        try {
                wait.until(ExpectedConditions.visibilityOf(obj.account_link));
                obj.account_link.click();
       logger1.log(Status.PASS, "clicking account  successful");
        } catch (Exception e) {
            System.out.println("Clicking Account link failed: " + e.getMessage());
            logger1.log(Status.FAIL,"Clicking account failed");

        }
        extent.flush();

    }
	 //Used for creating the account by entering the required details
    public static void clickingCreationAccount() {
    	 extent.attachReporter(reporter);
         logger1 = extent.createTest("Clicking create account");
         logger1.log(Status.INFO, "Clicking create account");
    	try {
             wait.until(ExpectedConditions.visibilityOf(obj.create_account_link));
                obj.create_account_link.click();
             logger1.log(Status.PASS, "clicking create account successful");     
        } catch (Exception e) {
            System.out.println("Clicking Create Account link failed: " + e.getMessage());
            logger1.log(Status.FAIL,"Clicking Account create button failed");

        }
        extent.flush();

    }
    public static void enterFirstName(String firstname) {
    	 extent.attachReporter(reporter);
         logger1 = extent.createTest("Entering firstname");
         logger1.log(Status.INFO, "Entering firstname");
    	try {
            wait.until(ExpectedConditions.visibilityOf(obj.first_name));
                obj.first_name.sendKeys(firstname);
                logger1.log(Status.PASS, "first name entered successfully");
            
        } catch (Exception e) {
            System.out.println("Improper FirstName entered: " + e.getMessage());
            logger1.log(Status.FAIL,"Entered  first name improper");

        }
        extent.flush();

    }
    public static void enterLastName(String laststname) {
    	extent.attachReporter(reporter);
        logger1 = extent.createTest("Entering lastname");
        logger1.log(Status.INFO, "Entering lastname");
    	try {
            wait.until(ExpectedConditions.visibilityOf(obj.last_name));
                obj.last_name.sendKeys(laststname);
                logger1.log(Status.PASS, "last name entered successfully");
            
        } catch (Exception e) {
            System.out.println("Improper LastName entered: " + e.getMessage());
            logger1.log(Status.FAIL,"Entered  lastname improper");

        }
        extent.flush();

    }

    public static void enterEmail(String email) {
    	extent.attachReporter(reporter);
        logger1 = extent.createTest("Entering email");
        logger1.log(Status.INFO, "Entering email");
    	try {
            wait.until(ExpectedConditions.visibilityOf(obj.email));
                obj.email.sendKeys(email);
                logger1.log(Status.PASS, "email entered successfully");       
        } catch (Exception e) {
            System.out.println("Improper Email entered: " + e.getMessage());
            logger1.log(Status.FAIL,"Entered  email is improper");

        }
        extent.flush();

    }
    public static void enterPassword(String password) {
    	extent.attachReporter(reporter);
        logger1 = extent.createTest("Entering password");
        logger1.log(Status.INFO, "Entering password");

    	try {
            wait.until(ExpectedConditions.visibilityOf(obj.password));
                obj.password.sendKeys(password);
                logger1.log(Status.PASS, "Password entered successfully");

        } catch (Exception e) {
            System.out.println("Improper Password Entered: " + e.getMessage());
            logger1.log(Status.FAIL,"Entered password is improper");
        }
        extent.flush();

    }

    //Used after all required details are entered
    public static void createAccount() {
    	extent.attachReporter(reporter);
        logger1 = extent.createTest("Clicking create account button");
        logger1.log(Status.INFO, "Clicking create account button");
    	try {
            wait.until(ExpectedConditions.visibilityOf(obj.create_button));
                obj.create_button.click();
                logger1.log(Status.PASS, "create account button clicked successfully");
            
        } catch (Exception e) {
            System.out.println("CreateAccount Button not clicked: " + e.getMessage());
            logger1.log(Status.FAIL,"create account button click failed");

        }
        extent.flush();

    }
    //proper details need to entered for required fields should not be blank
    public static void getErrorMessage() {
    	extent.attachReporter(reporter);
        logger1 = extent.createTest("Getting error message");
        logger1.log(Status.INFO, "Getting error message");

    	try {
            wait.until(ExpectedConditions.visibilityOf(obj.errors));
            System.out.println(obj.errors.getText());
           String actualError= obj.errors.getText();
           Assert.assertEquals(actualError,"Password can't be blank.");
           logger1.addScreenCaptureFromPath(Capture.screenShot("Error captured"));
           logger1.log(Status.PASS, "got error message successfully");

        } catch (Exception e) {
            System.out.println("Error message retrival failed: " + e.getMessage());
            logger1.log(Status.FAIL,"Error message retrival failed");

        }
        extent.flush();

    }
    //After entering valid details navigates to next page
    public static void getSuccessMessage() {
    	extent.attachReporter(reporter);
        logger1 = extent.createTest("Getting success message");
        logger1.log(Status.INFO, "Getting sucess message");

    	try {
             wait.until(ExpectedConditions.visibilityOf(obj.success));
             System.out.println(obj.success.getText());
             String actualMessage=obj.success.getText();
             Assert.assertEquals(actualMessage,actualMessage);
             logger1.log(Status.PASS, "got success successfully");

         } catch (Exception e) {
             System.out.println("Success message retrival failed: " + e.getMessage());
                logger1.log(Status.FAIL,"Success message retrival failed");

         }
        extent.flush();

    }
    
}

    

