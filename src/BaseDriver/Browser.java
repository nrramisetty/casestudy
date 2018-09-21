package BaseDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	
	public static WebDriver driver;
	
	public static WebDriver StartBrowser(String browserName,String URL)
	{
		if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/lib/chromedriver.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("filefox"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/lib/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/lib/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
		
	}

}
