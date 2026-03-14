package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
			//1.creating webdriver
			public WebDriver ldriver;
			WaitHelper waitHelper;

			//2.creating constructor
		    public SearchCustomerPage(WebDriver rdriver) {
		        ldriver = rdriver;
		        PageFactory.initElements(rdriver, this);
		        
		        waitHelper = new WaitHelper(ldriver);
		    }
		    
		    
		    
		    
		    //3. Locators
		    
		    @FindBy(how = How.ID, using = "SearchEmail")
		    @CacheLookup
		    WebElement txtEmail;

		    @FindBy(how = How.ID, using = "SearchFirstName")
		    @CacheLookup
		    WebElement txtFirstName;

		    @FindBy(how = How.ID, using = "SearchLastName")
		    @CacheLookup
		    WebElement txtLastName;

		    
		    /*
		    @FindBy(how = How.ID, using = "SearchMonthOfBirth")
		    @CacheLookup
		    WebElement drpDobMonth;

		    @FindBy(how = How.ID, using = "SearchDayOfBirth")
		    @CacheLookup
		    WebElement drpDobDay;

		    @FindBy(how = How.ID, using = "SearchCompany")
		    @CacheLookup
		    WebElement txtCompany;
		    
		    @FindBy(how = How.XPATH, using = "//div[@class='k-multiselect-wrap k-floatwrap']")
		    @CacheLookup
		    WebElement txtcustomerRoles;

		    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
		    @CacheLookup
		    WebElement lstitemAdministrators;

		    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
		    @CacheLookup
		    WebElement lstitemRegistered;

		    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
		    @CacheLookup
		    WebElement lstitemGuests;

		    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
		    @CacheLookup
		    WebElement lstitemVendors;
		    */
		    
		    
		    @FindBy(how = How.ID, using = "search-customers")
		    @CacheLookup
		    WebElement btnSearch;

		    @FindBy(how = How.XPATH, using = "//table[@role='grid']")
		    @CacheLookup
		    WebElement tblSearchResults;

		    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
		    @CacheLookup
		    WebElement table;

		    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
		    @CacheLookup
		    List<WebElement> tableRows;

		    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
		    @CacheLookup
		    List<WebElement> tableColumns;
		    
		    
		    //4. Action Methods
		    
//		    1️ Enter Email
		    public void setEmail(String email)
		    {
		    	waitHelper.WaitForElement(txtEmail, 30);
		        txtEmail.clear();
		        txtEmail.sendKeys(email);
		    }
		    
		    
//		    2️ Enter First Name
		    public void setFirstName(String fname)
		    {
		    	waitHelper.WaitForElement(txtFirstName, 30);
		        txtFirstName.clear();
		        txtFirstName.sendKeys(fname);
		    }
		    
		    
//		    3️ Enter Last Name
		    public void setLastName(String lname)
		    {
		    	waitHelper.WaitForElement(txtLastName, 30);
		        txtLastName.clear();
		        txtLastName.sendKeys(lname);
		    }


/*
		    
//		    4️ Select Date of Birth Month
		    public void setDobMonth(String month)
		    {
		        Select drp = new Select(drpDobMonth);
		        drp.selectByVisibleText(month);
		    }
		    
		    
//		    5️ Select Date of Birth Day
		    public void setDobDay(String day)
		    {
		        Select drp = new Select(drpDobDay);
		        drp.selectByVisibleText(day);
		    }
		    
		    
//		    6️ Enter Company Name
		    public void setCompanyName(String company)
		    {
		        txtCompany.clear();
		        txtCompany.sendKeys(company);
		    }
		    
		    
//		    7️ Click Customer Roles
		    public void clickCustomerRoles()
		    {
		        txtcustomerRoles.click();
		    }
		    
		    
//		    8️ Select Administrator Role
		    public void selectAdministratorsRole()
		    {
		        lstitemAdministrators.click();
		    }
		    
		    
//		    9️ Select Registered Role
		    public void selectRegisteredRole()
		    {
		        lstitemRegistered.click();
		    }
		    
		    
//		    10 Select Guests Role
		    public void selectGuestsRole()
		    {
		        lstitemGuests.click();
		    }
		    
		    
//		    11 Select Vendors Role
		    public void selectVendorsRole()
		    {
		        lstitemVendors.click();
		    }
		    
*/
		    
//		    12 Click Search Button
		    public void clickSearch()
		    {
		        btnSearch.click();
		        waitHelper.WaitForElement(btnSearch, 30);
		    }
		    
		    
//		    13 Get Number of Rows in Table
		    public int getNoOfRows()
		    {
		        return tableRows.size();
		    }
		    
		    
//		    14 Get Number of Columns in Table
		    public int getNoOfColumns()
		    {
		        return tableColumns.size();
		    }
		    

// Main Important login
 
//		    15 Search Customer By Email in Table
		    public boolean searchCustomerByEmail(String email)
		    {
		        boolean flag=false;

		        for(int i=1;i<=tableRows.size();i++)
		        {
		            String emailid = table.findElement
		            (By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
		            
		            System.out.println(emailid);

		            if(emailid.equals(email))
		            {
		                flag=true;
		                break;
		            }
		        }
		        return flag;
		    }
		    
	
// 			16 Verify Search Result Table is Displayed
 			public boolean isSearchResultTableDisplayed()
			{
    			return tblSearchResults.isDisplayed();
			}
			
//			17 Verify Customer Table is Displayed
			public boolean isCustomerTableDisplayed()
			{
    			return table.isDisplayed();
			}

 	    
 /*
//		    18 Search Customer By Name
		    public boolean searchCustomerByName(String name)
		    {
		        boolean flag=false;

		        for(int i=1;i<=tableRows.size();i++)
		        {
		            String Name = table.findElement
		            (By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]"))
		            .getText();
		            
		            System.out.println(name);

		            if(Name.contains(name))
		            {
		                flag=true;
		                break;
		            }
		        }
		        return flag;
		    }
		    
		    
		    19 Get Text from the Table (Optional Useful Method)
			public String getTableText()
			{
    			return table.getText();
			}

*/		    
}
