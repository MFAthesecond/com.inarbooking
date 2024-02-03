package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import stepdefinitions.flightstepdefinitions.FlightHomeSteps;

public class HotelBookingSteps extends BaseStep {

	private static final Logger LOGGER = LogManager.getLogger(HotelBookingSteps.class);

	@When("Type the destination {string} where you will be staying")
	public void type_the_destination_where_you_will_be_staying(String destination) {
		PAGES.getHotelPages().getHotelPage().selectDestination(destination);
		LOGGER.debug("Select destination");
	}

	@When("Select date as {string} and {string} days of next")
	public void select_date_as_and_days_of_next(String firstDate, String lastDate) {
		PAGES.getHotelPages().getHotelPage().selectMonth(4);
		PAGES.getHotelPages().getHotelPage().selectFirstDay(firstDate);
		LOGGER.debug("Select first date");
		PAGES.getHotelPages().getHotelPage().selectLastDay(lastDate);
		LOGGER.debug("Select last day");
	}

	@When("Select {string} adults and {string} child and {string}room")
	public void select_adults_and_child_and_room(String adults, String children, String rooms) {
		PAGES.getHotelPages().getHotelPage().clickOnVisitors();
		PAGES.getHotelPages().getHotelPage().selectAdultNumber(adults);
		LOGGER.debug("Set adults number:{} ", Integer.parseInt(adults));
		PAGES.getHotelPages().getHotelPage().selectChildrenNumber(children);
		LOGGER.debug("Set children number:{} ", Integer.parseInt(children));
		PAGES.getHotelPages().getHotelPage().selectRoomNumber(Integer.parseInt(rooms));
		LOGGER.debug("Set rooms number:{} ", Integer.parseInt(rooms));

	}

	@When("click on search flight button")
	public void click_on_search_flight_button() {
		PAGES.getHotelPages().getHotelPage().clickOnSearchButton();
		LOGGER.debug("Click on search button");
	}

	@Then("Validate the user is on hotel selection page")
	public void validate_the_user_is_on_hotel_selection_page() {
		PAGES.getHotelPages().getHotelSelectionPage().validateNavigationToHotelSelectionPage();
		LOGGER.debug("Validated that the user is on the hotel selection page");
	}

}
