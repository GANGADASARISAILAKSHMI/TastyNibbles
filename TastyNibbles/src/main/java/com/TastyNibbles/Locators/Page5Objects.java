package com.TastyNibbles.Locators;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page5Objects {
	@FindBy(xpath="//div[@class=\"cart__item-sub cart__item-row cart__item--subtotal\"]")
	public WebElement total;
	

}
