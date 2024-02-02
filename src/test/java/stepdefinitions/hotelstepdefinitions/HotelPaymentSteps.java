package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HotelPaymentSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(HotelPaymentSteps.class);

    @Given("Navigation to the hotel yours details URL")
    public void navigation_to_the_hotel_yours_details_url() {
        PAGES.getHotelPages().getHotelsYourDetailsPage();
    }

    @When("Click on the booking for someone else for checkbox")
    public void click_on_the_booking_for_someone_else_for_checkbox() {
        PAGES.getHotelPages().getHotelDetailsPage().clickBookingCheckbox();
    }

    @And("Select {string} for country code dropdown and fill in {string} as phone number")
    public void select_for_country_code_dropdown_and_fill_in_as_phone_number(String countryCode, String phoneNumber) {
        PAGES.getHotelPages().getHotelsYourDetailsPage().selectCountryCodeDropDown(countryCode);
        PAGES.getHotelPages().getHotelsYourDetailsPage().fillPhoneNumber(phoneNumber);
    }

    @When("Click yes checkbox for free paper approval")
    public void click_yes_checkbox_for_free_paper_approval() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().clickOnFreePaperCheckbox();
    }

    @When("Click the yes checkbox to save the details")
    public void click_the_yes_checkbox_to_save_the_details() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().clickOnDetailsCheckbox();
    }

    @When("Write the Card Holder's Name as {string}")
    public void write_the_card_holder_s_name_as(String cardName) {
        PAGES.getHotelPages().getHotelsFinalStep().fillCardHolderName("Furkan Altun");
    }

    @When("Enter card number as {string}")
    public void enter_card_number_as(String cardNumber) {
        PAGES.getHotelPages().getHotelsFinalStep().fillCardNumber("7772228887779994");
    }

    @When("Enter expiration date as {string}")
    public void enter_expiration_date_as(String date) {
        PAGES.getHotelPages().getHotelsFinalStep().fillExpirationDate("1222");

    }

    @When("Enter cvv as {string}")
    public void enter_cvv_as(String ccv) {
        PAGES.getHotelPages().getHotelsFinalStep().fillCvcCode("777");
    }

    @When("Select both checkboxes to receive notification emails")
    public void select_both_checkboxes_to_receive_notification_emails() {
        PAGES.getHotelPages().getHotelsFinalStep().clickOpportunityCheckbox();
    }

    @When("Click on the complete booking button")
    public void click_on_the_complete_booking_button() {
        PAGES.getHotelPages().getHotelsFinalStep().clickOnCompleteBookingButton();
    }

    @Then("Confirm that you have successfully navigated to the confirmation page")
    public void confirm_that_you_have_successfully_navigated_to_the_confirmation_page() {
        String actualTitle = PAGES.getHotelPages().getHotelConfirmationPage().getHotelTitle();
        String expectedTitle = "About Urban Oasis Resort\n";
        assertThat(actualTitle)
                .as("Verify that the confirmation page title is correct")
                .isEqualTo(expectedTitle);
    }

}