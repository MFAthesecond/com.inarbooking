package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSelectionPage extends BasePage {

	@FindBy(css = ".tab-item")
	private List<WebElement> tabList;

	@FindBy(css = ".searchItem")
	private List<WebElement> flightItemsList;

	@FindBy(css = ".lsItem-flights:nth-child(2) select")
	private WebElement originDropDown;

	@FindBy(css = ".lsItem-flights:nth-child(3) select")
	private WebElement destinationDropDown;

	@FindBy(css = ".lsItem-flights:nth-child(4) input")
	private WebElement departureDatePicker;

	@FindBy(css = ".lsItem-flights:nth-child(5) input")
	private WebElement returnDatePicker;

	@FindBy(css = ".lsItem-flights:nth-child(5) select")
	private WebElement oneWayAdultDropDown;

	@FindBy(css = ".lsItem-flights:nth-child(6) select")
	private WebElement adultDropDownForRoundTripAndChildDropDownForOneWay;

	@FindBy(css = ".lsItem-flights:nth-child(7) select")
	private WebElement childDropDown;

	@FindBy(css = ".lsItem-flights:nth-child(7) .d-flex")
	private List<WebElement> tripTypeListForOneWay;

	@FindBy(css = ".lsItem-flights:nth-child(8) .d-flex")
	private List<WebElement> tripTypeListForRoundTripAndCabinClassListForOneWay;

	@FindBy(css = ".lsItem-flights:nth-child(9) .lsCheckboxItem")
	private List<WebElement> cabinClassListForRoundTripAndAirlinesListForOneWay;

	@FindBy(css = ".lsItem-flights:nth-child(10) .lsCheckboxItem")
	private List<WebElement> airlinesListForRoundTripAndDurationListForOneWay;

	@FindBy(css = ".lsItem-flights:nth-child(11) .lsCheckboxItem")
	private List<WebElement> durationList;

	@FindBy(css = ".search-btn-flight button")
	private WebElement searchButton;

	@FindBy(css = ".pagination-booking button")
	private List<WebElement> paginationButtons;

	private WebElement getItem(int flightIndex) {
		if (flightIndex <= flightItemsList.size()) {
			return flightItemsList.get(flightIndex - 1);
		}
		throw new UnsupportedOperationException("There is no flight for the index");
	}

	public void clickOnSelectTicket(int flightIndex) {
		BrowserUtils.clickOnElement(getItem(flightIndex).findElement(By.cssSelector(".flight-button")));
	}

	public void selectDepartureDate(String date) {
		departureDatePicker.clear();
		departureDatePicker.sendKeys(date);
	}

	public void selectReturnDate(String date) {
		returnDatePicker.clear();
		returnDatePicker.sendKeys(date);
	}

	public String getSelectedDepartureDate() {
		String departureDate = departureDatePicker.getAttribute("value");
		String[] dividedDate = departureDate.split("-");
		return dividedDate[1] + "/" + dividedDate[2] + "/" + dividedDate[0];
	}

	public String getSelectedReturnDate() {
		String returnDate = returnDatePicker.getAttribute("value");
		String[] dividedDate = returnDate.split("-");
		return dividedDate[1] + "/" + dividedDate[2] + "/" + dividedDate[0];
	}

	public void clickOnTab(String tabName) {
		WebElement tab = tabList.stream().filter(element -> element.getText().equals(tabName)).findFirst().get();
		BrowserUtils.clickOnElement(tab);
	}

	public List<String> getItemInformation(int flightIndex) {
		List<String> flightInformationList = new ArrayList<>();
		flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".flight-title")).getText());
		flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".siCancelOpSubtitle")).getText());
		flightInformationList
			.add(getItem(flightIndex).findElement(By.cssSelector(".text-muted:nth-child(4)")).getText());
		flightInformationList
			.add(getItem(flightIndex).findElement(By.cssSelector(".text-muted:nth-child(4) + span")).getText());
		flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".flight-deperture-time")).getText());
		flightInformationList
			.add(getItem(flightIndex).findElement(By.cssSelector(".flight-deperture-time + span")).getText());
		flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".my-2:nth-child(1)")).getText());
		flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".my-2:nth-child(3)")).getText());
		flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".flight-arrival-time")).getText());
		flightInformationList
			.add(getItem(flightIndex).findElement(By.cssSelector(".flight-arrival-time + span")).getText());
		flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".siPrice")).getText());
		flightInformationList.add(getItem(flightIndex).findElement(By.cssSelector(".siTaxOp")).getText());
		flightInformationList
			.add(getItem(flightIndex).findElement(By.cssSelector(".text-muted:nth-child(3)")).getText());
		return flightInformationList;
	}

	public void clickOnPaginationButton(int buttonIndex) {
		BrowserUtils.clickOnElement(paginationButtons.get(buttonIndex - 1));
	}

	public void selectFromOriginDropDown(String originName) {
		Select select = new Select(originDropDown);
		select.selectByVisibleText(originName);
	}

	public void selectFromDestinationDropDown(String destinationName) {
		Select select = new Select(destinationDropDown);
		select.selectByVisibleText(destinationName);
	}

	public void selectFromAdultDropDownForRoundTrip(int adultNum) {
		Select select = new Select(adultDropDownForRoundTripAndChildDropDownForOneWay);
		select.selectByIndex(adultNum - 1);
	}

	public void selectFromChildDropDownForRoundTrip(int childNum) {
		Select select = new Select(childDropDown);
		select.selectByIndex(childNum);
	}

	public void selectTripTypeForRoundTrip(String tripTypeName) {
		WebElement tripType = tripTypeListForRoundTripAndCabinClassListForOneWay.stream()
			.filter(element -> element.findElement(By.cssSelector(".ms-2")).getText().equals(tripTypeName))
			.findFirst()
			.get();
		tripType.findElement(By.cssSelector("input")).click();
		BrowserUtils.clickOnElement(tripType.findElement(By.cssSelector("input")));
	}

	public void selectCabinClassForRoundTrip(String cabinClassName) {
		WebElement cabinClass = cabinClassListForRoundTripAndAirlinesListForOneWay.stream()
			.filter(element -> element.findElement(By.cssSelector("span")).getText().equals(cabinClassName))
			.findFirst()
			.get();
		BrowserUtils.clickOnElement(cabinClass.findElement(By.cssSelector("input")));
	}

	public void selectAirlinesForRoundTrip(String airlinesName) {
		WebElement airlines = airlinesListForRoundTripAndDurationListForOneWay.stream()
			.filter(element -> element.findElement(By.cssSelector("span")).getText().equals(airlinesName))
			.findFirst()
			.get();
		BrowserUtils.clickOnElement(airlines.findElement(By.cssSelector("input")));
	}

	public void selectDurationHoursForRoundTrip(String durationHoursName) {
		WebElement durationHours = durationList.stream()
			.filter(element -> element.findElement(By.cssSelector("span")).getText().equals(durationHoursName))
			.findFirst()
			.get();
		BrowserUtils.clickOnElement(durationHours.findElement(By.cssSelector("input")));
	}

	public void clickOnSearchButton() {
		BrowserUtils.clickOnElement(searchButton);
	}

	public void selectFromAdultDropDownForOneWay(int adultNum) {
		Select select = new Select(oneWayAdultDropDown);
		select.selectByIndex(adultNum - 1);
	}

	public void selectFromChildDropDownForOneWay(int childNum) {
		Select select = new Select(adultDropDownForRoundTripAndChildDropDownForOneWay);
		select.selectByIndex(childNum - 1);
	}

	public void selectTripTypeForOneWay(String tripTypeName) {
		WebElement tripType = tripTypeListForOneWay.stream()
			.filter(element -> element.findElement(By.cssSelector(".ms-2")).getText().equals(tripTypeName))
			.findFirst()
			.get();
		tripType.findElement(By.cssSelector("input")).click();
		BrowserUtils.clickOnElement(tripType.findElement(By.cssSelector("input")));
	}

	public void selectCabinClassForOneWay(String cabinClassName) {
		WebElement cabinClass = tripTypeListForRoundTripAndCabinClassListForOneWay.stream()
			.filter(element -> element.findElement(By.cssSelector("span")).getText().equals(cabinClassName))
			.findFirst()
			.get();
		BrowserUtils.clickOnElement(cabinClass.findElement(By.cssSelector("input")));
	}

	public void selectAirlinesForOneWay(String airlinesName) {
		WebElement airlines = cabinClassListForRoundTripAndAirlinesListForOneWay.stream()
			.filter(element -> element.findElement(By.cssSelector("span")).getText().equals(airlinesName))
			.findFirst()
			.get();
		BrowserUtils.clickOnElement(airlines.findElement(By.cssSelector("input")));
	}

	public void selectDurationHoursForOneWay(String durationHoursName) {
		WebElement durationHours = airlinesListForRoundTripAndDurationListForOneWay.stream()
			.filter(element -> element.findElement(By.cssSelector("span")).getText().equals(durationHoursName))
			.findFirst()
			.get();
		BrowserUtils.clickOnElement(durationHours.findElement(By.cssSelector("input")));
	}

	public List<Double> getFlightPrices() {
		return flightItemsList.stream()
			.flatMap(parent -> parent.findElements(By.cssSelector(".siPrice")).stream())
			.map(WebElement::getText)
			.map(element -> element.substring(1))
			.map(Double::parseDouble)
			.collect(Collectors.toList());
	}

	public List<Double> getFlightHours() {
		return flightItemsList.stream()
			.flatMap(parent -> parent.findElements(By.cssSelector(".my-2:nth-child(1)")).stream())
			.map(WebElement::getText)
			.map(element -> element.split(" ")[0])
			.map(Double::parseDouble)
			.collect(Collectors.toList());
	}

	private boolean isElementOnDropDownSelected(String elementName, WebElement dropDown) {
		Select select = new Select(dropDown);
		return select.getFirstSelectedOption().getText().equals(elementName);
	}

	public boolean isElementOnDropDownSelected(String elementName, String dropDownName) {
		switch (dropDownName) {
			case "Origin":
				return isElementOnDropDownSelected(elementName, originDropDown);
			case "Destination":
				return isElementOnDropDownSelected(elementName, destinationDropDown);
			case "AdultForRoundTrip", "ChildrenForOneWay":
				return isElementOnDropDownSelected(elementName, adultDropDownForRoundTripAndChildDropDownForOneWay);
			case "ChildrenForRoundTrip":
				return isElementOnDropDownSelected(elementName, childDropDown);
			case "AdultForOneWay":
				return isElementOnDropDownSelected(elementName, oneWayAdultDropDown);
			default:
				return false;
		}
	}

	private boolean isElementSelectedOnTripTypeList(String tripTypeName, String elementName) {
		WebElement webElement;
		if (tripTypeName.equals("Round Trip")) {
			webElement = tripTypeListForRoundTripAndCabinClassListForOneWay.stream()
				.filter(element -> element.findElement(By.cssSelector("div")).getText().equals(elementName))
				.findFirst()
				.get();
		}
		else {
			webElement = tripTypeListForOneWay.stream()
				.filter(element -> element.findElement(By.cssSelector("div")).getText().equals(elementName))
				.findFirst()
				.get();
		}
		return webElement.findElement(By.cssSelector("input")).isSelected();
	}

	private boolean isElementSelectedOnList(String elementName, List<WebElement> listName, String tripTypeName) {
		WebElement webElement = listName.stream()
			.filter(element -> element.findElement(By.cssSelector("span")).getText().equals(elementName))
			.findFirst()
			.get();
		return webElement.findElement(By.cssSelector("input")).isSelected();
	}

	public boolean isElementSelectedOnList(String elementName, String listName) {
		switch (listName) {
			case "TripTypeForRoundTrip":
				return isElementSelectedOnTripTypeList("Round Trip", elementName);
			case "TripTypeForOneWay":
				return isElementSelectedOnTripTypeList(" ", elementName);
			case "CabinClassForRoundTrip", "AirlinesForOneWay":
				return isElementSelectedOnList(elementName, cabinClassListForRoundTripAndAirlinesListForOneWay, " ");
			case "CabinClassForOneWay":
				return isElementSelectedOnList(elementName, tripTypeListForRoundTripAndCabinClassListForOneWay, " ");
			case "AirlinesForRoundTrip", "DurationForOneWay":
				return isElementSelectedOnList(elementName, airlinesListForRoundTripAndDurationListForOneWay, " ");
			case "DurationForRoundTrip":
				return isElementSelectedOnList(elementName, durationList, " ");
			default:
				return false;
		}
	}

}
