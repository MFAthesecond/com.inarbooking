package stepdefinitions.flightstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;

import static org.assertj.core.api.BDDAssertions.then;

public class FlightExtrasSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(FlightExtrasSteps.class);

    public static String totalPriceOnExtrasPage;
    @And("Click on go to checkout  button")
    public void click_on_go_to_checkout_button() {
        try {
            LOGGER.debug("Clicking on go to checkout button.");
            PAGES.getFlightPages().getFlightExtrasPage().clickOnGoToCheckOutButton();
            LOGGER.debug("Go to checkout button clicked successfully.");
        } catch (Exception e) {
            LOGGER.error("Error occurred while clicking on go to checkout button.", e);
            throw e;
        }
    }

    @And("Select {string} , {string} , {string}")
    public void select(String mealName, String extra1Name, String extra2Name) {
        try {
            LOGGER.debug("Selecting meal: {}, extra 1: {}, extra 2: {}.", mealName, extra1Name, extra2Name);
            BrowserUtils.scrollDownWithJavaScript(0 , -600);
            PAGES.getFlightPages().getFlightExtrasPage().selectMeal(mealName);
            BrowserUtils.wait(1);
            PAGES.getFlightPages().getFlightExtrasPage().selectExtra(extra1Name);
            BrowserUtils.wait(1);
            PAGES.getFlightPages().getFlightExtrasPage().selectExtra(extra2Name);
            LOGGER.debug("Selection completed successfully.");
        } catch (Exception e) {
            LOGGER.error("Error occurred while making selections.", e);
            throw e;
        }
    }

    @Then("Verify that {string} , {string} , {string} is selected")
    public void verifyThatIsSelected(String mealName, String extra1Name, String extra2Name) {
        try {
            LOGGER.debug("Verifying selections - meal: {}, extra 1: {}, extra 2: {}.", mealName, extra1Name, extra2Name);
            then(PAGES.getFlightPages().getFlightExtrasPage().isMealSelected(mealName))
                    .as("Meal selection check for " + mealName)
                    .isTrue();

            then(PAGES.getFlightPages().getFlightExtrasPage().isExtraSelected(extra1Name))
                    .as("Extra 1 selection check for " + extra1Name)
                    .isTrue();

            then(PAGES.getFlightPages().getFlightExtrasPage().isExtraSelected(extra2Name))
                    .as("Extra 2 selection check for " + extra2Name)
                    .isTrue();
            LOGGER.debug("Verification successful.");
        } catch (Exception e) {
            LOGGER.error("Error occurred while verifying selections.", e);
            throw e;
        }
    }

    @Then("Verify that total price calculation is correct after {string} , {string} , {string} selections")
    public void verifyThatTotalPriceCalculationIsCorrectAfterSelections(String mealName, String extra1Name, String extra2Name) {
        try {
            LOGGER.debug("Verifying total price calculation after selections - meal: {}, extra 1: {}, extra 2: {}.", mealName, extra1Name, extra2Name);
            String mealPrice = PAGES.getFlightPages().getFlightExtrasPage().getMealPrice(mealName);
            String extra1Price = PAGES.getFlightPages().getFlightExtrasPage().getExtraPrice(extra1Name);
            String extra2Price = PAGES.getFlightPages().getFlightExtrasPage().getExtraPrice(extra2Name);
            double totalPrice = PAGES.getFlightPages().getFlightExtrasPage().getCalculatedTotalPrice();
            double expectedTotalPrice = 0;
            if(!extra1Name.equals("Travel Insurance") && !extra2Name.equals("Travel Insurance")) {
                 expectedTotalPrice = totalPrice + FlightHomeSteps.totalTravelerNumber * (Double.parseDouble(extra1Price) + Double.parseDouble(extra2Price) + Double.parseDouble(mealPrice));
            }else if(extra1Name.equals("Travel Insurance")){
                expectedTotalPrice = totalPrice + Double.parseDouble(extra1Price) + FlightHomeSteps.totalTravelerNumber * (Double.parseDouble(extra2Price) + Double.parseDouble(mealPrice));
            }else{
                expectedTotalPrice = totalPrice +  FlightHomeSteps.totalTravelerNumber * (Double.parseDouble(extra1Price) + Double.parseDouble(mealPrice)) + Double.parseDouble(extra2Price);
            }
            double actualTotalPrice = Double.parseDouble(PAGES.getFlightPages().getFlightExtrasPage().getTotalPrice());
            totalPriceOnExtrasPage = String.valueOf(actualTotalPrice);
            then(PAGES.getFlightPages().getFlightExtrasPage().getTotalPrice()).isEqualTo(String.format("%.2f", expectedTotalPrice));
            LOGGER.debug("Verification successful.");
        } catch (Exception e) {
            LOGGER.error("Error occurred while verifying total price calculation.", e);
            throw e;
        }
    }

    @Then("Verify that the user is on Flight Extras Page")
    public void verifyThatTheUserIsOnFlightExtrasPage() {
        try {
            boolean isInstructionDisplayed = PAGES.getFlightPages().getFlightExtrasPage().isInstructionDisplayed();
            LOGGER.debug("Verifying that the user is on Flight Extras Page...");
            then(isInstructionDisplayed).isTrue();
            LOGGER.debug("User is on Flight Extras Page.");
        } catch (Exception e) {
            LOGGER.error("Error while verifying that the user is on Flight Extras Page: {}", e.getMessage());
            throw e;
        }
    }
}
