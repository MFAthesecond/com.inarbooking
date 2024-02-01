package pages.carpages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class CarInsurancePage extends BasePage {
    @FindBy(css = ".mt-5 .btn.btn-blue")
    private List<WebElement> goToBookElement;
    @FindBy(css = ".carDate-area .fw-bold")
    private List<WebElement> pickAndDropAddressAtTopOfInsurancePage;
    @FindBy(css = ".fs-4.mb-2")
    private List<WebElement> hoursAndDateOfPickupAndDropOff;
    @FindBy(css = ".pickup-and-drop-off.mb-5 .fw-bold.fs-4")
    private List<WebElement> locationOfPickupAndDropOff;
    @FindBy(css = "div[class='mt-5'] span:nth-child(2)")
    private WebElement totalPriceElement;
    @FindBy(css = ".pickup-and-drop-off.mb-5")
    private WebElement dateAndHourTable;
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
        BrowserUtils.scrollDownWithJavaScript(0,-3000);
        return pickAndDropAddressAtTopOfInsurancePage.get(0).getText();
    }

    public String getDropOffAddressAtTheTopOfInsurancePageFullAddressWithCountry() {
        BrowserUtils.scrollDownWithJavaScript(0,-3000);
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
        BrowserUtils.scrollToElement(dateAndHourTable);
        System.out.println("index of - is "+locationOfPickupAndDropOff.get(0).getText().indexOf("-") + 1);
        return locationOfPickupAndDropOff.get(0).getText().substring(locationOfPickupAndDropOff.get(0).getText().indexOf("-") + 1);
    }


    public String getTheDropOffLocation() {
        BrowserUtils.scrollToElement(dateAndHourTable);
        System.out.println("index of + >>>"+locationOfPickupAndDropOff.get(1).getText().indexOf("-") + 1);
        return locationOfPickupAndDropOff.get(1).getText().substring(locationOfPickupAndDropOff.get(1).getText().indexOf("-") + 1);
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

//    public HashMap<String, String> getLocationHourDateInfosInCarInsurancePage() {
//        System.out.println("1");
//        HashMap<String, String> locationHourDateInfosInCarInsurancePage = new HashMap<>();
//        BrowserUtils.scrollToElement(dateAndHourTable);
//        locationHourDateInfosInCarInsurancePage.put("PickupLocation", getThePickUpLocation());
//        System.out.println(locationHourDateInfosInCarInsurancePage.get("PickupLocation"));
//        locationHourDateInfosInCarInsurancePage.put("PickupDate", getThePickupDate());
//        System.out.println(locationHourDateInfosInCarInsurancePage.get("PickupDate"));
//        locationHourDateInfosInCarInsurancePage.put("PickupHour", getThePickUpHour());
//        locationHourDateInfosInCarInsurancePage.put("DropoffDate", getTheDropOffDate());
//        locationHourDateInfosInCarInsurancePage.put("DropoffHour", getTheDropOffHour());
//
//        return locationHourDateInfosInCarInsurancePage;
//    }


    public String getTheTotalPriceElement() {
        BrowserUtils.scrollToElement(totalPriceElement);
        return totalPriceElement.getText().substring(1, totalPriceElement.getText().indexOf("."));
    }

    public String getTheFeeAndTaxPercentage() {
        System.out.println("bialssşlşls");
        BrowserUtils.scrollToElement(taxesAndFeesElement.get(0));
        String xx = taxesAndFeesElement.get(0).getText();
        System.out.println(xx);
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

    public String getTheTotalCoverPricePercentage() {
        BrowserUtils.scrollToElement(taxesAndFeesElement.get(1));
        String xx = taxesAndFeesElement.get(1).getText();
        return xx.substring(xx.indexOf("%") + 1, xx.indexOf(" of total price"));
    }

    public String getTheCarName() {
        return carNameElement.getText();
    }

}
