package com.example.testrunner;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestCaseAPITest
{
	@Test
	public void getListOfTestCases()
	{
		Response response = RestAssured.get("http://localhost:8080/testcases");
		for (Header header : response.headers())
		{
			System.out.println("header: " + header.getName() + " = " + header.getValue());
		}

		String body = response.getBody().asString();
		System.out.println(body);
	}


	@Test
	public void getTestCase()
	{
		String body = RestAssured.given()
				.when().get("http://localhost:8080/testcases")
				.then().statusCode(200)
				.extract().body().asString();

		System.out.println(body);
	}

}
