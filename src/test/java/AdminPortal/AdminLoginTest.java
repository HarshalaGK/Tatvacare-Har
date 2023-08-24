package AdminPortal;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
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

        Login loginData = new LoginData().getLoginData();
//        Reporter.log("Step 1: Navigate to URl");
//        selenium.navigateToPage("https://diginextdev.b2clogin.com/");
//        Reporter.log("Step 2: Enter mobileNumber, password and click on the login button");
//        // new LoginFunction(driver, selenium).loginIntoApplicationByUser(Constants.MobileNumber, Constants.Password);
//        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
    }

}
