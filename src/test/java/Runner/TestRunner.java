package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features =
        "src/test/resources/Features",

        glue = {
                "StepDefinitions",
                "Hooks"
        },

        plugin = {
                "pretty",
                "html:target/CucumberReport.html"
        })
public class TestRunner
        extends AbstractTestNGCucumberTests {

}