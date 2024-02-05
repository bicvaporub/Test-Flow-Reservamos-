package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GamePage extends Form {
    private final ILabel timerLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer--center')]"), "timer");
    private final CookiesForm cookiesForm;
    private final HelpForm helpForm;
    private final InterestForm interestForm;
    private final LoginForm loginForm;
    private final PersonalDetailsForm personalDetailsForm;

    public GamePage() {
        super(By.xpath("//div[@class='logo__icon']"), "logo_icon");
        cookiesForm = new CookiesForm();
        helpForm = new HelpForm();
        interestForm = new InterestForm();
        loginForm = new LoginForm();
        personalDetailsForm = new PersonalDetailsForm();
    }

    public CookiesForm getCookiesForm() {
        return cookiesForm;
    }

    public HelpForm getHelpForm() {
        return helpForm;
    }

    public InterestForm getInterestForm() {
        return interestForm;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        return personalDetailsForm;
    }

    public String getTimerLabelText() {
        return timerLabel.getElement().getText();
    }
}
