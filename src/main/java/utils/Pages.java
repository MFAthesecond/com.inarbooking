package utils;

import lombok.Data;
import pages.InarBookingHomePage;
import pages.carpages.CarPages;

import pages.HomePage;
import pages.flightpages.FlightPages;
import pages.hotelpages.HotelPages;

@Data
public class Pages {

    private HomePage homePage;
    private InarBookingHomePage inarBookingHomePage;
    private FlightPages flightPages;
    private CarPages carPages;
    private HotelPages hotelPages;


    public Pages() {
        homePage = new HomePage();
        inarBookingHomePage = new InarBookingHomePage();
        hotelPages = new HotelPages();
        flightPages = new FlightPages();
        carPages = new CarPages();
    }


}



