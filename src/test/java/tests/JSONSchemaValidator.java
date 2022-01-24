package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
//
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;


/*ctrl + shift + O (To remove all unused imports)
 * 
 * validate schema.json using json schema dependency from maven central
 * 
 * Local json server installation using nodejs
 * 
 * store json schema in target locator under class path
 * 
 * validate json schema against url
*/

public class JSONSchemaValidator {   
	
	@Test
	public void testGet()
	{
		baseURI = "https://reqres.in/api";
		
		given().
	      get("/users?page=2").
	    then().
	    //get("/products").then().assertThat().body(matchesJsonSchemaInClasspath("products-schema.json").using(jsonSchemaFactory));
	    assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
	      statusCode(200).
	    /*body("data[4].first_name", equalTo("George")).
	    body("data.first_name", hasItems("George","Rachel")).
	    body("data.last_name", hasItems("Ferguson","Edwards"));*/
	    log().all();	
	}

}
