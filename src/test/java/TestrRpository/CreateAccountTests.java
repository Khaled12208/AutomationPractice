package TestrRpository;

import org.testng.annotations.Test;

import ObjectRepository.UserRegestrationData;
import PageRepository.AuthenticationPage;
import PageRepository.CreateAccountPage;
import PageRepository.HomePage;
import junit.framework.Assert;

public class CreateAccountTests extends TestBase {

    /** variables ***/
    AuthenticationPage Auth;
    HomePage Home;
    CreateAccountPage CreatAccount;

    /** Test Cases ***/
    // Test Case to Validate the Email is Already Inserted
    @Test
    public void validatEmailIsInsrted() throws InterruptedException {
	Home = new HomePage(driver.get());
	Auth = new AuthenticationPage(driver.get());
	CreatAccount = new CreateAccountPage(driver.get());
	Home.ClickLogin();
	Auth.CreateaccountSendEmail(UserRegestrationData.getEmail());
	Auth.ClickCreateAccount();
	Assert.assertTrue(CreatAccount.getValueOfEmail());
    }

    // Test Case to Validate All Mandatory Filed
    @Test
    public void validateMandatoryFiled() {

	CreatAccount = new CreateAccountPage(driver.get());
	CreatAccount.clickRegister();
	Assert.assertTrue(CreatAccount.ValidateMandtoryFileds().contains("at least one phone number"));
	Assert.assertTrue(CreatAccount.ValidateMandtoryFileds().contains("lastname is required."));
	Assert.assertTrue(CreatAccount.ValidateMandtoryFileds().contains("firstname is required."));
	Assert.assertTrue(CreatAccount.ValidateMandtoryFileds().contains("passwd is required."));
	Assert.assertTrue(CreatAccount.ValidateMandtoryFileds().contains("choose a State"));
    }

    // Test Case to Validate Password Filed Limits
    @Test
    public void validatePasswordFiledLimits() throws InterruptedException {

	CreatAccount = new CreateAccountPage(driver.get());
	CreatAccount.SendPassword("1234");
	Assert.assertTrue(CreatAccount.ValidatePasswordLimits().contains("form-error"));

    }

    // Test Case To Validate End to End Registration Process
    @Test(dependsOnMethods = { "validatePasswordFiledLimits", "validateMandatoryFiled", "validatEmailIsInsrted" })
    public void ValidateUserRegestration() throws InterruptedException {

	CreatAccount = new CreateAccountPage(driver.get());
	// fill information filed
	CreatAccount.FillRegestrationForm();
	// Verify Authenciation
	Home = new HomePage(driver.get());
	String UserFirstLastName = UserRegestrationData.getPersonalFirstName() + " "
		+ UserRegestrationData.getPersonalLastName();
	Assert.assertTrue(Home.getAccountDispyedName().contains(UserFirstLastName));
	System.out.println();

    }

}
