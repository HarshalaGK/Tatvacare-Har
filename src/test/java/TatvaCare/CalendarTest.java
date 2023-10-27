package TatvaCare;

import base.BaseTest;
import datafactory.LoginData;
import dataobjects.Login;
import functions.LoginFunction;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageobjects.TatvaCare.CalendarPO;
import pageobjects.TatvaCare.HomePO;
import utilities.Constants;

public class CalendarTest extends BaseTest {
    @Test(priority = 0, description = "Login and click on CalendarTab")
    public void LoginAndClickOnCalendarTab()throws InterruptedException {
        Login loginData = new LoginData().getLoginData();
        CalendarPO calendar = new CalendarPO(driver);
        selenium.navigateToPage(Constants.URL);
        new LoginFunction(driver, selenium).loginIntoApplicationByUser(loginData.getMobileNumber(), loginData.getPassword());
        Reporter.log("Step 1: Click On HomeTab");
        calendar.getWindowHandle();
        calendar.tabOnCalendar();
        selenium.hardWait(10);

        Reporter.log("Step 2: Create Conform Event");
        calendar.addeventButtonInCalender();
        calendar.appointmentType(" Event ");
        calendar.statusType(" Confirmed ");
        calendar.title("Conform Event abc");
        calendar.selectCorrentDate();
        calendar.selectStartTime();
        selenium.hardWait(2);
        calendar.selectEndTime();
        calendar.addressFirst("www.zoom.com");
        calendar.addressSecond("www.meet.com");
        selenium.hardWait(2);
        calendar.clickOnCreateButton();
        selenium.hardWait(10);


      Reporter.log("Step 3: Fill Some Detail And Cancel The Event");
        calendar.addeventButtonInCalender();
        calendar.appointmentType(" Event ");
        calendar.statusType(" Confirmed ");
        calendar.title("Conform Event type 66");
        calendar.selectCorrentDate();
        calendar.selectStartTime();
        selenium.hardWait(2);
        calendar.selectEndTime();
        calendar.addressFirst("www.zoom.com");
        calendar.clickOnCancelButton();
        selenium.hardWait(10);

        Reporter.log("Step 4: Create  Tentative Event");
        calendar.addeventButtonInCalender();
        calendar.appointmentType(" Event ");
        calendar.statusType(" Tentative ");
        calendar.title(" Tentative Event type 23");
        calendar.selectAnyDate("21");
        calendar.selectStartTime();
        selenium.hardWait(2);
        calendar.selectEndTime();
        calendar.addressFirst("www.zoom.com");
        calendar.addressSecond("www.meet.com");
        calendar.clickOnCreateButton();
        selenium.hardWait(10);

        Reporter.log("Step 5 : Create  Others Conform Online Event ");
        calendar.addeventButtonInCalender();
        calendar.appointmentType(" Others ");
        calendar.statusType(" Confirmed ");
        calendar.modeType(" Online ");
        calendar.title(" Other Conform type s");
        calendar.selectAnyDate("22");
        calendar.selectStartTime();
        selenium.hardWait(2);
        calendar.selectEndTime();
        calendar.link("https://zoom.us/");
        calendar.clickOnCreateButton();
        selenium.hardWait(10);

        Reporter.log("Step 6 : Create  Others Tentative Offline Event ");
        calendar.addeventButtonInCalender();
        calendar.appointmentType(" Others ");
        calendar.statusType(" Confirmed ");
        calendar.modeType(" Offline ");
        calendar.title(" Tentative Event type 23");
        calendar.selectAnyDate("23");
        calendar.selectStartTime();
        selenium.hardWait(3);
        calendar.selectEndTime();
        calendar.addressFirst("www.zoom.com");
        calendar.addressSecond("www.meet.com");
        calendar.clickOnCreateButton();
        selenium.hardWait(10);

        Reporter.log("Step 7 : Check view Of Calender and Fetch List Of Event");
        calendar.monthlyView();
        calendar.listView();
        calendar.listData();

    }

}
