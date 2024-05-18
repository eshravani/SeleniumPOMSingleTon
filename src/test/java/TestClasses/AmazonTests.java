package TestClasses;

import basePackage.BaseClass;
import basePackage.DriverInit;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import uitlities.UtilityClass;

import java.io.IOException;

public class AmazonTests extends BaseClass {

    UtilityClass uc = new UtilityClass();

    @Test(priority = 1)
    public void getSecondHighestPriceFromGivenProduct(){
        AmazonHomePage ah = new AmazonHomePage();
        ah.sendProductName("Mobile Phones");
        ah.clickSearchButton();
        System.out.println("search button is clicked");
        System.out.println("second largest price is "+ah.getSecondLargestPrice());
    }

    @Test(priority = 2)
    public void validateDropDownOptions()  {
        AmazonHomePage ah = new AmazonHomePage();
        ah.selectCategory("search-alias=stripbooks");
        uc.takeScreenshot("./phones.png");
    }

    @Test(priority = 3)
    public void findBrokenLinks()
    {
        AmazonHomePage ah = new AmazonHomePage();
        ah.findBrokenLinkOnHomePage();
    }
}
