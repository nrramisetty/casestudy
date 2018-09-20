package pageobjects;

import java.io.FileNotFoundException;
import java.io.IOException;

import actiondriver.*;
import utilities.ExcelReader;
import utilities.log4j;

public class Git {
	
	ExcelReader reader;
	String sheetName;
	public Git(String fileName) throws IOException 
	{
		
		log4j log=new log4j();
		reader=new ExcelReader(fileName);
		
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
}
