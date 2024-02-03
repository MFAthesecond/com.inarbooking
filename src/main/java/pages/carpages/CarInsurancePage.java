package pages.carpages;

import freemarker.template.utility.DateUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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

      public String getThePickupDate() {
        BrowserUtils.scrollToElement(hoursAndDateOfPickupAndDropOff.get(0));
        return dateFormatter(hoursAndDateOfPickupAndDropOff.get(0).getText().substring(0, hoursAndDateOfPickupAndDropOff.get(0).getText().lastIndexOf(',')));
    }

    public String getThePickUpHour() {
        String pickUpHour = hoursAndDateOfPickupAndDropOff.get(0).getText();
        int indexOf = pickUpHour.indexOf(":");
        return pickUpHour.substring(indexOf - 2, indexOf + 3);

    }

    public String getTheDropOffDate() {
        BrowserUtils.scrollToElement(hoursAndDateOfPickupAndDropOff.get(1));
        return dateFormatter(hoursAndDateOfPickupAndDropOff.get(1).getText().substring(0, hoursAndDateOfPickupAndDropOff.get(1).getText().lastIndexOf(',')));
    }



    public String getThePickUpLocation() {
        BrowserUtils.scrollToElement(dateAndHourTable);
        return locationOfPickupAndDropOff.get(0)
                .getText()
                .substring(locationOfPickupAndDropOff.get(0).getText().indexOf("-") + 1);
    }

    public String getTheDropOffLocation() {
        BrowserUtils.scrollToElement(dateAndHourTable);
        return locationOfPickupAndDropOff.get(1)
                .getText()
                .substring(locationOfPickupAndDropOff.get(1).getText().indexOf("-") + 1);
    }


    public String getTheTotalPriceElement() {
        BrowserUtils.scrollToElement(totalPriceElement);
        return totalPriceElement.getText().substring(1, totalPriceElement.getText().indexOf("."));
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
        insuranceOptions.get(1).click();
    }

    public String getTheTotalCoverPricePercentage() {
        BrowserUtils.scrollToElement(taxesAndFeesElement.get(1));
        String xx = taxesAndFeesElement.get(1).getText();
        return xx.substring(xx.indexOf("%") + 1, xx.indexOf(" of total price"));
    }

    public String getTheCarName() {
        BrowserUtils.scrollToElement(carNameElement);
        return carNameElement.getText();
    }
    public static String dateFormatter(String givenDate) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date date = inputDateFormat.parse(givenDate);
            return outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
