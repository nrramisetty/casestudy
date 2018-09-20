package apitest;

import static org.hamcrest.Matchers.notNullValue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import utilities.Propertie;


public class RestTest {
	
	String restAPIURL;
	public RestTest() throws FileNotFoundException, IOException 
	{
		Propertie preader=new Propertie(System.getProperty("user.dir")+"/src/config.properties");
		restAPIURL=preader.getPropData("URL").trim();
		System.out.println(restAPIURL);
	}
	
	@Test
	public Response restPost(String url,String TestDatafilePath) throws IOException
	{
		restAPIURL=restAPIURL+url;
		Propertie preader=new Propertie(System.getProperty("user.dir")+"/src/config.properties");
		String restAPIURL=preader.getPropData("URL")+url;
		System.out.println(restAPIURL);
		FileInputStream inputSrc = new FileInputStream(System.getProperty("user.dir")+TestDatafilePath);
	    String apiBody = IOUtils.toString(inputSrc);
		RequestSpecBuilder builder=new RequestSpecBuilder();
		
		//Header
		builder.setContentType("Content-Type; text/plain")
		.addHeader("Content-Length", "0")
		.addHeader("Cache-Control", "no-cache");
		
		
		//Request Body
		builder.setBody(apiBody);
		
		RequestSpecification requestSpc=builder.build();
		
		Response response= RestAssured.given().authentication().basic("","").contentType("application/json; charset=utf-8").body(apiBody).post(restAPIURL);
		
		System.out.println(response.getStatusCode());
				
		return response;
		
		
		
	}
	
	public  Response restGet( String url) {
		System.out.println(restAPIURL+url);
		return RestAssured.given().headers("", "").contentType("application/json; charset=utf-8").expect().body(notNullValue()).when().get(restAPIURL+url);

	}
	
	
	public String getValueFromJson(Response response,String Key)
	{
		JsonObject JSONResponse=new JsonObject().get(response.body().asString()).getAsJsonObject();
		return JSONResponse.get(Key).getAsString();
	}
	
	public void sucessStatusValidation(Response response)
	{
		Assert.assertEquals(200, response.getStatusCode());
	}


	
}
