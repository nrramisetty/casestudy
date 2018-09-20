package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import ActionDriver.UDF;

public class Listener implements ITestListener,ISuiteListener{
	
	public void onStart(ISuite suite) {
		System.out.println("Test suite started");
		
	}
	
	
	public void onFinish(ISuite context) {
		System.out.println("My suite is finesed");
		
	}
	
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test case started");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test case finesh");
		
	}


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test getting success" +result.getTestName());
		
	}


	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("test getting failed" +result.getTestName());
		try {
			UDF.screenShot(System.getProperty("user.dir")+"\\src\\Logs\\"+result.getName()+".PNG");
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("test skipped" +result.getTestName());
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}
	
	
}
