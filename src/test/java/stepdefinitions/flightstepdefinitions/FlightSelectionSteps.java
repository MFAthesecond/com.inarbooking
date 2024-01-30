package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

public class FlightSelectionSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(FlightSelectionSteps.class);
    @And("Unselect {string} and Unselect {string} for cabin class")
    public void unselectAndUnselectForCabinClass(String classType1, String classType2) {
        PAGES.getFlightPages().getFlightSelectionPage().selectCabinClass(classType1);
        PAGES.getFlightPages().getFlightSelectionPage().selectCabinClass(classType2);
    }

    @And("Select {string} for airlines")
    public void selectForAirlines(String airlinesType) {
        PAGES.getFlightPages().getFlightSelectionPage().selectAirlines(airlinesType);
    }

    @And("Select {string} for duration \\(hours)")
    public void selectForDurationHours(String duration) {
        PAGES.getFlightPages().getFlightSelectionPage().selectDurationHours(duration);
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

}
