package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import resources.ConfProperties;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static final Logger LOG = Logger.getLogger(DriverFactory.class);
    public static WebDriver driver;

    public static void initDriver(){
        WebDriverManager.chromedriver().setup();
        LOG.info(String.format("Set system property: '%s' , '%s'", ConfProperties.getProperty("CHROME_NAME"), ConfProperties.getProperty("CHROME_DRIVER_LOCATION")));
        driver = new ChromeDriver();
        LOG.info("Driver started");
        driver.manage().window().maximize();
        LOG.info("Driver set maximize");
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            LOG.info("Driver was closed");
            driver = null;
        }
    }
}
