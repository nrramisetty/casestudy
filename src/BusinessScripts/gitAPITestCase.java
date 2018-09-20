package BusinessScripts;

import java.io.IOException;

import com.jayway.restassured.response.Response;

import APITests.RestTest;

public class gitAPITestCase {
	
	public static void main(String[] args) throws IOException 
	{
		RestTest api=new RestTest();
		Response responce=api.restGet("?access_token=204f0fe28d92a84de888f78de779ba19c10c8564");
		System.out.println(responce.getStatusCode());
		System.out.println(responce.asString());
		
		Response responce1=api.restGet("repos/SeleniumHQ/selenium/issues?state=open");
		System.out.println(responce1.getStatusCode());
		System.out.println(responce1.asString());
	}

}
