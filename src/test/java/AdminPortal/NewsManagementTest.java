package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import dataobjects.AdminLogin;
import functions.Admin_LoginFunction;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.AdminPortal.NewsManagementPO;


public class NewsManagementTest extends BaseTest {
    @Test(priority = 1, description = "Login In Admin Portal And Add FullContent News")
    public void TC001createdTypeOfNews() throws InterruptedException {
        AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
        NewsManagementPO news = new NewsManagementPO(driver);
        new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());
        Reporter.log("Step 1: create Full Screen Image News");
        news.newsManagementTAb();
        news.addNews();
        selenium.hardWait(10);
        news.selectTherapyArea();
        news.fullContentNewsCheckBox();
        news.sendNotification();
        news.selectImageNews();
        news.selectPublishedStatus();
        news.selectAllCountry();
        news.titleOFNews("Full screen News 123");
        news.newsDescription();
        news.selectTag();
        selenium.hardWait(5);
        Reporter.log("Step 2: upload image for full screen content");
        news.uploadImage();
        selenium.hardWait(10);
        news.saveNews();
        selenium.hardWait(7);
        Reporter.log("Step 2: Verify The Full Screen Image News created");
        String newsText = news.newsVerify();
        Assert.assertEquals("Full screen News 123", newsText);


        Reporter.log("Step 3: create  Image News With Trending");
        news.addNews();
        selenium.hardWait(10);
        news.selectTherapyArea();
        news.selectTrending();
        news.sendNotification();
        news.selectImageNews();
        news.selectPublishedStatus();
        news.selectAllCountry();
        news.titleOFNews("Image News with trending using AT");
        news.newsDescription();
        news.selectTag();
        news.linkedUrlLink();
        news.labelName("news");
        news.uploadImage();
        news.setTrendingDate();
        selenium.hardWait(5);
        news.saveNews();
        selenium.hardWait(7);

        Reporter.log("Step 4: Verify The create  Image News With Trending created");
        String INewsText = news.newsVerify();
        Assert.assertEquals("Image News with trending using AT", INewsText);


        Reporter.log("Step 5: create Video News With Trending ");
        news.addNews();
        selenium.hardWait(10);
        news.selectTherapyArea();
        news.sendNotification();
        news.selectVideoNews();
        news.selectPublishedStatus();
        news.selectAllCountry();
        news.titleOFNews("Video News with trending using AT");
        news.newsDescription();
        news.linkedUrlLink();
        news.labelName("news");
        news.uploadVideo();
        news.saveNews();
        selenium.hardWait(7);

        Reporter.log("Step 6: Verify The Video News With Trending created");
        String vNewsText = news.newsVerify();
        Assert.assertEquals("Video News with trending using AT", vNewsText);

        Reporter.log("Step 7: Create  Scheduled Image News ");
        // news.newsManagementTAb();
        news.addNews();
        selenium.hardWait(10);
        news.selectTherapyArea();
        news.sendNotification();
        news.selectImageNews();
        news.selectScheduledNews();
        news.selectAllCountry();
        news.titleOFNews("Image News scheduled using AT");
        news.newsDescription();
        //news.selectTag();
        news.setScheduleDate();
        news.linkedUrlLink();
        news.labelName("news");
        news.uploadImage();
        news.saveNews();
        selenium.hardWait(7);

        Reporter.log("Step 8: Verify The Create Scheduled Image News");
        String sheNews = news.newsVerify();
        Assert.assertEquals("Image News scheduled using AT", sheNews);

    }

        @Test(priority = 1, description = "Login In Admin Portal And Add FullContent News")
        public void TC002DeleteNews() throws InterruptedException {
            AdminLogin adminLoginData = new AdminLoginData().getAdminLoginData();
            NewsManagementPO news = new NewsManagementPO(driver);
            new Admin_LoginFunction(driver, selenium).loginByAdmin(adminLoginData.getAdminMobileNumber(), adminLoginData.getAdminPassword());

            news.newsManagementTAb();

            Reporter.log("Step 9: Select Any News In News Management For Deleted And Verify ");
            news.deleteNews();
            String successMassage = news.deleteSuccessMessage();
            Assert.assertEquals(successMassage,"News deleted successfully");
            selenium.hardWait(5);

            Reporter.log("Step 10: Select Any News In News Management For Edit And Verify ");
            news.editNews();
            news.saveNews();
            String successText = news.editSuccessMessage();
            Assert.assertEquals(successText,"News uploaded successfully");
            selenium.hardWait(5);
}

}
