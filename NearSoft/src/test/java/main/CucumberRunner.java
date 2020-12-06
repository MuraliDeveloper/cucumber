package main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import org.apache.log4j.PropertyConfigurator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import org.openqa.selenium.Capabilities;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;


/*import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;*/
import cucumber.api.CucumberOptions;
import cucumber.api.cli.Main;
import cucumber.api.junit.Cucumber;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/
/*import com.cucumber.listener.Reporter;*/
import com.google.common.io.Files;



import java.util.logging.Level;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


/*import helpers.Replace_url;*/
import org.openqa.selenium.*;
import java.util.logging.FileHandler;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.it.Date;
import cucumber.api.testng.AbstractTestNGCucumberTests;
//import helpers.ReportHelper;
/*import main.Hooks;*/
import org.junit.runner.RunWith; 
/**
 * 
 * @author Pooja Khanna
 * @version 1.0
 * @since 15/02/2019
 *  /*
 * Change History
 * *********************************************************************************
 * Version 		Date 	Defect/Task ID 	changed by 	Description
 ***********************************************************************************
 * 
 ***********************************************************************************
 */
@SuppressWarnings("unused")

@CucumberOptions( strict = true, monochrome = true, features = "src/test/resources/features/CCPA.feature", glue = "stepdefinition", plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, format = {"pretty", "html:target/cucumber"}, tags = {"@Regression","~@JunitScenario", "~@TestngScenario"})

public class CucumberRunner extends AbstractTestNGCucumberTests {
	
	
	//IFormPage form = new IFormPage(getDriver());
	static Logger log = Logger.getLogger(CucumberRunner.class.getName());
	public static String BrowserType4;
	public static String OS;
	public static final String BrowserType1 = "Chrome";
	public static final String BrowserType2 = "firefox";
	public static  final String BrowserType3 = "Internet Explorer";		
	public static String scenarioName;
	public static int scenarioIndex;
	public static String featureName;
	static final ClassLoader loader = CucumberRunner.class.getClassLoader();
	public static String reportConfigPath = null;
	public static String appURL;
	public static void test_setUP() {
		try {
			setScenarioIndex(1);
			
		} catch (Exception e) {
			// Test Set up Fail
			e.printStackTrace();
		}
	}


	

	public int getScenarioIndex() {
		return scenarioIndex;
	}

	public static void setScenarioIndex(int scenarioIndex) {
		CucumberRunner.scenarioIndex = scenarioIndex;
	}

	public String getScenarioName() {
		return scenarioName;
	}

	public static void setScenarioName(String scenarioName) {
		CucumberRunner.scenarioName = scenarioName;
	}

	public static String getFeatureName() {
		return featureName;
	}

	public static void setFeatureName(String featureName) {
		CucumberRunner.featureName = featureName;
	}
	public static WebDriver driver;
    
  //  Hooks.initialize();

    public static WebDriver getDriver() {

        return driver;
    }
   public static WebDriverWait wait;
  
	
   /*private TestNGCucumberRunner testNGCucumberRunner;
    //public static Properties config = null;
   private Reportable reportable;

   private File File;*/

