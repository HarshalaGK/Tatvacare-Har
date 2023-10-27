package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import dataobjects.AdminLogin;
import functions.Admin_LoginFunction;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.AdminPortal.ArticleManagementPO;
import pageobjects.AdminPortal.ContentManagementPO;

public class ArticleManagementTest extends BaseTest {
    @Test(priority = 0, description = "Login and Navigate On Article Management Tab ")
    @Severity(SeverityLevel.CRITICAL) //It's works on testNG version 7.4.0 not in 7.5
    @Description("Test Description: User Manage Article in Article Management Tab")
    public void TC001loginInAdminAndManageUserAccessInArticleManagement() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        Reporter.log("Step 1: Navigate to URl");
        Reporter.log("Step 2: Enter mobileNumber, password and click on the login button");
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
         ArticleManagementPO article = new ArticleManagementPO(driver);
        Reporter.log("Step 3: Select User  Asses Tab in  Article Management And Navigate on Tab");
        article.userAccessTab();
        article.editUserDetailInUserAccess();
        Reporter.log("Step 4: Edit The  User  Asses Tab Detail And Save The Change");
        article.saveChangeButtonInUserAccessTab();
        selenium.hardWait(2);
        Reporter.log("Step 5: Verify The Asses Tab Detail edit Successfully");
        String text= article.successMessageForSaveChange();
        Assert.assertEquals(text,"Profile Saved Successfully");
        selenium.hardWait(3);
        article.userDetailCloseTab();
    }
    @Test
    public void Tc002UploadArticleInArticleManagement() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        ArticleManagementPO article = new ArticleManagementPO(driver);
        Reporter.log("Step 6:  Select Article Upload Tab in  Article Management And Navigate on Tab");
        article.clickOnUploadArticle();
        Reporter.log("Step 7:  Delete The Selected Article In Article Upload Tab");
        article.articleDelete();
        article.articleDeleteAlertNo();
        article.articleDelete();
        article.articleDeleteAlertYes();
        selenium.hardWait(5);
        Reporter.log("Step 8:  Edit The Selected Article In Article Upload Tab");
        article.articleEdit();
        article.uploadArticleEdit();
    }
    @Test
    public void Tc003MasterArticleRequest() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        ArticleManagementPO article = new ArticleManagementPO(driver);
        Reporter.log("Step 9:  Select Article Upload Tab in  Article Management And Navigate on Tab");
        article.masterArticleRequestTab();
        article.articleThreeDotButtonClick();
        selenium.hardWait(5);
        Reporter.log("Step 10: Edit Master Article Request In  Article Management Tab");
        article.editArticleMasterRequest();
        article.editFinalCoast();
        article.clickOnSaveChangeButtonInArticleRequest();
        Reporter.log("Step 11:Verify Edit Successfully Or Not");
        String t = article.successMessageForSaveChange();
        Assert.assertEquals(t, "MasterArticleDetails Saved Successfully");
        selenium.hardWait(3);
        article.masterArticleEditTabClose();
        Reporter.log("Step 12: Upload Article In Master Article Request");
        selenium.hardWait(3);
        article.articleThreeDotButtonClick();
        article.threeDotUploadArticle();
        Reporter.log("Step 13: Upload Article Tab Open And Cancel The Request");
        article.uploadPDFArticleCancel();
        article.articleThreeDotButtonClick();
        Reporter.log("Step 14: Upload Article Tab  PDF  And Save The Request");
        article.threeDotUploadArticle();
        article.uploadPDFArticleSave();

    }
}
