package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.List;
import java.util.stream.Collectors;

public class FlightPassengerInformationPage extends BasePage {
    @FindBy(xpath = "//input[@name='contactEmail']")
    private WebElement contactEmailField;

    @FindBy(xpath = "//select[@name='phoneCountry']")
    private WebElement countryCodeSelect;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@name='freeTextMessages']")
    private WebElement freeTextMessageField;

    @FindBy(className = "flight-reserve-card")
    private List<WebElement> travelerCards;

    @FindBy(xpath = ".//input[@placeholder='First Name']")
    private WebElement firstNameInput;

    @FindBy(xpath = ".//input[@placeholder='Surname']")
    private WebElement lastNameInput;

    @FindBy(xpath = ".//select[@class='form-select fs-4 p-3 border-danger']")
    private WebElement genderSelect;

    @FindBy(xpath = "(//select[@class='form-select fs-4 p-3'])[1]")
    private WebElement yearDropDown;

    @FindBy(xpath = "(//select[@class='form-select fs-4 p-3'])[2]")
    private WebElement monthDropDown;

    @FindBy(xpath = "(//select[@class='form-select fs-4 p-3'])[3]")
    private WebElement dayDropDown;

    @FindBy(xpath = "//span[normalize-space()='Back']")
    private WebElement backButton;

    @FindBy(css = ".btn.btn-blue")
    private WebElement selectExtrasButton;
    @FindBy(css = ".col-5 .flight-reserve-card")
    private WebElement priceCalculationContainer;
    @FindBy(className = "text-danger")
    private List<WebElement> errorMessage;

    @FindBy(css = ".flight-reserve-card h2")
    private WebElement contactHeader;


    public void clickOnFreeTextMessageField() {
        BrowserUtils.clickOnElement(freeTextMessageField);
    }

    public void fillTravelerCard(int index, String firstName, String lastName, String gender, String year, String month, String day) {
        WebElement travelerCard = travelerCards.get(index);
        List<WebElement>dateOfBirth=travelerCard.findElements(By.cssSelector("div[style='width: 32%;'] select"));
        WebElement firstNameInput = travelerCard.findElement(By.xpath(".//input[@placeholder='First Name']"));
        WebElement lastNameInput = travelerCard.findElement(By.xpath(".//input[@placeholder='Surname']"));
        WebElement genderSelect = travelerCard.findElement(By.xpath(".//select[@class='form-select fs-4 p-3 border-danger']"));
        WebElement yearDropDown = dateOfBirth.get(0);
        WebElement monthDropDown = dateOfBirth.get(1);
        WebElement dayDropDown =dateOfBirth.get(2);

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        new Select(genderSelect).selectByVisibleText(gender);
        new Select(yearDropDown).selectByVisibleText(year);
        new Select(monthDropDown).selectByVisibleText(month);
        new Select(dayDropDown).selectByVisibleText(day);
    }
    public void travelerCards(int index){
        WebElement travelerCard = travelerCards.get(index);
    }

    public void fillContactEmail(String email) {
        contactEmailField.sendKeys(email);
    }

    public void fillPhoneNumber(String number) {
        phoneNumberField.sendKeys(number);
    }

    public void fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void selectGenderDropDown(String genderSelectionText) {
        Select select = new Select(genderSelect);
        select.selectByVisibleText(genderSelectionText);
        //new Select(genderSelect).selectByVisibleText(genderSelectionText);
    }

    public void selectCountryCodeDropDown(String countryCodeSelectionText) {
        Select select = new Select(countryCodeSelect);
        select.selectByVisibleText(countryCodeSelectionText);
    }

    public void selectYearDropDown(String yearSelectionText) {
        Select select = new Select(yearDropDown);
        select.selectByVisibleText(yearSelectionText);
    }

    public void selectMonthDropDown(String monthSelectionText) {
        Select select = new Select(monthDropDown);
        select.selectByVisibleText(monthSelectionText);
    }

    public void selectDayDropDown(String daySelectionText) {
        Select select = new Select(dayDropDown);
        select.selectByVisibleText(daySelectionText);
    }

    public void clickOnBackButton() {
        BrowserUtils.clickOnElement(backButton);
    }

    public void clickOnSelectExtrasButton() {
        BrowserUtils.clickOnElement(selectExtrasButton);
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
        String[] dividedPrice = priceCalculationContainer.findElement(By.cssSelector("h1:nth-child(2)")).getText().split("\\$");
        return dividedPrice[dividedPrice.length - 1];
    }


    public Double getCalculatedTotalPrice() {
        double ticketPrice = Double.parseDouble(getTicketPrice());
        double taxesAndFeesPercentage = Double.parseDouble(getTaxesAndFeesPercentage());
        double thirdPartyFeePercentage = Double.parseDouble(getThirdPartyFeePercentage());
        double totalPrice = ticketPrice + ((ticketPrice * taxesAndFeesPercentage) / 100) + ((ticketPrice * thirdPartyFeePercentage) / 100);
        return Double.parseDouble(String.format("%.2f", totalPrice));
    }

    public String findErrorMessage(String targetErrorMessage) {
        List<WebElement> matchingElements = errorMessage.stream()
                .filter(element -> element.getText().equals(targetErrorMessage))
                .toList();

        if (!matchingElements.isEmpty()) {
            return matchingElements.get(0).getText();
        } else {
            return "No matching error message found";
        }
    }

    public String getHeaderText(){
        return contactHeader.getText();
    }
}
