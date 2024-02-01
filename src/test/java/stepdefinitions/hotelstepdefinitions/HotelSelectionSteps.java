package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;
import stepdefinitions.BaseStep;

import java.util.ArrayList;
import java.util.List;

public class HotelSelectionSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(HotelSelectionSteps.class);

    @Given("Navigation to the Hotel Details Page")
    public void navigation_to_the_hotel_details_page() {
        PAGES.getHotelPages().getHotelPage().clickOnSearchButton();
        LOGGER.debug("Click on search button");
    }

    @When("Choose {string} where to stay")
    public void choose_where_to_stay(String destination) {
        PAGES.getHotelPages().getHotelSelectionPage().selectDestination(destination);
    }

    @When("Click on search hotels button")
    public void click_on_search_hotels_button() {
        PAGES.getHotelPages().getHotelSelectionPage().clickOnSearchButton();
    }

    @When("Select {string} and select {string} for fun things to do")
    public void select_and_select_for_fun_things_to_do(String thing1, String thing2) {
        List<String> thingsList = new ArrayList<>();
        thingsList.add(thing1);
        thingsList.add(thing2);
        PAGES.getHotelPages().getHotelSelectionPage().selectThingsToDo(thingsList);
        LOGGER.debug("Click on {} and {} buttons", thing1, thing2);
    }

    @When("Select {string} for additional features")
    public void select_for_additional_features(String additional) {
        List<String> additionals = new ArrayList<>();
        additionals.add(additional);
        PAGES.getHotelPages().getHotelSelectionPage().selectAdditionalFeatures(additionals);
        LOGGER.debug("Click on {} button", additional);
    }

    @When("Click on the see availability button for #{int} hotel")
    public void click_on_the_see_availability_button_for_hotel(Integer index) {
        PAGES.getHotelPages().getHotelSelectionPage().clickOnSeeAvailabilityButton(index);

    }

    @Then("Verify that the user is on the details page")
    public void verify_that_the_user_is_on_the_details_page() {
        PAGES.getHotelPages().getHotelDetailsPage().validateNavigateToDetailsPage();
    }
//    @When("Select {string} and {string} for hotels and click on search button")
//    public void select_and_for_hotels_and_click_on_search_button(String string, String string2) {
////        PAGES.getHotelPages().getHotelSelectionPage().
//    }


}