   @BeforeClass
    @Parameters({"NodeURL", "Environment","osname", "BrowserType", "platformVersion", "portNumber"})
    public void configureDriverPath(String NodeURL, String Environment, String osname,  String BrowserType, String platformVersion, String portNumber) throws IOException {

	   boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
   	try {
   	   
   	        Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
   	} catch (IOException e) {
   	    e.printStackTrace();
   	}

	   
			

		
		
		
      /*  DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("BrowserType", BrowserType);
        caps.setCapability("platformVersion", platformVersion);*/
	   ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	 
	   
//     extentProperties.setExtentXServerUrl("http://localhost:1337");
//     extentProperties.setProjectName("MyProject");
	   extentProperties.setReportPath("target/cucumber-reports/MyOwnReport"+currentDateTime()+".html");
	   extentProperties.setProjectName("ACORD Automation Testing");
	  
    	       
    	try{
    	  log.info( "Inside of configuration of the different environment() method ");

    	  log.info("Operating System - " +osname + " " + "Browser Type - " + BrowserType + " " + "Environment - " + Environment + " " + "URL - " + NodeURL);
        if(driver==null) {
        if (osname.equalsIgnoreCase("Windows")) {
        	if(Environment.equalsIgnoreCase("QA"))
        {
            if (BrowserType.equalsIgnoreCase("firefox")) {
                String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/geckodriver.exe";
                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

                FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
                DesiredCapabilities desired = DesiredCapabilities.firefox();
                FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\Administrator\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\20lh8its.default-1549871597586"));
                FirefoxOptions options = new FirefoxOptions().addPreference("security.insecure_password.ui.enabled", false).addPreference("security.insecure_field_warning.contextual.enabled", false);

                desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                options.setProfile(profile);

                // options.addArguments("disable-infobars");

               // driver = new FirefoxDriver(options);
                //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                driver = ThreadGuard.protect(new FirefoxDriver(options)); 
                driver.get(NodeURL);
                driver.manage().window().maximize();
                ThreadLocalDriver.setTLDriver(driver);
                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
            }

           /*     String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                driver = new ChromeDriver();*/
            		}
        		}
        	}
        
        if(driver==null) {
            if (osname.equalsIgnoreCase("Windows")) {
            	if(Environment.equalsIgnoreCase("DEV"))
            {
                if (BrowserType.equalsIgnoreCase("firefox")) {
                    String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                    File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

                    FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
                    DesiredCapabilities desired = DesiredCapabilities.firefox();
                    FirefoxProfile profile = new FirefoxProfile(new File("D:\\Users\\pkhanna\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\1xw79wot.default"));
                    FirefoxOptions options = new FirefoxOptions().addPreference("security.insecure_password.ui.enabled", false).addPreference("security.insecure_field_warning.contextual.enabled", false);

                    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                    options.setProfile(profile);

                    // options.addArguments("disable-infobars");

                    //driver = new FirefoxDriver(options);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver = ThreadGuard.protect(new FirefoxDriver(options)); 
                    driver.get(NodeURL);
                    driver.manage().window().maximize();
                    ThreadLocalDriver.setTLDriver(driver);
	                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
	                

               /*     String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    driver = new ChromeDriver();*/
                		}
            		}
            	}
            }
        if(driver==null) {
            if (osname.equalsIgnoreCase("Windows")) {
            	if(Environment.equalsIgnoreCase("UAT"))
            {
                if (BrowserType.equalsIgnoreCase("firefox")) {
                    String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/geckodriver.exe";
                    System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                    File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

                    FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
                    DesiredCapabilities desired = DesiredCapabilities.firefox();
                    FirefoxProfile profile = new FirefoxProfile(new File("D:\\Users\\pkhanna\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\1xw79wot.default"));
                    FirefoxOptions options = new FirefoxOptions().addPreference("security.insecure_password.ui.enabled", false).addPreference("security.insecure_field_warning.contextual.enabled", false);

                    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                    options.setProfile(profile);

                    // options.addArguments("disable-infobars");

                    //driver = new FirefoxDriver(options);
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver = ThreadGuard.protect(new FirefoxDriver(options)); 
                    driver.get(NodeURL);
                    driver.manage().window().maximize();
                    ThreadLocalDriver.setTLDriver(driver);
	                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
               /*     String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    driver = new ChromeDriver();*/
                		}
            		}
            	}
            }
        if(driver==null) {
        if (osname.equalsIgnoreCase("Windows")) {
        	if(Environment.equalsIgnoreCase("QA")) {
            if (BrowserType.equalsIgnoreCase(BrowserType1)) {
                String ChromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
                //File pathBinary = new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                //chromeBinary Binary = new chromeBinary(pathBinary);
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
                options.addArguments("--start-maximized");
                //driver = new ChromeDriver(options);
                DesiredCapabilities desired = DesiredCapabilities.chrome();
              //  String chromeProfile = "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1";  
                desired.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                desired.setCapability("chrome.switches", Arrays.asList("--incognito"));
                options.addArguments("disable-infobars");
              //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                driver = ThreadGuard.protect(new ChromeDriver(options)); 
                driver.get(NodeURL);
            //    driver.manage().window().maximize();
                ThreadLocalDriver.setTLDriver(driver);
                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
           /*     String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                driver = new ChromeDriver();*/
            		}
        		}
        	}
        }
        
        if(driver==null) {
            if (osname.equalsIgnoreCase("Windows")) {
            	if(Environment.equalsIgnoreCase("DEV")) {
                if (BrowserType.equalsIgnoreCase("Chrome")) {
                    String ChromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
                    //File pathBinary = new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                    //chromeBinary Binary = new chromeBinary(pathBinary);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
                    options.addArguments("--start-maximized");
                   // driver = new ChromeDriver(options);
                    DesiredCapabilities desired = DesiredCapabilities.chrome();
                    String chromeProfile = "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1"; 
                                
                    options.addArguments("disable-infobars");
                    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
                    driver = ThreadGuard.protect(new ChromeDriver(options)); 
                    driver.get(NodeURL);
                    driver.manage().window().maximize();
                    ThreadLocalDriver.setTLDriver(driver);
                    wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
               /*     String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    driver = new ChromeDriver();*/
                		}
            		}
            	}
            }
        
        if(driver==null) {
            if (osname.equalsIgnoreCase("Windows")) {
            	if(Environment.equalsIgnoreCase("QA")) {
                if (BrowserType.equalsIgnoreCase("Chrome")) {
                    String ChromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/chromedriver.exe";
                    System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
                    //File pathBinary = new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                    //chromeBinary Binary = new chromeBinary(pathBinary);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("user-data-dir=\\10.240.50.146\\C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
                    options.addArguments("--start-maximized");
                   // driver = new ChromeDriver(options);
                    DesiredCapabilities desired = DesiredCapabilities.chrome();
                    String chromeProfile = "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1";  
                    desired.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
                    desired.setCapability("chrome.switches", Arrays.asList("--incognito"));
                    options.addArguments("disable-infobars");
                    options.setCapability("Proxy", "null");
                   // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                    driver = ThreadGuard.protect(new ChromeDriver(options)); 
                    driver.get(NodeURL);
                    driver.manage().window().maximize();
                    ThreadLocalDriver.setTLDriver(driver);
                    wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);

               /*    String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);*/
                   // driver = new ChromeDriver();
                		}
            		}
            	}
            }
        if(driver==null) {
	        if (osname.equalsIgnoreCase("Windows")) {
	        	if(Environment.equalsIgnoreCase("QA"))
	        	{
	            if (BrowserType.equalsIgnoreCase("Internet explorer")) {
	                String IEDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/IEDriverServer.exe";
	                System.setProperty("webdriver.ie.driver", IEDriverPath);
	                File pathBinary = new File("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");

	               //IEBinary chromeBinary = new ChromeBinary(pathBinary);
	                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer(); 
	                capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
	                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
	                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	                capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
	                capabilities.setCapability("allow-blocked-content", true); capabilities.setCapability("allowBlockedContent", true);
	                // WebDriver driver = new InternetExplorerDriver();
	                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	                driver = ThreadGuard.protect(new InternetExplorerDriver()); 
	                driver.get(NodeURL);
	                driver.manage().window().maximize();
	                ThreadLocalDriver.setTLDriver(driver);
	                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);

	           /*     String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
	                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	                driver = new ChromeDriver();*/
	            	}
	        	}
	        }
        }
        if(driver==null) {
	        if (osname.equalsIgnoreCase("Windows")) {
	        	if(Environment.equalsIgnoreCase("DEV"))
	        	{
	            if (BrowserType.equalsIgnoreCase("Internet explorer")) {
	                String IEDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/IEDriverServer.exe";
	                System.setProperty("webdriver.ie.driver", IEDriverPath);
	                File pathBinary = new File("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");

	               //IEBinary chromeBinary = new ChromeBinary(pathBinary);
	                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer(); 
	                capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
	                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
	                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	                capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
	                capabilities.setCapability("allow-blocked-content", true); capabilities.setCapability("allowBlockedContent", true);
	                 //WebDriver driver = new InternetExplorerDriver();
	                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	                driver = ThreadGuard.protect(new InternetExplorerDriver()); 
	                driver.get(NodeURL);
	                driver.manage().window().maximize();
	                ThreadLocalDriver.setTLDriver(driver);
	                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
	           /*     String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
	                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	                driver = new ChromeDriver();*/
	            	}
	        	}
	        }
        }
        if(driver==null) {
	        if (osname.equalsIgnoreCase("Windows")) {
	        	if(Environment.equalsIgnoreCase("UAT"))
	        	{
	            if (BrowserType.equalsIgnoreCase("Internet explorer")) {
	                String IEDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/windows/IEDriverServer.exe";
	                System.setProperty("webdriver.ie.driver", IEDriverPath);
	                File pathBinary = new File("C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe");
	               //IEBinary chromeBinary = new ChromeBinary(pathBinary);
	                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer(); 
	                capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
	                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
	                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	                capabilities.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
	                capabilities.setCapability("allow-blocked-content", true); capabilities.setCapability("allowBlockedContent", true);
	                // WebDriver driver = new InternetExplorerDriver();

	               // options.addArguments("disable-infobars");
	                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	                driver = ThreadGuard.protect(new InternetExplorerDriver()); 
	                driver.get(NodeURL);
	                driver.manage().window().maximize();
	                ThreadLocalDriver.setTLDriver(driver);
	                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);

	           /*     String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/chromedriver";
	                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	                driver = new ChromeDriver();*/
	            	}
	        	}
	        }
        }
        
        if (osname.equalsIgnoreCase("Linux")) {
            if (BrowserType.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\NagarajS\\IdeaProjects\\2_iDigiPro\\driver-servers\\geckodriver.exe");
                File pathBinary = new File("C:\\Program Files (x86)\\Firefox\\firefox.exe");

                FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
                DesiredCapabilities desired = DesiredCapabilities.firefox();
                FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\NagarajS\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\079iupvh.FirefoxProfile"));
                FirefoxOptions options = new FirefoxOptions().addPreference("security.insecure_password.ui.enabled", false).addPreference("security.insecure_field_warning.contextual.enabled", false);

                desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                options.setProfile(profile);

                // options.addArguments("disable-infobars");

                driver = new FirefoxDriver(options);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                String chromeDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/mac/chromedriver";
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                driver = new ChromeDriver();
                ThreadLocalDriver.setTLDriver(driver);
                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
                driver = ThreadGuard.protect(new FirefoxDriver(options)); 
            }
        }
        if (osname.equalsIgnoreCase("Mac")) {
            if (BrowserType.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\NagarajS\\IdeaProjects\\2_iDigiPro\\driver-servers\\geckodriver.exe");
                File pathBinary = new File("C:\\Program Files (x86)\\Firefox\\firefox.exe");

                FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
                DesiredCapabilities desired = DesiredCapabilities.firefox();
                FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\NagarajS\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\079iupvh.FirefoxProfile"));
                FirefoxOptions options = new FirefoxOptions().addPreference("security.insecure_password.ui.enabled", false).addPreference("security.insecure_field_warning.contextual.enabled", false);

                desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                options.setProfile(profile);

                options.addArguments("disable-infobars");
                
                driver = new FirefoxDriver(options);
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                String chromeDriverPath = System.getProperty("user.dir") + "//src//test//resources//drivers//windows//chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ThreadLocalDriver.setTLDriver(driver);
                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
                driver = ThreadGuard.protect(new FirefoxDriver(options)); 
               
            }
        }
        BrowserType4 = BrowserType;
        log.info(BrowserType4);
        OS = osname;
        System.out.println(OS);
        ThreadLocalDriver.setTLDriver(driver);
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
                    
       
        
    	}
        catch (Exception e){
        e.printStackTrace();
        log.error("Cant find setup for browser : " +e.getMessage() + BrowserType);
        log.error("Can't create browser ....! "+e.getMessage() + BrowserType);
        
        
        }
        
        
        
        // ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://192.168.12.78:" + portNumber + "/wd/hub"), caps));
        	
