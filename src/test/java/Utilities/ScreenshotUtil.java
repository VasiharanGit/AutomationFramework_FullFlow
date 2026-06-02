package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseClass;
import factory.DriverFactory;

public class ScreenshotUtil extends BaseClass {

    public static String captureScreenshot(String testName) {

        TakesScreenshot ts =
                (TakesScreenshot) DriverFactory.getDriver();

        File source =
                ts.getScreenshotAs(OutputType.FILE);

        String destination =
                "Screenshots/"
                + testName
                + ".png";

        try {

            FileUtils.copyFile(
                    source,
                    new File(destination));

        } catch (IOException e) {

            e.printStackTrace();
        }

        return destination;
    }
}