package pages.carpages;

import org.openqa.selenium.*;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.v120.dom.DOM;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CarRentalsHomePage extends BasePage {

	private HashMap<String, String> locationHourDateInfos;

	@FindBy(css = ".headerList :nth-child(3)")
	private WebElement carRentalsElement;

	@FindBy(css = ".headerBtn")
	private WebElement searchCarsElement;

	@FindBy(css = "input[placeholder='Enter Pickup Location']")
	private WebElement pickUpLocationElement;

	@FindBy(css = ".location-li-rentcar")
	private List<WebElement> locationSuggestion;

	@FindBy(css = ".headerDateInput")
	private List<WebElement> pickAndDropDates;

	@FindBy(css = ".form-select > option")
	private List<WebElement> pickHourAndDropHour;

	@FindBy(css = ".form-select")
	private List<WebElement> pickHourAndDropHourSelection;

	public void clickOnCarRentalsElementsInHomePage() {
		carRentalsElement.click();
	}

	public void setPickupLocationByFullAddress(String pickUpLocation) {
		pickUpLocationElement.sendKeys(pickUpLocation);
		if (!locationSuggestion.isEmpty()) {
			locationSuggestion.get(0).click();
		}
	}

	public void setPickupLocation(String pickUpLocation, String numberOfSuggestion) {
		pickUpLocationElement.sendKeys(pickUpLocation);
		int numberOfSuggestionAsInteger = Integer.parseInt(numberOfSuggestion);
		if (locationSuggestion != null) {
			if (numberOfSuggestionAsInteger > locationSuggestion.size() - 1) {
				locationSuggestion.get(0).click();
			}
			else {
				locationSuggestion.get(numberOfSuggestionAsInteger).click();
			}
		}
	}

	public void setThePickUpDate(String value) {
		pickAndDropDates.get(0).click();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
		javascriptExecutor.executeScript("document.querySelector('." + "headerDateInput" + "').value='" + value + "'");
	}

	public void setTheDropOffDate(String value) {
		pickAndDropDates.get(1).click();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getDriver();
		javascriptExecutor.executeScript("document.querySelector('."
				+ "headerDateInput.form-control.fs-5.position-relative" + "').value='" + value + "'");
	}

	public void setThePickupHour(String pickUpHour_hh_mm_30min_intervals) {
		pickHourAndDropHourSelection.get(0).click();
		for (int i = 0; i < pickHourAndDropHour.size() / 2; i++) {
			if (pickUpHour_hh_mm_30min_intervals.equals(pickHourAndDropHour.get(i).getText())) {
				pickHourAndDropHour.get(i).click();
			}
		}
	}

	public void setTheDropOffHour(String dropOffHour_hh_mm_30min_intervals) {
		pickHourAndDropHourSelection.get(1).click();
		for (int i = pickHourAndDropHour.size() / 2; i < pickHourAndDropHour.size(); i++) {
			if (dropOffHour_hh_mm_30min_intervals.equals(pickHourAndDropHour.get(i).getText())) {
				pickHourAndDropHour.get(i).click();
			}
		}
	}

	public void clickOnSearchCarsElements() {
		searchCarsElement.click();
	}

	public String getThePickUpLocation() {
		return pickUpLocationElement.getAttribute("value");
	}

	public String getThePickupDate() {
		return pickAndDropDates.get(0).getAttribute("value");
	}

	public String getTheDropOffDate() {
		return pickAndDropDates.get(1).getAttribute("value");
	}

	public String getThePickupHour() {
		return pickHourAndDropHourSelection.get(0).getText();
	}

	public String getTheDropOffHour() {
		return pickHourAndDropHourSelection.get(1).getText();
	}

	public void setTheLocationHourDateInfos() {
		locationHourDateInfos = new HashMap<>();
		BrowserUtils.scrollToElement(pickUpLocationElement);
		System.out.println("4");
		locationHourDateInfos.put("PickupLocation", getThePickUpLocation());
		locationHourDateInfos.put("PickupDate", getThePickupDate());
		locationHourDateInfos.put("PickupHour", getThePickupHour());
		locationHourDateInfos.put("DropoffDate", getTheDropOffDate());
		locationHourDateInfos.put("DropoffHour", getTheDropOffHour());
	}

	public HashMap<String, String> getTheLocationHourDateInfos() {
		setTheLocationHourDateInfos();
		System.out.println("5");
		return locationHourDateInfos;
	}

	public void enterThePickUpDate(String date) {
		List<String> list = Arrays.asList(date.split("/"));
		actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
		pickAndDropDates.get(0).clear();
		list.forEach(data -> {
			pickAndDropDates.get(0).sendKeys(data);
		});
	}

	public void enterTheDropOffDate(String date) {
		List<String> list = Arrays.asList(date.split("/"));
		actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
		pickAndDropDates.get(1).clear();
		list.forEach(data -> {
			pickAndDropDates.get(1).sendKeys(data);
		});
	}

	public void acceptTheAlertMessage() {
		Alert alert = DriverManager.getDriver().switchTo().alert();
		alert.accept();
	}

	public boolean isAlertMessageAppeared() {
		Alert alert = DriverManager.getDriver().switchTo().alert();
		return alert.getText().length() > 1;
	}

}
