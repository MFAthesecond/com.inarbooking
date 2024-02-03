package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsInsurancePage extends BaseStep {
    String locationHere;

    @When("Click On Go To Book Element From Car Insurance Page")
    public void clickOnGoToBookElementFromCarInsurancePage() {
        PAGES.getCarPages().getCarInsurancePage().clickOnGoToBookElement();
    }

    @Then("Verify That Total Car Price Breakdown Is Accurate In Insurance Page")
    public void verifyThatTotalCarPriceBreakdownIsAccurateInInsurancePage() {
        int expectedTotalPriceWithoutTax = CarRentalsConfigPageSteps.numberOfDayForRental
                * CarRentalsConfigPageSteps.priceOfCar;
        double totalPriceWithTax = expectedTotalPriceWithoutTax
                + (double) (expectedTotalPriceWithoutTax * percentageOfTaxAsVariable) / 100;
        then((int) totalPriceWithTax)
                .isEqualTo(Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheTotalPriceElement()));

    }

    static int percentageOfTaxAsVariable;

    @When("Get The Percentage Of Tax")
    public void getThePercentageOfTax() {
        percentageOfTaxAsVariable = Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheFeeAndTaxPercentage());
    }


    @When("Get The Order Details As Location Date And Hour On Insurance Page")
    public void getTheOrderDetailsAsLocationDateAndHourOnInsurancePage() {
        locationHere = PAGES.getCarPages()
                .getCarInsurancePage()
                .getTheDropOffDate();

    }

    @Then("Verify That Order Details Date Place Hour As Given")
    public void verifyThatOrderDetailsDatePlaceHourAsGiven() {
        then(locationHere).isEqualTo(CarRentalsOnBookingHomePageSteps.location);
    }

    static String nameOfCar = "";

    @When("Get The Name Of Car In Insurance Page")
    public void getTheNameOfCarInInsurancePage() {
        nameOfCar = PAGES.getCarPages()
                .getCarInsurancePage()
                .getTheCarName()
                .substring(0, PAGES.getCarPages().getCarInsurancePage().getTheCarName().indexOf("or similar") - 2);
    }

    @Then("Verify That Program Passed To Insurance Page")
    public void verifyThatProgramPassedToInsurancePage() {
        then(PAGES.getCarPages().getCarInsurancePage().getTheFeeAndTaxPercentage()).isNotNull();
    }

    @When("Get The Pick Up Date  In Car Insurance Page")
    public void get_the_pick_up_date_ın_car_ınsurance_page() {
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages.add(PAGES.getCarPages().getCarInsurancePage().getThePickupDate());
    }

    @When("Get The Drop Off Date As  In Car Insurance Page")
    public void get_the_drop_off_date_as_ın_car_ınsurance_page() {
        CarRentalsOnBookingHomePageSteps.pickUpDateInDifferentPages.add(PAGES.getCarPages().getCarInsurancePage().getTheDropOffDate());

    }

    @When("Click On Extra Insurance Element In Car Rental Insurance Page")
    public void clickOnExtraInsuranceElementInCarRentalInsurancePage() {
        PAGES.getCarPages().getCarInsurancePage().clickOnWhatIsCoveredInsuranceElementOption();
    }

    @Then("Verify That Calculation Is Accurate With Extra Insurance")
    public void verifyThatCalculationIsAccurateWithExtraInsurance() {
        percentageOfTaxAsVariable = Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheFeeAndTaxPercentage());
        int percentageOfExtraInsurance = Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheTotalCoverPricePercentage());
        int expectedTotalPriceWithoutTax = CarRentalsConfigPageSteps.numberOfDayForRental
                * CarRentalsConfigPageSteps.priceOfCar;
        double totalPriceWithTax = expectedTotalPriceWithoutTax + (double) (expectedTotalPriceWithoutTax * percentageOfExtraInsurance) / 100
                + (double) (expectedTotalPriceWithoutTax * percentageOfTaxAsVariable) / 100;
        then((int) totalPriceWithTax)
                .isEqualTo(Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheTotalPriceElement()));

    }
}
