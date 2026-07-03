package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		 this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	// Web Elements

    @FindBy(linkText = "Calendar")
    private WebElement calendarLink;

    @FindBy(linkText = "Leads")
    private WebElement leadsLink;

    @FindBy(linkText = "Organizations")
    private WebElement organizationsLink;

    @FindBy(linkText = "Contacts")
    private WebElement contactsLink;
    
    
 /// Business Methods

    public void clickCalendar() {
        calendarLink.click();
    }

    public void clickLeads() {
        leadsLink.click();
    }

    public void clickOrganizations() {
        organizationsLink.click();
    }

    public void clickContacts() {
        contactsLink.click();

    }


}