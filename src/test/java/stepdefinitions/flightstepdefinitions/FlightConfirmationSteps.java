package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightConfirmationSteps extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightConfirmationSteps.class);

	@Then("Validate the user is on confirmation page")
	public void validateTheUserIsOnConfirmationPage() {
		try {
			LOGGER.debug("Validating that the user is on the confirmation page.");
			Assertions.assertThat(PAGES.getFlightPages().getFlightConfirmationPage().isConfirmationMessageDisplayed())
				.isTrue();
			LOGGER.debug("Validation successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while validating the user on the confirmation page.", e);
			throw e;
		}
	}

	@Then("Verify that {string} , route and ticket information on confirmation page for departure and return")
	public void verifyThatRouteAndTicketInformationOnConfirmationPage(String email) {
		try {
			LOGGER.info("Verifying route and ticket information on confirmation page for departure and return.");
			String departureEmailOnConfirmationPage = PAGES.getFlightPages()
				.getFlightConfirmationPage()
				.getConfirmationCardInfo("gmail", "departure");
			String departureRouteOnConfirmationPage = PAGES.getFlightPages()
				.getFlightConfirmationPage()
				.getConfirmationCardInfo("route", "departure");
			String departureTakeOffTimeOnConfirmationPage = PAGES.getFlightPages()
				.getFlightConfirmationPage()
				.getConfirmationCardInfo("takeoff time", "departure");
			String departureArrivalTimeOnConfirmationPage = PAGES.getFlightPages()
				.getFlightConfirmationPage()
				.getConfirmationCardInfo("arrival time", "departure");

			String returnEmailOnConfirmationPage = PAGES.getFlightPages()
				.getFlightConfirmationPage()
				.getConfirmationCardInfo("gmail", "return");
			String returnRouteOnConfirmationPage = PAGES.getFlightPages()
				.getFlightConfirmationPage()
				.getConfirmationCardInfo("route", "return");
			String returnTakeOffTimeOnConfirmationPage = PAGES.getFlightPages()
				.getFlightConfirmationPage()
				.getConfirmationCardInfo("takeoff time", "return");
			String returnArrivalTimeOnConfirmationPage = PAGES.getFlightPages()
				.getFlightConfirmationPage()
				.getConfirmationCardInfo("arrival time", "return");
			then(departureEmailOnConfirmationPage).as("Email on confirmation page for departure").isEqualTo(email);

			then(departureRouteOnConfirmationPage).as("Route on confirmation page for departure")
				.isEqualTo(FlightFareSteps.departureRoute);

			then(departureTakeOffTimeOnConfirmationPage).as("Takeoff time on confirmation page for departure")
				.isEqualTo(FlightSelectionSteps.departureFlightInfo.get(4));

			then(departureArrivalTimeOnConfirmationPage).as("Arrival time on confirmation page for departure")
				.isEqualTo(FlightSelectionSteps.departureFlightInfo.get(8));

			then(returnEmailOnConfirmationPage).as("Email on confirmation page for return").isEqualTo(email);

			then(returnRouteOnConfirmationPage).as("Route on confirmation page for return")
				.isEqualTo(FlightFareSteps.returnRoute);

			then(returnTakeOffTimeOnConfirmationPage).as("Takeoff time on confirmation page for return")
				.isEqualTo(FlightSelectionSteps.returnFlightInfo.get(4));

			then(returnArrivalTimeOnConfirmationPage).as("Arrival time on confirmation page for return")
				.isEqualTo(FlightSelectionSteps.returnFlightInfo.get(8));

			LOGGER.info("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying route and ticket information on confirmation page.", e);
			throw e;
		}
	}

	@When("Click on close button on confirmation page")
	public void clickOnCloseButtonOnConfirmationPage() {
		try {
			PAGES.getFlightPages().getFlightConfirmationPage().clickOnCloseButton();
			LOGGER.info("Clicked on the close button on the confirmation page.");
		}
		catch (Exception e) {
			LOGGER.error("Error while clicking on the close button: " + e.getMessage());
			throw e;

		}
	}

}
