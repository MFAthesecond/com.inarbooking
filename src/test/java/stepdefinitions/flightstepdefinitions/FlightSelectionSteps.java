package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightSelectionSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(FlightSelectionSteps.class);

    private List<Double> flightRanking;
    @And("Unselect {string} and Unselect {string} for cabin class")
    public void unselectAndUnselectForCabinClass(String classType1, String classType2) {
        PAGES.getFlightPages().getFlightSelectionPage().selectCabinClassForRoundTrip(classType1);
        PAGES.getFlightPages().getFlightSelectionPage().selectCabinClassForRoundTrip(classType2);
    }

    @And("Select {string} for airlines")
    public void selectForAirlines(String airlinesType) {
        PAGES.getFlightPages().getFlightSelectionPage().selectAirlinesForRoundTrip(airlinesType);
    }

    @And("Select {string} for duration \\(hours)")
    public void selectForDurationHours(String duration) {
        PAGES.getFlightPages().getFlightSelectionPage().selectDurationHoursForRoundTrip(duration);
    }

    @And("Click on search button")
    public void clickOnSearchButton() {
        PAGES.getFlightPages().getFlightSelectionPage().clickOnSearchButton();
    }
    @And("Click on select ticket button for #{int} flight")
    public void clickOnSelectTicketButtonFor(int flightIndex) {
        try {
            BrowserUtils.wait(1);
            PAGES.getFlightPages().getFlightSelectionPage().clickOnSelectTicket(flightIndex);
        }catch (UnsupportedOperationException ex){
            LOGGER.error("There is no flight item for the flight index");
            throw ex;
        }
    }

    @And("Click on {string} tab")
    public void clickOnTab(String tabName) {
        if(tabName.equals("Fastest")){
            flightRanking = PAGES.getFlightPages().getFlightSelectionPage().getFlightHours();
        }else {
            flightRanking = PAGES.getFlightPages().getFlightSelectionPage().getFlightPrices();
        }
        PAGES.getFlightPages().getFlightSelectionPage().clickOnTab(tabName);
    }

    @Then("Verify that the the cheapest flight is the first flight")
    public void verifyThatTheTheCheapestFlightIsTheFirstFlight() {
        List<Double> flightPricesAfterCheapest = PAGES.getFlightPages().getFlightSelectionPage().getFlightPrices();
        Collections.sort(flightRanking);
        then(flightPricesAfterCheapest).isEqualTo(flightRanking);
    }

    @Then("Verify that the the fastest flight is the first flight")
    public void verifyThatTheTheFastestFlightIsTheFirstFlight() {
        List<Double> flightPricesAfterFastest = PAGES.getFlightPages().getFlightSelectionPage().getFlightHours();
        Collections.sort(flightRanking);
        then(flightPricesAfterFastest).isEqualTo(flightRanking);
    }

    @And("Click on select return ticket button for #{int} flight")
    public void clickOnSelectReturnTicketButtonForFlight(int flightIndex) {
        PAGES.getFlightPages().getFlightSelectionPage().clickOnSelectTicket(flightIndex);
    }

    @And("Select {string} from origin drop down")
    public void selectFromOriginDropDown(String originName) {
        PAGES.getFlightPages().getFlightSelectionPage().selectFromOriginDropDown(originName);
    }

    @And("Select {string} from destination drop down")
    public void selectFromDestinationDropDown(String destinationName) {
        PAGES.getFlightPages().getFlightSelectionPage().selectFromDestinationDropDown(destinationName);
    }

    @And("Select #{int} for Adult dropdown")
    public void selectForAdultDropdown(int adultNum) {
        PAGES.getFlightPages().getFlightSelectionPage().selectFromAdultDropDownForRoundTrip(adultNum);
    }

    @And("Select #{int} for Children dropdown")
    public void selectForChildrenDropdown(int childNum) {
        PAGES.getFlightPages().getFlightSelectionPage().selectFromChildDropDownForRoundTrip(childNum);
        BrowserUtils.wait(3);
    }

    @Then("Verify that all selected items as requested")
    public void verifyThatAllSelectedItemsAsRequested() {
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected("Italy" , "Origin")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected("Germany" , "Destination")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected("5" , "AdultForRoundTrip")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected("7" , "ChildrenForRoundTrip")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementSelectedOnList("First Class" , "CabinClassForRoundTrip")).isFalse();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementSelectedOnList("Business" , "CabinClassForRoundTrip")).isFalse();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementSelectedOnList("Airline Z" , "AirlinesForRoundTrip")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementSelectedOnList("6 hours" , "DurationForRoundTrip")).isTrue();
    }
}
