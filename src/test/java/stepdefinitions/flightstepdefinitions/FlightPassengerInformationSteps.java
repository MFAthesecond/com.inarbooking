package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;
import utils.Pages;

public class FlightPassengerInformationSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(FlightHomeSteps.class);
    @And("Fill {string} as contact email")
    public void fill_as_contact_email(String email)  {
        PAGES.getFlightPages().getFlightPassengerInformationPage().fillContactEmail(email);
    }
    @And("Select {string} for country code dropdown and fill {string} as phone number")
    public void select_for_country_code_dropdown_and_fill_as_phone_number(String countryCode, String phoneNumber) {
        PAGES.getFlightPages().getFlightPassengerInformationPage().selectCountryCodeDropDown(countryCode);
        PAGES.getFlightPages().getFlightPassengerInformationPage().fillPhoneNumber(phoneNumber);
    }
    @And("Fill in first name {string} last name {string} for passenger")
    public void fillInFirstNameLastNameForPassenger(String firstName, String lastName) {
        PAGES.getFlightPages().getFlightPassengerInformationPage().fillFirstName(firstName);
        PAGES.getFlightPages().getFlightPassengerInformationPage().fillLastName(lastName);
    }
    @And("Select in the Gender as {string} from the gender dropdown for the 1st passenger")
    public void select_in_the_gender_as_from_the_gender_dropdown_for_the_1st_passenger(String gender) {
       PAGES.getFlightPages().getFlightPassengerInformationPage().selectGenderDropDown(gender);
    }
    @And("Select the year {string}, month {string}, day {string} as the date of birth")
    public void select_the_year_month_day_as_the_date_of_birth(String year, String month, String day) {
       PAGES.getFlightPages().getFlightPassengerInformationPage().selectYearDropDown(year);
       PAGES.getFlightPages().getFlightPassengerInformationPage().selectMonthDropDown(month);
       PAGES.getFlightPages().getFlightPassengerInformationPage().selectDayDropDown(day);
    }
    @And("Click on select extras button")
    public void click_on_select_extras_button() {
       PAGES.getFlightPages().getFlightPassengerInformationPage().clickOnSelectExtrasButton();
    }




    @Then("Verify that the {string} message is not displayed")
    public void verifyThatTheMessageIsNotDisplayed(String expectedErrorMessage) {
        String actualErrorMessage = PAGES.getFlightPages().getFlightPassengerInformationPage().findErrorMessage(expectedErrorMessage);
        if (actualErrorMessage.equals(expectedErrorMessage)) {
            Assertions.fail("Error Message: " + actualErrorMessage + " is displayed");
        } else {
            System.out.println("Test Valid");
        }
    }

    @And("Fill in {string} as the name, {string} as the surname, {string} as the gender, {string} as the year, {string} as the month, {string} as the day for the #{int} passenger")
    public void fillInAsTheNameAsTheSurnameAsTheGenderAsTheYearAsTheMonthAsTheDayForThePassenger(String firstName, String lastName, String gender, String year, String month, String day, int traveler) {
        PAGES.getFlightPages().getFlightPassengerInformationPage().fillTravelerCard(traveler,firstName,lastName,gender,year,month,day);
        BrowserUtils.wait(4);
    }

    @And("Calculate total price")
    public double calculateTotalPrice() {
        return PAGES.getFlightPages().getFlightPassengerInformationPage().getCalculatedTotalPrice();
    }

    @Then("Verify that total flight fare")
    public void verifyThatTotalFlightFare() {
        String actualTotalPriceStr = String.valueOf(calculateTotalPrice());
        String expectedTotalPrice=PAGES.getFlightPages().getFlightPassengerInformationPage().getTotalPrice();
        Assertions.assertThat(actualTotalPriceStr).as("Actual and expected total prices should be equal")
                .isEqualTo(expectedTotalPrice);
    }
}