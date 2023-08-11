package pageobjects.TatvaCare;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement searchBox;


    public void navigateOnTatvapedia() {
        selenium.getWindowHandles();
        selenium.switchToWindow(1);
    }

    @Step("Click On Unselect Button And Check It Change Into Select All Button")
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

//    @Step("Speciality")
//    public String unselectSpeciality() {
//        // List<WebElement> specialityList= driver.findElements(By.xpath("//*[@id='contentSpecializationFilter']/div[@class='inner-scroll px-3']/div"));
//        //  List<WebElement> CheckBoxList= driver.findElements(By.xpath("//*[@id='contentSpecializationFilter']/div[@class='inner-scroll px-3']/div//label/span"));
//
//    }


    @Step("Select Any filter of Genre ")
    public String selectRandomFilterOfGenre() throws NumberFormatException{
        List<WebElement> filterList = driver.findElements(By.xpath("//*[@id='contentGenreFilter']/div"));

        String  randomNumber = (java.getRandomNumber(filterList.size(), 2));
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
    public  String selectRandomContentOfAppliedFilter()throws  InterruptedException{
        List<WebElement> contentList= driver.findElements(By.xpath("//div[@class='card-title']"));
        selenium.hardWait(2);
        String randomNumber = (java.getRandomNumber(contentList.size(), 2));
        String contentTitle= driver.findElement(By.xpath("//div[@class='card-body']['" + randomNumber + "']//*[@class='card-title']")).getText();
        driver.findElement(By.xpath("//div[@class='card-body']['" + randomNumber + "']//*[@class='card-title']")).click();
        return contentTitle;
    }
    public String randomSelectContentPageTitleText()throws InterruptedException{
        return selenium.getText(contentPageTitleText);
    }


    public void uncheckCheckbox(String filterName) {
        String xpath = "//div[@id='content'" + filterName + "'Filter']//a[@class='text-decoration-none clear-all']";
        driver.findElement(By.xpath(xpath)).click();
    }




    }

//    public void unSelectCheckBoxOfContinuum(String filterName) throws InterruptedException {
//
//        String xpath = "//div[@id='content'"+filterName+"'Filter']//a[@class='text-decoration-none clear-all']";
//        selenium.javascriptSetValue(continuumSelectFilterButton);
////              driver.findElement(By.xpath(xpath)).click();
//        String conSelectCheckBoxButtonText = selenium.getText(continuumSelectFilterButton);
//        selenium.hardWait(3);
////        selenium.click(continuumSelectFilterButton);
//        driver.findElement(By.xpath(xpath)).click();
//        String conSelectCheckBosButtonText2 = selenium.getText(continuumSelectFilterButton);
//        selenium.hardWait(5);
//        Assert.assertNotEquals(conSelectCheckBoxButtonText, conSelectCheckBosButtonText2);

    //  }


