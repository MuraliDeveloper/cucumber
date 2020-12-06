//package stepdefinition;
//
//import java.sql.Date;
//
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.time.LocalDate;
//import java.sql.Date;
//
//import org.apache.commons.io.FileUtils;
////import org.openqa.selenium.By;
////import org.openqa.selenium.WebElement;
//
//import java.sql.*;
//
//import static org.testng.Assert.assertTrue;
//
//import java.io.*;
//import java.lang.reflect.Method;
//import java.util.*;
//import java.util.logging.*;
//
////import com.mysql.cj.xdevapi.Statement;
//
//import cucumber.api.java.en.When;
///*import main.TestListener;*/
//import main.CucumberRunner;
//import main.ExtentCucumberFormatter;
///*import main.ExtentTestManager;*/
///*import main.TestListener;*/
//import main.ThreadLocalDriver;
//
//import pages.CPMPage;
//
//import org.testng.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.fasterxml.jackson.databind.deser.Deserializers.Base;
//
//import com.mongodb.connection.Connection;
//
//import Utility.TestUtil;
//
///**
// * 
// * @author Pooja Khanna
// * @version 1.0
// * @since 03/04/2020 /* Change History
// *        *********************************************************************************
// *        Version Date Defect/Task ID changed by Description
// ***********************************************************************************
// * 
// ***********************************************************************************
// */
//
//@SuppressWarnings("unused")
//public class ExpediaStepDef extends CucumberRunner {
//
//	public WebDriver driver = null;
//
//	public ExpediaStepDef() {
//		driver = CucumberRunner.getDriver();
//		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
//	}
//
//	static Logger log = Logger.getLogger(CucumberRunner.class.getName());
//
//	CPMPage page = new CPMPage(driver);
//	CCPAPageTest test = new CCPAPageTest();
//	String sheetName="CCPA";
//	@DataProvider
//	public Object[][] getCCPATestData()
//	{
//		Object data[][] = TestUtil.getTestData(sheetName);
//		return data;
//	}
//	
//	@Test (priority=1, dataProvider="getCCPATestData")
//	@Then("^Validation of the permitted value with result is being printed in excel sheet \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
//	public void CCPAPageTitleTest(String Flag, String FirstName, String LastName, String AddressLine1,
//			String AddressLine2, String City, String State, String ZipCode, String PhoneNumber, String Emailid,
//			String Client, String RequestType, String System, String ProductCodeItem, String AccountNumber)
//			throws InterruptedException, IOException {
//
//		test.CCPAPageTitleTest(Flag, FirstName, LastName, AddressLine1, AddressLine2, City, State, ZipCode, PhoneNumber,
//				Emailid, Client, RequestType, System, ProductCodeItem, AccountNumber);
//
//	}
//
//	@Test(invocationCount = 1, threadPoolSize = 2)
//	@Given("^User provide details for fields$")
//	public void formenter()  {
//	
//		System.out.println("User enters details");
//			
//
//	}
//
//	@Test
//	@When("^User enters multiple set of values$")
//	public void entervalues() {
//		// TODO Auto-generated method stub
//		System.out.println("Filling data ");
//
//	}
//}
