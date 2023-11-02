package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import dataobjects.AdminLogin;
import functions.Admin_LoginFunction;
import io.qameta.allure.Story;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.AdminPortal.AppManagementPO;
import pageobjects.AdminPortal.Event_ManagementPO;

public class AppManagementTest extends BaseTest {
    @Test(priority = 1, description="Login To Admin and Manage User Management Data")
    @Story("In User Management Mange User Listing And Manage Group")
    public void manageUserListingAndGroup() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        Event_ManagementPO event = new Event_ManagementPO(driver);
        AppManagementPO userManage= new AppManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 1: Navigate On User Management In Admin Portal ");
        Reporter.log("Step 2: Click On add User Button And Navigate On User Detail Form");
        userManage.addUser();
        Reporter.log("Step 3: Create As Guest Account Type ");
        userManage.selectAccountType();
        userManage.selectExpiryDate();
        userManage.selectRandomGender();
    }
}