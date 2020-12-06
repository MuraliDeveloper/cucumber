package main;


import org.apache.log4j.Logger;
import org.testng.ITestClass;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import static org.apache.commons.lang.StringUtils.isEmpty;

import org.apache.commons.lang.StringUtils;


/**
 * <b>NOTE:</b> This listener can not work with an official TestNG distribution!
 * 
 * Optional TEST listener invoked from TestNG.
 * Used to allow capturing log events from within @BeforeClass and @AfterClass methods.
 */

/**
 * 
 * @author Pooja Khanna
 * @version 1.0
 * @since 01/03/2019
 *  
 * Change History
 * *********************************************************************************
 * Version 		Date 	Defect/Task ID 	changed by 	Description
 ***********************************************************************************
 * 
 ***********************************************************************************
 */
@SuppressWarnings("unused")
public class TestngClassListener {
	 private static final  Logger log = Logger.getLogger(TestngClassListener.class.getName());
    private static String            lastSuiteName;
    private static ExtentTest extentTest;
    private static ExtentReports extentReports;

    /**
     * Invoked when tests from a new class are about to start 
     * @param testClass the class under test
     */
    public void onStart( ITestClass testClass ) {
    	
    		String suiteName = testClass.getName();
            String suiteSimpleName = suiteName.substring(suiteName.lastIndexOf('.') + 1);

            String packageName = getPackageName(suiteName);
          //  log.startSuite(packageName, suiteSimpleName);
            lastSuiteName = suiteName;
            extentTest.debug(MarkupHelper.createLabel("AUTO1-Automation", ExtentColor.TRANSPARENT));
           
            
        }
    
    public void onTestStart(ITestResult result) 
	{
		extentTest = extentReports.createTest(result.getName());
		

	}

    /**
     * Invoked after all tests from a given class had been invoked 
     */
    public void onFinish() {

       
            if (lastSuiteName != null) {
            //	log.endSuite();
                lastSuiteName = null;
            } else { // should not happen
            	log.error("Wrong test listeners state",
                             new RuntimeException("TestngClassListener.onFinish() method is invoked but seems that onStart() is not invoked first"));
            }
        }
    

    public void resetTempData() {

        TestngClassListener.lastSuiteName = null;
    }

    public static String getLastSuiteName() {

        return lastSuiteName;
    }

    public static String getPackageName( String className ) {

        if (!StringUtils.isEmpty(className)) {
            int lastDotInx = className.lastIndexOf('.');
            if (lastDotInx <= 0) {
                return "";
            } else {
                return className.substring(0, lastDotInx);
            }
        } else {
            return "";
        }
    }
}