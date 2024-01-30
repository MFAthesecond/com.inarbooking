package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;


import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsConfigPage extends BaseStep {

    @When("Select The Drivers Age as {string}")
    public void selectTheDriversAgeAs(String driversAge) {
        BrowserUtils.scrollDownWithJavaScript(0, 400);
        BrowserUtils.wait(2);
        System.out.println(PAGES.getCarPages().getCarConfigsRight().pricesOfCarsInPage());
        PAGES.getCarPages().getCarConfigs().setCarRentalsDriverAgeByDropBox(driversAge);
    }

    @Then("Verify That Driver Aged Button Clicked {string}")
    public void verifyThatDriverAgedButtonClickedTrue(String isClicked) {
        boolean actual = PAGES.getCarPages().getCarConfigs().isDriverAged30And65CheckBoxSelected();
        then(isClicked).isEqualTo(actual + "");
    }

    @When("Select The Price Range from {string} to {string}")
    public void selectThePriceRangeFromTo(String minPrice, String maxPrice) {
        BrowserUtils.scrollDownWithJavaScript(0, 500);
        PAGES.getCarPages().getCarConfigs().setThePriceRange(minPrice, maxPrice);
    }

//    @And("Select {string}{string}{string}{string} Car Specs")
//    public void selectCarSpecs(String numberOfSpec) {
//        PAGES.getCarPages().getCarConfigs().setTheCarSpecs(numberOfSpec);
//    }

    @And("Select Transmission as {string}")
    public void selectTransmissionAsAutomatic(String transmissionType) {
        BrowserUtils.scrollDownWithJavaScript(0, 600);
        PAGES.getCarPages().getCarConfigs().setTheTransmission(transmissionType);
    }

    @And("Select From Car Category The {string}")
    public void selectFromCarCategoryTheSmall(String carCategoryType) {
        PAGES.getCarPages().getCarConfigs().setCarCategory(carCategoryType);
    }

    @And("Select {string} {string} {string} {string}Car Specs")
    public void selectAutomaticTransmissionCarSpecs(String args1, String arg2, String arg3, String arg4) {
        PAGES.getCarPages().getCarConfigs().setTheCarSpecs(args1, arg2, arg3, arg4);

    }

    @When("Set the Pickup Location On Configpage as {string}")
    public void setThePickupLocationOnConfigpageAsHeathrowAirport(String pickupLocation) {
        PAGES.getCarPages().getCarConfigs().setThePickUpLocationInConfigurationPage(pickupLocation);
    }

    @When("Sort The Cars By Lowest Price")
    public void sort_the_cars_by_lowest_price() {
        PAGES.getCarPages().getCarConfigsRight().sortByPriceLowest();
    }

    @Then("Verify That Cars Sorted By Lowest Price")
    public void verify_that_cars_sorted_by_lowest_price() {
        List<Integer> getThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().pricesOfCarsInPage();
        List<Integer> sortedList = PAGES.getCarPages().getCarConfigsRight().pricesOfCarsInPage();
        Collections.sort(sortedList);
        then(getThePricesOfCar).isEqualTo(sortedList);
    }

    @When("Sort The Cars By Highest Price")
    public void sort_the_cars_by_highest_price() {
        PAGES.getCarPages().getCarConfigsRight().sortPriceHighest();

    }

    @Then("Verify That Cars Sorted By Highest Price")
    public void verify_that_cars_sorted_by_highest_price() {
        List<Integer> getThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().pricesOfCarsInPage();
        Collections.reverse(getThePricesOfCar);
        List<Integer> sortedThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().pricesOfCarsInPage();
        Collections.sort(sortedThePricesOfCar);
        then(getThePricesOfCar).isEqualTo(sortedThePricesOfCar);
    }

    @Then("Verify That There are Small Cars")
    public void verify_that_there_are_small_cars() {


    }

    @Then("Verify That Cars Are Only From {string}")
    public void verify_that_cars_are_only_from(String string) {

    }

    @Then("Verify That All Prices Are Within {string}")
    public void verify_that_all_prices_are_within(String string) {

    }

    @Then("Verify That Transmission Is {string}")
    public void verify_that_transmission_ıs(String string) {
        List<String> transmissionTYpe = PAGES.getCarPages().getCarConfigsRight().getTheTransmission();
        List<String> transmissions = PAGES.getCarPages().getCarConfigs().getTheSelectedTransmission();
        transmissions.remove(string);
        for (String nameOfProduct : transmissionTYpe) {
            then(transmissions.contains(nameOfProduct)).isFalse();
        }

    }


    @Then("Verify That Car Category is Formed By {string}")
    public void verifyThatCarCategoryIsFormedBy(String arg0, String arg1) {


    }
}