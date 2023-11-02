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

    @FindBy(xpath = "//div[@class='col-auto']//span[text()='Article Request List']")
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

    @FindBy(xpath = "//div[contains(@class,'mat-select-arrow-wrapper ng-tns')]")
    private WebElement statusDropDown;

    @FindBy(xpath = "//*[text()=' Add to favourite ']")
    private WebElement addToFavouriteButton;

    @FindBy(xpath = "//button[@matbadgecolor='warn']")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//a[text()='Clear All']")
    private WebElement clearAllButton;

    @FindBy(xpath = "//a[text()='Additonal filters']")
    private WebElement additionalFilterButton;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement customDateSubmitButton;

    @FindBy(xpath = "//button[contains(text(),'Apply Filters')]")
    private WebElement applyFilterButtonForAdditionFilter;


    public void navigateOnTcOrWindowHandle() throws InterruptedException {
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
        selenium.hardWait(2);
    }

    public void navigateOnPubmed() throws InterruptedException {
        selenium.click(pubmedButton);
    }

    @Step("Search any word in searchBar ")
    public void searchBarInPubmed(String text) throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//input[@role='searchbox']"));
        selenium.enterText(searchBar, text, true);
        selenium.hardWait(1);
        //  driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys(text);
        return;
    }

    @Step("Select Any Suggestion and  navigate search result page")
    public void selectRandomSuggestion() throws InterruptedException {
        selenium.hardWait(3);
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

    public void bckOnDetailPage() throws InterruptedException {
        // selenium.pageScrollInView(backButton);
        selenium.hardWait(3);
        selenium.clickOn(backButton);

    }

    @Step("Click On Unselect Button ")
    public List<String> requestArticleAndValidateButtonText() throws InterruptedException {
        List<String> checkList = new ArrayList<>();
        String buttonText = selenium.getText(requestArticleButton);
        checkList.add(buttonText);
        selenium.hardWait(2);
        selenium.click(requestArticleButton);
        selenium.hardWait(2);
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

    public void checkAllRequestInPage() throws InterruptedException {
        selenium.hardWait(3);
        selenium.clickOn(statusDropDown);
        driver.findElement(By.xpath("//mat-option//span[text()='In Process']")).click();
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

    public void applyFilter() throws InterruptedException {
        selenium.click(applyFilterButton);
    }

    public void clearAll() throws InterruptedException {
        selenium.click(clearAllButton);
    }

    @Step("Select Any Filter In Text Availability")
    public void selectFilterInTextAvailability() throws InterruptedException {
        List<WebElement> filterList = driver.findElements(By.xpath("//div[@id='contentGenreFilter']//app-checkbox//span"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(filterList.size(), 2);
        System.out.println("Random Number is: " + randomNumber);
        selenium.hardWait(2);
        driver.findElement(By.xpath("//div[@id='contentGenreFilter']//div[" + randomNumber + "]//span")).click();
        selenium.hardWait(2);

    }

    @Step("Select Any One Filter In Article Type")
    public void selectFilterInArticleType() throws InterruptedException {
        List<WebElement> articleFilterList = driver.findElements(By.xpath("//div[@id='contentCategoryFilter']//app-checkbox//label"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(articleFilterList.size(), 2);
        selenium.hardWait(5);
        // System.out.println("Random Number is: " + randomNumber);
        driver.findElement(By.xpath("//div[@id='contentCategoryFilter']//div[" + randomNumber + "]//span")).click();
        selenium.hardWait(2);
    }

    @Step("Select Any one  Publish date Range ANd If Select CustomRange So Enter Select Custom Date")
    public void selectFilterInPublicationDate() throws InterruptedException {
        List<WebElement> publishYearList = driver.findElements(By.xpath("//div[contains(@class,'radio')]/div"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(publishYearList.size(), 1);
        System.out.println("Random Number1 is: " + randomNumber);
        selenium.hardWait(2);
        selenium.pageScrollInView(By.xpath("//div[contains(@class,'radio')]/div[" + randomNumber + "]//input"));

        String filterText = driver.findElement(By.xpath("//div[contains(@class,'radio')]/div[" + randomNumber + "]//label")).getText();
        //if select custom range than select any date

        selenium.javascriptClickOn(driver.findElement(By.xpath("//div[contains(@class,'radio')]/div[" + randomNumber + "]//input")));
        if (filterText.equalsIgnoreCase(" Custom Range")) {
            driver.findElement(By.xpath("//form/div[1]/div[1]//mat-datepicker-toggle)")).click();
            selenium.hardWait(3);
            WebElement startDate = driver.findElement(By.xpath("//td[@class='mat-calendar-body-cell mat-focus-indicator mat-calendar-body-active ng-star-inserted']/preceding-sibling::td']"));
            startDate.click();
            driver.findElement(By.xpath("//form/div[1]/div[2]//mat-datepicker-toggle)")).click();
            WebElement endDate = driver.findElement(By.xpath("//td[@class='mat-calendar-body-cell mat-focus-indicator mat-calendar-body-active ng-star-inserted']"));
            endDate.click();
            selenium.click(customDateSubmitButton);
        }
    }

    public void selectCustomRangeFilter() throws InterruptedException {
        driver.findElement(By.xpath("//label[text()=' Custom Range']")).click();
        selenium.hardWait(3);
    }

    public void customStartDate(String startDate) {
        driver.findElement(By.xpath("//input[@name='start_date']")).sendKeys(startDate);
    }

    public void customEndDate(String endDate) {
        driver.findElement(By.xpath("//input[@name='end_date']")).sendKeys(endDate);
    }

    public String numberOfFiltersApply() {
        String no = driver.findElement(By.xpath("//button[text()='Apply Filter']//span[@class='mat-badge-content mat-badge-active']")).getText();
        return no;
    }

    @Step("Select Any Filter in Additional Filter And Apply")
    public void additionalFilter() throws InterruptedException {
        selenium.clickOn(additionalFilterButton);
    }

    public void additionalFilterOfArticleType() throws InterruptedException {
        List<WebElement> articleType = driver.findElements(By.xpath("//ul[@class='list-unstyled']//div//span"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(articleType.size(), 1);
        System.out.println("Random Number1 is: " + randomNumber);
        selenium.hardWait(2);

        driver.findElement(By.xpath("//ul[@class='list-unstyled']//div[" + randomNumber + "]//span")).click();
    }

    public void additionalFilterOfSpecies() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Species']")).click();
        selenium.hardWait(3);
        List<WebElement> species = driver.findElements(By.xpath("//ul[@class='list-unstyled']//div//span"));
        int number = JavaHelpers.getRandomNumberInInteger(species.size(), 1);
        selenium.hardWait(1);
        System.out.println("Random Number1 is: " + number);
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//div[" + number + "]//span")).click();
    }

    // Artical type=  //ul[@class='list-unstyled']//div//span
    public void additionalFilterOfLanguage() throws InterruptedException {
        selenium.hardWait(2);
        driver.findElement(By.xpath("//div[text()='Language']")).click();
        List<WebElement> languages = driver.findElements(By.xpath("//ul[@class='list-unstyled']//div//span"));
        int randomNum = JavaHelpers.getRandomNumberInInteger(languages.size(), 1);
        System.out.println("Random Number1 is: " + randomNum);
        selenium.hardWait(2);

        driver.findElement(By.xpath("//ul[@class='list-unstyled']//div[" + randomNum + "]//span")).click();
    }

    public void additionalFilterOfSex() throws InterruptedException {
        selenium.hardWait(2);
        driver.findElement(By.xpath("//div[text()='Sex']")).click();
        selenium.hardWait(3);
        List<WebElement> s = driver.findElements(By.xpath("//ul[@class='list-unstyled']//div"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(s.size(), 1);
        System.out.println("Random Number1 is: " + randomNumber);
        selenium.hardWait(2);
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//div[" + randomNumber + "]//span")).click();
      //   driver.findElement(By.xpath("//input[contains(@id, 'sex')]["+ randomNumber +"]")).click();
    }
    public void additionalFilterOfAge() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Age']")).click();
        selenium.hardWait(2);
        List<WebElement> age = driver.findElements(By.xpath("//ul[@class='list-unstyled']//div//span"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(age.size(), 1);
        System.out.println("Random Number1 is: " + randomNumber);
        selenium.hardWait(2);
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//div[" + randomNumber + "]//span")).click();
    }
    public void additionalFilterOfOther() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Other']")).click();
        selenium.hardWait(3);
        List<WebElement> other = driver.findElements(By.xpath("//ul[@class='list-unstyled']//div//span"));
        int randomNumber = JavaHelpers.getRandomNumberInInteger(other.size(), 1);
        System.out.println("Random Number1 is: " + randomNumber);
        selenium.hardWait(2);
        driver.findElement(By.xpath("//ul[@class='list-unstyled']//div[" + randomNumber + "]//span")).click();
    }
    public void applyAdditionalFilters() throws InterruptedException{
        selenium.clickOn(applyFilterButtonForAdditionFilter);
    }

}