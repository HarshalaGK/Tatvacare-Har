package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.PubmedPO;
import utilities.Constants;

public class PubmedTest extends BaseTest {
    //PubmedPO pubmed = new PubmedPO(driver);
    @Test(priority = 0, description = "Login and navigate on Pubmed Tab")
    public void login()throws InterruptedException {
        Login loginData = new LoginData().getLoginData();
        selenium.navigateToPage(Constants.URL);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
        PubmedPO pubmed = new PubmedPO(driver);
        pubmed.navigateOnPubmed();

        Reporter.log("Step 2: Search Any Word and Selected As Suggested list ");
        pubmed.SearchBarInPubmed("health");
        pubmed.selectRandomSuggestion();
       // pubmed.randomArticle();

        Reporter.log("Step 3:  Send Article List in Mail");
        pubmed.saveAndEmailButton();
        pubmed.email("abc@gmail.com");
        pubmed.sendEmail();

        Reporter.log("Step 4:  Click On Random Article ");
        pubmed.randomArticle();

        pubmed.BckOnDetailPage();



    }



}
