package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataDriven {

    @DataProvider(name = "LoginDataDrivenData")
    public String[][] getData() {
        try {
            String path = "testdata/TestData.xlsx";
            ExcelUtility excelUtility = new ExcelUtility(path);
            int rows = excelUtility.getRowCount("Sheet1");
            int columns = excelUtility.getCellCount("Sheet1", rows);
            String[][] data = new String[rows][columns];

            for (int i = 1; i <= rows; i++) {
                for (int j = 0; j < columns; j++) {
                    data[i - 1][j] = excelUtility.getCellData("Sheet1", i, j);
                }
            }
            System.out.println(data);
            return data;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
