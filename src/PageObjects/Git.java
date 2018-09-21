package PageObjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ActionDriver.*;
import BaseDriver.Browser;
import Utilities.ExcelReader;
import Utilities.Propertie;
import Utilities.log4j;

public class Git {
	
	ExcelReader reader;
	String sheetName;
	public Git(String fileName) throws IOException 
	{
		
		Class<?> enclosingClass = getClass().getEnclosingClass();
		String className=getClass().getName();
		Propertie prop=new Propertie(System.getProperty("user.dir")+"/src/log4j.properties");
		prop.setKeyalue("log4j.appender.file.File", System.getProperty("user.dir")+"\\src\\Logs\\"+className.split("\\.")[1]+".log");
		log4j log=new log4j();
		reader=new ExcelReader(fileName);

		UDF.driver=Browser.getDriver();
		
	}
	
	
	public void gitSignUp(String SheetName) throws IOException, InterruptedException
	{
		
		
		this.sheetName=SheetName;
		String login=reader.getCellData(1, 0, sheetName);
		String email=reader.getCellData(1, 1, sheetName);;
		String password=reader.getCellData(1, 2, sheetName);;
		
		wait.waitforElementVisible(UDF.getLocator("xpath", "//*[text()='Sign up for GitHub']"));
		log4j.infoLog("wait commpleted");
		UDF.textInput("id", "user[login]",login);
		UDF.textInput("id", "user[email]",email);
		UDF.textInput("id", "user[password]",password);
		UDF.clickElement("xpath", "//*[text()='Sign up for GitHub']");
		log4j.infoLog("Account created sucesfully");
		wait.waitforElementVisible(UDF.getLocator("id", "signup_button"));
		Thread.sleep(2000);
		UDF.clickElement("id", "signup_button");
		wait.waitforElementVisible(UDF.getLocator("xpath", "//*[@class='btn btn-primary js-choose-plan-submit']"));
		UDF.clickElement("xpath", "//*[@class='btn btn-primary js-choose-plan-submit']");
		wait.waitforElementVisible(UDF.getLocator("id", "answers_98_choice_476"));
		UDF.clickElement("id", "answers_98_choice_476");
		UDF.clickElement("id", "answers_99_choice_464");
		UDF.clickElement("id", "answers_100_choice_470");
		UDF.clickElement("name", "commit");
		log4j.infoLog("commpleted git Setup");
	}
	
	private void gitSignupDetailsEnter(String SheetName) throws IOException, InterruptedException
	{
		this.sheetName=SheetName;
		String login=reader.getCellData(1, 0, sheetName);
		String email=reader.getCellData(1, 1, sheetName);;
		String password=reader.getCellData(1, 2, sheetName);;
		
		//wait.waitforElementVisible(UDF.getLocator("xpath", "//*[text()='Sign up for GitHub']"));
		Thread.sleep(3000);
		log4j.infoLog("wait commpleted");
		UDF.textInput("id", "user[login]",login);
		UDF.textInput("id", "user[email]",email);
		System.out.println(UDF.getText("xpath", "//*[@id='user[email]']/following::dd[1]"));
		UDF.textInput("id", "user[password]",password);
		Thread.sleep(2000);
		
	}
	public void gitDuplicateUserNamevalidation(String SheetName) throws IOException, InterruptedException
	{
		
				
		gitSignupDetailsEnter(SheetName);
		System.out.println(UDF.getText("xpath", "//*[@id='user[login]']/following::dd[1]"));
		Assert.assertEquals("Username is already taken", UDF.getText("xpath", "//*[@id='user[login]']/following::dd[1]"),"Comparing with Duplicate username");
	}
	
	public void gitDuplicateEmailvalidation(String SheetName) throws IOException, InterruptedException
	{
		
				
		gitSignupDetailsEnter(SheetName);
		System.out.println(UDF.getText("xpath", "//*[@id='user[email]']/following::dd[1]"));
		Assert.assertEquals("Email is invalid or already taken", UDF.getText("xpath", "//*[@id='user[email]']/following::dd[1]"),"Comparing with Duplicate username");
	}
	
	public void passwordvalidation(String SheetName) throws IOException, InterruptedException
	{		
		gitSignupDetailsEnter(SheetName);
		UDF.clickElement("xpath", "//*[text()='Sign up for GitHub']");
		log4j.infoLog("Account created sucesfully");
		wait.waitforElementVisible(UDF.getLocator("id", "signup_button"));
		Thread.sleep(3000);
		System.out.println(UDF.getText("xpath", "//*[@id='user_password']/following::dd[1]"));
		Assert.assertEquals("Password is too short (minimum is 7 characters) and has been compromised in a third party data breach", UDF.getText("xpath", "//*[@id='user_password']/following::dd[1]"),"Comparing with Duplicate username");
	}
}
