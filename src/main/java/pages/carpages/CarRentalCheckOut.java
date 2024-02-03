package pages.carpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CarRentalCheckOut extends BasePage {

    // fill the blanks
    // make some confirmations

    @FindBy(css = ".form-control")
    private List<WebElement> customesInfos;

    @FindBy(css = "option")
    private List<WebElement> countryPhoneNumber;

    @FindBy(css = "select[name='phoneCountry']")
    private WebElement counrty;

    @FindBy(css = ".text-danger")
    private List<WebElement> textDangerElements;

    @FindBy(css = ".btn.btn-blue.fs-4.px-5.py-3")
    private WebElement bookNowElement;

    @FindBy(css = "input[name='consentMarketingEmails']")
    private WebElement consentMarketingEmailsElement;

    @FindBy(css = ".modal .thanks .fs-3 ")
    private WebElement nameInMessageAfterOrdering;

    @FindBy(css = ".fs-2 .fw-bold")
    private WebElement pickupLocationInMessageAfterOrdering;

    @FindBy(css = ".about-hotel .fs-3")
    private WebElement carTypeInMessageAfterOrdering;

    @FindBy(css = ".w-100 .text-muted")
    private List<WebElement> datesInMessageAfterOrdering;

    public void setFirstName(String firstName) {
        BrowserUtils.scrollToElement(customesInfos.get(0));
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
        counrty.click();
        BrowserUtils.wait(1);
        for (int i = 0; i < 7; i++) {
            if (countryName.contains(countryPhoneNumber.get(i).getAttribute("value"))) {
                countryPhoneNumber.get(i).click();
                break;
            }
        }
    }

    public int getTheNumberOfTextDangerElement() {
        return textDangerElements.size();
    }

    public void clickOnBookNowElement() {
        BrowserUtils.scrollToElement(bookNowElement);
        bookNowElement.click();
    }

    public void clickOnConsentMarketingEmails() {
        BrowserUtils.scrollToElement(consentMarketingEmailsElement);
        consentMarketingEmailsElement.click();
    }

    public String getTheNameInConfirmationMessage() {
        return nameInMessageAfterOrdering.getText();
    }

    public String carTypeInConfirmationMessage() {
        return carTypeInMessageAfterOrdering.getText();
    }

    public String getThePickUpDateInAppearedMessage() {
        return dateFormatterForGivenMessage(datesInMessageAfterOrdering.get(0).getText());
    }
    public String getTheDropOffDateInAppearedMessage() {
        return dateFormatterForGivenMessage(datesInMessageAfterOrdering.get(1).getText());
    }
    public  String dateFormatterForGivenMessage(String givenDate) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            Date date = inputDateFormat.parse(givenDate);
            return outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
