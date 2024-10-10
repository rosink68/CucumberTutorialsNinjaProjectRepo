package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
				 glue={"stepdefinations", "hooks"},
			 	 // Report in Cloud veröffentlichen <== normalerweise bekommt man nach Beendigung
				 // des Scripts eine URL <== funktioniert bei mir aber nicht
				 //publish=true, 
				 plugin={"pretty", "html:target/CucumberReports/CucumberReport.html"})
public class TestRunner {
	

}
