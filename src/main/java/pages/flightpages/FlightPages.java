package pages.flightpages;

import lombok.Data;

@Data
public class FlightPages {

    private FlightHomePage flightHomePage;
    private FlightSelectionPage flightSelectionPage;
    private FlightExtrasPage flightExtrasPage;
    private FlightCheckAndPayPage flightCheckAndPayPage;
    private FlightFarePage flightFarePage;
    private FlightPassengerInformationPage flightPassengerInformationPage;

    public FlightPages() {
        flightHomePage = new FlightHomePage();
        flightSelectionPage = new FlightSelectionPage();
        flightExtrasPage = new FlightExtrasPage();
        flightCheckAndPayPage = new FlightCheckAndPayPage();
        flightFarePage = new FlightFarePage();
        flightPassengerInformationPage = new FlightPassengerInformationPage();
    }
}
