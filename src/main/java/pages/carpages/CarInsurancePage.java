package pages.carpages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class CarInsurancePage extends BasePage {
    private HashMap<String, String> locationHourDateInfosInCarInsurancePage;
    @FindBy(css = ".mt-5 .btn.btn-blue")
    private List<WebElement> goToBookElement;
    @FindBy(css = ".carDate-area .fw-bold")
    private List<WebElement> pickAndDropAddressAtTopOfInsurancePage;
    @FindBy(css = ".fs-4.mb-2")
    private List<WebElement> hoursAndDateOfPickupAndDropOff;
    @FindBy(css = ".pickup-and-drop-off.mb-5 .fw-bold.fs-4")
    private List<String> locationOfPickupAndDropOff;
    @FindBy(css = "div[class='mt-5'] span:nth-child(2)")
    private WebElement totalPriceElement;
//
    @FindBy(css = "span.d-inline-block:nth-child(1)")
    private List<WebElement> taxesAndFeesElement;

    @FindBy(css = ".check-option")
    private List<WebElement> insuranceOptions;

    @FindBy(css = "h3.fs-2")
    private WebElement carNameElement;

    public void clickOnGoToBookElement() {
        BrowserUtils.scrollToElement(goToBookElement.get(1));
        goToBookElement.get(1).click();
    }

    public String getPickupAddressAtTheTopOfInsurancePageFullAddressWithCountry() {
        return pickAndDropAddressAtTopOfInsurancePage.get(0).getText();
    }

    public String getDropOffAddressAtTheTopOfInsurancePageFullAddressWithCountry() {
        return pickAndDropAddressAtTopOfInsurancePage.get(1).getText();
    }

    public String getThePickupDate() {
        return datesOfDopOffAndPickUp(0);
    }

    public String getThePickUpHour() {
        String pickUpHour = hoursAndDateOfPickupAndDropOff.get(0).getText();
        int indexOf = pickUpHour.indexOf(":");
        return pickUpHour.substring(indexOf - 2, indexOf + 3);

    }

    public String getTheDropOffDate() {
        return datesOfDopOffAndPickUp(1);
    }

    public String getTheDropOffHour() {
        String pickUpHour = hoursAndDateOfPickupAndDropOff.get(0).getText();
        int indexOf = pickUpHour.indexOf(":");
        return pickUpHour.substring(indexOf - 2, indexOf + 3);

    }

    public String getThePickUpLocation() {
        return locationOfPickupAndDropOff.get(0).substring(locationOfPickupAndDropOff.get(0).indexOf("-") + 1);
    }

    public String getTheDropOffLocation() {
        return locationOfPickupAndDropOff.get(1).substring(locationOfPickupAndDropOff.get(0).indexOf("-") + 1);
    }

    public String datesOfDopOffAndPickUp(int i) {
        String pickUpDate = hoursAndDateOfPickupAndDropOff.get(i).getText();
        int indexOfSpace = pickUpDate.indexOf(" ");
        int indexOf = pickUpDate.indexOf(",");
        String pickUpMonth = pickUpDate.substring(0, indexOfSpace);
        String pickUpDay = pickUpDate.substring(indexOfSpace + 1, indexOf);
        String newPickUpDay = pickUpDay.length() == 1 ? "0" + pickUpDay : pickUpDay;
        String pickUpYear = pickUpDate.substring(indexOf + 2, indexOf + 6);
        Month ay = Month.valueOf(pickUpMonth.toUpperCase());
        int aySirasi = ay.getValue() + 1;
        return pickUpYear + "-" + aySirasi + "-" + newPickUpDay;
    }

    public void setLocationHourDateInfosInCarInsurancePage() {
        locationHourDateInfosInCarInsurancePage = new HashMap<>();
        locationHourDateInfosInCarInsurancePage.put("PickupLocation", getThePickUpLocation());
        locationHourDateInfosInCarInsurancePage.put("PickupDate", getThePickupDate());
        locationHourDateInfosInCarInsurancePage.put("PickupHour", getThePickUpHour());
        locationHourDateInfosInCarInsurancePage.put("DropoffDate", getTheDropOffDate());
        locationHourDateInfosInCarInsurancePage.put("DropoffHour", getTheDropOffHour());
    }

    public HashMap<String, String> getLocationHourDateInfosInCarInsurancePage() {
        setLocationHourDateInfosInCarInsurancePage();
        return locationHourDateInfosInCarInsurancePage;
    }

    public String getTheTotalPriceElement() {
        BrowserUtils.scrollToElement(totalPriceElement);
        return totalPriceElement.getText().substring(1,totalPriceElement.getText().indexOf("."));
    }

    public String getTheFeeAndTaxPercentage() {
        BrowserUtils.scrollToElement(taxesAndFeesElement.get(0));
        String xx = taxesAndFeesElement.get(0).getText();
        return xx.substring(xx.indexOf("%") + 1, xx.indexOf(" of total price"));
    }

    public void clickOnNoInsuranceOption() {
        BrowserUtils.scrollToElement(insuranceOptions.get(0));
        insuranceOptions.get(0).click();
    }

    public void clickOnWhatIsCoveredInsuranceElementOption() {
        BrowserUtils.scrollToElement(insuranceOptions.get(1));
        insuranceOptions.get(0).click();
    }

    public String getTheTotalCoverPricePercentage(){
        BrowserUtils.scrollToElement(taxesAndFeesElement.get(1));
        String xx = taxesAndFeesElement.get(0).getText();
        return xx.substring(xx.indexOf("%") + 1, xx.indexOf(" of total price"));
    }

    public String getTheCarName(){
        return carNameElement.getText();
    }

}
