package config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataConfig {
    private static final ISettingsFile TEST_DATA_SETTINGS = new JsonSettingsFile("testData.json");

    public static String getDepartureLocation() {
        return TEST_DATA_SETTINGS.getValue("/departureLocation").toString();
    }
    public static String getDestinationLocation() {
        return TEST_DATA_SETTINGS.getValue("/destinationLocation").toString();
    }
    public static String getPassengerName() {
        return TEST_DATA_SETTINGS.getValue("/passengerName").toString();
    }
    public static String getPassengerLastName() {
        return TEST_DATA_SETTINGS.getValue("/passengerLastName").toString();
    }
    public static String getPassengerEmail() {
        return TEST_DATA_SETTINGS.getValue("/passengerEmail").toString();
    }
    public static String getPassengerIDNumber() {
        return TEST_DATA_SETTINGS.getValue("/idNumber").toString();
    }
    public static String getPurchaserName() {
        return TEST_DATA_SETTINGS.getValue("/creditCardName").toString();
    }
    public static String getPurchaserLastName() {
        return TEST_DATA_SETTINGS.getValue("/creditCardLastName").toString();
    }
    public static String getPurchaserPhoneNumber() {
        return TEST_DATA_SETTINGS.getValue("/creditCardPhoneNumber").toString();
    }
    public static String getPurchaserEmail() {
        return TEST_DATA_SETTINGS.getValue("/creditCardEmail").toString();
    }
    public static String getCreditCardNumber() {
        return TEST_DATA_SETTINGS.getValue("/creditCardNumber").toString();
    }
    public static String getCreditCardCVV() {
        return TEST_DATA_SETTINGS.getValue("/creditCardCVV").toString();
    }
    public static String getCreditCardExpirationDate() {
        return TEST_DATA_SETTINGS.getValue("/creditCardExpirationDate").toString();
    }
}
