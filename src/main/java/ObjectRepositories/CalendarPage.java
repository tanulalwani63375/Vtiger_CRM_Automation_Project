package ObjectRepositories;

import java.security.Key;
import Utility.JavaUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.Assertion;

import Utility.WebDriverUtility;

public class CalendarPage {
	// WebDriver driver = null;
	private WebDriver driver;
	private WebDriverUtility wUtil;
	private JavaUtility jUtil = new JavaUtility();

	public CalendarPage(WebDriver driver) {
		this.driver = driver;
		this.wUtil = new WebDriverUtility(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "calAddButton")
	private WebElement addButton;

	@FindBy(id = "addmeeting")
	private WebElement meetingLink;

	@FindBy (name = "activitytype")
	private WebElement eventType;	

	@FindBy(name = "subject")
	private WebElement eventName;

	@FindBy(name = "description")
	private WebElement description;

	@FindBy(name = "location")
	private WebElement location;

	@FindBy(name = "eventstatus")
	private WebElement status;

	@FindBy(id = "taskpriority")
	private WebElement priority;

	@FindBy(xpath = "//input[@value='U']")
	private WebElement userRadioButton;

	@FindBy(xpath = "//input[@value='T']")
	private WebElement groupRadioButton;

	@FindBy(name = "assigned_user_id")
	private WebElement assignedTo;
	
	@FindBy(name = "sendnotification")
	private WebElement sendnotification;
	
	@FindBy(id = "starthr")
	private WebElement startHour;

	@FindBy(id = "startmin")
	private WebElement startMinute;

	@FindBy(id = "startfmt")
	private WebElement startFormat;

	@FindBy(name = "date_start")
	private WebElement startDate;

	@FindBy(id = "endhr")
	private WebElement endHour;

	@FindBy(id = "endmin")
	private WebElement endMinute;

	@FindBy(id = "endfmt")
	private WebElement endFormat;

	@FindBy(name = "due_date")
	private WebElement endDate;

	@FindBy(name = "eventsave")
	private WebElement saveButton;
	
	@FindBy(xpath="//input[contains(@value,'Save')]")
	private WebElement EditSaveButton;

	
	// Reminder
//	@FindBy(linkText="Reminder")
//   private WebElement reminderTab;
//
//    @FindBy(name="set_reminder")
//    private WebElement reminderCheckBox;
//
//    @FindBy(name="remdays")
//    private WebElement reminderDays;
//
//    @FindBy(name="remhrs")
//    private WebElement reminderHours;
//
//    @FindBy(name="remmin")
//    private WebElement reminderMinutes;
//    
//    @FindBy(linkText="Repeat")
//   private WebElement repeatTab;
//
//    @FindBy(name="recurringcheck")
//    private WebElement repeatCheckBox;
//
//    @FindBy(name="repeat_frequency")
//    private WebElement repeatEvery;
//
//    @FindBy(name="repeatType")
//   private WebElement repeatType;
//    
//    @FindBy(linkText="Related To")
//    private WebElement relatedTab;
//
//    @FindBy(name="parent_type")
//    private WebElement relatedModule;

//	@FindBy(xpath = "//img[@title='Select']")
//	private WebElement selectRelatedRecord;

	// Business Method
	public void scheduleMeeting(String type,String eventName, String description, String location,String eventStatus, 
								String eventPriority, String assignType, String assignValue,
								String startHour, String startMinute, String startFormat,  
								String endHour, String endMinute, String endFormat ) {
		
		Reporter.log("Hover performed successfully", true);
		wUtil.hover(addButton);

		
		Reporter.log("After performed successfully", true);
		meetingLink.click();

	
		Reporter.log("Meeting Clicked", true);
		wUtil.select(eventType, type);
		
	
		this.eventName.sendKeys(eventName);
	    this.description.sendKeys(description);
	    this.location.sendKeys(location);

	    wUtil.select(eventStatus, status);
	    wUtil.select(eventPriority, priority);

		// Assigned To
	    if(assignType.equalsIgnoreCase("User"))
	    {
	        userRadioButton.click();
	    }
	    else
	    {
	        groupRadioButton.click();
	    }
		wUtil.select(assignValue, assignedTo);
		
		//Send Notification
		if(!sendnotification.isSelected()) {
			sendnotification.click();
		}

		// Start Time
		wUtil.select(startHour, this.startHour);
		Reporter.log("startHour filled", true);
			
		wUtil.select(startMinute, this.startMinute);
		Reporter.log("startMinute ", true);
		
		wUtil.select(startFormat, this.startFormat);
		Reporter.log("startFormat filled", true);
	
		String tomorrow = jUtil.getTomorrowDate();
		Reporter.log("tomorrow date filled", true);
		
		
		// Start Date
		startDate.clear();
		startDate.sendKeys(tomorrow);
		Reporter.log("startDate  filled", true);


		// End Time
		wUtil.select(endHour, this.endHour);
		Reporter.log("endHour filled", true);
		
	    wUtil.select(endMinute, this.endMinute);
	    Reporter.log("endMinute filled", true);
	    
	    wUtil.select(endFormat, this.endFormat);
	    Reporter.log("endFormat filled", true);
	    
		// End Date
		endDate.sendKeys(Keys.CONTROL + "a");
		endDate.sendKeys(Keys.DELETE);
		endDate.sendKeys(tomorrow);
		Reporter.log("tomorrow date  filled", true);

	    //Reminder
//	    reminderTab.click();
//
//	    if(!reminderCheckBox.isSelected()) {
//	        reminderCheckBox.click();
//	    }
//
//	    wUtil.select("0", reminderDays);
//	    wUtil.select("1", reminderHours);
//	    wUtil.select("30", reminderMinutes);
//  
//	    //Repeat
//	    repeatTab.click();
//
//	    if(!repeatCheckBox.isSelected()) {
//	        repeatCheckBox.click();
//	    }
//
//	    wUtil.select("1", repeatEvery);
//	    wUtil.select("Weekly", repeatType);
//	    
//	    //Related To
//	   relatedTab.click();
//
//	    wUtil.select("Contacts", relatedModule);

		// Optional
		// selectRelatedRecord.click();

		// Save
		saveButton.click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

	}

	
	//Navigate to all event page
	@FindBy(linkText = "All Events & Todos")
	private WebElement allEventsTab;

	public void openAllEvents() {
		allEventsTab.click();
		Reporter.log("alleventTab clicked", true);
	}

	
	// Verification of meeting creation
	public String getCreatedMeetingName(String meetingName) {

		
	    WebElement meeting = driver.findElement(
	        By.xpath("//a[contains(normalize-space(),'" + meetingName + "')]"));

	    wUtil.waitForElementVisible(meeting);
	    Reporter.log("Created meetingName visible", true);
	    
	    return meeting.getText();
	}


	
	
	//Delete meeting Locator
	@FindBy(xpath = "//input[@value= 'Delete']")
	private WebElement deleteButton;
	
	
	//Delete meeting method	
		public void deleteMeeting(String meetingName) {
		
		WebElement meeting = driver.findElement(By.linkText(meetingName));
	    Reporter.log("meeting visible", true);
	     wUtil.waitForElementVisible(meeting);

	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", meeting);
	    js.executeScript("arguments[0].click();", meeting);
	    Reporter.log("page Scrolled", true);
	    
	    	Reporter.log("meetingName clicked", true);
	    	 wUtil.waitForElementClickable(deleteButton);
	    	 Reporter.log("waited for element clickable", true);
	    	 
	    	deleteButton.click();
	    	Reporter.log("deleteButton clicked", true);
		    
	    driver.switchTo().alert().accept();
	    Reporter.log("alert accepted", true);
	    
	}
	
	//Delete meeting Verification	
		public boolean ismeetingpresent(String meetingName) {
			
			Reporter.log("meeting checked", true);
			 return driver.findElements(By.xpath("//a[contains(text(),'" + meetingName + "')]")) .size() > 0;
			 
		}
		
		
		
		//Edit Event
		@FindBy(name = "Edit")
		private WebElement EditButton;
		
		public void editEvent(String meetingName, String newDescription)
		{
		    WebElement meeting = driver.findElement(By.linkText(meetingName));
		    System.out.println(meeting.getText());
		    
		    wUtil.waitForElementVisible(meeting);

		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView({block:'center'});", meeting);
		    js.executeScript("arguments[0].click();", meeting);

		    wUtil.waitForElementClickable(EditButton);
		    EditButton.click();

		    description.clear();
		    description.sendKeys(newDescription);

		    EditSaveButton.click();
		}

//		public void verifyMeetingDetails(String expectedDescription, String expectedLocation, String expectedStatus, String expectedPriority) {
//			Assert.assertEquals(description.getDomAttribute("value"),expectedDescription);
//			Assert.assertEquals(location.getAttribute("value"), expectedLocation);
//
//		    Select statusDropdown = new Select(status);
//		    Assert.assertEquals(statusDropdown.getFirstSelectedOption().getText(), expectedStatus);
//
//		    Select priorityDropdown = new Select(priority);
//		    Assert.assertEquals(priorityDropdown.getFirstSelectedOption().getText(), expectedPriority);
//		}


}	
