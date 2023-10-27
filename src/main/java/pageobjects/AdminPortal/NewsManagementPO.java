package pageobjects.AdminPortal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.List;

public class NewsManagementPO extends BasePO {
    public NewsManagementPO(WebDriver driver) {
        super(driver);
    }

    JavaHelpers javaHelpers = new JavaHelpers();
    @FindBy(xpath = "//span[text()=' News Management']")
    private WebElement newsManagementTab;

    @FindBy(xpath = "//span[text()='Add News']")
    private WebElement addNewsButton;

    @FindBy(xpath = "//p-multiselect[@defaultlabel='Select Therapy Area']")
    private WebElement therapyAreaTextBox;
    @FindBy(xpath = "//p-checkbox[@inputid='isFullScreenContent']/div")
    private WebElement fullScreenContentCheckBox;

    @FindBy(xpath = "//span[text()='Select Type']")
    private WebElement selectNewsTypeTextBox;

    @FindBy(xpath = "//span[text()='Image']")
    private WebElement imageNewsType;
    @FindBy(xpath = "//span[text()='Video']")
    private WebElement videoNewsType;

    @FindBy(xpath = "//span[text()='Select Status']")
    private WebElement statusTexBox;
    @FindBy(xpath = "//span[text()='PUBLISHED']")
    private WebElement publishedNewsOption;
    @FindBy(xpath = "//span[text()='SCHEDULED']")
    private WebElement scheduledNewsOption;
    @FindBy(xpath = "//div[text()='Select Tags']")
    private WebElement tagTextBox;

    @FindBy(xpath = "//p-calendar[@formcontrolname='trendingStartDate']//button")
    private WebElement trendingStartDateBox;
    @FindBy(xpath = "//p-calendar[@formcontrolname='trendingEndDate']//button")
    private WebElement trendingEndDateBox;
    @FindBy(xpath = "//td[contains(@class,'datepicker-today')]")
    private WebElement trendingStartDate;
    @FindBy(xpath = "//td[contains(@class,'datepicker-today')]/following-sibling::td[1]")
    private WebElement trendingEndDate;

    @FindBy(xpath = "//div[contains(text(),'Select Country')]")
    private WebElement selectCountyDropDown;

    @FindBy(xpath = "//div[contains(@class, 'p-multiselect-header ng-tns')]//div[1]")
    private WebElement allSelectCountryCheckBox;

    public void newsManagementTAb() throws InterruptedException {
        selenium.clickOn(newsManagementTab);
    }

    public void addNews() throws InterruptedException {
        selenium.clickOn(addNewsButton);
    }

    public void selectTherapyArea() throws InterruptedException {
        selenium.hardWait(5);
        selenium.clickOn(therapyAreaTextBox);
        selenium.hardWait(3);
         driver.findElement(By.xpath("//div[contains(@class, 'p-multiselect-header')]/div[1]")).click();
        selenium.hardWait(1);
        driver.findElement(By.xpath("//button[contains(@class,'p-multiselect-close')]")).click();
//        List<WebElement> therapyOption = driver.findElements(By.xpath("//ul[@role='listbox']//p-multiselectitem/li/div"));
//        String randomNumber = (javaHelpers.getRandomNumber(therapyOption.size(), 2));
//        selenium.hardWait(2);
//        driver.findElement(By.xpath("//ul[@role='listbox']//p-multiselectitem[" + randomNumber + "]/li/div")).click();
//        selenium.hardWait(2);
//        driver.findElement(By.xpath("//button[contains(@class,'p-multiselect-close')]")).click();
    }

    public void fullContentNewsCheckBox() throws InterruptedException {
        selenium.clickOn(fullScreenContentCheckBox);
    }

    public void selectImageNews() throws InterruptedException {
        selenium.clickOn(selectNewsTypeTextBox);
        selenium.clickOn(imageNewsType);
    }

    public void selectVideoNews() throws InterruptedException {
        selenium.clickOn(selectNewsTypeTextBox);
        selenium.clickOn(videoNewsType);
    }

    public void selectPublishedStatus() throws InterruptedException {
        selenium.clickOn(statusTexBox);
        selenium.clickOn(publishedNewsOption);
    }

    public void selectScheduledNews() throws InterruptedException {
        selenium.clickOn(statusTexBox);
        selenium.clickOn(scheduledNewsOption);
    }

    public void setScheduleDate() {
        driver.findElement(By.xpath("//p-calendar[@formcontrolname='scheduledPublishedDate']//button")).click();
        WebElement nextDay = driver.findElement(By.xpath("//td[contains(@class,'datepicker-today')]/following-sibling::td[1]"));
        nextDay.click();
    }

