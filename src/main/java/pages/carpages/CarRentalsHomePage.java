package pages.carpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.stream.Stream;

public class CarRentalsHomePage extends BasePage {
    @FindBy(css = ".headerList :nth-child(3)")
    private WebElement carRentalsElement;

    public void clickOnCarRentalsElementsInHomePage() {
        carRentalsElement.click();
    }

    //
    @FindBy(css = "input[placeholder='Enter Pickup Location']")
    private WebElement pickUpLocationElement;
    @FindBy(css = ".location-li-rentcar")
    private List<WebElement> locationSuggestion;

    public void enterPickupLocation(String pickUpLocation, String numberOfSuggestion) {
        pickUpLocationElement.sendKeys(pickUpLocation);
        int numberOfSuggestionAsInteger = Integer.parseInt(numberOfSuggestion);
        if (locationSuggestion != null) {
            if (numberOfSuggestionAsInteger > locationSuggestion.size() - 1) {
                locationSuggestion.get(0).click();
            } else {
                locationSuggestion.get(numberOfSuggestionAsInteger).click();
            }
        }
    }

    public boolean isPickUpLocationSelected() {
        return !pickUpLocationElement.getAttribute("placeholder").equalsIgnoreCase("Enter Pickup Location");
    }

    //bunlar hatalı olabilir mi
    @FindBy(css = "headerDateInput")
    private List<WebElement> pickAndDropDates;

    public void setThePickUpDate(String date) {
        pickAndDropDates.get(0).click();
    }

    public void setTheDropOffDate() {
        pickAndDropDates.get(1).click();
    }

    //
    @FindBy(css = "form-select")
    private List<WebElement> pickHourAndDropHour;

    public void setThePickupHour(String pickUpHourHalfHourInterval) {
        List<WebElement> pickupHours = Stream.of(pickHourAndDropHour.get(0).findElement(By.cssSelector(" > option"))).toList();
        pickupHours.get(Integer.parseInt(pickUpHourHalfHourInterval)).click();
    }

    public void setTheDropOffHour(String dropOffHourHalfHourInterval) {
        List<WebElement> pickupHours = Stream.of(pickHourAndDropHour.get(1).findElement(By.cssSelector(" > option"))).toList();
        pickupHours.get(Integer.parseInt(dropOffHourHalfHourInterval)).click();
    }

    //
    @FindBy(css = ".headerBtn")
    private WebElement searchCarsElement;

    public void clickOnSearchCarsElements() {
        searchCarsElement.click();
    }
}
