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

		assertThat(actualTitle).as("Verify that the confirmation page title is correct").isEqualTo(expectedTitle);
		LOGGER.debug("Confirmed successful navigation to the confirmation page");
	}

	@And("Verify that {string} is selected")
	public void verifyThatIsSelected(String hotelName) {
		LOGGER.debug("Verifying that {} is selected", hotelName);
		try {
			String selectedHotelName = PAGES.getHotelPages().getHotelsPaymentPage().getHotelName();
			LOGGER.debug("Selected hotel name: {}", selectedHotelName);
			assertThat(selectedHotelName).as("Verify that the hotel is selected").isEqualTo(hotelName);
		}
		catch (Exception e) {
			LOGGER.error("An error occurred while verifying selected hotel: {}", e.getMessage());
			throw new AssertionError("Error occurred while verifying selected hotel.", e);
		}
	}

}
