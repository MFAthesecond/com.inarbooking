package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FlightPassengerInformationPage {
    @FindBy(xpath = "//input[@name='contactEmail']")
    private WebElement contactEmailField;

    @FindBy(xpath = "//select[@name='phoneCountry']")
    private WebElement countryCodeSelect;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@name='freeTextMessages']")
    private WebElement freeTextMessageField;

    @FindBy(xpath = "(//div)[46]")
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


    public void clickOnFreeTextMessageField() {
        freeTextMessageField.click();
    }

    public void fillTravelerCard(int index, String firstName, String lastName, String gender, String year, String month, String day) {
        WebElement travelerCard = travelerCards.get(index);
        WebElement firstNameInput = travelerCard.findElement(By.xpath(".//input[@placeholder='First Name']"));
        WebElement lastNameInput = travelerCard.findElement(By.xpath(".//input[@placeholder='Surname']"));
        WebElement genderSelect = travelerCard.findElement(By.xpath(".//select[@class='form-select fs-4 p-3 border-danger']"));
        WebElement yearDropDown = travelerCard.findElement(By.xpath(".//select[contains(@class, 'form-select')]"));
        WebElement monthDropDown = travelerCard.findElement(By.xpath(".//select[contains(@class, 'form-select')]"));
        WebElement dayDropDown = travelerCard.findElement(By.xpath(".//select[contains(@class, 'form-select')]"));

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        new Select(genderSelect).selectByVisibleText(gender);
        new Select(yearDropDown).selectByVisibleText(year);
        new Select(monthDropDown).selectByVisibleText(month);
        new Select(dayDropDown).selectByVisibleText(day);
    }
    public void fillContactEmail(String email){
        contactEmailField.sendKeys(email);
    }
    public void fillPhoneNumber(String number){
        phoneNumberField.sendKeys(number);
    } public void fillFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    } public void fillLastName(String lastName){
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
        backButton.click();
    }

    public void clickOnSelectExtrasButton() {
        selectExtrasButton.click();
    }
}
