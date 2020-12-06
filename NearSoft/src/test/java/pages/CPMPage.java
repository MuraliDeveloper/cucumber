package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.internal.annotations.DataProviderAnnotation;

import main.CucumberRunner;
import Utility.TestUtil;

import net.bytebuddy.asm.Advice.Exit;

import static java.lang.System.out;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPMPage extends BasePage{
	
	//PageFactory or OR
	
	
	//Code to initialize advanced button
	
	
	@FindBy(xpath="//button[contains(text(),'Advanced')]")
	WebElement advanced;
	
	

	
	//Code to initialize Userid
	@FindBy(name="userNameSet")
	WebElement username;
	
	
	
	
	//Code to initialize FirstName
	@FindBy(id="inputFirstname")
	WebElement firstname;
	@FindBy(xpath="//input[@id='inputFirstname']/following-sibling::div/div")
	WebElement validateerrorfirstname;
	
	
	

	//Code to initialize LastName
	@FindBy(id="inputLastname")
	WebElement lastname;
	@FindBy(xpath="//div[contains(text(),'Please enter last name')]")
	WebElement validateerrorlastname;

	
	
	
	//Code to initialize AddressLine1
	@FindBy(id="inputAddressLine1")
	WebElement addressline1;
	@FindBy(xpath="//div[contains(text(),'Please enter address line 1')]")
	WebElement validateerroraddressline1;
	
	
	
	
	//Code to initialize AddressLine2
	@FindBy(id="inputAddressLine2")
	WebElement addressline2;
	
	
	
	
	//Code to initialize City
	@FindBy(id="inputCity")
    WebElement city;
	@FindBy(xpath="//div[contains(text(),'Please enter city')]")
	WebElement validateerrorcity;
	
	
	
	
	//Code to initialize State
	@FindBy(xpath="//*[@id=\"collapseRequestForm\"]/form/div[3]/div[4]/p-dropdown/div/label/span")
    WebElement state;
	@FindBy(xpath="//input[contains(@class,'ui-dropdown-filter')]")
    WebElement filter;
	@FindBy(xpath="//div[contains(text(),'Please select state')]")
	WebElement validateerrorstate;
	
	
	
	
	//Code to initialize ZipCode
	@FindBy(id="inputZipCode")
    WebElement zipcode;
	@FindBy(xpath="//div[contains(text(),'Please enter ZIP code')]")
	WebElement validateerrorzipcode;
	
	
	
	
	//Code to initialize PhoneNumber
	@FindBy(id="inputContactNumber")
    WebElement phonenumber;
	
	
	
	
	//Code to initialize EmailId
	@FindBy(id="inputConsumerEmailId")
    WebElement emailid;	
	@FindBy(xpath="//div[contains(text(),'Please enter valid email id')]")
	WebElement validateerroremailid;
	
	
	
	//Code to initialize client
	@FindBy(xpath="//*[@id=\"collapseRequestForm\"]/form/div[5]/div[4]/p-dropdown/div/label/span")
    WebElement client;	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement YesButton;
	
	
	
	
	//Code to initialize Request Type		
	@FindBy(xpath="//input[(@name='requestType') and (@type='checkbox') and (@value='access')]")
	//@FindBy(xpath="//input[(@name='requestType') and (@type='checkbox')]") 
	WebElement requesttype;	
	
	@FindBy(xpath="//input[(@name='requestType') and (@type='checkbox') and (@value='delete')]")
	//@FindBy(xpath="//input[(@name='requestType') and (@type='checkbox')]") 
	WebElement requesttype1;	
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement ModalYesBtn;
	
	
	
	
	//Code to initialize System
	@FindBy(xpath="//*[@id=\"collapseRequestForm\"]/form/div[7]/div/span/div[1]/div/div[1]/div/p-dropdown/div/label/span")
    WebElement system;
	
	
	
	
	//Code to initialize ProductCode
	@FindBy(xpath="//*[@id=\"collapseRequestForm\"]/form/div[7]/div/span/div[1]/div/div[2]/div/p-multiselect/div")
    WebElement productcode;	
	
	@FindBy(xpath="//input[@role='textbox']")
    WebElement ProductCodeSearch;
	
	@FindBy(xpath="//div[contains(@class,'ui-chkbox-box ui-widget ui-corner-all')]")
    WebElement ProductCodeAllCheckbox;	
	
	//@FindBy(xpath="//li[@class='ui-multiselect-item ui-corner-all']/div/div")
	@FindBy(xpath="/html/body/div/div[2]/ul/p-multiselectitem[3]/li/div/div")
	WebElement productcodemul;	
	
	@FindBy(xpath="//a[contains(@class,'ui-multiselect-close')]")
	WebElement close;
	
	
	
	
	
	//AccountNumber
	@FindBy(id="inputAccountNo")
	WebElement AccountNo;
	
	
	
	//Submit
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	
	
	
	//Get request id number as output
	@FindBy(xpath="//strong")
	WebElement GetRequestid;
	
	@FindBy(xpath="//button[text()='Ok']")
	WebElement okbutton;
	
	@FindBy(xpath="//input[@placeholder='search by request id']")
	WebElement searchrequestid;
	
	@FindBy(xpath="//img[contains(@src,'refresh')]")
	WebElement refresh;
	
	@FindBy(xpath="//div[contains(@class,'ui-table-wrapper')]/table/thead")
	WebElement tableReqSummThead;
	@FindBy(xpath="//div[contains(@class,'ui-table-wrapper')]/table/tbody")
	WebElement tableReqSummBody;
	
	
	
	//initializing the pageobjects
	public CPMPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
//
//	public boolean ValidateCPMUseridFieldEditable()
//	{
//		return username.isEnabled();
//	}
//	
//	public void EnterUserName(String userid)
//	{
//		username.sendKeys(userid);
//		username.sendKeys(Keys.ENTER);
//	}
//		
	public String ValidateCCPAPageTitle()
	{
		//verifyTitle("CDSGlobal CCPA");
		System.out.println("Title fetching");
		return driver.getTitle();
	}
	
	public void ValidateFirstNameErrorMessage(boolean boolstr)
	{
		Assert.assertEquals(validateerrorfirstname.isDisplayed(), true);
		String ErrorText = validateerrorfirstname.getText();
		boolean msg = ErrorText.contains("Please enter first name without <> ? % * ( ) � � ; & +�");
		Assert.assertEquals(msg, true);
		
	}
	
	public void ValidateLastNameErrorMessage(boolean boolstr)
	{
		Assert.assertEquals(validateerrorlastname.isDisplayed(), true);
		String ErrorText = validateerrorlastname.getText();
		boolean msg = ErrorText.contains("Please enter last name without <> ? % * ( ) � � ; & +�");
		Assert.assertEquals(msg, true);
		
	}

	
	public void CreateNewCPMFormCheckFirstNameError(String FirstName,String LastName) throws InterruptedException, IOException
	{
		
		firstname.sendKeys(FirstName);
		Thread.sleep(1000);
				
		lastname.sendKeys(LastName);
		
		
		boolean boolfn= TestUtil.getSpecialCharacterCount(FirstName);
		if (boolfn)
		{
			Thread.sleep(1000);
			ValidateFirstNameErrorMessage(boolfn);	
			TestUtil.TakeScreenshot(driver,"ValidateFirstNameError");
			//driver.quit();
		
		}
	}
	public void CreateNewCPMFormCheckLastNameError(String FirstName, String LastName, String AddressLine1) throws InterruptedException, IOException
	{
		firstname.sendKeys(FirstName);
		Thread.sleep(1000);
				
		lastname.sendKeys(LastName);
		Thread.sleep(1000);
		addressline1.sendKeys(AddressLine1);
		
		
		boolean boolfn1= TestUtil.getSpecialCharacterCount(LastName);
		if (boolfn1)
		{
			Thread.sleep(1000);	
			ValidateLastNameErrorMessage(boolfn1);
			TestUtil.TakeScreenshot(driver,"ValidateLastNameError");
			//driver.quit();	
			//Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		}
	}
	
	
	
	public String CreateNewCPMForm(String FirstName,String LastName, String AddressLine1, String AddressLine2,String City,String State, String ZipCode, String PhoneNumber, String Emailid, String Client, String RequestType, String System, String ProdCodeItem, String AccountNumber) throws InterruptedException, IOException
	{
			
		firstname.sendKeys(FirstName);
		Thread.sleep(1000);
				
		lastname.sendKeys(LastName);
		Thread.sleep(1000);
		/*
		boolean boolfn= TestUtil.getSpecialCharacterCount(FirstName);
		if (boolfn)
		{
			Thread.sleep(4000);
			ValidateFirstNameErrorMessage(boolfn);	
			TestUtil.TakeScreenshot(driver,"ValidateFirstNameError");
			driver.quit();
			//Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		}
		*/
			
		addressline1.sendKeys(AddressLine1);
		Thread.sleep(2000);
		/*
		
		boolean boolfn1= TestUtil.getSpecialCharacterCount(LastName);
		if (boolfn1)
		{
			Thread.sleep(4000);	
			ValidateLastNameErrorMessage(boolfn1);
			driver.quit();	
			//Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
		}*/
		
			
		
		addressline2.sendKeys(AddressLine2);	
		Thread.sleep(1000);
		city.sendKeys(City);
		Thread.sleep(1000);
		state.click();
		Thread.sleep(1000);
		filter.sendKeys(State);
		Thread.sleep(1000);
		filter.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		filter.sendKeys(Keys.ENTER);
		state.click();
		Thread.sleep(1000);
		state.click();
		Thread.sleep(1000);
		zipcode.sendKeys(ZipCode);
		Thread.sleep(1000);
		phonenumber.sendKeys(PhoneNumber);
		Thread.sleep(1000);
		emailid.sendKeys(Emailid);	
		Thread.sleep(1000);
		client.click();
		Thread.sleep(1000);
		filter.sendKeys(Client);
		Thread.sleep(1000);
		filter.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(1000);
		filter.sendKeys(Keys.ENTER);
		if (YesButton.isDisplayed()==true)
		{
		YesButton.click();
		}
		client.click();
		Thread.sleep(1000);
		client.click();
		Thread.sleep(1000);
	
		SelectRequestType(RequestType);
		Thread.sleep(1000);

		HandleMultipleLineItems(System, ProdCodeItem, AccountNumber,Emailid);
		//TakeScreenshot(driver,"MultipleLineItems");	
		TestUtil.ScrollIntoView(driver,submit);
          
		Thread.sleep(1000);
		submit.click();
		Thread.sleep(3000);
		String requestidout = GetRequestid.getText();
		TestUtil.TakeScreenshot(driver,"RequestIdOutput");	
		//TestUtil.takeScreenshotAtEndOfTest();
		okbutton.click();
		Thread.sleep(1000);
		return requestidout;
				
	}
	

	
	public void HandleMultipleLineItems(String System, String ProdCodeItem, String AccountNumber, String Emailid) throws InterruptedException
	{
		
		String[] arrSys = System.split(";");
		String[] arrProCodeItem = ProdCodeItem.split(";");	
		String[] arrAccNo = AccountNumber.split(";");
		
		
		
		for (int i=1;i<=arrSys.length;i++)
		{
		
			if (i!=arrSys.length)
			{
			WebElement Plus = driver.findElement(By.xpath("(//img[@title='add'])["+i+"]"));
			Plus.click();
			}
			Thread.sleep(1000);
		
			//Enter System
			WebElement system1 = driver.findElement(By.xpath("(//label[@for='inputSystem']/following-sibling::p-dropdown/div)["+i+"]"));
			TestUtil.ScrollIntoView(driver,system1);
			
			system1.click();
			Thread.sleep(1000);	
			filter.sendKeys(arrSys[i-1]);
			Thread.sleep(1000);
			filter.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
			filter.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			
			//Enter Product Code
			WebElement ProCode1 = driver.findElement(By.xpath("(//label[@for='inputCode']/following-sibling::p-multiselect/div)["+i+"]"));
			ProCode1.click();
			Thread.sleep(1000);
			SelectProdCodeItemCheckbox(arrProCodeItem[i-1]);
					
			Thread.sleep(1000);
			close.click();
			Thread.sleep(1000);
			boolean test = arrSys[i-1].equalsIgnoreCase("eHub");
			if (test)
			{
				
				Thread.sleep(1000);
			}
			else
			{
			//Enter Account Number
			WebElement AccNo1 = driver.findElement(By.xpath("(//label[@for='inputAccountNo']/following-sibling::input)["+i+"]"));
			AccNo1.click();
			AccNo1.sendKeys(arrAccNo[i-1]);	
			Thread.sleep(1000);
			}
		}
	}
	
	public void SelectRequestType(String strReqType) throws InterruptedException
	{
		WebElement reqtype= driver.findElement(By.xpath("//input[@name='requestType' and @value='"+strReqType+"']"));
		reqtype.click();
		Thread.sleep(3000);
	
		WebElement element = driver.findElement(By.xpath("//div[@id='req_type_modal']//button[text()='Yes']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
	}
	
	public void SelectProdCodeItemCheckbox(String ProdCodeItem)
	{
		String[] arrPCItem = ProdCodeItem.split(",");
		for (int i=0;i<arrPCItem.length;i++)
		{
		 WebElement PCItem = driver.findElement(By.xpath("//li[contains(@aria-label,'"+arrPCItem[i]+"')]/div/div"));
		 PCItem.click();
		}
	}
		
	
	
	
	public void ValidateRequestIsVisible(String requestid,String ExpClient, String ExpConsName, String ExpReqType) throws InterruptedException
	{
		Thread.sleep(4000);
	          
	   //This will scroll the page till the element is found
		TestUtil.ScrollIntoView(driver, refresh);	  
		refresh.click();
		Thread.sleep(1000);
		System.out.println(requestid);
		searchrequestid.sendKeys(requestid);
	
		Thread.sleep(3000);
		
		List <WebElement> rows_thead = tableReqSummThead.findElements(By.tagName("tr"));
		int row_count = rows_thead.size();
		List <WebElement> cols_thead = rows_thead.get(0).findElements(By.tagName("th"));
		int cols_count = cols_thead.size();
		List <WebElement> rows_body = tableReqSummBody.findElements(By.tagName("tr"));
		int row_bodycount = rows_body.size();
		List <WebElement> cols_body = rows_body.get(0).findElements(By.tagName("td"));
		int cols_bodycount = cols_body.size();
		
		int colbody=0;
		OUTER_LOOP:			
		for (int col=0;col<cols_count;col++)
		{			
			String CellText = cols_thead.get(col).getText();
			while (colbody<cols_bodycount)
			{
			
			colbody++;
			//for (int colbody=0;colbody<cols_bodycount;colbody++)
			{
				
				if (CellText.contains("Client"))
				{
					String ActualClient = cols_body.get(0).getText();
					Assert.assertEquals(ActualClient, ExpClient);
					System.out.println("The value of client is "+ActualClient+" which is equal to expected client "+ExpClient);
					
					break;// OUTER_LOOP ;
					
				}
				
				if (CellText.contains("Request Id"))
				{
					String Actualreqid = cols_body.get(colbody-1).getText();
					Assert.assertEquals(Actualreqid, requestid);
					System.out.println("The value of request id is "+Actualreqid+" which is equal to expected request id "+requestid);
					
					break; //OUTER_LOOP ;
					
					
				}
				
				if (CellText.contains("Consumer Name"))
				{
					String ActualConsName = cols_body.get(colbody-1).getText();
					Assert.assertEquals(ActualConsName, ExpConsName);
					System.out.println("The value of Consumer Name is "+ActualConsName+" which is equal to expected Consumer Name "+ExpConsName);
					
					break;// OUTER_LOOP ;
					
				}
				
				if (CellText.contains("Request Type"))
				{
					String ActualReqType = cols_body.get(colbody-1).getText();
					Assert.assertEquals(ActualReqType, ExpReqType);
					System.out.println("The value of Request Type is "+ActualReqType+" which is equal to expected request type "+ExpReqType);
					
					break OUTER_LOOP ;
					
				}
			}
			
			}	
		
		}
	
		
	}

}
	
	