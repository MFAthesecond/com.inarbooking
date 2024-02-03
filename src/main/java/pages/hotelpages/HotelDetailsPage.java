package pages.hotelpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HotelDetailsPage extends BasePage {

	@FindBy(css = "button.bookNow")
	WebElement reserveOrBookNowButton;

	@FindBy(css = ".align-items-center > h1")
	WebElement hotelName;

	@FindBy(css = ".bhp-item.p-3.d-flex.flex-row")
	List<WebElement> hotelProperties;

	@FindBy(css = "b")
	WebElement totalAmount;

	@FindBy(css = ".fs-5")
	WebElement amountPerNight;

	public void getHotelAspectsName() {
		List<String> hotelPropertiesStr = new ArrayList<>();
		for (WebElement aspect : hotelProperties) {
			hotelPropertiesStr.add(aspect.getText());
		}
	}

	public boolean validateHotelAspects(List<String> FunThings) {
		List<String> hotelPropertiesStr = new ArrayList<>();
		for (WebElement aspect : hotelProperties) {
			hotelPropertiesStr.add(aspect.getText());
		}
		return FunThings.stream()
			.allMatch(funThing -> hotelPropertiesStr.stream().anyMatch(property -> property.equals(funThing)));
	}

	public boolean validateNavigateToDetailsPage() {
		return reserveOrBookNowButton.isDisplayed();
	}

	public void clickOnReserveButton() {
		reserveOrBookNowButton.click();
	}

	public String getHotelName() {
		return hotelName.getText();
	}

	public int getTotalAmount() {
		String amount = totalAmount.getText().substring(1);
		return Integer.parseInt(amount);
	}

	public int getAmountPerNight() {
		String amount = amountPerNight.getText();
		amount = amount.substring(1, amount.indexOf(" "));
		return Integer.parseInt(amount);
	}

	@FindBy(css = ".fs-4.fw-bold > input.me-3.fs-4")
	WebElement bookingCheckbox;

	public void clickBookingCheckbox() {
		bookingCheckbox.click();
	}

}