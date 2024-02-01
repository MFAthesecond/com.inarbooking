package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.devtools.v85.page.Page;
import pages.carpages.CarConfigsRight;
import stepdefinitions.BaseStep;

import java.util.HashMap;

import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsInsurancePage extends BaseStep {
    @When("Click On Go To Book Element From Car Insurance Page")
    public void clickOnGoToBookElementFromCarInsurancePage() {
        PAGES.getCarPages().getCarInsurancePage().clickOnGoToBookElement();
    }

    @Then("Verify That Total Car Price Breakdown Is Accurate In Insurance Page")
    public void verifyThatTotalCarPriceBreakdownIsAccurateInInsurancePage() {
        System.out.println("hesap " + CarRentalsConfigPage.numberOfDayForRental * CarRentalsConfigPage.priceOfCar);
        int expectedTotalPriceWithoutTax = CarRentalsConfigPage.numberOfDayForRental * CarRentalsConfigPage.priceOfCar;
        double totalPriceWithTax = expectedTotalPriceWithoutTax + (double) (expectedTotalPriceWithoutTax * percentageOfTax) / 100;
        then((int) totalPriceWithTax).isEqualTo(Integer.parseInt(PAGES.getCarPages().getCarInsurancePage().getTheTotalPriceElement()));

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
        System.out.println(PAGES.getCarPages().getCarInsurancePage().getTheCarName());
        System.out.println(PAGES.getCarPages().getCarInsurancePage().getTheDropOffDate());
        System.out.println(PAGES.getCarPages().getCarInsurancePage().getThePickUpLocation());
        System.out.println(PAGES.getCarPages().getCarInsurancePage().getTheDropOffLocation());
        locationHere = PAGES.getCarPages().getCarInsurancePage().getPickupAddressAtTheTopOfInsurancePageFullAddressWithCountry();
        System.out.println("Loca ="+ locationHere);

    }



    @Then("Verify That Order Details Date Place Hour As Given")
    public void verifyThatOrderDetailsDatePlaceHourAsGiven() {
        then(locationHere).isEqualTo(CarRentalsOnBookingHomePage.location);
    }
}
