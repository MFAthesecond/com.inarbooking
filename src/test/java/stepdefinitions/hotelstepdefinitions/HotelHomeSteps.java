package stepdefinitions.hotelstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;

public class HotelHomeSteps extends BaseStep {
    @And("Click on the Stays Tab")
    public void click_on_the_stays_tab() {
       //default login page is Stays Tab so no need for extra action.
    }
}
