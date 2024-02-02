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
	public WebElement countryCodeSelect;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumberField;

	@FindBy(xpath = "//select[@name='country']")
	private WebElement countrySelect;

	@FindBy(css = ".my-4.fs-4 > div:nth-child(1) > input")
	private WebElement yesCheckbox1;

	@FindBy(css = ".my-4.fs-4 > div:nth-child(2) > input")
	private WebElement yesCheckbox2;

	@FindBy(css = ".enter-your-info.mb-4 > h2")
	WebElement infoTitle;

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

	public void clickOpportunityCheckbox() {
		yesCheckbox1.click();
		yesCheckbox2.click();
	}

	public boolean validateInfoTitle() {
		return infoTitle.isDisplayed();

	}

}
