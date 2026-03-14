package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import PageObjects.SearchCustomerPage2;
import java.util.*;

public class BaseClass {
	
	// Inside this base class we will keep the steps that are need for all the steps
	
	public static WebDriver driver;
    public LoginPage lp;   // this is loginpage POM
    public AddCustomerPage addCust; // this is AddCustomerPage POM
    public SearchCustomerPage searchCust;
    public SearchCustomerPage2 searchCust2;
    public static Logger logger;
    public Properties configProp;
    
    
    public void setUp()
    {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-blink-features=AutomationControlled");
    	options.addArguments("--start-maximized");
    	options.addArguments("--disable-infobar");
    	options.addArguments("--disable-notifications");
    	options.addArguments("user-data-dir=C:\\AutomationProfile");
    	options.addArguments("--profile-directory=Default");

    	WebDriver driver = new ChromeDriver(options);
    	driver.get("https://admin-demo.nopcommerce.com/login");
    }
    
    
    // java method to create random email id 
    // whenever we want generate some random string or random value that time we need to class this particular method generatedstring1
    // created for generating random string for unique email id
    public static String randomstring()
    {
    	String generatedstring1 = RandomStringUtils.randomAlphabetic(5);
    	return (generatedstring1);
    }

}
