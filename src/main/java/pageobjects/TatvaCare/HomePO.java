package pageobjects.TatvaCare;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.base.BasePO;

import java.util.List;
import java.util.stream.Collectors;

public class HomePO extends BasePO {
    public HomePO(WebDriver driver)
    {
        super(driver);
    }
      @FindBy(id="navItemHome")
      private WebElement homeTab;

   // @FindBy(xpath = "//div[@class='card-body']//div[@class='col-auto mr-auto']")
 //   private WebElement subTabList;
    @FindBy(xpath ="//div[@class='card custom-card ng-star-inserted']")
    private WebElement nunOfTab;


      public void loginAndClickOnHomeTab() throws InterruptedException {
          selenium.hardWait(3);
          selenium.click(homeTab);
          selenium.hardWait(10);
          selenium.getWindowHandles();
          selenium.switchToWindow(1);
          selenium.hardWait(10);

      }
        //  elements = driver.find_elements_by_xpath('your_xpath_here')
//     int num_elements = len(nunOfTab);
//
//          print("Number of elements found:", num_elements)
//          List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card custom-card ng-star-inserted']"));
//
//          // Get the number of elements found
//          int numElements = elements.size();

          // Print the number of elements
       //   System.out.println("Number of elements found: " + numElements);


   //   }

//    public List<String> getDashboardTabList() {
//        List<WebElement>subTabList = driver.findElements(By.xpath("//div[@class='card custom-card ng-star-inserted']"));
//        return subTabList.stream().map(x -> x.getText().trim()).collect(Collectors.toList());
  //  }

}
