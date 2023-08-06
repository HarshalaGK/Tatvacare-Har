package pageobjects.TatvaCare;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.base.BasePO;

import java.util.List;

public class HomePO extends BasePO {
    public HomePO(WebDriver driver)
    {
        super(driver);
    }
      @FindBy(id="navItemHome")
      private WebElement homeTab;


      public void loginAndClickOnHomeTab() throws InterruptedException {
          selenium.click(homeTab);
          selenium.hardWait(10);
          selenium.getWindowHandles();
          selenium.switchToWindow(1);
          selenium.hardWait(10);
        }
//    public int subTabOnHomePageList() throws InterruptedException{
//        List<WebElement>subTabList = driver.findElements(By.xpath("//div[@class='card custom-card ng-star-inserted']"));
//        Assert.assertTrue(!subTabList.isEmpty(),"list have 7 tab");
//       }
}
