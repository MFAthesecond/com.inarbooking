package pages.carpages;

import lombok.Data;

@Data
public class CarPages {
    //list olarak tut
    //.CarRentalItem
    //.tab-item-car
    //.form-control

    private CarConfigs carConfigs;
    private CarRentalsHomePage carRentalsHomePage;

    public CarPages() {
        carConfigs = new CarConfigs();
        carRentalsHomePage = new CarRentalsHomePage();
    }
}
