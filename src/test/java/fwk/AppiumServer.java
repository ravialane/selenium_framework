package fwk;

import java.io.IOException;

public class AppiumServer {
  private static Process process;
  private static String APPIUMSERVERSTART = "node /Applications/Appium.app/Contents/Resources/node/bin/node";

  public static void startAppiumServer() throws IOException, InterruptedException {
      Runtime runtime = Runtime.getRuntime();
      process = runtime.exec(APPIUMSERVERSTART);
      Thread.sleep(5000);
      if (process != null) {
          System.out.println("Appium server started");
      }
  }

  public static void stopAppiumServer() throws IOException {
      if (process != null) {
          process.destroy();
      }
      System.out.println("Appium server stop");
  }
}