package pages;

import basePackage.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class AmazonHomePage extends BasePage {

    private WebDriver driver;
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> priceList;

    @FindBy(id = "searchDropdownBox")
    private WebElement category1;

    @FindBy(xpath = "//img[contains(@src,'img21/Books/mayart24/Children-')]")
    private WebElement book;

    By allLinks = By.tagName("a");
    By category = By.id("searchDropdownBox");


    public AmazonHomePage() {
       driver = DriverInit.getCurrentDriver();
        /*if (this.driver == null) {
            throw new IllegalStateException("Driver is not initialized. Please check the setup.");
        }*/
        PageFactory.initElements(driver, this);
    }

    public void sendProductName(String productName) {
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public int getSecondLargestPrice() {
        Map<WebElement, Integer> hmap = new HashMap<>();
        for (WebElement el : priceList) {
            if (el.getText() != null) {
                hmap.put(el, Integer.parseInt(el.getText().replaceAll(",", "")));
            }
        }
        List<Map.Entry<WebElement, Integer>> list = new ArrayList<>(hmap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list.get(list.size() - 2).getValue();
    }

    public void selectCategory(String value) {
        selectDropDownByValue(category, value);
    }

    public void findBrokenLinkOnHomePage() {
        findBrokenLinks(allLinks);
    }
}
