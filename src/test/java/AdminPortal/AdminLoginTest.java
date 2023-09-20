package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import datafactory.LoginData;
import dataobjects.AdminLogin;
import dataobjects.Login;
import functions.Admin_LoginFunction;
import functions.LoginFunction;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utilities.Constants;

public class AdminLoginTest extends BaseTest {
    @Test(priority = 0, description = "Login with valid credentials. ")
    @Severity(SeverityLevel.CRITICAL) //It's works on testNG version 7.4.0 not in 7.5
    @Description("Test Description: User login into the application with valid credentials")
    @Story("Valid Username and Password")
    public void enterAdminLoginCredentialsAndClickOnLoginButton() throws InterruptedException {

        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        Reporter.log("Step 1: Navigate to URl");
       // selenium.navigateToPage("https://hlinkadmin.azureedge.net/");
        Reporter.log("Step 2: Enter mobileNumber, password and click on the login button");
        // new LoginFunction(driver, selenium).loginIntoApplicationByUser(Constants.MobileNumber, Constants.Password);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());

    }

}
