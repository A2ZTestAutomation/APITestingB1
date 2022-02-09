package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthSample {
	
//	@Test
	public void preemptiveAuth() {
		
//		https://postman-echo.com/basic-auth
		RestAssured.given().auth()
		.preemptive().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().log().body();
			
	}
//	@Test
	public void challegedAuth() {
		
//		https://postman-echo.com/basic-auth
		RestAssured.given().auth()
		.basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().log().body();
			
	}
	
	//4410a0645b33e16063e75fc3f2045685
	@Test
	public void getWeatherWithAPI() {
		RestAssured.given().queryParam("q", "Chennai")
		.queryParam("appid", "4410a0645b33e16063e75fc3f2045685")
		.when().get("http://api.openweathermap.org/data/2.5/weather")
		.then().log().body();
	}
	
	@Test
	public void validateCountry() {
		String strCountry = RestAssured.given().queryParam("q", "Chennai")
		.queryParam("appid", "4410a0645b33e16063e75fc3f2045685")
		.when().get("http://api.openweathermap.org/data/2.5/weather")
		.then().extract().path("sys.country");
		Assert.assertTrue(strCountry.equals("IN"));
	}
	
	@Test
	public void getWeather() {
		String mainWeather = RestAssured.given().queryParam("q", "Chennai")
		.queryParam("appid", "4410a0645b33e16063e75fc3f2045685")
		.when().get("http://api.openweathermap.org/data/2.5/weather")
		.then().extract().path("weather[0].main");
		System.out.println("Main Weather is : " + mainWeather);
		
	}
	
	
}
