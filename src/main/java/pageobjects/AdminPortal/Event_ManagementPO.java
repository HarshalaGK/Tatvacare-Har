package pageobjects.AdminPortal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

public class Event_ManagementPO extends BasePO {
    public Event_ManagementPO(WebDriver driver) {
        super(driver);
    }
       @FindBy(xpath = "//span[text()=' Event Management']")
    private WebElement EventManageTab;

    @FindBy(xpath = "")
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
    private WebElement selectTypeDropDown;

    @FindBy(xpath = "//label[@for='event-internal-radio']//span[@class='radio-icon']")
    private WebElement radioButtonOfInternalEvent;

    @FindBy(xpath = "///label[@for='event-external-radio']//span[@class='radio-icon']")
    private WebElement radioButtonOfExternalEvent;

}
