package PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCardPage extends PageBase {

    /** Constructor to init the web driver **/
    public ShoppingCardPage(WebDriver driver) {
	super(driver);

    }

    /** Locators to identify WebElements **/
    By CardProceedToCheckOut = By.xpath(
	    "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");
    By AddProceedToCheckOut = By
	    .xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");
    By ShippingProceedToCheckout = By
	    .xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");
    By OrderConfirmationButton = By.xpath("//span[contains(text(),'I confirm my order')]");
    By AgreeOnTerms = By.xpath("//label[contains(text(),'I agree to the terms of service and will adhere to')]");
    By BankWire = By.xpath("//a[@class='bankwire']");
    By PyamentHeader = By.xpath("//h3[@class='page-subheading']");
    By Cheque = By.xpath("//div[@class='box']");

    /** Function to Perform Actions over the Elements **/
    // Click ProceedToCheckOutButton from Shopping card
    public void CardProceedToCheckOutButton() {
	click_Element(driver.findElement(CardProceedToCheckOut));

    }

    // Click ProceedToCheckOutButton from Address
    public void AddProceedToCheckOutButton() {
	click_Element(driver.findElement(AddProceedToCheckOut));

    }

    // Click Proceed To Check out from Carier panel
    public void ShippingProceedToCheckOutButton() {
	click_Element(driver.findElement(ShippingProceedToCheckout));

    }

    // Click Agree On terms
    public void ClickAgreeOnTerm() {

	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(AgreeOnTerms)).click().build().perform();

    }

    // Select Bank Wire
    public void ClickBankWire() {
	click_Element(driver.findElement(BankWire));
    }

    // Click Agree on Terms
    public void ClickAgreeOnTerms() {
	click_Element(driver.findElement(AgreeOnTerms));

    }

    // Get the text of payment Header
    public String getPaymentHeaderText() {
	return get_text(driver.findElement(PyamentHeader));

    }

    // Select Bank Wire Option
    public void SelectBankWire() {

	click_Element(driver.findElement(BankWire));
    }

    // Click I confirm Payment
    public void ClickConfirmPayment() {

	click_Element(driver.findElement(OrderConfirmationButton));

    }

    // Get Text From Cheque
    public String GetRefrenceCode() {
	String RefrenceCode = null;
	String ChequeInfo = get_text(driver.findElement(Cheque));
	String[] Words = ChequeInfo.split(" ");
	for (int i = 0; i < Words.length; i++) {
	    if (Words[i].equalsIgnoreCase("reference")) {
		RefrenceCode = Words[i + 1];
		break;
	    }

	}

	return RefrenceCode;

    }

}
