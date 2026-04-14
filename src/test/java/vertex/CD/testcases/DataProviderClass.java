package vertex.CD.testcases;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class DataProviderClass {

    private Workbook workbook;
    private String filePath = "./TestData\\TestData.xlsx";
    private String sheetName = "TestResults";

    @BeforeMethod
    public void setUp() {
        workbook = new XSSFWorkbook();
    }

    @DataProvider(name = "testData")
    public Object[][] testData() {
        return new Object[][] {
            {"Test Case 1", "Pass"},
            {"Test Case 2", "Fail"},
            {"Test Case 3", "Pass"}
        };
    }

    @Test(dataProvider = "testData")
    public void executeTest(String testCaseName, String testResult, Method method) {
        Sheet sheet = workbook.createSheet(sheetName);

        // Create a header row for each test execution
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Test Case Name");
        headerRow.createCell(1).setCellValue("Test Result");

        // Create a data row for each test execution
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(testCaseName);
        dataRow.createCell(1).setCellValue(testResult);

        // You can add more test data as needed

        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
