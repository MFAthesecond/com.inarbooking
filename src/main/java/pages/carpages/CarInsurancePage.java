package pages.carpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.List;

public class CarInsurancePage extends BasePage {

    @FindBy(css = ".mt-5 .btn.btn-blue")
    private List<WebElement> goToBookElement;


    public void clickOnGoToBookElement() {
        BrowserUtils.scrollToElement(DriverManager.getDriver(), goToBookElement.get(1));
        goToBookElement.get(1).click();
    }


}
