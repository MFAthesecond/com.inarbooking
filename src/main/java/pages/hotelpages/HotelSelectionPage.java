package pages.hotelpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

import static utils.BrowserUtils.scrollToElement;

public class HotelSelectionPage extends BasePage {
    @FindBy(css = ".listWrapper > h1")
    WebElement hotelTabName;

    @FindBy(css = ".listSearch-hotels > div:nth-child(2) > input")
    WebElement destinationInputArea;

    public void selectDestination(String destination) {
        destinationInputArea.sendKeys(destination);
    }

    @FindBy(css = ".listSearch-hotels > div:nth-child(3) > span")
    WebElement checkInAndCheckOutDate;

    @FindBy(css = ":nth-child(1) > input.lsOptionInput.shadow-md.w-100:nth-child(2)")
    WebElement minPriceSlider;

    @FindBy(css = ":nth-child(4) > div > div:nth-child(2) > input")
    WebElement maxPriceSlider;

    @FindBy(css = ":nth-child(3) > input.lsOptionInput.shadow-md")
    WebElement adultNumberBox;
    @FindBy(css = ":nth-child(4) > input.lsOptionInput.shadow-md")
    WebElement childrenNumberBox;
    @FindBy(css = ":nth-child(5) > div.lsOptions.p-0:nth-child(2) > div.lsCheckboxItem > span")
    List<WebElement> funThingsToDoNameList;
    @FindBy(css = ":nth-child(5) > div.lsOptions.p-0:nth-child(2) > div.lsCheckboxItem  >input")
    List<WebElement> funThingsToDoButtonList;
    @FindBy(css = ".listSearch-hotels > div:nth-child(6) > div > div > span")
    List<WebElement> additionalFeaturesNameList;
    @FindBy(css = ".listSearch-hotels > div:nth-child(7) > div")
    WebElement hotels;
    @FindBy(css = ":nth-child(8) > div > div > button:nth-child(1)")
    WebElement minusBox;
    @FindBy(css = ":nth-child(8) > div > div > button:nth-child(3)")
    WebElement plusBox;
    @FindBy(css = ".lsOptionInput.shadow-md.w-50:nth-child(2)")
    WebElement numberOfBedroomsBox;

    @FindBy(css = ".search-btn-flight > button")
    WebElement searchButton;
    @FindBy(css = ".searchItem")
    private static List<WebElement> searchItemBox;
    @FindBy(css = ".listResult ")
    private static WebElement hotelsList;

    public boolean validateNavigationToHotelSelectionPage() {
        return hotelTabName.isDisplayed();
    }

    public String getCheckInDate() {
        String date = checkInAndCheckOutDate.getText();
        return date.substring(0, date.indexOf("/202"));
    }

    public String getCheckOutDate() {
        String date = checkInAndCheckOutDate.getText();
        return date.substring(date.lastIndexOf(" "), date.indexOf("/202"));
    }

    public int getAdultNumber(int quantity) {
        return Integer.parseInt(adultNumberBox.getAttribute("value"));
    }

    public int getChildrenNumber(int quantity) {
        return Integer.parseInt(childrenNumberBox.getAttribute("value"));
    }

    @FindBy(css = ".listSearch-hotels > div:nth-child(6) > div > div > input")
    List<WebElement> additionalButtonList;

    public void selectThingsToDo(List<String> selectionThingList) {
        scrollToElement(maxPriceSlider);
        List<String> textList = funThingsToDoNameList.stream()
                .map(WebElement::getText)
                .toList();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if (selectionThingList.get(i).equals(textList.get(j))) {
                    funThingsToDoButtonList.get(j).click();
                }
            }
        }

    }

    public void selectAdditionalFeatures(List<String> selectionAdditionalList) {
        scrollToElement(maxPriceSlider);
        List<String> textList = additionalFeaturesNameList.stream()
                .map(WebElement::getText)
                .toList();

        for (int i = 0; i < selectionAdditionalList.size(); i++) {
            for (int j = 0; j < textList.size(); j++) {
                if (selectionAdditionalList.get(i).equals(textList.get(j))) {
                    additionalButtonList.get(j).click();
                }
            }
        }
    }

    public void setRoomNumber(int roomNumber) {
        for (int i = 1; i < roomNumber; i++) {
            clickOnPlusBox();
        }
    }

    public void clickOnMinusBox() {
        minusBox.click();
    }

    public void clickOnPlusBox() {
        plusBox.click();
    }

    public void clickOnSearchButton() {
        scrollToElement(searchButton);
        searchButton.click();
    }

    public WebElement getEvaluationScoreBox(int index) {
        return searchItemBox.get(index).findElement(By.cssSelector("button:nth-child(2)"));
    }

    public void clickOnSeeAvailabilityButton(int index) {
        scrollToElement(hotelTabName);
        List<WebElement> list = hotelsList.findElements(By.cssSelector(".searchItem "));
        list.get(index - 1).findElement(By.cssSelector(".siCheckButton")).click();

//        for (int i = 0; i < searchItemBox.size(); i++) {
//            System.out.println(searchItemBox.get(i).getText());
//        }
    }

    public WebElement getHotelNameBox(int index) {
        return searchItemBox.get(index).findElement(By.cssSelector(".siTitle"));
    }

    public WebElement getLocationInformation(int index) {
        return searchItemBox.get(index).findElement(By.cssSelector(".siDistance"));
    }

    public WebElement getLocation(int index) {
        return searchItemBox.get(index).findElement(By.cssSelector(".siDesc > h2.fs-5.m-0"));
    }

    public WebElement getLocationCountry(int index) {
        return searchItemBox.get(index).findElement(By.cssSelector(".siDesc > h2.fs-4.m-0"));
    }

    @FindBy(css = ":nth-child(7) > div > div")
    List<WebElement> listOfHotelTypes;

//    public void selectHotelTypes(List<String>stringList) {
//        for (int i = 0; i < ; i++) {
//
//        }
//        listOfHotelTypes.stream().filter()
//    }

    public String getCityName(int index) {
        String cityName = getLocation(index).getText();
        return cityName.substring(0, cityName.lastIndexOf(","));
    }

    public WebElement getHotelFee(int index) {
        return searchItemBox.get(index).findElement(By.cssSelector(".siDetailTexts > span.siPrice"));
    }
}


