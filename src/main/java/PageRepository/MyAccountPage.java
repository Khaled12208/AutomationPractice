package PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends PageBase {

    /** Constructor to invoke super constructor and init values **/
    public MyAccountPage(WebDriver driver) {
	super(driver);
    }

    /** Elements Locators **/
    By OrderHistory = By.xpath("//span[contains(text(),'Order history and details')]");

    /** Functions to perform Actions **/
    // Click on Order History
    public void ClickOrderHistory() {

	click_Element(driver.findElement(OrderHistory));

    }

}
