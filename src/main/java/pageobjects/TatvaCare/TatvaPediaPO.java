package pageobjects.TatvaCare;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.ArrayList;
import java.util.List;

public class TatvaPediaPO extends BasePO {

    JavaHelpers java = new JavaHelpers();


    public TatvaPediaPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='text-decoration-none clear-all']")
    private WebElement genreSelectFilterButton;

    @FindBy(xpath = "//div[@id='contentcontinuumFilter']/div/div/a")
    private WebElement continuumSelectFilterButton;

    @FindBy(xpath = "//div[@id='contentGenreFilter']//label[@class='checkbox-container ng-star-inserted']")
    private WebElement selectCheckBoxList;

    @FindBy(xpath = "//button[@class='btn btn-primary ml-2 publish-btn']")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//div[text()='No Records Found.']")
    private WebElement noRecordText;

    @FindBy(xpath = "//a[@class='text-decoration-none clear-all clear-all-new mr-2']")
    private WebElement clearAllFilterButton;

    @FindBy(xpath = "//app-content-genre-section//div[@class='section-heading']")
    private WebElement sectionHeaderText;

    @FindBy(xpath = "//span[@class='active-page']")
    private WebElement contentPageTitleText;

    @FindBy(xpath = "//a[@class='text-decoration-none old-page']")
    private WebElement contentType;

    @FindBy(xpath = "//span[text()='Tatwacare Share']")
    private WebElement tatvacareShareIcon;

    @FindBy(xpath = "//span[text()='WhatsApp Share']")
    private WebElement whatsAppShareIcon;
    @FindBy(xpath = "//span[text()='Back']")
    private WebElement backButton;

    @FindBy(xpath = "//div[@class='media align-items-md-center d-md-flex media']/img")
    private WebElement backButtonOnContentDetailPage;

    @FindBy(xpath = "//a[@class='text-decoration-none clear-all clear-all-new mr-2']")
    private WebElement clearAllButton;

    @FindBy(xpath = "//button[@class='btn btn-outline-primary btn-sm px-3 blue-btn']")
    private WebElement shareButton;

    @FindBy(xpath = "//li[@id='navItemSocialConnect' and @title='Social']")
    private WebElement socialTabButton;

    @FindBy(xpath = "//span[text()='Start Webinar']")
    private WebElement startWebinarButton;

    public void navigateOnTatvapedia() {
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
    }

    @Step("Search any word in searchBar and  and navigate search result page")
    public void SearchBarFunctionality(String text) throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("//input[@role='searchbox']"));
        selenium.hardWait(2);
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void clickOnRandomFilterOFSearchResultPage() {
        List<WebElement> filterList = driver.findElements(By.xpath("//ul[@class='ng-star-inserted']//li"));
        String randomNumber = (java.getRandomNumber(filterList.size(), 1));
        String filterText = driver.findElement(By.xpath("//ul[@class='ng-star-inserted']['" + randomNumber + "']//li/a")).getText();
        driver.findElement(By.xpath("//ul[@class='ng-star-inserted']['" + randomNumber + "']//li/a")).click();
        //ul[@class='ng-star-inserted']//li/a
    }

    public String searchResultPageTitle() {
        String searchResultText;
        searchResultText = driver.findElement(By.xpath("//div[@class='section-heading typography-18']")).getText();
        return searchResultText;
    }

    public void backButton() throws InterruptedException {
        selenium.click(backButton);
    }


    @Step("Click On Unselect Button of Genre And Check It Change Into Select All Button")
    public List<String> unSelectorSelectCheckBoxOfGenre() throws InterruptedException {
        List<String> checkList = new ArrayList<>();
        String buttonText = selenium.getText(genreSelectFilterButton);
        checkList.add(buttonText);
        selenium.hardWait(2);
        selenium.click(genreSelectFilterButton);
        selenium.hardWait(2);
        String newButtonText = selenium.getText(genreSelectFilterButton);
        checkList.add(newButtonText);
        selenium.hardWait(2);
        return checkList;
        // return Arrays.asList(buttonText,newButtonText);
        //  Assert.assertNotEquals(buttonText, newButtonText);
    }

    @Step("Unselect filter of Genre And Verify The Result")
    public String resultOfUnselectGenreFilter() throws InterruptedException {
        selenium.click(applyFilterButton);
        String noRecord;
        return noRecord = selenium.getText(noRecordText);
    }

    @Step("Speciality")
    public void unselectSpeciality() {
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//*[@id='contentSpecializationFilter']/div[@class='inner-scroll px-3']/div//label/span"));
        for (WebElement checkbox : checkBoxList) {
            if (checkbox.isSelected()) {
                checkbox.click();
                //  System.out.println("Unchecked checkbox with ID: " + checkbox.getAttribute("id"));
            }
        }
    }


    @Step("Select Any filter of Genre ")
    public String selectRandomFilterOfGenre() throws NumberFormatException {
        List<WebElement> filterList = driver.findElements(By.xpath("//*[@id='contentGenreFilter']/div"));

        String randomNumber = (java.getRandomNumber(filterList.size(), 3));
        String filterText = driver.findElement(By.xpath("//*[@id='contentGenreFilter']/div[" + randomNumber + "]//label")).getText();
        driver.findElement(By.xpath("//*[@id='contentGenreFilter']/div[" + randomNumber + "]//span")).click();
        return filterText;
    }

    public void clickOnApplyFilterButton() throws InterruptedException {
        selenium.javascriptClickOn(applyFilterButton);
    }

    public String getSectionHeaderText() {
        return selenium.getText(sectionHeaderText);
    }

    @Step("Select Any Content of selected Genre Filter and Verify The Page Title")
    public String selectRandomContentOfAppliedFilter() throws InterruptedException {
        List<WebElement> contentList = driver.findElements(By.xpath("//div[@class='card-title']"));
        selenium.hardWait(2);
        String randomNumber = (java.getRandomNumber(contentList.size(), 2));
        String contentTitle = driver.findElement(By.xpath("//div[@class='card-body']['" + randomNumber + "']//*[@class='card-title']")).getText();
        selenium.hardWait(2);
        driver.findElement(By.xpath("//div[@class='card-body']['" + randomNumber + "']//*[@class='card-title']")).click();
        return contentTitle;
    }

    public String randomSelectContentPageTitleText() throws InterruptedException {
        return selenium.getText(contentPageTitleText);
    }

    public void shareButton() throws InterruptedException {
        selenium.click(shareButton);
    }

    public void shareTheContentInOptionsList() throws InterruptedException {
        selenium.hardWait(2);
        driver.findElement(By.xpath("//span[@class='p-menuitem-icon share-icon share-icon-tatwacare ng-star-inserted']")).click();
        selenium.hardWait(3);
        driver.findElement(By.xpath("//button[@class='btn btn-primary submit-btn']")).click();
        selenium.hardWait(10);
    }

    public void backOnContentDetailPage() throws InterruptedException {
        selenium.click(backButtonOnContentDetailPage);
    }

    public void clearAll() throws InterruptedException {
        selenium.click(clearAllButton);

    }
