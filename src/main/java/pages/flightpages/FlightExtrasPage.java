package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;

import java.util.List;

public class FlightExtrasPage extends BasePage {

    @FindBy(css = ".reservationStepArea span")
    private List<WebElement> reservationSteps;

    @FindBy(css = "div[class='row w-100 m-0 py-5']")
    private WebElement extrasContainer;

    @FindBy(css = ".form-select")
    private WebElement mealDropDown;

    @FindBy(css = ".flight-reserve-card .mb-5 .form-check")
    private List<WebElement> extrasCheckBoxList;

    @FindBy(css = ".col-5 .flight-reserve-card")
    private WebElement priceCalculationContainer;

    public List<String> getReservationSteps(){
        return reservationSteps.stream().map(WebElement::getText).toList();
    }

    public List<String> getFlightInfo(){
       List<WebElement> flightInfo = extrasContainer.findElements(By.cssSelector("div[class='col-12 fs-3 text-muted'] span"));
       return flightInfo.stream().map(WebElement::getText).toList();
    }

    public String getRouteInfo(){
        return extrasContainer.findElement(By.cssSelector("div[class='col-12 display-2 fw-semibold text-dark']")).getText();
    }

    public void selectMeal(String meal){
        Select select = new Select(mealDropDown);
        select.selectByValue(meal);
    }

    public String getMealPrice(String meal){
        List<WebElement> mealOptions = mealDropDown.findElements(By.cssSelector("option"));
        List<String> mealsAndPrices = mealOptions.stream().map(WebElement::getText).toList();
        String mealAndPrice = mealsAndPrices.stream().filter(m -> m.contains(meal)).findFirst().get();
        String [] dividedMeal = mealAndPrice.split("\\$");
        return dividedMeal[dividedMeal.length - 1];
    }

    public void selectExtra(String extraName){
        WebElement extra = extrasCheckBoxList.stream().filter(element -> element.findElement(By.cssSelector("label")).getText().contains(extraName)).findFirst().get();
        extra.findElement(By.cssSelector("input")).click();
    }

    public String getExtraPrice(String extraName){
        WebElement extra = extrasCheckBoxList.stream().filter(element -> element.findElement(By.cssSelector("label")).getText().contains(extraName)).findFirst().get();
        String[] dividedExtra = extra.findElement(By.cssSelector("label")).getText().split(" ");
        String extraPrice = dividedExtra[dividedExtra.length - 1];
        return extraPrice.substring(0 , extraPrice.length() - 1);
    }

    public String getTicketPrice(){
       return priceCalculationContainer.findElement(By.cssSelector(".col-5 .flight-reserve-card .mb-3:nth-child(1) > div > span:nth-child(1)")).getText().substring(2);
    }






}
