package com.TastyNibbles.Locators;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;

import com.TastyNibbles.Browser.Browser;

public class Page1Objects extends Browser {
	@FindBy(xpath="//a[@href=\"/account\"]")
	 public WebElement account_link;
	@FindBy(xpath="//a[text()=\"Create account\"]")
	public WebElement create_account_link;
	@FindBy(name="customer[first_name]")
	public WebElement first_name ;
	@FindBy(id="LastName")
	public WebElement last_name ;
	@FindBy(id="Email")
	public WebElement email;
	@FindBy(id="CreatePassword")
	public WebElement password;
	@FindBy(xpath="//input[@value=\"Create\"]")
	public WebElement create_button;
	@FindBy(xpath="//div[@class=\"errors\"]")
	public WebElement errors;
	@FindBy(xpath="//div[@class=\"hero__sidebyside-content\"]")
	public WebElement success;
//	@FindBy(xpath="//div[@class=\"color-background-1  contains-content-container content-container engt_modal_popup_root \"]")
//	public WebElement popup;
	

}
