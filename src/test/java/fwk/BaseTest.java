package fwk;


import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  public WebDriver driver;
  public int n;

  // Mandatory setup before each test execution
  @BeforeMethod
  public void mandatorySetup() throws IOException, InterruptedException{
    ConfigData conf = new ConfigData();
    Properties prop = new Properties();
    prop = conf.getConfigProperties();

    this.initDriver(prop);

    driver.get(prop.getProperty("base_url"));

  }

  //Initialize driver
  public void initDriver(Properties prop) throws IOException, InterruptedException{
    String device = prop.getProperty("device");
    String browser = prop.getProperty("browser");
    String platform = prop.getProperty("platform");

    DesiredCapabilities cap = null;

    if(device.equals("web")){
      if(browser.equals("firefox")){
        cap = DesiredCapabilities.firefox();
        cap.setBrowserName("firefox");
        cap.setPlatform(Platform.ANY);
      }
      if(browser.equals("chrome")){
        cap = DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.ANY);
      }
      if(browser.equals("iexplore")){
        cap = DesiredCapabilities.internetExplorer();
        cap.setBrowserName("iexplore");
        cap.setPlatform(Platform.WINDOWS);
      }

      driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
    }else{

      System.out.println("Starting appium server-------------");
      AppiumServer.startAppiumServer();

      cap.setCapability("deviceName", "Andro");
      cap.setCapability("platformName", "Android");
      cap.setCapability("platformVersion", "4.4");
      cap.setCapability("browserName", "");

      File classpathRoot = new File(System.getProperty("user.dir"), "/src/apps/"); // path to Eclipse project
      System.out.println("Class path: " + classpathRoot);
////      File appDir = new File(classpathRoot, "/apps/"); // path to <project folder>/Contact Manager
      System.out.println("Class path: " + classpathRoot);
      File app = new File(classpathRoot, "LinkedInApp-debug.apk");

    //the absolute local path to the APK
      cap.setCapability("app", "/Users/ralane/workspace_RTF/framework/src/test/resources/data/LinkedInApp-debug.apk");
  //
//      //Java package of the tested Android app
      cap.setCapability("appPackage", "com.linkedin.android");
  //
//      // activity name for the Android activity you want to run from your package. This need to be preceded by a . (example: .MainActivity)
      cap.setCapability("appActivity", "com.linkedin.android.authenticator.LaunchActivity");

      driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);





    }




  }


}
