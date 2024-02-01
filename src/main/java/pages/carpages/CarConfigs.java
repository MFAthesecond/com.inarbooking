package pages.carpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


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

    public void setThePriceRangeViaList(List<String> list) {
        List<WebElement> priceOptions = getTheOptionsInConfigurationPage.get(0).findElements(By.cssSelector(".lsCheckboxInput"));
        BrowserUtils.scrollToElement(DriverManager.getDriver(), priceOptions.get(0));
        for (String nameOfProduct : list) {
            for (WebElement carSpecsOption : priceOptions) {
                if (carSpecsOption.getAttribute("value").equals(nameOfProduct.substring(1))) {
                    carSpecsOption.click();
                }
            }
        }

    }

    public String getTheSelectedMaxPrice() {
        List<WebElement> priceOptions = getTheOptionsInConfigurationPage.get(0).findElements(By.cssSelector(".lsCheckboxInput"));
        String maxPrice;
        for (int i = priceOptions.size() - 1; i >= 0; i--) {
            if (priceOptions.get(i).isSelected()) {
                maxPrice = priceOptions.get(i).getAttribute("value");
                return maxPrice.substring(maxPrice.indexOf('-') + 1);
            }
        }
        maxPrice = priceOptions.get(priceOptions.size()).getAttribute("value");
        return maxPrice.substring(maxPrice.indexOf('-') + 1);

    }

    public void setTheCarSpecs(List<String> list) {
        List<WebElement> carSpecsOptions = getTheOptionsInConfigurationPage.get(1).findElements(By.cssSelector(".lsCheckboxInput"));
        BrowserUtils.scrollToElement(DriverManager.getDriver(), carSpecsOptions.get(0));
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
        BrowserUtils.scrollToElement(DriverManager.getDriver(), transmissionOptions.get(0));
        transmissionOptions.get(automaticOrManual.toLowerCase(Locale.ROOT).contains("au") ? 0 : 1).click();
    }

    public void setTheTransmissionViaDataSet(List<String> list) {
        List<WebElement> transmissionOptions = getTheOptionsInConfigurationPage.get(2).findElements(By.cssSelector(".lsCheckboxInput"));
        BrowserUtils.scrollToElement(DriverManager.getDriver(), transmissionOptions.get(0));
        for (String nameOfProduct : list) {
            if (nameOfProduct != null) {
                for (WebElement carSpecsOption : transmissionOptions) {
                    if (carSpecsOption.getAttribute("value").equals(nameOfProduct) && !carSpecsOption.isSelected()) {
                        carSpecsOption.click();
                    }
                }
            }
        }
    }

    public List<String> getTheSelectedTransmission() {
        List<WebElement> transmissionOptions = getTheOptionsInConfigurationPage.get(2).findElements(By.cssSelector(".lsCheckboxInput"));
        List<String> transmission = new ArrayList<>();
        for (WebElement transmissionOption : transmissionOptions) {
            transmission.add(transmissionOption.getText());
        }
        return transmission;
    }

    public void setCarCategory(List<String> carCategory) {
        List<WebElement> carCategoryOptions = getTheOptionsInConfigurationPage.get(3).findElements(By.cssSelector(".lsCheckboxInput"));
        BrowserUtils.scrollToElement(DriverManager.getDriver(), carCategoryOptions.get(0));
        for (int i = 0; i < carCategory.size(); i++) {
            for (int j = 0; j < carCategoryOptions.size(); j++) {
                if (carCategory.get(i).equals(carCategoryOptions.get(j).getAttribute("value"))) {
                    carCategoryOptions.get(j).click();
                }
            }

        }
    }

    public List<String> getTheSelectedCarCategory() {
        List<WebElement> carCategoryOptions = getTheOptionsInConfigurationPage.get(3).findElements(By.cssSelector(".lsCheckboxInput"));
        List<String> selectedCarCategory = new ArrayList<>();
        for (int i = 0; i < carCategoryOptions.size(); i++) {
            if (carCategoryOptions.get(i).isSelected()) {
                selectedCarCategory.add(carCategoryOptions.get(i).getAttribute("value"));
            }
        }
        return selectedCarCategory;
    }

    public void clickOnSearchButtonInConfigPage() {
        BrowserUtils.scrollToElement(DriverManager.getDriver(), searchButton);
        searchButton.click();
    }


}
