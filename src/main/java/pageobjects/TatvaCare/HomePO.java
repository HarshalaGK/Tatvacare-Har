package pageobjects.TatvaCare;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.base.BasePO;

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

      public void loginAndClickOnHomeTab() throws InterruptedException {
          selenium.hardWait(3);
          selenium.click(homeTab);
          selenium.hardWait(10);
          selenium.getWindowHandles();
          selenium.switchToWindow(1);
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


}
