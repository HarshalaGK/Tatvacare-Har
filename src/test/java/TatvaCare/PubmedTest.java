package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.PubmedPO;
import utilities.Constants;

import java.util.List;

public class PubmedTest extends BaseTest {

    @Test(priority = 0, description = "Login and navigate on Pubmed Tab")
    public void login()throws InterruptedException {
        Login loginData = new LoginData().getLoginData();
        selenium.navigateToPage(Constants.URL);
        selenium.hardWait(5);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
        PubmedPO pubmed = new PubmedPO(driver);
        pubmed.navigateOnTcOrWindowHandle();
        pubmed.navigateOnPubmed();

        Reporter.log("Step 2: Search Any Word and Selected As Suggested list ");
        pubmed.searchBarInPubmed("mind");
        pubmed.selectRandomSuggestion();

        Reporter.log("Step 3:  Send Article List in Mail");
        pubmed.saveAndEmailButton();  // for some time
        pubmed.email("harshalahyperlink@gmail.com");
        pubmed.sendEmail();

        Reporter.log("Step 4:  Click On Random Article ");
        String articleName = pubmed.selectRandomArticle();
        pubmed.readArticle();

        Reporter.log("Step 5: Request To Full Article And Check Article ");
        List<String> buttonTextList = pubmed.requestArticleAndValidateButtonText();
        Assert.assertEquals(buttonTextList.get(0).trim(),"Request full article");
        Assert.assertEquals(buttonTextList.get(1).trim(),"Article requested");
        //pubmed.BckOnDetailPage();

        Reporter.log("Step 6: View All Request And Verify The Requested And List Article Is Same ");
        pubmed.viewAllRequest();
        pubmed.checkAllRequestInPage();
        selenium.hardWait(2);
        String text= pubmed.allRequestViewInProgress();
        Assert.assertEquals(articleName,text);
        pubmed.bckOnDetailPage();

        Reporter.log("Step 7: Selected Content Add  In Favourite List And Share The Content");
        pubmed.addFavourite();
        pubmed.shareIconList();
        pubmed.navigateOnTcOrWindowHandle();

        Reporter.log("Step 8: Search Word And Apply Filters");
        pubmed.searchBarInPubmed("hand" );
        pubmed.selectRandomSuggestion();
        selenium.hardWait(4);
        pubmed.selectFilterInTextAvailability();
        pubmed.selectFilterInArticleType();
        selenium.hardWait(4);
        pubmed.selectFilterInPublicationDate();
        selenium.hardWait(6);
        pubmed.applyFilter();
        selenium.hardWait(3);
        String number = pubmed.numberOfFiltersApply();
        Assert.assertEquals("3", number);
        pubmed.clearAll();

//        Reporter.log("Step 9: Search Word And Apply CustomDate Filters");
//        pubmed.searchBarInPubmed("nose");
//        pubmed.selectRandomSuggestion();
//        pubmed.selectCustomRangeFilter();
//        pubmed.customStartDate("08/10/2023");
//        pubmed.customEndDate("15/10/2023");
//        pubmed.customDateSubmitButton();

         Reporter.log("Step 9: Apply Additional Filter And Verify the Count Of Filters");
         pubmed.additionalFilter();
         pubmed.additionalFilterOfArticleType();
         pubmed.additionalFilterOfSpecies();
         pubmed.additionalFilterOfLanguage();
         pubmed.additionalFilterOfSex();
         pubmed.additionalFilterOfAge();
         pubmed.additionalFilterOfOther();
         pubmed.applyAdditionalFilters();
         selenium.hardWait(5);
        String num = pubmed.numberOfFiltersApply();
        Assert.assertEquals("6", num);


    }



}
