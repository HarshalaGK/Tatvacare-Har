package pageobjects.TatvaCare;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;

public class MyPracticePO extends BasePO {

    public MyPracticePO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@id='navbarDropdown' and @aria-expanded='true']")
    private WebElement profileDropdownButton;

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminOption;

    @FindBy(xpath = "//span[text()='Manage User']")
    private WebElement manageUserOption;

    @FindBy(xpath = "//span[text()='Add User']")
    private WebElement addUserButton;



    public void navigateOnPracticePortal() throws InterruptedException {
        selenium.click(profileDropdownButton);
        selenium.hardWait(2);
        selenium.clickOn(adminOption);
        selenium.hardWait(2);
        selenium.clickOn(manageUserOption);
    }
    public void manageUser() throws InterruptedException {
      String userType= driver.findElement(By.xpath("//tr[@class='odd']/td[2]")).getText();

      if (userType == "Doctor / Owner"){
          selenium.clickOn(addUserButton);
          selenium.hardWait(2);
      }
      }
    @Step("Add Assistant User and detail ")
      public void selectHospital(){
        driver.findElement(By.xpath(" //input[@id='issuedbycheck']")).click();
      }
      public void phoneNumber(String text){
        driver.findElement(By.xpath(" //input[@placeholder='Phone No.']")).sendKeys(text);
      }
      public void selectDepartment(){
          Select select = new Select(driver.findElement(By.xpath("//select[@id='dp_id']")));
          select.selectByVisibleText("Cardiology");
      }

    public void fullName(String text){
        driver.findElement(By.xpath(" //input[@id='um_name']")).sendKeys(text);
    }

    public void selectUserType(){
        Select select = new Select(driver.findElement(By.xpath("//select[@id='edit_ut_id']")));
        select.selectByVisibleText("Dr. / Jr & Asst. Doctor");
    }

    public void emaiID(String text) {
        driver.findElement(By.xpath(" //input[@id='um_emailid']")).sendKeys(text);
    }

    public void medicalRegistrationNumber(String text) {
        driver.findElement(By.xpath(" //input[@id='gmc_no']")).sendKeys(text);
    }
}