package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Written by Hema Sundar Sai
 * 
 * This class will retrieve the data from excel file in the form of Object[][]
 */
public class MultipleDataProvider {
	
public static Object[][]  getDataFromDataprovider(String fileName,String sheetName) throws IOException {
	    
		Object[][] object = null;
		
	    FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/testData"+fileName);
		
		XSSFWorkbook workBook = new XSSFWorkbook(file);
    
		XSSFSheet sheet = workBook.getSheet(sheetName);
		
	    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
	    
	    int colCount = sheet.getRow(0).getLastCellNum();
	    
	    object = new Object[rowCount][colCount];
	    
	    DataFormatter formatter = new DataFormatter();
	    
	    for (int i = 0; i < rowCount; i++) {
	    	
	        Row row = sheet.getRow(i+1);
	        
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        	
	            object[i][j] = formatter.formatCellValue(row.getCell(j));
	        }
	    }
	    workBook.close();
	    
		return object;
	         
	    }

public static Object[][]  getDataFromDataprovidercol(String fileName,String sheetName, int lastColNo) throws IOException {
    
	Object[][] object = null;
	
    FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/testData/"+fileName);
	
	XSSFWorkbook workBook = new XSSFWorkbook(file);

	XSSFSheet sheet = workBook.getSheet(sheetName);
	
    int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
    
    int colCount = sheet.getRow(0).getLastCellNum();
    
    object = new Object[rowCount][colCount];
    
    DataFormatter formatter = new DataFormatter();
    
    for (int i = 0; i < rowCount; i++) {
    	
        Row row = sheet.getRow(i+1);
        
        for (int j = 0; j < lastColNo; j++) {
        	System.out.println("row:"+i);
        	System.out.println("col:"+j);
        	Cell data = row.getCell(j);
        	if(data!=null)
          object[i][j] = formatter.formatCellValue(data);
        	
        }
    }
    workBook.close();
    
	return object;
         
    }

}
