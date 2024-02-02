package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightConfirmationSteps extends BaseStep {

	@Then("Validate the user is on confirmation page")
	public void validateTheUserIsOnConfirmationPage() {
		Assertions.assertThat(PAGES.getFlightPages().getFlightConfirmationPage().isConfirmationMessageDisplayed())
			.isTrue();
	}

	@Then("Verify that {string} , route and ticket information on confirmation page for departure and return")
	public void verifyThatRouteAndTicketInformationOnConfirmationPage(String email) {
		String departureEmailOnConfirmationPage = PAGES.getFlightPages()
			.getFlightConfirmationPage()
			.getConfirmationCardInfo("gmail", "departure");
		System.out.println(departureEmailOnConfirmationPage);
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

		then(departureEmailOnConfirmationPage).isEqualTo(email);
		then(departureRouteOnConfirmationPage).isEqualTo(FlightFareSteps.departureRoute);
		then(departureTakeOffTimeOnConfirmationPage).isEqualTo(FlightSelectionSteps.departureFlightInfo.get(4));
		then(departureArrivalTimeOnConfirmationPage).isEqualTo(FlightSelectionSteps.departureFlightInfo.get(8));

		then(returnEmailOnConfirmationPage).isEqualTo(email);
		then(returnRouteOnConfirmationPage).isEqualTo(FlightFareSteps.returnRoute);
		then(returnTakeOffTimeOnConfirmationPage).isEqualTo(FlightSelectionSteps.returnFlightInfo.get(4));
		then(returnArrivalTimeOnConfirmationPage).isEqualTo(FlightSelectionSteps.returnFlightInfo.get(8));
	}

}
