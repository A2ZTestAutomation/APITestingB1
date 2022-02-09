package testScripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestSample {
	
	// name, email, gender, status
//	@Test
	public void postUser() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "TestUser");
		jsonObject.put("job", "TestArchitect"); 
//		jsonObject.put("email", "testuser@gmail.com");
//		jsonObject.put("gender", "female");
//		jsonObject.put("status","Active");
		System.out.println(jsonObject.toString());
		Response resp = RestAssured.given()
				.accept(ContentType.JSON)
				.contentType("application/JSON")
				.and()
				.body(jsonObject.toString())
				.post();
		System.out.println("Status Code : "+ resp.getStatusCode());
				
	}

	//b8c87e237c1c43cd079cbecef302025986abb7a48864a0b66d31b7742cda36ea
	@Test
	public void postUserWithAuth() {
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "TestUser");
		jsonObject.put("email", "testuser111@gmail.com");
		jsonObject.put("gender", "female");
		jsonObject.put("status","Active");
		System.out.println(jsonObject.toString());
		Response resp = RestAssured.given()
				.header("authorization", "Bearer b8c87e237c1c43cd079cbecef302025986abb7a48864a0b66d31b7742cda36ea")
				.accept(ContentType.JSON)
				.contentType("application/JSON")
				.and()
				.body(jsonObject.toString())
				.post();
		System.out.println("Status Code : "+ resp.getStatusCode());
		System.out.println(resp.asString());
				
	}

}
