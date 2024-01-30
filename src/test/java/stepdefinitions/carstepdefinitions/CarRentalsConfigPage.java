package stepdefinitions.carstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;


import static org.assertj.core.api.BDDAssertions.then;

public class CarRentalsConfigPage extends BaseStep {

    @When("Select The Drivers Age as {string}")
    public void selectTheDriversAgeAs(String driversAge) {
        PAGES.getCarPages().getCarConfigs().setCarRentalsDriverAgeByDropBox(driversAge);
    }

    @Then("Verify That Driver Aged Button Clicked {string}")
    public void verifyThatDriverAgedButtonClickedTrue(String isClicked) {
        boolean actual = PAGES.getCarPages().getCarConfigs().isDriverAged30And65CheckBoxSelected();
        then(isClicked).isEqualTo(actual + "");
    }

    @When("Select The Price Range from {string} to {string}")
    public void selectThePriceRangeFromTo(String minPrice, String maxPrice) {
        BrowserUtils.scrollDownWithJavaScript(0,600);
        PAGES.getCarPages().getCarConfigs().setThePriceRange(minPrice, maxPrice);
    }

    @And("Select {string} Car Specs")
    public void selectCarSpecs(String numberOfSpec) {
        PAGES.getCarPages().getCarConfigs().setTheCarSpecs(numberOfSpec);
    }

    @And("Select Transmission as {string}")
    public void selectTransmissionAsAutomatic(String transmissionType) {
        BrowserUtils.scrollDownWithJavaScript(0,600);
        PAGES.getCarPages().getCarConfigs().setTheTransmission(transmissionType);
    }

    @And("Select From Car Category The {string}")
    public void selectFromCarCategoryTheSmall(String carCategoryType) {
        PAGES.getCarPages().getCarConfigs().setCarCategory(carCategoryType);
    }
}