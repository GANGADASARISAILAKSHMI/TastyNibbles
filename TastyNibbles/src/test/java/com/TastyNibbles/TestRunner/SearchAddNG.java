package com.TastyNibbles.TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
	@CucumberOptions(features="src\\test\\resources\\com.TastyNibbles.Feature\\SearchAdd.feature",
	glue= {"com.TastyNibbles.StepDefinition"},
	plugin= {"pretty","html:target/CucumberReport/Search&Add.html"},
	monochrome=true)

public class SearchAddNG extends AbstractTestNGCucumberTests {

}
