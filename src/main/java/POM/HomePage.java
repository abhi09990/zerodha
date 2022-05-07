package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//input[@icon='search']")private WebElement searchbox;
	@FindBy(xpath="(//span[@class='tradingsymbol'])[1]")private WebElement addToWatchlist;
	@FindBy(xpath="//span[@class='symbol']//span//span")private List<WebElement> buyShearButton;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnSearchBox(String name)//enter the shearname
	{
		searchbox.sendKeys(name);
	}

	public void clickOnAddtowatchlist()
	{
		addToWatchlist.click();
	}
	public void buyButton(WebDriver driver, String shearname) throws InterruptedException
	{
		
		for(int i=0; i<buyShearButton.size(); i++)
		{
			if(buyShearButton.get(i).getText().equalsIgnoreCase(shearname))
			{	
				buyShearButton.get(i).click();
				Thread.sleep(2000);
				WebElement clickonbuy = driver.findElement(By.xpath("//button[@class='button-blue buy']"));
				clickonbuy.click();				
			}
		}
	}	
}

