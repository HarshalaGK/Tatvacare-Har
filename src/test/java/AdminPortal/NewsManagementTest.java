package AdminPortal;

import base.BaseTest;
import datafactory.AdminLoginData;
import dataobjects.AdminLogin;
import functions.Admin_LoginFunction;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.AdminPortal.NewsManagementPO;


public class NewsManagementTest extends BaseTest {
    @Test(priority = 1, description = "Login In Admin Portal And Add FullContent News")
    public void fullScreenNews() throws InterruptedException {
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
        news.titleOFNews("Full screen News 123");
        news.newsDescription("news description");
        news.selectTag();
        news.uploadImage("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//mZWTSqsHwPqLJ4WCez9mSm.jpg");
        news.saveNews();
        selenium.hardWait(7);

        Reporter.log("Step 2: create  Image News With Trending");
        news.addNews();
        selenium.hardWait(10);
        news.selectTherapyArea();
        news.selectTrending();
        news.sendNotification();
        news.selectImageNews();
        news.selectPublishedStatus();
        news.titleOFNews("Image News with trending using Automation");
        news.newsDescription("image news description");
        news.selectTag();
        news.linkedUrlLink("https://indianexpress.com/section/education/");
        news.labelName("news");
        news.uploadImage("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//mZWTSqsHwPqLJ4WCez9mSm.jpg");
        news.setTrendingDate();
        selenium.hardWait(5);
        news.saveNews();
        selenium.hardWait(7);


        Reporter.log("Step 3: create Video News ");
        news.addNews();
        selenium.hardWait(10);
        news.selectTherapyArea();
        news.sendNotification();
        news.selectVideoNews();
        news.selectPublishedStatus();
        news.titleOFNews("Video News with trending using Automation");
        news.newsDescription("Video news description");
        news.linkedUrlLink("https://indianexpress.com/section/education/");
        news.labelName("news");
        news.uploadVideo("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//sample-15s.mp4",
              "C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//mZWTSqsHwPqLJ4WCez9mSm.jpg");
        news.saveNews();
        selenium.hardWait(7);

        Reporter.log("Step 4: create  Scheduled Image News ");
        // news.newsManagementTAb();
        news.addNews();
        selenium.hardWait(10);
        news.selectTherapyArea();
        news.sendNotification();
        news.selectImageNews();
        news.selectScheduledNews();
        news.titleOFNews("Image News scheduled using Automation");
        news.newsDescription(" Scheduled Image news description");
        //news.selectTag();
        news.setScheduleDate();
        news.linkedUrlLink("https://indianexpress.com/section/education/");
        news.labelName("news");
        news.uploadImage("C://Users//Administrator//Desktop//Tatvacare-Har//src//main//resources//Images//mZWTSqsHwPqLJ4WCez9mSm.jpg");
        news.saveNews();
        selenium.hardWait(7);



        Reporter.log("Step 5: Delete Any News ");
        // news.newsManagementTAb();
        news.deleteNews();
        selenium.hardWait(10);

        Reporter.log("Step 6: Edit Any News ");
        news.editNews();
        selenium.hardWait(10);
        news.newsDescription("edit news description");
        selenium.hardWait(5);
        news.saveNews();

}

}
