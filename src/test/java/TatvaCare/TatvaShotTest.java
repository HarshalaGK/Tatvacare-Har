package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.PubmedPO;
import pageobjects.TatvaCare.TatvaShotPO;
import utilities.Constants;

public class TatvaShotTest extends BaseTest {

    @Test(priority = 0, description = "Login and navigate on Pubmed Tab")
    public void navigateOnTatvaShot() throws InterruptedException {
        Login loginData = new LoginData().getLoginData();
        selenium.navigateToPage(Constants.URL);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
        // PubmedPO pubmed = new PubmedPO(driver);
        TatvaShotPO tatvaShot = new TatvaShotPO(driver);

        Reporter.log("Step 1: Navigate On TatvaShots Tab");
        tatvaShot.windowHandle();
        selenium.hardWait(20);
        tatvaShot.navigateOnTatvaShots();
        selenium.hardWait(20);

        Reporter.log("Step 3: search invalid Words In Search Box And Validate Result");
        tatvaShot.searchInBox("1x");
        selenium.hardWait(6);
        String noRecord = tatvaShot.noRecordFoundResult();
        Assert.assertEquals(noRecord,"No Records Found.");
        selenium.hardWait(15);

        Reporter.log("Step 2: search valid Tags In Search Box And Validate Result");
        tatvaShot.searchInBox("#hepatology");
        selenium.hardWait(3);
        String newsText = tatvaShot.getTextOfFirstNewsAfterSearchWord();
        Assert.assertEquals("#hepatology",newsText.trim());


        Reporter.log("Step 3: Unselect All Therapy Area In My Feed And Validate Result");
        tatvaShot.myFeedTabEditIcon();
        tatvaShot.UnselectFeed();
        String result = tatvaShot.noRecordFoundResult();
        Assert.assertEquals(result,"No Records Found.");

        Reporter.log("Step 4: Select Any One Therapy Area In My Feed And Apply Filter");
        tatvaShot.myFeedTabEditIcon();
        tatvaShot.selectRandomTherapyAreaInMyFeed();
        selenium.hardWait(15);

        Reporter.log("Step 5: Select All News and Bookmark In Any News");
        tatvaShot.tapOnAllNewsTab();
        selenium.hardWait(5);
        String text = tatvaShot.newsHeadingText();
        tatvaShot.addBookmarkOnNews();
        selenium.hardWait(5);

        Reporter.log("Step 6 : Click On Any Random In All News Tab ");
        tatvaShot.likeOnAnyNews();
        selenium.hardWait(5);

        Reporter.log("Step 7 : Check User Able to Navigate On Trending tab ");
        tatvaShot.navigateOnTrending();
        selenium.hardWait(5);

        Reporter.log("Step 8 : Verify Newly Bookmarked News Is Present In BookMark Tab ");
        tatvaShot.navigateOnBookMarkTab();
        String bookmarkNewsTest = tatvaShot.newsHeadingText();
        Assert.assertEquals(bookmarkNewsTest , text);













    }
}