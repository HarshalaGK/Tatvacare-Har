package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.MyPracticePO;
import pageobjects.TatvaCare.PubmedPO;
import utilities.Constants;

public class MYPracticeTest extends BaseTest {

    @Test(priority = 0, description = "Login and navigate on My Practice Tab")
    public void login() throws InterruptedException {
        Login loginData = new LoginData().getLoginData();
        selenium.navigateToPage(Constants.URL);
        selenium.hardWait(5);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
        MyPracticePO pm =  new MyPracticePO(driver);
        pm.navigateOnPracticePortal();

        Reporter.log("Step 2: Add Assistant Doctor  ");
        pm.manageUser();
        pm.addUser();
        pm.selectHospital();
        pm.phoneNumber("9837237238");
        pm.selectDepartment();
        pm.fullName("neha sharma");
        pm.selectUserType();
        pm.emaiID("abc@gmail.com");
        pm.medicalRegistrationNumber("136543");
        pm.submit();


    }
}