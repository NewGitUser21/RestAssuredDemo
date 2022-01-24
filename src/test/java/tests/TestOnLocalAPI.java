package tests;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class TestOnLocalAPI {   //Local json server (node.js) by adding json dependency

	
	//@Test
	public void get()
	{
		
       baseURI = "http://localhost:3000";
		
		given().
		  get("/users").
		then().
		  statusCode(200).log().all();
		
	}
	
	//POST is always for creating a resource (does not matter if it was duplicated).
	//PUT is for checking if resource is exists then update , else create new resource. 
	//PATCH is always for update a resource.
	
	
	//@Test
	public void post()    
	{
		
	JSONObject request = new JSONObject();
		
		request.put("firstName", "Saubhagya Ranjan");
		request.put("lastName", "Jena");
		request.put("subjectId", 1);
		
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
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
	
	//@Test
	public void put()   
	{
		
	JSONObject request = new JSONObject();
		
		request.put("firstName", "Sachin");
		request.put("lastName", "Tendulkar");
		request.put("subjectId", 1);
		
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
		  header("Content-Type", "application/json").   //header type of api will be known projects
		  contentType(ContentType.JSON).                //sending-request data in forms of json
		  accept(ContentType.JSON).                     //accepting-response data in forms of json
		  body(request.toJSONString()).
		when().
		  put("/users/4").
		then().
		  statusCode(200).log().all();                  //200 is success
		
	}
	
	//@Test
	public void patch()
	{
		
	JSONObject request = new JSONObject();
		
		//request.put("firstName", "Sachin");
		request.put("lastName", "Tondulkar");
		//request.put("subjectId", 1);
		
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
		  header("Content-Type", "application/json").   //header type of api will be known projects
		  contentType(ContentType.JSON).                //sending-request data in forms of json
		  accept(ContentType.JSON).                     //accepting-response data in forms of json
		  body(request.toJSONString()).
		when().
		  patch("/users/4").
		then().
		  statusCode(200).log().all();                  //200 is success
		
	}
	
	//@Test
	public void delete()
	{
		
		baseURI = "http://localhost:3000";
	
		when().
		  delete("/users/4").
		then().
		  statusCode(200).log().all();                  //204 - fail the test case, whereas records deleted - need to be careful for delete operation
		                                               //200 - success
	}
}
