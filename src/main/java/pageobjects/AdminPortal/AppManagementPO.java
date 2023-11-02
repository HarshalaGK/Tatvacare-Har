package pageobjects.AdminPortal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.List;

public class AppManagementPO extends BasePO {
    public AppManagementPO(WebDriver driver){
        super(driver);
    }
    JavaHelpers javaHelpers = new JavaHelpers();
    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    private WebElement userManagementTab;

    @FindBy(xpath = "//span[contains(text(),'Add User')]")
    private WebElement addUserButton;

    @FindBy(xpath = "//span[contains(text(),'Select Account Type')]")
    private WebElement  accountTypeInAddUser;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameBoxInAddUser;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement  lastNameBoxInAddUser;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailBoxInAddUser;

    @FindBy(xpath = "//input[@id='regNo']")
    private WebElement registrationNumberBoxInAddUser;

    @FindBy(xpath = "//input[@id='accessCode']")
    private WebElement accessCodeBoxInAddUser;

    @FindBy(xpath = "//input[@id='mobileNo']")
    private WebElement mobileNumberBoxInAddUser;

    @FindBy(xpath = "//button[text()='Create Account']")
    private WebElement createAccountButtonInAddUser;

//    @FindBy(xpath = "//input[@id='regNo']")
//    private WebElement registrationNumberBoxInAddUser;
//    @FindBy(xpath = "//input[@id='regNo']")
//    private WebElement registrationNumberBoxInAddUser;
//    @FindBy(xpath = "//input[@id='regNo']")
//    private WebElement registrationNumberBoxInAddUser;



    @Step(" User Management through the Add User In admin Panel First click on User Management")
    public void clickOnUserManagementTab()throws InterruptedException{
    selenium.clickOn(userManagementTab);
    }

    public void addUser()throws InterruptedException{
        selenium.clickOn(addUserButton);
    }
    @Step("select account type as guest")
    public  void  selectAccountType()throws InterruptedException{
        selenium.clickOn(accountTypeInAddUser);
        driver.findElement(By.xpath("//li//span[text()='Guest']")).click();
    }
    @Step("select account expiry date")
    public void selectExpiryDate()throws InterruptedException{
        driver.findElement(By.xpath("//input[@placeholder='Select Expiry Date']")).click();
        driver.findElement(By.xpath("//button//span[contains(@class,'p-datepicker-next-icon pi pi-chevron-right')]")).click();
        selenium.hardWait(5);
        driver.findElement(By.xpath("//span[text()='17']")).click();
    }
    @Step("select account any gender in list")
    public void selectRandomGender()throws InterruptedException{
        driver.findElement(By.xpath("//span[text()='Select Gender']")).click();
        List<WebElement> filterOption = driver.findElements(By.xpath("//p-dropdownitem//li[@role='option']//span"));
        selenium.hardWait(2);
        String randomNumber = (javaHelpers.getRandomNumber(filterOption.size(), 1));
        driver.findElement(By.xpath("//p-dropdownitem//li[@role='option']["+randomNumber+"]//span")).click();
        selenium.hardWait(2);
    }
    @Step("write any First name")
    public void firstName(String text){
        firstNameBoxInAddUser.sendKeys(text);
    }
    @Step("write any Last Name")
    public void lastName(String lastname){
        lastNameBoxInAddUser.sendKeys(lastname);
    }
    @Step("write any valid email address")
    public void emailAddress(String email){
        emailBoxInAddUser.sendKeys(email);
    }
    @Step("write any registration number")
    public void registrationNumber(){
        selenium.enterText(registrationNumberBoxInAddUser, javaHelpers.getContentId(7), true);
    }

    @Step("select account any type of speciality")
    public void selectRandomSpeciality()throws InterruptedException{
        driver.findElement(By.xpath("//span[text()='Select Speciality']")).click();
        List<WebElement> filterOption = driver.findElements(By.xpath("//div//ul[@role='listbox']//p-dropdownitem"));
        selenium.hardWait(2);
        String randomNumber = (javaHelpers.getRandomNumber(filterOption.size(), 1));
        driver.findElement(By.xpath("//div//ul[@role='listbox']//p-dropdownitem["+randomNumber+"]//li")).click();
        selenium.hardWait(2);
    }
    @Step("select Qualification in list")
    public void selectQualification()throws InterruptedException{
        driver.findElement(By.xpath("//span[text()='Select Qualification']")).click();
        List<WebElement> qulOption = driver.findElements(By.xpath("//div//ul[@role='listbox']//p-dropdownitem"));
        selenium.hardWait(2);
        String randomNumber = (javaHelpers.getRandomNumber(qulOption.size(), 1));
        driver.findElement(By.xpath("//div//ul[@role='listbox']//p-dropdownitem["+randomNumber+"]//li")).click();
        selenium.hardWait(2);
    }
    @Step("select account division type ")
    public void selectDivision()throws InterruptedException{
        driver.findElement(By.xpath("//span[text()='Select Division']")).click();
        List<WebElement> options = driver.findElements(By.xpath("//div//ul[@role='listbox']//p-dropdownitem"));
        selenium.hardWait(2);
        String randomNumber = (javaHelpers.getRandomNumber(options.size(), 1));
        driver.findElement(By.xpath("//div//ul[@role='listbox']//p-dropdownitem["+randomNumber+"]//li")).click();
        selenium.hardWait(2);
    }



    }

