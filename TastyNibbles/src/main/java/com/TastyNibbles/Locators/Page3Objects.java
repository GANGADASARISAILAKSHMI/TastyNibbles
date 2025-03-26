package com.TastyNibbles.Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.TastyNibbles.Browser.Browser;

public class Page3Objects extends Browser {
	@FindBy(xpath="//a[text()=\"Log out\"]")
	public  WebElement logout;

	   
}