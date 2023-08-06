package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.DriverManager;
import utilities.SeleniumHelpers;

public class BaseTest {

    protected WebDriver driver;
    protected SeleniumHelpers selenium;
    private DriverManager drivermanager;
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        drivermanager = new DriverManager();
        driver = drivermanager.setUp(browser);
        selenium = new SeleniumHelpers(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result){


        try
        {
            //capturing screenshot if failed

            if (ITestResult.FAILURE == result.getStatus()) {
                selenium.takeScreenshot(result.getName());
            }
        }
        catch (Exception e)
        {
            //ignore
        }
        drivermanager.tearDown();
    }


}
