package pages.carpages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class CarRentalPage extends BasePage {


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

    //WARNING SECOND PAGE  LEFT SIDE

    @FindBy(css = ".listSearch-car-rental > div")
    private WebElement carRentalConfigurations;


    //
    public void setTheDriverAge(String driverAge) {
        carRentalConfigurations.findElement(By.cssSelector(" .form-select")).sendKeys(driverAge);
    }

    public void setCarRentalsDriverAgeByDropBox(String setAgesZeroFor18and47For65) {
        carRentalConfigurations.findElement(By.cssSelector(" .form-select")).click();
        List<WebElement> ageList = Stream.of(carRentalConfigurations.findElement(By.cssSelector(" .form-select > option"))).toList();
        ageList.get(Integer.parseInt(setAgesZeroFor18and47For65));
    }

    //
    public void clickOnDriverAgedBetween30And65() {
        carRentalConfigurations.findElement(By.cssSelector(" .w-auto")).click();
    }

    public boolean isDriverAged30And65CheckBoxSelected() {
        return carRentalConfigurations.findElement(By.cssSelector(" .w-auto")).isSelected();
    }

    //bunları bulamadım
    public void setThePickUpDateInConfigurationPage() {
        // takvime ulaşamıyorum
    }

    public void setTheDropOffDateInConfigurationPage() {
        // takvime ulaşamıyorum
    }

    public void setThePickUpLocationInConfigurationPage(String setThePickUpLocationInConfigurationPage) {
        carRentalConfigurations.sendKeys(setThePickUpLocationInConfigurationPage);
    }

    // options there are 4 options part with checkboxes

    public List<WebElement> getTheOptionsInConfigurationPage(String numberOfOption) {
        List<WebElement> options = Stream.of(carRentalConfigurations.findElement(By.cssSelector(" .lsOptions "))).toList();
        return (List<WebElement>) options.get(Integer.parseInt(numberOfOption));
    }

    public void setThePriceRange(String minPrice, String maxPrice) {
        List<WebElement> priceOptions = getTheOptionsInConfigurationPage("0");
        if (Integer.parseInt(maxPrice) > 500) {
            maxPrice = "500";
        }
        int startPriceElement = Integer.parseInt(minPrice) / 50;
        int endPriceElement = Integer.parseInt(maxPrice) / 50;
        for (int i = startPriceElement; i < endPriceElement; i++) {
            priceOptions.get(i).click();
        }
    }

    public void setTheCarSpecs(String numberOfCarSpecs) {
        List<WebElement> carSpecsOptions = getTheOptionsInConfigurationPage("1");
        for (int i = 0; i < Integer.parseInt(numberOfCarSpecs); i++) {
            Random random = new Random();
            int pickOptionRandomly = random.nextInt(carSpecsOptions.size());
            if (!carSpecsOptions.get(pickOptionRandomly).isSelected()) {
                carSpecsOptions.get(pickOptionRandomly).isSelected();
            } else {
                i--;
            }
        }
    }




}
