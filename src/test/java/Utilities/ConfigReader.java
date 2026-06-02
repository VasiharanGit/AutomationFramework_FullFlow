package Utilities;

// Import FileInputStream to read data from config.properties file
import java.io.FileInputStream;

// Import IOException to handle file reading exceptions
import java.io.IOException;

// Import Properties class to read key-value pairs from properties file
import java.util.Properties;

public class ConfigReader {

    // Properties object reference to store all properties
    Properties prop;

    // Constructor - executes automatically when ConfigReader object is created
    public ConfigReader() {

        // Create Properties object
        prop = new Properties();

        try {

            // Open config.properties file
            FileInputStream fis =
                    new FileInputStream(
                    "src/test/resources/config.properties");

            // Load all key-value pairs into Properties object
            prop.load(fis);

        } catch(IOException e) {

            // Print exception details if file is not found/readable
            e.printStackTrace();
        }
    }

    // Returns browser value from config.properties
    public String getBrowser() {

        // Example:
        // browser=chrome
        return prop.getProperty("browser");
    }

    // Returns URL value from config.properties
    public String getUrl() {

        // Example:
        // url=https://www.google.com
        return prop.getProperty("url");
    }
}