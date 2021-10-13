package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/functionalTests", glue = { "stepDefinitions" }, plugin = { "pretty",
		"html:target/cucumber-htmlreport", "json:target/cucumber-report.json",
		// "html:cucumber-htmlreport",
		// "json:cucumber-report.json",
		"com.cucumber.listener.ExtentCucumberFormatter:target/ExtendReport.html" }, tags = { "@all" })

public class TestRunner {

}