package pages;

import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    private final static By HELP_LOCATOR = By.xpath("//button[contains(@class,'help-form__send')]");
    private final IButton helpButton = getElementFactory().getButton(HELP_LOCATOR, "helpButton");

    public HelpForm() {
        super(HELP_LOCATOR, "helpForm");
    }

    public void clickHelpButton() {
        helpButton.click();
    }
}
