package PageRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    /** Global Variables **/
    public WebDriver driver; // WebDriver
    public JavascriptExecutor js;

    /** Constructor to init the web driver and java executor **/
    public PageBase(WebDriver webDriver) {

	this.driver = webDriver;

	this.js = ((JavascriptExecutor) driver);

    }

    /** Common Function across testing process **/
    // Click on Element
    public void click_Element(WebElement Element) {

	Element.click();
    }

    // Send Text to Element
    public void Send_Keys(WebElement Element, String values) {

	Element.sendKeys(values.trim());
    }

    // Send Text to Element
    public void Send_Keys(WebElement Element, Keys modifierKey) {

	Element.sendKeys(modifierKey);
    }

    // Handling Drop down Selection by value
    public void SelectByValue(WebElement Element, String values) {
	Select s = new Select(Element);
	s.selectByValue(values);

    }

    // Handling Drop down Selection by Index
    public void SelectByIndexe(WebElement Element, int values) {
	Select s = new Select(Element);
	s.selectByIndex(values);

    }

    // Handling Drop down Selection by Visual Text
    public void SelectByVisualText(WebElement Element, String values) {
	Element.click();
	Select s = new Select(Element);
	s.selectByVisibleText(values);
    }

    // Extracting text from web Element
    public String get_text(WebElement Element) {

	return Element.getText();

    }

    // Check if Element is Displayed
    public boolean isDisplayed(WebElement Element) {

	return Element.isDisplayed();

    }

}
