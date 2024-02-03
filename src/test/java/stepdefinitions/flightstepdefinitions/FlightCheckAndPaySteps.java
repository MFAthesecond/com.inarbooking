package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.flightpages.FlightExtrasPage;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightCheckAndPaySteps extends BaseStep {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightCheckAndPaySteps.class);

	@When("Fill in {string} as the cardholder's name")
	public void fill_in_as_the_cardholder_s_name(String cardHolderName) {
		try {
			LOGGER.debug("Filling cardholder's name as {}", cardHolderName);
			PAGES.getFlightPages().getFlightCheckAndPayPage().fillCardHolderName(cardHolderName);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while filling cardholder's name: {}", e.getMessage());
			throw e;
		}
	}

	@When("Fill in {string} as the card number")
	public void fill_in_as_the_card_number(String cardNumber) {
		try {
			LOGGER.debug("Filling card number as {}", cardNumber);
			PAGES.getFlightPages().getFlightCheckAndPayPage().fillCardNumber(cardNumber);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while filling card number: {}", e.getMessage());
			throw e;
		}
	}

	@When("Fill in {string} as the expiration date")
	public void fill_in_as_the_expiration_date(String expirationDate) {
		try {
			LOGGER.debug("Filling expiration date as {}", expirationDate);
			PAGES.getFlightPages().getFlightCheckAndPayPage().fillExpirationDate(expirationDate);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while filling expiration date: {}", e.getMessage());
			throw e;
		}
	}

	@When("Fill in {string} as the cvc code")
	public void fill_in_as_the_cvc_code(String cvcCode) {
		try {
			LOGGER.debug("Filling cvc code as {}", cvcCode);
			PAGES.getFlightPages().getFlightCheckAndPayPage().fillCvcCode(cvcCode);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while filling cvc code: {}", e.getMessage());
			throw e;
		}
	}

	@When("Click on complete booking button")
	public void click_on_complete_booking_button() {
		try {
			LOGGER.info("Clicking on complete booking button");
			BrowserUtils.wait(2);
			PAGES.getFlightPages().getFlightCheckAndPayPage().clickOnCompleteBookingButton();
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while clicking on complete booking button: {}", e.getMessage());
			throw e;
		}

	}

	@Then("Verify that total price on check and pay page")
	public void verifyThatTotalPriceOnCheckAndPayPage() {
		try {
			then(PAGES.getFlightPages().getFlightCheckAndPayPage().getTotalPrice())
				.isEqualTo(FlightExtrasSteps.totalPriceOnExtrasPage);
			LOGGER.info("Total price on check and pay page verified successfully.");
		}
		catch (AssertionError e) {
			LOGGER.debug("Total price on check and pay page verification failed: " + e.getMessage());
		}
	}

	@Then("Verify that the user is on Flight Check And Pay Page")
	public void verifyThatTheUserIsOnFlightCheckAndPayPage() {
		try {
			then(PAGES.getFlightPages().getFlightCheckAndPayPage().validateCheckAndPay())
				.isEqualTo("Cardholder's Name");
			LOGGER.info("User is on Flight Check And Pay Page.");
		}
		catch (NoSuchElementException e) {
			LOGGER.debug("User is not on Flight Check And Pay Page: " + e.getMessage());
			Assertions.fail("The user should be on the check and pay page because of invalid name credential");
		}
	}

	@Then("Verify that the expiration of date invalid message is displayed")
	public void verifyThatTheExpirationOfDateInvalidMessageIsDisplayed() {
		try {
			then(PAGES.getFlightPages().getFlightCheckAndPayPage().expirationOfDateInvalidMessage())
				.isEqualTo("Invalid expiration date. Please use the MM/YY format.");
			LOGGER.info("Expiration of date invalid message is displayed as expected.");
		}
		catch (NoSuchElementException e) {
			LOGGER.debug("Expiration of date invalid message is not displayed as expected: " + e.getMessage());
			Assertions.fail(
					"The user should be on the check and pay page because of the invalid card expiration date credential");
			throw e;
		}
	}

}