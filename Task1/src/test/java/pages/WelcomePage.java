package pages;

import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class WelcomePage extends Form {

    private final ILabel hereLabel = getElementFactory().getLabel(By.xpath("//a[@class='start__link']"), "HERE");

    public WelcomePage() {
        super(By.xpath("//div[@class='logo__icon']"), "logo_icon");
    }

    public void clickHereLabel() {
        hereLabel.click();
    }
}
