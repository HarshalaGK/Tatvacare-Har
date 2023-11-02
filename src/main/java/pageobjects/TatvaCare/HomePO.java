package pageobjects.TatvaCare;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.List;
import java.util.stream.Collectors;

public class HomePO extends BasePO {
    public HomePO(WebDriver driver)
    {
        super(driver);
    }
      @FindBy(id="navItemHome")
      private WebElement homeTab;

    @FindBy(xpath = "//div[@class='card-body']//div[@class='col-auto mr-auto']")
    private WebElement subTabList;

    @FindBy(xpath ="//div[@class='card custom-card ng-star-inserted']")
    private WebElement nunOfTab;

    @FindBy(xpath = "//a[@href='#/events']")
    private WebElement eventViewAllButton;

    @FindBy(xpath = "//span[text()='Events']")
    private WebElement eventPageTitle;

    @FindBy(xpath = "//a[@class='text-decoration-none header-back-link ng-star-inserted']")
    private WebElement backButtonOfEventPage;

    @FindBy(xpath = "//div[@class='col-auto ng-star-inserted']/a")
    private WebElement myListViewAllButton;

    @FindBy(xpath = "//div[@class='appointment-header']/div/div[2]/a")
    private WebElement calenderViewAllButton;

    @FindBy(xpath = "//span[@class='ml-2 mr-4 heading']")
    private WebElement calenderTitle;

    @FindBy(xpath = "//img[@alt='Back']")
    private WebElement myListBackButton;

    @FindBy(xpath = "//span[text()='My List']")
    private WebElement myListPageTitleText;

    @FindBy(xpath = "//button[@title='Tatvacare Walkthrough']")
    private WebElement walkThrough;

    @FindBy(xpath = "//button[text()='Next']")
    private WebElement walkThroughNextButton;

    @FindBy(xpath = "//button[text()='Finish']")
    private WebElement walkThroughFinishButton;

    @FindBy(xpath = "//span[text()=' Skip ']")
    private WebElement walkThroughSkipButton;

    @FindBy(xpath = "//button[@title='Search Content']")
    private WebElement searchContentINHomePage;

      public void loginAndClickOnHomeTab() throws InterruptedException {
          selenium.hardWait(10);
          selenium.getWindowHandles();
          selenium.switchToWindow(1);
          selenium.hardWait(3);
          selenium.click(homeTab);
          selenium.hardWait(10);

      }
    public void numberOFSubTab() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card custom-card ng-star-inserted']"));
        // Get the number of elements found
        int numOfSubTab = elements.size();
        Assert.assertEquals(numOfSubTab, 7);
    }

    public List<String> getDashboardTabNameList() {
        List<WebElement>subTabList = driver.findElements(By.xpath("//h3[contains(@class,'heading mb')]"));
        System.out.println("Sub list is: "+subTabList.size());
        return subTabList.stream().map(x -> x.getText().trim()).collect(Collectors.toList());
    }


    public String navigateOnCalenderThroughDashBoard() throws InterruptedException {
        selenium.click(calenderViewAllButton);
        selenium.hardWait(2);
        String calenderHeader = calenderTitle.getText();
        selenium.click(homeTab);
        return calenderHeader;

    }

    public String navigateOnEventPage() throws InterruptedException {
        selenium.click(eventViewAllButton);
        String eventsPageTitle = eventPageTitle.getText();
        selenium.hardWait(2);
        selenium.click(backButtonOfEventPage);
        return eventsPageTitle;
    }

    public String navigateOnMyListPage() throws InterruptedException {
        selenium.click(myListViewAllButton);
        String myListPageTitle = myListPageTitleText.getText();
        selenium.click(myListBackButton);
        return myListPageTitle;
    }
    public void tatvacareWalkThrough()throws InterruptedException {
        selenium.clickOn(walkThrough);
        selenium.hardWait(1);
        selenium.clickOn(walkThroughNextButton);
        selenium.hardWait(2);
        selenium.clickOn(walkThroughNextButton);
        selenium.hardWait(1);
        selenium.clickOn(walkThroughNextButton);
        selenium.clickOn(walkThroughFinishButton);
        selenium.hardWait(2);
    }
    public void skipStepsWalkThrough()throws InterruptedException {
        selenium.clickOn(walkThrough);
        selenium.clickOn(walkThroughNextButton);
        selenium.clickOn(walkThroughSkipButton);
        driver.findElement(By.xpath("//span[text()=' Yes ']")).click();
    }
    public void searchWordInHomePage(String text) throws InterruptedException{
            selenium.javascriptClickOn(searchContentINHomePage);
            selenium.hardWait(3);
            WebElement searchBar = driver.findElement(By.xpath("//input[@role='searchbox']"));
            selenium.enterText(searchBar, text, true);
            selenium.hardWait(2);
    }
    @Step("Select Any Suggestion and  navigate search result page")
    public void selectRandomSuggestion() throws InterruptedException {
        selenium.hardWait(3);
        List<WebElement> suggestionOptionList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(suggestionOptionList.size(), 1);
        System.out.println("Random Number is: " + randomNumber);
        driver.findElement(By.xpath("//ul[@role='listbox']/li[" + randomNumber + "]//div")).click();
        selenium.hardWait(2);
    }
    public void clickOnBackButton(){
          driver.findElement(By.xpath("//span[text()='Back']")).click();
    }

}
