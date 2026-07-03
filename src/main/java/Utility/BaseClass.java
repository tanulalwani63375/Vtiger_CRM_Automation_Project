package Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepositories.LoginPage;
import ObjectRepositories.LogoutPage;

public class BaseClass {
	
	
	PropertiesUtility pUtil = new PropertiesUtility();
	    public static WebDriver driver;
	    public ExcelUtility eUtil;

	    @BeforeClass
	    public void launchBrowser(){
	    String Browser = pUtil.getPropertyData("browser");
	    System.out.println("Browser from properties = " + Browser);
	    
	 // Default constructor to launch browser
	    	WebDriverUtility wb = new WebDriverUtility();
	    	driver = wb.launchBrowser(Browser);	
	    	System.out.println("Driver = " + driver);

	    //create new object to run browser	
	    	wb = new WebDriverUtility(driver);
	    	wb.maximizeWindow();
	    	wb.waitForPageLoad();
	       

	        driver.get(pUtil.getPropertyData("url"));
	    }

	    @BeforeMethod
	    public void login()
	    {
	        LoginPage lp = new LoginPage(driver);

	        lp.loginToVtiger(
	        		pUtil.getPropertyData("username"),
	                pUtil.getPropertyData("password"));
	    
	       
	        eUtil = new ExcelUtility();
	        
	    }

	    @AfterMethod
	    public void logout()
	    {
	    	LogoutPage lo = new LogoutPage(driver);
	    	
	    	lo.logout();
	    }

	    @AfterClass
	    public void closeBrowser()
	    {
	        driver.quit();
	    }

	
	
	
	
}
