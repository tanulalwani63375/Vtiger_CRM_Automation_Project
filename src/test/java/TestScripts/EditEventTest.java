package TestScripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.ListenerImplementation;
import ObjectRepositories.CalendarPage;
import ObjectRepositories.HomePage;
import Utility.BaseClass;


@Listeners(ListenerImplementation.class)
public class EditEventTest extends BaseClass{
	 @Test
	    public void editMeetingTest() {


	        HomePage hp = new HomePage(driver);
	        hp.clickCalendar();

	        CalendarPage cp = new CalendarPage(driver);

	        cp.openAllEvents();

	        String meetingName = eUtil.getExcelData("EditEvent", 1, 1);

	        String updatedDescription =  eUtil.getExcelData("EditEvent", 1, 3);

	        cp.editEvent(meetingName, updatedDescription);

	        System.out.println("Meeting edited successfully");
	        
//	        String description = eUtil.getExcelData("EditEvent",1,2);
//	        String location = eUtil.getExcelData("EditEvent",1,4);
//	        String status = eUtil.getExcelData("EditEvent",1,5);
//	        String priority = eUtil.getExcelData("EditEvent",1,6);
//	        cp.verifyMeetingDetails( description,  location,  status,  priority);
//	    
	 }
}
