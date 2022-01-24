package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

//static imports
//https://github.com/rest-assured/rest-assured/wiki/Usage#static-imports


//import static io.restassured.matcher.ResponseAwareMatcher.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class TestsExamples {
	
	@Test
	public void test_1()
	{
	
		{
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		 Response response = get("https://reqres.in/api/users?page=2");	
			
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
		
		}
	}
	
	@Test
	public void test_2()
	{
		baseURI = "https://reqres.in/api";
		
		given().
	      get("/users?page=2").
	    then().
	      statusCode(200).
	    body("data[1].id", equalTo(8)).
	    log().all();	
	}
	

}
