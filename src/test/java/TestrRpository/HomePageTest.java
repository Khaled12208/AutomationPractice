package TestrRpository;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageRepository.AuthenticationPage;
import PageRepository.BlousesPage;
import PageRepository.HomePage;

public class HomePageTest extends TestBase {

    /** Variables **/
    HomePage Home;
    AuthenticationPage Auth;
    BlousesPage Blous;

    /** Classes test cases **/
    // Test Case to Verify windows size
    @Test
    public void VerfiyWindowsSize() throws IOException, ParseException, InterruptedException {

	// extracting the window dimensions
	Dimension dim = driver.get().manage().window().getSize();
	// Verify the dim values
	Assert.assertEquals(dim.height, 768);
	Assert.assertEquals(dim.width, 1024);

    }

    // Test Case to Verify Sign in Button Functionality
    @Test
    public void VerfiyNavigatioToAuthincaitonPage() throws IOException, ParseException, InterruptedException {

	Home = new HomePage(driver.get());
	Auth = new AuthenticationPage(driver.get());
	Home.ClickLogin();
	Assert.assertTrue(Auth.getPageHeaderText().contains("AUTHENTICATION"));

    }

}
