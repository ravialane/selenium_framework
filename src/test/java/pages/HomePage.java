package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

  WebDriver driver;
  public HomePage(WebDriver driver){
    this.driver = driver;
  }

  @FindBy(css="menu#share-actions > li:nth-child(1) > button")
  public WebElement shareUpdateButotn;

  @FindBy(id="postmodule-text")
  public WebElement shareTextArea;

  @FindBy(css="button.postmodule-submit")
  public WebElement ShareButton;

  @FindBy(css="select.share-with-combo-select")
  public WebElement ShareWith;

  @FindBy(css="ol.feed updates > li")
  public WebElement updates;


  public void shareUpdate(String text, String share_with){
    shareUpdateButotn.click();
    shareTextArea.sendKeys(text);
    Select select = new Select(ShareWith);
    select.selectByValue(share_with);
    List<WebElement> drop_down_options = select.getOptions();
    System.out.println(drop_down_options.size());
    for(int i=0;i<drop_down_options.size();i++){
      System.out.println(drop_down_options.get(i).getText());
    }
    ShareButton.click();
  }

}
