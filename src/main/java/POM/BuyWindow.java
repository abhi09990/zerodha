package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyWindow {
	WebDriver driver;
	@FindBy(xpath="//div[@class='exchange-selector']//label")private List<WebElement> exchange;
	@FindBy(xpath="//label[@class='su-radio-label']")private List<WebElement> orderType; // need to find for fund too
	@FindBy(xpath="//div[@class='product row']//label//span")private List<WebElement> investmentType;
	@FindBy(xpath="//input[@label='Qty.']")private WebElement quentity;
	@FindBy(xpath="//div[@tooltip-pos='down']")private List<WebElement> price;	
	@FindBy(xpath="//button[@class='submit']")private WebElement buy;
	@FindBy(xpath="//button[@class='button-outline cancel']")private WebElement cancle;
	public BuyWindow(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnExchange(WebDriver driver, String exc) throws InterruptedException
	{
		for(int i=0; i<exchange.size(); i++)
		{
			if(exchange.get(i).getText().equalsIgnoreCase(exc))
			{	
				exchange.get(i).click();
				System.out.println(exc);
//				Thread.sleep(2000);				
//				driver.findElement(By.xpath("//label[@class='su-radio-label']")).click();				
			}
		}
	}
	public void clickOnOrderType(WebDriver driver, String text) throws InterruptedException
	{
		for(int i=0; i<orderType.size(); i++)
		{
			if(orderType.get(i).getText().equalsIgnoreCase(text))
			{	
				orderType.get(i).click();
				System.out.println(text);
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//label[@class='su-radio-label']")).click();				
			}
		}
	}
	
	public void clickOnInvestmentType(WebDriver driver, String invType)
	{
		for(int i=0; i<investmentType.size(); i++)
		{
			if(investmentType.get(i).getText().equalsIgnoreCase(invType))
			{
				investmentType.get(i).click();
				System.out.println(invType);

//				driver.findElement(By.xpath("//label[@class='su-radio-label']")).click();
			}
		}
		
	}
	
	public void clickOnPriceType(WebDriver driver, String priceType)
	{
		for(int i=0; i<price.size(); i++)
		{
			if(price.get(i).getText().equalsIgnoreCase(priceType))
			{
				price.get(i).click();
				System.out.println(priceType);
//				driver.findElement(By.xpath("//label[@class='su-radio-label']")).click();
			}
		}
	}
	
	public void enterRequiredQuentity(String qty)
	{
		quentity.sendKeys(qty);
	}
	
	public void clickOnBuy()
	{
		buy.click();
	}
	
	public void clickOnCancle()
	{
		cancle.click();
	}
	
}
