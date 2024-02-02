package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

public class FlightCheckAndPayPage extends BasePage {
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
    @FindBy(css = "button[class='btn btn-blue']")
    private WebElement completeBookingButton;
    
    @FindBy(css = ".col-5 .flight-reserve-card")
    private WebElement priceCalculationContainer;

    public void clickOnBackButton() {
        BrowserUtils.clickOnElement(backButton);
    }
  
    public void clickOnCompleteBookingButton() {
        BrowserUtils.clickOnElement(completeBookingButton);
    }

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
    public String getTicketPrice() {
        return priceCalculationContainer.findElement(By.cssSelector(".mb-3:nth-child(1) > div > span:nth-child(1)")).getText().substring(2);
    }

    public String getTaxesAndFeesPercentage() {
        String taxesAndFees = priceCalculationContainer.findElement(By.cssSelector(".mb-3:nth-child(2)  > span:nth-child(1)")).getText();
        String[] dividedTaxesAndFees = taxesAndFees.split("%");
        String percentage = dividedTaxesAndFees[dividedTaxesAndFees.length - 1];
        return percentage.charAt(0) + "";
    }

    public String getThirdPartyFeePercentage() {
        String thirdPartyFee = priceCalculationContainer.findElement(By.cssSelector(".mb-3:nth-child(3)  > span:nth-child(1)")).getText();
        String[] dividedThirdPartyFee = thirdPartyFee.substring(thirdPartyFee.indexOf("%") + 1).split(" ");
        return dividedThirdPartyFee[0];
    }

    public String getTotalPrice() {
        String[] dividedPrice = priceCalculationContainer.findElement(By.cssSelector("h1")).getText().split("\\$");
        return dividedPrice[dividedPrice.length - 1];
    }

    public Double getCalculatedTotalPrice() {
        double ticketPrice = Double.parseDouble(getTicketPrice());
        double taxesAndFeesPercentage = Double.parseDouble(getTaxesAndFeesPercentage());
        double thirdPartyFeePercentage = Double.parseDouble(getThirdPartyFeePercentage());
        double totalPrice = ticketPrice + ((ticketPrice * taxesAndFeesPercentage) / 100) + ((ticketPrice * thirdPartyFeePercentage) / 100);
        return Double.parseDouble(String.format("%.2f", totalPrice));
    }


}
