package pages.hotelpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HotelSelectionPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) DRIVER;

    @FindBy(css = ".listWrapper > h1")
    WebElement hotelTabName;

    @FindBy(css = ".listSearch-hotels > div:nth-child(2) > input")
    WebElement destinationInputArea;

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

    @FindBy(css = ":nth-child(5) > div.lsOptions.p-0:nth-child(2)")
    WebElement funThingsToDo;
    @FindBy(css = ".listSearch-hotels > div:nth-child(6) > div")
    WebElement additionalFeatures;
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
    @FindBy(css = ".searchItem:nth-child(1)")
    private static WebElement searchItemBox;
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

    public void selectThingsToDo(List<Integer> selectionThingList) {
        WebElement funThingsElements;
        List<WebElement> thingsToDoChecklist = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            funThingsElements = funThingsToDo.findElement(By.cssSelector(":nth-child(5) > div.lsOptions.p-0:nth-child(2) > div:nth-child(" + i + ") > input "));
            thingsToDoChecklist.add(funThingsElements);
        }

        for (int i = 0; i < selectionThingList.size() - 1; i++) {
            int index = selectionThingList.get(i);
            for (int j = 0; j < thingsToDoChecklist.size() - 1; j++) {
                if (index == j) {
                    thingsToDoChecklist.get(j).click();
                }
            }
        }
    }


    public void selectAdditionalFeatures(List<Integer> selectionAdditionalList) {
        WebElement additionalFeaturesElements;
        List<WebElement> featureChecklist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            additionalFeaturesElements = additionalFeatures.findElement(By.cssSelector(".listSearch-hotels > div:nth-child(6) > div > div:nth-child(" + 1 + " ) > input"));
            featureChecklist.add(additionalFeaturesElements);
        }

        for (int i = 0; i < selectionAdditionalList.size() - 1; i++) {
            int index = selectionAdditionalList.get(i);
            for (int j = 0; j < featureChecklist.size() - 1; j++) {
                if (index == j) {
                    featureChecklist.get(j).click();
                }
            }
        }
    }


    public void selectHotelsTypes(List<Integer> hotelsSelectionList) {
        WebElement hotelsElements;
        List<WebElement> hotelsChecklist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            hotelsElements = additionalFeatures.findElement(By.cssSelector(".listSearch-hotels > div:nth-child(7) > div> div:nth-child(" + 1 + ") > input"));
            hotelsChecklist.add(hotelsElements);
        }

        for (int i = 0; i < hotelsSelectionList.size() - 1; i++) {
            int index = hotelsSelectionList.get(i);
            for (int j = 0; j < hotelsChecklist.size() - 1; j++) {
                if (index == j) {
                    hotelsChecklist.get(j).click();
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
        searchButton.click();
    }


    public static WebElement seeAvailabilityButton() {
        return searchItemBox.findElement(By.cssSelector(".siCheckButton"));
    }

    public static void clickSeeAvailabilityButton() {
        seeAvailabilityButton().click();
    }

    public static WebElement getEvaluationScoreBox() {
        return searchItemBox.findElement(By.cssSelector("button:nth-child(2)"));
    }

    public static WebElement getHotelNameBox() {
        return searchItemBox.findElement(By.xpath("//h1[contains(text(),'Urban Oasis Resort')]"));
    }

    public static WebElement getLocationInformation() {
        return searchItemBox.findElement(By.cssSelector(".siDistance"));
    }

    public static WebElement getLocation() {
        return searchItemBox.findElement(By.cssSelector(".siDesc > h2.fs-5.m-0"));
    }

    public static WebElement getLocationCountry() {
        return searchItemBox.findElement(By.cssSelector(".siDesc > h2.fs-4.m-0"));
    }
    // New York, United States of America

    public String getCityName() {
        String cityName = getLocation().getText();
        return cityName.substring(0, cityName.lastIndexOf(","));
    }

    public static WebElement getHotelFee() {
        return searchItemBox.findElement(By.cssSelector(".siDetailTexts > span.siPrice"));
    }


}


