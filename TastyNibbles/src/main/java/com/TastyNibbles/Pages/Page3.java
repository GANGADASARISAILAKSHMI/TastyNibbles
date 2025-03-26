package com.TastyNibbles.Pages;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.TastyNibbles.Browser.Browser;
import com.TastyNibbles.Locators.Page3Objects;
import com.TastyNibbles.ScreenShot.Capture;
import com.aventstack.extentreports.Status;
public class Page3 extends Browser {
    static Page3Objects obj;
    static WebDriverWait wait;
    //Checks the logout is clicked after entering valid details 
    public static void logOut() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Entering credentials ");
		logger1.log(Status.INFO,"Entering crredentials  ");
        obj = PageFactory.initElements(driver, Page3Objects.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
        try {
          
            wait.until(ExpectedConditions.visibilityOf(obj.logout));
            Actions actions = new Actions(driver);
            WebElement logoutButton = obj.logout;
            actions.moveToElement(logoutButton).click().perform();
            logger1.addScreenCaptureFromPath(Capture.screenShot("Login credentials"));
            logger1.log(Status.PASS,"Entered credentials successfully");

        } catch (Exception e) {
            System.out.println("Logout failed: " + e.getMessage());
            logger1.log(Status.FAIL,"Entered  credentials are improper");

        }
        extent.flush();
    }
    //Checks the user redirected to homePage after logout
    public static void verifyUserRedirectedToHomePage() {
    	extent.attachReporter(reporter);
		logger1=extent.createTest("Redirecting to homepage ");
		logger1.log(Status.INFO,"Redirected to homepage ");
        try {
            wait.until(ExpectedConditions.urlToBe("https://www.tastynibbles.in/"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.tastynibbles.in/");
            logger1.log(Status.PASS,"Redirected to homepage successfully");

        } catch (Exception e) {
            System.out.println("Redirection failed: " + e.getMessage());
            logger1.log(Status.FAIL,"Redirection to home page failed");

        }
        extent.flush();
    }
}