//        ThreadLocalDriver.setTLDriver( new RemoteWebDriver(new URL("192.168.56.1:" + portNumber + "/wd/hub"), caps));
        //ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://192.168.12.78:4723/wd/hub"), caps));
        //    wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
        
        
        }
        
  /* 
    public void openBrowser() throws Exception {
        // loads the config options
        //LoadConfigProperty();
        // configures the driver path
		//configureDriverPath();
        if (driver.get("browserType").equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (config.getProperty("browserType").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			options.addArguments("--disable-gpu");
//			options.addArguments("--no-sandbox");
//			options.addArguments("--disable-dev-shm-usage");
//			options.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver();
    }


*/
   /* public void maximizeWindow() {
        driver.manage().window().maximize();
    }*/

    public static void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void explicitWait(WebElement element) {
         wait = new WebDriverWait(driver, 600);
       
    }
    
    /*public Wait<WebDriver> mfluentWait(WebDriver driver) {
    	
    	Wait<WebDriver> gWait = new FluentWait<> (driver).withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofSeconds(600)).ignoring(NoSuchElementException.class);
    	

		return gWait;
    	
    }*/
    

    public void pageLoad(int time) {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

   /* public void setEnv() throws Exception {
        LoadConfigProperty();
        String baseUrl = config.getProperty("siteUrl");
        driver.get(baseUrl);
    }*/
    	static String cal1;
    	
    public static String currentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
         cal1 = dateFormat.format(cal.getTime());
        return cal1;
    }
    
    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
    	//implement.rasieFollowingValidateUser();
    	//implement.validateHTTPresponseCode(200);
    }
    
 /*   @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        openBrowser();
        maximizeWindow();
        implicitWait(30);
        deleteAllCookies();
       // setEnv();
    }*/

   /* @AfterClass(alwaysRun = true)
    public static void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
        trgtFile.getParentFile().mkdir();
        trgtFile.createNewFile();
        Files.copy(scrFile, trgtFile);

    }*/

   @AfterMethod
	public static void postCondition(ITestResult result) throws IOException, Throwable, SQLException
	{
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			String name = result.getName();
			TakesScreenshot t = (TakesScreenshot) driver;
 			File src = t.getScreenshotAs(OutputType.FILE);
 			FileUtils.copyFile(src, new File("./screenshots/"+name +".png"));
// 			implement.AddSchemaStatusFail();
// 			implement.UpdateschemaJiraStatusFail();
// 			implement.negativeorgaddJiraStatusFail();
// 			implement.AddOrgJiraStatusFail();
// 			implement.AddSchemablankvalueStatusFail();
//		       implement.AddMessageTypeStatusFail();
 			
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		   {

		       //Do something here
		       System.out.println("passed **********");
//		       implement.AddSchemaStatusPass();
//		       implement.UpdateschemaJiraStatusPass();
//		       implement.NegOrgJiraStatusPass();
//		       implement.AddOrgJiraStatusPass();
//		       implement.AddSchemablankvaluesStatusPass();
//		       implement.AddMessageTypeStatusPass();
		   }
		ThreadLocalDriver.UnSet();
		//driver.close();
	}
   



    @AfterMethod
    public static void destroyLocalDriver(){
    	BrowserType4.toString();
    	log.info("destroyLocalDriver ...!");
    	if (getDriver() != null) {
       	ThreadLocalDriver.UnSet();
		//driver.quit();
		/*getDriver().quit();*/
    	log.info("Destroyed ...!");
    	}else {
    	log.info("Not Destroyed ...is NULL ...!");
    	}
    	}



   
           // driver.quit();
            /*implement.UpdateJiraStatusPass();
        }
            else if(result.getStatus() == result.FAILURE)
            {
            	implement.UpdateJiraStatusFail();
            }*/
        

    

    /*@AfterSuite(alwaysRun = true)
    public void generateHTMLReports() throws IOException, Throwable, SQLException {
    	
     //   ReportHelper.generateCucumberReport();
    
    }*/
   /* @AfterSuite(alwaysRun = true)
    public static void closeBrowser() throws Exception{
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;
    }
*/

   /* @AfterSuite(alwaysRun = true)
    public void quit() throws IOException, InterruptedException {
        driver.quit();
    }
*/
    @AfterClass
    public void teardown () throws Exception {
    	
    	Thread.sleep(3000);
    	//driver.close();
        //driver.quit();
        Thread.sleep(5000);
    	Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f /t");
    	Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
    }
    	
    public static void NavigateURL(WebDriver driver) throws InterruptedException {
    	
    	Thread.sleep(2000);
    	
    /*	driver = new ChromeDriver();*/
        driver.manage().window().maximize();
        driver.navigate().refresh();

    	driver.get("https://qa2-iconductor.acordsolutions.net/#/login");
    }
    


    
	@AfterClass
	public static void writeExtentReport() {
		/*Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));*/
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", OS);
		//Reporter.setTestRunnerOutput("Sample test runner output message");
	    //Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 7" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	    Reporter.setSystemInfo("Browser", BrowserType4);
	    //Reporter.setTestRunnerOutput(BrowserType4);t
	    String authorname = "Pooja";
	    String authorname1 = "Khanna";
	   
	    Reporter.assignAuthor(authorname  + "\t" +  authorname1);
	    Reporter.setTestRunnerOutput("Test runner output message<br />" + "OS:"+OS + " <br /> Browser Name: "+BrowserType4);
	    Reporter.getExtentHtmlReport().setAppendExisting(true);

	  //  Reporter.addStepLog(message);
	   
	
		}
	




public static void main(String[] args) throws Exception, IOException {
	
	
	
	  try {
		  //String filePath = CommonPage.getReportConfigPath();
		  PropertyConfigurator.configure("log4j.properties");
		  log.debug("Sample debug message");
	        log.info("Sample info message");
	        log.error("Sample error message");
	        log.fatal("Sample fatal message");
		 ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		 String featurePath=".\\src\\test\\resources\\features\\ACORD.feature";
		 String [] argv = new String[]{ "-g","stepdefinition",featurePath,"--plugin","html:.\\target\\cucumber-reports\\report.html"};
		  //String [] argv = new String[]{ "-g","StepDef",featurePath,"--plugin","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-html-report"};
		  byte exitstatus = Main.run(argv, contextClassLoader);
		
		//setScenarioIndex(1);
		//setScenarioName("Scenario 1");
		//SetTestDataCollection();
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// System.out.println(GetDataFromExcel("FeatureName", 0));
	// System.out.println(GetDataFromExcel("FeatureName", 1));
	// System.out.println(GetDataFromExcel("FeatureName", 2));
}
 
}
  
  


