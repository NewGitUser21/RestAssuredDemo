/**
 * 
 */
package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;

//XSD import
//import static io.restassured.matcher.RestAssuredMatchers.matchesDtdInClasspath;

/**
 * @author DELL
 * 
 * Validate XML response against XML schema definition (AddCalculator.xsd)
 *
 */
public class XMLSchemaValidation {
	
	
	@Test
	public void schemaAddValidation() throws IOException
	{
		
		File file = new File("./SoapRequest/Add.xml");
		//File file = new File("./SoapRequest/Subtract.xml");
		//File file = new File("./SoapRequest/Divide.xml");
		//File file = new File("./SoapRequest/Multiply.xml");
		
		
		if(file.exists())
		{
			System.out.println("  >> File Exists");
		}
		
		//File I/O util
		FileInputStream fileInputStream = new FileInputStream(file);
		
		//Apache common IO dependency
		
		String requestBody = org.apache.commons.io.IOUtils.toString(fileInputStream, "UTF-8");
		
		//If baseURI is static imported then baseURI can be directly used instead of (RestAssured.baseURI)
		baseURI = "http://www.dneonline.com";
		
		given().
		  contentType("text/xml").
		  accept(ContentType.XML).  //How to validate SOAP API from file
		  body(requestBody).
		  when().
		  post("/calculator.asmx").
		  then().
		  statusCode(200).
		  log().all().
		  and().
		  body("//*:AddResult.text()", equalTo("5")).
		  and().
		  assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("AddCalculator.xsd"));
		
		//If XSD import is added
		//assertThat().body(matchesXsdInClasspath("AddCalculator.xsd"));
		
		//During first run
		//FAILED: schemaValidation
		//org.xml.sax.SAXParseException; lineNumber: 1; columnNumber: 208; cvc-elt.1.a: Cannot find the declaration of element 'soap:Envelope'.
		
		//AddCalulator.xsd requires below piece of code
		//<xs:import namespace="http://schemas.xmlsoap.org/soap/envelope/"   
	    //         schemaLocation="http://schemas.xmlsoap.org/soap/envelope/"/>
		
		
	}
	
	@Test
	public void schemaSubtractValidation() throws IOException
	{
		
		//File util
		//File file = new File("./SoapRequest/Add.xml");
		File file = new File("./SoapRequest/Subtract.xml");
		//File file = new File("./SoapRequest/Divide.xml");
		//File file = new File("./SoapRequest/Multiply.xml");
		
		
		if(file.exists())
		{
			System.out.println("  >> File Exists");
		}
		
		//File I/O util
		FileInputStream fileInputStream = new FileInputStream(file);
		
		//Apache common IO dependency
		
		String requestBody = org.apache.commons.io.IOUtils.toString(fileInputStream, "UTF-8");
		
		//If baseURI is static imported then baseURI can be directly used instead of (RestAssured.baseURI)
		baseURI = "http://www.dneonline.com";
		
		given().
		  contentType("text/xml").
		  accept(ContentType.XML).  //How to validate SOAP API from file
		  body(requestBody).
		  when().
		  post("/calculator.asmx").
		  then().
		  statusCode(200).
		  log().all().
		  and().
		  body("//*:SubtractResult/text()", equalTo("23")).
		  and().
		  assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("SubtractCalculator.xsd"));
		
		//body("//*:SubtractResult/text()", equalTo("23")).
		  		
	}
	
	@Test
	public void schemaDivideValidation() throws IOException
	{
		
		//File util
		//File file = new File("./SoapRequest/Add.xml");
		//File file = new File("./SoapRequest/Subtract.xml");
		File file = new File("./SoapRequest/Divide.xml");
		//File file = new File("./SoapRequest/Multiply.xml");
		
		
		if(file.exists())
		{
			System.out.println("  >> File Exists");
		}
		
		//File I/O util
		FileInputStream fileInputStream = new FileInputStream(file);
		
		//Apache common IO dependency
		
		String requestBody = org.apache.commons.io.IOUtils.toString(fileInputStream, "UTF-8");
		
		//If baseURI is static imported then baseURI can be directly used instead of (RestAssured.baseURI)
		baseURI = "http://www.dneonline.com";
		
		given().
		  contentType("text/xml").
		  accept(ContentType.XML).  //How to validate SOAP API from file
		  body(requestBody).
		  when().
		  post("/calculator.asmx").
		  then().
		  statusCode(200).
		  log().all().
		  and().
		  body("//*:DivideResult/text()", equalTo("8")).
		  and().
		  assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("DivideCalculator.xsd"));
		  		
	}
	
	@Test
	public void schemaMultiplyValidation() throws IOException
	{
		
		//File util
		//File file = new File("./SoapRequest/Add.xml");
		//File file = new File("./SoapRequest/Subtract.xml");
		//File file = new File("./SoapRequest/Divide.xml");
		File file = new File("./SoapRequest/Multiply.xml");
		
		
		if(file.exists())
		{
			System.out.println("  >> File Exists");
		}
		
		//File I/O util
		FileInputStream fileInputStream = new FileInputStream(file);
		
		//Apache common IO dependency
		
		String requestBody = org.apache.commons.io.IOUtils.toString(fileInputStream, "UTF-8");
		
		//If baseURI is static imported then baseURI can be directly used instead of (RestAssured.baseURI)
		baseURI = "http://www.dneonline.com";
		
		given().
		  contentType("text/xml").
		  accept(ContentType.XML).  //How to validate SOAP API from file
		  body(requestBody).
		  when().
		  post("/calculator.asmx").
		  then().
		  statusCode(200).
		  log().all().
		  and().
		  body("//*:MultiplyResult/text()", equalTo("200")).
		  and().
		  assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Multiply.xsd"));
		  		
	}

}
