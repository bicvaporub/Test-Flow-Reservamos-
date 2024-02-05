package pages;
import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class TripOptionsPage extends Form {

    private final ILabel tripOption = getElementFactory().getLabel(By.xpath("/html/body/div/div/div/div[3]/div[3]/div[4]/div/div[1]/div[1]/div/div/div[1]/div/div[2]/div[3]/button"), "tripOption");


    public TripOptionsPage() {
        super(By.xpath("//div[@class='departures-container']"), "departuresOptions");
    }
    public void selectTripOption(){
     tripOption.click();
    }
}
