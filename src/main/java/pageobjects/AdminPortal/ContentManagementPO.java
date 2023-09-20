package pageobjects.AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.List;

public class ContentManagementPO extends BasePO {
    public ContentManagementPO(WebDriver driver){
        super(driver);}
    JavaHelpers javahelpers = new JavaHelpers();

    @FindBy(xpath = "//span[text()=' Content Management']")
    private WebElement contentManagementTabButton;

    @FindBy(xpath = "//span[text()='Upload Content']")
    private WebElement createContentButton;

    @FindBy(xpath = "//div[text()='Select Content Genre']")
    private WebElement selectGenreBox;

    @FindBy(xpath = "//div[text()='Select Continuum']")
    private WebElement selectContinuumBox;

    @FindBy(xpath = "//span[text()='Select Type']")
    private WebElement selectContentTypeBox;

    @FindBy(xpath = "//span[text()='Add File']")
    private WebElement addFileButton;

    @FindBy(xpath = "//textarea[@formcontrolname='contentTitle']")
    private WebElement contentTitleBox;

    @FindBy(xpath = "//textarea[@formcontrolname='contentDescription']")
    private WebElement contentDescription;

    @FindBy(xpath = "//input[@id='timeonly']")
    private WebElement timeFieldBox;

    @FindBy(xpath = "//div[text()='Select Speciality']")
    private WebElement specialityTextBox;

    @FindBy(xpath = "//div[text()='Select Topics']")
    private WebElement topicTextBox;

    @FindBy(xpath = "//input[@formcontrolname='therapyBasedTags']")
    private WebElement  therapyBasedTabBox;

    @FindBy(xpath = "//input[@formcontrolname='descriptionBasedTags']")
    private WebElement descriptionBasedTagBox;

    @FindBy(xpath = "//p-calendar[@formcontrolname='scheduledPublishedDate']//button")
    private WebElement scheduleStartDateBox;
    @FindBy(xpath = "//p-calendar[@formcontrolname='expiryDate']//button")
    private WebElement expireDateBox;

    @FindBy(xpath = "//td[contains(@class,'datepicker-today')]/following-sibling::td[1]")
    private WebElement endDate;

    @FindBy(xpath = "//td[contains(@class,'p-datepicker-today ng-star-inserted')]")
    private WebElement currentDate;

    @FindBy(xpath = "//input[@formcontrolname='wordCount']")
    private WebElement wordCountBox;

    @FindBy(xpath = "//p-checkbox[@inputid='notApplicable']")
    private WebElement notApplicableCheckBox;


