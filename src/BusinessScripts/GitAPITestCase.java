package BusinessScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import APITests.RestTest;

public class GitAPITestCase {

	static RestTest api;
	
	
	//basic authentication Validation
	
	@Test
	public void gitWithBasicAuthenticationValidations() throws FileNotFoundException, IOException
	{	
		System.out.println("-------Start of Test gitWithBasicAuthenticationValidations--------------");
		api=new RestTest();
		Response responce=api.restGet("?access_token=086e41f2f6410a314c5e6e6ae7941d1f4a0ca8e8");
		System.out.println("Status code is : "+responce.getStatusCode());
		System.out.println(responce.asString());
		Assert.assertEquals(responce.getStatusCode(),200,"Authentication status");

	}

	//Validate the url with state=open and verifing the response
	
	@Test
	public void gitWithOpenState() throws FileNotFoundException, IOException
	{	
		System.out.println("-------Start of Test gitWithOpenState--------------");
		api=new RestTest();
		Response responce=api.restGet("repos/SeleniumHQ/selenium/issues?state=open");
		System.out.println("Status code is : "+responce.getStatusCode());
		Assert.assertEquals(responce.getStatusCode(),200,"State status");
		Assert.assertTrue(api.getValue("state",responce.asString()).size()>0);
		Assert.assertTrue(api.getValue("state",responce.asString()).contains("\"open\""));


	}
	
	
	//Validate the url with state=closed and verifing the response
	
	@Test
	public void gitWithCloseState() throws FileNotFoundException, IOException
	{	
		System.out.println("-------Start of Test gitWithCloseState--------------");
		api=new RestTest();
		Response responce=api.restGet("repos/SeleniumHQ/selenium/issues?state=closed");
		System.out.println("Status code is : "+responce.getStatusCode());
		Assert.assertEquals(responce.getStatusCode(),200,"state status");
		Assert.assertTrue(api.getValue("state",responce.asString()).size()>0);
		Assert.assertTrue(api.getValue("state",responce.asString()).contains("\"closed\""));


	}

	
	//Pass an invalid user name(sele-is a invalid username here) in the url and verify the status code and respone
	
	@Test
	public void gitWithInvalidUserName() throws FileNotFoundException, IOException
	{
		System.out.println("-------Start of Test gitWithInvalidUserName--------------");
		api=new RestTest();
		Response responce=api.restGet("repos/Sele/selenium/issues?state=closed");
		System.out.println("Status code is : "+responce.getStatusCode());
		Assert.assertEquals(responce.getStatusCode(),404,"Invalid user name status");


	}
	
	//Pass an invalid repo name(sel -is a invalid repository) in the url and verify the status code and respone
	@Test
	public void gitWithInvalidRepoName() throws FileNotFoundException, IOException
	{	
		System.out.println("-------Start of Test gitWithInvalidRepoName--------------");
		api=new RestTest();
		Response responce=api.restGet("repos/SeleniumHQ/sel/issues?state=closed");
		System.out.println("Status code is : "+responce.getStatusCode());
		Assert.assertEquals(responce.getStatusCode(),404,"Invalid repository status");



	}


	//Pass an invalid issue state and verify the status code and respone
	@Test
	public void gitWithEmptyIssueState() throws FileNotFoundException, IOException
	{
		System.out.println("-------Start of Test gitWithEmptyIssueState--------------");
		api=new RestTest();
		Response responce=api.restGet("repos/SeleniumHQ/selenium/issues?state=");
		System.out.println("Status code is : "+responce.getStatusCode());
		Assert.assertEquals(responce.getStatusCode(),200,"Invalid state");

	}

	//Hit the url with state=all and verify the response
	@Test
	public void gitWithAllIssueState() throws FileNotFoundException, IOException
	{	
		System.out.println("-------Start of Test gitWithAllIssueState--------------");
		api=new RestTest();
		Response responce=api.restGet("repos/SeleniumHQ/selenium/issues?state=all");
		System.out.println("Status code is : "+responce.getStatusCode());
		Assert.assertEquals(responce.getStatusCode(),200,"Invalid user name status");
		Assert.assertTrue(api.getValue("state",responce.asString()).contains("\"open\""));
		Assert.assertTrue(api.getValue("state",responce.asString()).contains("\"closed\""));
		Assert.assertTrue(api.getValue("state",responce.asString()).size()>0);

	}

	//Hit the url with state=modified and verify the response (invalid)
	@Test
	public void gitWithInvalidIssueState() throws FileNotFoundException, IOException
	{		
			System.out.println("-------Start of Test gitWithInvalidIssueState--------------");
			api=new RestTest();
			Response responce=api.restGet("repos/SeleniumHQ/selenium/issues?state=modified");
			System.out.println("Status code is : "+responce.getStatusCode());
			Assert.assertEquals(responce.getStatusCode(),422,"Invalid state issues");

	}
}