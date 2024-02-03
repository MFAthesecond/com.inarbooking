
package stepdefinitions;

import org.openqa.selenium.WebDriver;
import utils.DriverManager;
import utils.Pages;

public class BaseStep {

	protected final Pages PAGES = new Pages();

	protected final WebDriver DRIVER = DriverManager.getDriver();

}
