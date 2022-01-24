package tests;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExamples {
	
	@Test
	public void testPut()
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
		  put("/users/2").
		then().
		  statusCode(200).log().all();
	}
	
	@Test
	public void testPatch()
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
		
		baseURI = "https://reqres.in";
		
		given().
		  header("Content-Type", "application/json").   //header type of api will be known projects
		  contentType(ContentType.JSON).                //sending-request data in forms of json
		  accept(ContentType.JSON).                     //accepting-response data in forms of json
		  body(request.toJSONString()).
		when().
		  patch("/api/users/2").
		then().
		  statusCode(200).log().all();
	}
	
	@Test
	public void testDelete()
	{
		
		baseURI = "https://reqres.in";
		
		when().
		  delete("/api/users/2").
		then().
		  statusCode(204).log().all();      //204 no content
	}

}
