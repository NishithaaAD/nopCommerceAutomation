package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
//		to run all Feature files
//		features = "src/test/resources/Features/",  
		
//		to run single Feature files
        features = "src/test/resources/Features/LoginHybridDrivenMethod.feature",
        
//      to run random or selected  Feature files
//      features = {"src/test/resources/Features/UsingBackgroundKeyWord.feature", 
//        				"src/test/resources/Features/Login.feature", "src/test/resources/Features/Customers.feature\"}
        
//      to run all stepdefinition files        
        glue = "stepDefinitions",
        
        
//        dryRun = true, // keep true as active and false one comment out when you check all the definitions are correct as in feature file
        dryRun = false,
        
        monochrome=true, // will remove the un necessary characters from console window
        
        
//        plugin = { "pretty","html:target/test-output.html" },
        
        		plugin = {
        		        "pretty",
        		        "html:target/cucumber-reports.html",
        		        "html:target/cucumber-reports/index.html",
        		        "json:target/cucumber.json",
        		        "junit:target/cucumber.xml"},
        
        tags= "@sanity"
        		

)


public class TestRun {

}