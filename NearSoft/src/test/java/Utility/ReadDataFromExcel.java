package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashSet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Written by Hema Sundar Sai
 * 
 * This class will retrieve the data from excel file in the form of Set<String>
 */


public class ReadDataFromExcel {
	
	static LinkedHashSet<String> list;
	
	public static LinkedHashSet<String> readExcel(String fileName,String sheetName,int colNo) throws IOException {
		try {
		
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/testData/"+fileName);
		
			XSSFWorkbook workBook = new XSSFWorkbook(file);
        
			XSSFSheet sheet = workBook.getSheet(sheetName);
        
			list = new LinkedHashSet<String>();
        
			DataFormatter formatter = new DataFormatter();
        
			for (int i=1; i <= sheet.getLastRowNum(); i++) {
            Row r = sheet.getRow(i);
               
            String data = formatter.formatCellValue(r.getCell(colNo));
              
            list.add(data);
            }            
       
			workBook.close();       		
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
					e.printStackTrace();
			}
		return list;
	}
	
		
}
