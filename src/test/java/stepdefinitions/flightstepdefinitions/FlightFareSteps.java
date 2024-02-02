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
		then(PAGES.getFlightPages().getFlightFarePage().getContainerInstruction("departure"))
			.isEqualTo("Choose your fare");
	}

	@And("Verify that the departure route {string} and the return route {string}")
	public void verifyThatTheDepartureRouteAndTheReturnRoute(String departureRoute, String returnRoute) {
		then(PAGES.getFlightPages().getFlightFarePage().getContainerDirection("departure")).isEqualTo(departureRoute);
		then(PAGES.getFlightPages().getFlightFarePage().getContainerDirection("return")).isEqualTo(returnRoute);
	}

	@When("Click on {string} for departure fare type")
	public void clickOnForDepartureFareType(String fareType) {
		PAGES.getFlightPages().getFlightFarePage().clickOnFareType("departure", fareType);
	}

	@And("Click on {string} for return fare type")
	public void clickOnForReturnFareType(String fareType) {
		PAGES.getFlightPages().getFlightFarePage().clickOnFareType("return", fareType);
	}

	@And("Click on select who's flying button")
	public void clickOnSelectWhoSFlyingButton() {
		PAGES.getFlightPages().getFlightFarePage().clickOnSelectWhoFlyingButton();
	}

	@Then("Verify that the {string} is selected for departure fare type and {string} is selected for return fare type")
	public void verifyThatTheIsSelectedForDepartureFareTypeAndIsSelectedForReturnFareType(String departureFareType,
			String returnFareType) {
		then(PAGES.getFlightPages().getFlightFarePage().isFareTypeSelected("departure", departureFareType)).isTrue();
		then(PAGES.getFlightPages().getFlightFarePage().isFareTypeSelected("return", returnFareType)).isTrue();
	}

	@And("Get departure route information and Click on {string} for departure fare type")
	public void getDepartureRouteInformationAndClickOnForDepartureFareType(String fareType) {
		departureRoute = PAGES.getFlightPages().getFlightFarePage().getContainerDirection("departure");
		PAGES.getFlightPages().getFlightFarePage().clickOnFareType("departure", fareType);

	}

	@And("Get return route information and Click on {string} for return fare type")
	public void getReturnRouteInformationAndClickOnForReturnFareType(String fareType) {
		returnRoute = PAGES.getFlightPages().getFlightFarePage().getContainerDirection("return");
		PAGES.getFlightPages().getFlightFarePage().clickOnFareType("return", fareType);
	}

}
