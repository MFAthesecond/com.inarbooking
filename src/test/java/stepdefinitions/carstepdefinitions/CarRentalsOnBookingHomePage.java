package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsOnBookingHomePage extends BaseStep {

    @And("Navigation to the Car Rentals page")
    public void navigationToTheCarRentalsPage() {
        PAGES.getCarPages().getCarRentalsHomePage().clickOnCarRentalsElementsInHomePage();
    }

    @When("Enter Pickup Location As {string}")
    public void enterPickupLocationAsAirportAndChooseTheOption(String pickupLocation) {
        PAGES.getCarPages().getCarRentalsHomePage().setPickupLocationByFullAddress(pickupLocation);
        System.out.println(pickupLocation);
    }

    @And("Click on Pickup Date")
    public void clickOnPickupDate() {
        PAGES.getCarPages().getCarRentalsHomePage().setThePickUpDate();
    }

    @And("Click On Pickup Hour And Choose {string}")
    public void clickOnPickupHourAndChoose(String pickupHour) {
        PAGES.getCarPages().getCarRentalsHomePage().setThePickupHour(pickupHour);
    }

    @And("Click On DropOff Date")
    public void clickOnDropOffDate() {
        PAGES.getCarPages().getCarRentalsHomePage().setTheDropOffDate();
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
    public void verifyThatPickupDateOnTheInarBookingHomePageIs(String actualPickupDate) {
        String expectedPickupDate = "2024-01-30";
        actualPickupDate = PAGES.getCarPages().getCarRentalsHomePage().getThePickupDate();
        then(actualPickupDate).isEqualTo(expectedPickupDate);
    }

    @And("Verify That DropOff Date On The Inar Booking HomePage Is {string}")
    public void verifyThatDropOffDateOnTheInarBookingHomePageIs(String actualDropOffDate) {
        String expectedDropOffDate = "2024-02-02";
        actualDropOffDate = PAGES.getCarPages().getCarRentalsHomePage().getTheDropOffDate();
        then(actualDropOffDate).isEqualTo(expectedDropOffDate);
    }
}
