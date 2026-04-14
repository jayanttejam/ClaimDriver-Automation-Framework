package vertex.CD.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelManager {

    private static ExcelManager instance;
    private XSSFWorkbook workbook;
    private Map<String, XSSFSheet> sheetCache = new HashMap<>();

    private ExcelManager(String path) throws IOException {
        FileInputStream fi = new FileInputStream(path);
        workbook = new XSSFWorkbook(fi);
    }

    // Singleton instance
    public static ExcelManager getInstance(String path) throws IOException {
        if (instance == null) {
            synchronized (ExcelManager.class) {
                if (instance == null) {
                    instance = new ExcelManager(path);
                }
            }
        }
        return instance;
    }

    // Get sheet with caching
    private XSSFSheet getSheet(String sheetName) {
        if (!sheetCache.containsKey(sheetName)) {
            sheetCache.put(sheetName, workbook.getSheet(sheetName));
        }
        return sheetCache.get(sheetName);
    }

    // Get row count
    public int getRowCount(String sheetName) {
        return getSheet(sheetName).getLastRowNum();
    }

    // Get column count
    public int getColCount(String sheetName, int rowNum) {
        XSSFRow row = getSheet(sheetName).getRow(rowNum);
        return (row == null) ? 0 : row.getLastCellNum();
    }

    // Get cell data
    public String getCellData(String sheetName, int rowNum, int colNum) {
        XSSFSheet sheet = getSheet(sheetName);
        XSSFRow row = sheet.getRow(rowNum);

        if (row == null) return "";

        XSSFCell cell = row.getCell(colNum);
        DataFormatter df = new DataFormatter();

        return df.formatCellValue(cell);
    }

    // Get full data (for DataProvider)
    public Object[][] getSheetData(String sheetName) {
        int rows = getRowCount(sheetName);
        int cols = getColCount(sheetName, 1);

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = getCellData(sheetName, i, j);
            }
        }
        return data;
    }

    // Close workbook
    public void close() throws IOException {
        workbook.close();
    }
}