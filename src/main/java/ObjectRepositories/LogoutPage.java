package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// User Profile Icon
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;

	// Sign Out Link
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;

	public void logout() {

		Actions act = new Actions(driver);

		act.moveToElement(adminIcon).perform();

		signOut.click();
	}
}
