package uitlities;
import basePackage.BaseClass;
import basePackage.DriverInit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class UtilityClass extends BaseClass {

    public void takeScreenshot(String pathName){
        try{
        File scrFile = ((TakesScreenshot)DriverInit.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File(pathName));
    }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public void getScreenshotOfElement(WebElement el,String pathName)
    {
        try{
            File scrFile = el.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile,new File(pathName));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void verifyLink(String url){
        try{
            URL linkurl = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)linkurl.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            if(httpURLConnection.getResponseCode()>=400){
                System.out.println(linkurl+"-->"+httpURLConnection.getResponseMessage()+" this is a broken link");

            }
            else{
                System.out.println(linkurl+"-->"+httpURLConnection.getResponseMessage());
            }
        }
        catch(Exception e){
        }
    }
}
