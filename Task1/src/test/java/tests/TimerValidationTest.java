package tests;

import config.EnvironmentConfig;
import pages.*;
import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TimerValidationTest extends BaseTest {
    private static final String TIMER = "00:00:00";
    private WelcomePage welcomePage;
    private GamePage gamePage;

    @Test
    public void timerValidation() {
        AqualityServices.getBrowser().goTo(EnvironmentConfig.getUrl());
        welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().waitForDisplayed(),"Welcome page should be open");
        welcomePage.clickHereLabel();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.state().waitForDisplayed(),"Game page should be open");
        Assert.assertEquals(gamePage.getTimerLabelText(), TIMER, String.format("Timer should be start from %s", TIMER));
    }
}
