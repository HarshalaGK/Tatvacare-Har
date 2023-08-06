package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.LoginPO;
import utilities.Constants;

import java.util.List;

public class LoginTest extends BaseTest {

    @Test(priority = 0, description = "Login with valid credentials. ")
    @Severity(SeverityLevel.CRITICAL) //It's works on testNG version 7.4.0 not in 7.5
    @Description("Test Description: User login into the application with valid credentials")
    @Story("Valid Username and Password")
    public void enterLoginCredentialsAndClickOnLoginButton() throws InterruptedException {

        Login loginData = new LoginData().getLoginData();
        Reporter.log("Step 1: Navigate to URl");
        selenium.navigateToPage(Constants.URL);
        Reporter.log("Step 2: Enter mobileNumber, password and click on the login button");
        // new LoginFunction(driver, selenium).loginIntoApplicationByUser(Constants.MobileNumber, Constants.Password);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
    }


    @Test(priority = 0, description = "Login with invalid credentials. ")
    @Severity(SeverityLevel.NORMAL) //It's works on testNG version 7.4.0 not in 7.5
    @Description("Verify that validations message is displayed when user try to login with invalide credential")
    @Story("inValid mobile number and Password")
    public void enterInvalidLoginCredentialsAndClickOnLoginButton() throws InterruptedException {

        Login loginData = new LoginData().getInvalidLoginData();
        LoginPO loginPO = new LoginPO(driver);
        Reporter.log("Step 1: Navigate to URl");
        selenium.navigateToPage(Constants.URL);
        Reporter.log("Step 2: Enter invalid mobile number, invalid password and click on the login button");
        new LoginFunction(driver, selenium).VerifyValidationMessageForInvalidLoginCredential(loginData.getInvalidMobileNumber(), loginData.getInvalidPassword());
        Reporter.log("Step : Verify the validation message");
        Assert.assertEquals(loginPO.validationMessageForInvalidCredential(), "We can't seem to find your account3");
    }

    @Test(priority = 0, description = "Click On Login Button withot Filled Mobile Number and Password.")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that validations message is displayed when user click on loging without fill data")
    @Story("Enpty Mobile and Passworg field")
    public void clickOnLoginButtonWithoutFillRequiredField() throws InterruptedException {
        LoginPO loginPO = new LoginPO(driver);
        Reporter.log("Step 1: Navigate to URl");
        selenium.navigateToPage(Constants.URL);
        Reporter.log("Step 2: Click on the login button");
        new LoginFunction(driver, selenium).VerifyValidationMessageForWithoutFillNumAndPass();
        Assert.assertEquals(loginPO.ValidationMessageForRequiredFieldMissing(), "A required field is missing. Please fill out all required fields and try again.");

    }
//    @Test(priority = 0, description = "Click On Login Button with only filled mobileNumber field.")
//    @Severity(SeverityLevel.NORMAL)
//    @Description("Verify that validations message is displayed when user click on login only fill MobileNumber")
//    @Story("Empty password filled")
//    public void clickOnLoginButtonWithoutFillPasswordField()throws InterruptedException{
//        LoginPO loginPO = new LoginPO(driver);
//        Login loginData = new LoginData().getOneFilledData();
//        Reporter.log("Step 1: Navigate to URl");
//        selenium.navigateToPage(Constants.URL);
//        Reporter.log("Step 2: Click on the login button");
//        new LoginFunction(driver,selenium).VerifyValidationMessageForWithoutFillPassword(loginData.getMobileNumber());
//       // loginPO.loginWithoutFilledRequiredField();
//        Assert.assertEquals(loginPO.ValidationMessageForPasswordRequired(),"This information is required.");
//
//        Assert.assertEquals(loginPO.ValidationMessageForRequiredFieldMissing(),"A required field is missing. Please fill out all required fields and try again.");
//}


}