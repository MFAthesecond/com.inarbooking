package stepdefinitions.carstepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsConfigPage extends BaseStep {

    @When("Select The Drivers Age as {string}")
    public void selectTheDriversAgeAs(String driversAge) {
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
        //     PAGES.getCarPages().getCarConfigs().setCarCategory(carCategoryType);
    }

    @And("Select {string} {string} {string} {string}Car Specs")
    public void selectAutomaticTransmissionCarSpecs(String args1, String arg2, String arg3, String arg4) {
        List<String> specs = new ArrayList<>(List.of(new String[]{args1, arg2, arg3, arg4}));
        PAGES.getCarPages().getCarConfigs().setTheCarSpecs(specs);

    }

    @When("Set the Pickup Location On Configpage as {string}")
    public void setThePickupLocationOnConfigpageAsHeathrowAirport(String pickupLocation) {
        PAGES.getCarPages().getCarConfigs().setThePickUpLocationInConfigurationPage(pickupLocation);
    }

    @When("Sort The Cars By Lowest Price")
    public void sort_the_cars_by_lowest_price() {
        BrowserUtils.scrollDownWithJavaScript(0, -2000);
        PAGES.getCarPages().getCarConfigsRight().sortByPriceLowest();
    }

    @Then("Verify That Cars Sorted By Lowest Price")
    public void verify_that_cars_sorted_by_lowest_price() {
        List<Integer> getThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        List<Integer> sortedList = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        Collections.sort(sortedList);
        then(getThePricesOfCar).isEqualTo(sortedList);
    }

    @When("Sort The Cars By Highest Price")
    public void sort_the_cars_by_highest_price() {
        PAGES.getCarPages().getCarConfigsRight().sortPriceHighest();

    }

    @Then("Verify That Cars Sorted By Highest Price")
    public void verify_that_cars_sorted_by_highest_price() {
        List<Integer> getThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        Collections.reverse(getThePricesOfCar);
        List<Integer> sortedThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        Collections.sort(sortedThePricesOfCar);
        then(getThePricesOfCar).isEqualTo(sortedThePricesOfCar);
    }

    @Then("Verify That There are Small Cars {string}")
    public void verify_that_there_are_small_cars(String givenCarCatgory) {
        List<String> carCategory = PAGES.getCarPages().getCarConfigsRight().getTheCarCategory();
        for (int i = 0; i < carCategory.size(); i++) {
            then(givenCarCatgory).isEqualTo(carCategory.get(i));

        }

    }

    @Then("Verify That Cars Are Only From {string}")
    public void verify_that_cars_are_only_from(String givenPickupLocation) {
        List<String> pickUpLocations = PAGES.getCarPages().getCarConfigsRight().getThePickupLocation();
        for (int i = 0; i < pickUpLocations.size(); i++) {
            then(givenPickupLocation).isEqualTo(pickUpLocations.get(i));
        }
    }

    @Then("Verify That All Prices Are Within Given Range")
    public void verify_that_all_prices_are_within() {
        String givenMaxPrice = PAGES.getCarPages().getCarConfigs().getTheSelectedMaxPrice();
        List<Integer> carPrices = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        then(carPrices.get(0)).isLessThanOrEqualTo(Integer.parseInt(givenMaxPrice));
    }

    @Then("Verify That Transmission Is As Given")
    public void verify_that_transmission_ıs() {
        List<String> transmissionTYpe = PAGES.getCarPages().getCarConfigsRight().getTheTransmission();
        List<String> selectedTransmissions = PAGES.getCarPages().getCarConfigs().getTheSelectedTransmission();
        for (String nameOfProduct : transmissionTYpe) {
            then(selectedTransmissions.contains(nameOfProduct)).isTrue();
        }

    }


    @Then("Verify That Car Category is Formed By {string}")
    public void verifyThatCarCategoryIsFormedBy(String arg0, String arg1) {
        List<String> givenCarCategory = new ArrayList<>(List.of(new String[]{arg0, arg1}));
        List<String> carCategory = PAGES.getCarPages().getCarConfigsRight().getTheCarCategory();
        for (String nameOfProduct : carCategory) {
            then(nameOfProduct).isIn(givenCarCategory);
        }

    }

    @When("Click on search button In Car Rental Config Page")
    public void clickOnSearchButtonInCarRentalConfigPage() {
        PAGES.getCarPages().getCarConfigs().clickOnSearchButtonInConfigPage();
    }

    @And("Click on {string} Car's View Deal Element")
    public void clickOnCarSViewDealElement(String numberOfCar) {
        PAGES.getCarPages().getCarConfigsRight().clickOnViewDealElement(numberOfCar);
    }

    @When("Select Car Category Via DataTable")
    public void enterPickupLocations(DataTable carSpec) {
        List<String> carSpecList = carSpec.asList(String.class);
        PAGES.getCarPages().getCarConfigs().setCarCategory(carSpecList);
    }

    @When("Select Car Specs Via DataTable")
    public void selectCarSpecsViaDataTable(DataTable carSpec) {
        List<String> carSpecList = carSpec.asList(String.class);
        PAGES.getCarPages().getCarConfigs().setTheCarSpecs(carSpecList);
    }

    @When("Select The Price Range Via DataTable")
    public void selectThePriceRangeViaDataTable(DataTable carSpec) {
        List<String> carPriceRangeList = carSpec.asList(String.class);
        PAGES.getCarPages().getCarConfigs().setThePriceRangeViaList(carPriceRangeList);
    }

    @When("Set The Car's Transmission Via DataTable")
    public void setTheCarSTransmissionViaDataTable(DataTable carSpec) {
        List<String> carTransmissionList = carSpec.asList(String.class);
        PAGES.getCarPages().getCarConfigs().setTheTransmissionViaDataSet(carTransmissionList);
    }

    @Then("Verify That Car Category is Formed By As Given")
    public void verifyThatCarCategoryIsFormedByAsGiven() {
        List<String> selectedCarCategory = PAGES.getCarPages().getCarConfigs().getTheSelectedCarCategory();
        List<String> categoryOfAppearedCar = PAGES.getCarPages().getCarConfigsRight().getTheCarCategory();
        for (int i = 0; i < categoryOfAppearedCar.size(); i++) {
            then(selectedCarCategory).contains(categoryOfAppearedCar.get(i));
        }
    }
    static int numberOfDayForRental;
    static String nameOfChosenCar;
    static int priceOfCar;
    @When("Get The Price Of #{string} Car's In The Page")
    public void getThePriceOfCarSInThePage(String numberOfCar) {
        priceOfCar = PAGES.getCarPages().getCarConfigsRight().getTheSelectedCarPrice(numberOfCar);
    }
    @And("Get The Name Of #{string} Car's In Config Page")
    public void getTheNameOfCarSInConfigPage(String numberOfCar) {
        nameOfChosenCar = PAGES.getCarPages().getCarConfigsRight().getTheSelectedCarName(numberOfCar);

    }

    @And("Get The Number Of Days For Rental In Config Page")
    public void getTheNumberOfDaysForRentalInConfigPage() {
        numberOfDayForRental = PAGES.getCarPages().getCarConfigs().getTheNumberOfDaysInfos();
    }
}