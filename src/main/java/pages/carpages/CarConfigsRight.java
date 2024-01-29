package pages.carpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CarConfigsRight {

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

    @FindBy(css = "div.fs-1.fw-bold.mb-0")
    private List<WebElement> carsAppeared;
    public List<String> pricesOfCarsInPage() {
        List<String> pricesOfCarsInThePage = new ArrayList<>();
        pricesOfCarsInThePage.add("bilal");
        System.out.println(carsAppeared.size());
        return pricesOfCarsInThePage;
    }




}
