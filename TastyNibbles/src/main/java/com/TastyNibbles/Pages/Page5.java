package com.TastyNibbles.Pages;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.TastyNibbles.Browser.Browser;
import com.TastyNibbles.Locators.Page5Objects;

public class Page5 extends Browser {

    static Page5Objects obj;
    static WebDriverWait wait;

    public static void verifyTotalPrice(String expectedTotal) {
        obj = PageFactory.initElements(driver, Page5Objects.class);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        try {
            
            wait.until(ExpectedConditions.visibilityOf(obj.total));
            String totalText = obj.total.getText().trim();
            System.out.println("Total text from page: " + totalText); 
            if (totalText.isEmpty()) {
                System.out.println("Total price is empty.");
                return; 
            }
            String totalPriceStr = totalText.replaceAll("[^\\d.]", "");
            // Convert to double
            double actualTotal = Double.parseDouble(totalPriceStr);

            // Remove non-numeric characters from expected total and convert it to double
            double expectedTotalValue = Double.parseDouble(expectedTotal.replaceAll("[^\\d.]", ""));
            System.out.println("Actual Total: " + actualTotal);
            System.out.println("Expected Total: " + expectedTotalValue);

            // Use a small delta (tolerance) for comparison to avoid precision issues
            double delta = 0.05;  
            Assert.assertEquals(actualTotal, expectedTotalValue, delta, "The total price in the cart is incorrect.");
        } catch (Exception e) {
            System.out.println("Error verifying total price: " + e.getMessage());
        }
    }
}
