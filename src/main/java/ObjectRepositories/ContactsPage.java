package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	WebDriver driver;

    public ContactsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Locators

    
    
    @FindBy(name = "lastname")
    private WebElement lastNameTextField;

    @FindBy(name = "account_name")
    private WebElement organizationNameTextField;

    @FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveButton;

    // Getters

    public WebElement getLastNameTextField() {
        return lastNameTextField;
    }

    public WebElement getOrganizationNameTextField() {
        return organizationNameTextField;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }
    @FindBy(css= "img[title='Create Contact...']")
	private WebElement createContactIcon;
    
    
    public WebElement getcreateContactIcon() {
    		return createContactIcon;
    }
    
    // Business Methods


    public void createContact(String lastName, String orgName) {
   
    	createContactIcon.click();
    	lastNameTextField.sendKeys(lastName);
        organizationNameTextField.sendKeys(orgName);
        saveButton.click();
    }
}
