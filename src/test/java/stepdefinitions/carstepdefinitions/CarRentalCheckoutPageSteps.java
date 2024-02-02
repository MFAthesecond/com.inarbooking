package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import javax.sql.rowset.BaseRowSet;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalCheckoutPageSteps extends BaseStep {

    @When("Enter Your Name As {string} In Car Rental Checkout Page")
    public void enter_your_name_as_name_ın_car_rental_checkout_page(String name) {
        PAGES.getCarPages().getCarRentalCheckOut().setFirstName(name);
    }

    @When("Enter Your LastName As {string} In Car Rental Checkout Page")
    public void enter_your_last_name_as_last_name_ın_car_rental_checkout_page(String lastName) {
        PAGES.getCarPages().getCarRentalCheckOut().setLastName(lastName);
    }

    @When("Select The Country Code As {string} For Telephone In Car Rental Checkout Page")
    public void select_the_country_code_as_for_telephone_ın_car_rental_checkout_page(String country) {
        PAGES.getCarPages().getCarRentalCheckOut().setOnCountriesPhoneNumber(country);
    }

    @When("Enter Your Phone Number As {string} In Car Rental Checkout Page")
    public void enter_your_phone_number_as_phone_number_ın_car_rental_checkout_page(String phoneNumber) {
        PAGES.getCarPages().getCarRentalCheckOut().setPhoneNumber(phoneNumber);
    }

    @When("Enter Your Country As {string} In Car Rental Checkout Page")
    public void enter_your_country_as_ın_car_rental_checkout_page(String country) {
        PAGES.getCarPages().getCarRentalCheckOut().setCountry(country);
    }

    @When("Enter Your Adress As {string} In Car Rental Checkout Page")
    public void enter_your_adress_as_ın_car_rental_checkout_page(String address) {
        PAGES.getCarPages().getCarRentalCheckOut().setAddress(address);
    }

    @When("Enter Your City As {string} In Car Rental Checkout Page")
    public void enter_your_city_as_city_ın_car_rental_checkout_page(String city) {
        PAGES.getCarPages().getCarRentalCheckOut().setCity(city);
    }

    @When("Enter Your As Postal Code {string} In Car Rental Checkout Page")
    public void enter_your_as_postal_code_ın_car_rental_checkout_page(String postalCode) {
        PAGES.getCarPages().getCarRentalCheckOut().setPostalCode(postalCode);
    }

    @When("Enter Your Card Holder Name As {string} In Car Rental Checkout Page")
    public void enter_your_card_holder_name_as_ın_car_rental_checkout_page(String cardHolderName) {
        PAGES.getCarPages().getCarRentalCheckOut().setCardHoldersName(cardHolderName);
    }

    @When("Enter Your  Card Number As {string} In Car Rental Checkout Page")
    public void enter_your_card_number_as_ın_car_rental_checkout_page(String cardNumber) {
        PAGES.getCarPages().getCarRentalCheckOut().setCardNumber(cardNumber);

    }

    @When("Enter Your Expriration Date As {string} In Car Rental Checkout Page")
    public void enter_your_expriration_date_as_ın_car_rental_checkout_page(String expirationDate) {
        PAGES.getCarPages().getCarRentalCheckOut().setExpiryDate(expirationDate);
    }

    @When("Enter Your CVV As {string} In Car Rental Checkout Page")
    public void enter_your_cvv_as_ın_car_rental_checkout_page(String CVV) {
        PAGES.getCarPages().getCarRentalCheckOut().setCVV(CVV);
    }

    @Then("Verify That Number Of Text Danger Message Is {string}")
    public void verifyThatNumberOfTextDangerMessageIs(String expectedNumberOfDangerMessage) {
        int actualNumberOfDangerMessage = PAGES.getCarPages().getCarRentalCheckOut().getTheNumberOfTextDangerElement();
        then(String.valueOf(actualNumberOfDangerMessage)).isEqualTo(expectedNumberOfDangerMessage);
    }

    @When("Click On Book Now Element In Car Rental Checkout Page")
    public void clickOnBookNowElementInCarRentalCheckoutPage() {
        PAGES.getCarPages().getCarRentalCheckOut().clickOnBookNowElement();
        BrowserUtils.wait(3);

    }

    @When("Click On Consent Of Taking Email Element In Car Rental Checkout Page")
    public void clickOnConsentOfTakingEmailElementInCarRentalCheckoutPage() {
        PAGES.getCarPages().getCarRentalCheckOut().clickOnConsentMarketingEmails();
    }

    @Given("Verify That Name In Confirmation Message Matches With Given Name {string}")
    public void verifyThatNameInConfirmationMessageMatchesWithGivenNameFelix(String expectedName) {
        then(PAGES.getCarPages().getCarRentalCheckOut().getTheNameInConfirmationMessage()).contains(expectedName);
    }

    @Given("Verify That Name Of Car Is As Same As In Insurance Page")
    public void verifyThatNameOfCarIsAsSameAsInInsurancePage() {
        System.out.println("ınsurance page --> " + CarRentalsInsurancePage.nameOfCar);
        then(PAGES.getCarPages().getCarRentalCheckOut().carTypeInConfirmationMessage())
                .contains(CarRentalsInsurancePage.nameOfCar);
    }

    @Then("Verify That Program Passed To CheckOut Page")
    public void verifyThatProgramPassedToCheckOutPage() {
        PAGES.getCarPages().getCarRentalCheckOut().clickOnBookNowElement();
        then(PAGES.getCarPages().getCarRentalCheckOut().getTheNumberOfTextDangerElement()).isGreaterThan(0);
    }
}
