package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import dataobjects.AdminLogin;
import functions.Admin_LoginFunction;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.AdminPortal.Event_ManagementPO;

public class EventManagementTest extends BaseTest {
    @Test(priority = 0, description = "Login and click on HomeTab")
    public void EventManagement() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        //HomePO homePO = new HomePO(driver);
        Event_ManagementPO event = new Event_ManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 1: Click On HomeTab");
       //mediamanage.
    }
}