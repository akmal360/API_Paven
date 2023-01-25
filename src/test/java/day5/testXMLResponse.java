package day5;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.internal.http.Status;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class testXMLResponse {

	// @Test
	void testResponseWithXML_1() {

		// Apporch 1

		given()

				.when().get("http://restapi.adequateshop.com/api/traveler?/page=1")

				.then().statusCode(200).header("Content-Type", "application/xml; charset=utf-8")
				.body("TravelerinformationResponse.page", equalTo("1"))
				.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));

	}

	@Test
	void testResponseWithXML_2() {

		// Apporch 2

		Response res =

				given()

						.when().get("http://restapi.adequateshop.com/api/traveler?/page=1");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		
		String pageNo=res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");
		System.out.println(pageNo);
		
		String travelName=res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(travelName, "Developer");
		System.out.println(travelName);
		
		
	}
	
	
	@Test
	void testResponseWithXML_3() {

		// Apporch 2

		Response res =

				given()

						.when().get("http://restapi.adequateshop.com/api/traveler?/page=1");


		XmlPath xmlPath=new XmlPath(res.asString());
		List<String > travellers= xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals( travellers.size(),10);
		
		
		//verify traveller name is present in response
		
		List<String> traveller_name= xmlPath.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		
		boolean status=false;
		for (String namesOfTraveller : traveller_name) {
			System.out.println(namesOfTraveller);
			
			if (namesOfTraveller.equals("vano")) {
				status=true;
				break;
			}
		}
		 Assert.assertEquals(status, true);
		
		
		
	
		
	}


}
