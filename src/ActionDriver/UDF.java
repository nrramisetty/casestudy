package ActionDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import BaseDriver.Browser;

public class UDF {
	
	public static WebDriver driver=Browser.getDriver();
	
	public static By getLocator(String attributType,String attributeValue)
	{
		if(attributType.equalsIgnoreCase("id"))
		{
			return By.id(attributeValue);
		}
		if(attributType.equalsIgnoreCase("name"))
		{
			return By.name(attributeValue);
		}
		if(attributType.equalsIgnoreCase("className"))
		{
			return By.className(attributeValue);
		}
		if(attributType.equalsIgnoreCase("xpath"))
		{
			return By.xpath(attributeValue);
		}
		if(attributType.equalsIgnoreCase("linkText"))
		{
			return By.linkText(attributeValue);
		}
		if(attributType.equalsIgnoreCase("partialLinkText"))
		{
			return By.partialLinkText(attributeValue);
		}
		if(attributType.equalsIgnoreCase("css"))
		{
			return By.cssSelector(attributeValue);
		}
		
		if(attributType.equalsIgnoreCase("tagName"))
		{
			return By.tagName(attributeValue);
		}
		return null;
		
	}
	

	
	public static WebElement getWebElement(String attributType,String attributeValue)
	{
		return driver.findElement(getLocator(attributType, attributeValue));
	}
	
	
	public static List<WebElement> getWebElements(String attributType,String attributeValue)
	{
		return driver.findElements(getLocator(attributType, attributeValue));
	}
	
	public static void textInput(String attributType,String attributeValue,String inputValue)
	{
		getWebElement(attributType, attributeValue).clear();
		getWebElement(attributType, attributeValue).sendKeys(inputValue);
		
	}
	
	public void sample()
	{
		System.out.println("sample");
	}
	
	
	public static void clickElement(String attributType,String attributeValue)
	{
		getWebElement(attributType, attributeValue).click();
	}
	
	public static String getText(String attributType,String attributeValue)
	{
		return getWebElement(attributType, attributeValue).getText();
	}
	
	public static void screenShot(String fileName) throws WebDriverException, IOException
	{
		FileUtils.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),new File(fileName));
		
		
	}
	

}
