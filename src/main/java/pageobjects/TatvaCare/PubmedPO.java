package pageobjects.TatvaCare;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.List;

public class PubmedPO extends BasePO {
    //JavaHelpers java = new JavaHelpers();
    public PubmedPO(WebDriver driver) {
        super(driver);
    }

    JavaHelpers java = new JavaHelpers();
    @FindBy(xpath = "//a[@class='text-decoration-none header-back-link']")
    private WebElement pubmedButton;

    @FindBy(xpath = "//button[@class='btn border rounded px-2']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[@class='btn border']")
    private WebElement emailButton;

    @FindBy(xpath = "//button[text()='Send Email']")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//a[@class='hovers ng-tns-c425-33']")
    private WebElement backButton;

    @FindBy(xpath = "//a[text()='Read article']")
    private WebElement readArticleButton;

    @FindBy(xpath = "//span[text()='Request full article']")
    private WebElement requestArticleButton;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageBoxForRequest;

//    @FindBy(xpath = "//button[text()='Send Article Request ']")
//    private WebElement

    public void navigateOnPubmed() throws InterruptedException {
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
        selenium.hardWait(2);
        selenium.click(pubmedButton);
    }

    @Step("Search any word in searchBar ")
    public void SearchBarInPubmed(String text) throws InterruptedException {
        driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys(text);
        return;
    }

    @Step("Select Any Suggestion and  navigate search result page")
    public void selectRandomSuggestion() throws InterruptedException {
        selenium.hardWait(5);
        List<WebElement> suggestionOptionList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(suggestionOptionList.size(), 1);
        System.out.println("Random Number is: " + randomNumber);
        //  selenium.pageScrollInView(driver.findElement(By.xpath("//ul[@role='listbox']/li[" + randomNumber + "]//div")));
        //selenium.hardWait(2);
        driver.findElement(By.xpath("//ul[@role='listbox']/li[" + randomNumber + "]//div")).click();
        selenium.hardWait(2);

    }

    @Step("Click On Any Random Article And Navigate On Detail Page")
    public void randomArticle() throws InterruptedException {
        List<WebElement> articleList = driver.findElements(By.cssSelector("app-article-list > div:nth-child(2) > div > div h2"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(articleList.size(), 1);
        selenium.hardWait(3);
        driver.findElement(By.cssSelector("app-article-list > div:nth-child(2) > div > div:nth-child(" + randomNumber + ") h2")).click();

    }


    public void saveAndEmailButton() throws InterruptedException {
//          ChromeOptions options = new ChromeOptions();
//          String downloadPath = "path/to/download/directory";
//          options.addArguments("download.default_directory=" + downloadPath);
        selenium.clickOn(saveButton);
        selenium.hardWait(2);
        selenium.clickOn(emailButton);
        selenium.hardWait(6);
    }

    public void email(String text) {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(text);
        return;
    }

    @Step("Click On Send Mail And Send The Mail")
    public void sendEmail() throws InterruptedException {
        selenium.clickOn(sendEmailButton);
    }

    public void BckOnDetailPage() throws InterruptedException {
        selenium.clickOn(backButton);
    }

    @Step("Read Article ANd Back To Previous Tab")
    public void readArticle() throws InterruptedException {
        selenium.clickOn(readArticleButton);
        selenium.hardWait(3);
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
    }

    @Step("Request For Full Article")
    public void requestArticle() throws InterruptedException {
        selenium.clickOn(requestArticleButton);
        selenium.enterText(messageBoxForRequest, "Want to read full Article", true);
        selenium.clickOn();

    }

}