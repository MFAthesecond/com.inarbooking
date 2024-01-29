package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightHomePage extends BasePage {

    @FindBy(className = "headerSearchItem")
    private List<WebElement> searchFlightsBarInputFields;
    @FindBy(xpath = "//span[normalize-space()='Flights']")
    private WebElement flightTab;

    @FindBy(css = "div[class='h-100 d-flex justify-content-start align-items-center'] label")
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
    private WebElement monthDropDown;

    @FindBy(css = ".rdrYearPicker")
    private WebElement yearDropDown;
    @FindBy(css = "button.rdrDay")
    private List<WebElement> dayButtons;
    @FindBy(xpath = "//input[@placeholder='Early']")
    private WebElement firstDate;

    @FindBy(xpath = "//input[@placeholder='Continuous']")
    private WebElement lastDate;

    @FindBy(css = ".optionCounterNumber")
    private List<WebElement> passengerCounterNumber;

    @FindBy(css = ".optionCounterButton")
    private List<WebElement> counterButtons;

    @FindBy(className = "optionDoneButton")
    private WebElement doneButton;

    public void clickOnFlightTab() {
        flightTab.click();
    }

    public void selectFlightClassesDropDown(String flightClassesSelectionText) {
        Select select = new Select(flightClassesDropDown);
        select.selectByVisibleText(flightClassesSelectionText);
    }

    public void clickOnRoundTripAndOneWayRadioButton(String buttonName) {
        WebElement element = roundTripAndOneWayRadioButton.stream().filter(webElement -> webElement.findElement(By.cssSelector("span")).getText().equals(buttonName)).findFirst().get();
        element.click();
    }

    public void selectFromDropDown(String fromSelectionText) {
        Select select = new Select(fromDropDown);
        select.selectByVisibleText(fromSelectionText);
    }

    public void selectToDropDown(String toSelectionText) {
        Select select = new Select(toDropDown);
        select.selectByVisibleText(toSelectionText);
    }

    public void clickOnDatePicker() {
        searchFlightsBarInputFields.get(2).click();
    }

    public void selectMonthDropDown(String monthSelectionText) {
        Select select = new Select(monthDropDown);
        select.selectByVisibleText(monthSelectionText);
    }

    public void selectYearDropDown(String yearSelectionText) {
        Select select = new Select(yearDropDown);
        select.selectByVisibleText(yearSelectionText);
    }

    public void clickOnDayByIndex(int index) {
        List<WebElement> filterButton = dayButtons.stream().filter(button -> !button.getAttribute("class").contains("rdrDayPassive") && !button.getAttribute("class").contains("rdrDayDisplayed")).toList();
        filterButton.get(index - 1).click();
    }

    public void clickOnPassengersOptionsItem() {
        searchFlightsBarInputFields.get(3).click();

    }

    public String getTextOfAdultCounterNumber() {
        return passengerCounterNumber.get(0).getText();
    }

    public String getTextOfChildrenCounterNumber() {
        return passengerCounterNumber.get(1).getText();
    }

    public void clickOnAdultCounterNumber(int input) {
        int currentNumber = Integer.parseInt(getTextOfAdultCounterNumber());

        if (input > currentNumber) {
            while (currentNumber < input) {
                counterButtons.get(1).click();
                currentNumber++;
            }
        } else if (input < currentNumber) {
            while (currentNumber > input) {
                counterButtons.get(0).click();
                currentNumber--;
            }
        }
    }

    public void adjustChildrenCounter(int input) {
        int currentNumber = Integer.parseInt(getTextOfChildrenCounterNumber());

        if (input > currentNumber) {
            while (currentNumber < input) {
                counterButtons.get(3).click();
                currentNumber++;
            }
        } else if (input < currentNumber) {
            while (currentNumber > input) {
                counterButtons.get(2).click();
                currentNumber--;
            }
        }
    }

    public void clickOnDoneButtonForPassengerField() {
        doneButton.click();
    }

    public void clickOnPrevButton() {
        prevButton.click();
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void clickOnSearchFlightButton() {
        searchFlightsBarInputFields.get(4).click();
    }

    public void selectFirstDate(String firstDateStr) {
        firstDate.click();
        firstDate.clear();
        firstDate.sendKeys(firstDateStr);
    }

    public void selectLastDate(String lastDateStr) {
        lastDate.click();
        lastDate.clear();
        lastDate.sendKeys(lastDateStr);
    }

}
