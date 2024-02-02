package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class HotelYoursDetailsSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(HotelYoursDetailsSteps.class);

    @When("Click on the search hotels button")
    public void click_on_the_search_hotels_button() {
        PAGES.getHotelPages().getHotelPage().clickOnSearchButton();
        LOGGER.debug("Click on search button");
    }


    @And("Click on the reserve or book now button")
    public void click_on_the_reserve_or_book_now_button() {
        PAGES.getHotelPages().getHotelDetailsPage().clickOnReserveButton();
        LOGGER.debug("Click on the reserve or book now button");
    }

    @And("Click on the no checkbox for are you traveling for business")
    public void click_on_the_no_checkbox_for_are_you_traveling_for_business() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().clickOnNoCheckbox();
        LOGGER.debug("Click on 'No' checkbox for traveling for business");

    }

    @And("Click on the I'm the main guest for checkbox")
    public void click_on_the_i_m_the_main_guest_for_checkbox() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().clickOnGuestCheckbox();
    }

    @And("Fill in first name {string} last name {string} for visitor")
    public void fillInFirstNameLastNameForVisitor(String firstName, String lastName) {
        PAGES.getHotelPages().getHotelsYourDetailsPage().enterFirstName("Nisanur");
        PAGES.getHotelPages().getHotelsYourDetailsPage().enterLastName("Altuntas");
    }


    @And("Fill in {string} as contact email")
    public void fill_in_contact_email(String email) {
        PAGES.getHotelPages().getHotelsYourDetailsPage().fillInContactEmail("nialandin@gmail.com");
    }

    @And("Write that you have no {string} requests")
    public void write_that_you_have_no_requests(String string) {
        PAGES.getHotelPages().getHotelsYourDetailsPage().setRequestsText("I don't have any requests");
    }

    @And("Choose unknown from the arrival time options")
    public void choose_unknown_from_the_arrival_time_options() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().setArrivalTime(1);
    }

    @And("Click on the next, final details button")
    public void click_on_the_next_final_details_button() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().clickOnNextButton();

    }

    @Then("Verify that you can pass the final step page")
    public void verify_that_you_can_pass_the_final_step_page() {
        boolean isCountryCodeSelectDisplayed = PAGES.getHotelPages().getHotelsFinalStep().countryCodeSelect.isDisplayed();
        assertThat(isCountryCodeSelectDisplayed)
                .as("Verify that the final step page is passed successfully").isTrue();
        LOGGER.info("Final step passed successfully");
    }


    @When("Choose your arrival time between 10 and 11")
    public void select_arrival_time_between_pm_and_pm() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().setArrivalTime(2);

    }

    @Then("Click on the close button")
    public void click_on_the_close_button() {
        PAGES.getHotelPages().getHotelConfirmationPage().clickOnTheCloseButton();

    }

    @Then("You will confirm that you have successfully navigated to the confirmation page")
    public void you_will_confirm_that_you_have_successfully_navigated_to_the_confirmation_page() {
        String actualTitle = PAGES.getHotelPages().getHotelConfirmationPage().getHotelTitle();
        String expectedTitle = "Coastal Breeze Inn";
        assertThat(actualTitle)
                .as("Verify that the confirmation page title is correct")
                .isEqualTo(expectedTitle);
    }
}



