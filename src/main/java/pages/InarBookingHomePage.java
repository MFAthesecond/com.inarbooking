package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InarBookingHomePage {

    @FindBy(css = ".headerListItem")
    List<WebElement> headerList;

    public void clickOnStaysLink() {
        headerList.get(0).click();
    }

    public void clickOnFlightsLink() {
        headerList.get(1).click();
    }

    public void clickOnCarRentalsLink() {
        headerList.get(2).click();
    }
}
