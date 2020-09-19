package PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage extends PageBase {

    /** Constructor to init the super class **/
    public AuthenticationPage(WebDriver webDriver) {
	super(webDriver);

    }

    /** Locators to the elements **/
    protected By PageHeader = By.xpath("//h1[@class='page-heading']");
    protected By CreatAccounSubheading = By.xpath("//h3[contains(text(),'Create an account')]");
    protected By RegestedSubheading = By.xpath("//h3[contains(text(),'Already registered?')]");
    protected By CreateEmailFiled = By.xpath("//input[@id='email_create']");
    protected By LoginEmailFiled = By.xpath("//input[@id='email']");
    protected By LoginPasswordFiled = By.xpath("//input[@id='passwd']");
    protected By CreateAccountButton = By.xpath("//form[@id='create-account_form']//span[1]");
    protected By SignInButton = By.xpath("//p[@class='submit']//span[1]");
    protected By CreateAccountEmailValidation = By.xpath("//form[1]/div[1]/div[@class=\"alert alert-danger\"]");

    /** functions to find elements and perform actions **/
    // get page header Text
    public String getPageHeaderText() {
	return get_text(driver.findElement(PageHeader));

    }

    // get create account sub heading
    public String getCreatAccounSubheading() {
	return get_text(driver.findElement(CreatAccounSubheading));

    }

    // get register account sub heading
    public String getRegestedSubheading() {
	return get_text(driver.findElement(RegestedSubheading));

    }

    // send mail to create account
    public void CreateaccountSendEmail(String Email) {

	Send_Keys(driver.findElement(CreateEmailFiled), Email);
    }

    // click create account
    public void ClickCreateAccount() {

	click_Element(driver.findElement(CreateAccountButton));
    }

    // send mail to sign in account
    public void SignInSendEmail(String Email) {

	Send_Keys(driver.findElement(LoginEmailFiled), Email);
    }

    // send mail to sign in account
    public void SignInSendPassword(String pass) {

	Send_Keys(driver.findElement(LoginPasswordFiled), pass);
    }

    // Click Sign In
    public void ClickSiginIn() {

	click_Element(driver.findElement(SignInButton));
    }

    // Wait until validation message display and return
    public boolean EmailWarningElementIsDisplayed(WebDriver driver) {

	WebDriverWait wait = new WebDriverWait(driver, 40);

	return wait.until(ExpectedConditions.visibilityOf(driver.findElement(CreateAccountEmailValidation))) != null;

    }

}
