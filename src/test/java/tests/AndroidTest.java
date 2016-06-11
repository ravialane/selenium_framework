package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import fwk.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AndroidTest extends BaseTest {




  @Test
  public void testAndroidApp() throws InterruptedException{

    System.out.println("In Test");

    WebDriverWait wait = new WebDriverWait(driver, 30L);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[2]")));

    WebElement login = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.Button[2]"));
    // Click Login button
    System.out.println("Size: " + login.getSize());
    login.click();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_username_edit")));
    WebElement email = driver.findElement(By.id("com.linkedin.android:id/login_username_edit"));
    WebElement password = driver.findElement(By.id("com.linkedin.android:id/login_password_edit"));
    WebElement signin_button = driver.findElement(By.id("com.linkedin.android:id/login_ok_button"));
//    WebElement no_thanks = driver.findElement(By.id("com.linkedin.android:id/diagree_sync"));

    email.sendKeys("angela.yang872@gmail.com");
    password.sendKeys("test872");
    signin_button.click();

//    Set<String> screens = driver.getWindowHandles();
//    Iterator<String> iterator = screens.iterator();
//    String mainScreen = iterator.next();
//    String loginscreen = iterator.next();
//    driver.switchTo().window(mainScreen);
//    Thread.sleep(20L);
//    driver.switchTo().window(loginscreen);
  }

}
