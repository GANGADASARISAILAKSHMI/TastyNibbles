package com.TastyNibbles.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\com.TastyNibbles.Feature\\AddMultipleProductsToCart.feature",
glue= {"com.TastyNibbles.StepDefinition"},
plugin= {"pretty","html:target/CucumberReport/MultipleProductsToCart.html"},
		monochrome=true)
public class MultipleProductsToCartNG extends AbstractTestNGCucumberTests {


}
