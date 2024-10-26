package TestClasses;

import basePackage.BaseClass;
import basePackage.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.WebTablePage;

import java.util.List;

public class WebTableHandling extends BaseClass {


    @Test
    public void getProductId()
    {
   /* {
        WebTablePage page = new WebTablePage();

        WebElement tableBody = driver.findElement(By.xpath("//table[@id='productTable']//tbody"));

        List<WebElement> tableRows=tableBody.findElements(By.tagName("tr"));
        for(WebElement row:tableRows)
        {

            String category = row.findElement(By.xpath("td[4]")).getText();
            String productPrice = row.findElement(By.xpath("td[3]")).getText();
            String productId = row.findElement(By.xpath("td[1]")).getText();
            int price = Integer.parseInt(productPrice.replace("$", "").trim());

           if(category.equalsIgnoreCase("Electronics")&&price>500&&productId.startsWith("abc"))
           {
                System.out.println("Product Id is"+productId);
           }

        }*/
    WebTablePage page = new WebTablePage();
   // page.getProductId();
        page.getProductId1();
    }}
