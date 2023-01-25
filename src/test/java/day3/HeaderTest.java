package day3;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.internal.http.Status;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.Map;

public class HeaderTest {

	// @Test(priority = 1)
	void testHeaders1() {
		given()

				.when().get("https://www.google.com/")

				.then().header("Content-Type", "text/html; charset=ISO-8859-1").and().header("Content-Encoding", "gzip")
				.and().header("Server", "gws");
	}

	// @Test(priority = 1)
	void testHeaders2() {
		Response res = given()

				.when().get("https://www.google.com/");

		String value1 = res.header("Content-Type");
		System.out.println(value1);

		Headers value2 = res.headers();
		System.out.println(value2);

	}

	// @Test(priority = 1)
	void testHeaders3() {
		Response res = given().contentType(ContentType.JSON)

				.when().get("http://localhost:3000/store");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		String bookname = res.jsonPath().get("book[2].title").toString();
		System.out.println(bookname);
		Assert.assertEquals(bookname, "book category 3");

	}

	
	//problem found ..A JSONObject text must begin with '{' at 1 [character 2 line 1]
	@Test(priority = 1)
	void testHeaders4() {
		Response res = given().contentType(ContentType.JSON)

				.when().get("http://localhost:3000/store");

		JSONObject jo = new JSONObject(res.toString()); // converting res to json object type

		boolean status=false;
		for (int i = 0; i < jo.getJSONArray("book").length(); i++) {
			String booktitle = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(booktitle);
			if (booktitle.equals("book category 1")) {
				status=true;
				break;
			}
		}

	}
}
