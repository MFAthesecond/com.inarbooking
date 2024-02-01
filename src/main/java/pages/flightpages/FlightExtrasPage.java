package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.BasePage;
import utils.BrowserUtils;

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
        BrowserUtils.clickOnElement(extra.findElement(By.cssSelector("input")));
    }

    public String getExtraPrice(String extraName){
        WebElement extra = extrasCheckBoxList.stream().filter(element -> element.findElement(By.cssSelector("label")).getText().contains(extraName)).findFirst().get();
        String[] dividedExtra = extra.findElement(By.cssSelector("label")).getText().split(" ");
        String extraPrice = dividedExtra[dividedExtra.length - 1];
        return extraPrice.substring(0 , extraPrice.length() - 1);
    }

    public String getTicketPrice(){
       return priceCalculationContainer.findElement(By.cssSelector(".mb-3:nth-child(1) > div > span:nth-child(1)")).getText().substring(2);
    }

    public String getTaxesAndFeesPercentage(){
        String taxesAndFees = priceCalculationContainer.findElement(By.cssSelector(".mb-3:nth-child(2)  > span:nth-child(1)")).getText();
        String[] dividedTaxesAndFees = taxesAndFees.split("%");
        String percentage = dividedTaxesAndFees[dividedTaxesAndFees.length - 1];
        return percentage.charAt(0) + "";
    }

    public String getThirdPartyFeePercentage(){
        String thirdPartyFee = priceCalculationContainer.findElement(By.cssSelector(".mb-3:nth-child(3)  > span:nth-child(1)")).getText();
        String[] dividedThirdPartyFee = thirdPartyFee.substring(thirdPartyFee.indexOf("%") + 1).split(" ");
        return dividedThirdPartyFee[0];
    }

    public String getTotalPrice(){
        String[] dividedPrice = priceCalculationContainer.findElement(By.cssSelector("h1:nth-child(2)")).getText().split("\\$");
        return dividedPrice[dividedPrice.length - 1];
    }

    public Double getCalculatedTotalPrice(){
        double ticketPrice = Double.parseDouble(getTicketPrice());
        double taxesAndFeesPercentage = Double.parseDouble(getTaxesAndFeesPercentage());
        double thirdPartyFeePercentage = Double.parseDouble(getThirdPartyFeePercentage());
        double totalPrice = ticketPrice + ((ticketPrice * taxesAndFeesPercentage) / 100) + ((ticketPrice * thirdPartyFeePercentage) / 100);
        return Double.parseDouble(String.format("%.2f", totalPrice));
    }

    public void clickOnBackButton(){
        BrowserUtils.clickOnElement(extrasContainer.findElement(By.cssSelector("button:nth-child(1)")));
    }
    public void clickOnGoToCheckOutButton(){
       BrowserUtils.clickOnElement(extrasContainer.findElement(By.cssSelector("button:nth-child(2)")));
    }
}
