package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import dataobjects.AdminLogin;
import functions.Admin_LoginFunction;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.AdminPortal.Event_ManagementPO;

public class EventManagementTest extends BaseTest {
    @Test(priority = 0, description = "Login In Admin Portal And Click On Event Management Tab")
    public void EventManagement() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        Event_ManagementPO event = new Event_ManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 1: create Internal Event For All Country");
        event.eventManageTab();
        event.createEvent();
        event.contentId();
        event.selectAllCountry();
        event.eventTitle("1 External Event");
        selenium.hardWait(2);
        event.selectEventType();
        event.externalEvent();
        event.selectStartDateAndEndDate();
        event.fullDayEventCheck();
        String specialityType=  event.selectSpeciality();
        selenium.hardWait(10);
        event.selectScheduleDate();
        event.publishEvent();
        selenium.hardWait(10);
        Reporter.log("Step 2: verify the Extenal Event Is Publish or not");
        String newsText = event.eventVerify();
        Assert.assertEquals("1 External Event" , newsText);



        Reporter.log("Step 3: create Internal Event for All Country");
        event.createEvent();
        event.contentId();
        event.selectAllCountry();
        event.eventTitle("2 Internal Event");
        selenium.hardWait(1);
        event.selectEventType();
        event.selectInternalEvent();
        event.internalEventDescription();
        event.selectStartDateAndEndDate();
        event.fullDayEventCheck();
        String sType=  event.selectSpeciality();
        selenium.hardWait(10);
        event.selectScheduleDate();
        event.publishEvent();
        selenium.hardWait(10);
        Reporter.log("Step 2: verify the Extenal Event Is Publish or not");
        String nText = event.eventVerify();
        Assert.assertEquals("2 Internal Event" , newsText);


    }
}