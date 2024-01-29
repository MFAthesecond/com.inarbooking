package pages.flightpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckAndPayPage {
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
    @FindBy(xpath = "//span[normalize-space()='Back']")
    private WebElement backButton;
    @FindBy(xpath = "//span[normalize-space()='Complete Booking']")
    private WebElement completeBookingButton;

    public void clickOnBackButton(){
        backButton.click();
    }
    public void clickOnCompleteBookingButton(){
        completeBookingButton.click();
    }

    public void fillCardHolderName(String name){
        cardHolderNameField.sendKeys(name);
    }

    public void fillCardNumber(String number){
        cardNumberField.sendKeys(number);
    }

    public void fillExpirationDate(String date){
        expirationDateField.sendKeys(date);
    }

    public void fillCvcCode(String code){
        cvcCodeField.sendKeys(code);
    }

    public void clickOnEmailConsentCheckbox(){
        emailConsentCheckbox.click();
    }

    public void clickOnTransportDealsConsentCheckbox(){
        transportDealsConsentCheckbox.click();
    }
    

}
