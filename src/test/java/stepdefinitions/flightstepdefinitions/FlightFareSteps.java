package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightFareSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(FlightFareSteps.class);

    @Then("Verify that the user on flight fare page")
    public void verifyThatTheUserOnFlightFarePage() {
        then(PAGES.getFlightPages().getFlightFarePage().getContainerInstruction("departure")).isEqualTo("Choose your fare");
    }
    @And("Click on select who's flying button")
    public void click_on_select_who_s_flying_button() {
        PAGES.getFlightPages().getFlightFarePage().clickOnSelectWhoFlyingButton();

    }
}
