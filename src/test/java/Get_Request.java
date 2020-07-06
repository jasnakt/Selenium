import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request {
	
	@Test
	void userDetails() {
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification httpRequest=RestAssured.given();
		Response httpResponse=httpRequest.request(Method.GET,"/2");
		System.out.println(httpResponse.getHeader("Date"));
		
	}

}
