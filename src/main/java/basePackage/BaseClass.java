package basePackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static uitlities.ConfigProperties.getPropValue;


public class BaseClass {
    private static WebDriver driver;
    private static String url;
//    private Properties prop;
  //  FileInputStream fis;


 /*   private void loadProperties() {
        String appName = System.getProperty("appName");
        prop = new Properties();
        try (FileInputStream fis = new FileInputStream("resources\\" + appName + ".properties")) {
            prop.load(fis);
        } catch (IOException e) {
            System.err.println("Error loading properties file for " + appName + ": " + e.getMessage());
        }
    }*/

    @Parameters({"envType","envName","appName","browserName"})
    @BeforeClass
    public void setUpData(String envType,String envName,String appName,String browserName) {
        System.setProperty("envType",envType);
        System.setProperty("envName", envName);
        System.setProperty("appName", appName);
        System.setProperty("browserName", browserName);
        url = getPropValue("URL");
        System.out.println("In before class"+envType+"_"+envName+"_"+appName+"_"+browserName);
    }
       // String url= getPropInstance("URL");
        // Initialize driver using ThreadLocal instance from DriverInit
       @BeforeMethod
       public void setUpDriverConfig(){
           System.out.println("In before mehod"+System.getProperty("envType")+"_"+System.getProperty("envName")+"_"+System.getProperty("appName")+"_"+System.getProperty("browserName"));
           System.out.println("url is in before method"+url);
      //  String browserName=System.getProperty("browserName");
       // DriverInit.getInstance().setDriver(driver);
        WebDriver driver = DriverInit.getInstance().getDriver();
        if (url != null) {
            driver.get(url);
        } else {
            System.err.println("URL not found in the properties file");
        }


        // Load application URL from the properties file
      //  driver.get(url);
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
