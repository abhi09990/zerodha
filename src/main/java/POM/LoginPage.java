package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//div[@class='form-header text-center']")private WebElement loginText;
	@FindBy(xpath="//input[@label='User ID']")private WebElement userId;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//button[@type='submit']")private WebElement login;
	@FindBy(xpath="//input[@label='PIN']")private WebElement pin;
	@FindBy(xpath="//button[@type='submit']")private WebElement submit;
	
	public LoginPage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getLoginText()
	{
		return loginText.getText();
	}
	public void enteruserid(String id)
	{
		userId.sendKeys(id);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickOnLoginButton()
	{
		login.click();
	}
	public void enterPin(String pinid)
	{
		pin.sendKeys(pinid);
	}
	public void clickOnSubmitButton()
	{
		submit.click();
	}
	
}

