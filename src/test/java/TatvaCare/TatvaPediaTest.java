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

    @Test(priority = 0, description = "Login and navigate on Tatavpedoa Tab")
    public void checkSelectAllButton()throws InterruptedException {
        Login loginData = new LoginData().getLoginData();
        selenium.navigateToPage(Constants.URL);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
        TatvaPediaPO tatvapedia = new TatvaPediaPO(driver);
        Reporter.log("Step 1: Navigate On Tatvapedia Tab");
        tatvapedia.navigateOnTatvapedia();
        Reporter.log("Step 2: Unselect All Filter in Genre");

        List <String> buttonTextList = tatvapedia.unSelectorSelectCheckBoxOfGenre();
        Assert.assertEquals(buttonTextList.get(0).trim(),"Unselect All");
        Assert.assertEquals(buttonTextList.get(1).trim(),"Select All");

        Reporter.log("Step 3: Unselect All Filter in Genre And Verify The Result");
        String noRecord=tatvapedia.resultOfUnselectGenreFilter();
        Assert.assertEquals(noRecord,"No Records Found.");

        Reporter.log("Step 4: Select Any Filter In Genre And Verify Result");
        String filterText = tatvapedia.selectRandomFilterOfGenre();
        tatvapedia.clickOnApplyFilterButton();
        String actualFilterText = tatvapedia.getSectionHeaderText();
        Assert.assertEquals(actualFilterText,filterText);

        Reporter.log("Step 5: Select Any Content of Applied Filter And Verify The Page Title Of Content");
        String contentTitle = tatvapedia.selectRandomContentOfAppliedFilter();
        String contentPageTitleText = tatvapedia.randomSelectContentPageTitleText();
        Assert.assertEquals(contentPageTitleText, contentTitle);



//
//        Reporter.log("Step 3: Unselect All Filter in Genre And Verify The Result");
//        String noRecord=tatvapedia.resultOfUnselectGenreFilter();
//        Assert.assertEquals(noRecord,"No Records Found.");
//        Reporter.log("Step 4: select any filter option in Genre and Verify the result");
//
//       // tatvapedia.unSelectCheckBoxOfContinuum("Continuum");


    }
}
