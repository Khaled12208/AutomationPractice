package PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends PageBase {

    /** Constructor to init the super class **/
    public HomePage(WebDriver Driver) {
	super(Driver);
    }

    /** locators of the web elements **/
    protected By SignIn = By.xpath("//a[@class='login']");
    protected By Women = By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]");
    protected By Blouses = By
	    .xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Blouses')]");
    protected By MyAccount = By
	    .xpath("//div[@class=\"header-container\"]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]");
    protected By SignOut = By.xpath("//a[@class='logout']");

    /** performing action on the elements **/
    // Click Sign in Button
    public void ClickLogin() {

	click_Element(driver.findElement(SignIn));

    }

    // Hover Over Women List
    public void HoverOverWomenMenue() {
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(Women)).build().perform();

    }

    // Select Blouses item from Women List
    public void SelectBlouses() {
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(Blouses)).click().build().perform();

    }

    // view My Account
    public void ViewMyAccount() {
	click_Element(driver.findElement(MyAccount));

    }

    // Get Displayed account Name
    public String getAccountDispyedName() {

	return get_text(driver.findElement(MyAccount));
    }

    // Click sign Out
    public void ClickSignOut() {
	click_Element(driver.findElement(SignOut));

    }
}
