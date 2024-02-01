package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import stepdefinitions.BaseStep;

public class CarRentalsInsurancePageSteps extends BaseStep {
    @When("Click On Go To Book Element From Car Insurance Page")
    public void clickOnGoToBookElementFromCarInsurancePage() {
        PAGES.getCarPages().getCarInsurancePage().clickOnGoToBookElement();
    }

    @When("Verify That Total Car Price Breakdown Is Accurate In Isurance Page")
    public void verifyThatTotalCarPriceBreakdownIsAccurateInIsurancePage() {
      int numberOfDays =  PAGES.getCarPages().getCarConfigs().getTheNumberOfDays();
      int dailyPriceOfSelectedCar = PAGES.getCarPages().getCarConfigsRight().getTheSelectedCarPrice();
      int getTheFeePercentage =Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheFeeAndTaxPercentage());
        System.out.println(numberOfDays);
        System.out.println(dailyPriceOfSelectedCar);
        System.out.println(getTheFeePercentage);

      int expectedCarPrice = numberOfDays*dailyPriceOfSelectedCar+(numberOfDays*dailyPriceOfSelectedCar*getTheFeePercentage/100);
        System.out.println(expectedCarPrice);

      int actualTotalTotalCarPriceBreakdown = Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheTotalPriceElement());
        System.out.println(actualTotalTotalCarPriceBreakdown);
        Assertions.assertThat(expectedCarPrice).isEqualTo(actualTotalTotalCarPriceBreakdown);

    }
}
