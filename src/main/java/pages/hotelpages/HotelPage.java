package pages.hotelpages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

@Data
public class HotelPage extends BasePage {

	@FindBy(css = "input.headerSearchInput")
	WebElement destinationInput;

	public void selectDestination(String destination) {
		destinationInput.sendKeys(destination);
	}

	@FindBy(css = ":nth-child(2) > .headerSearchText")
	WebElement datePicker;

	@FindBy(css = ".rdrMonthPicker > select")
	WebElement monthPicker;

	@FindBy(css = ".rdrDays > button")
	List<WebElement> allTheDays;

	List<WebElement> daysOfTheMonth = new ArrayList<>();

	@FindBy(css = ".display-2.text-left.w-100")
	WebElement hotelsField;

	public void selectMonth(int index) {
		datePicker.click();
		Select monthSelector = new Select(monthPicker);
		monthSelector.selectByIndex(index - 1);
		findTheMonthDates();
	}

	public void findTheMonthDates() {
		daysOfTheMonth = allTheDays.stream()
			.filter(button -> !button.getAttribute("class").contains("Passive"))
			.toList();
	}

	public void selectFirstDay(String firstDay) {
		daysOfTheMonth.get(Integer.parseInt(firstDay)).click();
	}

	public void selectLastDay(String lastDay) {
		daysOfTheMonth.get(Integer.parseInt(lastDay)).click();
		datePicker.click();
	}

	@FindBy(css = ":nth-child(3) > .headerSearchText")
	WebElement visitors;

	public void clickOnVisitors() {
		visitors.click();
	}

	@FindBy(css = ".optionCounterButton:nth-child(3)")
	List<WebElement> addButtons;

	@FindBy(xpath = "//button[text()='Done']")
	WebElement doneButton;

	public void selectAdultNumber(String strAdultNumber) {
		int adultNumber = Integer.parseInt(strAdultNumber);
		for (int i = 0; i < adultNumber - 1; i++) {
			addAdult();
		}
	}

	public void selectChildrenNumber(String strChildrenNumber) {
		int adultNumber = Integer.parseInt(strChildrenNumber);
		for (int i = 0; i < adultNumber; i++) {
			addChildren();
		}
	}

	public void selectRoomNumber(int strRoomNumber) {
		int adultNumber = strRoomNumber;// Integer.parseInt(strRoomNumber);
		for (int i = 0; i < adultNumber - 1; i++) {
			addRoom();
		}
		doneButton.click();
	}

	private void addAdult() {
		addButtons.get(0).click();
	}

	private void addChildren() {
		addButtons.get(1).click();
	}

	private void addRoom() {
		addButtons.get(2).click();
	}
	// There is no need to shrink numbers for now.
	// @FindBy(css = ".optionCounterButton:nth-child(1)")
	// List<WebElement> extractButtons;
	//
	// private void extractAdult() {
	// extractButtons.get(0).click();
	// }
	//
	// private void extractChildren() {
	// extractButtons.get(1).click();
	// }
	//
	// private void extractRoom() {
	// extractButtons.get(2).click();
	// }

	@FindBy(css = ".headerBtn")
	WebElement searchButton;

	public void clickOnSearchButton() {
		searchButton.click();
	}

}
