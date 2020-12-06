package stepdefinition;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.CucumberRunner;
import main.ThreadLocalDriver;
import pages.BasePage;
import pages.CPMPage;
import Utility.MultipleDataProvider;
import Utility.TestUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CCPAPageTest extends CucumberRunner {
	
	public CCPAPageTest() {
		driver = CucumberRunner.getDriver();
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}

	BasePage page1 = new BasePage(driver);
	CPMPage cpmpage = new CPMPage(driver);
	String sheetName="CCPA";
	public static String RequestType;
	
	
	
//	@DataProvider
//	public Object[][] getCCPATestData()
//	{
//		Object data[][] = TestUtil.getTestData(sheetName);
//		return data;
//	}
	
	@DataProvider(name="BuildData")
	public Object[][] createdata()throws Exception
    {	
        Object[][] obj =MultipleDataProvider.getDataFromDataprovidercol("Copy of Test Cases_QA_Dep_02032020.xlsx", "Test data2", 5) ;
        return obj;              
    }

	
	@Test (priority=1, dataProvider="BuildData")
	@Then("^Validation of the permitted value with result is being printed in excel sheet  \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void CCPAPageTitleTest(String FirstName,String LastName, String AddressLine1, String AddressLine2,String City/*String State, String ZipCode, String PhoneNumber, String Emailid, String Client, String RequestType, String System, String ProductCodeItem,String AccountNumber*/) throws InterruptedException, IOException
	{
		//int flag=Integer.parseInt(Flag);
	//	Object[][] obj =MultipleDataProvider.getDataFromDataprovidercol("Copy of Test Cases_QA_Dep_02032020.xlsx", "Test data2", 5) ;
        
		

		
		//Validate PageTitle
		
		
		
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//*[@formcontrolname='first_name']"))));
		WebElement el =driver.findElement(By.xpath("//*[@formcontrolname='first_name']"));
		el.getSize();
		pageLoad(40);
		page1.verifyTitle("CDSGlobal CCPA");
		
//		boolean userideditable = CPMPage.ValidateCPMUseridFieldEditable();
//		Assert.assertEquals(userideditable, true);
//		
		
		
		cpmpage.CreateNewCPMFormCheckFirstNameError(FirstName, LastName);
		
		cpmpage.CreateNewCPMFormCheckLastNameError(FirstName,LastName, AddressLine1);
		
		//Fill the CPM Form and Submit the form
		//String requestno = cpmpage.CreateNewCPMForm(FirstName, LastName, AddressLine1, AddressLine2, City, State, ZipCode, PhoneNumber, Emailid, Client, RequestType, System, ProductCodeItem,  AccountNumber);
	
		String ExpConsName = FirstName+" "+LastName;
		
		//Validate request is available
	//	cpmpage.ValidateRequestIsVisible(requestno,Client,ExpConsName,RequestType);
		}
	
	

	@Test(invocationCount = 1, threadPoolSize = 2)
	@Given("^User provide details for fields$")
	public void formenter()  {
	
		System.out.println("User enters details");
			

	}

	@Test
	@When("^User enters multiple set of values$")
	public void entervalues() {
		// TODO Auto-generated method stub
		System.out.println("Filling data ");

	}

	/*@Test (priority=1, dataProvider="getCCPATestData")
	public void ValidateCCPAPageFields(String FirstName,String LastName, String AddressLine1) throws InterruptedException
	{
		//Validate PageTitle
		String title = CPMPage.ValidateCCPAPageTitle();
		Assert.assertEquals(title, "CDSGlobal CCPA");
		
		//Validate username field is editable or not
		boolean userideditable = CPMPage.ValidateCPMUseridFieldEditable();
		Assert.assertEquals(userideditable, true);
		
		//Enter Username field
		CPMPage.EnterUserName(prop.getProperty("username"));
		
		CPMPage.EnterFirstlastAddress(FirstName, LastName, AddressLine1);
		
		Thread.sleep(2000);
		
		boolean boolfn= CPMPage.getSpecialCharacterCount(FirstName);
		if (boolfn)
		CPMPage.ValidateFirstNameErrorMessage(boolfn);
		
	}*/
	
    @AfterMethod
	public void tearDown() {
		driver.quit();
    }

}
