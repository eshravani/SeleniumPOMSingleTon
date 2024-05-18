package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import uitlities.ConfigProperties;
import java.time.Duration;


public class BaseClass {
    private static WebDriver driver=null;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browserName){
        String url =  ConfigProperties.getPropInstance("URL");
        switch (browserName) {
            case "chrome" -> driver = new ChromeDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> System.out.println("please pass correct browser name");
        }
        driver.get(url);
        DriverInit.getInstance().setDriver(driver);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterClass
    public void quitBrowser() {
        driver = DriverInit.getCurrentDriver();
        if(driver!=null) {
            DriverInit.getCurrentDriver().quit();
        }
        DriverInit.webdriver.remove();
    }
}
