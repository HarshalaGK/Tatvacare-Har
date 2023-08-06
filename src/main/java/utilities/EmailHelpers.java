package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.mailinator.EmailDetailsPO;
import utilities.mailinator.EmailListingGridPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class EmailHelpers {
    WebDriver driver;
    SeleniumHelpers selenium;
    EmailListingGridPO emailListing;
    EmailDetailsPO emailDetails;
    EmailDetailsPO emailDetailsOfYopMail;

    public EmailHelpers(WebDriver driver) {
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        emailListing = new EmailListingGridPO(driver);
        emailDetails = new EmailDetailsPO(driver);
        emailDetailsOfYopMail = new EmailDetailsPO(driver);
    }

    public WebDriver setup() {
        WebDriverManager.chromedriver().setup();
        // Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<>();
        // add key and value to map as follow to switch off browser notification
        // Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 1);
        // Create an instance of ChromeOptions
        ChromeOptions cOptions = new ChromeOptions();
        // set ExperimentalOption - prefs
        cOptions.setExperimentalOption("prefs", prefs);
        cOptions.addArguments("--disable-gpu");
        HashMap<String, Object> chromeLocalStatePrefs = new HashMap<>();
        List<String> experimentalFlags = new ArrayList<>();
        experimentalFlags.add("calculate-native-win-occlusion@2");
        chromeLocalStatePrefs.put("browser.enabled_labs_experiments", experimentalFlags);
        cOptions.setExperimentalOption("localState", chromeLocalStatePrefs);

        cOptions.addArguments("--chrome");
        // Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome
        // driver which will switch off this browser notification on the chrome browser
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver = new ChromeDriver(cOptions);
    }

    /**
     * Navigate to email box
     *
     * @param emailDomain email domain name
     * @param emailAccountName email account name
     */
    public void navigateToEmailBox(String emailDomain, String emailAccountName)
            throws InterruptedException {
        if (emailDomain.equals(Constants.MAILINATORNAME)) {
            String emailBoxUrl = Constants.MAILINATORURL + emailAccountName + "#/#inboxpane";
            selenium.navigateToPage(emailBoxUrl);
        }
    }

    /**
     * To check whether email is received or not
     *
     * @param emailDomain email domain name
     * @param emailAccountName email account name
     * @param fromInfo email from info
     * @param subjectInfo email subject info
     * @return boolean true or false
     */
    public boolean isEmailReceived(
            String emailDomain,
            String emailAccountName,
            String fromInfo,
            String subjectInfo,
            int waitTime)
            throws InterruptedException {
        selenium.hardWait(waitTime);
        navigateToEmailBox(emailDomain, emailAccountName);

        if (emailDomain.equals(Constants.MAILINATORNAME)) {
            Map<String, String> emailData;
            emailData = emailListing.getAllEmailsSubjectAndFromInfo(emailAccountName);

            if (emailData.containsKey(subjectInfo)) {
                return emailData.get(subjectInfo).equals(fromInfo);
            }
        }

        return false;
    }

    /**
     * Get Welcome Email Subject Text
     *
     * @return Email Subject Text
     */
    public String getWelcomeEmailSubjectText() {
        WebElement welcomeEmailSubjectCssLocator = driver.findElement(By.cssSelector("tr.ng-scope:nth-child(1) td:nth-child(3)"));
        String welcomeText = welcomeEmailSubjectCssLocator.getText();
        return welcomeText;
    }


}

