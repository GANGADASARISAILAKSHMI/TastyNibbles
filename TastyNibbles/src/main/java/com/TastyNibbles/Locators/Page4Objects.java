package com.TastyNibbles.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.TastyNibbles.Browser.Browser;

public class Page4Objects extends Browser {
	 @FindBy(xpath = "//div[@class=\"errors\"]")  
	    public WebElement errorMessage;
	   @FindBy(xpath="//h1[@class=\"section-header__title\"]")
	   public WebElement success_Message;

}
