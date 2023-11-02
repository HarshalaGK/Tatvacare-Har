package pageobjects.AdminPortal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class ArticleManagementPO extends BasePO {
    public ArticleManagementPO(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[text()=' User Access ']")
    private WebElement userAccessTabButton;

    @FindBy(xpath = "//span[text()=' Upload Article ']")
    private WebElement uploadArticleTabButton;

    @FindBy(xpath = "//span[text()=' Master Article Request']")
    private WebElement masterArticleTabButton;

    @FindBy(xpath = "//img[@alt='Edit']//parent::a[1]")
    private WebElement userAccessEditButton;

    @FindBy(xpath = "//span[@class='close']")
    private WebElement userDetailCloseTabButton;

    @FindBy(xpath = "//a//img[@alt='Delete'][1]")
    private WebElement articleDeleteButton;

    @FindBy(xpath = "//img[@alt='Edit']//parent::a")
    private WebElement articleEditButton;

    @FindBy(xpath = "//span[text()='Logs']//parent::button")
    private WebElement logsButton;


    @FindBy(xpath = "//span[text()='Upload Article']")
    private WebElement threeDotUploadArticleButton;

    @Step("Navigate on User Access ")
    public void userAccessTab()throws InterruptedException{
        selenium.clickOn(userAccessTabButton);
        selenium.hardWait(5);
    }

     @Step("Edit The User Detail In User Access ")
    public void editUserDetailInUserAccess()throws InterruptedException{
        selenium.clickOn(userAccessEditButton);
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter Primary Contact']")).sendKeys("-");
    }
    public void saveChangeButtonInUserAccessTab(){
        driver.findElement(By.xpath("//span[text()=' Save Changes ']")).click();
    }
    public String successMessageForSaveChange(){
      String text=  driver.findElement(By.xpath("//div[contains(@class,'p-toast-message-content')]//div//div[2]")).getText();
      return text;
    }
    @Step("close the tab of User Access ")
    public void userDetailCloseTab()throws InterruptedException{
        selenium.clickOn(userDetailCloseTabButton);
    }
    public void clickOnUploadArticle()throws InterruptedException{
        selenium.clickOn(uploadArticleTabButton);

    }
    @Step("Upload Article delete and edit there is no success message")
    public void articleDelete()throws InterruptedException{
        selenium.clickOn(articleDeleteButton);
    }
    public void articleDeleteAlertYes(){
        driver.findElement(By.xpath("//p-button[@label='Yes']")).click();
    }
    public void articleDeleteAlertNo(){
        driver.findElement(By.xpath("//p-button[@label='No']")).click();
    }
    @Step("Upload Article Edit")

    public void articleEdit()throws InterruptedException{
        selenium.clickOn(articleEditButton);
    }
    public void uploadArticleEdit(){
        driver.findElement(By.xpath("//span[text()='Save']//parent::button")).click();
    }


    @Step("Master Article Request first click on  : dot button")
    public void masterArticleRequestTab()throws InterruptedException{
        selenium.clickOn(masterArticleTabButton);

    }
    public void articleThreeDotButtonClick()throws InterruptedException{
        driver.findElement(By.xpath("//tbody/tr[1]//button[@aria-label='Example icon-button with a menu']")).click();

    }
    public void editArticleMasterRequest()throws InterruptedException{
        driver.findElement(By.xpath("//span[text()='Edit']//parent::button")).click();
        selenium.hardWait(3);
        driver.findElement(By.xpath("//div/button[@label='Edit']")).click();
    }
    public void editFinalCoast(){
       String text= driver.findElement(By.xpath("//input[@placeholder='Cost Research Solution']")).getText();
       driver.findElement(By.xpath("//input[@placeholder='Final Cost']")).sendKeys(text);
    }
    @Step("Master Article Request edit button change in to save change button")
    public void clickOnSaveChangeButtonInArticleRequest(){
        driver.findElement(By.xpath("//span[text()=' Save Changes ']//parent::button")).click();
    }
    @Step("success message for after edit")
    public String detailUpdateSuccessMessage(){
       String msg= driver.findElement(By.xpath("//div(text()='MasterArticleDetails Saved Successfully')")).getText();
       return msg;
    }
    public void masterArticleEditTabClose(){
        driver.findElement(By.xpath("//span[@class='close']")).click();
    }

    @Step("Master Article Request in click on upload article button and upload pdf in that")

    public void threeDotUploadArticle()throws InterruptedException{
        selenium.clickOn(threeDotUploadArticleButton);
    }
    public void uploadPDFArticleCancel()throws InterruptedException{
//        driver.findElement(By.xpath("//span[text()='Upload Article']//parent::button")).click();
        selenium.hardWait(2);
        driver.findElement(By.xpath("//span[text()='Cancel']//parent::button")).click();
    }

    public void uploadPDFArticleSave() {
       // driver.findElement(By.xpath("//span[text()='Upload Article']//parent::button")).click();
        driver.findElement(By.xpath("//input[@class='custom-file-input']")).sendKeys("C://Users//hlink//Desktop//NweTatvacare//Tatvacare-Har//src//main//resources//Images//sample pdf.pdf");
        driver.findElement(By.xpath("//span[text()='Save']//parent::button")).click();
    }

}
