package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightFareSteps extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightFareSteps.class);

	public static String departureRoute;

	public static String returnRoute;

	@Then("Verify that the user on flight fare page")
	public void verifyThatTheUserOnFlightFarePage() {
		try {
			LOGGER.debug("Verifying that the user is on the flight fare page.");
			then(PAGES.getFlightPages().getFlightFarePage().getContainerInstruction("departure"))
				.as("Departure container instruction check")
				.isEqualTo("Choose your fare");
			LOGGER.debug("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying the user on the flight fare page.", e);
			throw e;
		}
	}

	@And("Verify that the departure route {string} and the return route {string}")
	public void verifyThatTheDepartureRouteAndTheReturnRoute(String departureRoute, String returnRoute) {
		try {
			LOGGER.debug("Verifying departure route: {} and return route: {}.", departureRoute, returnRoute);
			then(PAGES.getFlightPages().getFlightFarePage().getContainerDirection("departure"))
				.as("Departure route check")
				.isEqualTo(departureRoute);

			then(PAGES.getFlightPages().getFlightFarePage().getContainerDirection("return")).as("Return route check")
				.isEqualTo(returnRoute);
			LOGGER.debug("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying departure and return routes.", e);
			throw e;
		}
	}

	@When("Click on {string} for departure fare type")
	public void clickOnForDepartureFareType(String fareType) {
		try {
			LOGGER.debug("Clicking on {} for departure fare type.", fareType);
			PAGES.getFlightPages().getFlightFarePage().clickOnFareType("departure", fareType);
			LOGGER.debug("{} clicked successfully.", fareType);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while clicking on {} for departure fare type.", fareType, e);
			throw e;
		}
	}

	@And("Click on {string} for return fare type")
	public void clickOnForReturnFareType(String fareType) {
		try {
			LOGGER.debug("Clicking on {} for return fare type.", fareType);
			PAGES.getFlightPages().getFlightFarePage().clickOnFareType("return", fareType);
			LOGGER.debug("{} clicked successfully.", fareType);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while clicking on {} for return fare type.", fareType, e);
			throw e;
		}
	}

	@And("Click on select who's flying button")
	public void clickOnSelectWhoSFlyingButton() {
		try {
			LOGGER.info("Clicking on select who's flying button.");
			PAGES.getFlightPages().getFlightFarePage().clickOnSelectWhoFlyingButton();
			LOGGER.info("Select who's flying button clicked successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while clicking on select who's flying button.", e);
			throw e;
		}
	}

	@Then("Verify that the {string} is selected for departure fare type and {string} is selected for return fare type")
	public void verifyThatTheIsSelectedForDepartureFareTypeAndIsSelectedForReturnFareType(String departureFareType,
			String returnFareType) {
		try {
			LOGGER.debug("Verifying departure fare type: {} and return fare type: {} are selected.", departureFareType,
					returnFareType);
			then(PAGES.getFlightPages().getFlightFarePage().isFareTypeSelected("departure", departureFareType))
				.as("Fare type selection check for departure: " + departureFareType)
				.isTrue();

			then(PAGES.getFlightPages().getFlightFarePage().isFareTypeSelected("return", returnFareType))
				.as("Fare type selection check for return: " + returnFareType)
				.isTrue();
			LOGGER.debug("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying fare type selections.", e);
			throw e;
		}
	}

	@And("Get departure route information and Click on {string} for departure fare type")
	public void getDepartureRouteInformationAndClickOnForDepartureFareType(String fareType) {
		try {
			LOGGER.info("Getting departure route information and Clicking on {} for departure fare type.", fareType);
			departureRoute = PAGES.getFlightPages().getFlightFarePage().getContainerDirection("departure");
			PAGES.getFlightPages().getFlightFarePage().clickOnFareType("departure", fareType);
			LOGGER.info("{} clicked successfully.", fareType);
		}
		catch (Exception e) {
			LOGGER.error(
					"Error occurred while getting departure route information and clicking on {} for departure fare type.",
					fareType, e);
			throw e;
		}

	}

	@And("Get return route information and Click on {string} for return fare type")
	public void getReturnRouteInformationAndClickOnForReturnFareType(String fareType) {
		try {
			LOGGER.debug("Getting return route information and Clicking on {} for return fare type.", fareType);
			returnRoute = PAGES.getFlightPages().getFlightFarePage().getContainerDirection("return");
			PAGES.getFlightPages().getFlightFarePage().clickOnFareType("return", fareType);
			LOGGER.debug("{} clicked successfully.", fareType);
		}
		catch (Exception e) {
			LOGGER.error(
					"Error occurred while getting return route information and clicking on {} for return fare type.",
					fareType, e);
			throw e;
		}
	}

}
