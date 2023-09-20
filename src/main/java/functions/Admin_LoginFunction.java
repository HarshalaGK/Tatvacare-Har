package functions;

import org.openqa.selenium.WebDriver;
import pageobjects.AdminPortal.Admin_LoginPO;
import pageobjects.TatvaCare.LoginPO;
import utilities.SeleniumHelpers;

public class Admin_LoginFunction {
    protected WebDriver driver;
    protected SeleniumHelpers selenium;
    public Admin_LoginFunction(WebDriver driver, SeleniumHelpers selenium) {
        this.driver = driver;
        this.selenium = selenium;
    }
    public void loginByAdmin(String mobileNumber, String password) throws InterruptedException {
        Admin_LoginPO adminLogin = new Admin_LoginPO(driver);
        selenium.navigateToPage("https://diginextadmin72093uat.azureedge.net");
        adminLogin.enterAdminLoginCredentialsAndClickOnLoginButton(mobileNumber,password);
    }




    }
