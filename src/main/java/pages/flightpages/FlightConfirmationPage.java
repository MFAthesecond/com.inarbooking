package pages.flightpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.BrowserUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightConfirmationPage extends BasePage {
    @FindBy(css = ".confirmation-number span:nth-child(2)")
    private WebElement confirmationNumber;

    @FindBy(css = ".second")
    private WebElement departureContainer;

    @FindBy(css = ".first")
    private WebElement returnContainer;

    @FindBy(css = ".your-reservation")
    private WebElement reservationCard;
    @FindBy(xpath = "//button[normalize-space()='Close']")
    private WebElement closeButton;
    @FindBy(xpath = "//div[@class='thanks']//h1[contains(text(),'Thank you for your booking')]")
    private WebElement confirmationMessage;


    private WebElement getContainer(String containerName){
        WebElement container = departureContainer;
        switch (containerName){
            case "departure" : container = departureContainer;break;
            case "return" : container = returnContainer;
        }
        return container;
    }

    public Map<String , String> getContainerInfo(String containerName){
        Map<String , String> containerInfo = new HashMap<>();
        containerInfo.put("rating" , getContainer(containerName).findElement(By.cssSelector(".italic")).getText());
        containerInfo.put("gmail" , getContainer(containerName).findElement(By.cssSelector(".thanks .fs-3  .fw-bold")).getText());
        containerInfo.put("route" , getContainer(containerName).findElement(By.cssSelector(".fs-4 i")).getText());
        containerInfo.put("load info" , getContainer(containerName).findElement(By.cssSelector(".ul li:nth-child(1) div:nth-child(2)")).getText());
        containerInfo.put("flight extras" , getContainer(containerName).findElement(By.cssSelector(".ul li:nth-child(2) div:nth-child(2)")).getText());
        containerInfo.put("takeoff airport" , getContainer(containerName).findElement(By.cssSelector("div > span:nth-child(1) br:nth-child(1)")).getText());
        containerInfo.put("takeoff time" , getContainer(containerName).findElement(By.cssSelector("div > span:nth-child(1) br:nth-child(2)")).getText());
        containerInfo.put("flight time" , getContainer(containerName).findElement(By.cssSelector(".w-50 span")).getText());
        containerInfo.put("arrival airport" , getContainer(containerName).findElement(By.cssSelector(".about-hotel span:nth-child(3) br:nth-child(1)")).getText());
        containerInfo.put("arrival time" , getContainer(containerName).findElement(By.cssSelector(".about-hotel span:nth-child(3) br:nth-child(2)")).getText());
        return containerInfo;
    }
    public void clickOnCloseButton(){
        BrowserUtils.clickOnElement(closeButton);
    }

    public List<String> getReservationInfo(){
        List<WebElement> reservationInfo = reservationCard.findElements(By.cssSelector(".your-reservation .w-100 > div"));
        return reservationInfo.stream().map(WebElement::getText).toList();
    }
    public void clickOnGetPrintVersion(String containerName){
        BrowserUtils.clickOnElement(getContainer(containerName).findElement(By.cssSelector("button")));
    }
public boolean isConfirmationMessageDisplayed(){
       return confirmationMessage.isDisplayed();
}
}
