package com.TastyNibbles.Locators;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class Page6Objects {
	@FindBy(id="HeaderCartTrigger")
	public WebElement cart_button;
	@FindBy(name="checkout")
	public WebElement checkout;
	@FindAll(@FindBy(xpath="//ul[@id=\"shipping-address1-options\"]/li[1]"))
	public List <WebElement> address;
	@FindBy(id="TextField29")
	public WebElement city;
	@FindBy(xpath="//label[@for=\"Select9\"]")
	public WebElement stateDropdown;
	@FindBy(id="TextField30")
	public WebElement pincode;
	@FindBy(id="TextField31")
	public WebElement phone;
	@FindBy(name="countryCode")
	public WebElement country;
	@FindBy(xpath="//p[@id=\"error-for-TextField4\"]")
	public WebElement error;
	@FindBy(id="checkout-pay-button")
	public WebElement paynow;
	@FindBy(xpath="//div[@class=\"flex grow justify-end gap-2 py-2\"]")
	public WebElement success;
	@FindBy(xpath="//button[@data-testid=\"confirm-positive\"]")
	public WebElement exit_page;
	@FindBy(xpath="//label[text()=\"Same as shipping address\"]")
	public WebElement radiobutton;

}
