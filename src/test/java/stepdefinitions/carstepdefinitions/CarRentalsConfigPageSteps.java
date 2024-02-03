package stepdefinitions.carstepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsConfigPageSteps extends BaseStep {
    static int numberOfDayForRental;
    static String nameOfChosenCar;
    static int priceOfCar;
    static String dateOfDropOff;

    private static final Logger logger = LogManager.getLogger(CarRentalsConfigPageSteps.class);

    @When("Select The Drivers Age as {string}")
    public void selectTheDriversAgeAs(String driversAge) {
        logger.info("Selecting the driver's age as {}", driversAge);
        PAGES.getCarPages().getCarConfigs().setCarRentalsDriverAgeByDropBox(driversAge);
    }

    @Then("Verify That Driver Aged Button Clicked {string}")
    public void verifyThatDriverAgedButtonClickedTrue(String isClicked) {
        logger.info("Verifying that the driver aged button is clicked: {}", isClicked);
        boolean actual = PAGES.getCarPages().getCarConfigs().isDriverAged30And65CheckBoxSelected();
        logger.debug("Actual value: {}", actual);
        then(isClicked).isEqualTo(String.valueOf(actual));
    }

    @When("Select The Price Range from {string} to {string}")
    public void selectThePriceRangeFromTo(String minPrice, String maxPrice) {
        logger.info("Selecting the price range from {} to {}", minPrice, maxPrice);
        BrowserUtils.scrollDownWithJavaScript(0, 500);
        PAGES.getCarPages().getCarConfigs().setThePriceRange(minPrice, maxPrice);
    }

    @And("Select Transmission as {string}")
    public void selectTransmissionAsAutomatic(String transmissionType) {
        logger.info("Selecting transmission as {}", transmissionType);
        PAGES.getCarPages().getCarConfigs().setTheTransmission(transmissionType);
    }

    @And("Select {string} {string} {string} {string}Car Specs")
    public void selectAutomaticTransmissionCarSpecs(String args1, String arg2, String arg3, String arg4) {
        logger.info("Selecting car specs: {}, {}, {}, {}", args1, arg2, arg3, arg4);
        List<String> specs = new ArrayList<>(List.of(new String[]{args1, arg2, arg3, arg4}));
        PAGES.getCarPages().getCarConfigs().setTheCarSpecs(specs);
    }

    @When("Set the Pickup Location On Configpage as {string}")
    public void setThePickupLocationOnConfigpageAsHeathrowAirport(String pickupLocation) {
        logger.info("Setting pickup location on configuration page as {}", pickupLocation);
        PAGES.getCarPages().getCarConfigs().setThePickUpLocationInConfigurationPage(pickupLocation);
    }

    @When("Sort The Cars By Lowest Price")
    public void sort_the_cars_by_lowest_price() {
        logger.info("Sorting cars by lowest price");
        PAGES.getCarPages().getCarConfigsRight().sortByPriceLowest();
    }

    @Then("Verify That Cars Sorted By Lowest Price")
    public void verify_that_cars_sorted_by_lowest_price() {
        logger.info("Verifying that cars are sorted by lowest price");
        List<Integer> getThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        List<Integer> sortedList = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        Collections.sort(sortedList);
        logger.debug("Prices of cars: {}", getThePricesOfCar);
        then(getThePricesOfCar).isEqualTo(sortedList);
    }

    @When("Sort The Cars By Highest Price")
    public void sort_the_cars_by_highest_price() {
        logger.info("Sorting cars by highest price");
        PAGES.getCarPages().getCarConfigsRight().sortPriceHighest();
    }

    @Then("Verify That Cars Sorted By Highest Price")
    public void verify_that_cars_sorted_by_highest_price() {
        logger.info("Verifying that cars are sorted by highest price");
        List<Integer> getThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        Collections.reverse(getThePricesOfCar);
        List<Integer> sortedThePricesOfCar = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        Collections.sort(sortedThePricesOfCar);
        logger.debug("Prices of cars: {}", getThePricesOfCar);
        then(getThePricesOfCar).isEqualTo(sortedThePricesOfCar);
    }

    @Then("Verify That There are Small Cars {string}")
    public void verify_that_there_are_small_cars(String givenCarCatgory) {
        logger.info("Verifying that there are small cars: {}", givenCarCatgory);
        List<String> carCategory = PAGES.getCarPages().getCarConfigsRight().getTheCarCategory();
        for (int i = 0; i < carCategory.size(); i++) {
            logger.debug("Car category: {}", carCategory.get(i));
            then(givenCarCatgory).isEqualTo(carCategory.get(i));
        }
    }

    @Then("Verify That Cars Are Only From {string}")
    public void verify_that_cars_are_only_from(String givenPickupLocation) {
        logger.info("Verifying that cars are only from: {}", givenPickupLocation);
        List<String> pickUpLocations = PAGES.getCarPages().getCarConfigsRight().getThePickupLocation();
        for (int i = 0; i < pickUpLocations.size(); i++) {
            logger.debug("Pickup location: {}", pickUpLocations.get(i));
            then(givenPickupLocation).isEqualTo(pickUpLocations.get(i));
        }
    }

    @Then("Verify That All Prices Are Within Given Range")
    public void verify_that_all_prices_are_within() {
        logger.info("Verifying that all prices are within given range");
        String givenMaxPrice = PAGES.getCarPages().getCarConfigs().getTheSelectedMaxPrice();
        List<Integer> carPrices = PAGES.getCarPages().getCarConfigsRight().getThePricesOfCarsInPage();
        logger.debug("Selected max price: {}", givenMaxPrice);
        logger.debug("Car prices: {}", carPrices);
        then(carPrices.get(0)).isLessThanOrEqualTo(Integer.parseInt(givenMaxPrice));
    }

    @Then("Verify That Transmission Is {string}")
    public void verify_that_transmission_ıs(String string) {
        logger.info("Verifying that transmission is not: {}", string);
        List<String> transmissionType = PAGES.getCarPages().getCarConfigsRight().getTheTransmission();
        List<String> transmissions = PAGES.getCarPages().getCarConfigs().getTheSelectedTransmission();
        transmissions.remove(string);
        for (String nameOfProduct : transmissionType) {
            logger.debug("Transmission type: {}", nameOfProduct);
            then(transmissions.contains(nameOfProduct)).isFalse();
        }
    }

    @Then("Verify That Car Category is Formed By {string}")
    public void verifyThatCarCategoryIsFormedBy(String arg0, String arg1) {
        logger.info("Verifying that car category is formed by: {}, {}", arg0, arg1);
        List<String> givenCarCategory = new ArrayList<>(List.of(new String[]{arg0, arg1}));
        List<String> carCategory = PAGES.getCarPages().getCarConfigsRight().getTheCarCategory();
        for (String nameOfProduct : carCategory) {
            logger.debug("Car category: {}", nameOfProduct);
            then(nameOfProduct).isIn(givenCarCategory);
        }
    }

    @When("Click on search button In Car Rental Config Page")
    public void clickOnSearchButtonInCarRentalConfigPage() {
        logger.info("Clicking on search button in car rental config page");
        PAGES.getCarPages().getCarConfigs().clickOnSearchButtonInConfigPage();
    }

    @And("Click on {string} Car's View Deal Element")
    public void clickOnCarSViewDealElement(String numberOfCar) {
        logger.info("Clicking on {} car's view deal element", numberOfCar);
        PAGES.getCarPages().getCarConfigsRight().clickOnViewDealElement(numberOfCar);
    }

    @When("Select Car Category Via DataTable")
    public void enterPickupLocations(DataTable carSpec) {
        logger.info("Selecting car category via DataTable");
        List<String> carSpecList = carSpec.asList(String.class);
        PAGES.getCarPages().getCarConfigs().setCarCategory(carSpecList);
    }

    @When("Select Car Specs Via DataTable")
    public void selectCarSpecsViaDataTable(DataTable carSpec) {
        logger.info("Selecting car specs via DataTable");
        List<String> carSpecList = carSpec.asList(String.class);
        PAGES.getCarPages().getCarConfigs().setTheCarSpecs(carSpecList);
    }

    @When("Select The Price Range Via DataTable")
    public void selectThePriceRangeViaDataTable(DataTable carSpec) {
        logger.info("Selecting the price range via DataTable");
        List<String> carPriceRangeList = carSpec.asList(String.class);
        PAGES.getCarPages().getCarConfigs().setThePriceRangeViaList(carPriceRangeList);
    }

    @When("Set The Car's Transmission Via DataTable")
    public void setTheCarSTransmissionViaDataTable(DataTable carSpec) {
        logger.info("Setting the car's transmission via DataTable");
        List<String> carTransmissionList = carSpec.asList(String.class);
        PAGES.getCarPages().getCarConfigs().setTheTransmissionViaDataSet(carTransmissionList);
    }

    @Then("Verify That Car Category is Formed By As Given")
    public void verifyThatCarCategoryIsFormedByAsGiven() {
        logger.info("Verifying that car category is formed by as given");
        List<String> selectedCarCategory = PAGES.getCarPages().getCarConfigs().getTheSelectedCarCategory();
        List<String> categoryOfAppearedCar = PAGES.getCarPages().getCarConfigsRight().getTheCarCategory();
        for (int i = 0; i < categoryOfAppearedCar.size(); i++) {
            logger.debug("Selected car category: {}", selectedCarCategory);
            logger.debug("Category of appeared car: {}", categoryOfAppearedCar.get(i));
            then(selectedCarCategory).contains(categoryOfAppearedCar.get(i));
        }
    }

    @When("Get The Price Of #{string} Car's In The Page")
    public void getThePriceOfCarSInThePage(String numberOfCar) {
        logger.info("Getting the price of {} car's in the page", numberOfCar);
        priceOfCar = PAGES.getCarPages().getCarConfigsRight().getTheSelectedCarPrice(numberOfCar);
    }

    @And("Get The Name Of #{string} Car's In Config Page")
    public void getTheNameOfCarSInConfigPage(String numberOfCar) {
        logger.info("Getting the name of {} car's in config page", numberOfCar);
        nameOfChosenCar = PAGES.getCarPages().getCarConfigsRight().getTheSelectedCarName(numberOfCar);
    }

    @And("Get The Number Of Days For Rental In Config Page")
    public void getTheNumberOfDaysForRentalInConfigPage() {
        logger.info("Getting the number of days for rental in config page");
        numberOfDayForRental = PAGES.getCarPages().getCarConfigs().getTheNumberOfDaysInfos();
    }

    @When("Select From Car Category The {string}")
    public void selectFromCarCategoryTheLarge(String givenCarCategory) {
        logger.info("Selecting from car category the {}", givenCarCategory);
        List<String> carCategory = new ArrayList<>();
        carCategory.add(givenCarCategory);
        PAGES.getCarPages().getCarConfigs().setCarCategory(carCategory);
    }

    @Then("Verify That Program Passed To Car Rental Config Page")
    public void verifyThatProgramPassedToCarRentalConfigPage() {
        logger.info("Verifying that program passed to car rental config page");
        String expectedURL = "https://InarAcademy:Fk160621.@test.inar-academy.com/booking/cars";
        logger.debug("Expected URL: {}", expectedURL);
        then(expectedURL).isEqualTo(DRIVER.getCurrentUrl());
    }

    @Then("Verify That Items Are Selected In In Car Rental Config Page")
    public void verifyThatItemsAreSelectedInInCarRentalConfigPage(DataTable carSpec) {
        logger.info("Verifying that items are selected in car rental config page");
        List<String> expectedSelectedConfigs = carSpec.asList(String.class);
        for (String expectedSelectedConfig : expectedSelectedConfigs) {
            logger.debug("Expected selected config: {}", expectedSelectedConfig);
            then(PAGES.getCarPages().getCarConfigs().isSelected(expectedSelectedConfig)).isTrue();
        }
    }

    @Then("Verify That Transmission Is As Given")
    public void verifyThatTransmissionIsAsGiven() {
        logger.info("Verifying that transmission is as given");
        List<String> selectedCarTransmission = PAGES.getCarPages().getCarConfigs().getTheSelectedTransmission();
        List<String> categoryOfAppearedCar = PAGES.getCarPages().getCarConfigsRight().getTheTransmission();
        for (String nameOfProduct : categoryOfAppearedCar) {
            logger.debug("Selected car transmission: {}", selectedCarTransmission);
            logger.debug("Category of appeared car transmission: {}", nameOfProduct);
            then(selectedCarTransmission).contains(nameOfProduct);
        }
    }

    @When("Get The Pick Up Date  In Car Config Page")
    public void get_the_pick_up_date_ın_car_config_page() {
        logger.info("Getting the pick-up date in car config page");
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages.add(PAGES.getCarPages().getCarConfigs().getThePickUpDateInConfigurationPage());
    }

    @When("Get The Drop Off Date As  In Car Congig Page")
    public void get_the_drop_off_date_as_ın_car_congig_page() {
        logger.info("Getting the drop-off date in car config page");
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages.add(PAGES.getCarPages().getCarConfigs().getTheDropOffDateInConfigurationPage());
    }
}