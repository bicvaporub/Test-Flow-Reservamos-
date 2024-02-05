package tests;

import config.EnvironmentConfig;
import config.TestDataConfig;
import pages.*;
import aquality.selenium.browser.AqualityServices;
import org.testng.annotations.Test;
import org.testng.Assert;
import utils.RandomUtils;

public class DisplayCardsTest extends BaseTest {

    private static final int EMAIL_LENGTH = 8;
    private static final int DOMAIN_LENGTH = 8;
    private static final int PASSWORD_LENGTH = 10;
    private static final int NUMBER_OF_INTEREST = 3;
    private WelcomePage welcomePage;
    private GamePage gamePage;

    @Test
    public void displayCards() {
        AqualityServices.getBrowser().goTo(EnvironmentConfig.getUrl());
        welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().waitForDisplayed(), "Welcome page should be open");
        welcomePage.clickHereLabel();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.getLoginForm().state().waitForDisplayed(),"The card 'Login Form' should be open");
        String randomEmail = RandomUtils.generateRandomString(EMAIL_LENGTH);
        String randomDomain = RandomUtils.generateRandomString(DOMAIN_LENGTH);
        String randomPassword = RandomUtils.generateRandomPassword(randomEmail, PASSWORD_LENGTH);
        gamePage.getLoginForm().completeLoginForm(randomEmail,randomPassword,randomDomain);
        gamePage.getLoginForm().clickDropdownExtensionButton();
        gamePage.getLoginForm().selectRandomDomain();
        gamePage.getLoginForm().selectAcceptCheckbox();
        gamePage.getLoginForm().selectNextLabel();
        Assert.assertTrue(gamePage.getInterestForm().state().waitForDisplayed(),"The card 'Interest Form' should be open");
        gamePage.getInterestForm().unselectAllCheckbox();
        gamePage.getInterestForm().selectRandomInterests(NUMBER_OF_INTEREST);
        gamePage.getInterestForm().clickUploadButton();
        gamePage.getInterestForm().uploadFile(TestDataConfig.getFilePath());
        gamePage.getInterestForm().clickNextButton();
        Assert.assertTrue(gamePage.getPersonalDetailsForm().state().waitForDisplayed(),"The card 'Personal Details Form' should be open");
    }
}
