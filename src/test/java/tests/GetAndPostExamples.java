package tests;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

//static imports
//https://github.com/rest-assured/rest-assured/wiki/Usage#static-imports

//import static io.restassured.matcher.ResponseAwareMatcher.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

//import java.util.HashMap;
//import java.util.Map;

public class GetAndPostExamples {
	
	//@Test
	public void testGet()
	{
		baseURI = "https://reqres.in/api";
		
		given().
	      get("/users?page=2").
	    then().
	      statusCode(200).
	    body("data[4].first_name", equalTo("George")).
	    body("data.first_name", hasItems("George","Rachel")).
	    body("data.last_name", hasItems("Ferguson","Edwards"));
	    //log().all();	
	}
	
	@Test
	public void testPost()
	{
		
		//Map<String, Object> map = new HashMap<String, Object>();
		 /* 
		 * map.put("name", "Raghav"); 
		 * map.put("job", "Teacher");
		 */
		
		//json library in maven repository
		//json, Gson, Json simple, Jackson
		
	//	System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		  header("Content-Type", "application/json").   //header type of api will be known projects
		  contentType(ContentType.JSON).                //sending-request data in forms of json
		  accept(ContentType.JSON).                     //accepting-response data in forms of json
		  body(request.toJSONString()).
		when().
		  post("/users").
		then().
		  statusCode(201).log().all();                  //201 is created
						
	}

}
