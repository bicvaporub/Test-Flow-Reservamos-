package tests;

import config.EnvironmentConfig;
import pages.*;
import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.Test;
import org.testng.Assert;

public class AcceptCookiesTest extends BaseTest {
    private WelcomePage welcomePage;
    private GamePage gamePage;

    @Test
    public void acceptCookies() {

        AqualityServices.getBrowser().goTo(EnvironmentConfig.getUrl());
        welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().waitForDisplayed(),"Welcome page should be displayed");
        welcomePage.clickHereLabel();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.getCookiesForm().state().waitForDisplayed(),"Cookie Form should be displayed");
        gamePage.getCookiesForm().clickAcceptCookiesButton();
        Assert.assertTrue(gamePage.getCookiesForm().state().waitForNotDisplayed(),"Form should be closed");
    }
}
