package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assert;
import org.assertj.core.api.WithAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginSteps extends BaseStep {
    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class);

    @Given("the user is on the InarAcademy Home Page")
    public void the_user_is_on_the_inar_academy_home_page() {
        PAGES.getHomePage();
        LOGGER.debug("Navigate to InarAcademy Home Page");
    }

    @When("the user click on {string} button")
    public void the_user_click_on_button(String string) {
        PAGES.getHomePage().clickBookingLink();
        LOGGER.debug("Click on Booking tab ");
    }

    @Then("Inar Booking page is displayed")
    public void inar_booking_page_is_displayed() {
        WebElement header = DRIVER.findElement(By.xpath("//h1[contains(text(),'Find your next stay')]"));
        assertThat(header.getText()).isEqualTo("Find your next stay");
        LOGGER.info("User log in to Inar Booking Page");
    }
}
