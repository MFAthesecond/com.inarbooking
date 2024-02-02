package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;
import stepdefinitions.BaseStep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.WithAssertions;
import static org.assertj.core.api.Assertions.assertThat;

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

    @When("Select {string} and {string} for hotels")
    public void select_and_for_hotels(String selection1, String selection2) {
        PAGES.getHotelPages().getHotelSelectionPage().selectHotelTypes(Arrays.asList(selection1, selection2));
    }

    @And("Select {string} select {string} for additional features")
    public void selectSelectForAdditionalFeatures(String arg0, String arg1) {
        PAGES.getHotelPages().getHotelSelectionPage().selectAdditionalFeatures(Arrays.asList(arg0, arg1));
        LOGGER.debug("Click on {} and {} button", arg0, arg1);
    }

    @And("Select {string} for hotels")
    public void selectForHotels(String selection1) {
        PAGES.getHotelPages().getHotelSelectionPage().selectHotelTypes(Arrays.asList(selection1));
    }

    @And("Select {string} for number of bedrooms spinner overflow")
    public void selectForNumberOfBedroomsSpinnerOverflow(String rooms) {
        PAGES.getHotelPages().getHotelSelectionPage().setRoomNumber(Integer.parseInt(rooms));
    }

    @Then("Verify that destination is written as {string}, {string} for adult {string} for child")
    public void verifyThatDestinationIsWrittenAsForAdultForChild(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {

    }

    @Then("Verify that {string} and {string} for fun things to do are selected")
    public void verifyThatAndForFunThingsToDoAreSelected(String arg0, String arg1) {
        assertThat(PAGES.getHotelPages().getHotelDetailsPage().validateHotelAspects(Arrays.asList(arg0, arg1))).isTrue();
    }

    @And("Verify that {string} selected")
    public void verifyThatSelected(String arg0) {
        assertThat(arg0.toString()).isEqualTo(PAGES.getHotelPages().getHotelDetailsPage().getHotelName());
    }
}
