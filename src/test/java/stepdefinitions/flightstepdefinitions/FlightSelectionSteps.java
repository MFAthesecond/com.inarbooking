package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightSelectionSteps extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightSelectionSteps.class);

	private List<Double> flightRanking;

	public static List<String> departureFlightInfo;

	public static List<String> returnFlightInfo;

	@And("Unselect {string} and Unselect {string} for cabin class")
	public void unselectAndUnselectForCabinClass(String classType1, String classType2) {
		try {
			LOGGER.debug("Unselecting cabin classes for round trip: {}, {}", classType1, classType2);
			PAGES.getFlightPages().getFlightSelectionPage().selectCabinClassForRoundTrip(classType1);
			PAGES.getFlightPages().getFlightSelectionPage().selectCabinClassForRoundTrip(classType2);
			LOGGER.debug("Cabin classes unselected successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while unselecting cabin classes.", e);
			throw e;
		}
	}

	@And("Select {string} for airlines")
	public void selectForAirlines(String airlinesType) {
		try {
			LOGGER.debug("Selecting airlines for round trip: {}", airlinesType);
			PAGES.getFlightPages().getFlightSelectionPage().selectAirlinesForRoundTrip(airlinesType);
			LOGGER.debug("Airlines selected successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting airlines.", e);
			throw e;
		}
	}

	@And("Select {string} for duration \\(hours)")
	public void selectForDurationHours(String duration) {
		try {
			LOGGER.debug("Selecting duration for round trip: {}", duration);
			PAGES.getFlightPages().getFlightSelectionPage().selectDurationHoursForRoundTrip(duration);
			LOGGER.debug("Duration selected successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting duration.", e);
			throw e;
		}
	}

	@And("Click on search button")
	public void clickOnSearchButton() {
		try {
			LOGGER.debug("Clicking on the search button.");
			PAGES.getFlightPages().getFlightSelectionPage().clickOnSearchButton();
			LOGGER.debug("Search button clicked successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while clicking on the search button.", e);
			throw e;
		}
	}

	@And("Click on select ticket button for #{int} flight")
	public void clickOnSelectTicketButtonFor(int flightIndex) {
		try {
			BrowserUtils.wait(1);
			PAGES.getFlightPages().getFlightSelectionPage().clickOnSelectTicket(flightIndex);
		}
		catch (UnsupportedOperationException ex) {
			LOGGER.error("There is no flight item for the flight index");
			throw ex;
		}
	}

	@And("Click on {string} tab")
	public void clickOnTab(String tabName) {
		try {
			LOGGER.debug("Clicking on {} tab.", tabName);
			if (tabName.equals("Fastest")) {
				flightRanking = PAGES.getFlightPages().getFlightSelectionPage().getFlightHours();
			}
			else {
				flightRanking = PAGES.getFlightPages().getFlightSelectionPage().getFlightPrices();
			}
			PAGES.getFlightPages().getFlightSelectionPage().clickOnTab(tabName);
			LOGGER.debug("Tab {} clicked successfully.", tabName);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while clicking on {} tab.", tabName, e);
			throw e;
		}
	}

	@Then("Verify that the the cheapest flight is the first flight")
	public void verifyThatTheTheCheapestFlightIsTheFirstFlight() {
		try {
			LOGGER.debug("Verifying that the cheapest flight is the first flight.");
			List<Double> flightPricesAfterCheapest = PAGES.getFlightPages().getFlightSelectionPage().getFlightPrices();
			Collections.sort(flightRanking);
			then(flightPricesAfterCheapest).isEqualTo(flightRanking);
			LOGGER.debug("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying the cheapest flight.", e);
			throw e;
		}
	}

	@Then("Verify that the the fastest flight is the first flight")
	public void verifyThatTheTheFastestFlightIsTheFirstFlight() {
		try {
			LOGGER.debug("Verifying that the fastest flight is the first flight.");
			List<Double> flightPricesAfterFastest = PAGES.getFlightPages().getFlightSelectionPage().getFlightHours();
			Collections.sort(flightRanking);
			then(flightPricesAfterFastest).isEqualTo(flightRanking);
			LOGGER.debug("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying the fastest flight.", e);
			throw e;
		}
	}

	@And("Click on select return ticket button for #{int} flight")
	public void clickOnSelectReturnTicketButtonForFlight(int flightIndex) {
		try {
			LOGGER.info("Clicking on select return ticket button for flight #{}.", flightIndex);
			PAGES.getFlightPages().getFlightSelectionPage().clickOnSelectTicket(flightIndex);
			LOGGER.info("Select return ticket button clicked successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while clicking on select return ticket button for flight #{}.", flightIndex,
					e);
			throw e;
		}
	}

	@And("Select {string} from origin drop down")
	public void selectFromOriginDropDown(String originName) {
		try {
			LOGGER.debug("Selecting {} from origin drop-down.", originName);
			PAGES.getFlightPages().getFlightSelectionPage().selectFromOriginDropDown(originName);
			LOGGER.debug("{} selected from origin drop-down.", originName);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting {} from origin drop-down.", originName, e);
			throw e;
		}
	}

	@And("Select {string} from destination drop down")
	public void selectFromDestinationDropDown(String destinationName) {
		try {
			LOGGER.debug("Selecting {} from destination drop-down.", destinationName);
			PAGES.getFlightPages().getFlightSelectionPage().selectFromDestinationDropDown(destinationName);
			LOGGER.debug("{} selected from destination drop-down.", destinationName);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting {} from destination drop-down.", destinationName, e);
			throw e;
		}
	}

	@And("Select {string} for Adult dropdown")
	public void selectForAdultDropdown(String adultNum) {
		try {
			LOGGER.debug("Selecting {} for Adult dropdown.", adultNum);
			PAGES.getFlightPages()
				.getFlightSelectionPage()
				.selectFromAdultDropDownForRoundTrip(Integer.parseInt(adultNum));
			LOGGER.debug("{} selected for Adult dropdown.", adultNum);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting {} for Adult dropdown.", adultNum, e);
			throw e;
		}
	}

	@And("Select {string} for Children dropdown")
	public void selectForChildrenDropdown(String childNum) {
		try {
			LOGGER.debug("Selecting {} for Children dropdown.", childNum);
			PAGES.getFlightPages()
				.getFlightSelectionPage()
				.selectFromChildDropDownForRoundTrip(Integer.parseInt(childNum));
			BrowserUtils.wait(3);
			LOGGER.debug("{} selected for Children dropdown.", childNum);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting {} for Children dropdown.", childNum, e);
			throw e;
		}
	}

	@Then("Verify that {string} for origin, {string} for destination {string} for adult {string} for children dropdown is selected")
	public void verifyThatForOriginForDestinationForAdultForChildrenDropdown(String originName, String destinationName,
			String adultNum, String childrenNum) {
		try {
			LOGGER.debug(
					"Verifying that {} for origin, {} for destination, {} for adult, {} for children dropdown is selected.",
					originName, destinationName, adultNum, childrenNum);
			then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected(originName, "Origin"))
				.as("Origin dropdown selection check")
				.isTrue();

			then(PAGES.getFlightPages()
				.getFlightSelectionPage()
				.isElementOnDropDownSelected(destinationName, "Destination")).as("Destination dropdown selection check")
				.isTrue();

			then(PAGES.getFlightPages()
				.getFlightSelectionPage()
				.isElementOnDropDownSelected(adultNum, "AdultForRoundTrip")).as("Adult dropdown selection check")
				.isTrue();

			then(PAGES.getFlightPages()
				.getFlightSelectionPage()
				.isElementOnDropDownSelected(childrenNum, "ChildrenForRoundTrip"))
				.as("Children dropdown selection check")
				.isTrue();
			LOGGER.debug("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying dropdown selections.", e);
			throw e;
		}
	}

	@And("Verify that {string} and {string} unselected for for cabin class, {string} selected for airlines , {string} selected for duration")
	public void verifyThatAndUnselectedForForCabinClassSelectedForAirlinesSelectedForDuration(String cabinClassName1,
			String cabinClassName2, String airlineName, String duration) {
		try {
			LOGGER.debug(
					"Verifying that {} and {} unselected for for cabin class, {} selected for airlines, {} selected for duration.",
					cabinClassName1, cabinClassName2, airlineName, duration);
			then(PAGES.getFlightPages()
				.getFlightSelectionPage()
				.isElementSelectedOnList(cabinClassName1, "CabinClassForRoundTrip")).as("Cabin class 1 selection check")
				.isFalse();

			then(PAGES.getFlightPages()
				.getFlightSelectionPage()
				.isElementSelectedOnList(cabinClassName2, "CabinClassForRoundTrip")).as("Cabin class 2 selection check")
				.isFalse();

			then(PAGES.getFlightPages()
				.getFlightSelectionPage()
				.isElementSelectedOnList(airlineName, "AirlinesForRoundTrip")).as("Airlines selection check").isTrue();

			then(PAGES.getFlightPages()
				.getFlightSelectionPage()
				.isElementSelectedOnList(duration, "DurationForRoundTrip")).as("Duration selection check").isTrue();
			LOGGER.debug("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying selections.", e);
			throw e;
		}
	}

	@And("Select departure date as {string}")
	public void selectDepartureDateAs(String departureDate) {
		try {
			LOGGER.debug("Selecting departure date as {}.", departureDate);
			PAGES.getFlightPages().getFlightSelectionPage().selectDepartureDate(departureDate);
			LOGGER.debug("Departure date selected successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting departure date.", e);
			throw e;
		}
	}

	@And("Select return date as {string}")
	public void selectReturnDateAs(String returnDate) {
		try {
			LOGGER.debug("Selecting return date as {}.", returnDate);
			PAGES.getFlightPages().getFlightSelectionPage().selectReturnDate(returnDate);
			LOGGER.debug("Return date selected successfully.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting return date.", e);
			throw e;
		}
	}

	@Then("Verify that {string} and {string} is selected")
	public void verifyThatAndIsSelected(String departureDate, String returnDate) {
		try {
			LOGGER.debug("Verifying that {} and {} are selected.", departureDate, returnDate);
			then(PAGES.getFlightPages().getFlightSelectionPage().getSelectedDepartureDate()).isEqualTo(departureDate);
			then(PAGES.getFlightPages().getFlightSelectionPage().getSelectedReturnDate()).isEqualTo(returnDate);
			LOGGER.debug("Verification successful.");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying selected dates.", e);
			throw e;
		}
	}

	@And("Get the #{int} flight information and click on select ticket button")
	public void getTheFlightInformationAndClickOnSelectTicketButton(int flightIndex) {
		try {
			LOGGER.debug("Getting the #{} flight information and clicking on select ticket button.", flightIndex);
			departureFlightInfo = PAGES.getFlightPages().getFlightSelectionPage().getItemInformation(flightIndex);
			PAGES.getFlightPages().getFlightSelectionPage().clickOnSelectTicket(flightIndex);
			LOGGER.debug("Select ticket button clicked successfully.");
		}
		catch (Exception e) {
			LOGGER.error(
					"Error occurred while getting flight information and clicking on select ticket button for flight #{}.",
					flightIndex, e);
			throw e;
		}
	}

	@And("Get the #{int} flight information and click on select return ticket button")
	public void getTheFlightInformationAndClickOnSelectReturnTicketButton(int flightIndex) {
		try {
			LOGGER.debug("Getting the #{} flight information and clicking on select return ticket button.",
					flightIndex);
			returnFlightInfo = PAGES.getFlightPages().getFlightSelectionPage().getItemInformation(flightIndex);
			PAGES.getFlightPages().getFlightSelectionPage().clickOnSelectTicket(flightIndex);
			LOGGER.debug("Select return ticket button clicked successfully.");
		}
		catch (Exception e) {
			LOGGER.error(
					"Error occurred while getting flight information and clicking on select return ticket button for flight #{}.",
					flightIndex, e);
			throw e;
		}
	}

	@Then("Verify that {string} as departure date and {string} as return date are not accepted on date picker")
	public void verifyThatAsDepartureDateAndAsReturnDateAreNotAcceptedOnDatePicker(String departureDate,
			String returnDate) {
		try {
			LOGGER.debug("Verifying departure date: {} and return date: {}", departureDate, returnDate);

			String selectedDepartureDate = PAGES.getFlightPages().getFlightSelectionPage().getSelectedDepartureDate();
			String selectedReturnDate = PAGES.getFlightPages().getFlightSelectionPage().getSelectedReturnDate();

			LOGGER.debug("Selected departure date: {}", selectedDepartureDate);
			LOGGER.debug("Selected return date: {}", selectedReturnDate);

			then(selectedDepartureDate)
				.as("The departure date should not be displayed because it should be before from return date")
				.isNotEqualTo(departureDate);
			then(selectedReturnDate)
				.as("The return date should not be displayed because it should be after from departure date")
				.isNotEqualTo(returnDate);

			LOGGER.debug("Verification completed.");
		}
		catch (NoSuchElementException e) {
			LOGGER.error("The element was not found on page.", e);
			throw e;
		}
	}

}
