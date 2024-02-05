package pages;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PassengerPage extends Form {

    private final ITextBox passengerNameTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='passengers[0].firstName']"), "passengerNameTextBox");
    private final ITextBox passengerLastNameTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='passengers[0].lastName']"), "passengerLastNameTextBox");
    private final ITextBox passengerEmailTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='passengers[0].email']"), "passengerEmailTextBox");
    private final IButton passengerBornDayButton = getElementFactory().getButton(By.xpath("//select[@id='day-select']"),"passengerBornDayButton");
    private final IButton passengerBornDayOptionButton = getElementFactory().getButton(By.xpath("//select[@id='day-select']//option[@value='08']"),"passengerBornDayOptionButton");
    private final IButton passengerBornMonthButton = getElementFactory().getButton(By.xpath("//select[@id='month-select']"),"passengerBornMonthButton");
    private final IButton passengerBornMonthOptionButton = getElementFactory().getButton(By.xpath("//select[@id='month-select']//option[@value='07']"),"passengerBornMonthOptionButton");
    private final IButton passengerBornYearButton = getElementFactory().getButton(By.xpath("//select[@id='year-select']"),"passengerBornYearButton");
    private final IButton passengerBornYearOptionButton = getElementFactory().getButton(By.xpath("//select[@id='year-select']//option[@value='1975']"),"passengerBornYearOptionButton");
    private final IButton passengerNacionalityButton = getElementFactory().getButton(By.xpath("//select[@name='passengers[0].nationality']"),"passengerNacionalityButton");
    private final IButton passengerNacionalityOptionButton = getElementFactory().getButton(By.xpath("//select[@name='passengers[0].nationality']//option[@value='CO']"),"passengerNacionalityOptionButton");
    private final IButton passengerIdentityDocumentButton = getElementFactory().getButton(By.xpath("//select[@name='passengers[0].documentType']"),"passengerIdentityDocumentButton");
    private final IButton passengerIdentityDocumentOptionButton = getElementFactory().getButton(By.xpath("//select[@name='passengers[0].documentType']//option[@value='CC']"),"passengerIdentityDocumentOptionButton");
    private final ITextBox passengerIDNumberTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='passengers[0].documentId']"), "passengerIdNumberTextBox");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[@class='main-button  ']"), "nextButton");
    public PassengerPage() {
        super(By.xpath("//div[@class='passengers-container']"), "passengerForm");
    }
    public void fillPassengerForm(String name,String lastName, String email, String idNumber){
        passengerNameTextBox.clearAndType(name);
        passengerLastNameTextBox.clearAndType(lastName);
        passengerEmailTextBox.clearAndType(email);
        passengerBornDayButton.click();
        passengerBornDayOptionButton.click();
        passengerBornMonthButton.click();
        passengerBornMonthOptionButton.click();
        passengerBornYearButton.click();
        passengerBornYearOptionButton.click();
        passengerNacionalityButton.click();
        passengerNacionalityOptionButton.click();
        passengerIdentityDocumentButton.click();
        passengerIdentityDocumentOptionButton.click();
        passengerIDNumberTextBox.clearAndType(idNumber);
        JavascriptExecutor js = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", nextButton.getElement());
        nextButton.click();
    }
}
