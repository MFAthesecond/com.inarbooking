package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;
import stepdefinitions.flightstepdefinitions.FlightFareSteps;
import stepdefinitions.hook.Hooks;
import utils.Pages;

public class LoginSteps extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);

    @Given("the user is on the InarAcademy Home Page")
    public void the_user_is_on_the_inar_academy_home_page() {

    }
    @When("the user click on {string} button")
    public void the_user_click_on_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Inar Booking page is displayed")
    public void inar_booking_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
