package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;
import factory.DriverFactory;

public class WaitUtil extends BaseClass {

    // Wait until element is visible
    public static void waitForVisibility(
            WebElement element,
            int seconds) {

        WebDriverWait wait =
                new WebDriverWait(
                		DriverFactory.getDriver(),
                        Duration.ofSeconds(seconds));

        wait.until(
                ExpectedConditions
                .visibilityOf(element));
    }

    // Wait until element is clickable
    public static void waitForClickable(
            WebElement element,
            int seconds) {

        WebDriverWait wait =
                new WebDriverWait(
                		DriverFactory.getDriver(),
                        Duration.ofSeconds(seconds));

        wait.until(
                ExpectedConditions
                .elementToBeClickable(element));
    }
}