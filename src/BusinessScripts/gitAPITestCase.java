package BusinessScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import APITests.RestTest;

public class gitAPITestCase {
		
		/*
		 * Validate response with AccessToken
		 */
		@Test
		public void ValidateResponsewithAccessToken() throws IOException{
			
		RestTest api=new RestTest();
		Response responce=api.restGet("?access_token=204f0fe28d92a84de888f78de779ba19c10c8564");
		System.out.println("Status code is : "+responce.getStatusCode());
		System.out.println(responce.body().prettyPrint());
		
		}
		
		/*
		 * Validate Open Issues 
		 */
		
		@Test
		public void ValidateOpenIssues() throws IOException{
			
		RestTest api=new RestTest();
		Response responce1=api.restGet("repos/SeleniumHQ/selenium/issues?state=open");
		System.out.println("Status code is : "+responce1.getStatusCode());
		System.out.println(responce1.body().prettyPrint());
		}
	}


