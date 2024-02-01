package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

public class FlightCheckAndPaySteps extends BaseStep {


    @When("Fill in {string} as the cardholder's name")
    public void fill_in_as_the_cardholder_s_name(String cardHolderName) {
       PAGES.getFlightPages().getFlightCheckAndPayPage().fillCardHolderName(cardHolderName);
    }

    @When("Fill in {string} as the card number")
    public void fill_in_as_the_card_number(String cardNumber) {
        PAGES.getFlightPages().getFlightCheckAndPayPage().fillCardNumber(cardNumber);
    }

    @When("Fill in {string} as the expiration date")
    public void fill_in_as_the_expiration_date(String expirationDate) {
        PAGES.getFlightPages().getFlightCheckAndPayPage().fillExpirationDate(expirationDate);
    }

    @When("Fill in {string} as the cvc code")
    public void fill_in_as_the_cvc_code(String cvcCode) {
        PAGES.getFlightPages().getFlightCheckAndPayPage().fillCvcCode(cvcCode);
    }

    @When("Click on complete booking button")
    public void click_on_complete_booking_button() {
        BrowserUtils.wait(2);

        PAGES.getFlightPages().getFlightCheckAndPayPage().clickOnCompleteBookingButton();
    }


}
