package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {
    private static DriverInit driverInstance = null;
    // public static  WebDriver driver;
    /**
     * ThreadLocal<WebDriver> to handle WebDriver instances for each thread independently.
     * ThreadLocal to handle the WebDriver instance in a multi-threaded environment.
     * This is a good approach for parallel testing as it ensures each thread has its own WebDriver instance.
     **/
    public static final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    private DriverInit() {
    }

    public static DriverInit getInstance() {
        if (driverInstance == null) {
            driverInstance = new DriverInit();
        }
        return driverInstance;
    }

    public WebDriver getDriver() {
        return webdriver.get();

    }

    public static WebDriver getCurrentDriver(){

        return getInstance().getDriver();

    }

    public void setDriver(WebDriver driver) {
        webdriver.set(driver);
    }

}
