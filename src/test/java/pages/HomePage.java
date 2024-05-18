package pages;

import basePackage.DriverInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage() {
        this.driver = DriverInit.getCurrentDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@title='Search for Products, Brands and More']")
    private WebElement flipKarSearch;
    //input[@placeholder='Search for Products, Brands and More']


    public void clickSearchBox() {

    }
}
