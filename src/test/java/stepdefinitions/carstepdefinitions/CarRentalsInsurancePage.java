package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsInsurancePage extends BaseStep {

	@When("Click On Go To Book Element From Car Insurance Page")
	public void clickOnGoToBookElementFromCarInsurancePage() {
		PAGES.getCarPages().getCarInsurancePage().clickOnGoToBookElement();
	}

	@Then("Verify That Total Car Price Breakdown Is Accurate In Insurance Page")
	public void verifyThatTotalCarPriceBreakdownIsAccurateInInsurancePage() {
		int expectedTotalPriceWithoutTax = CarRentalsConfigPageSteps.numberOfDayForRental
				* CarRentalsConfigPageSteps.priceOfCar;
		double totalPriceWithTax = expectedTotalPriceWithoutTax
				+ (double) (expectedTotalPriceWithoutTax * percentageOfTax) / 100;
		then((int) totalPriceWithTax)
			.isEqualTo(Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheTotalPriceElement()));

	}

	static int percentageOfTax;

	@When("Get The Percentage Of Tax")
	public void getThePercentageOfTax() {
		percentageOfTax = Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheFeeAndTaxPercentage());
		System.out.println("per =" + percentageOfTax);
	}

	String locationHere;

	@When("Get The Order Details As Location Date And Hour On Insurance Page")
	public void getTheOrderDetailsAsLocationDateAndHourOnInsurancePage() {
		locationHere = PAGES.getCarPages()
			.getCarInsurancePage()
			.getPickupAddressAtTheTopOfInsurancePageFullAddressWithCountry();

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


}
