package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @And("Navigation to the Car Rentals page")
    public void navigationToTheCarRentalsPage() {
        PAGES.getCarPages().getCarRentalsHomePage().clickOnCarRentalsElementsInHomePage();
    }

    @When("Enter Pickup Location As {string}")
    public void enterPickupLocationAsAirportAndChooseTheOption(String pickupLocation) {
        PAGES.getCarPages().getCarRentalsHomePage().setPickupLocationByFullAddress(pickupLocation);
    }

    @And("Click On Pickup Hour And Choose {string}")
    public void clickOnPickupHourAndChoose(String pickupHour) {
        PAGES.getCarPages().getCarRentalsHomePage().setThePickupHour(pickupHour);
    }

    @And("Click On Drop Hour And Set The Time as {string}")
    public void clickOnDropHourAndSetTheTimeAs(String dropOffHour) {
        PAGES.getCarPages().getCarRentalsHomePage().setTheDropOffHour(dropOffHour);
    }

    @When("click On Search Button On The Inar Booking HomePage")
    public void clickOnSearchButtonOnTheInarBookingHomePage() {
        PAGES.getCarPages().getCarRentalsHomePage().clickOnSearchCarsElements();
    }

    @Then("Verify That PickUp Location Inar Booking HomePage Is {string}")
    public void verifyThatPickUpLocationInarBookingHomePageIs(String actualLocation) {
        String expectedPickupLocation = actualLocation;
        actualLocation = PAGES.getCarPages().getCarRentalsHomePage().getThePickUpLocation();
        then(actualLocation).isEqualTo(expectedPickupLocation);
    }

    @And("Verify That Pickup Date On The Inar Booking HomePage Is {string}")
    public void verifyThatPickupDateOnTheInarBookingHomePageIs(String expectedPickupDate) {
        String actualPickupDate = PAGES.getCarPages().getCarRentalsHomePage().getThePickupDate();
        then(actualPickupDate).isEqualTo(expectedPickupDate);
    }

    @And("Verify That DropOff Date On The Inar Booking HomePage Is {string}")
    public void verifyThatDropOffDateOnTheInarBookingHomePageIs(String expectedDropOffDate) {
        String actualDropOffDate = PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate();
        then(actualDropOffDate).isEqualTo(expectedDropOffDate);
    }

    @When("Get The Order Details As Location Date And Hour")
    public void getTheOrderDetailsAsLocationDateAndHour() {
        location = PAGES.getCarPages().getCarRentalsHomePage().getThePickUpLocation();
    }

    @When("Get The Pickup Date In Car Rental Home Page")
    public void getThePickupDateInCarRentalHomePage() throws ParseException {
        pickupDateInCarRentalHomePage = PAGES.getCarPages().getCarRentalsHomePage().getThePickupDate();

    }

    @When("Set The Pick Up Date As {string} In Car Rental Home Page")
    public void setThePickUpDateAsInCarRentalHomePage(String pickUpDate) {
        PAGES.getCarPages().getCarRentalsHomePage().enterThePickUpDate(pickUpDate);
    }

    @And("Set The Drop Off Date As {string} In Car Rental Home Page")
    public void setTheDropOffDateAsInCarRentalHomePage(String pickUpDate) {
        PAGES.getCarPages().getCarRentalsHomePage().enterTheDropOffDate(pickUpDate);
        BrowserUtils.wait(10);

    }

    @Then("Verify That An Alert Message Appeared In In Car Rental Home Page")
    public void verifyThatAnAlertMessageAppearedInInCarRentalHomePage() {
        then(PAGES.getCarPages().getCarRentalsHomePage().isAlertMessageAppeared()).isTrue();
    }

    @When("Accept The Alert Message In In Car Rental Home Page")
    public void acceptTheAlertMessageInInCarRentalHomePage() {
        PAGES.getCarPages().getCarRentalsHomePage().acceptTheAlertMessage();
    }

    @And("Verify That Pick Up Date Is {string}")
    public void verifyThatPickUpDateIsPickUpDate(String expectedDate) {
        then(PAGES.getCarPages().getCarRentalsHomePage().getThePickupDate()).isEqualTo(expectedDate);
    }

    @And("Verify That Drop Date Is As {string}")
    public void verifyThatDropDateIsAsDropOffDate(String expectedDate) {
        then(PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate()).isEqualTo(expectedDate);
    }

    @When("Get The Pick Up Date  In Car Rental Home Page")
    public void get_the_pick_up_date_ın_car_rental_home_page() {
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages.add(PAGES.getCarPages().getCarRentalsHomePage().getThePickupDate());
    }

    @When("Get The Drop Off Date As  In Car Rental Home Page")
    public void get_the_drop_off_date_as_ın_car_rental_home_page() {
        dropOffDateInCarRentalPage = PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate();
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages.add(PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate());
    }
}
