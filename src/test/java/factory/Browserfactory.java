package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browserfactory {

    public static WebDriver getDriver(
            String browser) {

        WebDriver driver = null;

        if(browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
        }

        else if(browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }

        return driver;
    }
}