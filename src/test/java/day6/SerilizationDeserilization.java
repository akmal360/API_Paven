package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//POJO --> Serilization--->JSON Object

public class SerilizationDeserilization {

	// Pojo ----serilization---> Json Object
	//@Test
	void converPojoToJson() throws JsonProcessingException {

		// creating java object using pojo class
		Student data = new Student();

		data.setName("Scott");
		data.setLocation("France");
		data.setPhone("12345");

		String coursesArr[] = { "C", "C++" };
		data.setCourses(coursesArr);

		// convert java object - -->json object (serilization)
		ObjectMapper objectMapperPojoToJson = new ObjectMapper();
		String jsonData = objectMapperPojoToJson.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsonData);
	}

	// Json object -->Deserilization ---> Pojo
	@Test
	void converJsonToPojo() throws JsonProcessingException {

		String jsonData = "{\n" + "  \"name\" : \"Scott\",\n" + "  \"location\" : \"France\",\n"
				+ "  \"phone\" : \"12345\",\n" + "  \"courses\" : [ \"C\", \"C++\" ]\n" + "}";
		
		
		// converting json data--->Pojo obect
		ObjectMapper objectMapperJsonToPojo = new ObjectMapper();
		Student stuPojo=objectMapperJsonToPojo.readValue(jsonData, Student.class);
		
		System.out.println("Name: "+stuPojo.getName());
		System.out.println("Location: "+stuPojo.getLocation());
		System.out.println("Phone: "+stuPojo.getPhone());
		System.out.println("Course 1: "+stuPojo.getCourses()[0]);
		System.out.println("Coures 2:"+stuPojo.getCourses()[1]);
		
		
		
		
	}


}
