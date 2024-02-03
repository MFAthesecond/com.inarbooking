package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsInsurancePage extends BaseStep {


    private static final Logger logger = LogManager.getLogger(CarRentalsInsurancePage.class);
    static int percentageOfTaxAsVariable;
    static String locationHere="";
    static String nameOfCar = "";

    @When("Click On Go To Book Element From Car Insurance Page")
    public void clickOnGoToBookElementFromCarInsurancePage() {
        logger.info("Clicking on 'Go To Book' element from car insurance page");
        PAGES.getCarPages().getCarInsurancePage().clickOnGoToBookElement();
    }

    @Then("Verify That Total Car Price Breakdown Is Accurate In Insurance Page")
    public void verifyThatTotalCarPriceBreakdownIsAccurateInInsurancePage() {
        logger.info("Verifying that total car price breakdown is accurate in insurance page");
        int expectedTotalPriceWithoutTax = CarRentalsConfigPageSteps.numberOfDayForRental
                * CarRentalsConfigPageSteps.priceOfCar;
        double totalPriceWithTax = expectedTotalPriceWithoutTax
                + (double) (expectedTotalPriceWithoutTax * percentageOfTaxAsVariable) / 100;
        int actualTotalPrice = Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheTotalPriceElement());
        logger.debug("Expected total price with tax: {}", (int) totalPriceWithTax);
        logger.debug("Actual total price: {}", actualTotalPrice);
        then(actualTotalPrice).isEqualTo((int) totalPriceWithTax);
    }

    @When("Get The Percentage Of Tax")
    public void getThePercentageOfTax() {
        logger.info("Getting the percentage of tax");
        percentageOfTaxAsVariable = Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheFeeAndTaxPercentage());
        logger.debug("Percentage of tax: {}", percentageOfTaxAsVariable);
    }

    @When("Get The Order Details As Location Date And Hour On Insurance Page")
    public void getTheOrderDetailsAsLocationDateAndHourOnInsurancePage() {
        logger.info("Getting the order details as location, date, and hour on insurance page");
        locationHere = PAGES.getCarPages().getCarInsurancePage().getThePickUpLocation();
        logger.debug("Location: {}", locationHere);
    }

    @Then("Verify That Order Details Date Place Hour As Given")
    public void verifyThatOrderDetailsDatePlaceHourAsGiven() {
        logger.info("Verifying that order details date, place, hour match the given values");
        then(locationHere).isEqualTo(CarRentalsOnBookingHomePageSteps.location);
    }

    @When("Get The Name Of Car In Insurance Page")
    public void getTheNameOfCarInInsurancePage() {
        logger.info("Getting the name of the car in insurance page");
        nameOfCar = PAGES.getCarPages().getCarInsurancePage().getTheCarName()
                .substring(0, PAGES.getCarPages().getCarInsurancePage().getTheCarName().indexOf("or similar") - 2);
        logger.debug("Name of the car: {}", nameOfCar);
    }

    @Then("Verify That Program Passed To Insurance Page")
    public void verifyThatProgramPassedToInsurancePage() {
        logger.info("Verifying that the program passed to the insurance page");
        then(PAGES.getCarPages().getCarInsurancePage().getTheFeeAndTaxPercentage()).isNotNull();
    }

    @When("Get The Pick Up Date  In Car Insurance Page")
    public void get_the_pick_up_date_ın_car_ınsurance_page() {
        logger.info("Getting the pick-up date in car insurance page");
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages
                .add(PAGES.getCarPages().getCarInsurancePage().getThePickupDate());
    }

    @When("Get The Drop Off Date As  In Car Insurance Page")
    public void get_the_drop_off_date_as_ın_car_ınsurance_page() {
        logger.info("Getting the drop-off date in car insurance page");
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages
                .add(PAGES.getCarPages().getCarInsurancePage().getTheDropOffDate());
    }

    @When("Click On Extra Insurance Element In Car Rental Insurance Page")
    public void clickOnExtraInsuranceElementInCarRentalInsurancePage() {
        logger.info("Clicking on 'Extra Insurance' element in car rental insurance page");
        PAGES.getCarPages().getCarInsurancePage().clickOnWhatIsCoveredInsuranceElementOption();
    }

    @Then("Verify That Calculation Is Accurate With Extra Insurance")
    public void verifyThatCalculationIsAccurateWithExtraInsurance() {
        logger.info("Verifying that the calculation is accurate with extra insurance");
        percentageOfTaxAsVariable = Integer
                .parseInt(PAGES.getCarPages().getCarInsurancePage().getTheFeeAndTaxPercentage());
        int percentageOfExtraInsurance = Integer
                .parseInt(PAGES.getCarPages().getCarInsurancePage().getTheTotalCoverPricePercentage());
        int expectedTotalPriceWithoutTax = CarRentalsConfigPageSteps.numberOfDayForRental
                * CarRentalsConfigPageSteps.priceOfCar;
        double totalPriceWithTax = expectedTotalPriceWithoutTax
                + (double) (expectedTotalPriceWithoutTax * percentageOfExtraInsurance) / 100
                + (double) (expectedTotalPriceWithoutTax * percentageOfTaxAsVariable) / 100;
        int actualTotalPrice = Integer.parseInt(
                PAGES.getCarPages().getCarInsurancePage().getTheTotalPriceElement());
        logger.debug("Expected total price with extra insurance and tax: {}", (int) totalPriceWithTax);
        logger.debug("Actual total price: {}", actualTotalPrice);
        then(actualTotalPrice).isEqualTo((int) totalPriceWithTax);
    }
}
