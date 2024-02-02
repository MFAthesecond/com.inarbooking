package stepdefinitions.hook;

import config.ConfigurationManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BrowserUtils;
import utils.DriverManager;

public class Hooks {

	public static final Logger LOGGER = LogManager.getLogger(Hooks.class);

	public static Scenario scenario;

	/**
	 * This method is executed before each scenario. It sets up the test environment,
	 * initializes the browser, and maximizes the window.
	 * @param scenario the Cucumber scenario object
	 */
	@Before
	public void setup(Scenario scenario) {
		LOGGER.info("---------------Test Automation has started------------");
		LOGGER.info("Test Scenario : " + scenario.getName());
		LOGGER.info("Browser type ----> " + ConfigurationManager.getProperty("browser"));
		DriverManager.getDriver().manage().window().maximize();
	}

	/**
	 * This method is executed after each scenario. It performs necessary actions based on
	 * the scenario result, such as taking a screenshot on failure, logging the failure
	 * details, and handling test retries for failed scenarios.
	 * @param scenario the Cucumber scenario object
	 */
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
			byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			BrowserUtils.getScreenshot(scenario.getName());
			scenario.attach(image, "image/png", scenario.getName());
			LOGGER.error("Test scenario ->>> ->>>>> Failed " + scenario.getName());
		}
		else {
			LOGGER.info("Test scenario -->>> ->>>> Passed");
		}
		DriverManager.closeDriver();
	}

}