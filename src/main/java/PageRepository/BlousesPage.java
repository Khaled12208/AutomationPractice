package PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class BlousesPage extends PageBase {

    // Constructor to init the class
    public BlousesPage(WebDriver webDriver) {
	super(webDriver);

    }

    // identify the Locators
    By ProductContainer = By.xpath("//div[@class='product-container']");
    By AddToCard = By.xpath("//div[@class=\"product-container\"]/div[2]/div[2]/a[1]");
    By ProceedToCheck = By.xpath("//span[contains(text(),'Proceed to checkout')]");

    // Methods to perform action over the elements
    public void HoverOverProductContainer() {

	Point ProductLocation = driver.findElement(ProductContainer).getLocation();
	js.executeScript("window.scrollTo" + ProductLocation + "");
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(ProductContainer)).build().perform();
    }

    // ClickAddto Card
    public void ClickAddToCard() {
	click_Element(driver.findElement(AddToCard));

    }

    // ClickProceedToCheckOut
    public void ClickProceedToCheckOut() {
	click_Element(driver.findElement(ProceedToCheck));

    }
}
