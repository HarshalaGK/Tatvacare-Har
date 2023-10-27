package pageobjects.AdminPortal;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

    public class Admin_LoginPO extends BasePO {

        public Admin_LoginPO(WebDriver driver) {
            super(driver);
        }

        @FindBy(id="nationalNumber")
        //label[text()='Mobile Number']
        private WebElement mobileNumberTextBox;

        @FindBy(id = "password")
        private WebElement passwordTextBox;

        @FindBy(id = "continue")
        private WebElement loginButton;


        @Step("Enter MobileNumber: [0], password [1] and click on Login button")
        public void enterAdminLoginCredentialsAndClickOnLoginButton(String adminMobileNumber, String adminPassword) throws InterruptedException {
            selenium.enterText(mobileNumberTextBox, adminMobileNumber , true);
            selenium.enterText(passwordTextBox, adminPassword , true);
            selenium.click(loginButton);
            selenium.hardWait(10);
        }
    }


