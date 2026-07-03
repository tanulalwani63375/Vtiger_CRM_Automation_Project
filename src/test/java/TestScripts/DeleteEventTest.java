package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.ListenerImplementation;
import ObjectRepositories.CalendarPage;
import ObjectRepositories.HomePage;
import Utility.BaseClass;


@Listeners(ListenerImplementation.class)
public class DeleteEventTest extends BaseClass{
	@Test
	public void DeleteMeetinTest() {
		HomePage hp = new HomePage(driver);
	    hp.clickCalendar();

		CalendarPage cp = new CalendarPage(driver);
		cp.openAllEvents();
		
		String meetingName = eUtil.getExcelData("DeleteEvent", 1, 1);
		cp.deleteMeeting(meetingName);
		
		Assert.assertFalse(cp.ismeetingpresent(meetingName), "Meeting Deleted");
	}
	
}
