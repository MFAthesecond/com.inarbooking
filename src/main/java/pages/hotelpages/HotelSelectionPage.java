package pages.hotelpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HotelSelectionPage extends BasePage {

    @FindBy(css = " .searchItem:nth-child(1)")
    private static WebElement searchItemBox;


    public static WebElement seeAvailabilityButton(WebDriver driver) {
        return searchItemBox.findElement(By.cssSelector(".siCheckButton"));
    }

    public static WebElement evaluationScoreBox() {
        return searchItemBox.findElement(By.cssSelector("button:nth-child(2)"));
    }

    public static WebElement hotelNameBox() {
        return searchItemBox.findElement(By.cssSelector("//h1[contains(text(),'Urban Oasis Resort')]"));
    }

    public static WebElement locationInformation() {
        return searchItemBox.findElement(By.cssSelector(".siDistance"));
    }

    public static WebElement location() {
        return searchItemBox.findElement(By.cssSelector(".siDesc > h2.fs-5.m-0"));
    }

    public static WebElement locationCountry() {
        return searchItemBox.findElement(By.cssSelector(".siDesc > h2.fs-4.m-0"));
    }
}

// otel adı = div.siDesc > h1
// h1[contains(text(),'Urban Oasis Resort')]
// .siDesc
//h2[contains(text(), 'United States of America')]
//.siDesc > h2.fs-5.m-0   konum yazan kutucuk

  /* @FindBy (css = "button:nth-child(2)")
     private WebElement evaluationScoreBox;
 */
