package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import dataobjects.AdminLogin;
import functions.Admin_LoginFunction;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.AdminPortal.ContentManagementPO;


public class ContentManagementTest extends BaseTest {

    @Test(priority = 0, description = "Login In Admin Portal And Click On Content Management Tab")
    public void editorialsResearchContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 1: Create Editorial Research Content");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectEditorialContentType();
        content.clickOnAddFile();
        content.contentID("2312143");
        content.uploadContentFile("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//sample pdf.pdf");
        content.contentTitle("Education Research");
        content.contentDescription("Detail of education research");
        content.readTime();
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag(" acb");
        content.descriptionBasedTag("bbb");
        content.wordCountOfText("122");
        selenium.hardWait(1);
        content.selectDate();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        selenium.hardWait(3);
        String massage = content.successMassage();
        selenium.hardWait(2);
        Assert.assertEquals(massage,"Content file uploaded successfully.");
    }

    public void expertOpinion() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 2: Create Expert Opinions Content");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectExpertOpinionOption();
        content.clickOnAddFile();
        content.contentID("2312143");
        content.uploadContentFile("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//sample-mp4-file-small.mp4");
        content.contentTitle("Expert Opinions content");
        content.contentDescription("Detail of Expert Opinions");
        content.readTime();
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag("expertTag");
        content.descriptionBasedTag("opinionTag");
        selenium.hardWait(1);
        content.selectDate();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        selenium.hardWait(3);
    }
    public void InfographicsContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 3: Create Infographics Content");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectInfographicsOption();
        content.clickOnAddFile();
        content.contentID("2312143");
        content.uploadContentFile("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//sample pdf.pdf");
        content.contentTitle("Infographics content");
        content.contentDescription("Detail of Infographics");
        content.readTime();
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag("InfographicsTag");
        content.descriptionBasedTag("opinionTag");
        selenium.hardWait(1);
        content.selectDate();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        selenium.hardWait(3);
    }
    public void MedicalSlideLibraryContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 4: Create Medical Slide Library Content");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectMedicalSlideLibraryOption();
        content.clickOnAddFile();
        content.contentID("2312143");
        content.uploadContentFile("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//Dickinson_Sample_Slides.pptx");
        content.contentTitle("Title - Medical Slide Library ");
        content.contentDescription("Detail of Medical Slide Library");
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag("MedicalTag");
        content.descriptionBasedTag("LibraryTag");
        selenium.hardWait(1);
        content.selectDate();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        selenium.hardWait(3);
    }

    public void PodcastsContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 5: Create Podcasts Content");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectPodcasts();
        content.clickOnAddFile();
        content.contentID("2312143");
        content.uploadContentFile("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//file_example_MP3_1MG.mp3");
        content.contentTitle("Title - PodcastsTag");
        content.contentDescription("Detail of PodcastsTag");
        content.readTime();
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag("PodcastsTag");
        content.descriptionBasedTag("PodcastsDescriptionTag");
        selenium.hardWait(1);
        content.selectDate();
        content.transcriptInPodcast();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        selenium.hardWait(3);
    }
    public void WebinarsAndPanelDiscussions() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 5: Create Webinars & Panel Discussions Content");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectPodcasts();
        content.clickOnAddFile();
        content.contentID("23121893");
        content.uploadContentFile("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//sample-15s.mp4");
        content.contentTitle("Title - Webinars & Panel Discussions");
        content.contentDescription("Detail Webinars & Panel Discussions");
        content.readTime();
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag(" WPDTag");
        content.descriptionBasedTag("Webinar Tag");
        selenium.hardWait(1);
        content.selectDate();
        content.externalLink("www.google.com");
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        selenium.hardWait(3);

    }
}

