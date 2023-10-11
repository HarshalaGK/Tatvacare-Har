package pageobjects.TatvaCare;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;
import utilities.Constants;

public class LoginPO extends BasePO {
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
     */

    @FindBy(id="nationalNumber")
    private WebElement mobileNumberTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "continue")
    private WebElement loginButton;

    @FindBy(id="claimVerificationServerError")
    private WebElement validationMessage;

    @FindBy(id="requiredFieldMissing")
    private WebElement requiredFieldMissingMessage;

    @FindBy(xpath ="//div[@class='error itemLevel show']")
    private WebElement passwordRequireMessage;



    /**
     * Enter login credentials and click on the login button
     *
     * @param mobileNumber mobileNumber
     * @param password password
     * @throws InterruptedException
     */
    @Step("Enter MobileNumber: [0], password [1] and click on Login button")
    public void enterLoginCredentialsAndClickOnLoginButton(String mobileNumber, String password) throws InterruptedException {
        //selenium.navigateToPage(Constants.URL);
        selenium.enterText(mobileNumberTextBox, mobileNumber , true);
        selenium.enterText(passwordTextBox, password , true);
        selenium.click(loginButton);
        selenium.hardWait(10);
    }
    @Step("Enter InvalidMobileNumber: [0], InvalidPassword [1] and click on Login button")
    public void enterInvalidCredentialsAndVerifyValidationMessage(String invalidMobileNumber, String invalidPassword) throws InterruptedException{
        selenium.enterText(mobileNumberTextBox, invalidMobileNumber, true);
        selenium.enterText(passwordTextBox, invalidPassword, true);
        selenium.click(loginButton);
       // selenium.getText(validationMessage);
    }
    public String validationMessageForInvalidCredential()throws InterruptedException{
        return selenium.getText(validationMessage);
    }

    public void loginWithoutFilledRequiredField()throws InterruptedException{
        selenium.click(loginButton);
    }
    public String ValidationMessageForRequiredFieldMissing()throws InterruptedException{
        return selenium.getText(requiredFieldMissingMessage);
    }

    @Step("Enter InvalidMobileNumber: [0]and click on Login button")
    public void enterValidMobileNumAndVerifyValidationMessage(String mobileNumber) throws InterruptedException {
        selenium.enterText(mobileNumberTextBox, mobileNumber, true);
        selenium.hardWait(3);
        selenium.click(loginButton);
        selenium.hardWait(5);
    }
    public String ValidationMessageForPasswordRequired()throws InterruptedException {
        return selenium.getText(passwordRequireMessage);
    }

}
