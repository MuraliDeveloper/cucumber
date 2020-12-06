package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUtil {
	
	//public static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT=100000;
	public static long IMPLICIT_WAIT=100000;
	//public static String TESTDATA_SHEET_PATH = "/Users/naveenkhunteta/Documents/workspace"
	//		+ "/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";

	
public static String TESTDATA_SHEET_PATH = "C:/Users/Pooja/Downloads/AUTO1 (1)/NearSoft/src/test/resources/testData/Copy of Test Cases_QA_Dep_02032020.xlsx";
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	 public static void TakeScreenshot(WebDriver driver,String screenShotName) throws IOException
	    {
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        //String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
	        String dest = "src\\main\\java\\Screenshots\\"+screenShotName+".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);        
	                     
	        //return dest;
	    }
	
	 	public static void ScrollIntoView(WebDriver driver, WebElement Obj)
		{
		JavascriptExecutor js = (JavascriptExecutor) driver;	        
		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Obj);
		}
	 	
		public static boolean getSpecialCharacterCount(String s) {
			if (s == null || s.trim().isEmpty()) {
		         System.out.println("Incorrect format of string");
		         return false;
		     }
		     //Pattern p = Pattern.compile("[^A-Za-z0-9]");
		     Pattern p = Pattern.compile("[<>?%*()��;&+�]");
		     Matcher m = p.matcher(s);
		    // boolean b = m.matches();
		     boolean b = m.find();
		     if (b)
		     {
		       System.out.println("There is a special character in String "+s+" Please enter correct data");
		     return true;
		     }
		     else
		         System.out.println("There is no special char.");
		     return false;
		 }
    /*public void ByVisibleElement() {
        
        JavascriptExecutor js = (JavascriptExecutor) driver;

      
         //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }*/
}
