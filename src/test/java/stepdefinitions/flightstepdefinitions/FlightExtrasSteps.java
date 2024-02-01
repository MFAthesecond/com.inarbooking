package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightExtrasSteps extends BaseStep {
    @And("Click on go to checkout  button")
    public void click_on_go_to_checkout_button() {
        PAGES.getFlightPages().getFlightExtrasPage().clickOnGoToCheckOutButton();
    }

    @And("Select {string} , {string} , {string}")
    public void select(String mealName, String extra1Name, String extra2Name) {
        BrowserUtils.scrollDownWithJavaScript(0 , -600);
        PAGES.getFlightPages().getFlightExtrasPage().selectMeal(mealName);
        PAGES.getFlightPages().getFlightExtrasPage().selectExtra(extra1Name);
        PAGES.getFlightPages().getFlightExtrasPage().selectExtra(extra2Name);
    }

    @Then("Verify that {string} , {string} , {string} is selected")
    public void verifyThatIsSelected(String mealName, String extra1Name, String extra2Name) {
        then(PAGES.getFlightPages().getFlightExtrasPage().isMealSelected(mealName)).isTrue();
        then(PAGES.getFlightPages().getFlightExtrasPage().isExtraSelected(extra1Name)).isTrue();
        then(PAGES.getFlightPages().getFlightExtrasPage().isExtraSelected(extra2Name)).isTrue();
    }

    @Then("Verify that total price calculation is correct after {string} , {string} , {string} selections")
    public void verifyThatTotalPriceCalculationIsCorrectAfterSelections(String mealName, String extra1Name, String extra2Name) {
        String mealPrice = PAGES.getFlightPages().getFlightExtrasPage().getMealPrice(mealName);
        String extra1Price = PAGES.getFlightPages().getFlightExtrasPage().getExtraPrice(extra1Name);
        String extra2Price = PAGES.getFlightPages().getFlightExtrasPage().getExtraPrice(extra2Name);
        double totalPrice = PAGES.getFlightPages().getFlightExtrasPage().getCalculatedTotalPrice();
        double expectedTotalPrice = totalPrice + Double.parseDouble(mealPrice) + Double.parseDouble(extra1Price) + Double.parseDouble(extra2Price);
        double actualTotalPrice = Double.parseDouble(PAGES.getFlightPages().getFlightExtrasPage().getTotalPrice());
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }
}
