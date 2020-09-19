package TestrRpository;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.UserLoginData;
import ObjectRepository.UserRegestrationData;
import PageRepository.AuthenticationPage;
import PageRepository.CreateAccountPage;
import PageRepository.HomePage;

public class AuthincaitonTests extends TestBase {

    // Classes Variables
    AuthenticationPage Auth;
    HomePage Home;
    CreateAccountPage CreatAccount;

    // TestCases
    // TestCase to Verify That Create Account Box is Exist
    @Test
    public void VerfiyCreatAccountBoxIsExist() throws IOException, ParseException, InterruptedException {

	Home = new HomePage(driver.get());
	Auth = new AuthenticationPage(driver.get());
	Home.ClickLogin();
	Assert.assertTrue(Auth.getRegestedSubheading().contains("ALREADY REGISTERED?"));
    }

    // TestCase to Verify That Login Box is Exist
    @Test
    public void VerfiyLoginBoxIsExist() throws IOException, ParseException, InterruptedException {

	Auth = new AuthenticationPage(driver.get());
	Assert.assertTrue(Auth.getCreatAccounSubheading().contains("CREATE AN ACCOUNT"));
    }

    // TestCase to Verify Mandatory Email Filed to Create Account
    @Test(dependsOnMethods = "VerfiyCreatAccountBoxIsExist")
    public void VerfiyMandtoryEmailFiled() throws IOException, ParseException, InterruptedException {

	Auth = new AuthenticationPage(driver.get());
	Auth.ClickCreateAccount();
	Assert.assertTrue(Auth.EmailWarningElementIsDisplayed(driver.get()));
    }

    // Test Case To verify Create Account functionality
    @Test(dependsOnMethods = { "VerfiyCreatAccountBoxIsExist", "VerfiyMandtoryEmailFiled" })
    public void VerfiyCreateaccountButton() throws IOException, ParseException, InterruptedException {

	Auth = new AuthenticationPage(driver.get());
	CreatAccount = new CreateAccountPage(driver.get());
	Auth.CreateaccountSendEmail(UserRegestrationData.getEmail());
	Auth.ClickCreateAccount();
	Assert.assertTrue(CreatAccount.PageHeaderIsDisplayed(driver.get()));
    }

    // Test Case To verify Create Account functionality
    @Test(dependsOnMethods = "VerfiyCreateaccountButton")
    public void VerfiyLogintoRegistedAccount() throws IOException, ParseException, InterruptedException {

	Auth = new AuthenticationPage(driver.get());
	CreatAccount = new CreateAccountPage(driver.get());
	// 1.create account
	CreatAccount.FillRegestrationForm();
	// 2. sign out
	Home.ClickSignOut();
	// 3. login to same account
	Home.ClickLogin();
	Auth.SignInSendEmail(UserLoginData.getEmail());
	Auth.SignInSendPassword(UserLoginData.getPassword());
	Auth.ClickSiginIn();
	// verify the login info
	String UserFirstLastName = UserRegestrationData.getPersonalFirstName() + " "
		+ UserRegestrationData.getPersonalLastName();
	Assert.assertTrue(Home.getAccountDispyedName().contains(UserFirstLastName));
    }

}
