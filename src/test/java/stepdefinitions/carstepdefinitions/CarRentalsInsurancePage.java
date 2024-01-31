package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;

public class CarRentalsInsurancePage extends BaseStep {
    @When("Click On Go To Book Element From Car Insurance Page")
    public void clickOnGoToBookElementFromCarInsurancePage() {
        PAGES.getCarPages().getCarInsurancePage().clickOnGoToBookElement();
    }
}
