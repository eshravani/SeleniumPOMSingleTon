package pages;

import basePackage.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SouthWestAirLinesPage extends BasePage{
    WebDriver driver;

    @FindBy(xpath="")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@value='roundtrip']")
    private WebElement radioButtonRoundTrip;

    @FindBy(xpath="")
    private WebElement fromDestination;

    @FindBy(xpath="")
    private WebElement toDestination;

    @FindBy(xpath="")
    private WebElement nextMonthButton;

    @FindBy(xpath = "//input[@id='returnDate']//following-sibling::div")
    private WebElement returnDateCalender;
    @FindBy(css=".modify-search-button")
    private WebElement modifyBtn;
    public SouthWestAirLinesPage()
    {
        driver = DriverInit.getCurrentDriver();
        PageFactory.initElements(driver,this);
    }

        public void searchFlightsOneWay() throws InterruptedException {
            driver.findElement(By.xpath("//input[@value='oneway']")).click();
            WebElement ele=driver.findElement(By.id("originationAirportCode"));
            JavascriptExecutor js=(JavascriptExecutor)driver;
          //  js.executeScript("arguments[0].value='';",ele);
            Thread.sleep(2000);
           // js.executeScript("arguments[0].value='Dallas';",ele);
            Thread.sleep(2000);
           driver.findElement(By.id("originationAirportCode")).click();
         //   driver.findElement(By.id("originationAirportCode")).clear();
            driver.findElement(By.id("originationAirportCode")).sendKeys("MSY");
            driver.findElement(By.xpath("//span[text()='New Orleans, LA - ']/../..")).click();
           // js.executeScript("arguments[0].value='MSY';",ele);
            pickDepartDate("January", "2025","10");
            Thread.sleep(2000);
            driver.findElement(By.id("destinationAirportCode")).sendKeys("DAL");
            Thread.sleep(2000);
           driver.findElement(By.xpath("//span[text()='Dallas (Love Field), TX - ']/../..")).click();
            boolean isDisabled = !driver.findElement(By.id("returnDate")).isEnabled();

            if (isDisabled) {
                System.out.println("The return date field is disabled.");
            } else {
                System.out.println("The return date field is enabled.");
            }
            driver.findElement(By.xpath("//button[contains(@aria-label,'Search button')]")).click();
            Thread.sleep(2000);
        }

    public void searchFlightsRoundTrip() throws InterruptedException {
        modifyBtn.click();
        Thread.sleep(2000);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.elementToBeClickable(radioButtonRoundTrip));
        driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
        radioButtonRoundTrip.click();
        pickReturnDate("February","2025","20");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(@aria-label,'Search button')]")).click();
        Thread.sleep(2000);

    }

    public void pickDepartDate(String Month,String year,String date)
    {
        driver.findElement(By.xpath("//input[@id='departureDate']/..//div[@class='input--icon-separator']")).click();

        String monthYear=Month+" "+year;
        String date1=Month+" "+date;
        String monthText= driver.findElement(By.xpath("//div[@class='calendar-month--title']")).getText();
        do{
            driver.findElement(By.cssSelector("button[aria-label*='Next Month']")).click();
            monthText=driver.findElement(By.xpath("//div[@class='calendar-month--title']")).getText();
        }
        while(!monthText.equalsIgnoreCase(monthYear));
        driver.findElement(By.xpath("//button[contains(@aria-label,'"+date1+"')]")).click();

    }

    public void pickReturnDate(String month,String year,String date)
    {
        String monthYear=month+" "+year;
        String date1=month+" "+date;
        returnDateCalender.click();
        String monthText= driver.findElement(By.xpath("//div[@class='calendar-month--title']")).getText();
        do{
            driver.findElement(By.cssSelector("button[aria-label*='Next Month']")).click();
            monthText=driver.findElement(By.xpath("//div[@class='calendar-month--title']")).getText();
        }
        while(!monthText.equalsIgnoreCase(monthYear));
        driver.findElement(By.xpath("//button[contains(@aria-label,'"+date1+"')]")).click();
    }

    public void searchForMinimumPrice()
    {
        List<WebElement> priceTable=driver.findElements(By.xpath("(//ul[@id='air-search-results-matrix-0'])[1]//li"));
        for(int i=0;i< priceTable.size();i++)
        {
          String price=  driver.findElement(By.xpath("//ul[@id='air-search-results-matrix-0'])[1]//li//span[@class='swa-g-screen-reader-only']")).getText();
            String[] priceA=price.split(" ");
            int priced=Integer.parseInt(priceA[0]);
        }
    }
}
