package pageobjects.AdminPortal;

import io.qameta.allure.Step;
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
     @FindBy(xpath = "//label[text()=' Upload Content File ']//following-sibling::div/input")
     private WebElement uploadFileBox;
     @FindBy(xpath ="//input[@placeholder='Enter Content ID']")
     private WebElement contentIdTextBox;

    @FindBy(xpath = "//div[contains(text(),'Select Country')]")
    private WebElement selectCountyDropDown;
    @FindBy(xpath = "//div[contains(@class, 'p-multiselect-header ng-tns')]//div[1]")
    private WebElement allSelectCountryCheckBox;

    @FindBy(xpath = "//p-button[@label='Edit']/button")
    private WebElement editButton;


        public void selectContentManagementTab()throws InterruptedException{
          selenium.clickOn(contentManagementTabButton);
           }
           public void clickOnUploadContent()throws InterruptedException{
            selenium.clickOn(createContentButton);
           }
    @Step("Click on Genre type filter and select any random")
   public void selectGenreTypeFilter() throws InterruptedException{
               selenium.clickOn(selectGenreBox);
                List<WebElement> filterOption = driver.findElements(By.xpath("//ul[@role='listbox']/p-multiselectitem"));
                selenium.hardWait(2);
                String randomNumber = (javahelpers.getRandomNumber(filterOption.size(), 2));
                driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber +"]//li/div")).click();
                selenium.hardWait(2);
        }
    @Step("Click on Continuum type filter and select any one randomly")
    public void selectContinuumFilter() throws InterruptedException{
        selenium.clickOn(selectContinuumBox);
        List<WebElement> filterOption = driver.findElements(By.xpath("//ul[@role='listbox']/p-multiselectitem"));
        selenium.hardWait(1);
        String randomNumber = (javahelpers.getRandomNumber(filterOption.size(), 1));
        driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber + "]/li/div")).click();
        selenium.hardWait(1);
    }
    @Step("Click on Content type filter and select Editorial Content Type")
    public void selectEditorialContentType()throws InterruptedException{
            selenium.clickOn(selectContentTypeBox);
            selenium.hardWait(1);
            driver.findElement(By.xpath("//span[text()='Editorials & Research Case Studies']")).click();
    }
    public void clickOnAddFile()throws InterruptedException{
            selenium.clickOn(addFileButton);
    }
//    public void contentID(String id){
//            WebElement idBox = driver.findElement(By.xpath("//input[@placeholder='Enter Content ID']"));
//              idBox.sendKeys(id);
//    }
    public void contentID() {
        selenium.enterText(contentIdTextBox, javahelpers.getContentId(7), true);

    }
//    public void uploadContentFile(String path)throws InterruptedException{
//            WebElement file = driver.findElement(By.xpath("//label[text()=' Upload Content File ']//following-sibling::div/input"));
//            file.sendKeys(path);
//             selenium.hardWait(1);
//        }
    public void editorialsResearchContentUploadPDFFile()throws InterruptedException {
      uploadFileBox.sendKeys("C://Users//hlink//Desktop//NweTatvacare//Tatvacare-Har//src//main//resources//Images//sample pdf.pdf");
      selenium.hardWait(1);
    }
    public void expertOpinionVideoUploadPDFFile()throws InterruptedException {
        uploadFileBox.sendKeys("C://Users//hlink//Desktop//NweTatvacare//Tatvacare-Har//src//main//resources//Images//sample-mp4-file-small.mp4");
        selenium.hardWait(1);
    }

    public void InfographicsContentUploadFile()throws InterruptedException {
            selenium.hardWait(5);
        uploadFileBox.sendKeys("C://Users//hlink//Desktop//NweTatvacare//Tatvacare-Har//src//main//resources//Images//sample pdf.pdf");
        selenium.hardWait(3);
    }

    public void MedicalSlideLibraryPPTxFile()throws InterruptedException {
        uploadFileBox.sendKeys("C://Users//hlink//Desktop//NweTatvacare//Tatvacare-Har//src//main//resources//Images//Dickinson_Sample_Slides.pptx");
        selenium.hardWait(1);
    }

    public void PodcastUploadMP3File()throws InterruptedException {
        uploadFileBox.sendKeys("C://Users//hlink//Desktop//NweTatvacare//Tatvacare-Har//src//main//resources//Images//file_example_MP3_1MG.mp3");
        selenium.hardWait(1);
    }
    public void WebinarsAndPanelDiscussionsUploadMP4File()throws InterruptedException {
        uploadFileBox.sendKeys("C://Users//hlink//Desktop//NweTatvacare//Tatvacare-Har//src//main//resources//Images//sample-15s.mp4");
        selenium.hardWait(1);}

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
            selenium.hardWait(3);
            selenium.javascriptClickOn(specialityTextBox);
            selenium.hardWait(2);
               List<WebElement> filterOption = driver.findElements(By.xpath("//ul[@role='listbox']/p-multiselectitem"));
               String randomNumber = (javahelpers.getRandomNumber(filterOption.size(), 1));
               selenium.hardWait(3);
               driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber + "]//li/div")).click();
               selenium.hardWait(3);
           }
           public void selectTopic()throws InterruptedException{
            selenium.clickOn(topicTextBox);
            driver.findElement(By.xpath("//div[contains(@class, 'p-multiselect-header')]/div")).click();
       }
       public void therapyBasedTag(){
            therapyBasedTabBox.sendKeys("TherapyTag");
       }
       public void descriptionBasedTag(){
            descriptionBasedTagBox.sendKeys("DTag");
       }
       public void wordCountOfText(){
            wordCountBox.sendKeys("122");
       }
       public void selectDate()throws InterruptedException{
            driver.findElement(By.xpath("//p-calendar[@formcontrolname='date']//button")).click();
            selenium.hardWait(4);
            driver.findElement(By.xpath("//td[contains(@class,'p-datepicker-today ng-star-inserted')]")).click();
       }
       public void permission(){
           // driver.findElement(By.xpath("//p-checkbox[@value='isDownload']")).click();
            driver.findElement(By.xpath("//p-checkbox[@inputid='externalSharing']")).click();
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
    public String successMessage(){
      String text= driver.findElement(By.xpath("//p-toastitem//div[text()='Content file uploaded successfully.']")).getText();
   return text;
    }
    public void selectAllCountry() throws InterruptedException {
        selenium.clickOn(selectCountyDropDown);
        selenium.hardWait(2);
        selenium.clickOn(allSelectCountryCheckBox);
        selenium.hardWait(2);
        driver.findElement(By.xpath("//button[contains(@class, 'p-multiselect-close p-link ng-tns')]")).click();
    }
     @Step("select any content for edit")
    public void  editConetent()throws InterruptedException{
            driver.findElement(By.xpath("//tbody[@class='p-datatable-tbody']//td[2]")).click();
            selenium.hardWait(3);
            selenium.clickOn(editButton);
            driver.findElement(By.xpath("//input[@formcontrolname='moleculeBasedTags']")).sendKeys("tag");
     }
     public String successEditMessage(){
        String text=  driver.findElement(By.xpath("//div[text()='Content File uploaded successfully.']")).getText();
        return text;
     }


}
