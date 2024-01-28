package utils;

import lombok.Getter;
import pages.CarRentalPage;
import pages.HomePage;

public class Pages {




    CarRentalPage carRentalPage;
    private HomePage homePage;


    public Pages() {
        homePage = new HomePage();
        carRentalPage = new CarRentalPage();
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public CarRentalPage getCarRentalPage() {
        return carRentalPage;
    }

}
