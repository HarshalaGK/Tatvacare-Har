package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.HomePO;
import utilities.Constants;

import java.util.List;

public class HomeTest extends BaseTest{

//    public HomeTest(){
//        LoginData loginData = new LoginData();
//        Login login =new Login();
//        LoginPO loginPO = new LoginPO(driver);
//        LoginFunction loginFunction =  new LoginFunction(driver, selenium);
//    }

    @Test(priority = 0, description = "Login and click on HomeTab")
    public void LoginAndClickOnHomeTab()throws InterruptedException{
        Login loginData = new LoginData().getLoginData();
        HomePO homePO =new HomePO(driver);
        selenium.navigateToPage(Constants.URL);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
        Reporter.log("Step 1: Click On HomeTab");
        homePO.loginAndClickOnHomeTab();
        //new LoginFunction(driver,selenium).navigateOnHomeTab();


        List<String> subtabList = homePO.getDashboardTabNameList();
        Reporter.log("Step 2: Dashboard Tab List:"+subtabList);
        Assert.assertTrue(subtabList.contains("Events"));
        Assert.assertTrue(subtabList.contains("My List"));
        Assert.assertTrue(subtabList.contains("Survey"));

        Reporter.log("Step 3: Validate user navigate on calender tab after clicking on calender view all button");
        String calenderHeader = homePO.navigateOnCalenderThroughDashBoard();
        Assert.assertEquals(calenderHeader,"Calendar");

        Reporter.log("Step 4: validate user navigate on event tab");
        String eventsPageTitle= homePO.navigateOnEventPage();
        Assert.assertEquals(eventsPageTitle,"Events");

        String myListPageTitle= homePO.navigateOnMyListPage();
        Assert.assertEquals(myListPageTitle,"My List");
    }

}
