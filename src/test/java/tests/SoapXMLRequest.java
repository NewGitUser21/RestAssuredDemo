/**
 * 
 */
package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

//body("//*:AddResult.text()", equalTo("5")
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/**
 * @author DELL
 * 
 * How to validate SOAP API from file
 * 
 * How to validate SOAP XML Rest Assured (XPath)
 *
 */
public class SoapXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException
	{
		
		//File util
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
		  log().all();
		  
		  		
	}
	
	@Test
	public void validateAddSoapXML() throws IOException
	{
		
		//File util
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
		  body("//*:AddResult.text()", equalTo("5"));  //How to validate SOAP XML Rest Assured (XPath)
		  		
	}
	
	@Test
	public void validateSubtractSoapXML() throws IOException
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
		  body("//*:SubtractResult/text()", equalTo("23"));  //How to validate SOAP XML Rest Assured (XPath)
		  		
	}
	
	@Test
	public void validateDivideSoapXML() throws IOException
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
		  body("//*:DivideResult/text()", equalTo("8"));  //How to validate SOAP XML Rest Assured (XPath)
		  		
	}
	
	@Test
	public void validateMultiplySoapXML() throws IOException
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
		  body("//*:MultiplyResult/text()", equalTo("200"));  //How to validate SOAP XML Rest Assured (XPath)
		  		
	}

}
