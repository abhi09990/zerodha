package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
	
	public static ExtentReports addReports()
	{
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("extentReport.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("Environment", "SIT");
		reports.setSystemInfo("Testing", "Functional");
		return reports;	
	}

}
