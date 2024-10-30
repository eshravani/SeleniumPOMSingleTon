package TestClasses;

import basePackage.BaseClass;
import org.testng.annotations.Test;
import pages.SouthWestAirLinesPage;

public class SouthWestAirLines extends BaseClass {


    @Test
    public void searchFlights() throws InterruptedException {
        SouthWestAirLinesPage sw=new SouthWestAirLinesPage();
        System.out.println("I am on southwest airlines");
        sw.searchFlightsOneWay();

    }
    @Test
    public void searchFlightsRoundTrip() throws InterruptedException {
        SouthWestAirLinesPage sw=new SouthWestAirLinesPage();
        System.out.println("I am on southwest airlines");
        sw.searchFlightsOneWay();
        sw.searchFlightsRoundTrip();

    }
}
