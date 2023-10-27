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

    JavaHelpers javaHelper = new JavaHelpers();
    @FindBy(xpath = "//span[text()=' Event Management']")
    private WebElement eventManageTab;

    @FindBy(xpath = "//span[text()='Create Event']")
    private WebElement createEventButton;

    @FindBy(xpath = "//input[@placeholder='Enter Content ID']")
    private WebElement contentIdTextBox;

    @FindBy(xpath = "//div[contains(text(),'Select Country')]")
    private WebElement selectCountyDropDown;

    @FindBy(xpath = "//div[contains(@class, 'p-multiselect-header ng-tns')]//div[1]")
    private WebElement allSelectCountryCheckBox;
    @FindBy(xpath = "//input[@id='eventTitle']")
    private WebElement eventTitleBox;

    @FindBy(xpath = "//label[@for='event-internal-radio']//span[@class='radio-icon']")
    private WebElement radioButtonOfInternalEvent;

    @FindBy(xpath = "//label[@for='event-external-radio']//span[@class='radio-icon']")
    private WebElement radioButtonOfExternalEvent;

    @FindBy(xpath = "//p-calendar[@formcontrolname='eventStartDate']//button")
    private WebElement startDateBox;

    @FindBy(xpath = "//td[contains(@class, 'p-datepicker-today ng-star-inserted')]")
    private WebElement currentDate;

    @FindBy(xpath = "//p-calendar[@formcontrolname='eventEndDate']//button")
    private WebElement endDateBox;

    @FindBy(xpath = "//td[contains(@class,'datepicker-today')]/following-sibling::td[1]//span")
    private WebElement endDate;

    @FindBy(xpath = "//p-calendar[@formcontrolname='scheduledPublishedDate']//button")
    private WebElement scheduleStartDateBox;

    @FindBy(xpath = "//button[text()=' Publish Event ']")
    private WebElement publishEventButton;

    @FindBy(xpath = "//textarea[@id='eventDescription']")
    private WebElement eventDescriptionBox;

    public void eventManageTab() throws InterruptedException {
        selenium.clickOn(eventManageTab);
    }

    public void createEvent() throws InterruptedException {
        selenium.click(createEventButton);
    }

    public void contentId() {
        selenium.enterText(contentIdTextBox, javaHelper.getContentId(7), true);

    }

    public void selectAllCountry() throws InterruptedException {
        selenium.clickOn(selectCountyDropDown);
        selenium.hardWait(2);
        selenium.clickOn(allSelectCountryCheckBox);
        selenium.hardWait(2);
        driver.findElement(By.xpath("//button[contains(@class, 'p-multiselect-close p-link ng-tns')]")).click();
    }


    public void selectCountyAsIndia() throws InterruptedException {
        selenium.clickOn(selectCountyDropDown);
        selenium.hardWait(5);
        driver.findElement(By.xpath("//li[@aria-label='India']/div")).click();
    }

    public void eventTitle(String title) {
        eventTitleBox.sendKeys(title);
    }


    public void selectEventType() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Select Type')]")).click();
        selenium.hardWait(3);
        // driver.findElement(By.cssSelector("ul[role='listbox'] > p-dropdownitem:nth-child(3) span")).click();
        List<WebElement> eventLs = driver.findElements(By.cssSelector("ul[role='listbox'] > p-dropdownitem"));
        selenium.hardWait(3);
        int randomNumber = (JavaHelpers.getRandomNumberInInteger(eventLs.size(), 3));
        selenium.hardWait(2);
        WebElement g = driver.findElement(By.cssSelector("ul[role='listbox'] > p-dropdownitem:nth-child(" + randomNumber + ") span"));
        selenium.clickOn(g);
        selenium.hardWait(2);

    }

    public void externalEvent() throws InterruptedException {
        selenium.clickOn(radioButtonOfExternalEvent);
    }

    public void internalEventDescription() {
        eventDescriptionBox.sendKeys("this is Internal Event  " + javaHelper.getRandomString(5));
    }

    public void selectStartDateAndEndDate() throws InterruptedException {
        selenium.clickOn(startDateBox);
        selenium.hardWait(1);
        selenium.clickOn(currentDate);
        selenium.hardWait(2);
        selenium.clickOn(endDateBox);
        selenium.clickOn(endDate);
    }

    @Step("Select any speciality")
    public String selectSpeciality() throws InterruptedException {
        driver.findElement(By.xpath("//div[text()='Select Speciality']")).click();
        List<WebElement> specialityList = driver.findElements(By.xpath("//ul[@role='listbox']/p-multiselectitem"));
        selenium.hardWait(2);
        String randomNumber = (javaHelper.getRandomNumber(specialityList.size(), 2));
        String specialityTitle = driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber + "]//li/span")).getText();
        selenium.hardWait(2);
        driver.findElement(By.xpath("//ul[@role='listbox']/p-multiselectitem[" + randomNumber + "]//li/span")).click();
        return specialityTitle;
    }

    public void fullDayEventCheck() {
        String value = driver.findElement(By.xpath("//p-inputswitch[@formcontrolname='isFullDay']//input")).getAttribute("aria-checked");
        if (value == "false") {
            driver.findElement(By.xpath("//p-inputswitch[@formcontrolname='isFullDay']/div/input")).click();
        }

    }

    @Step("select any city")
    public void selectCity() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Select City')]")).click();
        selenium.hardWait(2);
        driver.findElement(By.xpath("//span[contains(text(),'Kolkata, West Bengal')]")).click();

    }

    public void selectInternalEvent() throws InterruptedException {
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

    public String eventVerify() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='From']")).click();
        driver.findElement(By.xpath("//td[contains(@class, 'p-datepicker-today ng-star-inserted')]")).click();
        selenium.hardWait(5);
        driver.findElement(By.xpath("//p-button[@label='Submit']")).click();
        selenium.hardWait(5);
        String eventText = driver.findElement(By.xpath("//tbody[@class='p-datatable-tbody']//tr//td[2]")).getText();
        return eventText;
    }

}








