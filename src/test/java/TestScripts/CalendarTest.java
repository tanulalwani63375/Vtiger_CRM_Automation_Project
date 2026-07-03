package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.ListenerImplementation;
import ObjectRepositories.CalendarPage;
import ObjectRepositories.HomePage;
import Utility.BaseClass;
import Utility.JavaUtility;

@Listeners(ListenerImplementation.class)
public class CalendarTest  extends BaseClass {

    @Test
    public void createEditDeleteMeetingTest() {

        HomePage hp = new HomePage(driver);
        hp.clickCalendar();

        CalendarPage cp = new CalendarPage(driver);
        JavaUtility jUtil = new JavaUtility();

        // ================= CREATE =================

        String type = eUtil.getExcelData("CreateEvent", 1, 0);
        String meetingName = eUtil.getExcelData("CreateEvent", 1, 1)
                                + "_" + jUtil.generateRandomNumber();

        String description = eUtil.getExcelData("CreateEvent", 1, 2);
        String location = eUtil.getExcelData("CreateEvent", 1, 3);
        String status = eUtil.getExcelData("CreateEvent", 1, 4);
        String priority = eUtil.getExcelData("CreateEvent", 1, 5);
        String assignType = eUtil.getExcelData("CreateEvent", 1, 6);
        String assignValue = eUtil.getExcelData("CreateEvent", 1, 7);
        String startHour = eUtil.getExcelData("CreateEvent", 1, 8);
        String startMinute = eUtil.getExcelData("CreateEvent", 1, 9);
        String startFormat = eUtil.getExcelData("CreateEvent", 1, 10);
        String endHour = eUtil.getExcelData("CreateEvent", 1, 11);
        String endMinute = eUtil.getExcelData("CreateEvent", 1, 12);
        String endFormat = eUtil.getExcelData("CreateEvent", 1, 13);

        cp.scheduleMeeting(type, meetingName, description, location,
                status, priority, assignType, assignValue,
                startHour, startMinute, startFormat,
                endHour, endMinute, endFormat);

        cp.openAllEvents();

        Assert.assertEquals(cp.getCreatedMeetingName(meetingName), meetingName);

        System.out.println("Meeting Created Successfully");



        // ================= EDIT =================

        String updatedDescription =
                eUtil.getExcelData("EditEvent", 1, 3);

        cp.editEvent(meetingName, updatedDescription);

        System.out.println("Meeting Edited Successfully");



        // ================= DELETE =================

        cp.openAllEvents();

        cp.deleteMeeting(meetingName);

        Assert.assertFalse(cp.ismeetingpresent(meetingName));

        System.out.println("Meeting Deleted Successfully");
    }
}
