package pageobjects.TatvaCare;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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

    @FindBy(xpath = "//a[@class='text-decoration-none clear-all'][2]")
    private WebElement continuumSelectFilterButton;

    @FindBy(xpath = "//div[@id='contentGenreFilter']//label[@class='checkbox-container ng-star-inserted']")
    private WebElement selectCheckBoxList;

    @FindBy(xpath = "//button[@class='btn btn-primary ml-2 publish-btn']")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//div[text()='No Records Found.']")
    private WebElement noRecordText;

    @FindBy(xpath = "//a[@class='text-decoration-none clear-all clear-all-new mr-2']")
    private WebElement clearAllFilterButton;

    @FindBy(xpath = "//*[@class='section-heading']")
    private WebElement sectionHeaderText;

    @FindBy(xpath = "//span[@class='active-page']")
    private WebElement contentPageTitleText;


    @FindBy(xpath = "//span[text()='Back']")
    private WebElement backButton;

    @FindBy(xpath = "//div[@class='media align-items-md-center d-md-flex media']/img")
    private WebElement backButtonOnContentDetailPage;

    @FindBy(xpath = "//a[@class='text-decoration-none clear-all clear-all-new mr-2']")
    private WebElement clearAllButton;


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
    public String searchResultPageTitle(){
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
        // List<WebElement> specialityList= driver.findElements(By.xpath("//*[@id='contentSpecializationFilter']/div[@class='inner-scroll px-3']/div"));
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
        selenium.clickOn(applyFilterButton);
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
    public void backOnContentDetailPage()throws InterruptedException{
        selenium.click(backButtonOnContentDetailPage);
    }
    public  void clearAll()throws InterruptedException{
        selenium.click(clearAllButton);

    }
//
//    public void uncheckCheckboxForAllFilters(String filterName) {
//        String xpath = "//div[@id='content'" + filterName + "'Filter']//a[@class='text-decoration-none clear-all']";
//        driver.findElement(By.xpath(xpath)).click();}


    public void check() throws InterruptedException{
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
    public String resultOfUnselectAllFilters(){
        String textResult;
        textResult  =driver.findElement(By.xpath("//div[@class='col-12 mt-4']")).getText();
     return textResult;
    }


     }


//    public void unSelectCheckBoxOfContinuum(String filterName) throws InterruptedException {
//
//        String xpath = "//div[@id='content'" + filterName + "'Filter']//a[@class='text-decoration-none clear-all']";
//        selenium.javascriptSetValue(continuumSelectFilterButton);
////              driver.findElement(By.xpath(xpath)).click();
//        String conSelectCheckBoxButtonText = selenium.getText(continuumSelectFilterButton);
//        selenium.hardWait(3);
////        selenium.click(continuumSelectFilterButton);
//        driver.findElement(By.xpath(xpath)).click();
//        String conSelectCheckBosButtonText2 = selenium.getText(continuumSelectFilterButton);
//        selenium.hardWait(5);
//        Assert.assertNotEquals(conSelectCheckBoxButtonText, conSelectCheckBosButtonText2);
//
//    }


