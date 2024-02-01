package pages.hotelpages;

import pages.BasePage;
import pages.HomePage;

public class HotelPages extends BasePage {
    private HotelConfirmationPage hotelConfirmationPage;
    private HotelDetailsPage hotelDetailsPage;
    private HotelPage hotelPage;
    private HotelSelectionPage hotelSelectionPage;
    private HotelsFinalStep hotelsFinalStep;
    private HotelsYourDetailsPage hotelsYourDetailsPage;

    public HotelPages() {
        hotelConfirmationPage = new HotelConfirmationPage();
        hotelDetailsPage = new HotelDetailsPage();
        hotelPage = new HotelPage();
        hotelSelectionPage = new HotelSelectionPage();
        hotelsFinalStep = new HotelsFinalStep();
        hotelsYourDetailsPage = new HotelsYourDetailsPage();
    }
}
