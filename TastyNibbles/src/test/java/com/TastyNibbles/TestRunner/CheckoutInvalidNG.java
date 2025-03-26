package com.TastyNibbles.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\resources\\com.TastyNibbles.Feature\\CheckoutInvalid.feature",
glue= {"com.TastyNibbles.StepDefinition"},
plugin= {"pretty","html:target/CucumberReport/Logout.html"},
		monochrome=true)


public class CheckoutInvalidNG extends AbstractTestNGCucumberTests {

}
