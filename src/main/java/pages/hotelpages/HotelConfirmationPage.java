package pages.hotelpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class HotelConfirmationPage extends BasePage {

    @FindBy(css = ".about-hotel-title")
    public WebElement hotelTitle;

    @FindBy(css = ".text-muted.fs-4")
    private WebElement locationOfHotel;

    @FindBy(css = ".text-white.rounded.my-4")
    private WebElement ratingDegree;

    @FindBy(xpath = "//div[@class='text-muted']")
    private List<WebElement> reservationInfos;

    public String checkReservationInfo(int i) {
        return reservationInfos.get(i).getText();
    }

    public String getRatingDegree() {
        return ratingDegree.getAttribute("value");
    }

    public String getHotelTitle() {
        return hotelTitle.getText();
    }

    public String getLocationOfHotel() {
        return locationOfHotel.getText();
    }


}