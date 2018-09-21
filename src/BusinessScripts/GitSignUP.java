package BusinessScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseDriver.Browser;
import PageObjects.Git;
import Utilities.ExcelReader;
import Utilities.log4j;

public class GitSignUP {
	
	String fileName=System.getProperty("user.dir")+"\\src\\TestData\\Registration.xlsx";
	@Test(priority=1)
	public void gitHubUserRegistration()
	{	
		try{
			
			Git git=new Git(fileName);
			git.gitSignUp("signIN");
	
		}
		catch (Exception e) {

			log4j.errorLog("getting error"+e.toString());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void gitHubDuplicateUserNameDetails()
	{	
		try{
			Git git=new Git(fileName);
			git.gitDuplicateUserNamevalidation("signIN");
	
		}
		catch (Exception e) {

			log4j.errorLog("getting error"+e.toString());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=3)
	public void gitHubDuplicateEmailNameDetails()
	{	
		try{
			Git git=new Git(fileName);
			git.gitDuplicateEmailvalidation("signIN");
	
		}
		catch (Exception e) {

			log4j.errorLog("getting error"+e.toString());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=4)
	public void gitHubPasswordValidation()
	{	
		try{
			Git git=new Git(fileName);
			git.passwordvalidation("Password_Invalid");
	
		}
		catch (Exception e) {

			log4j.errorLog("getting error"+e.toString());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@BeforeMethod
	public void startBrowser()
	{
		Browser.StartBrowser("chrome", "https://github.com/");
	}
	
	
	@AfterMethod
	public void closeBroswe()
	{
		Browser.closeBrowser();
	}
}