    public void titleOFNews(String title) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='title']")).sendKeys(title);
    }

    public void newsDescription() throws InterruptedException {
      WebElement des=  driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
      des.sendKeys("news description");
    }

    public void selectTag() throws InterruptedException {
        selenium.clickOn(tagTextBox);
        selenium.hardWait(3);
        List<WebElement> filterOption = driver.findElements(By.xpath("//ul[@role='listbox']//p-multiselectitem"));
        String randomNumber = (javaHelpers.getRandomNumber(filterOption.size(), 1));
        selenium.hardWait(2);
        driver.findElement(By.xpath("//ul[@role='listbox']//div/p-multiselectitem[" + randomNumber + "]/li/div")).click();
        selenium.hardWait(2);
        driver.findElement(By.xpath("//button[contains(@class, 'p-multiselect-close')]")).click();

    }

    public void linkedUrlLink() throws InterruptedException {
        selenium.hardWait(2);
         WebElement e=  driver.findElement(By.xpath("//input[@id='readMoreUrl']"));
         selenium.clickOn(e);
         e.sendKeys("https://indianexpress.com/section/education/");
         selenium.hardWait(2);

    }

    public void labelName(String label) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='readMoreLable']")).sendKeys(label);
    }
    @Step(" given the image path for upload image")
    public void uploadImage()throws InterruptedException {
        selenium.hardWait(5);
        WebElement imag = driver.findElement(By.xpath("//label[text()='Image *']//following-sibling::div/input"));
        imag.sendKeys("C://Users//hlink//Desktop//NweTatvacare//Tatvacare-Har//src//main//resources//Images//mZWTSqsHwPqLJ4WCez9mSm.jpg");
    }
    @Step(" given the video and image path for upload ")
    public void uploadVideo() throws InterruptedException {
        WebElement video = driver.findElement(By.xpath("//label[text()='Video *']//following-sibling::div/input"));
        video.sendKeys("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//sample-15s.mp4");
        selenium.hardWait(2);
        WebElement thumbNail = driver.findElement(By.xpath("//label[text()='Thumbnail For Video - jpeg / jpg / png *']//following-sibling::div/input"));
        thumbNail.sendKeys("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//mZWTSqsHwPqLJ4WCez9mSm.jpg");
        selenium.hardWait(1);
    }

    public void saveNews() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Save']")).click();
        selenium.hardWait(5);
    }
    @Step("click on country dropdown and select all country")
    public void selectAllCountry() throws InterruptedException {
        selenium.clickOn(selectCountyDropDown);
        selenium.hardWait(2);
        selenium.clickOn(allSelectCountryCheckBox);
        selenium.hardWait(2);
        driver.findElement(By.xpath("//button[contains(@class, 'p-multiselect-close p-link ng-tns')]")).click();
    }

    public void sendNotification() {
        driver.findElement(By.xpath("//p-checkbox[@inputid='isNotification']")).click();
    }

    public void selectTrending() {
        driver.findElement(By.xpath("//p-checkbox[@inputid='isTrending']")).click();
    }

    public void setTrendingDate() throws InterruptedException {
        selenium.clickOn(trendingStartDateBox);
        selenium.clickOn(trendingStartDate);
        selenium.hardWait(1);
        selenium.clickOn(trendingEndDateBox);
        selenium.clickOn(trendingEndDate);
    }
    public void deleteNews()throws InterruptedException{
        driver.findElement(By.xpath("//a//img[@alt='Delete'][1]")).click();
        selenium.hardWait(2);
        driver.findElement(By.xpath("//p-button[@label='Yes']")).click();
        selenium.hardWait(2);
    }
    public String deleteSuccessMessage(){
       String text= driver.findElement(By.xpath("//p-toastitem//div[text()='News deleted successfully']")).getText();
       return text;
    }
    public void editNews(){
        driver.findElement(By.xpath("//a//img[@alt='Edit'][1]")).click();
        WebElement edit =  driver.findElement(By.xpath("//div[@class='ql-editor']"));
      selenium.enterText(edit,"edit news description", true);
    }
    public String editSuccessMessage(){
        String text= driver.findElement(By.xpath("//p-toastitem//div[text()='News uploaded successfully']")).getText();
        return text;

    }
    public void selectCountyAsIndia() throws InterruptedException {
        selenium.clickOn(selectCountyDropDown);
        selenium.hardWait(5);
        driver.findElement(By.xpath("//li[@aria-label='India']/div")).click();
    }
    @Step("Select Today Date And Submit Get News Text For Verify")
    public String newsVerify() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='From']")).click();
        driver.findElement(By.xpath("//td[contains(@class, 'p-datepicker-today ng-star-inserted')]")).click();
        selenium.hardWait(5);
        driver.findElement(By.xpath("//p-button[@label='Submit']")).click();
        selenium.hardWait(5);
        String newsText = driver.findElement(By.xpath("//tbody[@class='p-datatable-tbody']//tr//td[3]")).getText();
        return newsText;
    }

}



