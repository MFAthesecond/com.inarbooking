package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public abstract class BasePage {

	protected final WebDriver DRIVER = DriverManager.getDriver();

	protected WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(10));

	public BasePage() {
		PageFactory.initElements(DRIVER, this);

		DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}