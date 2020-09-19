package TestrRpository;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.UserRegestrationData;
import PageRepository.AuthenticationPage;
import PageRepository.BlousesPage;
import PageRepository.CreateAccountPage;
import PageRepository.HomePage;
import PageRepository.MyAccountPage;
import PageRepository.OrderHistoryPage;
import PageRepository.ShoppingCardPage;

public class ShoppingTest extends TestBase {

    /** Variables **/
    HomePage Home;
    AuthenticationPage Auth;
    BlousesPage Blouses;
    ShoppingCardPage Shopping;
    CreateAccountPage CreatAccount;
    MyAccountPage Myaccount;
    OrderHistoryPage OrderHistory;
    String RefrenceCode;

    // Verified item adding to Shoping card
    @Test
    public void VerfiyPlacingOrder() throws InterruptedException {

	// 1.Click Sign in
	Home = new HomePage(driver.get());
	Home.ClickLogin();
	// 2. Enter Email and Create Account
	Auth = new AuthenticationPage(driver.get());
	Auth.CreateaccountSendEmail(UserRegestrationData.getEmail());
	Auth.ClickCreateAccount();

	// 3. Fill Registration Form
	CreatAccount = new CreateAccountPage(driver.get());
	CreatAccount.FillRegestrationForm();
	// 4. Navigate to Blouses
	Home.HoverOverWomenMenue();
	Home.SelectBlouses();
	// 5. Add First item To card
	Blouses = new BlousesPage(driver.get());
	Blouses.HoverOverProductContainer();
	Blouses.ClickAddToCard();
	Blouses.ClickProceedToCheckOut();
	// 6. Proceed to checkout
	Shopping = new ShoppingCardPage(driver.get());
	Shopping.CardProceedToCheckOutButton();
	Shopping.AddProceedToCheckOutButton();
	Shopping.ClickAgreeOnTerm();
	Shopping.ShippingProceedToCheckOutButton();
	// 7. Confirm order by selecting bank wire option
	Shopping.SelectBankWire();
	Shopping.ClickConfirmPayment();
	RefrenceCode = Shopping.GetRefrenceCode();
	// 8. Validate order was placed from order history page.
	Myaccount = new MyAccountPage(driver.get());
	Home.ViewMyAccount();
	Myaccount.ClickOrderHistory();
	OrderHistory = new OrderHistoryPage(driver.get());
	Assert.assertTrue(OrderHistory.GetOrderRefrenceList().contains(RefrenceCode));

    }

}
