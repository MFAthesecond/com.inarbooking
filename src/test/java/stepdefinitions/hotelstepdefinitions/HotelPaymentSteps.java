package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// Diğer import ifadeleri...

public class HotelPaymentSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(HotelPaymentSteps.class);

    @Given("Navigation to the hotel yours details URL")
    public void navigation_to_the_hotel_yours_details_url() {
        PAGES.getHotelPages().getHotelsYourDetailsPage();
        LOGGER.debug("Navigated to the hotel your details URL");
    }

    @When("Click on the booking for someone else for checkbox")
    public void click_on_the_booking_for_someone_else_for_checkbox() {
        PAGES.getHotelPages().getHotelDetailsPage().clickBookingCheckbox();
        LOGGER.debug("Clicked on booking for someone else checkbox");
    }

    @And("Select {string} for country code dropdown and fill in {string} as phone number")
    public void select_for_country_code_dropdown_and_fill_in_as_phone_number(String countryCode, String phoneNumber) {
        PAGES.getHotelPages().getHotelsYourDetailsPage().selectCountryCodeDropDown(countryCode);
        PAGES.getHotelPages().getHotelsYourDetailsPage().fillPhoneNumber(phoneNumber);
        LOGGER.debug("Selected country code: {}, Filled phone number: {}", countryCode, phoneNumber);
    }

    @When("Click yes checkbox for free paper approval")
    public void click_yes_checkbox_for_free_paper_approval() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().clickOnFreePaperCheckbox();
        LOGGER.debug("Clicked on free paper approval checkbox");
    }

    @When("Click the yes checkbox to save the details")
    public void click_the_yes_checkbox_to_save_the_details() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().clickOnDetailsCheckbox();
        LOGGER.debug("Clicked on save details checkbox");
    }

    @When("Write the Card Holder's Name as {string}")
    public void write_the_card_holder_s_name_as(String cardName) {
        PAGES.getHotelPages().getHotelsPaymentPage().fillCardHolderName(cardName);
        LOGGER.debug("Filled card holder's name: {}", cardName);
    }

    @When("Enter card number as {string}")
    public void enter_card_number_as(String cardNumber) {
        PAGES.getHotelPages().getHotelsPaymentPage().fillCardNumber(cardNumber);
        LOGGER.debug("Filled card number: {}", cardNumber);
    }

    @When("Enter expiration date as {string}")
    public void enter_expiration_date_as(String date) {
        PAGES.getHotelPages().getHotelsPaymentPage().fillExpirationDate(date);
        LOGGER.debug("Filled expiration date: {}", date);
    }

    @When("Enter cvv as {string}")
    public void enter_cvv_as(String ccv) {
        PAGES.getHotelPages().getHotelsPaymentPage().fillCvcCode(ccv);
        LOGGER.debug("Filled CVV code: {}", ccv);
    }

    @When("Select both checkboxes to receive notification emails")
    public void select_both_checkboxes_to_receive_notification_emails() {
        PAGES.getHotelPages().getHotelsPaymentPage().clickOpportunityCheckbox();
        LOGGER.debug("Selected checkboxes to receive notification emails");
    }

    @When("Click on the complete booking button")
    public void click_on_the_complete_booking_button() {
        PAGES.getHotelPages().getHotelsPaymentPage().clickOnCompleteBookingButton();
        LOGGER.debug("Clicked on the complete booking button");
    }

    @Then("Confirm that you have successfully navigated to the {string} confirmation page")
    public void confirmThatYouHaveSuccessfullyNavigatedToTheConfirmationPage(String expectedTitle) {
        String actualTitle = PAGES.getHotelPages().getHotelConfirmationPage().getHotelTitle();
        LOGGER.debug("Expected Title: {}, Actual Title: {}", expectedTitle, actualTitle);

        assertThat(actualTitle)
                .as("Verify that the confirmation page title is correct")
                .isEqualTo(expectedTitle);
        LOGGER.debug("Confirmed successful navigation to the confirmation page");
    }


    @Then("Verify that the user is on the hotel selection page")
    public void verify_that_the_user_is_on_the_hotel_selection_page() {
        assertThat(PAGES.getHotelPages().getHotelSelectionPage().validateNavigationToHotelSelectionPage()).isTrue();

    }

    @Then("Verify that the user is on the hotel details page")
    public void verify_that_the_user_is_on_the_hotel_details_page() {

    }

    @Then("Verify that the user is on the payment page")
    public void verify_that_the_user_is_on_the_payment_page() {
        assertThat(PAGES.getHotelPages().getHotelsPaymentPage().validateInfoTitle()).isTrue();
        try {
            LOGGER.info("Verifying that the user is on the payment page...");
            boolean isInfoTitleDisplayed = PAGES.getHotelPages().getHotelsPaymentPage().validateInfoTitle();
            assertThat(PAGES.getHotelPages().getHotelsPaymentPage().validateInfoTitle()).isTrue();
            LOGGER.info("Verification completed successfully.");

        } catch (Exception e) {
            Logger errorLogger = LogManager.getLogger("errorLogger");
            errorLogger.error("An error occurred during verification: " + e.getMessage());

            throw e;
        }
    }

    @Then("Verify that the hotel name is correct")
    public void verify_that_the_hotel_name_is_correct() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @And("Verify that {string} is selected")
    public void verifyThatSelected(String arg0) {
        assertThat(arg0).isEqualTo(PAGES.getHotelPages().getHotelPage().getHotelName());
        LOGGER.debug("Verified that {} is selected", arg0);
    }
}
