package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class FlightFarePage extends BasePage {

    @FindBy(css = ".reservationStepArea span")
    private List<WebElement> reservationSteps;

    @FindBy(css = "div[class='row w-100 m-0 py-5']")
    private WebElement departureContainer;

    @FindBy(css = "div[class='row w-100 m-0 py-5 mt-5']")
    private WebElement returnContainer;

    public List<String> getReservationSteps(){
        return reservationSteps.stream().map(WebElement::getText).toList();
    }

    private WebElement getContainer(String containerName){
        WebElement container = departureContainer;
        switch (containerName){
            case "departure" : container = departureContainer; break;
            case "return" : container = returnContainer;
        }
        return container;
    }
    public List<String> getContainerInfo(String containerName){
       List<WebElement> containerInfo =  getContainer(containerName).findElements(By.cssSelector("div[class='col-12 fs-3 text-muted'] span"));
       return containerInfo.stream().map(WebElement::getText).toList();
    }

    public String getContainerDirection(String containerName){
        return getContainer(containerName).findElement(By.cssSelector("div[class='col-12 display-2 fw-semibold text-dark']")).getText();
    }
    private WebElement getFareContainer(String containerName , String fareType){
        List<WebElement> fareTypes = getContainer(containerName).findElements(By.cssSelector(".fare-item-inner"));
        WebElement fare = fareTypes.stream().filter(element -> element.findElement(By.cssSelector(".fare-item-inner .fare-item-header span")).getText().equals(fareType)).findFirst().get();
        return fare;
    }
    public void clickOnFareType(String containerName , String fareType){
        getFareContainer(containerName , fareType).findElement(By.cssSelector(".icn")).click();
    }

    public List<String> getFareIncludeInfo(String containerName ,String fareType){
        List<WebElement> fareInfoList = getFareContainer(containerName ,fareType).findElements(By.cssSelector(".fare-item-body > div:nth-child(1) > div > span:nth-child(2)"));
        return fareInfoList.stream().map(WebElement::getText).toList();
    }

    public String getFarePrice(String containerName ,String fareType){
        return getFareContainer(containerName , fareType).findElement(By.cssSelector(".fare-item-inner .mt-5 span:nth-child(2)")).getText();
    }

    public String getPersonInfoOnFareContainer(String containerName , String fareType){
        return getFareContainer(containerName, fareType).findElement(By.cssSelector(".d-block span")).getText();
    }

    public void clickOnBackButton(){
        returnContainer.findElement(By.cssSelector("button:nth-child(1)"));
    }
    public void clickOnSelectWhoFlyingButton(){
        returnContainer.findElement(By.cssSelector("button:nth-child(2)"));
    }


}
