package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // Use Log4j Logger

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

    public static WebDriver driver;
    public static Properties p;
    public static Logger logger = LogManager.getLogger(BaseClass.class); // Correct initialization
    
    public static WebDriver initializeBrowser() throws IOException {
        p = getProperties();
        String browser = p.getProperty("browser").toLowerCase();

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                logger.error("No matching browser found: " + browser);
                driver = null;
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProperties() throws IOException {
        FileReader file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
        p = new Properties();
        p.load(file);
        return p;
    }

    public static Logger getLogger() {
        return logger;
    }
}
