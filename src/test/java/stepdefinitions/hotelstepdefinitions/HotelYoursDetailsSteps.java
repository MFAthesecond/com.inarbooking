package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;


public class HotelYoursDetailsSteps extends BaseStep {

    private static final Logger LOGGER = LogManager.getLogger(HotelYoursDetailsSteps.class);

    @When("Click on the search hotels button")
    public void click_on_the_search_hotels_button() {
        PAGES.getHotelPages().getHotelPage().clickOnSearchButton();
        LOGGER.debug("Click on search button");
    }
    @And("Click on the see availability button for #{int} hotel")
    public void click_on_the_see_availability_button_for_hotel(Integer hotelIndex) {
        PAGES.getHotelPages().getHotelSelectionPage().clickOnSeeAvailability(hotelIndex);
    }
    @And("Click on the reserve or book now button")
    public void click_on_the_reserve_or_book_now_button() {
        PAGES.getHotelPages().getHotelDetailsPage().clickOnReserveButton();
        LOGGER.debug("Click on search button");
    }
    @And("Click on the no checkbox for are you traveling for business")
    public void click_on_the_no_checkbox_for_are_you_traveling_for_business() {
        PAGES.getHotelPages().getHotelsYourDetailsPage().clickOnNoCheckbox();
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
    public void fill_in_contact_email(String email)  {
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
       PAGES.getHotelPages().getHotelsFinalStep().countryCodeSelect.isDisplayed();
    }


}
