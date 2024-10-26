package pages;

import basePackage.BaseClass;
import basePackage.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import uitlities.UtilityClass;

import java.util.ArrayList;
import java.util.List;

public class BasePage {


    public void selectDropDownByValue(By byLocator, String value)
    {
        Select categoryDropDown = new Select(DriverInit.getInstance().getDriver().findElement(byLocator));
        categoryDropDown.selectByValue(value);
    }

    public void findBrokenLinks(By byLocator)
    {
        List<String> allLinksList = new ArrayList<>();
        for (WebElement el : DriverInit.getCurrentDriver().findElements(byLocator)) {
            if(el.getAttribute("href")!=null){
                allLinksList.add(el.getAttribute("href"));
            }}
        allLinksList.parallelStream().forEach(l-> UtilityClass.verifyLink(l));
    }

    }
