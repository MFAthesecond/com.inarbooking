package pages.carpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;
import utils.DriverManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarConfigsRight extends BasePage {

	@FindBy(css = ".tab-item-car")
	private List<WebElement> carType;

	@FindBy(css = "div[class='fs-1 fw-bold mb-0']")
	private List<WebElement> carsAppeared;

	@FindBy(css = ".lrb-btn")
	private List<WebElement> sortByButtons;

	@FindBy(css = ".listResult span.fs-4")
	private List<WebElement> carSpecsInPage;

	@FindBy(css = ".mt-2")
	private List<WebElement> viewDealClickableElement;

	@FindBy(css = ".pagination-button-booking ")
	private List<WebElement> pageNumberClickableElement;

	@FindBy(css = "h3")
	private List<WebElement> carNamesAfterClickOnSelectButton;

	public void setCarTypes(String carTypes) {
		switch (carTypes) {
			case "small" -> carType.get(0).click();
			case "medium" -> carType.get(1).click();
			case "large" -> carType.get(2).click();
			case "minivan" -> carType.get(3).click();
			case "suv" -> carType.get(4).click();
		}
	}

	public List<Integer> getThePricesOfCarsInPage() {
		List<Integer> priceOfCars = new ArrayList<>();
		for (WebElement element : carsAppeared) {
			priceOfCars.add(Integer.parseInt(element.getText().substring(1, element.getText().indexOf("."))));
		}
		return priceOfCars;
	}

	public void sortByPriceLowest() {
		BrowserUtils.scrollToElement(sortByButtons.get(0));
		sortByButtons.get(0).click();
	}

	public void sortPriceHighest() {
		BrowserUtils.scrollToElement(sortByButtons.get(1));
		sortByButtons.get(1).click();
	}

	public int getTheNumberOfCarsInPage() {
		return carsAppeared.size();
	}

	public HashMap<Integer, List<String>> getCarSpecsFromShowedCars() {
		HashMap<Integer, List<String>> carSpecs = new HashMap<>();
		List<String> specForEachCar = new ArrayList<>();
		int numberOfCar = 0;
		for (int i = 0; i < carSpecsInPage.size(); i++) {
			if (i - 1 % carSpecsInPage.size() / getTheNumberOfCarsInPage() == 0) {
				carSpecs.put(numberOfCar, specForEachCar);
				numberOfCar++;
				carSpecs.clear();
			}
			specForEachCar.add(carSpecsInPage.get(i).getText());
		}
		carSpecs.remove(1);
		return carSpecs;
	}

	public List<String> getTheTransmission() {
		HashMap<Integer, List<String>> carSpecs = getCarSpecsFromShowedCars();
		List<String> carTransmissions = new ArrayList<>();
		for (int i = 0; i < carSpecs.size(); i++) {
			carTransmissions.add(carSpecs.get(i).get(1));
		}
		return carTransmissions;
	}

	public List<String> getTheCarCategory() {
		HashMap<Integer, List<String>> carSpecs = getCarSpecsFromShowedCars();
		List<String> carCategory = new ArrayList<>();
		for (int i = 0; i < carSpecs.size(); i++) {
			carCategory.add(carSpecs.get(i).get(3));
		}
		return carCategory;
	}

	public List<String> getThePickupLocation() {
		HashMap<Integer, List<String>> carSpecs = getCarSpecsFromShowedCars();
		List<String> pickUpLocation = new ArrayList<>();
		for (int i = 0; i < carSpecs.size(); i++) {
			pickUpLocation.add(carSpecs.get(i).get(5));
		}
		return pickUpLocation;
	}

	public void clickOnViewDealElement(String numberOfElement) {
		if (getTheNumberOfCarsInPage() != 0) {
			BrowserUtils.scrollToElement(viewDealClickableElement.get(Integer.parseInt(numberOfElement)));
			viewDealClickableElement.get(Integer.parseInt(numberOfElement)).click();
		}
	}

	public int getTheNumberOfPage() {
		return pageNumberClickableElement.size();
	}

	public int getTheSelectedCarPrice(String numberOfElement) {
		return getThePricesOfCarsInPage().get(Integer.parseInt(numberOfElement));
	}

	public String getTheSelectedCarName(String numberOfElement) {
		return carNamesAfterClickOnSelectButton.get(Integer.parseInt(numberOfElement)).getText();
	}

}
