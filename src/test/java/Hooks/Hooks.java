package Hooks;

import org.openqa.selenium.WebDriver;

import Utilities.ConfigReader;
import factory.Browserfactory;
import factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    ConfigReader config =
            new ConfigReader();

    @Before
    public void setup() {

        WebDriver driver =
                Browserfactory.getDriver(
                        config.getBrowser());

        DriverFactory.setDriver(driver);

        DriverFactory.getDriver()
                     .manage()
                     .window()
                     .maximize();

        DriverFactory.getDriver()
                     .get(config.getUrl());

        System.out.println(
                "Browser Launched");
    }

    @After
    public void tearDown() {

        DriverFactory.getDriver()
                     .quit();

        System.out.println(
                "Browser Closed");
    }
}