package pageobjects.TatvaCare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;

import javax.swing.*;
import java.util.List;

public class CalendarPO extends BasePO {
   public CalendarPO(WebDriver driver){
        super(driver);
    }
    @FindBy (xpath = "//li[@id='navItemScheduler']")
    private WebElement calendarTab;

    @FindBy (xpath = "//button[contains(@class, 'mat-focus-indicator mr-4')]")
    private WebElement addEventButton;

    @FindBy (xpath = "//select[@id='appointment']")
    private WebElement appointmentDropdown;

    @FindBy (xpath = "//select[@id='status']")
    private WebElement statusDropdown;
    @FindBy (xpath = "//select[@id='mode']")
    private WebElement modeDropdown;
    @FindBy (xpath = "//textarea[@id='subject']")
    private WebElement titleBOx;

    @FindBy (xpath = "//textarea[@id='notes']")
    private WebElement notesBox;

    @FindBy(xpath = "//button[text()=' Create ']")
    private WebElement createButton;
    @FindBy(xpath = "//button[contains(@class,'cancel-btn mat-button mat-button-base')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//a[text()='Monthly']")
    private WebElement monthlyViewButton;

    @FindBy(xpath = "//a[text()='List']")
    private WebElement listButton;
    public void getWindowHandle()throws InterruptedException{
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
        selenium.hardWait(2);
    }
    public void tabOnCalendar()throws InterruptedException{
        selenium.clickOn(calendarTab);
    }
    public void addeventButtonInCalender()throws InterruptedException{
        selenium.clickOn(addEventButton);
    }
    public void appointmentType(String text)throws InterruptedException{
       selenium.javascriptClickOn(appointmentDropdown);
       driver.findElement(By.xpath("//option[text()='"+text+"']")).click();

    }
    public void statusType(String text){
        Select select = new Select(statusDropdown);
        select.selectByVisibleText(text);
    }

    public void modeType(String text){
        Select select = new Select(modeDropdown);
        select.selectByVisibleText(text);
    }
    public void title(String text)throws InterruptedException{
        driver.findElement(By.xpath("//textarea[@id='subject']")).sendKeys(text);
    }
    public void selectCorrentDate(){
        driver.findElement(By.xpath("//input[@id='date']")).click();
        driver.findElement(By.xpath("//span[@tabindex='0']")).click();
    }
    public void selectAnyDate(String num){
        driver.findElement(By.xpath("//input[@id='date']")).click();
        driver.findElement(By.xpath("//*[text()="+num+"]")).click();
    }

    public void selectStartTime(){
        driver.findElement(By.xpath("//p-calendar[@inputid='stime']")).click();
      //  driver.findElement(By.xpath("//div[contains(@class,'p-hour-picker')]//span[starts-with(@class,'pi pi-chevron-up')]")).click();

    }
    public void selectEndTime()throws InterruptedException{
        driver.findElement(By.xpath("//p-calendar[@inputid='etime']")).click();
        selenium.hardWait(5);
        driver.findElement(By.xpath("//div[contains(@class,'p-hour-picker')]//button[starts-with(@class,'p-link ng-tns-c')][1]")).click();
//        WebElement a=  driver.findElement(By.xpath("//div[contains(@class,'p-hour-picker')]//span[starts-with(@class,'pi pi-chevron-up')]"));
//        selenium.doubleClickOnElement(a);
    }
    public void addressFirst(String link1){
        driver.findElement(By.xpath("//input[@placeholder='Address 1']")).sendKeys(link1);
    }
    public void addressSecond(String link2){
        driver.findElement(By.xpath("//input[@placeholder='Address 2']")).sendKeys(link2);
    }
    public void link(String link){
        driver.findElement(By.xpath("//input[@id='link']")).sendKeys(link);
    }
    public void clickOnCreateButton()throws InterruptedException{
        selenium.clickOn(createButton);
    }
    public void clickOnCancelButton()throws InterruptedException{
        selenium.clickOn(cancelButton);
    }
    public void monthlyView()throws InterruptedException{
        selenium.clickOn(monthlyViewButton);
    }
    public void listView()throws InterruptedException{
        selenium.clickOn(listButton);
    }
    public void listData()throws InterruptedException{
        selenium.hardWait(10);
        List<WebElement> k =driver.findElements(By.xpath("//tbody[@class='p-datatable-tbody']//td//span"));
        for(int i=0; i<k.size();i++){
           System.out.println(k.get(i).getText());
        }
    }


}
