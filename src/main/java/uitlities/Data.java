package uitlities;

import org.openqa.selenium.Platform;

public class Data {
   // public static String url = System.getProperty("URL","https://www.amazon.in/");

    public static String url = System.getProperty("URL","https://letzautomate.github.io/samples/eCommerce.html");
   // public static String url = System.getProperty("URL","https://www.southwest.com/air/booking/");
    public static String envType = System.getProperty("envType","local");
    public static String browserName =System.getProperty("browserName","chrome");
    public static Platform platformName = Platform.valueOf("WIN11");
}
