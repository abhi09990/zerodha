package Test;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.WebDriverClass;

public class ListenersClass extends WebDriverClass implements ITestListener {
	
	
	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Start"+result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		
	}

}
