 package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement forgot;
	
	public ForgotPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnForgot()
	{
		forgot.click();
	}
	
}
