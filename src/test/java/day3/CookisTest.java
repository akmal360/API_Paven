package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.Map;

public class CookisTest {

	// @Test(priority = 1)
	void testCookis() {
		given()

				.when().get("https://www.google.com/")

				.then().cookie("AEC").log().all();
	}

	@Test(priority = 1)
	void testCookisInfo() {
		Response res = given()

				.when().get("https://www.google.com/");

		// get single cookies info
		String cookie_variable = res.getCookie("AEC");
		//System.out.println("value of cookies======> "+cookie_variable);
	
		//get all cookies info
		Map<String,String> cookies_values=res.getCookies();
		System.out.println(cookies_values.keySet());
		
		for(String coo:cookies_values.keySet()) {
			 String cookies_valuess=res.getCookie(coo);
			 System.out.println(coo+" === "+cookies_valuess);	
		}
	}
}
