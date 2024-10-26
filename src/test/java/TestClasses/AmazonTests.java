package TestClasses;

import basePackage.BaseClass;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import uitlities.UtilityClass;

public class AmazonTests extends BaseClass {



    //@Test(priority = 1,groups="pricesort")
    @Test
    public void getSecondHighestPriceFromGivenProduct(){
        AmazonHomePage ah = new AmazonHomePage();
        ah.sendProductName("Mobile Phones");
        ah.clickSearchButton();
        System.out.println("search button is clicked");
        System.out.println("second largest price is "+ah.getSecondLargestPrice());
    }

   // @Test(priority = 1)
  // @Test(priority = 2,groups="dropdown")
   @Test
    public void validateDropDownOptions()  {
        AmazonHomePage ah = new AmazonHomePage();
       UtilityClass uc = new UtilityClass();
     //  ah.sendProductName("Mobile Phones");
       //ah.clickSearchButton();
        ah.selectCategory("search-alias=stripbooks");
        uc.takeScreenshot("resources/screenshots/amazonhome.png");
    }

    @Test
    public void findBrokenLinks()
    {
        AmazonHomePage ah = new AmazonHomePage();
        ah.findBrokenLinkOnHomePage();
    }

  /*  @Test(dependsOnMethods={"findBrokenLinks","validateDropDownOptions"},priority=4)
    public void test1()
    {
        System.out.println("depends on methods");
    }
    @Test(description="this test is related to groups",dependsOnGroups={"pricesort","dropdown"},priority=5)
    public void test2()
    {
        System.out.println("depends on groups");
    }*/
}
