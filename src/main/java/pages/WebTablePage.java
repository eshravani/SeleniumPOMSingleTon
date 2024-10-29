package pages;

import basePackage.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablePage extends BasePage{

    private WebDriver driver;

    public WebTablePage()
    {
        driver = DriverInit.getCurrentDriver();
        PageFactory.initElements(driver, this);
    }
    public void getProductId()
    {
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
                System.out.println("Product Id is "+productId);
            }

        }
    }

    public void getProductId1()
    {
    WebElement tableBody = driver.findElement(By.xpath("//table[@id='productTable']//tbody"));

    // Using Streams to process table rows
        tableBody.findElements(By.tagName("tr")).stream()
            .filter(row -> {
        String category = row.findElement(By.xpath("td[4]")).getText();
        String productPrice = row.findElement(By.xpath("td[3]")).getText();
        String productId = row.findElement(By.xpath("td[1]")).getText();
        int price = Integer.parseInt(productPrice.replace("$", "").trim());

        // Apply conditions for filtering
        return category.equalsIgnoreCase("Electronics") && price > 500 && productId.startsWith("abc");
    })
            .forEach(row -> {
        // Fetch and print the product ID if the conditions are met
        String productId = row.findElement(By.xpath("td[1]")).getText();
        System.out.println("Product Id is " + productId);
    });
}
}
