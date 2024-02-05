package pages;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class PaymentPage extends Form {

    private final ITextBox purchaserFirstNameTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='purchaserFirstName']"), "purchaserFirstNameTextBox");
    private final ITextBox purchaserLastNameTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='purchaserLastName']"), "purchaserLastNameTextBox");
    private final IButton purchaserCountryCodeButton = getElementFactory().getButton(By.xpath("//select[@name='phoneCountry']"),"purchaserCountryCodeButton");
    private final IButton purchaserCountryCodeOptionButton = getElementFactory().getButton(By.xpath("//select[@name='phoneCountry']//option[@value='MX']"),"purchaserCountryCodeOptionButton");
    private final ITextBox purchaserPhoneNumberTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='phone']"), "purchaserPhoneNumberTextBox");
    private final ITextBox purchaserEmailTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='email']"), "purchaserEmailTextBox");
    private final IButton purchaserIdentityDocumentButton = getElementFactory().getButton(By.xpath("//select[@name='documentType']"),"purchaserIdentityDocumentButton");
    private final IButton purchaserIdentityDocumentOptionButton = getElementFactory().getButton(By.xpath("//select[@name='documentType']//option[@value='CC']"),"purchaserIdentityDocumentOptionButton");
    private final ITextBox purchaserIDNumberTextBox = getElementFactory().getTextBox(By.xpath("//input[@id='documentId']"), "purchaserIdNumberTextBox");
    private final IButton creditCardButton = getElementFactory().getButton(By.xpath("//p[text()='Crédito']"), "nextButton");
    private final ITextBox purchaserCreditCardNumberTextBox = getElementFactory().getTextBox(By.xpath("//div[@id='mercado_pago_form__cardNumber']"), "purchaserCreditCardNumberTextBox");
    private final ITextBox purchaserCreditCardExpirationDateTextBox = getElementFactory().getTextBox(By.xpath("//div[@id='mercado_pago_form__expirationDate']"), "purchaserCreditCardExpirationDateTextBox");
    private final ITextBox purchaserCreditCardCVVTextBox = getElementFactory().getTextBox(By.xpath("//div[@id='mercado_pago_form__securityCode']"), "purchaserCreditCardCVVTextBox");
    private final IButton purchaseButton = getElementFactory().getButton(By.xpath("//button[@class='main-button  ']"), "nextButton");
    public PaymentPage() {
        super(By.xpath("//div[@class='checkout-container ']"), "paymentForm");
    }
    public void fillPaymentForm(String name,String lastName,String phoneNumber, String email, String idNumber, String creditCardNumber, String creditCardExpirationDate, String creditCardCVV){
        purchaserFirstNameTextBox.clearAndType(name);
        purchaserLastNameTextBox.clearAndType(lastName);
        purchaserCountryCodeButton.click();
        purchaserCountryCodeOptionButton.click();
        purchaserPhoneNumberTextBox.clearAndType(phoneNumber);
        purchaserEmailTextBox.clearAndType(email);
        purchaserIdentityDocumentButton.click();
        purchaserIdentityDocumentOptionButton.click();
        purchaserIDNumberTextBox.clearAndType(idNumber);
        JavascriptExecutor js = (JavascriptExecutor) AqualityServices.getBrowser().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", purchaseButton.getElement());
        creditCardButton.click();
        purchaserCreditCardNumberTextBox.clearAndType(creditCardNumber);
        purchaserCreditCardExpirationDateTextBox.clearAndType(creditCardExpirationDate);
        purchaserCreditCardCVVTextBox.clearAndType(creditCardCVV);
        purchaseButton.click();
    }
}
