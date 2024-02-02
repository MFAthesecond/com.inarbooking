package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;

public class HotelHomeSteps extends BaseStep {

	@And("Click on the Stays Tab")
	public void click_on_the_stays_tab() {
		// default login page is Stays Tab so no need for extra action.
	}

	@When("Type the destination {string} where you will be staying    And Select date as {string} and {string} days of next month")
	public void type_the_destination_where_you_will_be_staying_and_select_date_as_and_days_of_next_month(String string,
			String string2, String string3) {
		PAGES.getHomePage().clickBookingLink();

	}

}
