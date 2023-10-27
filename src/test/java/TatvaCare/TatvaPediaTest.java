package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.TatvaPediaPO;
import utilities.Constants;

import java.util.List;

public class TatvaPediaTest extends BaseTest {

    @Test(priority = 0, description = "Login and navigate on Tatavpedia Tab")
    public void checkSelectAllButton()throws InterruptedException {
        Login loginData = new LoginData().getLoginData();
        selenium.navigateToPage(Constants.URL);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
        TatvaPediaPO tatvapedia = new TatvaPediaPO(driver);

        Reporter.log("Step 1: Navigate On Tatvapedia Tab");
        tatvapedia.navigateOnTatvapedia();
        tatvapedia.unselectSpeciality();   //unselect any selected speciality

        Reporter.log("Step 2: Search text in searchbar");
        // give any text for search
        tatvapedia.SearchBarFunctionality("mind");

        Reporter.log("Step 2: select any one option in suggestions");
        String searchResultPageTitleText = tatvapedia.searchResultPageTitle();

        Reporter.log("Step 2: Verify The page Title for selected options");
        Assert.assertEquals(searchResultPageTitleText,"Search Results");
        tatvapedia.clickOnRandomFilterOFSearchResultPage();
        tatvapedia.backButton();


        Reporter.log("Step 3: Unselect All Filter in Genre And Verify The Result ");
        List <String> buttonTextList = tatvapedia.unSelectorSelectCheckBoxOfGenre();
        Assert.assertEquals(buttonTextList.get(0).trim(),"Unselect All");
        Assert.assertEquals(buttonTextList.get(1).trim(),"Select All");
        String noRecord=tatvapedia.resultOfUnselectGenreFilter();
        Assert.assertEquals(noRecord,"No Records Found.");

        Reporter.log("Step 4: Select Any Filter In Genre And Verify Result");
        selenium.hardWait(5);
        String filterText = tatvapedia.selectRandomFilterOfGenre();
        tatvapedia.clickOnApplyFilterButton();
        selenium.hardWait(5);
        String actualFilterText = tatvapedia.getSectionHeaderText();
        Assert.assertEquals(actualFilterText,filterText);

        Reporter.log("Step 5: Select Any Content of Applied Filter And Verify The Page Title Of Content");
        String contentTitle = tatvapedia.selectRandomContentOfAppliedFilter();
        String contentPageTitleText = tatvapedia.randomSelectContentPageTitleText();
        Assert.assertEquals(contentPageTitleText, contentTitle);
        tatvapedia.shareButton();
        tatvapedia.backOnContentDetailPage();
        tatvapedia.clearAll();

        Reporter.log("Step 6: Unselect All Filters And Verify The Result");
        tatvapedia.UnselectAllFilterAndVerify();
        selenium.hardWait(10);
        tatvapedia.clickOnApplyFilterButton();
        selenium.hardWait(5);
        String textResult=tatvapedia.resultOfUnselectAllFilters();
        Assert.assertEquals(textResult,"You have not selected any filter. Please Select a filter.");

        tatvapedia.clearAll();

        Reporter.log("Step 7 : Unselect All Continuum And Verify The Result");
        selenium.hardWait(15);
        tatvapedia.unSelectorSelectCheckBoxOfContinuum();
        tatvapedia.clickOnApplyFilterButton();
        String text= tatvapedia.resultOfUnselectContinuumFilter();
        //Assert.assertEquals(textResult,"No Records Found.");

        tatvapedia.clearAll();


        Reporter.log("Step 8: Select Any Content of Applied Filter If Selected Content IS WEbinar So Click On Star Button");
        String contTitle = tatvapedia.selectRandomContentOfAppliedFilter();
        String contPageTitleText = tatvapedia.selectContentType();
        if(contTitle == contPageTitleText){
            tatvapedia.startWebinar();
        }
        selenium.hardWait(10);
        tatvapedia.backOnContentDetailPage();
        selenium.hardWait(10);

        Reporter.log("Step 8: Select Any Content of Applied Filter And Verify The Page Title Of Content");
        String newContTitle = tatvapedia.selectRandomContentOfAppliedFilter();
        String newContPageTitleText = tatvapedia.randomSelectContentPageTitleText();
        Assert.assertEquals(newContPageTitleText, newContTitle);
        tatvapedia.shareButton();
        tatvapedia.shareTheContentInOptionsList();
        selenium.hardWait(10);
        tatvapedia.backOnContentDetailPage();
        selenium.hardWait(10);


        Reporter.log("Step 9: Verify The Shared Contend Available On Social Share Or Not");
        String socialText =tatvapedia.NavigateOnSocialTabAndVerify();
        Assert.assertEquals(socialText,contPageTitleText);
        selenium.hardWait(5);
        tatvapedia.backToHomePage();











    }
}
