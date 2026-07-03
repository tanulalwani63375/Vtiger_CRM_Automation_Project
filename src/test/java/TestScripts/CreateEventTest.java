package TestScripts;

import Listeners.ListenerImplementation;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Listeners;


import ObjectRepositories.CalendarPage;
import ObjectRepositories.HomePage;
import Utility.BaseClass;
import Utility.ExcelUtility;
import Utility.JavaUtility;



@Listeners(ListenerImplementation.class)
public class CreateEventTest extends BaseClass{
	@Test
	public void createMeetingTest() {

	    HomePage hp = new HomePage(driver);
	    hp.clickCalendar();

	//    Assert.fail("Testing Listener");
	    
	    CalendarPage cp = new CalendarPage(driver);

	    ExcelUtility eUtil = new ExcelUtility();
	    JavaUtility jUtil = new JavaUtility();
	    
	    String type = eUtil.getExcelData("CreateEvent", 1, 0);
	    String eventName = eUtil.getExcelData("CreateEvent", 1, 1)+ "_" + jUtil.generateRandomNumber();
	    String description = eUtil.getExcelData("CreateEvent", 1, 2);
	    String location = eUtil.getExcelData("CreateEvent", 1, 3);
	    String eventStatus = eUtil.getExcelData("CreateEvent", 1, 4);
	    String eventPriority = eUtil.getExcelData("CreateEvent", 1, 5);
	    String assignType = eUtil.getExcelData("CreateEvent", 1, 6);
	    String assignValue = eUtil.getExcelData("CreateEvent", 1, 7);
	    String startHour = eUtil.getExcelData("CreateEvent", 1, 8);
	    String startMinute = eUtil.getExcelData("CreateEvent", 1, 9);
	    String startFormat = eUtil.getExcelData("CreateEvent", 1, 10);
	    String endHour = eUtil.getExcelData("CreateEvent", 1, 11);
	    String endMinute = eUtil.getExcelData("CreateEvent", 1, 12);
	    String endFormat = eUtil.getExcelData("CreateEvent", 1, 13);
	
	    cp.scheduleMeeting( type, eventName,  description,  location, eventStatus, eventPriority,  assignType,  assignValue, 
				 startHour,  startMinute,  startFormat, endHour, endMinute,  endFormat);
	    
	    
	    cp.openAllEvents();
	    
	    Assert.assertEquals(cp.getCreatedMeetingName(eventName), eventName);
	    
	}
}