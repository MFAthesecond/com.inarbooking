package pages.hotelpages;

import lombok.Data;

@Data
public class HotelPages {

	private HotelConfirmationPage hotelConfirmationPage;

	private HotelDetailsPage hotelDetailsPage;

	private HotelPage hotelPage;

	private HotelSelectionPage hotelSelectionPage;

	private HotelsPaymentPage hotelsPaymentPage;

	private HotelsYourDetailsPage hotelsYourDetailsPage;

	public HotelPages() {
		hotelConfirmationPage = new HotelConfirmationPage();
		hotelDetailsPage = new HotelDetailsPage();
		hotelPage = new HotelPage();
		hotelSelectionPage = new HotelSelectionPage();
		hotelsPaymentPage = new HotelsPaymentPage();
		hotelsYourDetailsPage = new HotelsYourDetailsPage();
	}

}
