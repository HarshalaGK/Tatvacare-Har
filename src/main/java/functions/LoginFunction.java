package functions;
import org.openqa.selenium.WebDriver;
import pageobjects.TatvaCare.HomePO;
import pageobjects.TatvaCare.LoginPO;
import utilities.SeleniumHelpers;

public class LoginFunction {
    protected WebDriver driver;
    protected SeleniumHelpers selenium;

    public LoginFunction(WebDriver driver, SeleniumHelpers selenium){
        this.driver = driver;
        this.selenium = selenium;
    }

    public void loginIntoApplicationByUser(String mobileNumber, String password) throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        login.enterLoginCredentialsAndClickOnLoginButton(mobileNumber, password);
    }
    public  void VerifyValidationMessageForInvalidLoginCredential(String invalidMobileNumber, String invalidPassword) throws InterruptedException{
        LoginPO invalidLogin = new LoginPO(driver);
        invalidLogin.enterInvalidCredentialsAndVerifyValidationMessage(invalidMobileNumber, invalidPassword);
    }
    public void VerifyValidationMessageForWithoutFillNumAndPass()throws InterruptedException{
        LoginPO login = new LoginPO(driver);
        login.loginWithoutFilledRequiredField();
    }

    public void VerifyValidationMessageForWithoutFillPassword(String mobileNumber)throws InterruptedException {
        LoginPO login = new LoginPO(driver);
        login.enterValidMobileNumAndVerifyValidationMessage(mobileNumber);
    }
    public void navigateOnHomeTab()throws InterruptedException{
        HomePO homePO = new HomePO(driver);
        homePO.loginAndClickOnHomeTab();
       // homePO.SubTabOnHomePageList();

    }

}
