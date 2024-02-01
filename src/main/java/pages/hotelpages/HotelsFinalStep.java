package pages.hotelpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

public class HotelsFinalStep extends BasePage {
    @FindBy(css = "input[placeholder=\"Cardholder's Name\"]")
    private WebElement cardHolderNameField;

    @FindBy(css = "input[placeholder='**** **** **** ****']")
    private WebElement cardNumberField;
    @FindBy(css = "input[placeholder='MM/YY or MMYY']")
    private WebElement expirationDateField;
    @FindBy(css = "input[placeholder='CVV/CVC ( 3 or 4 number length)']")
    private WebElement cvcCodeField;

    @FindBy(css = "input[name='consentMarketingEmails']")
    private WebElement emailConsentCheckbox;
    @FindBy(css = "input[name='consentTransportDeals']")
    private WebElement transportDealsConsentCheckbox;
    @FindBy(xpath = "//span[normalize-space()='Complete Booking']")
    private WebElement completeBookingButton;
    @FindBy(xpath = "//select[@name='phoneCountry']")
    private WebElement countryCodeSelect;
    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//select[@name='country']")
    private WebElement countrySelect;

    public void fillCardHolderName(String name) {
        cardHolderNameField.sendKeys(name);
    }

    public void fillCardNumber(String number) {
        cardNumberField.sendKeys(number);
    }

    public void fillExpirationDate(String date) {
        expirationDateField.sendKeys(date);
    }

    public void fillCvcCode(String code) {
        cvcCodeField.sendKeys(code);
    }

    public void clickOnEmailConsentCheckbox() {
        BrowserUtils.clickOnElement(emailConsentCheckbox);
    }

    public void clickOnTransportDealsConsentCheckbox() {
        BrowserUtils.clickOnElement(transportDealsConsentCheckbox);
    }

    public void clickOnCompleteBookingButton() {
        BrowserUtils.clickOnElement(completeBookingButton);
    }

    public void selectCountryCodeDropDown(String countryCodeSelectionText) {
        Select select = new Select(countryCodeSelect);
        select.selectByVisibleText(countryCodeSelectionText);
    }

    public void fillPhoneNumber(String number) {
        phoneNumberField.sendKeys(number);
    }

    public void selectCountry(String countryName) {
        Select countriesDropdown = new Select(countrySelect);
        countriesDropdown.selectByVisibleText(countryName);
    }
}