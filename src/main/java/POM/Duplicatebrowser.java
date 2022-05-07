package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Duplicatebrowser {

	public static WebDriver openbrowser(String url)
	{
		ChromeOptions options = new ChromeOptions();	
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "G:\\Automation\\ZerodhaAutomation\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
}
