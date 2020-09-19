package PageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.UserRegestrationData;

public class CreateAccountPage extends PageBase {

    // variables
    WebDriverWait wait;

    // call the super constructor to init the driver
    public CreateAccountPage(WebDriver webDriver) {
	super(webDriver);
    }

    // Identifying the page element Locators
    protected By MrButton = By.xpath("//div[1][@class=\"radio-inline\"]/label[1]/div[1]/span[1]");
    protected By MrsButton = By.xpath("//div[2][@class=\"radio-inline\"]/label[1]/div[1]/span[1]");
    protected By PersonalFirstName = By.xpath("//div[@class=\"account_creation\"]//input[@id=\"customer_firstname\"]");
    protected By PersonalLastName = By.xpath("//input[@id='customer_lastname']");
    protected By Email = By.xpath("//input[@id='email']");
    protected By Password = By.xpath("//input[@id='passwd']");
    protected By DayOfBirth = By.xpath("//select[@id='days']");
    protected By MonthOfBirth = By.xpath("//div[@id=\"uniform-months\"]//select[@id='months']");
    protected By YearOfBirth = By.xpath("//select[@id='years']");
    protected By NewsLetter = By.xpath("//input[@id='newsletter']");
    protected By SpecialOffers = By.xpath("//input[@id='optin']");
    protected By AdressFirstName = By.xpath("//input[@id='firstname']");
    protected By AdressLastName = By.xpath("//input[@id='lastname']");
    protected By CompanyName = By.xpath("//input[@id='company']");
    protected By Address = By.xpath("//div[@class=\"account_creation\"]/p[4]/input[@type=\"text\"]");
    protected By CityName = By.xpath("//input[@id='city']");
    protected By StateName = By.xpath("//select[@id='id_state']");
    protected By ZIPCode = By.xpath("//input[@id='postcode']");
    protected By CountryName = By.xpath("//select[@id='id_country']");
    protected By AddtionoalInfo = By.xpath("//textarea[@id='other']");
    protected By HomePhone = By.xpath("//input[@id='phone']");
    protected By MobilePhone = By.xpath("//input[@id='phone_mobile']");
    protected By FutuerAdderes = By.xpath("//input[@id='alias']");
    protected By RigesterButton = By.xpath("//span[contains(text(),'Register')]");
    protected By CreatePageHeader = By.xpath("//h1[@class='page-heading']");
    protected By PassowrdLinitsVerfication = By.xpath("//div[@class=\"account_creation\"]//div[5]");
    protected By AlertDanger = By.xpath("//div[@class='alert alert-danger']");

    // Methods to perform Action on the elements
    // 1. YOUR PERSONAL INFORMATION Part
    // Select Title Option
    public void SelectTitle(String Title) {
	if (Title.equals("Mr.")) {
	    click_Element(driver.findElement(MrButton));

	} else {
	    click_Element(driver.findElement(MrsButton));

	}

    }

    // Send first Name
    public void SendPersonalFirstName(String FName) {
	Send_Keys(driver.findElement(PersonalFirstName), FName);

    }

    // Send last Name
    public void SendPersonalLastName(String lName) {
	Send_Keys(driver.findElement(PersonalLastName), lName);

    }

    // Send Email
    public void SendEmail(String Emailadd) {
	Send_Keys(driver.findElement(Email), Emailadd);

    }

    // Send The password
    public void SendPassword(String credentials) {
	Send_Keys(driver.findElement(Password), credentials);
	driver.findElement(Password).sendKeys(Keys.TAB);
    }

    // Select Day of birth
    public void SelectDayOfBirth(String Day) {

	SelectByValue(driver.findElement(DayOfBirth), Day);
    }

    // Select year of birth
    public void SelectYearOfBirth(String Year) {

	SelectByValue(driver.findElement(YearOfBirth), Year);
    }

    // Select month of birth
    public void SelectMonthOfBirth(String Month) {

	int MonthIndex = 0;
	if (Month.equalsIgnoreCase("January"))
	    MonthIndex = 1;
	else if (Month.equalsIgnoreCase("February"))
	    MonthIndex = 2;
	else if (Month.equalsIgnoreCase("March"))
	    MonthIndex = 3;
	else if (Month.equalsIgnoreCase("April"))
	    MonthIndex = 4;
	else if (Month.equalsIgnoreCase("May"))
	    MonthIndex = 5;
	else if (Month.equalsIgnoreCase("June"))
	    MonthIndex = 6;
	else if (Month.equalsIgnoreCase("July"))
	    MonthIndex = 7;
	else if (Month.equalsIgnoreCase("August"))
	    MonthIndex = 8;
	else if (Month.equalsIgnoreCase("September"))
	    MonthIndex = 9;
	else if (Month.equalsIgnoreCase("October"))
	    MonthIndex = 10;
	else if (Month.equalsIgnoreCase("November"))
	    MonthIndex = 11;
	else if (Month.equalsIgnoreCase("December"))
	    MonthIndex = 12;

	SelectByIndexe(driver.findElement(MonthOfBirth), MonthIndex);
    }

