package pages.carpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class CarConfigs extends BasePage {
    @FindBy(css = ".listSearch-car-rental > div")
    private WebElement carRentalConfigurations;

    //
    public void setTheDriverAge(String driverAge) {
        carRentalConfigurations.findElement(By.cssSelector(" .form-select")).sendKeys(driverAge);
    }

    @FindBy(css = ".form-select > option")
    private List<WebElement> driverAgesOptions;

    public void setCarRentalsDriverAgeByDropBox(String driversAge) {
        carRentalConfigurations.findElement(By.cssSelector(" .form-select")).click();
        driverAgesOptions.get(Math.abs(18 - Integer.parseInt(driversAge))).click();
        BrowserUtils.wait(1);
        carRentalConfigurations.findElement(By.cssSelector(" .form-select")).click();

    }

    //
    public void clickOnDriverAgedBetween30And65() {
        carRentalConfigurations.findElement(By.cssSelector(" .w-auto")).click();
    }

    public boolean isDriverAged30And65CheckBoxSelected() {
        return carRentalConfigurations.findElement(By.cssSelector(" .w-auto")).isSelected();
    }

    //bunları bulamadım
    public void setThePickUpDateInConfigurationPage() {
        // takvime ulaşamıyorum
    }

    public void setTheDropOffDateInConfigurationPage() {
        // takvime ulaşamıyorum
    }

    public void setThePickUpLocationInConfigurationPage(String setThePickUpLocationInConfigurationPage) {
        carRentalConfigurations.sendKeys(setThePickUpLocationInConfigurationPage);
    }

    //4 options
    @FindBy(css = ".lsOptions ")
    private List<WebElement> getTheOptionsInConfigurationPage;

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
        return prices.get(prices.size()).getText().substring(prices.get(prices.size()).getText().indexOf("-")+1);
    }

    public void setTheCarSpecs(String numberOfCarSpecs) {
        List<WebElement> carSpecsOptions = getTheOptionsInConfigurationPage.get(1).findElements(By.cssSelector(".lsCheckboxInput"));
        for (int i = 0; i < Integer.parseInt(numberOfCarSpecs); i++) {
            Random random = new Random();
            int pickOptionRandomly = random.nextInt(carSpecsOptions.size());
            if (!carSpecsOptions.get(pickOptionRandomly).isSelected()) {
                carSpecsOptions.get(pickOptionRandomly).click();
                BrowserUtils.wait(0.25);
            } else {
                i--;
            }
        }
    }

    public void setTheTransmission(String automaticOrManual) {
        List<WebElement> transmissionOptions = getTheOptionsInConfigurationPage.get(2).findElements(By.cssSelector(".lsCheckboxInput"));
        transmissionOptions.get(automaticOrManual.toLowerCase(Locale.ROOT).contains("au") ? 0 : 1).click();
    }

    public void setCarCategory(String carCategoryTypes) {
        String carCategoryTypesSmall = carCategoryTypes.toLowerCase(Locale.ROOT);
        List<WebElement> carCategoryOptions = getTheOptionsInConfigurationPage.get(3).findElements(By.cssSelector(".lsCheckboxInput"));
        switch (carCategoryTypesSmall) {
            case "small" -> carCategoryOptions.get(0).click();
            case "medium" -> carCategoryOptions.get(1).click();
            case "large" -> carCategoryOptions.get(2).click();
            case "minivan" -> carCategoryOptions.get(3).click();
            case "suv" -> carCategoryOptions.get(4).click();
        }
    }

    //sort bY section
    @FindBy(css = "div[class='search-btn-car-rental'] button")
    private WebElement searchButton;

    public void clickOnSearchButton(){
        searchButton.click();
        BrowserUtils.wait(2);
    }


}
