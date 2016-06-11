package tests;

import java.util.List;
import static com.jayway.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import fwk.BaseTest;

public class FirstTest extends BaseTest{

  @Test
  public void testFirst() throws InterruptedException{
      driver.manage().window().maximize();;

      driver.get("http://www.google.com");
      List<WebElement> options = driver.findElements(By.tagName("a"));
      for(int i=0; i<options.size(); i++){
        System.out.println(options.get(i).getAttribute("href"));
      }

      LoginPage login = PageFactory.initElements(driver, LoginPage.class);
      HomePage homePage = login.login("angela.yang872@gmail.com", "test872");

      Thread.sleep(5000);
      List<WebElement> list = driver.findElements(By.xpath("//ol[@class='feed-updates']"));
      System.out.println(list.size());



  }

  @Test
  public void testSecond() throws InterruptedException{

    System.out.println("First test: " + driver);
  }

}
