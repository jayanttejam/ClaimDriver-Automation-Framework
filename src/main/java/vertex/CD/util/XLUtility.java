package vertex.CD.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	static String path="./TestData\\TestData.xlsx";
	
	XLUtility(String path)
	{
		this.path=path;
	}

	public static int getRowCount (String sheetName) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		
		return rowcount;
		
	}
	
	public static int getCellCount (String sheetName, int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
		
	}
	
	public static String getCellData (String xlfile, String xlsheet, int rowNum, int colNum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		String data;
		try
		{
			DataFormatter df = new DataFormatter();
			String cellData = df.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data = "";
		}
		workbook.close();
		fi.close();
		
		
		return data;
		
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		workbook.write(fo);		
		workbook.close();
		fi.close();
		fo.close();
	}
	
	public static void setResultData(String xlfile,String xlsheet,String no, String user, String pwd, String formattedResult, String date) throws IOException
	{	
		

		fi=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(xlsheet);
		int rowcount = sheet.getLastRowNum();
		
		row = sheet.createRow(rowcount+1);
		
		cell=row.createCell(0);
		cell.setCellValue(no);
		cell=row.createCell(1);
		cell.setCellValue(user);
		cell=row.createCell(2);
		cell.setCellValue(pwd);
		
		cell=row.createCell(3);
		cell.setCellValue(formattedResult);
		cell=row.createCell(4);
		cell.setCellValue(date);
		
		fo=new FileOutputStream(xlfile);
		workbook.write(fo);		
		workbook.close();
		fi.close();
		fo.close();
	}
	
	
	public static void deleteSheetContent (String sheetName) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
	
		
		// Iterate through rows and delete rows with data
       
           int rowcount = sheet.getLastRowNum();

   		for(int i=rowcount; i>0; i--) {

   			XSSFRow removingrow = sheet.getRow(i);

   			sheet.removeRow(removingrow);

   		}
		
   		// Save changes back to the Excel file
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
		
		workbook.close();
		fi.close();		
	}	
	}
	
