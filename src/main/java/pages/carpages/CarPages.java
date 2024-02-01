package pages.carpages;

import lombok.Data;
import lombok.Getter;

@Getter
public class CarPages {
    //list olarak tut
    //.CarRentalItem
    //.tab-item-car
    //.form-control

    private CarConfigs carConfigs;
    private CarRentalsHomePage carRentalsHomePage;
    private CarConfigsRight carConfigsRight;
    private CarRentalCheckOut carRentalCheckOut;
    private CarInsurancePage carInsurancePage;

    public CarPages() {
        carConfigs = new CarConfigs();
        carRentalsHomePage = new CarRentalsHomePage();
        carConfigsRight = new CarConfigsRight();
        carRentalCheckOut = new CarRentalCheckOut();
        carInsurancePage = new CarInsurancePage();
    }


}
