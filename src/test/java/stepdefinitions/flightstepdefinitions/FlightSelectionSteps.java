package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    public static List<String> departureFlightInfo;
    public static List<String> returnFlightInfo;
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

    @And("Select {string} for Adult dropdown")
    public void selectForAdultDropdown(String adultNum) {
        PAGES.getFlightPages().getFlightSelectionPage().selectFromAdultDropDownForRoundTrip(Integer.parseInt(adultNum));
    }

    @And("Select {string} for Children dropdown")
    public void selectForChildrenDropdown(String childNum) {
        PAGES.getFlightPages().getFlightSelectionPage().selectFromChildDropDownForRoundTrip(Integer.parseInt(childNum));
        BrowserUtils.wait(3);
    }

    @Then("Verify that {string} for origin, {string} for destination {string} for adult {string} for children dropdown is selected")
    public void verifyThatForOriginForDestinationForAdultForChildrenDropdown(String originName, String destinationName, String adultNum, String childrenNum) {
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected(originName , "Origin")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected(destinationName , "Destination")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected(adultNum , "AdultForRoundTrip")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementOnDropDownSelected(childrenNum , "ChildrenForRoundTrip")).isTrue();
    }

    @And("Verify that {string} and {string} unselected for for cabin class, {string} selected for airlines , {string} selected for duration")
    public void verifyThatAndUnselectedForForCabinClassSelectedForAirlinesSelectedForDuration(String cabinClassName1, String cabinClassName2, String airlineName, String duration) {
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementSelectedOnList(cabinClassName1 , "CabinClassForRoundTrip")).isFalse();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementSelectedOnList(cabinClassName2 , "CabinClassForRoundTrip")).isFalse();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementSelectedOnList(airlineName , "AirlinesForRoundTrip")).isTrue();
        then(PAGES.getFlightPages().getFlightSelectionPage().isElementSelectedOnList(duration , "DurationForRoundTrip")).isTrue();
    }

    @And("Select departure date as {string}")
    public void selectDepartureDateAs(String departureDate) {
        PAGES.getFlightPages().getFlightSelectionPage().selectDepartureDate(departureDate);
    }

    @And("Select return date as {string}")
    public void selectReturnDateAs(String returnDate) {
        PAGES.getFlightPages().getFlightSelectionPage().selectReturnDate(returnDate);
    }
    @Then("Verify that {string} and {string} is selected")
    public void verifyThatAndIsSelected(String departureDate, String returnDate) {
        then(PAGES.getFlightPages().getFlightSelectionPage().getSelectedDepartureDate()).isEqualTo(departureDate);
        then(PAGES.getFlightPages().getFlightSelectionPage().getSelectedReturnDate()).isEqualTo(returnDate);
    }

    @And("Get the #{int} flight information and click on select ticket button")
    public void getTheFlightInformationAndClickOnSelectTicketButton(int flightIndex) {
        departureFlightInfo = PAGES.getFlightPages().getFlightSelectionPage().getItemInformation(flightIndex);
        PAGES.getFlightPages().getFlightSelectionPage().clickOnSelectTicket(flightIndex);
    }

    @And("Get the #{int} flight information and click on select return ticket button")
    public void getTheFlightInformationAndClickOnSelectReturnTicketButton(int flightIndex) {
        returnFlightInfo = PAGES.getFlightPages().getFlightSelectionPage().getItemInformation(flightIndex);
        PAGES.getFlightPages().getFlightSelectionPage().clickOnSelectTicket(flightIndex);
    }
}
