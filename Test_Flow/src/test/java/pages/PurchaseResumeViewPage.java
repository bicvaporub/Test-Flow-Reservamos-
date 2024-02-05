package pages;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PurchaseResumeViewPage extends Form {
    public PurchaseResumeViewPage() {
        super(By.xpath("//div[@class='steps-status']"), "purchaseView");
    }
}
