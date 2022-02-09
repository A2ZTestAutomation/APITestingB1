package testScripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequestSample {
	
	int userId=2;
  @Test
  public void updateUser() {
	  RestAssured.baseURI = "https://reqres.in/api/users";
	  
	  JSONObject requestParams = new JSONObject();
	  requestParams.put("name", "Peter");
	  requestParams.put("job", "Project Leader");
	  
	  Response resp = RestAssured.given()
	  .accept(ContentType.JSON)
	  .contentType("application/json")
	  .and()
	  .body(requestParams.toString())
	  .put("/2");
	  
	  System.out.println("Status Code : "+ resp.getStatusCode());
	  System.out.println("Is job of employee 2 is Project Leader"+resp.asString().contains("Project Leader"));
	  
	  Assert.assertTrue(resp.asString().contains("Project Leader"));
  }
  
  @Test
  public void deleteUser() {
	  RestAssured.baseURI = "https://reqres.in/api/users";
	  Response resp = RestAssured.given()
			  .delete("/2");
	  
	  System.out.println("Status code after delete : "+resp.getStatusCode());
	  
  }
  
}
