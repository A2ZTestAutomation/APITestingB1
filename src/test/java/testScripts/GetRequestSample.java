package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequestSample {
  @Test
  public void testResponseStatus() {
	  RequestSpecification request = RestAssured.given();
	  request.baseUri("https://demoqa.com/utilities/weather/city");
	  Response response = request.get("/Chennai");
	  String resString =  response.asPrettyString();
//	  response.asPrettyString()
	  System.out.println("Response Details : " + resString);
	  System.out.println("Response Headers :  " + response.getContentType());
	  System.out.println("Status Code :  " + response.statusCode());
	  ValidatableResponse valRes = response.then();
	  valRes.statusCode(200);
	  Headers allheaders = response.headers();
	  for(Header header: allheaders) {
		  System.out.println("Key : " + header.getName() + " Value : " + header.getValue());
	  }
	  String serverType = response.header("Server");
	  Assert.assertEquals(serverType, "nginx/1.17.10 (Ubuntu)");
//	  Assert.assertEquals(resString.toLowerCase().contains("hyderabad"), true);
	  JsonPath jsonPathEval = response.jsonPath();
	  System.out.println("City Name : " + jsonPathEval.get("City"));
	  String cityName = jsonPathEval.get("City");
	  Assert.assertEquals(cityName, "Chennai", "Expected City name is fetched");
	  
  }
  
  @Test
  public void testResponseBDD() {
	  RestAssured.given()
	  	.baseUri("https://demoqa.com/utilities/weather/city")
	  	.when().get("/Chennai")
	  	.then()
	  		.statusCode(200);
  }
}
