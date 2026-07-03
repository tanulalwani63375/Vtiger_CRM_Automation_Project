package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver ;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private	WebElement username;
	
	@FindBy(name="user_password")
	private	WebElement password;
	
	@FindBy(id="submitButton")
	private	WebElement submit;

	
// This is business method
	public void loginToVtiger(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();

	}
}
