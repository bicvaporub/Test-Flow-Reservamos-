package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private final ITextBox departureTextBox = getElementFactory().getTextBox(By.xpath("//input[@class='origin es-input']"), "departureTextBox");
    private final ILabel departureOptionLabel = getElementFactory().getLabel(By.xpath("//div[@class='place-info place-info-column']"),"departureOptionLabel");
    private final ITextBox destinationTextBox = getElementFactory().getTextBox(By.xpath("//input[@class='destination es-input']"), "destinationTextBox");
    private final ILabel destinationOptionLabel = getElementFactory().getLabel(By.xpath("//div[@class='place-info place-info-column']"),"destinationOptionLabel");
    private final ITextBox departureDateTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@class,'departureDate')]"), "departureDateTextBox");
    private final ILabel departureDateOptionLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class,'departureDate')]//div[@aria-label='28-Feb-24']"),"departureDateOptionLabel");
    private final IButton searchButton = getElementFactory().getButton(By.xpath("//button[@class='search-button ']"),"searchButton");

    public HomePage() {
        super(By.xpath("//h1[@class='home-title']"), "home_title");
    }
    public void fillTravelForm(String departure, String destination) {
     departureTextBox.clearAndType(departure);
     departureTextBox.click();
     departureOptionLabel.click();
     destinationTextBox.clearAndType(destination);
     destinationTextBox.click();
     destinationOptionLabel.click();
     departureDateTextBox.click();
     departureDateOptionLabel.click();
     searchButton.click();
    }

}
