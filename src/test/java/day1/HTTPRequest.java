package day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

//import java.util.HashMap;

public class HTTPRequest {

	int id;
	
	@Test(priority = 1)
	void getUsers() {

		given().when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();

	}
	
	@Test(priority = 2)
	void createUser() {
		
		HashMap hm= new HashMap();
		hm.put("name", "akmal");
		hm.put("job", "candidate");
		
		id=given()
			.contentType("application/json")
			.body(hm)
		 
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
			
		
	}
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() {
		 
		
		HashMap hm= new HashMap();
		hm.put("name", "akmal hossain");
		hm.put("job", "lead_QA");
		
		given()
			.contentType("application/json")
			.body(hm)
			 
		.when()
			.put("https://reqres.in/api/users/"+id)
			
			
			.then()
			.statusCode(200)
			.log()
			.all();	
		
	}
	
	@Test(priority =4)
	void delete() {
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204)
			.log()
			.all();
	}

}
 