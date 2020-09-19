package PageRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage extends PageBase {

    /** this constructor to init the super class **/
    public OrderHistoryPage(WebDriver webDriver) {
	super(webDriver);
    }

    // Elements Locator
    By OrderTabel = By.xpath("//table[@id='order-list']/tbody");

    /** Function to Perform Actions over the Elements **/
    // this function to return the
    public ArrayList<String> GetOrderRefrenceList() {
	ArrayList<String> RefernceCodesList = new ArrayList<String>();
	WebElement Tabel = driver.findElement(OrderTabel);
	List<WebElement> Rows = Tabel.findElements(By.xpath("tr"));
	Iterator<WebElement> itr = Rows.iterator();
	while (itr.hasNext()) {

	    List<WebElement> column = itr.next().findElements(By.xpath("td"));
	    Iterator<WebElement> itc = column.iterator();
	    RefernceCodesList.add(itc.next().getText());
	}
	return RefernceCodesList;
    }
}
