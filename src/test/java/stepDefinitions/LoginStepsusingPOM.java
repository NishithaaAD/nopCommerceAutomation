package stepDefinitions;

import java.time.Duration;
import java.util.Properties;
import java.io.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import PageObjects.SearchCustomerPage2;

public class LoginStepsusingPOM extends BaseClass {
	
	
	//creating this method only for separating the configurations
	
	@Before
	public void setup() throws IOException
	{	
		logger = logger.getLogger("nopeCommercerV001_Cucumberproject4"); // Added logger
    	PropertyConfigurator.configure("log4j.properties");  // added llogger in project

		//Reading Properties
		configProp = new Properties();
		FileInputStream configPropfile = new FileInputStream("config.properties");
		configProp.load(configPropfile);
				
		ChromeOptions options = new ChromeOptions();
    	
    	options.addArguments("--disable-blink-features=AutomationControlled");
    	options.addArguments("--start-maximized");
    	options.addArguments("--disable-infobar");
    	options.addArguments("--disable-notifications");
//    	options.addArguments("user-data-dir=C:\\Users\\adhav\\AppData\\Local\\Google\\Chrome\\User Data");
////    	C:\Users\adhav\AppData\Local\Google\Chrome\User Data
    	options.addArguments("user-data-dir=C:\\AutomationProfile");
    	options.addArguments("--profile-directory=Default");
    	
    	// adding this line to set webdriver path from config.properties file
//    	System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
    	
    	String br = configProp.getProperty("browser");

    	if(br.equals("chrome")) {

    	    WebDriverManager.chromedriver().setup();
    	    driver = new ChromeDriver(options);
    	}
    	else if(br.equals("firefox")) {

    		WebDriverManager.firefoxdriver().setup();
    	    driver = new FirefoxDriver();

    	}
    	else if(br.equals("edge")) {

    		WebDriverManager.edgedriver().setup();
    	    driver = new EdgeDriver();

    	}
    	else if(br.equals("ie")) {  // ie is removed from windows 11

    		WebDriverManager.iedriver().setup();
    	    driver = new InternetExplorerDriver();

    	}
    	

    	
    	    	
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
	}

    
    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
    	
    	logger.info("*******************Launching Browser********************");

        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url){
    	
    	logger.info("*******************Opening URL********************");
        driver.get(url);
        
    }

//    private WebDriverWait WebDriverWait(WebDriver driver2, Duration ofSeconds) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_and_password(String email, String password) {

		logger.info("*******************Providing login details********************");
        lp.setUserName(email);
        lp.setPassword(password);
    }

    @When("Click on Login")
    public void click_on_login() {
    	
    	logger.info("*******************started login********************");
        lp.clickLogin();
    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String expectedTitle) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.titleContains("Dashboard"));
    	
    	logger.info("*******************Login Passed********************");

        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    	
//    	//negative dimensional check
//    	if (driver.getPageSource().contains("Login was Unsuccessful"))
//    	{
//    		driver.close();
//        logger.info("*******************Login Passed********************");
//    		Assert.assertTrue(false);
//    	}
//    	else
//    	{
//        logger.info("*******************Login failed********************");
//    		Assert.assertEquals(expectedTitle, driver.getTitle());
//    	}
    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until ajax loader disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajaxBusy")));
        logger.info("*******************Click on Logout********************");
        lp.clickLogout();
        Thread.sleep(3000);
        
    }
    
    @Then("Page Title must be {string}")
    public void page_title_must_be(String title) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("Login"));
        
        logger.info("*******************Page Title Is********************");

        Assert.assertEquals(driver.getTitle(), title);

    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }
    
    
    //Customer Feature step definition for adding customers.....................................................................................
    
    
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addCust = new AddCustomerPage(driver);
            
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains("Dashboard"));

        Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
//        Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
    }
    
    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
    	Thread.sleep(3000);
    	logger.info("*******************Adding New Customer********************");
        addCust.clickOnCustomersMenu();
    }
    
    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {
    	addCust.clickOnCustomersMenuItem();
    	Thread.sleep(3000);
    }
    
    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
    	addCust.clickOnAddNew();
    	Thread.sleep(3000);
    }
    
    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() throws InterruptedException {
    	Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
    	Thread.sleep(3000);
    }
    
    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
    	
    	String email = randomstring() + "@gmail.com";
    	addCust.setEmail(email);
    	addCust.setPassword("test123");
    	addCust.setFirstName("Pavan");
        addCust.setLastName("Kumar");
        addCust.setGender("Male");
        addCust.setCompanyName("busyQA");
    	// Registered - default
        // The customer cannot be in both 'Guests' and 'Registered' customer roles
        // Add the customer to 'Guests' or 'Registered' customer role
        addCust.setCustomerRoles("Guest");
        Thread.sleep(5000);

        addCust.setManagerOfVendor("Vendor 1");
        
        
//        addCust.setDob("7/05/1985"); // Format: D/MM/YYYY
        
        addCust.setAdminContent("This is for testing.........");
        
    }
    
    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
    	addCust.clickSave();
    	Thread.sleep(3000);
    }
    
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
    	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));      
    }
    
    
    // Steps for Searching a customer using Email Id.................................................................................
    
    @When("Enter customer Email")
    public void enter_customer_email() {
        searchCust = new SearchCustomerPage(driver);
        
        logger.info("*******************Searching customer with mail id*******************");
        
        searchCust.setEmail("email"); // pass the email inside double quotes
    	
    }
    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCust.clickSearch();
        Thread.sleep(3000);
    }
    @Then("User should found Email in the Search table")
    public void user_should_found_email_in_the_search_table() {
    	boolean status=searchCust.searchCustomerByEmail("email"); // pass the same email again what you gave in set email
    	
    	Assert.assertEquals(true, status);
    }
    
    
    
    
    //Steps for searching a customer by using firstname and lastname......................................................................
    
    @When("Enter customer FirstName")
    public void enter_customer_first_name() {
    	searchCust2 = new SearchCustomerPage2(driver);
    	logger.info("*******************Searching customer with name********************");
    	searchCust2.setFirstName(null);
    }
    
    
    @When("Enter customer LastName")
    public void enter_customer_last_name() {
    	searchCust2.setLastName(null);
    }
    
    
    @Then("User should found Name in the Search table")
    public void user_should_found_name_in_the_search_table() {
    	boolean status1= searchCust2.searchCustomerByName("Full Name");
    	Assert.assertEquals(true, status1);
    }
    
    
    
    
    
    
    
}