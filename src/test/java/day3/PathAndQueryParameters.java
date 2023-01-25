package day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
public class PathAndQueryParameters {	
		
		@Test()
		public void testQueryAndPathParameters() {
		
			//main URL like : https://reqres.in/api/users?page=2&id=5
			given()
			//prerequisite			
			.pathParam("mypath", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
					
			.when()
			//request type like get post
			
			.get("https://reqres.in/api/{mypath}") //here we no need to change the url
			
			.then()
			//validation
			.statusCode(200)
			.log().all();	
			
			
		}	
	
}
