package tests;

import config.EnvironmentConfig;
import pages.*;
import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.Test;
import org.testng.Assert;

public class HideHelpFormTest extends BaseTest {

    private WelcomePage welcomePage;
    private GamePage gamePage;

    @Test
    public void hideHelpForm() {
        AqualityServices.getBrowser().goTo(EnvironmentConfig.getUrl());
        welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().waitForDisplayed(),"Welcome page should be open");
        welcomePage.clickHereLabel();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.getHelpForm().state().waitForDisplayed(),"Form content should be appears");
        gamePage.getHelpForm().clickHelpButton();
        Assert.assertTrue(gamePage.getHelpForm().state().waitForNotDisplayed(),"Form content should be hidden");
    }
}
