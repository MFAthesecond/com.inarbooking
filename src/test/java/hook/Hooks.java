package hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.DriverManager;

public class Hooks {

	private static final Logger logger = LogManager.getLogger(Hooks.class);

	@Before
	public static void SetUpTestEnvironment() {
		String browserType = "chrome";
		DriverManager.getDriver(browserType);
		logger.info("Test Started");
	}

	@After
	public static void tearDownTestEnvironment() {
		DriverManager.closeDriver();
		logger.info("Test Finished");
	}

}