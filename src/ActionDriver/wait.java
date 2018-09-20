package actiondriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait extends UDF{
	
	
	public static WebDriverWait wait=new WebDriverWait(driver, 40);
	
	public static void waitforElementVisible(By by)
	{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
		
	}
	
	
	public static void waitforElementVisible(String attributType,String attributeValue)
	{
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(attributType, attributeValue)));
		
		
	}

}