    // Validating the page header
    public boolean PageHeaderIsDisplayed(WebDriver driver) {

	WebDriverWait wait = new WebDriverWait(driver, 40);

	return wait.until(ExpectedConditions.visibilityOf(driver.findElement(CreatePageHeader))) != null;

    }

    // Selecting or un selecting news letter Option
    public void SelectNewsLetter(String Option) {

	if (Option.equalsIgnoreCase("TRUE")) {
	    if (!driver.findElement(NewsLetter).isSelected()) {
		click_Element(driver.findElement(NewsLetter));
	    }
	} else {
	    if (driver.findElement(SpecialOffers).isSelected()) {
		click_Element(driver.findElement(NewsLetter));
	    }

	}

    }

    // Selecting or un-selecting news specials offer
    public void SelectSpecialOffer(String Option) {

	if (Option.equalsIgnoreCase("TRUE")) {
	    if (!driver.findElement(SpecialOffers).isSelected()) {
		click_Element(driver.findElement(SpecialOffers));
	    }
	} else {
	    if (driver.findElement(SpecialOffers).isSelected()) {
		click_Element(driver.findElement(SpecialOffers));
	    }

	}

    }

    // Send Company First Name
    public void SendFirstName(String AddFirstName) {

	Send_Keys(driver.findElement(AdressFirstName), AddFirstName);

    }

    // Send Company First Name
    public void SendLastName(String AddLastName) {
	Send_Keys(driver.findElement(AdressLastName), AddLastName);

    }

    // Send company name
    public void SendCompnayName(String CompName) {
	Send_Keys(driver.findElement(CompanyName), CompName);

    }

    // Send Address
    public void SendAddress(String add) {
	Send_Keys(driver.findElement(Address), add);

    }

    // Send city name
    public void SendCity(String CompName) {
	Send_Keys(driver.findElement(CityName), CompName);

    }

    // Select State
    public void SelectState(String State) {

	SelectByVisualText(driver.findElement(StateName), State);
    }

    // Send Postal Code
    public void SendPostalCode(String Code) {

	Send_Keys(driver.findElement(ZIPCode), Code);
    }

    // Send mobile number
    public void SendMobNumber(String mobile) {

	Send_Keys(driver.findElement(MobilePhone), mobile);
    }

    // get the value of displayed email
    public boolean getValueOfEmail() {

	wait = new WebDriverWait(driver, 60);
	return wait.until(ExpectedConditions.textToBePresentInElementValue(Email, UserRegestrationData.getEmail()));
    }

    // the message to check the password limits
    public String ValidatePasswordLimits() {

	return driver.findElement(PassowrdLinitsVerfication).getAttribute("class");

    }

    // click Register
    public void clickRegister() {

	click_Element(driver.findElement(RigesterButton));
    }

    // Mandatory field
    public String ValidateMandtoryFileds() {
	return get_text(driver.findElement(AlertDanger));

    }

    // Select Countery
    public void SelectCountry(String Country) {

	SelectByVisualText(driver.findElement(CountryName), Country);

    }

    // get the displayed add name
    public String DisplayedAddressFirstName() {

	return get_text(driver.findElement(AdressFirstName));

    }

    // get the displayed add name
    public String DisplayedAddressLastName() {

	return get_text(driver.findElement(AdressLastName));

    }

    // Method to Abstract Form Filling Process
    public void FillRegestrationForm() {
	CreateAccountPage CreatAccount = new CreateAccountPage(driver);
	CreatAccount.SelectTitle(UserRegestrationData.getTitle());
	CreatAccount.SelectSpecialOffer(UserRegestrationData.getSpecialOffers());
	CreatAccount.SendPersonalFirstName(UserRegestrationData.getPersonalFirstName());
	CreatAccount.SendPersonalLastName((UserRegestrationData.getPersonalLastName()));
	CreatAccount.SendPassword((UserRegestrationData.getPassword()));
	CreatAccount.SelectNewsLetter((UserRegestrationData.getNewsLetter()));
	CreatAccount.SelectSpecialOffer(UserRegestrationData.getSpecialOffers());
	CreatAccount.SelectDayOfBirth(UserRegestrationData.getDayOfBirth());
	CreatAccount.SelectMonthOfBirth(UserRegestrationData.getMonthOfBirth());
	CreatAccount.SelectYearOfBirth(UserRegestrationData.getYearOfBirth());
	CreatAccount.SendCompnayName(UserRegestrationData.getCompanyName());
	CreatAccount.SendAddress(UserRegestrationData.getAddress());
	CreatAccount.SendCity(UserRegestrationData.getAddress());
	CreatAccount.SelectState(UserRegestrationData.getStateName());
	CreatAccount.SendPostalCode(UserRegestrationData.getZIPCode());
	CreatAccount.SelectCountry(UserRegestrationData.getCountryName());
	CreatAccount.SendMobNumber(UserRegestrationData.getMobilePhone());
	CreatAccount.clickRegister();

    }

}
