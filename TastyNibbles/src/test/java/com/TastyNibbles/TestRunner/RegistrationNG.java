package com.TastyNibbles.TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
	@CucumberOptions(features="src\\test\\resources\\com.TastyNibbles.Feature\\Registration.feature",
	glue= {"com.TastyNibbles.StepDefinition"},
	plugin= {"pretty","html:target/CucumberReport/RegistrationValid&Invalid.html"},
	monochrome=true)

	public class RegistrationNG extends AbstractTestNGCucumberTests{


}