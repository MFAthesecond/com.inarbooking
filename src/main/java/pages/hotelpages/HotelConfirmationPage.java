package pages.hotelpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HotelConfirmationPage extends BasePage {

    @FindBy(css = ".modal-body.p-5")
    WebElement conformationContainer;

    @FindBy(css = ".confirmation-number span:nth-child(2)")
    WebElement confirmationNumber;

    @FindBy(css = ".your-reservation")
    WebElement reservationCard;

    @FindBy(css = "//button[normalize-space()='Close']")
    WebElement closeButton;

    @FindBy(css = ".about-hotel-title > h1")
    WebElement hotelName;
    @FindBy(css = ".about-hotel-title > h1")
    WebElement hotelLocation;

    @FindBy(css = ".rounded.my-4")
    WebElement ratingBox;

    @FindBy(css = ".your-reservation")
    WebElement reservationContainer;


    public String getThanksMessage() {
        String fullThankMessage = conformationContainer.findElement(By.cssSelector(".modal-body.p-5 > div.thanks > h1")).getText();
        String[] dividedThanksMessage = fullThankMessage.split("! ");
        if (dividedThanksMessage.length > 1) {
            String visitorNameMessage = dividedThanksMessage[dividedThanksMessage.length - 1];
            return visitorNameMessage.trim();
        } else {
            return "";
        }
    }

    public String getCityName() {
        String location = hotelLocation.getText();
        return location.substring(0, location.lastIndexOf(","));
    }

    public String getRatingNumber() {
        return ratingBox.getText();
    }

    public int[] getNumberOfReservation() {
        String yourReservation = reservationContainer.findElement(By.cssSelector(".your-reservation > div:nth-child(1) > div")).getText();
        String[] dividedYourReservation = yourReservation.split(" ");

        int[] reservationCounts = new int[3];

        if (dividedYourReservation.length > 5) {
            String adultNumber = dividedYourReservation[dividedYourReservation.length - 6];
            String childrenNumber = dividedYourReservation[dividedYourReservation.length - 4];
            String roomNumber = dividedYourReservation[dividedYourReservation.length - 2];

            reservationCounts[0] = Integer.parseInt(adultNumber.trim());
            reservationCounts[1] = Integer.parseInt(childrenNumber.trim());
            reservationCounts[2] = Integer.parseInt(roomNumber.trim());
        }
        return reservationCounts;
    }

    int[] reservationCounts = getNumberOfReservation();
    int adultCount = reservationCounts[0];
    int childrenCount = reservationCounts[1];
    int roomCount = reservationCounts[2];


    public String getCheckInDateDay() {
        String checkInDate = reservationContainer.findElement(By.cssSelector(".your-reservation > div:nth-child(2) > div")).getText();
        String[] dividedCheckInDate = checkInDate.split(" ");
        return dividedCheckInDate[dividedCheckInDate.length - 3];
    }

    public int getCheckInDateMonth() {
        String checkInDate = reservationContainer.findElement(By.cssSelector(".your-reservation > div:nth-child(2) > div")).getText();
        String[] dividedCheckInDate = checkInDate.split(" ");
        String monthName = dividedCheckInDate[dividedCheckInDate.length - 2];

        int month = 0;

        switch (monthName) {
            case "January":
                month = 1;
                break;
            case "February":
                month = 2;
                break;
            case "March":
                month = 3;
                break;
            case "April":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "June":
                month = 6;
                break;
            case "July":
                month = 7;
                break;
            case "August":
                month = 8;
                break;
            case "September":
                month = 9;
                break;
            case "October":
                month = 10;
                break;
            case "November":
                month = 11;
                break;
            case "December":
                month = 12;
                break;
        }

        return month;
    }

    public String getCheckInDateYear() {
        String checkInDate = reservationContainer.findElement(By.cssSelector(".your-reservation > div:nth-child(2) > div")).getText();
        String[] dividedCheckInDate = checkInDate.split(" ");
        return dividedCheckInDate[dividedCheckInDate.length - 1];
    }

    public String getCheckOutDateDay() {
        String checkInDate = reservationContainer.findElement(By.cssSelector(".your-reservation > div:nth-child(2) > div")).getText();
        String[] dividedCheckInDate = checkInDate.split(" ");
        return dividedCheckInDate[dividedCheckInDate.length - 3];
    }

    public int getCheckOutDateMonth() {
        String checkInDate = reservationContainer.findElement(By.cssSelector(".your-reservation > div:nth-child(2) > div")).getText();
        String[] dividedCheckInDate = checkInDate.split(" ");
        String monthName = dividedCheckInDate[dividedCheckInDate.length - 2];

        int month = 0;

        switch (monthName) {
            case "January":
                month = 1;
                break;
            case "February":
                month = 2;
                break;
            case "March":
                month = 3;
                break;
            case "April":
                month = 4;
                break;
            case "May":
                month = 5;
                break;
            case "June":
                month = 6;
                break;
            case "July":
                month = 7;
                break;
            case "August":
                month = 8;
                break;
            case "September":
                month = 9;
                break;
            case "October":
                month = 10;
                break;
            case "November":
                month = 11;
                break;
            case "December":
                month = 12;
                break;
        }

        return month;
    }

    public String getCheckOutDateYear() {
        String checkInDate = reservationContainer.findElement(By.cssSelector(".your-reservation > div:nth-child(2) > div")).getText();
        String[] dividedCheckInDate = checkInDate.split(" ");
        return dividedCheckInDate[dividedCheckInDate.length - 1];
    }

    public void clickOnCloseButton() {
        closeButton.click();
    }
}
