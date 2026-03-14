package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class WaitHelper {
	
	//1.creating webdriver
	public WebDriver driver;

	//2.creating constructor
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }
    
    public void WaitForElement(WebElement element, long timeOutInSeconds) {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOutInSeconds));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
	

}
