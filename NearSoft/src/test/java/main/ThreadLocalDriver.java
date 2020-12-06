package main;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * 
 * @author Pooja Khanna
 * @version 1.0
 * @since 15/02/2019
 *  
 * Change History
 * *********************************************************************************
 * Version 		Date 	Defect/Task ID 	changed by 	Description
 ***********************************************************************************
 * 
 ***********************************************************************************
 */
@SuppressWarnings("unused")
public class ThreadLocalDriver {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public synchronized static void setTLDriver(WebDriver driver)
    {
        tlDriver.set(driver);
    }

    @SuppressWarnings("static-access")
    public synchronized static WebDriver getTLDriver()
    {
        return tlDriver.get();
    }
    
    public static void UnSet() {
    	tlDriver.remove();
    	}


}
