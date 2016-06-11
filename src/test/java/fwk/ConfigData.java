package fwk;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigData {

  public Properties getConfigProperties(){

    FileInputStream inputStream;
    Properties prop = new Properties();

    try{

//      String propFileName = "config.properties";

      inputStream = new FileInputStream("/Users/ralane/workspace_RTF/framework/src/test/resources/config.properties");

      prop.load(inputStream);
      return prop;
    }catch(Exception e){
        System.out.println("Exception: " + e);
        return null;
    }

  }

}
