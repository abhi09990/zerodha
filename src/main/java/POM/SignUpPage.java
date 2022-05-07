package POM;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement signup;
	
	
	public SignUpPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignup(WebDriver driver)
	{
		signup.click();
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		WebElement mobileNo =driver.findElement(By.xpath("//input[@id='user_mobile']"));
		mobileNo.sendKeys("8862008131");
	}
}
