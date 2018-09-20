package businessscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basedriver.Browser;
import pageobjects.Git;
import utilities.ExcelReader;
import utilities.log4j;

public class GitSignUP {

	@Test
	public void gitHubUserRegistration()
	{	
		try{
			String fileName=System.getProperty("user.dir")+"\\src\\TestData\\Registration.xlsx";
			Git git=new Git(fileName);
			git.gitSignUp("signIN");
	
		}
		catch (Exception e) {

			log4j.errorLog("getting error"+e.toString());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@BeforeTest
	public void startBrowser()
	{
		Browser.StartBrowser("chrome", "https://github.com/");
	}
	
	
	@AfterTest
	public void closeBroswe()
	{
		Browser.closeBrowser();
	}
}