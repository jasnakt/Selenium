import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_Request {
	@Test
	void createUserdetails() {
		RestAssured.baseURI="https://reqres.in/api";
		RequestSpecification httpRequest=RestAssured.given();
		JSONObject requestParam=new JSONObject();
		requestParam.put("name", "morpheus");
		requestParam.put("job","leader");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		Response response=httpRequest.request(Method.POST,"/user");
		System.out.println(response.getBody().asString());
		System.out.println(";response.jsonPath().get(\"createdAt\");"+response.jsonPath().get("createdAt"));
	}

}
