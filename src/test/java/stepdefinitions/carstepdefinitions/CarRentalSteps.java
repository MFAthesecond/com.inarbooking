package stepdefinitions.carstepdefinitions;

import org.junit.Test;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;
import utils.Pages;

public class CarRentalSteps extends BaseStep {


    @Test
    public void xxx() {
        PAGES.getHomePage().clickBookingLink();
        BrowserUtils.wait(3);
        PAGES.getCarPages().getCarRentalsHomePage().clickOnCarRentalsElementsInHomePage();
        PAGES.getCarPages().getCarRentalsHomePage().clickOnSearchCarsElements();
        PAGES.getCarPages().getCarConfigs().setCarRentalsDriverAgeByDropBox("45");
        BrowserUtils.scrollDownWithJavaScript(0,600);
        PAGES.getCarPages().getCarConfigs().setThePriceRange("20", "250");
        PAGES.getCarPages().getCarConfigs().setTheCarSpecs("3");
        BrowserUtils.scrollDownWithJavaScript(0,400);
        PAGES.getCarPages().getCarConfigs().setTheTransmission("automatic");
        PAGES.getCarPages().getCarConfigs().setCarCategory("small");
        PAGES.getCarPages().getCarConfigs().setCarCategory("medium");
        PAGES.getCarPages().getCarConfigs().setCarCategory("suv");



    }


}
