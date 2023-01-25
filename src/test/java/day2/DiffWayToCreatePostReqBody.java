package day2;

import org.json.JSONObject;
import org.json.JSONTokener;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DiffWayToCreatePostReqBody {

	/*
	 * Different ways of create POST request body  
	 * 
	 */

	// 1.Post request body using HashMap
	
//	@Test(priority = 1)
//	public void testPostUsingHashMap() {
//		
//		HashMap data = new HashMap();
//		data.put("name", "Most");
//		data.put("location", "France");
//		data.put("phone", "12345");
//
//		String courseArr[] = { "C", "C++" };
//		data.put("courses", courseArr);
//
//		given().contentType("application/json").body(data).when().post("http://localhost:3000/Students")
//
//				.then().statusCode(201).body("name", equalTo("Most")).body("location", equalTo("France"))
//
//				.body("phone", equalTo("12345")).body("courses[0]", equalTo("C")).body("courses[1]", equalTo("C++"))
//				.header("Content-Type", "application/json; charset=utf-8").log().all();
//
//	}
//
//	// 2.Post request body creation using org.JSON
//
//	//@Test(priority = 1)
//	public void testPostUsingJsonLibrary() {
//
//		JSONObject data = new JSONObject();
//
//		data.put("name", "Lost");
//		data.put("location", "France");
//		data.put("phone", "12345");
//
//		String coursesArr[] = { "C", "C++" };
//		data.put("courses", coursesArr);
//
//		given().contentType("application/json").body(data.toString()).when().post("http://localhost:3000/Students")
//				.then().statusCode(201).body("name", equalTo("Lost")).body("location", equalTo("France"))
//				.body("phone", equalTo("12345")).body("courses[0]", equalTo("C")).body("courses[1]", equalTo("C++"))
//
//				.header("Content-Type", "application/json; charset=utf-8").log().all();
//	}
//
//	
//	
//	//3. Post request body using POJO class
//	
//	@Test(priority = 1)
//	public void testPostUsingPOJO() {
//
//		POJO_PostRequest data=new POJO_PostRequest();
//		
//
//		data.setName("Scott");
//		data.setLocation("France");
//		data.setPhone("12345");
//
//		String coursesArr[] = { "C", "C++" };
//		
//		data.setCourses(coursesArr);
//
//		given().contentType("application/json")
//		.body(data)
//		
//		.when()
//		.post("http://localhost:3000/Students")
//				
//		.then()
//		.statusCode(201)
//		.body("name", equalTo("Scott"))
//		.body("location", equalTo("France"))
//		.body("phone", equalTo("12345"))
//		.body("courses[0]", equalTo("C"))
//		.body("courses[1]", equalTo("C++"))
//
//		.header("Content-Type", "application/json; charset=utf-8").log().all();
//
//	}
	
	//4.Post request body using external json file data
	
	@Test(priority = 1)
	public void testPostUsigExternalJSonFile() throws FileNotFoundException {

		
		//  \\Users\\akmal360\\eclipse-workspace\\RestAssured2_you
		File file=new File(".//body.json");
		
		FileReader fileReader=new FileReader(file);
		
		JSONTokener jsonTokener= new JSONTokener(fileReader);
		
		JSONObject data=new JSONObject(jsonTokener);
		
		

		given().contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("http://localhost:3000/Students")
				
		.then()
		.statusCode(201)
		.body("name", equalTo("Sing"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("12345"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))

		.header("Content-Type", "application/json; charset=utf-8").log().all();

	}
	
	@Test(priority = 2)
	public void testDelete() {
		given().when().delete("http://localhost:3000/Students/5")

				.then().statusCode(200);
	}

}
