package pageobjects.TatvaCare;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.ArrayList;
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

    @FindBy(css = "a[class='hovers ng-tns-c425-16']")
    private WebElement backButton;

    @FindBy(xpath = "//a[text()='Read article']")
    private WebElement readArticleButton;


    @FindBy(xpath = "//span[text()='Request full article']")
    private WebElement requestArticleButton;

    @FindBy(xpath = "//span[text()='Article requested']")
    private WebElement afterRequestArticleButton;

    @FindBy(xpath = "//textarea[@id='message']")
    private WebElement messageBoxForRequest;

    @FindBy(xpath = "//button[text()='Send Article Request ']")
    private WebElement sendRequest;

    @FindBy(xpath = "//a[text()='View all Request']")
    private WebElement viewAllRequestButton;

    @FindBy(xpath = "//div[@class='mat-select-arrow ng-tns-c83-187']")
    private WebElement statusDropDown;

    @FindBy(xpath = "//*[text()=' Add to favourite ']")
    private WebElement addToFavouriteButton;

    @FindBy(xpath = "//button[@matbadgecolor='warn']")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//a[text()='Clear All']")
    private WebElement clearAllButton;

    @FindBy(xpath = "//a[text()='Additonal filters']")
    private WebElement additionalFilterButton;


    public void navigateOnTcOrWindowHandle() throws InterruptedException {
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
        selenium.hardWait(2);
    }

    public void navigateOnPubmed() throws InterruptedException {
        selenium.click(pubmedButton);
    }

    @Step("Search any word in searchBar ")
    public void SearchBarInPubmed(String text) throws InterruptedException {
        WebElement x = driver.findElement(By.xpath("//input[@role='searchbox']"));
        selenium.enterText(x, text, true);
        selenium.hardWait(2);
        //  driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys(text);
        return;
    }

    @Step("Select Any Suggestion and  navigate search result page")
    public void selectRandomSuggestion() throws InterruptedException {
        selenium.hardWait(5);
        List<WebElement> suggestionOptionList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(suggestionOptionList.size(), 2);
        System.out.println("Random Number is: " + randomNumber);
        driver.findElement(By.xpath("//ul[@role='listbox']/li[" + randomNumber + "]//div")).click();
        selenium.hardWait(2);

    }

    @Step("Click On Any Random Article And Navigate On Detail Page")
    public String selectRandomArticle() throws InterruptedException {
        List<WebElement> articleList = driver.findElements(By.cssSelector("app-article-list > div:nth-child(2) > div > div h2"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(articleList.size(), 1);
        selenium.hardWait(3);
        String articleText = driver.findElement(By.cssSelector("app-article-list > div:nth-child(2) > div > div:nth-child(" + randomNumber + ") h2")).getText();
        driver.findElement(By.cssSelector("app-article-list > div:nth-child(2) > div > div:nth-child(" + randomNumber + ") h2")).click();
        return articleText;
    }

    public void saveAndEmailButton() throws InterruptedException {
        selenium.clickOn(saveButton);  // for some time
        selenium.hardWait(2);
        selenium.clickOn(emailButton);
        selenium.hardWait(2);
    }

    public void email(String text) {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(text);
        return;
    }

    @Step("Click On Send Mail And Send The Mail")
    public void sendEmail() throws InterruptedException {
        selenium.clickOn(sendEmailButton);
    }

    @Step("Read Article ANd Back To Previous Tab")
    public void readArticle() throws InterruptedException {
        selenium.clickOn(readArticleButton);
        selenium.hardWait(2);
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
    }

    public void BckOnDetailPage() throws InterruptedException {
        // selenium.pageScrollInView(backButton);
        selenium.hardWait(3);
        // selenium.clickOn(backButton);
        selenium.javascriptClickOn(backButton);
    }

    @Step("Click On Unselect Button ")
    public List<String> requestArticleAndValidateButtonText() throws InterruptedException {
        List<String> checkList = new ArrayList<>();
        String buttonText = selenium.getText(requestArticleButton);
        checkList.add(buttonText);
        selenium.hardWait(2);
        selenium.click(requestArticleButton);
        selenium.enterText(messageBoxForRequest, "Want to read full Article", true);
        selenium.clickOn(sendRequest);
        selenium.hardWait(2);
        String newButtonText = selenium.getText(afterRequestArticleButton);
        checkList.add(newButtonText);
        selenium.hardWait(2);
        return checkList;
    }

    public void viewAllRequest() throws InterruptedException {
        selenium.click(viewAllRequestButton);
    }

    public void checkAllRequestPage() throws InterruptedException {
        selenium.clickOn(statusDropDown);
        Select select = new Select(statusDropDown);
        select.selectByVisibleText("In Process");
        selenium.hardWait(3);
    }

    public String allRequestViewInProgress() {
        String text;
        text = driver.findElement(By.xpath("//div[@class='pos-scroll ng-star-inserted']//div[1]//div[1]//div[1]")).getText();
        return text;
    }
    public void addFavourite() throws InterruptedException {
        selenium.click(addToFavouriteButton);
    }

    public void shareIconList() {
        List<WebElement> shareIconList = driver.findElements(By.xpath("//ul//li[starts-with(@class,'mr-3')]"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(shareIconList.size() - 1, 1);
        driver.findElement(By.xpath("//ul//li[starts-with(@class,'mr-3')][" + randomNumber + "]")).click();
    }
    public void applyFilter()throws InterruptedException{
        selenium.click(applyFilterButton);
    }

    public void clearAll()throws InterruptedException{
        selenium.click(clearAllButton);
    }

    @Step("Select Any Filter In Text Availability")
    public void selectFilterInTextAvailability() throws InterruptedException {
        List<WebElement> filterList = driver.findElements(By.xpath("//div[@id='contentGenreFilter']//div[@class='mb-1 ng-star-inserted']"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(filterList.size(), 1);
        // System.out.println("Random Number is: " + randomNumber);
        driver.findElement(By.xpath("//div[@id='contentGenreFilter']//div[@class='mb-1 ng-star-inserted']//span[" + randomNumber + "]")).click();
        selenium.hardWait(2);

    }

    @Step("Select Any One Filter In Article Type")
    public void selectFilterInArticleType() throws InterruptedException {
        List<WebElement> articleFilterList = driver.findElements(By.xpath("//div[@id='contentCategoryFilter']//div[@class='mb-1 ng-star-inserted']"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(articleFilterList.size(), 1);
        // System.out.println("Random Number is: " + randomNumber);
        driver.findElement(By.xpath("//div[@id='contentCategoryFilter']//div[@class='mb-1 ng-star-inserted']//span[" + randomNumber + "]")).click();
        selenium.hardWait(2);
    }
    @Step("Select Any one  Publish date Range")
    public void selectFilterInPublicationDate() throws InterruptedException {
        List<WebElement>publishYearList = driver.findElements(By.xpath("//div[@id='contentSpecializationFilter']//div[@class='form-group']"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(publishYearList.size()-1, 1);
        // System.out.println("Random Number is: " + randomNumber);
        driver.findElement(By.xpath("//div[@id='contentSpecializationFilter']//div[@class='form-group']/input[" + randomNumber + "]")).click();
        selenium.hardWait(2);
        // Custom Range is pending
    }
    public void additionalFilter()throws InterruptedException{
        selenium.click(applyFilterButton);
    }


}