package stepdefinitions.carstepdefinitions;

import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinitions.BaseStep;
import utils.BrowserUtils;
import utils.Pages;

import java.util.LinkedList;
import java.util.List;

public class CarRentalSteps extends BaseStep {


    @Test
    public void xxx() {
        PAGES.getHomePage().clickBookingLink();
        BrowserUtils.wait(3);
        PAGES.getCarPages().getCarRentalsHomePage().clickOnCarRentalsElementsInHomePage();
        PAGES.getCarPages().getCarRentalsHomePage().clickOnSearchCarsElements();
        BrowserUtils.scrollDownWithPageDownButton(1);
        WebElement xx = DRIVER.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) " +
                "> div:nth-child(2) > div:nth-child(1) > button:nth-child(3)"));
        xx.click();
        WebElement yy = DRIVER.findElement(By.cssSelector(".btn.btn-blue.fs-4.px-5.py-3.w-100"));
        yy.click();
        BrowserUtils.scrollDownWithJavaScript(0, 400);
        PAGES.getCarPages().getCarRentalCheckOut().setOnCountriesPhoneNumber("canada");
        PAGES.getCarPages().getCarRentalCheckOut().setCity("ohio");
        PAGES.getCarPages().getCarRentalCheckOut().setPostalCode("10200");
        BrowserUtils.scrollDownWithJavaScript(0, 800);
        PAGES.getCarPages().getCarRentalCheckOut().setCardNumber("485444444444444444444444444444");


    }


}
