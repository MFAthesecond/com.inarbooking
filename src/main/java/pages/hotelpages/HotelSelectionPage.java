package pages.hotelpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HotelSelectionPage extends BasePage {

    @FindBy(css = ".listWrapper > h1")
    WebElement hotelTabName;

    @FindBy(css = ".listSearch-hotels > div:nth-child(2) > input")
    WebElement destinationInputArea;

    @FindBy(css = ".listSearch-hotels > div:nth-child(3) > span")
    WebElement checkInDate;

    @FindBy(css = ":nth-child(1) > input.lsOptionInput.shadow-md.w-100:nth-child(2)0")
    WebElement minPriceSlider;

    @FindBy(css = ":nth-child(4) > div > div:nth-child(2) > input")
    WebElement maxPriceSlider;

    @FindBy(css = ":nth-child(3) > input.lsOptionInput.shadow-md")
    WebElement adultNumberBox;
    @FindBy(css = ":nth-child(4) > input.lsOptionInput.shadow-md")
    WebElement childNumberBox;

    @FindBy(css = ":nth-child(5) > div.lsOptions.p-0:nth-child(2)")
    WebElement funThingsToDo;

    public void selectThingToDo(List<Integer> selectionThingList) {
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

    @FindBy(css = ".listSearch-hotels > div:nth-child(6) > div")
    WebElement additionalFeatures;

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

    //:nth-child(7) > div > div:nth-child(1) > input
    @FindBy(css = ".listSearch-hotels > div:nth-child(7) > div")
    WebElement hotels;

    public void hotels(List<Integer> hotelsSelectionList) {
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

    @FindBy(css = ":nth-child(8) > div > div > button:nth-child(1)")
    WebElement minusBox;

    public void clickOnMinusBox() {
        minusBox.click();
    }

    @FindBy(css = ":nth-child(8) > div > div > button:nth-child(3)")
    WebElement plusBox;

    public void clickOnPlusBox() {
        plusBox.click();
    }

    @FindBy(css = ".lsOptionInput.shadow-md.w-50:nth-child(2)")
    WebElement numberOfBedroomsBox;

    @FindBy(css = ".search-btn-flight > button")
    WebElement searchButton;

    public void clickOnSearchButton() {
        searchButton.click();
    }

    @FindBy(css = ".searchItem:nth-child(1)")
    private static WebElement searchItemBox;


    public static WebElement seeAvailabilityButton() {
        return searchItemBox.findElement(By.cssSelector(".siCheckButton"));
    }

    public static WebElement evaluationScoreBox() {
        return searchItemBox.findElement(By.cssSelector("button:nth-child(2)"));
    }

    public static WebElement hotelNameBox() {
        return searchItemBox.findElement(By.xpath("//h1[contains(text(),'Urban Oasis Resort')]"));
    }

    public static WebElement locationInformation() {
        return searchItemBox.findElement(By.cssSelector(".siDistance"));
    }

    public static WebElement location() {
        return searchItemBox.findElement(By.cssSelector(".siDesc > h2.fs-5.m-0"));
    }

    public static WebElement locationCountry() {
        return searchItemBox.findElement(By.cssSelector(".siDesc > h2.fs-4.m-0"));
    }
    // New York, United States of America

    public String getCityName() {
        String cityName = location().getText();
        return cityName.substring(0, cityName.lastIndexOf(","));
    }

    public static WebElement hotelFee() {
        return searchItemBox.findElement(By.cssSelector(".siDetailTexts > span.siPrice"));
    }



}


