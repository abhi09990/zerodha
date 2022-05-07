package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POJO.Browser;
import POM.BuyWindow;
import POM.ForgotPasswordPage;
import POM.HomePage;
import POM.LoginPage;
import POM.SignUpPage;
import Utility.Excel;
import Utility.Reports;
import Utility.Screenshot;
import Utility.WebDriverClass;

@Listeners(ListenersClass.class)
public class LoginTestZerodha extends WebDriverClass {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public void configureExtentReports()
	{
		reports = Reports.addReports();
	}
	
	@BeforeMethod
	public void openbrowser()
	{
		driver=Browser.openbrowser("https://kite.zerodha.com/");
	}
	
	@Test
	public void loginWithVaildCridentials() throws EncryptedDocumentException, InterruptedException, IOException
	{
		test = reports.createTest("loginWithVaildCridentials");
		LoginPage obj = new LoginPage(driver);
		String ActualText = obj.getLoginText();
		String ExpectedText = "Login to Kite";// "Login to Kite"--> actual text
//		Assert.assertEquals(ActualText, ExpectedText); //stops execution immideately 
		SoftAssert softassert = new SoftAssert(); //does not stops execution but throw error at last
		softassert.assertEquals(ActualText, ExpectedText);
		String userName = Excel.getdata(0, 1, "USERNAME");
		obj.enteruserid(userName);
		String password = Excel.getdata(0, 1, "PASSWORD");
		obj.enterPassword(password);
		obj.clickOnLoginButton();
		Thread.sleep(1000);
		String pin = Excel.getdata(0, 1, "PIN");
		obj.enterPin(pin);
		obj.clickOnSubmitButton();
		softassert.assertAll();
			
		String shearname = Excel.getdata(41, 0, "SHEARNAME");
		HomePage obj1 = new HomePage(driver);
		Thread.sleep(1000);
		obj1.clickOnSearchBox(shearname);
		obj1.clickOnAddtowatchlist();
		Thread.sleep(1000);
		obj1.buyButton(driver, shearname);
		Thread.sleep(3000);
		
		BuyWindow obj2 = new BuyWindow(driver);	
		String exchange =Excel.getdata(2, 0, "EXCHANGE");
		obj2.clickOnExchange(driver, exchange);
		System.out.println(exchange);
		String order = Excel.getdata(1, 0,"ORDERTYPE");		
		obj2.clickOnOrderType(driver, order);
		
		Thread.sleep(2000);
		String inv = Excel.getdata(2, 0,"INVESTMENT");
		obj2.clickOnInvestmentType(driver, inv );
		Thread.sleep(2000);
		obj2.enterRequiredQuentity("10");
		Thread.sleep(2000);
		String price = Excel.getdata(1, 0, "PRICETYPE");		
		obj2.clickOnPriceType(driver, price);
		Thread.sleep(1000);
		obj2.clickOnBuy();
	}
	
	@Test
	public void forgotPassword()
	{
		test = reports.createTest("forgotPassword");
		ForgotPasswordPage obj = new ForgotPasswordPage(driver);
		obj.clickOnForgot();
	}
	@Test
	public void signUpPage()
	{
		test = reports.createTest("signUpPage");
		SignUpPage obj = new SignUpPage(driver);
		obj.clickOnSignup(driver);
	}
	
	
	@AfterMethod
	public void Screenshot(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else
		{
			test.log(Status.SKIP, result.getName());
		}
		
		Screenshot.get_Screenshot(driver, "zerodha");
	}
	
	@AfterClass
	public void flushResult()
	{
		reports.flush();
	}
	
	
}
