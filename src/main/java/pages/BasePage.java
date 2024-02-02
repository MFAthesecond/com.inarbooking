package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public abstract class BasePage {

	protected final WebDriver DRIVER = DriverManager.getDriver();

	public Actions actions;

	protected WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(10));

	public BasePage() {
		PageFactory.initElements(DRIVER, this);
		actions = new Actions(DRIVER);
		DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}