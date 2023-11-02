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

    @Test(priority = 0, description = "Login In Admin Portal and create Editorial Research Content")
    public void TC001editorialsResearchContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 1: Select Content Management Create Editorial Research Content");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectEditorialContentType();
        content.clickOnAddFile();
        content.contentID();
        content.selectAllCountry();
        content.editorialsResearchContentUploadPDFFile();
        content.contentTitle("Education Research");
        content.contentDescription("Detail of education research");
        selenium.hardWait(3);
        content.readTime();
        selenium.hardWait(2);
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag();
        content.descriptionBasedTag();
        content.wordCountOfText();
        selenium.hardWait(1);
        content.selectDate();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        selenium.hardWait(10);
        Reporter.log("Step 2: Verify the Editorial Research Content Is Created");
        String message = content.successMessage();
        selenium.hardWait(2);
        Assert.assertEquals(message, "Content file uploaded successfully.");
        selenium.hardWait(5);
    }

    @Test(priority = 1, description = "Login In Admin Portal And Create Expert Opinion Content ")
    public void TC002expertOpinion() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 3: Select Expert Opinions Content In Content Type And Create");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectExpertOpinionOption();
        content.clickOnAddFile();
        content.contentID();
        content.selectAllCountry();
        content.expertOpinionVideoUploadPDFFile();
        content.contentTitle("Expert Opinions content");
        content.contentDescription("Detail of Expert Opinions");
        content.selectSpeciality();
        content.selectTopic();
        content.readTime();
        content.therapyBasedTag();
        content.descriptionBasedTag();
        selenium.hardWait(1);
        content.selectDate();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        Reporter.log("Step 4: Verify the  Expert Opinions Content Is Created ");
        selenium.hardWait(10);
        String message = content.successMessage();
        selenium.hardWait(2);
        Assert.assertEquals(message, "Content file uploaded successfully.");
    }


    @Test(priority = 2, description = "Login In Admin Portal And Create Infographic Content ")
    public void TC003InfographicsContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 5: Select Infographics Content In Content Type And Create");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectInfographicsOption();
        content.clickOnAddFile();
        content.contentID();
        content.selectAllCountry();
        content.InfographicsContentUploadFile();
        content.contentTitle("Infographics content");
        content.contentDescription("Detail of Infographics");
        content.readTime();
        selenium.hardWait(2);
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag();
        content.descriptionBasedTag();
        selenium.hardWait(1);
        content.selectDate();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        Reporter.log("Step 6: Verify Infographics Content Created");
        selenium.hardWait(3);
    }

    @Test(priority = 3, description = "Login In Admin Portal And Create Medical Slide Library Content ")
    public void TC004MedicalSlideLibraryContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 7: Select Medical Slide Library Content In Content Type And Create");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectMedicalSlideLibraryOption();
        content.clickOnAddFile();
        content.contentID();
        content.selectAllCountry();
        content.MedicalSlideLibraryPPTxFile();
        content.contentTitle("Title - Medical Slide Library ");
        content.contentDescription("Detail of Medical Slide Library");
        selenium.hardWait(2);
        content.selectSpeciality();
        content.selectTopic();
        content.therapyBasedTag();
        content.descriptionBasedTag();
        selenium.hardWait(1);
        content.selectDate();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        Reporter.log("Step 8: Verify The Medical Slide Library Content Is Created");
        selenium.hardWait(3);
    }


    @Test(priority = 4, description = "Login In Admin Portal And Create Podcast Content ")
    public void TC005PodcastsContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 9: Select Podcasts Content In Content Type And Created");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectPodcasts();
        content.clickOnAddFile();
        content.contentID();
        content.selectAllCountry();
        content.PodcastUploadMP3File();
        content.contentTitle("Title - PodcastsTag");
        content.contentDescription("Detail of PodcastsTag");
        content.selectSpeciality();
        content.selectTopic();
        content.readTime();
        content.therapyBasedTag();
        content.descriptionBasedTag();
        selenium.hardWait(1);
        content.selectDate();
        content.transcriptInPodcast();
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        Reporter.log("Step 10: Verify The  Podcasts Content Is Created");
        selenium.hardWait(3);
    }

    @Test(priority = 5, description = "Login In Admin Portal And Create Webinars Content ")
    public void TC006WebinarsAndPanelDiscussions() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 11: Select Webinars & Panel Discussions Content In Content type And Created");
        content.selectContentManagementTab();
        content.clickOnUploadContent();
        content.selectGenreTypeFilter();
        content.selectContinuumFilter();
        content.selectPodcasts();
        content.clickOnAddFile();
        content.contentID();
        content.selectAllCountry();
        content.WebinarsAndPanelDiscussionsUploadMP4File();
        content.contentTitle("Title - Webinars & Panel Discussions");
        content.contentDescription("Detail Webinars & Panel Discussions");
        selenium.hardWait(2);
        content.selectSpeciality();
        content.selectTopic();
        content.readTime();
        content.therapyBasedTag();
        content.descriptionBasedTag();
        selenium.hardWait(2);
        content.selectDate();
        selenium.hardWait(3);
        content.externalLink("www.google.com");
        content.permission();
        content.schedulePublish();
        selenium.hardWait(2);
        content.saveContent();
        Reporter.log("Step 12: Verify Webinars & Panel Discussions Content Is Created");
        selenium.hardWait(3);
    }

    @Test(priority = 6, description = "Login In Admin Portal and Navigate on Contain management ")
    public void TC007editContent() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        ContentManagementPO content = new ContentManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 7: Select Any Content In Content Management");
        content.selectContentManagementTab();
        content.editConetent();
        content.saveContent();
        selenium.hardWait(3);
        Reporter.log("Step 7: Verify The Contend Updated Successfully");
        String text = content.successEditMessage();
        Assert.assertEquals(text,"Content File uploaded successfully.");


    }
}
