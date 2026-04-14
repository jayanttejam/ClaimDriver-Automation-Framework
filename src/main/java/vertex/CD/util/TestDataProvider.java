package vertex.CD.util;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
//	@DataProvider(name = "ClaimDriverData")
//	public static Object[][] getData() {
//	    return new Object[][] {
//	        {"testuser", "testpass"}
//	    };
//	}
//========================================================================
//    @DataProvider(name = "ClaimDriverData")
//    public static Object[][] getLoginData() throws IOException {
//
//        String path = "./TestData/TestData.xlsx";
//
//        int rownum = XLUtility.getRowCount("Login");
//        int colcount = XLUtility.getCellCount("Login", 1);
//        System.out.println("DataProvider executed  1");
//        String logindata[][] = new String[rownum][colcount];
//        System.out.println("DataProvider executed 2");
//        for (int i = 1; i <= rownum; i++) {
//            for (int j = 0; j < colcount; j++) {
//                logindata[i - 1][j] = XLUtility.getCellData(path, "Login", i, j);
//            }
//        }
//        System.out.println("DataProvider executed 3");
//        return logindata;
//        
//    }
//=====================================================================================
    
    @DataProvider(name = "ClaimDriverData", parallel = true)
    public static Object[][] getLoginData() throws IOException {

        String path = "./TestData/TestData.xlsx";

        int rownum = XLUtility.getRowCount("Login");

        int colcount = 2; // ✅ FIX: only username + password

        Object[][] logindata = new Object[rownum][colcount];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {

                String value = XLUtility.getCellData(path, "Login", i, j);

                if (value == null || value.trim().isEmpty()) {
                    throw new RuntimeException("Invalid data at row " + i + ", col " + j);
                }

                logindata[i - 1][j] = value;
            }
        }

        return logindata;
    }
    
//=====================================================================================    
//	@DataProvider(name = "ClaimDriverData")
//	public static Object[][] getData() {
//
//	    Object[][] data = ExcelManager.getTestData("Login");
//
//	    for (int i = 0; i < data.length; i++) {
//
//	        String user = data[i][0].toString();
//	        String pwd = data[i][1].toString();
//
//	        if (user.isEmpty() || pwd.isEmpty()) {
//	            throw new RuntimeException("Invalid data at row " + i);
//	        }
//
//	        System.out.println(user + " | " + pwd);
//	    }
//
//	    return data;
//	}
	
}