package pageobjects.TatvaCare;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.List;

public class TatvaShotPO extends BasePO {
    public TatvaShotPO(WebDriver driver)
    {
    super(driver);
    }
    JavaHelpers java = new JavaHelpers();

   @FindBy(xpath = "//li[@text='Consume Recent Medical Advances in a Flash!']")
    private WebElement tatvaShotsTab;

    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement searchBox;

    @FindBy(xpath = "//a[@ptooltip='Customize My Feed']")
    private  WebElement myFeedEditButton;

    @FindBy(xpath = "//a[@class='text-decoration-none clear-all']")
    private WebElement selectFeedButton;
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElement applyFeedButton;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement cancelFeedButton;

    @FindBy(xpath = "//button[contains(text(),'All News')]")
    private WebElement allNewsButton;

    @FindBy(xpath = "//*[text()='Trending ']")
    private WebElement trendingTabButton;

    @FindBy(xpath = "//button[normalize-space()='Bookmarked']")
    private WebElement bookMarkTabButton;

    @FindBy(xpath = "//div[@class='swiper-slide bg_swiper ng-star-inserted swiper-slide-active']//div[@class='d-flex align-items-center']//a[3]")
    private WebElement bookmarkIconButton;
    public void windowHandle() throws InterruptedException {
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
        selenium.hardWait(2);
    }

    public void navigateOnTatvaShots() throws InterruptedException {
        selenium.click(tatvaShotsTab);
    }
    public void searchInBox(String str)throws InterruptedException{
        selenium.enterText(searchBox,str,true);
        selenium.hardWait(2);
        searchBox.sendKeys(Keys.ENTER);
        return;
    }

        public String getTextOfFirstNewsAfterSearchWord () {
            String text;
            text=driver.findElement(By.xpath("//div[@class='ellipse_2_line']")).getText();
          //  text = driver.findElement(By.xpath("//a[@class='blue_00 ng-star-inserted']")).getText();
            return text;
        }

    @Step("Unselect all Feed and verify the result 'No Result Found'")
        public void myFeedTabEditIcon () throws InterruptedException {
            selenium.click(myFeedEditButton);
        }
        public void UnselectFeed()throws InterruptedException{
        selenium.click(selectFeedButton);
        selenium.click(selectFeedButton);
       // selenium.doubleClickOnElement(selectFeedButton);
        selenium.hardWait(1);
        selenium.click(applyFeedButton);
        }
        public String noRecordFoundResult(){
        String result;
        result= driver.findElement(By.xpath("//span[text()='No Records Found.']")).getText();
        return result;
    }
    public void selectRandomTherapyAreaInMyFeed() throws InterruptedException {
        List<WebElement>ls= driver.findElements(By.xpath("//label[@class='checkbox-container ng-star-inserted']"));
        String randomNumber = (java.getRandomNumber(ls.size(), 3));
        driver.findElement(By.xpath("//label[@class='checkbox-container ng-star-inserted']//span['+ randomNumber +']")).click();
        selenium.hardWait(1);
        selenium.click(applyFeedButton);
    }
    public void tapOnAllNewsTab() throws InterruptedException {
        selenium.click(allNewsButton);
    }
    public void addBookmarkOnNews() throws InterruptedException {
       //String text = driver.findElement(By.xpath("//h3[@class='font_22 ellipse_2_line force-select'][1]")).getText();
        selenium.click(bookmarkIconButton);
    }
   public void likeOnAnyNews(){
        List<WebElement>ls = driver.findElements(By.xpath("//div[@class='d-flex align-items-center']//a[1]"));
        String randomNumber = (java.getRandomNumber(ls.size(), 1));
       driver.findElement(By.xpath("//div[@class='d-flex align-items-center']//a[1]['+ randomNumber +']")).click();
    }
    public void navigateOnTrending() throws InterruptedException {
        selenium.click(trendingTabButton);
    }
    public void navigateOnBookMarkTab()throws InterruptedException{
        selenium.clickOn(bookMarkTabButton);
    }
    public String newsHeadingText(){
        List<WebElement> newsText = driver.findElements(By.xpath("//h3[@class='font_22 ellipse_2_line force-select']"));
        String newsName = newsText.get(1).getText();
        return newsName;
    }

    }
