package pageobjects.AdminPortal;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;
import utilities.JavaHelpers;

import java.util.List;

public class Event_ManagementPO extends BasePO {
    public Event_ManagementPO(WebDriver driver) {
        super(driver);
    }

    JavaHelpers java = new JavaHelpers();
    @FindBy(xpath = "//span[text()=' Event Management']")
    private WebElement eventManageTab;

    @FindBy(xpath = "//span[text()='Create Event']")
    private WebElement createEventButton;

    @FindBy(xpath = "//input[@placeholder='Enter Content ID']")
    private WebElement contentIdTextBox;

    @FindBy(xpath = "//div[@class='p-multiselect-label ng-tns-c153-86 p-placeholder']")
    private WebElement selectCountyDropDown;

    @FindBy(xpath = "//div[@class='p-checkbox-box ng-tns-c153-86']")
    private WebElement allSelectCountryCheckBox;
    @FindBy(xpath = "//input[@id='eventTitle']")
    private WebElement eventTitleBox;
    @FindBy(xpath = "//span[@class='ng-tns-c158-87 p-dropdown-label p-inputtext ng-star-inserted']")
    private WebElement selectEventTypeDropDown;

    @FindBy(xpath = "//label[@for='event-internal-radio']//span[@class='radio-icon']")
    private WebElement radioButtonOfInternalEvent;

    @FindBy(xpath = "//label[@for='event-external-radio']//span[@class='radio-icon']")
    private WebElement radioButtonOfExternalEvent;

    @FindBy(xpath = "//p-calendar[@formcontrolname='eventStartDate']//button")
    private WebElement startDateBox;

    @FindBy(xpath = "//td[@class='ng-tns-c156-20 p-datepicker-today ng-star-inserted']")
    private WebElement currentDate;

    @FindBy(xpath = "//p-calendar[@formcontrolname='eventEndDate']//button")
    private WebElement endDateBox;

    @FindBy(xpath = "//td[contains(@class,'datepicker-today')]/following-sibling::td[1]//span")
    private WebElement endDate;

    @FindBy(xpath = "//p-calendar[@formcontrolname='scheduledPublishedDate']//button")
    private WebElement scheduleStartDateBox;

    @FindBy(xpath = "//button[text()=' Publish Event ']")
    private WebElement publishEventButton;

    public void eventManageTab() throws InterruptedException {
        selenium.clickOn(eventManageTab);
    }

    public void createEvent() throws InterruptedException {
        selenium.click(createEventButton);
    }

    public void contentId(String id) {
        selenium.enterText(contentIdTextBox, id, true);
    }

    public void clickOnSelectCountryDropdown() throws InterruptedException {
        selenium.clickOn(selectCountyDropDown);
    }

    public void selectAllCountryOptionCheckBox() throws InterruptedException {
        selenium.clickOn(allSelectCountryCheckBox);
    }

    public void selectIndia() throws InterruptedException {
        //  List<WebElement> countryList = driver.findElements(By.xpath("//ul[@role='listbox']//li/div"));
        driver.findElement(By.xpath("//li[@aria-label='India']/div")).click();
    }

    public void eventTitle(String title) {
        eventTitleBox.sendKeys(title);
    }

    public void selectEventType() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Select Type')]")).click();
        selenium.hardWait(2);
       // driver.findElement(By.cssSelector("ul[role='listbox'] > p-dropdownitem:nth-child(3) span")).click();
        List<WebElement> eventLs = driver.findElements(By.cssSelector("ul[role='listbox'] > p-dropdownitem"));
        selenium.hardWait(2);
        //String randomNumber = (java.getRandomNumber(eventLs.size(), 2));
        int randomNumber= (java.getRandomNumberInInteger(eventLs.size(), 2));
        selenium.hardWait(2);
        driver.findElement(By.cssSelector("ul[role='listbox'] > p-dropdownitem:nth-child('" + randomNumber + "') span")).click();
        selenium.hardWait(2);

    }

    public void externalEvent() throws InterruptedException {
        selenium.clickOn(radioButtonOfExternalEvent);
    }

    public void selectStartDateAndEndDate() throws InterruptedException {
        selenium.clickOn(startDateBox);
        selenium.clickOn(currentDate);
        selenium.clickOn(endDateBox);
        selenium.clickOn(endDate);
    }

    @Step("Select any speciality")
    public String selectSpeciality() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Select Speciality']")).click();
        List<WebElement> specialityList = driver.findElements(By.xpath("//ul[@role='listbox']/p-multiselectitem"));
        selenium.hardWait(2);
        String randomNumber = (java.getRandomNumber(specialityList.size(), 1));
        String specialityTitle = driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber + "]//li/span")).getText();
        selenium.hardWait(2);
        driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber + "]//li/span")).click();
         return specialityTitle;
    }

    public void fullDayEventCheck() {
        String value = driver.findElement(By.xpath("//p-inputswitch[@formcontrolname='isFullDay']//input")).getAttribute("aria-checked");
        if (value == "false") {
            driver.findElement(By.xpath("//p-inputswitch[@formcontrolname='isFullDay']/div//input")).click();
        }

    }

    @Step("select any city")
    public void selectCity() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Select City')]")).click();
        selenium.hardWait(2);
        driver.findElement(By.xpath("//span[contains(text(),'Kolkata, West Bengal')]")).click();

    }
    public void SelectInternalEvent()throws InterruptedException{
        selenium.clickOn(radioButtonOfInternalEvent);
        driver.findElement(By.xpath("//textarea[@id='eventDescription']")).sendKeys("event");
    }

    public void selectScheduleDate() throws InterruptedException {
        selenium.clickOn(scheduleStartDateBox);
        selenium.clickOn(currentDate);
        driver.findElement(By.xpath("//p-checkbox[@name='scheduleNotApplicableName']")).click();
    }

    public void publishEvent() throws InterruptedException {
        selenium.clickOn(publishEventButton);
    }

}








