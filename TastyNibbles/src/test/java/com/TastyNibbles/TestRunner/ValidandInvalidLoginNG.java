package com.TastyNibbles.TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
	@CucumberOptions(features="src\\test\\resources\\com.TastyNibbles.Feature\\LoginValidandInvalid.feature",
	glue= {"com.TastyNibbles.StepDefinition"},
	plugin= {"pretty","html:target/CucumberReport/LoginValid&Invalid.html"},
	monochrome=true)

public class ValidandInvalidLoginNG extends AbstractTestNGCucumberTests {
 

}
