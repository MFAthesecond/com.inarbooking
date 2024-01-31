package pages.carpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class CarConfigs extends BasePage {
    @FindBy(css = ".listSearch-car-rental > div")
    private WebElement carRentalConfigurations;
    @FindBy(css = "div[class='search-btn-car-rental'] button")
    private WebElement searchButton;
    @FindBy(css = ".form-select > option")
    private List<WebElement> driverAgesOptions;
    @FindBy(css = ".w-auto.h-auto")
    WebElement isDriverAgedBetween30And65CheckBoxElement;
    @FindBy(css = ".lsOptions ")
    private List<WebElement> getTheOptionsInConfigurationPage;
    @FindBy(css = ".form-control")
    private List<WebElement> pickAndDropDateAndPickLocation;

    //
    public void setTheDriverAge(String driverAge) {
        carRentalConfigurations.findElement(By.cssSelector(" .form-select")).sendKeys(driverAge);
    }


    public void setCarRentalsDriverAgeByDropBox(String driversAge) {
        carRentalConfigurations.findElement(By.cssSelector(" .form-select")).click();
        driverAgesOptions.get(Math.abs(18 - Integer.parseInt(driversAge))).click();
        BrowserUtils.wait(1);
        carRentalConfigurations.findElement(By.cssSelector(" .form-select")).click();

    }


    public void clickOnDriverAgedBetween30And65() {
        isDriverAgedBetween30And65CheckBoxElement.click();
    }

    public boolean isDriverAged30And65CheckBoxSelected() {
        return isDriverAgedBetween30And65CheckBoxElement.isSelected();
    }

    //bunları bulamadım
    public void setThePickUpDateInConfigurationPage() {
        //pickAndDropDateAndPickLocation.get(0).
    }

    public void setTheDropOffDateInConfigurationPage() {
        // pickAndDropDateAndPickLocation.get(1)
    }

    public void setThePickUpLocationInConfigurationPage(String setThePickUpLocationInConfigurationPage) {
        pickAndDropDateAndPickLocation.get(2).sendKeys(setThePickUpLocationInConfigurationPage);
    }

    //4 options


    public void setThePriceRange(String minPrice, String maxPrice) {
        List<WebElement> priceOptions = getTheOptionsInConfigurationPage.get(0).findElements(By.cssSelector(".lsCheckboxInput"));
        if (Integer.parseInt(maxPrice) > 500) {
            maxPrice = "500";
        }
        int startPriceElement = Integer.parseInt(minPrice) / 50;
        int endPriceElement = Integer.parseInt(maxPrice) / 50;
        for (int i = startPriceElement; i < endPriceElement; i++) {
            priceOptions.get(i).click();
            BrowserUtils.wait(0.25);
        }
    }

    public String getTheSelectedMaxPrice() {
        List<WebElement> priceOptions = getTheOptionsInConfigurationPage.get(0).findElements(By.cssSelector(".lsCheckboxInput"));
        List<WebElement> prices = getTheOptionsInConfigurationPage.get(0).findElements(By.cssSelector(".lsCheckboxText"));

        for (int i = priceOptions.size() - 1; i >= 0; i--) {
            if (priceOptions.get(i).isSelected()) {
                return prices.get(i).getText().substring(prices.get(i).getText().indexOf("-"));
            }
        }
        return prices.get(prices.size()).getText().substring(prices.get(prices.size()).getText().indexOf("-") + 1);
    }

    public void setTheCarSpecs(String args1, String arg2, String arg3, String arg4) {
        List<String> list = new ArrayList<>(List.of(new String[]{args1, arg2, arg3, arg4}));
        List<WebElement> carSpecsOptions = getTheOptionsInConfigurationPage.get(1).findElements(By.cssSelector(".lsCheckboxInput"));
        for (String nameOfProduct : list) {
            if (nameOfProduct != null) {
                for (WebElement carSpecsOption : carSpecsOptions) {
                    if (carSpecsOption.getAttribute("value").equals(nameOfProduct) && !carSpecsOption.isSelected()) {
                        carSpecsOption.click();
                    }
                }
            }
        }


    }

    public void setTheTransmission(String automaticOrManual) {
        List<WebElement> transmissionOptions = getTheOptionsInConfigurationPage.get(2).findElements(By.cssSelector(".lsCheckboxInput"));
        transmissionOptions.get(automaticOrManual.toLowerCase(Locale.ROOT).contains("au") ? 0 : 1).click();
    }

    public List<String> getTheSelectedTransmission() {
        List<WebElement> transmissionOptions = getTheOptionsInConfigurationPage.get(2).findElements(By.cssSelector(".lsCheckboxInput"));
        List<String> transmission = new ArrayList<>();
        for (WebElement transmissionOption : transmissionOptions) {
            transmission.add(transmissionOption.getText());
        }
        return transmission;
    }

    public void setCarCategory(String carCategoryTypes) {
        String carCategoryTypesSmall = carCategoryTypes.toLowerCase(Locale.ROOT);
        List<WebElement> carCategoryOptions = getTheOptionsInConfigurationPage.get(3).findElements(By.cssSelector(".lsCheckboxInput"));
        BrowserUtils.scrollToElement(DriverManager.getDriver(), carCategoryOptions.get(0));
        switch (carCategoryTypesSmall) {
            case "small" -> carCategoryOptions.get(0).click();
            case "medium" -> carCategoryOptions.get(1).click();
            case "large" -> carCategoryOptions.get(2).click();
            case "minivan" -> carCategoryOptions.get(3).click();
            case "suv" -> carCategoryOptions.get(4).click();
        }
    }


    public void clickOnSearchButton() {
        searchButton.click();
        BrowserUtils.wait(2);
    }


}
