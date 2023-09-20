package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import dataobjects.AdminLogin;
import functions.Admin_LoginFunction;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.AdminPortal.Event_ManagementPO;

public class EventManagementTest extends BaseTest {
    @Test(priority = 0, description = "Login In Admin Portal And Click On Event Management Tab")
    public void EventManagement() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        Event_ManagementPO event = new Event_ManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 1: create Internal Event");
        event.eventManageTab();
        event.createEvent();
        event.contentId("6345327");
        event.eventTitle("Externat Event");
        selenium.hardWait(1);
        event.selectEventType();
        event.externalEvent();
        event.selectStartDateAndEndDate();
       String specialityType=  event.selectSpeciality();
       selenium.hardWait(10);
       event.selectScheduleDate();
       event.publishEvent();




       //mediamanage.
    }
}