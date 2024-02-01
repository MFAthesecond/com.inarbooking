package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import stepdefinitions.BaseStep;

public class FlightExtrasSteps extends BaseStep {


    
    @And("Click on go to checkout  button")
    public void click_on_go_to_checkout_button() {
        PAGES.getFlightPages().getFlightExtrasPage().clickOnGoToCheckOutButton();
    }
}
