package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import stepdefinitions.BaseStep;

public class FlightConfirmationSteps extends BaseStep {
    @Then("Validate the user is on confirmation page")
    public void validateTheUserIsOnConfirmationPage() {
        Assertions.assertThat(PAGES.getFlightPages().getFlightConfirmationPage().isConfirmationMessageDisplayed()).isTrue();
    }
}
