package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsOnBookingHomePageSteps extends BaseStep {

    static String location;
    static String pickupDateInCarRentalHomePage;
    static String dropOffDateInCarRentalPage;
    public static List<String> pickUpDateInDifferentPages = new ArrayList<>();
    public static List<String> dropOffDatesInDifferentPages = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(CarRentalsOnBookingHomePageSteps.class);


    @And("Navigation to the Car Rentals page")
    public void navigationToTheCarRentalsPage() {
        logger.info("Navigating to the Car Rentals page");
        PAGES.getCarPages().getCarRentalsHomePage().clickOnCarRentalsElementsInHomePage();
    }

    @When("Enter Pickup Location As {string}")
    public void enterPickupLocationAsAirportAndChooseTheOption(String pickupLocation) {
        logger.info("Entering pickup location as '{}'", pickupLocation);
        PAGES.getCarPages().getCarRentalsHomePage().setPickupLocationByFullAddress(pickupLocation);
    }

    @And("Click On Pickup Hour And Choose {string}")
    public void clickOnPickupHourAndChoose(String pickupHour) {
        logger.info("Clicking on pickup hour and choosing '{}'", pickupHour);
        PAGES.getCarPages().getCarRentalsHomePage().setThePickupHour(pickupHour);
    }

    @And("Click On Drop Hour And Set The Time as {string}")
    public void clickOnDropHourAndSetTheTimeAs(String dropOffHour) {
        logger.info("Clicking on drop hour and setting the time as '{}'", dropOffHour);
        PAGES.getCarPages().getCarRentalsHomePage().setTheDropOffHour(dropOffHour);
    }

    @When("click On Search Button On The Inar Booking HomePage")
    public void clickOnSearchButtonOnTheInarBookingHomePage() {
        logger.info("Clicking on search button on the Inar Booking HomePage");
        PAGES.getCarPages().getCarRentalsHomePage().clickOnSearchCarsElements();
    }

    @Then("Verify That PickUp Location Inar Booking HomePage Is {string}")
    public void verifyThatPickUpLocationInarBookingHomePageIs(String actualLocation) {
        logger.info("Verifying that pickup location in Inar Booking HomePage is '{}'", actualLocation);
        String expectedPickupLocation = actualLocation;
        actualLocation = PAGES.getCarPages().getCarRentalsHomePage().getThePickUpLocation();
        logger.debug("Actual pickup location: '{}'", actualLocation);
        then(actualLocation).isEqualTo(expectedPickupLocation);
    }

    @And("Verify That Pickup Date On The Inar Booking HomePage Is {string}")
    public void verifyThatPickupDateOnTheInarBookingHomePageIs(String expectedPickupDate) {
        logger.info("Verifying that pickup date on the Inar Booking HomePage is '{}'", expectedPickupDate);
        String actualPickupDate = PAGES.getCarPages().getCarRentalsHomePage().getThePickupHour();
        logger.debug("Actual pickup date: '{}'", actualPickupDate);
        then(actualPickupDate).isEqualTo(expectedPickupDate);
    }

    @And("Verify That DropOff Date On The Inar Booking HomePage Is {string}")
    public void verifyThatDropOffDateOnTheInarBookingHomePageIs(String expectedDropOffDate) {
        logger.info("Verifying that drop-off date on the Inar Booking HomePage is '{}'", expectedDropOffDate);
        String actualDropOffDate = PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate();
        logger.debug("Actual drop-off date: '{}'", actualDropOffDate);
        then(actualDropOffDate).isEqualTo(expectedDropOffDate);
    }

    @When("Get The Order Details As Location Date And Hour")
    public void getTheOrderDetailsAsLocationDateAndHour() {
        logger.info("Getting the order details as location, date, and hour");
        location = PAGES.getCarPages().getCarRentalsHomePage().getThePickUpLocation();
        logger.debug("Location: '{}'", location);
    }

    @When("Get The Pickup Date In Car Rental Home Page")
    public void getThePickupDateInCarRentalHomePage() {
        logger.info("Getting the pickup date in Car Rental Home Page");
        pickupDateInCarRentalHomePage = PAGES.getCarPages().getCarRentalsHomePage().getThePickupDate();
        logger.debug("Pickup date: '{}'", pickupDateInCarRentalHomePage);
    }

    @When("Set The Pick Up Date As {string} In Car Rental Home Page")
    public void setThePickUpDateAsInCarRentalHomePage(String pickUpDate) {
        logger.info("Setting the pick-up date as '{}'", pickUpDate);
        PAGES.getCarPages().getCarRentalsHomePage().enterThePickUpDate(pickUpDate);
    }

    @And("Set The Drop Off Date As {string} In Car Rental Home Page")
    public void setTheDropOffDateAsInCarRentalHomePage(String pickUpDate) {
        logger.info("Setting the drop-off date as '{}'", pickUpDate);
        PAGES.getCarPages().getCarRentalsHomePage().enterTheDropOffDate(pickUpDate);
    }

    @Then("Verify That An Alert Message Appeared In In Car Rental Home Page")
    public void verifyThatAnAlertMessageAppearedInInCarRentalHomePage() {
        logger.info("Verifying that an alert message appeared in In Car Rental Home Page");
        then(PAGES.getCarPages().getCarRentalsHomePage().isAlertMessageAppeared()).isTrue();
    }

    @When("Accept The Alert Message In In Car Rental Home Page")
    public void acceptTheAlertMessageInInCarRentalHomePage() {
        logger.info("Accepting the alert message in In Car Rental Home Page");
        PAGES.getCarPages().getCarRentalsHomePage().acceptTheAlertMessage();
    }

    @And("Verify That Pick Up Date Is {string}")
    public void verifyThatPickUpDateIsPickUpDate(String expectedDate) {
        logger.info("Verifying that pick-up date is '{}'", expectedDate);
        then(PAGES.getCarPages().getCarRentalsHomePage().getThePickupDate()).isEqualTo(expectedDate);
    }

    @And("Verify That Drop Date Is As {string}")
    public void verifyThatDropDateIsAsDropOffDate(String expectedDate) {
        logger.info("Verifying that drop date is as '{}'", expectedDate);
        then(PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate()).isEqualTo(expectedDate);
    }

    @When("Get The Pick Up Date  In Car Rental Home Page")
    public void get_the_pick_up_date_ın_car_rental_home_page() {
        logger.info("Getting the pick-up date in Car Rental Home Page");
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages
                .add(PAGES.getCarPages().getCarRentalsHomePage().getThePickupDate());
    }

    @When("Get The Drop Off Date As  In Car Rental Home Page")
    public void get_the_drop_off_date_as_ın_car_rental_home_page() {
        logger.info("Getting the drop-off date in Car Rental Home Page");
        dropOffDateInCarRentalPage = PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate();
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages
                .add(PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate());
    }
}
