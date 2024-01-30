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

    @FindBy(css = ".tab-item ")
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
    @FindBy(css = ".lsItem-flights:nth-child(6) select")
    private WebElement adultDropDown;
    @FindBy(css = ".lsItem-flights:nth-child(7) select")
    private WebElement childDropDown;
    @FindBy(css = ".lsItem-flights:nth-child(8) .d-flex")
    private List<WebElement> tripTypeList;
    @FindBy(css = ".lsItem-flights:nth-child(9) .lsCheckboxItem")
    private List<WebElement> cabinClassList;
    @FindBy(css = ".lsItem-flights:nth-child(10) .lsCheckboxItem")
    private List<WebElement> airlinesList;
    @FindBy(css = ".lsItem-flights:nth-child(11) .lsCheckboxItem")
    private List<WebElement> durationList;
    @FindBy(css = ".search-btn-flight button")
    private WebElement searchButton;
    @FindBy(css = ".pagination-booking button")
    private List<WebElement> paginationButtons;

    private WebElement getItem(String flightName){
        return flightItemsList.stream().filter(item -> item.findElement(By.cssSelector(".flight-title")).getText().equals(flightName)).findFirst().get();
    }

    public void clickOnSelectTicket(String flightName){
        getItem(flightName).findElement(By.cssSelector(".flight-button")).click();
    }
    public List<String> getItemInformation(String flightName){
        List<String> flightInformationList = new ArrayList<>();
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".flight-title")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".siCancelOpSubtitle")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".text-muted:nth-child(4)")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".text-muted:nth-child(4) + span")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".flight-deperture-time")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".flight-deperture-time + span")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".my-2:nth-child(1)")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".my-2:nth-child(3)")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".flight-arrival-time")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".flight-arrival-time + span")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".siPrice")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".siTaxOp")).getText());
        flightInformationList.add(getItem(flightName).findElement(By.cssSelector(".text-muted:nth-child(3)")).getText());
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
    public void selectFromAdultDropDown(int adultNum){
        Select select = new Select(adultDropDown);
        select.selectByIndex(adultNum - 1);
    }
    public void selectFromChildDropDown(int childNum){
        Select select = new Select(childDropDown);
        select.selectByIndex(childNum - 1);
    }
    public void selectTripType(String tripTypeName){
        WebElement tripType = tripTypeList.stream().filter(element -> element.findElement(By.cssSelector(".ms-2")).getText().equals(tripTypeName)).findFirst().get();
        tripType.findElement(By.cssSelector("input")).click();
        BrowserUtils.clickOnElement(tripType.findElement(By.cssSelector("input")));
    }
    public void selectCabinClass(String cabinClassName){
        WebElement cabinClass = cabinClassList.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(cabinClassName)).findFirst().get();
        BrowserUtils.clickOnElement(cabinClass.findElement(By.cssSelector("input")));
    }
    public void selectAirlines(String airlinesName){
        WebElement airlines = airlinesList.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(airlinesName)).findFirst().get();
        BrowserUtils.clickOnElement(airlines.findElement(By.cssSelector("input")));
    }
    public void selectDurationHours(String durationHoursName){
        WebElement durationHours = durationList.stream().filter(element -> element.findElement(By.cssSelector("span")).getText().equals(durationHoursName)).findFirst().get();
        BrowserUtils.clickOnElement(durationHours.findElement(By.cssSelector("input")));
    }
    public void clickOnSearchButton(){
        BrowserUtils.clickOnElement(searchButton);
    }
}
