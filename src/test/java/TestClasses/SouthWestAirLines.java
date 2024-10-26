package TestClasses;

import basePackage.BaseClass;
import org.testng.annotations.Test;
import pages.SouthWestAirLinesPage;

public class SouthWestAirLines extends BaseClass {

    SouthWestAirLinesPage sw=new SouthWestAirLinesPage();

    @Test
    public void searchFlights() throws InterruptedException {
        System.out.println("I am on southwest airlines");
        sw.searchFlightsOneWay();

    }
    @Test
    public void searchFlightsRoundTrip() throws InterruptedException {
        System.out.println("I am on southwest airlines");
        sw.searchFlightsRoundTrip();

    }
}
