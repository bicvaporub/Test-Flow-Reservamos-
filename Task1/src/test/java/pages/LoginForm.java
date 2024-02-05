package pages;

import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import utils.RandomUtils;
import java.util.List;

public class LoginForm extends Form {

    private static final By DOMAIN_OPTION_LOCATOR = By.xpath("//div[@class='dropdown__list-item']");
    private final ITextBox passwordFieldTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Password')]"), "passwordField");
    private final ITextBox emailFieldTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "emailField");
    private final ITextBox domainFieldTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "domainField");
    private final IButton dropdownExtensionButton = getElementFactory().getButton(By.xpath("//div[contains(@class,'opener')]"), "dropdownExtension");
    private final ICheckBox acceptCheckbox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox__check')]"), "accept");
    private final ILabel nextLabel = getElementFactory().getLabel(By.xpath("//a[@class='button--secondary']"), "Next");

    public LoginForm() {
        super(By.xpath("//div[@class='login-form__container']"), "LoginForm");
    }

    public void completeLoginForm(String email, String password, String domain) {
        passwordFieldTextBox.clearAndType(password);
        emailFieldTextBox.clearAndType(email);
        domainFieldTextBox.clearAndType(domain);
    }

    public void clickDropdownExtensionButton() {
        dropdownExtensionButton.click();
    }

    public void selectAcceptCheckbox() {
        acceptCheckbox.click();
    }

    public void selectNextLabel() {
        nextLabel.click();
    }

    public void selectRandomDomain()  {
        List<IButton> buttons = getElementFactory().findElements(DOMAIN_OPTION_LOCATOR, IButton.class);
        buttons.get(RandomUtils.getRandomNumber(buttons.size())).click();
    }
}
