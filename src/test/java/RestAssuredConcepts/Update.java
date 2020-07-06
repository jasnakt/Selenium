package RestAssuredConcepts;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update {

	@Test
	public void update() {
		RestAssured.baseURI="https://restful-booker.herokuapp.com/booking";
		RequestSpecification httprequest=RestAssured.given();
		
		
		/*{
		    "firstname" : "Amod",
		    "lastname" : "Mahajan",
		    "totalprice" : 121,
		    "depositpaid" : true,
		    "bookingdates" : {
		        "checkin" : "2020-02-01",
		        "checkout" : "2020-02-05"
		    },
		    "additionalneeds" : "Breakfast"
		}*/
		
		JSONObject hm1=new JSONObject();
		hm1.put("firstname", "Amod");
		hm1.put("lastname", "Mahajan");
		hm1.put("totalprice", 121);
		hm1.put("depositpaid", true);
		HashMap<String,String> hm2=new HashMap();
		hm2.put("checkin", "2020-02-01");
		hm2.put("checkout", "2020-02-05");
		hm1.put("bookingdates", hm2);
		hm1.put("additionalneeds", "Breakfast");
		
		httprequest.contentType("Content-Type,application/json");
		httprequest.body(hm1.toString());
		Response response=httprequest.request(Method.POST,"");
	System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	
		
		
		
	
	
	
	}

}
