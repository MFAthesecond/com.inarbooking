package stepdefinitions;

import config.ConfigurationManager;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

public class BasicStepDefs extends BaseStep{
    private static final Logger LOGGER = LogManager.getLogger(BasicStepDefs.class);
    @Given("Navigation to the baseURL")
    public void navigation_to_the_base_url() {
        DRIVER.get(ConfigurationManager.getProperty("baseURL"));
        LOGGER.info("Navigated to the baseURL");
    }
    @Given("Click on the Booking Link")
    public void click_on_the_booking_link() {
       PAGES.getHomePage().clickBookingLink();
       try {
           LOGGER.debug("Navigated to the Inar Booking Link");
       }catch (NoSuchElementException ex){
           LOGGER.error("The link could not found");
           throw ex;
       }
    }

}
