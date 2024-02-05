package pages;

import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class CookiesForm extends Form {

    private final IButton acceptCookiesButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'transparent')]"), "acceptCookies");

    public CookiesForm() {
        super(By.xpath("//div[@class='cookies']"), "Cookies Form");
    }

    public void clickAcceptCookiesButton() {
        acceptCookiesButton.click();
    }
}
