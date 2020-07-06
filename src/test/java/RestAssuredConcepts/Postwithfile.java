package RestAssuredConcepts;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postwithfile {
	
	@Test
	public void generateToken()
	{
		// Creating a File instance 
		File jsonDataInFile = new File("src/test/resource/Payload/AuthPayload.json");	
		
		
		// Create a request specification 
		RequestSpecification request= RestAssured.given();
				
		// Setting content type to specify format in which request payload will be sent.
		// ContentType is an ENUM. 
		request.contentType(ContentType.JSON);
		//Adding URI
		request.baseUri("https://restful-booker.herokuapp.com/booking");
		// Adding body as string
		request.body(jsonDataInFile);
			
		// Calling POST method on URI. After hitting we get Response
		Response response = request.post();
		
		System.out.println(response.statusCode());
		response.asString();
	}

}


