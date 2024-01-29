package pages.carpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CarRentalCheckOut extends BasePage {

    //fill the blanks
    //make some confirmations

    @FindBy(css = ".form-control")
    private List<WebElement> customesInfos;

    @FindBy(css = ".form-select")
    private WebElement countryPhoneNumber;

    public void setFirstName(String firstName) {
        customesInfos.get(0).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        customesInfos.get(1).sendKeys(lastName);
    }

    public void setPhoneNumber(String phoneNumber) {
        customesInfos.get(2).sendKeys(phoneNumber);
    }

    public void setCountry(String country) {
        customesInfos.get(3).sendKeys(country);
    }

    public void setAddress(String address) {
        customesInfos.get(4).sendKeys(address);
    }

    public void setCity(String city) {
        customesInfos.get(5).sendKeys(city);
    }

    public void setPostalCode(String postalCode) {
        customesInfos.get(6).sendKeys(postalCode);
    }

    public void setCardHoldersName(String cardHoldersName) {
        customesInfos.get(7).sendKeys(cardHoldersName);
    }

    public void setCardNumber(String cardNumber) {
        customesInfos.get(8).sendKeys(cardNumber);
    }

    public void setExpiryDate(String expiryDate_as_mm_yy_or_mmyy) {
        customesInfos.get(9).sendKeys(expiryDate_as_mm_yy_or_mmyy);
    }

    public void setCVV(String cvv) {
        customesInfos.get(10).sendKeys(cvv);
    }

    public void setOnCountriesPhoneNumber(String countryName) {
        countryPhoneNumber.click();
        List<WebElement> countries = countryPhoneNumber.findElements(By.cssSelector(" > option")).stream().toList();
    }


}
