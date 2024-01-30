package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class FlightSelectionPage extends BasePage {

    @FindBy(css = ".tab-item")
    private List<WebElement> tabList;
    @FindBy(css = ".searchItem")
    private List<WebElement> flightItemsList;
    @FindBy(css = ".lsItem-flights:nth-child(2) select")
    private WebElement originDropDown;
    @FindBy(css = ".lsItem-flights:nth-child(3) select")
    private WebElement destinationDropDown;
    @FindBy(css = ".lsItem-flights:nth-child(4) input")
    private WebElement departureDatePicker;
    @FindBy(css = ".lsItem-flights:nth-child(5) input")
    private WebElement returnDatePicker;
    @FindBy(css = ".lsItem-flights:nth-child(5) select")
    private WebElement oneWayAdultDropDown;
    @FindBy(css = ".lsItem-flights:nth-child(6) select")
    private WebElement adultDropDownForRoundTripAndChildDropDownForOneWay;
    @FindBy(css = ".lsItem-flights:nth-child(7) select")
    private WebElement childDropDown;
    @FindBy(css = ".lsItem-flights:nth-child(7) .d-flex")
    private List<WebElement> tripTypeListForOneWay;
    @FindBy(css = ".lsItem-flights:nth-child(8) .d-flex")
    private List<WebElement> tripTypeListForRoundTripAndCabinClassListForOneWay;
    @FindBy(css = ".lsItem-flights:nth-child(9) .lsCheckboxItem")
    private List<WebElement> cabinClassListForRoundTripAndAirlinesListForOneWay;
    @FindBy(css = ".lsItem-flights:nth-child(10) .lsCheckboxItem")
    private List<WebElement> airlinesListForRoundTripAndDurationListForOneWay;
    @FindBy(css = ".lsItem-flights:nth-child(11) .lsCheckboxItem")
    private List<WebElement> durationList;
    @FindBy(css = ".search-btn-flight button")
    private WebElement searchButton;
    @FindBy(css = ".pagination-booking button")
    private List<WebElement> paginationButtons;

    private WebElement getItem(int flightIndex){
        if(flightIndex <= flightItemsList.size()){
            return flightItemsList.get(flightIndex - 1);
        }
        throw new UnsupportedOperationException("There is no flight for the index");
    }

    public void clickOnSelectTicket(int flightIndex){
        BrowserUtils.clickOnElement(getItem(flightIndex).findElement(By.cssSelector(".flight-button")));
    }
    public List<String> getItemInformation(int flightIndex){
        List<String> flightInformationList = new ArrayList<>();
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".flight-title")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".siCancelOpSubtitle")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".text-muted:nth-child(4)")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".text-muted:nth-child(4) + span")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".flight-deperture-time")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".flight-deperture-time + span")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".my-2:nth-child(1)")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".my-2:nth-child(3)")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".flight-arrival-time")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".flight-arrival-time + span")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".siPrice")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".siTaxOp")).getText());
        flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".text-muted:nth-child(3)")).getText());
        return flightInformationList;
    }

    public void clickOnPaginationButton(int buttonIndex){
        BrowserUtils.clickOnElement(paginationButtons.get(buttonIndex - 1));
    }
    public void selectFromOriginDropDown(String originName){
        Select select = new Select(originDropDown);
        select.selectByVisibleText(originName);
    }
    public void selectFromDestinationDropDown(String destinationName){
        Select select = new Select(destinationDropDown);
        select.selectByVisibleText(destinationName);
    }
    public void selectFromAdultDropDownForRoundTrip(int adultNum){
        Select select = new Select(adultDropDownForRoundTripAndChildDropDownForOneWay);
        select.selectByIndex(adultNum - 1);
    }
    public void selectFromChildDropDownForRoundTrip(int childNum){
        Select select = new Select(childDropDown);
        select.selectByIndex(childNum - 1);
    }
    public void selectTripTypeForRoundTrip(String tripTypeName){
        WebElement tripType = tripTypeListForRoundTripAndCabinClassListForOneWay.stream().filter(element -> element.findElement(By.cssSelector(".ms-2")).getText().equals(tripTypeName)).findFirst().get();
        tripType.findElement(By.cssSelector("input")).click();
        BrowserUtils.clickOnElement(tripType.findElement(By.cssSelector("input")));
    }
    public void selectCabinClassForRoundTrip(String cabinClassName){
        WebElement cabinClass = cabinClassListForRoundTripAndAirlinesListForOneWay.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(cabinClassName)).findFirst().get();
        BrowserUtils.clickOnElement(cabinClass.findElement(By.cssSelector("input")));
    }
    public void selectAirlinesForRoundTrip(String airlinesName){
        WebElement airlines = airlinesListForRoundTripAndDurationListForOneWay.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(airlinesName)).findFirst().get();
        BrowserUtils.clickOnElement(airlines.findElement(By.cssSelector("input")));
    }
    public void selectDurationHoursForRoundTrip(String durationHoursName){
        WebElement durationHours = durationList.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(durationHoursName)).findFirst().get();
        BrowserUtils.clickOnElement(durationHours.findElement(By.cssSelector("input")));
    }
    public void clickOnSearchButton(){
        BrowserUtils.clickOnElement(searchButton);
    }

    public void selectFromAdultDropDownForOneWay(int adultNum){
        Select select = new Select(oneWayAdultDropDown);
        select.selectByIndex(adultNum - 1);
    }

    public void selectFromChildDropDownForOneWay(int childNum){
        Select select = new Select(adultDropDownForRoundTripAndChildDropDownForOneWay);
        select.selectByIndex(childNum - 1);
    }
    public void selectTripTypeForOneWay(String tripTypeName){
        WebElement tripType = tripTypeListForOneWay.stream().filter(element -> element.findElement(By.cssSelector(".ms-2")).getText().equals(tripTypeName)).findFirst().get();
        tripType.findElement(By.cssSelector("input")).click();
        BrowserUtils.clickOnElement(tripType.findElement(By.cssSelector("input")));
    }
    public void selectCabinClassForOneWay(String cabinClassName){
        WebElement cabinClass = tripTypeListForRoundTripAndCabinClassListForOneWay.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(cabinClassName)).findFirst().get();
        BrowserUtils.clickOnElement(cabinClass.findElement(By.cssSelector("input")));
    }
    public void selectAirlinesForOneWay(String airlinesName){
        WebElement airlines = cabinClassListForRoundTripAndAirlinesListForOneWay.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(airlinesName)).findFirst().get();
        BrowserUtils.clickOnElement(airlines.findElement(By.cssSelector("input")));
    }
    public void selectDurationHoursForOneWay(String durationHoursName){
        WebElement durationHours = airlinesListForRoundTripAndDurationListForOneWay.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(durationHoursName)).findFirst().get();
        BrowserUtils.clickOnElement(durationHours.findElement(By.cssSelector("input")));
    }




}
