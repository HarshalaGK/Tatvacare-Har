package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.HomePO;
import pageobjects.TatvaCare.LoginPO;
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
        new LoginFunction(driver,selenium).navigateOnHomeTab();

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card custom-card ng-star-inserted']"));

        // Get the number of elements found
        int numElements = elements.size();
        Assert.assertEquals(numElements,7);

//        List<String> subtabList = homePO.getDashboardTabList();
//        Reporter.log("Step 2: Dashboard Tab List:"+subtabList);
//        Assert.assertTrue(subtabList.contains(""));
//        Assert.assertTrue(subtabList.contains(""));
//        Assert.assertTrue(subtabList.contains(""));

    }


}
