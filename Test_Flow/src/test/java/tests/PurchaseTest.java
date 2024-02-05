package tests;

import config.EnvironmentConfig;
import config.TestDataConfig;
import pages.*;
import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.Test;
import org.testng.Assert;

public class PurchaseTest extends BaseTest {
    private static final int NUMBER_OF_SEATS = 1;
    private HomePage homePage;
    private TripOptionsPage tripOptionsPage;
    private SeatsPage seatsPage;
    private PassengerPage passengerPage;
    private PaymentPage paymentPage;
    private PurchaseResumeViewPage purchaseResumeViewPage;
    @Test
    public void purchaseTest() {

        AqualityServices.getBrowser().goTo(EnvironmentConfig.getUrl());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(),"The provide URL should be opened");
        homePage.fillTravelForm(TestDataConfig.getDepartureLocation(), TestDataConfig.getDestinationLocation());
        tripOptionsPage = new TripOptionsPage();
        Assert.assertTrue(tripOptionsPage.state().waitForDisplayed(),"The Trip Options Page should be displayed");
        tripOptionsPage.selectTripOption();
        seatsPage = new SeatsPage();
        Assert.assertTrue(seatsPage.state().waitForDisplayed(),"The Seat Details Page should be displayed");
        seatsPage.selectSeatOption();
        passengerPage = new PassengerPage();
        Assert.assertTrue(passengerPage.state().waitForDisplayed(),"The Passenger Details Page should be displayed");
        passengerPage.fillPassengerForm(TestDataConfig.getPassengerName(),TestDataConfig.getPassengerLastName(),TestDataConfig.getPassengerEmail(),TestDataConfig.getPassengerIDNumber());
        paymentPage = new PaymentPage();
        Assert.assertTrue(paymentPage.state().waitForDisplayed(),"The Payment Details Page should be displayed");
        paymentPage.fillPaymentForm(TestDataConfig.getPurchaserName(),TestDataConfig.getPurchaserLastName(),TestDataConfig.getPurchaserPhoneNumber(), TestDataConfig.getPurchaserEmail(), TestDataConfig.getPassengerIDNumber(), TestDataConfig.getCreditCardNumber(), TestDataConfig.getCreditCardExpirationDate(), TestDataConfig.getCreditCardCVV());
        purchaseResumeViewPage = new PurchaseResumeViewPage();
        Assert.assertTrue(purchaseResumeViewPage.state().waitForDisplayed(),"The Purchase Resume View Page should be displayed");
    }
}