//
//    public void uncheckCheckboxForAllFilters(String filterName) {
//        String xpath = "//div[@id='content'" + filterName + "'Filter']//a[@class='text-decoration-none clear-all']";
//        driver.findElement(By.xpath(xpath)).click();}


    public void UnselectAllFilterAndVerify() throws InterruptedException {
        List<WebElement> filtersSelectButtons = driver.findElements(By.xpath("//a[@class='text-decoration-none clear-all']"));
        // Loop through the buttons and toggle their selection

        for (WebElement filterButton : filtersSelectButtons) {

            if (filterButton.isSelected()) {
                // If the button is selected, unselect it
                filterButton.click();
                selenium.hardWait(2);
            } else {
                // If the button is not selected, select it
                filterButton.click();
                selenium.hardWait(2);

            }
        }
    }

    public String resultOfUnselectAllFilters() {
       // selenium.pageScrollInView(driver.findElement(By.xpath("//div[@class='row ng-star-inserted']//div")));
        String textResult;
        textResult = driver.findElement(By.xpath("//div[@class='row ng-star-inserted']//div")).getText();
        return textResult;
    }


    @Step("Click On Unselect Button of Genre And Check It Change Into Select All Button")
    public List<String> unSelectorSelectCheckBoxOfContinuum() throws InterruptedException {
        List<String> contCheckList = new ArrayList<>();
        selenium.hardWait(5);
        String bText = selenium.getText(continuumSelectFilterButton);
        contCheckList.add(bText);
        selenium.hardWait(2);
        selenium.click(continuumSelectFilterButton);
        selenium.hardWait(2);
        String newBText = selenium.getText(continuumSelectFilterButton);
        contCheckList.add(newBText);
        selenium.hardWait(2);
        return contCheckList;
    }

    @Step("Unselect filter of Continuum And Verify The Result")
    public String resultOfUnselectContinuumFilter() throws InterruptedException {
        selenium.click(applyFilterButton);
        String textResult = driver.findElement(By.xpath("//app-content-genre-section[@id='appContentSection_Clinical_Education']//div[2]")).getText();
        return textResult;
    }
    @Step("Go to the Social and Verify")
    public String NavigateOnSocialTabAndVerify()throws InterruptedException{
        selenium.click(socialTabButton);
        selenium.hardWait(20);
        String titleText = driver.findElement(By.xpath("//p[contains(@class,'post-data-title')]//span[1]")).getText();
        return titleText;
    }

    public String selectContentType() throws InterruptedException {
        return selenium.getText(contentType);
    }
    public void startWebinar()throws InterruptedException{
        selenium.clickOn(startWebinarButton);
        selenium.hardWait(5);
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
    }
    public void backToHomePage(){
        driver.findElement(By.xpath("//span[text()='Social']")).click();
    }

}