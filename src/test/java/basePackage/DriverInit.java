package basePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import uitlities.Data;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverInit {
    private  volatile static DriverInit driverInstance;
    // public static  WebDriver driver;
    /**
     * ThreadLocal<WebDriver> to handle WebDriver instances for each thread independently.
     * ThreadLocal to handle the WebDriver instance in a multi-threaded environment.
     * This is a good approach for parallel testing as it ensures each thread has its own WebDriver instance.
     **/
    private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    public void initDriver()  {
        //String url = ConfigProperties.getPropInstance("URL");
        String url = Data.url;
        String browserName = Data.browserName;
        DesiredCapabilities cap = new DesiredCapabilities();
        switch (Data.envType) {
            case "local" -> {
                switch (browserName) {
                    case "chrome" -> webdriver.set(new ChromeDriver());
                    case "edge" -> webdriver.set(new EdgeDriver());
                    default -> throw new IllegalArgumentException("please pass valid browser name");
                }
            }
            case "remote" -> {
                cap.setPlatform(Data.platformName);
                cap.setBrowserName(Data.browserName);
                switch (browserName) {
                    case "chrome" -> {
                        try {
                            webdriver.set(new RemoteWebDriver(new URL(""), cap));
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case "edge" -> webdriver.set(new EdgeDriver());
                    default -> System.out.println("please pass correct browser name");
                }
            }
            default -> {
                throw new IllegalArgumentException("please pass valid env type");
            }
        }
    }
    private DriverInit() {
    }

    public static DriverInit getInstance() {
        if(driverInstance ==null)
        {
            synchronized(DriverInit.class){
            if(driverInstance ==null)
            {
                driverInstance = new DriverInit();

            }
            }
        }
        if(webdriver.get()==null)
        {
            driverInstance.initDriver();
        }
        return driverInstance;
    }

    public WebDriver getDriver() {
        return webdriver.get();

    }

    public static WebDriver getCurrentDriver()  {

        return getInstance().getDriver();

    }

    public void setDriver(WebDriver driver) {
        webdriver.set(driver);
    }
    public void quitBrowser()
    {
        if(getDriver()!=null)
        {
            getDriver().quit();
            webdriver.remove();
        }
    }

}
