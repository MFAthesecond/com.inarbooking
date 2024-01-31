package pages.carpages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CarConfigsRight extends BasePage {

    @FindBy(css = ".tab-item-car")
    private List<WebElement> carType;

    public void setCarTypes(String carTypes) {

        switch (carTypes) {
            case "small" -> carType.get(0).click();
            case "medium" -> carType.get(1).click();
            case "large" -> carType.get(2).click();
            case "minivan" -> carType.get(3).click();
            case "suv" -> carType.get(4).click();
        }
    }

    //cars appeared in the page after clicked on search button

    @FindBy(css = "div[class='fs-1 fw-bold mb-0']")
    private List<WebElement> carsAppeared;

    public List<Integer> pricesOfCarsInPage() {
        List<Integer> priceOfCars = new ArrayList<>();
        for (int i = 0; i < carsAppeared.size(); i++) {
            priceOfCars.add(Integer.parseInt(carsAppeared.get(i).getText().substring(1, carsAppeared.get(i).getText().indexOf("."))));
        }
        return priceOfCars;
    }

    @FindBy(css = ".lrb-btn")
    private List<WebElement> sortByButtons;

    public void sortByPriceLowest() {
        sortByButtons.get(0).click();
    }

    public void sortPriceHighest() {
        sortByButtons.get(1).click();
    }

    public int getTheNumberOfCarsInPage() {
        return carsAppeared.size();
    }


    @FindBy(css = ".listResult span.fs-4")
    private List<WebElement> carSpecsInPage;

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


}
