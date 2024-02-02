package stepdefinitions.carstepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalCheckoutPageSteps extends BaseStep {

    private static final Logger logger = LogManager.getLogger(CarRentalCheckoutPageSteps.class);

    private void logInfo(String message) {
        logger.info(message);
    }

    private void logDebug(String message) {
        logger.debug(message);
    }

    @When("Enter Your Name As {string} In Car Rental Checkout Page")
    public void enter_your_name_as_name_ın_car_rental_checkout_page(String name) {
        logInfo("Entering name in Car Rental Checkout Page: " + name);
        logDebug("Debug - Entering name in Car Rental Checkout Page: " + name);
        PAGES.getCarPages().getCarRentalCheckOut().setFirstName(name);
    }

    @When("Enter Your LastName As {string} In Car Rental Checkout Page")
    public void enter_your_last_name_as_last_name_ın_car_rental_checkout_page(String lastName) {
        logInfo("Entering last name in Car Rental Checkout Page: " + lastName);
        logDebug("Debug - Entering last name in Car Rental Checkout Page: " + lastName);
        PAGES.getCarPages().getCarRentalCheckOut().setLastName(lastName);
    }

    @When("Select The Country Code As {string} For Telephone In Car Rental Checkout Page")
    public void select_the_country_code_as_for_telephone_ın_car_rental_checkout_page(String country) {
        logInfo("Selecting country code for telephone in Car Rental Checkout Page: " + country);
        logDebug("Debug - Selecting country code for telephone in Car Rental Checkout Page: " + country);
        PAGES.getCarPages().getCarRentalCheckOut().setOnCountriesPhoneNumber(country);
    }

    @When("Enter Your Phone Number As {string} In Car Rental Checkout Page")
    public void enter_your_phone_number_as_phone_number_ın_car_rental_checkout_page(String phoneNumber) {
        logInfo("Entering phone number in Car Rental Checkout Page: " + phoneNumber);
        logDebug("Debug - Entering phone number in Car Rental Checkout Page: " + phoneNumber);
        PAGES.getCarPages().getCarRentalCheckOut().setPhoneNumber(phoneNumber);
    }

    @When("Enter Your Country As {string} In Car Rental Checkout Page")
    public void enter_your_country_as_ın_car_rental_checkout_page(String country) {
        logInfo("Entering country in Car Rental Checkout Page: " + country);
        logDebug("Debug - Entering country in Car Rental Checkout Page: " + country);
        PAGES.getCarPages().getCarRentalCheckOut().setCountry(country);
    }

    @When("Enter Your Adress As {string} In Car Rental Checkout Page")
    public void enter_your_adress_as_ın_car_rental_checkout_page(String address) {
        logInfo("Entering address in Car Rental Checkout Page: " + address);
        logDebug("Debug - Entering address in Car Rental Checkout Page: " + address);
        PAGES.getCarPages().getCarRentalCheckOut().setAddress(address);
    }

    @When("Enter Your City As {string} In Car Rental Checkout Page")
    public void enter_your_city_as_city_ın_car_rental_checkout_page(String city) {
        logInfo("Entering city in Car Rental Checkout Page: " + city);
        logDebug("Debug - Entering city in Car Rental Checkout Page: " + city);
        PAGES.getCarPages().getCarRentalCheckOut().setCity(city);
    }

    @When("Enter Your As Postal Code {string} In Car Rental Checkout Page")
    public void enter_your_as_postal_code_ın_car_rental_checkout_page(String postalCode) {
        logInfo("Entering postal code in Car Rental Checkout Page: " + postalCode);
        logDebug("Debug - Entering postal code in Car Rental Checkout Page: " + postalCode);
        PAGES.getCarPages().getCarRentalCheckOut().setPostalCode(postalCode);
    }

    @When("Enter Your Card Holder Name As {string} In Car Rental Checkout Page")
    public void enter_your_card_holder_name_as_ın_car_rental_checkout_page(String cardHolderName) {
        logInfo("Entering card holder name in Car Rental Checkout Page: " + cardHolderName);
        logDebug("Debug - Entering card holder name in Car Rental Checkout Page: " + cardHolderName);
        PAGES.getCarPages().getCarRentalCheckOut().setCardHoldersName(cardHolderName);
    }

    @When("Enter Your  Card Number As {string} In Car Rental Checkout Page")
    public void enter_your_card_number_as_ın_car_rental_checkout_page(String cardNumber) {
        logInfo("Entering card number in Car Rental Checkout Page: " + cardNumber);
        logDebug("Debug - Entering card number in Car Rental Checkout Page: " + cardNumber);
        PAGES.getCarPages().getCarRentalCheckOut().setCardNumber(cardNumber);
    }

    @When("Enter Your Expriration Date As {string} In Car Rental Checkout Page")
    public void enter_your_expriration_date_as_ın_car_rental_checkout_page(String expirationDate) {
        logInfo("Entering expiration date in Car Rental Checkout Page: " + expirationDate);
        logDebug("Debug - Entering expiration date in Car Rental Checkout Page: " + expirationDate);
        PAGES.getCarPages().getCarRentalCheckOut().setExpiryDate(expirationDate);
    }

    @When("Enter Your CVV As {string} In Car Rental Checkout Page")
    public void enter_your_cvv_as_ın_car_rental_checkout_page(String CVV) {
        logInfo("Entering CVV in Car Rental Checkout Page: " + CVV);
        logDebug("Debug - Entering CVV in Car Rental Checkout Page: " + CVV);
        PAGES.getCarPages().getCarRentalCheckOut().setCVV(CVV);
    }

    @Then("Verify That Number Of Text Danger Message Is {string}")
    public void verifyThatNumberOfTextDangerMessageIs(String expectedNumberOfDangerMessage) {
        int actualNumberOfDangerMessage = PAGES.getCarPages().getCarRentalCheckOut().getTheNumberOfTextDangerElement();
        logInfo("Verifying the number of text danger messages: Expected - " + expectedNumberOfDangerMessage + ", Actual - " + actualNumberOfDangerMessage);
        logDebug("Debug - Verifying the number of text danger messages: Expected - " + expectedNumberOfDangerMessage + ", Actual - " + actualNumberOfDangerMessage);
        then(String.valueOf(actualNumberOfDangerMessage)).isEqualTo(expectedNumberOfDangerMessage);
    }

    @When("Click On Book Now Element In Car Rental Checkout Page")
    public void clickOnBookNowElementInCarRentalCheckoutPage() {
        logInfo("Clicking on Book Now element in Car Rental Checkout Page");
        logDebug("Debug - Clicking on Book Now element in Car Rental Checkout Page");
        PAGES.getCarPages().getCarRentalCheckOut().clickOnBookNowElement();
        BrowserUtils.wait(3);
    }

    @When("Click On Consent Of Taking Email Element In Car Rental Checkout Page")
    public void clickOnConsentOfTakingEmailElementInCarRentalCheckoutPage() {
        logInfo("Clicking on Consent of Taking Email element in Car Rental Checkout Page");
        logDebug("Debug - Clicking on Consent of Taking Email element in Car Rental Checkout Page");
        PAGES.getCarPages().getCarRentalCheckOut().clickOnConsentMarketingEmails();
    }

    @Given("Verify That Name In Confirmation Message Matches With Given Name {string}")
    public void verifyThatNameInConfirmationMessageMatchesWithGivenNameFelix(String expectedName) {
        logInfo("Verifying name in confirmation message: Expected - " + expectedName);
        logDebug("Debug - Verifying name in confirmation message: Expected - " + expectedName);
        then(PAGES.getCarPages().getCarRentalCheckOut().getTheNameInConfirmationMessage()).contains(expectedName);
    }

    @Given("Verify That Name Of Car Is As Same As In Insurance Page")
    public void verifyThatNameOfCarIsAsSameAsInInsurancePage() {
        logInfo("Verifying name of car in Car Rental Checkout Page matches with Insurance Page");
        logDebug("Debug - Verifying name of car in Car Rental Checkout Page matches with Insurance Page");
        System.out.println("ınsurance page --> " + CarRentalsInsurancePage.nameOfCar);
        then(PAGES.getCarPages().getCarRentalCheckOut().carTypeInConfirmationMessage())
                .contains(CarRentalsInsurancePage.nameOfCar);
    }

    @Then("Verify That Program Passed To CheckOut Page")
    public void verifyThatProgramPassedToCheckOutPage() {
        logInfo("Verifying that program passed to CheckOut Page");
        logDebug("Debug - Verifying that program passed to CheckOut Page");
        PAGES.getCarPages().getCarRentalCheckOut().clickOnBookNowElement();
        then(PAGES.getCarPages().getCarRentalCheckOut().getTheNumberOfTextDangerElement()).isGreaterThan(0);
    }

    @Given("Verify That Pick Up Date Matches With Car Rentals Home Page Given Pickup Date")
    public void verifyThatPickUpDateMatchesWithCarRentalsHomePageGivenPickupDate() throws ParseException {
        String date = CarRentalsOnBookingHomePageSteps.pickupDateInCarRentalHomePage;
        String dateInMessage = PAGES.getCarPages().getCarRentalCheckOut().getThePickUpDateInAppearedMessage();
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date inputDate = inputDateFormat.parse(dateInMessage);
        String outputDateString = outputDateFormat.format(inputDate);
        then(date).isEqualTo(outputDateString);
    }
}
