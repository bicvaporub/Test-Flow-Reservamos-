package pages;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SeatsPage extends Form {

    private final IButton seatOption = getElementFactory().getButton(By.xpath("//button[@class='seat-available' and text()='03']"), "seatOptionButton");
    private final IButton continueButton = getElementFactory().getButton(By.xpath("//button[@class='main-button  ']"), "continueButton");


    public SeatsPage() {
        super(By.xpath("//div[@class='purchase-step-wrapper']"), "SeatsOptions");
    }
    public void selectSeatOption(){
        seatOption.click();
        JavascriptExecutor js = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", continueButton.getElement());
        continueButton.click();
    }
}
