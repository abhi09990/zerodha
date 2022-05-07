package Utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	public static void get_Screenshot(WebDriver driver, String name) throws IOException
	{ 
		String d= DateTime.getDateTime();
		
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		File destination = new File("G:\\Automation\\ZerodhaAutomation\\ScreenShot\\"+name+""+d+".jpeg");
	
		FileHandler.copy(source, destination);
	}

}
