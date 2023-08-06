package utilities.mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

import java.util.ArrayList;

public class EmailDetailsPO extends BasePO {
  public EmailDetailsPO(WebDriver driver) {
    super(driver);
  }

  /*
   * All WebElements are identified by @FindBy annotation
   * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
   */

  @FindBy(id = "html_msg_body")
  private WebElement messageBodyIFrame;

  /**
   * @param buttonOrLinkText buttonOrLinkText
   * @throws InterruptedException
   */

  public void clickOnButtonOrLink(String buttonOrLinkText) throws InterruptedException {
    WebElement iFrameXpath = driver.findElement(By.id("html_msg_body"));
    driver.switchTo().frame(iFrameXpath);
    selenium.hardWait(5);
    String buttonOrLinkTextXpath = "//span[contains(text(),'" + buttonOrLinkText + "')]";
    driver.findElement(By.xpath(buttonOrLinkTextXpath)).click();
    selenium.hardWait(90);
    ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
    driver.switchTo().window(tabs1.get(0));
    selenium.hardWait(5);
    driver.navigate().back();
    selenium.hardWait(5);

  }
}
