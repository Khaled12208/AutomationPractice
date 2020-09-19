package ServicesRepository;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ObjectRepository.UserLoginData;
import ObjectRepository.UserRegestrationData;

public class DataReader {

    // 1. Extracting the invocation data From the external properties file
    public HashMap<String, Object> ReadInvocationData() throws IOException {
	HashMap<String, Object> data = new HashMap<String, Object>();
	// loading the properties file
	String PropertiesFilepath = System.getProperty("user.dir") + "\\DataFiles\\BrowserInvocationData.properties";
	FileInputStream file = new FileInputStream(PropertiesFilepath);
	Properties prop = new Properties();
	prop.load(file);
	// Extracting the information form the file and save it into hasMap
	data.put("BrowserName", prop.getProperty("BrowserName"));
	data.put("URL", prop.getProperty("URL"));
	data.put("URL", prop.getProperty("URL"));
	data.put("InvocationWidth", Integer.parseInt(prop.getProperty("InvocationWidth")));
	data.put("InvocationHeight", Integer.parseInt(prop.getProperty("InvocationHeight")));

	return data;
    }

    // 2. Extracting the User Data From the external Json file
    @SuppressWarnings("unchecked")
    public void ReadRegestrationData() throws IOException, ParseException {
	// Reading the External JSON file and Parsing the Data
	String FilePath = System.getProperty("user.dir") + "\\DataFiles\\UserRegestration.json";
	new HashMap<String, Object>();
	FileReader reader = new FileReader(FilePath);
	JSONParser parser = new JSONParser();
	Object obj = parser.parse(reader);
	JSONArray array = new JSONArray();
	array.add(obj);
	// to generate an random number for email
	Random rand = new Random();
	int upperbound = 25000;
	int int_random = rand.nextInt(upperbound);

	// Setting the Registration Data into user registration and login Class
	for (Object json : array) {
	    JSONObject prep = (JSONObject) json;
	    prep.get("firsrname");
	    // init the User Registration data class
	    UserRegestrationData.setTitle(prep.get("title"));
	    UserRegestrationData.setPersonalFirstName(prep.get("PersonalFirstName"));
	    UserRegestrationData.setPersonalLastName(prep.get("PersonalLastName"));
	    UserRegestrationData.setPassword(prep.get("Password"));
	    UserRegestrationData.setDayOfBirth(prep.get("DayOfBirth"));
	    UserRegestrationData.setMonthOfBirth(prep.get("MonthOfBirth"));
	    UserRegestrationData.setYearOfBirth(prep.get("YearOfBirth"));
	    UserRegestrationData.setNewsLetter(prep.get("NewsLetter"));
	    UserRegestrationData.setSpecialOffers(prep.get("SpecialOffers"));
	    UserRegestrationData.setAdressFirstName(prep.get("AdressFirstName"));
	    UserRegestrationData.setAdressLastName(prep.get("AdressLastName"));
	    UserRegestrationData.setCompanyName(prep.get("CompanyName"));
	    UserRegestrationData.setAddress(prep.get("Address"));
	    UserRegestrationData.setCityName(prep.get("CityName"));
	    UserRegestrationData.setStateName(prep.get("StateName"));
	    UserRegestrationData.setZIPCode(prep.get("ZIPCode"));
	    UserRegestrationData.setCountryName(prep.get("CountryName"));
	    UserRegestrationData.setAddtionoalInfo(prep.get("AddtionoalInfo"));
	    UserRegestrationData.setHomePhone(prep.get("HomePhone"));
	    UserRegestrationData.setMobilePhone(prep.get("MobilePhone"));
	    // this section to make sure that every run we will have new email
	    String Email = (String) prep.get("Email");
	    String[] EmailArray = Email.split("@");
	    String NewEmail = EmailArray[0] + int_random + "@" + EmailArray[1];
	    UserRegestrationData.setEmail(NewEmail);
	    // init the User Login Data Class
	    UserLoginData.setEmail(NewEmail);
	    UserLoginData.setPassword(prep.get("Password"));
	}

    }

}
