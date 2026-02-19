package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/ipRegistration.feature",
        glue = {"hooks", "stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "junit:target/cucumber-reports/Cucumber.xml"},
        tags = "@testcase7",
        monochrome = true)

public class TestRunner {


}
