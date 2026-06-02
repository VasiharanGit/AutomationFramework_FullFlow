package Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Utilities.ConfigReader;
import factory.Browserfactory;
import factory.DriverFactory;
public class BaseClass {

    //protected WebDriver driver;
	protected Logger logger =
	        LogManager.getLogger(this.getClass());
	public WebDriver getDriver() {

	    return DriverFactory.getDriver();
	}

    ConfigReader config =
            new ConfigReader();

    @BeforeClass
    public void setup() {

    	WebDriver driver =
    	        Browserfactory.getDriver(
    	                config.getBrowser());

    	DriverFactory.setDriver(driver);

    	DriverFactory.getDriver().manage()
              .window()
              .maximize();

    	DriverFactory.getDriver().get(
                config.getUrl());

    	logger.info(
    	        "Browser Launched Successfully");
    }

    @AfterClass
    public void tearDown() {

    	DriverFactory.getDriver().quit();

    	logger.info(
    	        "Browser Closed Successfully");
    }
}