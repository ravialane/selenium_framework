package tests;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.TestData;

public class LoginTest {

  @Test(dataProvider="getData")
  public void testData(Hashtable<String, String> testData){

    System.out.println(testData.get("TCID") + " " + testData.get("Name"));

  }

  @DataProvider(name = "getData")
  public Object[][] getData(){

    TestData data = new TestData();

    return(data.getData());

  }

}
