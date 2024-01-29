package stepdefinitions.carstepdefinitions;

import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.junit.Test;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;
import utils.Pages;

import java.util.LinkedList;
import java.util.List;

public class CarRentalSteps extends BaseStep {


    @Test
    public void xxx() {
        PAGES.getHomePage().clickBookingLink();
        BrowserUtils.wait(3);
        PAGES.getCarPages().getCarRentalsHomePage().clickOnCarRentalsElementsInHomePage();
        PAGES.getCarPages().getCarRentalsHomePage().clickOnSearchCarsElements();
//        PAGES.getCarPages().getCarConfigs().setCarRentalsDriverAgeByDropBox("45");
//        BrowserUtils.scrollDownWithJavaScript(0, 600);
//        PAGES.getCarPages().getCarConfigs().setThePriceRange("20", "250");
//        PAGES.getCarPages().getCarConfigs().setTheCarSpecs("3");
//        BrowserUtils.scrollDownWithJavaScript(0, 400);
//        PAGES.getCarPages().getCarConfigs().setTheTransmission("automatic");
//        PAGES.getCarPages().getCarConfigs().setCarCategory("small");
//        PAGES.getCarPages().getCarConfigs().setCarCategory("medium");
//        PAGES.getCarPages().getCarConfigs().setCarCategory("suv");
        int maxPrice = Integer.parseInt(PAGES.getCarPages().getCarConfigs().getTheSelectedMaxPrice());
        PAGES.getCarPages().getCarConfigs().clickOnSearchButton();
        List<String> carPrices = PAGES.getCarPages().getCarConfigsRight().pricesOfCarsInPage();
        for (String carPrice : carPrices) {
            Assert.assertTrue(maxPrice > Integer.parseInt(carPrice));
        }


    }


}
