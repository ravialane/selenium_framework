package data;

import java.util.Hashtable;

public class TestData {

  public static Object[][] getData(){

    String path = System.getProperty("user.dir") + "/src/test/resources/data/TestData.xlsx";
    String sheetName = "Login";
    String testCase = "LoginTest";
    System.out.println(path);
    ExcelReader excelReader = new ExcelReader(path);



    int testCaseRowNum = 1;

//    System.out.println(excelReader.getCellData(sheetName, testCaseRowNum, 0));
    while(!excelReader.getCellData(sheetName, 0, testCaseRowNum).equalsIgnoreCase(testCase)){
      testCaseRowNum++;
    }

    System.out.println("Testcase starts from Row: " + testCaseRowNum);

    int colStartRowNum = testCaseRowNum+1;
    int dataStatRowNum = colStartRowNum+1;

    // Total columns in test are
    int cols = 0;
    while(!excelReader.getCellData(sheetName, cols, colStartRowNum).equals("")){
      cols++;
    }
    System.out.println("Total columns in test: " + cols);

    // Total rows in test are
    int rows = 0;
    while(!excelReader.getCellData(sheetName, 0, dataStatRowNum+rows).equals("")){
      rows++;
    }
    System.out.println("Total rows in test: " + rows);

    Object[][] data = new Object[rows][1];

    int i=0;

    for(int row=dataStatRowNum; row<dataStatRowNum+rows; row++){
      Hashtable<String, String> table = new Hashtable<String, String>();

      for(int col=0; col<cols; col++){

         String testData = excelReader.getCellData(sheetName, col, row);
         String colTitle = excelReader.getCellData(sheetName, col, colStartRowNum);

        table.put(colTitle, testData);

        System.out.println(excelReader.getCellData(sheetName, col, row));
      }
      data[i][0] = table;
      i++;
    }

    return data;

  }

  public static void main(String[] args) throws Exception{


  }
}
