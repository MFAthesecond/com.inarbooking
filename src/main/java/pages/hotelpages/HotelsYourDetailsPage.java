package pages.hotelpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

public class HotelsYourDetailsPage extends BasePage {

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstNameInputArea;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastNameInputArea;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInputArea;

    @FindBy(css = ".form-select.fs-4")
    WebElement arrivalTimeDropdownMenu;

    @FindBy(css = ".align-items-end > button")
    WebElement nextButton;

    @FindBy(css = "span.m-0")
    WebElement totalPrice;

    @FindBy(css = ".hotel-title")
    WebElement hotelName;

    @FindBy(css = ".hotel-address")
    WebElement address;

    public String getHotelName(){
        return hotelName.getText();
    }
    public String getHotelCity(){
        String hotelCity=address.getText();
        return hotelCity.substring(0,hotelCity.indexOf(','));
    }


    public void enterFirstName(String firstname) {
        firstNameInputArea.sendKeys(firstname);
    }

    public void enterLastName(String lastName) {
        lastNameInputArea.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInputArea.sendKeys(email);
    }

    public int getTotalPrice() {
        String srtPrice = totalPrice.getText().substring(1);
        return Integer.parseInt(srtPrice);
    }

    public void clickOnNextButton() {
        nextButton.click();
    }
    public void setArrivalTime(int index){
        Select arrivalTime =new Select(arrivalTimeDropdownMenu);
        arrivalTime.deselectByIndex(index);
    }

}
