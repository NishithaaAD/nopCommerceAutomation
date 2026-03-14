package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	//1.creating webdriver
		public WebDriver ldriver;

		//2.creating constructor
	    public AddCustomerPage(WebDriver rdriver) {
	        ldriver = rdriver;
	        PageFactory.initElements(rdriver, this);
	    }
	    
	    /*
	     here instead of using @FinfBy annotation, I will use a different approach for that first I will capture all the locators for every element
	     and then I will write an action methods. and this time I am going to use findElemnts this is the another approach of creation of page object
	     class.
	     
	     so earlier in the LoginPage object class how we have created is we created just constructor and by using @FindBy we specified the locator in 
	     the same place and we identified all the elements and in the action method directly specified the element and performed the action. and haven't
	     any @FindBy Annotation
	     
	     but this time I am going to capture only locator for those elements and then I will identify those elements by using @FindBy method later
	     in the action methods
	     */
	    
	    //3. Locators
	    
	    By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	    By lnkCustomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	    By btnAddnew = By.xpath("//a[normalize-space()='Add new']"); // Add new

	    By txtEmail = By.xpath("//input[@id='Email']");
	    By txtPassword = By.xpath("//input[@id='Password']");

	    By txtcustomerRoles = By.xpath("//input[@role='searchbox']");

	    By lstitemAdministrators = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-zdru-1']");
	    By lstitemforumModerators = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-y9c0-2']");
	    By lstitemRegistered = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-608n-3']");
	    By lstitemGuests = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-dgvs-4']");
	    By lstitemVendors = By.xpath("//li[@id='select2-SelectedCustomerRoleIds-result-lqc7-5']");

	    By drpmgrOfVendor = By.xpath("//b[@role='presentation']");
	    By rdMaleGender = By.xpath("//input[@id='Gender_Male']");
	    By rdFeMaleGender = By.xpath("//input[@id='Gender_Female']");

	    By txtFirstName = By.xpath("//input[@id='FirstName']");
	    By txtLastName = By.xpath("//input[@id='LastName']");

	    By txtDob = By.xpath("//input[@id='DateOfBirth']");

	    By txtCompanyName = By.xpath("//input[@id='Company']");

	    By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");

	    By btnSave = By.xpath("//button[@name='save']");
	    
	    
	    //once after capturing the elements we need to perform action method for each element
	    //4. Action Methods
	    
	    public String getPageTitle()
	    {
	    	return ldriver.getTitle();
	    }
	    
	    //1. Click Customers Menu
	    public void clickOnCustomersMenu() {
	        ldriver.findElement(lnkCustomers_menu).click();
	    }
	    
	    //2. Click Customers Menu Item
	    public void clickOnCustomersMenuItem() {
	        ldriver.findElement(lnkCustomers_menuitem).click();
	    }
	    
	  //3. Click Add New Button
	    public void clickOnAddNew() {
	        ldriver.findElement(btnAddnew).click();
	    }

	    //4. Enter Email
	    public void setEmail(String email) {
	        ldriver.findElement(txtEmail).sendKeys(email);
	    }

	    //5. Enter Password
	    public void setPassword(String password) {
	        ldriver.findElement(txtPassword).sendKeys(password);
	    }
	    
	    
/*
	    //6. Click Customer Roles
	    public void clickCustomerRoles() {
	        ldriver.findElement(txtcustomerRoles).click();
	    }

	    //7. Select Administrator Role
	    public void selectAdministratorRole() {
	        ldriver.findElement(lstitemAdministrators).click();
	    }

	    //8. Select Registered Role
	    public void selectRegisteredRole() {
	        ldriver.findElement(lstitemRegistered).click();
	    }

	    //9. Select Guest Role
	    public void selectGuestRole() {
	        ldriver.findElement(lstitemGuests).click();
	    }

	    //10. Select Vendor Role
	    public void selectVendorRole() {
	        ldriver.findElement(lstitemVendors).click();
	    }
*/
	    
	 // step 6 to 10 in single line
	    public void setCustomerRoles(String role) throws InterruptedException
	    {
	        if(!role.equals("Vendors")) // If role is vendors should not delete Register as per requirement
	        {
	            ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span")).click();
	        }

	        ldriver.findElement(txtcustomerRoles).click();

	        WebElement listitem;

	        Thread.sleep(3000);

	        if(role.equals("Administrators"))
	        {
	            listitem = ldriver.findElement(lstitemAdministrators);
	        }
	        else if(role.equals("Guests"))
	        {
	            listitem = ldriver.findElement(lstitemGuests);
	        }
	        else if(role.equals("Registered"))
	        {
	            listitem = ldriver.findElement(lstitemRegistered);
	        }
	        else if(role.equals("Vendors"))
	        {
	            listitem = ldriver.findElement(lstitemVendors);
	        }
	        else if(role.equals("ForumModerators"))
	        {
	            listitem = ldriver.findElement(lstitemforumModerators);
	        }
	        else
	        {
	            listitem = ldriver.findElement(lstitemGuests);
	        }

	        listitem.click();
	        
//	        JavascriptExecutor js = (JavascriptExecutor)ldriver;  
//	        js.executeScript("arguments[0].click();", listitem);
	    }
	    
	    
	    
	    //11. Select setManagerOfVendor (Drop down)
	    public void setManagerOfVendor(String value) {
	        Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
	        drp.selectByVisibleText(value);
	    }    
	    
	    
/*	    
	    //12. Select Male Gender
	    public void selectMaleGender() {
	        ldriver.findElement(rdMaleGender).click();
	    }

	    //13. Select Female Gender
	    public void selectFemaleGender() {
	        ldriver.findElement(rdFeMaleGender).click();
	    }
*/
	    
	    
	    //step 12 and 13 to gether
	    public void setGender(String gender)
	    {
	        if(gender.equals("Male"))
	        {
	            ldriver.findElement(rdMaleGender).click();
	        }
	        else if(gender.equals("Female"))
	        {
	            ldriver.findElement(rdFeMaleGender).click();
	        }
	        else
	        {
	            ldriver.findElement(rdMaleGender).click(); // Default
	        }
	    }
	    

	    //14. Enter First Name
	    public void setFirstName(String fname) {
	        ldriver.findElement(txtFirstName).sendKeys(fname);
	    }

	    //15. Enter Last Name
	    public void setLastName(String lname) {
	        ldriver.findElement(txtLastName).sendKeys(lname);
	    }

//	    //16. Enter Date of Birth
//	    public void setDob(String dob) {
//	        ldriver.findElement(txtDob).sendKeys(dob);
//	    }

	    //17. Enter Company Name
	    public void setCompanyName(String company) {
	        ldriver.findElement(txtCompanyName).sendKeys(company);
	    }

	    //18. Enter Admin Comment
	    public void setAdminContent(String comment) {
	        ldriver.findElement(txtAdminContent).sendKeys(comment);
	    }

	    //19. Click Save Button
	    public void clickSave() {
	        ldriver.findElement(btnSave).click();
	    }
	    
	    
	    
	    
	    

}
