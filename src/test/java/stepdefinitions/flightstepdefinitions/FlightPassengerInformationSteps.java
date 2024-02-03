package stepdefinitions.flightstepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.BDDAssertions.then;

public class FlightPassengerInformationSteps extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(FlightPassengerInformationSteps.class);

	@And("Fill {string} as contact email")
	public void fill_as_contact_email(String email) {
		try {
			LOGGER.debug("Filling contact email as {}", email);
			PAGES.getFlightPages().getFlightPassengerInformationPage().fillContactEmail(email);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while filling contact email: {}", e.getMessage());
			throw e;
		}
	}

	@And("Select {string} for country code dropdown and fill {string} as phone number")
	public void select_for_country_code_dropdown_and_fill_as_phone_number(String countryCode, String phoneNumber) {
		try {
			LOGGER.debug("Selecting country code: {} and filling phone number: {}", countryCode, phoneNumber);
			PAGES.getFlightPages().getFlightPassengerInformationPage().selectCountryCodeDropDown(countryCode);
			PAGES.getFlightPages().getFlightPassengerInformationPage().fillPhoneNumber(phoneNumber);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting country code and filling phone number: {}", e.getMessage());
			throw e;
		}
	}

	@And("Fill in first name {string} last name {string} for passenger")
	public void fillInFirstNameLastNameForPassenger(String firstName, String lastName) {
		try {
			LOGGER.debug("Filling passenger information - First Name: {}, Last Name: {}", firstName, lastName);
			PAGES.getFlightPages().getFlightPassengerInformationPage().fillFirstName(firstName);
			PAGES.getFlightPages().getFlightPassengerInformationPage().fillLastName(lastName);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while filling passenger information: {}", e.getMessage());
			throw e;
		}
	}

	@And("Select in the Gender as {string} from the gender dropdown for the 1st passenger")
	public void select_in_the_gender_as_from_the_gender_dropdown_for_the_1st_passenger(String gender) {
		try {
			LOGGER.debug("Selecting gender for the 1st passenger: {}", gender);
			PAGES.getFlightPages().getFlightPassengerInformationPage().selectGenderDropDown(gender);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting gender: {}", e.getMessage());
			throw e;
		}
	}

	@And("Select the year {string}, month {string}, day {string} as the date of birth")
	public void select_the_year_month_day_as_the_date_of_birth(String year, String month, String day) {
		try {
			LOGGER.debug("Selecting date of birth - Year: {}, Month: {}, Day: {}", year, month, day);
			PAGES.getFlightPages().getFlightPassengerInformationPage().selectYearDropDown(year);
			PAGES.getFlightPages().getFlightPassengerInformationPage().selectMonthDropDown(month);
			PAGES.getFlightPages().getFlightPassengerInformationPage().selectDayDropDown(day);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while selecting date of birth: {}", e.getMessage());
			throw e;
		}
	}

	@And("Click on select extras button")
	public void click_on_select_extras_button() {
		try {
			LOGGER.info("Clicking on select extras button");
			PAGES.getFlightPages().getFlightPassengerInformationPage().clickOnSelectExtrasButton();
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while clicking on select extras button: {}", e.getMessage());
			throw e;
		}
	}

	@Then("Verify that the {string} message is not displayed")
	public void verifyThatTheMessageIsNotDisplayed(String expectedErrorMessage) {
		try {
			LOGGER.debug("Verifying that the '{}' message is not displayed", expectedErrorMessage);
			String actualErrorMessage = PAGES.getFlightPages()
				.getFlightPassengerInformationPage()
				.findErrorMessage(expectedErrorMessage);
			if (actualErrorMessage.equals(expectedErrorMessage)) {
				Assertions.fail("Error Message: " + actualErrorMessage + " is displayed");
			}
			else {
				LOGGER.info("Test is valid");
			}
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying error message: {}", e.getMessage());
			throw e;
		}
	}

	@And("Fill in {string} as the name, {string} as the surname, {string} as the gender, {string} as the year, {string} as the month, {string} as the day for the #{int} passenger")
	public void fillInAsTheNameAsTheSurnameAsTheGenderAsTheYearAsTheMonthAsTheDayForThePassenger(String firstName,
			String lastName, String gender, String year, String month, String day, int traveler) {
		try {
			LOGGER.debug(
					"Filling in traveler information - Name: {}, Surname: {}, Gender: {}, Year: {}, Month: {}, Day: {}, Passenger: #{}",
					firstName, lastName, gender, year, month, day, traveler);
			PAGES.getFlightPages()
				.getFlightPassengerInformationPage()
				.fillTravelerCard(traveler, firstName, lastName, gender, year, month, day);
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while filling traveler information: {}", e.getMessage());
			throw e;
		}
	}

	@Then("Verify that the user is on passenger information page")
	public void verifyThatTheUserIsOnPassengerInformationPage() {
		try {
			LOGGER.debug("Verifying user is on passenger information page");
			then(PAGES.getFlightPages().getFlightPassengerInformationPage().getHeaderText())
				.isEqualTo("Contact Details");
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying user is on passenger information page: {}", e.getMessage());
			throw e;
		}
	}

	@Then("Verify that total flight fare")
	public void verifyThatTotalFlightFare() {
		try {
			LOGGER.info("Verifying total flight fare");
			BrowserUtils.wait(2);
			String actualTotalPriceStr = PAGES.getFlightPages().getFlightPassengerInformationPage().getTotalPrice();
			String expectedTotalPrice = PAGES.getFlightPages().getFlightPassengerInformationPage().getTotalPrice();

			assertThat(actualTotalPriceStr).as("Actual and expected total prices should be equal")
				.isEqualTo(expectedTotalPrice);
		}
		catch (AssertionError e) {
			LOGGER.error("Assertion error occurred while verifying total flight fare: {}", e.getMessage());
			throw e;
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while verifying total flight fare: {}", e.getMessage());
			throw e;
		}

	}

	@And("Fill the traveler information")
	public void fillTheTravelerInformation(DataTable travelerInformation) {
		List<List<String>> data = travelerInformation.asLists();
		try {
			// LOGGER.debug("Filling in traveler information - Name: {}, Surname: {},
			// Gender: {}, Year: {}, Month: {}, Day: {}, Passenger: #{}", firstName,
			// lastName, gender, year, month, day, traveler);
			for (int i = 0; i < FlightHomeSteps.totalTravelerNumber; i++) {
				PAGES.getFlightPages()
					.getFlightPassengerInformationPage()
					.fillTravelerCard(i + 1, data.get(i).get(0), data.get(i).get(1), data.get(i).get(2),
							data.get(i).get(3), data.get(i).get(4), data.get(i).get(5));
				BrowserUtils.wait(1);
			}
		}
		catch (Exception e) {
			LOGGER.error("Error occurred while filling traveler information: {}", e.getMessage());
			throw e;
		}
	}

	@Then("Verify that the user is on flight Passenger Information Page")
	public void verifyThatTheUserIsOnFlightPassengerInformationPage() {
		try {
			boolean isPassengerInformationPageValid = PAGES.getFlightPages()
				.getFlightPassengerInformationPage()
				.validatePassengerInformationPage();
			if (isPassengerInformationPageValid) {
				LOGGER.debug("User is on the flight Passenger Information Page.");
			}
			else {
				LOGGER.debug("User is NOT on the flight Passenger Information Page.");
			}
		}
		catch (Exception e) {
			LOGGER.error("An error occurred while verifying passenger information page: " + e.getMessage());
			throw e;
		}
	}

}
