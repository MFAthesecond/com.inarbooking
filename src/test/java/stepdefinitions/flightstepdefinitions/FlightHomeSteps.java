package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightHomeSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(FlightHomeSteps.class);

    @When("Click on the Flight Tab")
    public void click_on_the_flight_tab() {
        try {
            LOGGER.info("Clicking on the Flight Tab");
            PAGES.getFlightPages().getFlightHomePage().clickOnFlightTab();
            LOGGER.debug("Navigated to the Flight Tab");
        } catch (RuntimeException ex) {
            LOGGER.error("The tab could not be found and the exception " + ex.getClass());
            throw ex;
        }
    }

    @And("Click on round trip checkbox")
    public void click_on_round_trip_checkbox() {
        try {
            LOGGER.info("Clicking on round trip checkbox");
            PAGES.getFlightPages().getFlightHomePage().clickOnRoundTripAndOneWayRadioButton("Round Trip");
            LOGGER.debug("The trip type is selected");
        } catch (RuntimeException ex) {
            LOGGER.error("The checkbox element could not be clicked" + ex.getClass());
            throw ex;
        }
    }

    @And("Select {string} for flight class")
    public void select_for_flight_class(String string) {
        try {
            LOGGER.debug("Selecting {} for flight class", string);
            PAGES.getFlightPages().getFlightHomePage().selectFlightClassesDropDown(string);
            LOGGER.debug("The trip type is selected");
        } catch (RuntimeException ex) {
            LOGGER.error("The checkbox element could not be clicked" + ex.getClass());
            throw ex;
        }
    }

    @And("Select {string} for from dropdown and select {string} for to dropdown")
    public void select_for_from_dropdown_and_select_for_to_dropdown(String countryName1, String countryName2) {
        try {
            LOGGER.debug("Selecting {} for from dropdown and {} for to dropdown", countryName1, countryName2);
            PAGES.getFlightPages().getFlightHomePage().selectFromDropDown(countryName1);
            PAGES.getFlightPages().getFlightHomePage().selectToDropDown(countryName2);
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while selecting dropdown values: {}", ex.getMessage());
            throw ex;
        }
    }

    @And("Select date as #{int} and #{int} days of next month")
    public void select_date_as_and_days_of_next_month(Integer day1, Integer day2) {
        try {
            LOGGER.debug("Selecting date as #{} and #{} days of next month", day1, day2);
            PAGES.getFlightPages().getFlightHomePage().clickOnDatePicker();
            PAGES.getFlightPages().getFlightHomePage().clickOnNextButton();
            BrowserUtils.scrollDownWithJavaScript(0, 400);
            BrowserUtils.wait(2);
            PAGES.getFlightPages().getFlightHomePage().clickOnDayByIndex(day1);
            PAGES.getFlightPages().getFlightHomePage().clickOnDayByIndex(day2);
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while selecting date: {}", ex.getMessage());
            throw ex;
        }
    }

    @And("Select {int} adults and {int} child and click on search flight button")
    public void select_adults_and_child_and_click_on_search_flight_button(Integer adultNum, Integer childNum) {
        try {
            LOGGER.debug("Selecting {} adults and {} child and clicking on search flight button", adultNum, childNum);
            PAGES.getFlightPages().getFlightHomePage().clickOnPassengersOptionsItem();
            PAGES.getFlightPages().getFlightHomePage().clickOnAdultCounterNumber(adultNum);
            PAGES.getFlightPages().getFlightHomePage().clickOnChildrenCounterNumber(childNum);
            PAGES.getFlightPages().getFlightHomePage().clickOnSearchFlightButton();
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while selecting passengers and clicking search flight button: {}", ex.getMessage());
            throw ex;
        }
    }

    @And("Select date as {string} and {string} days of next month")
    public void selectDateAsAndDaysOfNextMonth(String day1, String day2) {
        try {
            LOGGER.debug("Selecting date as {} and {} days of next month", day1, day2);
            PAGES.getFlightPages().getFlightHomePage().clickOnDatePicker();
            PAGES.getFlightPages().getFlightHomePage().clickOnNextButton();
            BrowserUtils.scrollDownWithJavaScript(0, 400);
            BrowserUtils.wait(2);
            PAGES.getFlightPages().getFlightHomePage().clickOnDayByIndex(Integer.parseInt(day1));
            PAGES.getFlightPages().getFlightHomePage().clickOnDayByIndex(Integer.parseInt(day2));
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while selecting date: {}", ex.getMessage());
            throw ex;
        }
    }

    @And("Select {string} adults and {string} child and click on search flight button")
    public void selectAdultsAndChildAndClickOnSearchFlightButton(String adultNum, String childNum) {
        try {
            LOGGER.debug("Selecting {} adults and {} child and clicking on search flight button", adultNum, childNum);
            BrowserUtils.scrollDownWithJavaScript(0, -400);
            BrowserUtils.wait(2);
            PAGES.getFlightPages().getFlightHomePage().clickOnPassengersOptionsItem();
            PAGES.getFlightPages().getFlightHomePage().clickOnAdultCounterNumber(Integer.parseInt(adultNum));
            PAGES.getFlightPages().getFlightHomePage().clickOnChildrenCounterNumber(Integer.parseInt(childNum));
            PAGES.getFlightPages().getFlightHomePage().clickOnSearchFlightButton();
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while selecting passengers and clicking search flight button: {}", ex.getMessage());
            throw ex;
        }
    }

    @And("Click on {string} trip checkbox")
    public void clickOnTripCheckbox(String tripType) {
        try {
            LOGGER.info("Clicking on {} trip checkbox", tripType);
            PAGES.getFlightPages().getFlightHomePage().clickOnRoundTripAndOneWayRadioButton(tripType);
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while clicking on trip checkbox: {}", ex.getMessage());
            throw ex;
        }
    }

    @And("Click on search flight button")
    public void clickOnSearchFlightButton() {
        try {
            LOGGER.info("Clicking on search flight button");
            PAGES.getFlightPages().getFlightHomePage().clickOnSearchFlightButton();
            BrowserUtils.wait(2);
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while clicking on search flight button: {}", ex.getMessage());
            throw ex;
        }
    }

    @Then("Validate the user is on flight selection page")
    public void validate_the_user_is_on_flight_selection_page() {
        try {
            LOGGER.debug("Validating the user is on flight selection page");
            then(DRIVER.getCurrentUrl()).isEqualTo("https://InarAcademy:Fk160621.@test.inar-academy.com/booking/flights");
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while validating the user is on flight selection page: {}", ex.getMessage());
            throw ex;
        }
    }

    @And("Select date as {string} and {string}")
    public void selectDate(String date1, String date2) {
        try {
            LOGGER.debug("Selecting date as {} and {}", date1, date2);
            PAGES.getFlightPages().getFlightHomePage().clickOnDatePicker();
            BrowserUtils.scrollDownWithJavaScript(0, 400);
            BrowserUtils.wait(2);
            PAGES.getFlightPages().getFlightHomePage().selectFirstDate(date1);
            PAGES.getFlightPages().getFlightHomePage().selectLastDate(date2);
        } catch (RuntimeException ex) {
            LOGGER.error("Error occurred while selecting date: {}", ex.getMessage());
            throw ex;
        }
    }
}
