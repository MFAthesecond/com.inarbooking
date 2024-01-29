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
       PAGES.getFlightPages().getFlightHomePage().clickOnFlightTab();
        try {
            LOGGER.debug("Navigated to the Flight Tab");
        }catch (RuntimeException ex){
            LOGGER.error("The tab could not found and the exception " + ex.getClass());
            throw ex;
        }
    }
    @And("Click on round trip checkbox")
    public void click_on_round_trip_checkbox() {
        PAGES.getFlightPages().getFlightHomePage().clickOnRoundTripAndOneWayRadioButton("Round Trip");
        try {
            LOGGER.debug("The trip type is selected");
        }catch (RuntimeException ex){
            LOGGER.error("The checkbox element could not be clicked" + ex.getClass());
            throw ex;
        }
    }
    @And("Select {string} for flight class")
    public void select_for_flight_class(String string) {
        PAGES.getFlightPages().getFlightHomePage().selectFlightClassesDropDown(string);
        try {
            LOGGER.debug("The trip type is selected");
        }catch (RuntimeException ex){
            LOGGER.error("The checkbox element could not be clicked" + ex.getClass());
            throw ex;
        }
    }
    @And("Select {string} for from dropdown and select {string} for to dropdown")
    public void select_for_from_dropdown_and_select_for_to_dropdown(String countryName1, String countryName2) {
        PAGES.getFlightPages().getFlightHomePage().selectFromDropDown(countryName1);
        PAGES.getFlightPages().getFlightHomePage().selectToDropDown(countryName2);
    }
    @And("Select date as #{int} and #{int} days of next month")
    public void select_date_as_and_days_of_next_month(Integer day1, Integer day2) {
        PAGES.getFlightPages().getFlightHomePage().clickOnDatePicker();
        PAGES.getFlightPages().getFlightHomePage().clickOnNextButton();
        BrowserUtils.scrollDownWithJavaScript(0 , 400);
        BrowserUtils.wait(2);
        PAGES.getFlightPages().getFlightHomePage().clickOnDayByIndex(day1);
        PAGES.getFlightPages().getFlightHomePage().clickOnDayByIndex(day2);
    }
    @And("Select {int} adults and {int} child and click on search flight button")
    public void select_adults_and_child_and_click_on_search_flight_button(Integer adultNum, Integer childNum) {
        BrowserUtils.scrollDownWithJavaScript(0 , -400);
        BrowserUtils.wait(2);
        PAGES.getFlightPages().getFlightHomePage().clickOnPassengersOptionsItem();
        PAGES.getFlightPages().getFlightHomePage().clickOnAdultCounterNumber(adultNum);
        PAGES.getFlightPages().getFlightHomePage().clickOnChildrenCounterNumber(childNum);
        PAGES.getFlightPages().getFlightHomePage().clickOnSearchFlightButton();
    }
    @Then("Validate the user is on flight selection page")
    public void validate_the_user_is_on_flight_selection_page() {
       then(DRIVER.getCurrentUrl()).isEqualTo("https://InarAcademy:Fk160621.@test.inar-academy.com/booking/flights");
    }

    @And("Select date as {string} and {string} days of next month")
    public void selectDateAsAndDaysOfNextMonth(String day1, String day2) {
        PAGES.getFlightPages().getFlightHomePage().clickOnDatePicker();
        PAGES.getFlightPages().getFlightHomePage().clickOnNextButton();
        BrowserUtils.scrollDownWithJavaScript(0 , 400);
        BrowserUtils.wait(2);
        PAGES.getFlightPages().getFlightHomePage().clickOnDayByIndex(Integer.parseInt(day1));
        PAGES.getFlightPages().getFlightHomePage().clickOnDayByIndex(Integer.parseInt(day2));
    }

    @And("Select {string} adults and {string} child and click on search flight button")
    public void selectAdultsAndChildAndClickOnSearchFlightButton(String adultNum, String childNum) {
        BrowserUtils.scrollDownWithJavaScript(0 , -400);
        BrowserUtils.wait(2);
        PAGES.getFlightPages().getFlightHomePage().clickOnPassengersOptionsItem();
        PAGES.getFlightPages().getFlightHomePage().clickOnAdultCounterNumber(Integer.parseInt(adultNum));
        PAGES.getFlightPages().getFlightHomePage().clickOnChildrenCounterNumber(Integer.parseInt(childNum));
        PAGES.getFlightPages().getFlightHomePage().clickOnSearchFlightButton();
    }
}
