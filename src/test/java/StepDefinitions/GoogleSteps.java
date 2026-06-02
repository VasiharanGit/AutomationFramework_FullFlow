package StepDefinitions;

import org.testng.Assert;

import Base.BaseClass;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSteps {

    String title;
    String url;
    String pageSource;

    @Given("User launches Google website")
    public void user_launches_google_website() {

    	System.out.println("Google Launched");
    }

    @When("User gets the page title")
    public void user_gets_the_page_title() {

    	title =
    		    DriverFactory
    		        .getDriver()
    		        .getTitle();
    }

    @Then("Title should be {string}")
    public void title_should_be(String expectedTitle) {

        Assert.assertEquals(
                title,
                expectedTitle);
    }

    @When("User gets the current URL")
    public void user_gets_the_current_url() {

        url = DriverFactory.getDriver().getCurrentUrl();
    }

    @Then("URL should contain {string}")
    public void url_should_contain(String expectedUrl) {

        Assert.assertTrue(
                url.contains(expectedUrl));
    }

    @When("User gets the page source")
    public void user_gets_the_page_source() {

        pageSource =
        		DriverFactory.getDriver().getPageSource();
    }

    @Then("Page source should be available")
    public void page_source_should_be_available() {

        Assert.assertNotNull(
                pageSource);
    }
}