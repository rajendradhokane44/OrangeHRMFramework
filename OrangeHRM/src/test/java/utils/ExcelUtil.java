package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil 
{
	//Workbook->Sheet->Row->Cell
	//FileInputStream->Open MS Excel
	//Workbook->Open ExcelFile
	//Sheet, ROW, Cell
	
	//first create method for Open Excel
	public static Object[][] getLoginData() throws IOException
	{
		FileInputStream fis=new FileInputStream("src/test/resources/testdata/LoginData(1).xlsx");
		Workbook workbook=new XSSFWorkbook(fis);
		
		Sheet sheet=workbook.getSheet("Login");
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rows][cols];
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		workbook.close();
		return data;
	}
	

}



























/*
	 1) Open Excel
	  2) Read Excel
	   3)Return Data
[Wrong]	Test Class kabhi Excel Nahi Padhata-> LoginTest
                                      ↓
                                      Excel Read
                                      
[Right] This is the right way->LoginTest    |    tests
                                  ↓         |    ↓
                               ExcelUtil    |    DataProvider
                                  ↓         |    ↓
                               Excel File   |    ExcelUtil
                                            |    ↓
                                            |    Excel
   
                               
                               
                               
 */

