package utilities.mailinator;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.base.BasePO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailListingGridPO extends BasePO {

  public EmailListingGridPO(WebDriver driver) {
    super(driver);
  }

  /*
   * All WebElements are identified by @FindBy annotation
   * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
   */

  @FindBy(css = ".jambo_table tbody tr")
  private List<WebElement> allEmailRows;

  @FindBy(css = "#inbox_field")
  private WebElement emailSearchTextBox;

  @FindBy(css = "tr.ng-scope td:nth-child(2)")
  private WebElement fromInfo;

  @FindBy(css = "tr.ng-scope:nth-child(1) td:nth-child(3)")
  private WebElement subjectInfo;

  /**
   * Get all email subject And from info as HasMap Key value pair
   *
   * @return Map<String, String>
   */
  public Map<String, String> getAllEmailsSubjectAndFromInfo(String emailAccountName) throws InterruptedException {
    emailSearchTextBox.sendKeys(Keys.ENTER);
    selenium.hardWait(2);
    HashMap<String, String> emailData = new HashMap<>();
    for (WebElement email : allEmailRows) {
      String fromInfoText = selenium.getText(fromInfo);
      String subjectText = selenium.getText(subjectInfo);
      emailData.put(subjectText, fromInfoText);
    }
    return emailData;
  }

  /**
   * Open given email by subject & from info
   *
   * @param from Email from info
   * @param subject Email subject info
   */
  public void openEmail(String from, String subject) throws InterruptedException {
    for (WebElement e : allEmailRows) {
      String rowText = selenium.getText(e);
      selenium.hardWait(5);
      if (rowText.contains(subject) && rowText.contains(from)) {
        selenium.javascriptClickOn(fromInfo);
        break;
      }
    }
  }
}
