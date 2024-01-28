package pages.flightPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightHomePage extends BasePage {

    @FindBy(xpath = "headerSearch")
    private List<WebElement>searchFlightsBarInputFields;
    @FindBy(xpath = "//span[normalize-space()='Flights']")
    private WebElement flightTab;

    @FindBy(css = "input[type='radio']")
    private List<WebElement> roundTripAndOneWayRadioButton;

    @FindBy(xpath = "//select[@class='headerSearchInput w-100 form-select fs-4']")
    private WebElement flightClassesDropDown;

    @FindBy(xpath = "//div[@class='headerContainer']//div[1]//select[1]")
    private WebElement fromDropDown;

    @FindBy(xpath = "(//select[@class='headerSearchInput w-100'])[2]")
    private WebElement toDropDown;

   @FindBy(css = "button[class='rdrNextPrevButton rdrPprevButton']")
   private WebElement prevButton;

    @FindBy(css = "button[class='rdrNextPrevButton rdrNextButton']")
    private WebElement nextButton;

    @FindBy(css = ".rdrMonthPicker")
    private WebElement monthPickerDropDown;

    @FindBy(css = ".rdrYearPicker")
    private WebElement yearPickerDropDown;

    @FindBy(xpath = "//div[@class='rdrCalendarWrapper rdrDateRangeWrapper date-booking']")
    private List<WebElement> datePicker;






    public void selectFlightClassesDropDown(String flightClassesSelectionText) {
        Select select = new Select(flightClassesDropDown);
        select.selectByVisibleText(flightClassesSelectionText);
    }
    public  void clickOnDatePicker(){
        searchFlightsBarInputFields.get(2).click();
    }

    public void selectMonthDropDown(String monthSelectionText) {
        Select select = new Select(monthPickerDropDown);
        select.selectByVisibleText(monthSelectionText);
    }
    public void selectYearDropDown(String yearSelectionText) {
        Select select = new Select(yearPickerDropDown);
        select.selectByVisibleText(yearSelectionText);
    }

}
