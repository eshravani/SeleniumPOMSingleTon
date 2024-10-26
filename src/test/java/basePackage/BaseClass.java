package basePackage;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import uitlities.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseClass {
    private static WebDriver driver;
    private Properties prop;
    FileInputStream fis;


    private void loadProperties() {
        String appName = System.getenv("appName");
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream("resources\\" + appName + ".properties")) {
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("Error loading properties file for " + appName + ": " + e.getMessage());
        }
    }

    @BeforeMethod
    public void setUp() {
       String url= ConfigProperties.getPropInstance("URL");
        // Initialize driver using ThreadLocal instance from DriverInit
        WebDriver driver = DriverInit.getInstance().getDriver();
        // Load application URL from the properties file
        driver.get(url);
        // Set browser configurations
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quitBrowser() {
        DriverInit.getInstance().quitBrowser();
    }
}
