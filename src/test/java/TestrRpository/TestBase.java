package TestrRpository;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import ServicesRepository.DataReader;

public class TestBase {

    /********* Variables *************/
    public ThreadLocal<WebDriver> driver; // identify the web driver as thread local
    DataReader ReadData = new DataReader();

    /********* common methods across the test class *************/
    // Before Test Configuration
    @BeforeTest(alwaysRun = true)
    public void Browser_Init() throws IOException, ParseException {
	String DriverPath;
	// Reading the invocation data from external properties file
	HashMap<String, Object> InvocationData = ReadData.ReadInvocationData();
	String browser = (String) InvocationData.get("BrowserName");
	String url = (String) InvocationData.get("URL");
	int InvocationWidth = (Integer) InvocationData.get("InvocationWidth");
	int InvocationHeight = (Integer) InvocationData.get("InvocationHeight");
	// Selecting the appropriate driver based on the provided information
	if (browser.equals("chrome")) {
	    // GoogleChrome Browser configuration
	    driver = new ThreadLocal<WebDriver>();
	    DriverPath = System.getProperty("user.dir") + "\\DriversFiles\\chromedriver.exe";
	    System.setProperty("webdriver.chrome.driver", DriverPath);
	    driver.set(new ChromeDriver());

	    // FireFox Browser configuration
	} else if (browser.equals("firefox")) {
	    driver = new ThreadLocal<WebDriver>();
	    DriverPath = System.getProperty("user.dir") + "\\DriversFiles\\geckodriver.exe";
	    System.setProperty("webdriver.gecko.driver", DriverPath);
	    driver.set(new FirefoxDriver());

	    // Error Message
	} else {
	    System.out.println("Error ! Please Make sure you enter a valid brwoser name");

	}

	// Reading and loading the External data;
	ReadData.ReadRegestrationData();
	// Setting the windows size
	Dimension d = new Dimension(InvocationWidth, InvocationHeight);
	driver.get().manage().window().setSize(d);
	// Setting the implicit waiting.
	driver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	// navigate to the web site
	driver.get().get(url);

    }

    // After Test configuration
    @AfterTest(alwaysRun = true)
    public void Browser_Terdown() {

	// terminate Project
	driver.get().quit();

    }

}