        public void selectContentManagementTab()throws InterruptedException{
          selenium.clickOn(contentManagementTabButton);
           }
           public void clickOnUploadContent()throws InterruptedException{
            selenium.clickOn(createContentButton);
           }
        public void selectGenreTypeFilter() throws InterruptedException{
               selenium.clickOn(selectGenreBox);
                List<WebElement> filterOption = driver.findElements(By.xpath("//ul[@role='listbox']/p-multiselectitem"));
                selenium.hardWait(1);
                String randomNumber = (javahelpers.getRandomNumber(filterOption.size(), 2));
                driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber +"]//li/div")).click();
                selenium.hardWait(1);
        }

    public void selectContinuumFilter() throws InterruptedException{
        selenium.clickOn(selectContinuumBox);
        List<WebElement> filterOption = driver.findElements(By.xpath("//ul[@role='listbox']/p-multiselectitem"));
        selenium.hardWait(1);
        String randomNumber = (javahelpers.getRandomNumber(filterOption.size(), 1));
        driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber + "]/li/div")).click();
        selenium.hardWait(1);
    }
    public void selectEditorialContentType()throws InterruptedException{
            selenium.clickOn(selectContentTypeBox);
            selenium.hardWait(1);
            driver.findElement(By.xpath("//span[text()='Editorials & Research Case Studies']")).click();
    }
    public void clickOnAddFile()throws InterruptedException{
            selenium.clickOn(addFileButton);
    }
    public void contentID(String id){
            WebElement idBox = driver.findElement(By.xpath("//input[@placeholder='Enter Content ID']"));
              idBox.sendKeys(id);
    }
    public void uploadContentFile(String path)throws InterruptedException{
       WebElement file = driver.findElement(By.xpath("//label[text()=' Upload Content File ']//following-sibling::div/input"));

             file.sendKeys(path);
             selenium.hardWait(1);
        }
        public void readTime()throws InterruptedException{
            selenium.clickOn(timeFieldBox);
            driver.findElement(By.xpath("//div[contains(@class,'p-timepicker ng-tns')]//following-sibling::div[2]//button/span[1]")).click();

        }
        public void contentTitle(String title)throws InterruptedException{
            contentTitleBox.sendKeys(title);
        }
         public void contentDescription(String description){
            contentDescription.sendKeys(description);
       }
       public void selectSpeciality()throws InterruptedException{
            selenium.clickOn(specialityTextBox);
               List<WebElement> filterOption = driver.findElements(By.xpath("//ul[@role='listbox']/p-multiselectitem"));
               String randomNumber = (javahelpers.getRandomNumber(filterOption.size(), 1));
               selenium.hardWait(1);
               driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber + "]/li/div")).click();
               selenium.hardWait(1);
           }
           public void selectTopic()throws InterruptedException{
            selenium.clickOn(topicTextBox);
            driver.findElement(By.xpath("//div[contains(@class, 'p-multiselect-header')]/div")).click();
       }
       public void therapyBasedTag(String tag){
            therapyBasedTabBox.sendKeys(tag);
       }
       public void descriptionBasedTag(String dTag){
            descriptionBasedTagBox.sendKeys(dTag);
       }
       public void wordCountOfText(String wordCount){
            wordCountBox.sendKeys(wordCount);
       }
       public void selectDate()throws InterruptedException{
            driver.findElement(By.xpath("//p-calendar[@formcontrolname='date']//button")).click();
            selenium.hardWait(2);
            driver.findElement(By.xpath("//td[contains(@class,'p-datepicker-today ng-star-inserted')]")).click();
       }
       public void permission(){
            driver.findElement(By.xpath("//p-checkbox[@value='isDownload']")).click();
       }

       public void schedulePublish()throws InterruptedException{
        selenium.clickOn(scheduleStartDateBox);
        selenium.clickOn(currentDate);
        selenium.clickOn(expireDateBox);
        selenium.clickOn(endDate);
        }
        public void saveContent(){
            driver.findElement(By.xpath("//span[text()='Save/Publish']")).click();
        }
        public void selectExpertOpinionOption()throws InterruptedException{
            selenium.clickOn(selectContentTypeBox);
            selenium.hardWait(1);
            driver.findElement(By.xpath("//span[text()='Expert Opinions']")).click();

        }
         public void selectInfographicsOption()throws InterruptedException{
            selenium.clickOn(selectContentTypeBox);
            selenium.hardWait(1);
            driver.findElement(By.xpath("//span[text()='Infographics']")).click();

    }
    public void selectMedicalSlideLibraryOption()throws InterruptedException{
        selenium.clickOn(selectContentTypeBox);
        selenium.hardWait(1);
        driver.findElement(By.xpath("//span[text()='Medical Slide Library']")).click();

    }

    public void selectPodcasts()throws InterruptedException{
        selenium.clickOn(selectContentTypeBox);
        selenium.hardWait(1);
        driver.findElement(By.xpath("//span[text()='Podcasts']")).click();

    }
    public void transcriptInPodcast(){
            driver.findElement(By.xpath("//textarea[@formcontrolname='transcript']")).sendKeys("podcast----");
    }

    public void selectWebinarsAndPanelDiscussions()throws InterruptedException {
        selenium.clickOn(selectContentTypeBox);
        selenium.hardWait(1);
        driver.findElement(By.xpath("//span[text()='Webinars & Panel Discussions']")).click();
    }
    public void externalLink(String link){
        driver.findElement(By.xpath("//input[@formcontrolname='externalLinkout']")).sendKeys(link);
    }
    public String successMassage(){
      String text= driver.findElement(By.xpath("//div[text()='Content file uploaded successfully.']")).getText();
   return text;
    }




}
