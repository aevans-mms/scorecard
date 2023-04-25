package com.example.scorecard;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class TeamsApiTest
{
	@Test
	public void listTeams()
	{
		ValidatableResponse response = RestAssured.given()
				.header("Accept", "application/json")
				.when()
				.get("http://localhost:8080/teams")
				.then()
				.statusCode(200);

		String body = response.extract().body().asString();
		System.out.println(body);
	}

	@Test
	public void addTeam()
	{
		JSONObject team = new JSONObject();
		team.put("name", "Pakistan");
		team.put("league", "East");

		RestAssured.given()
				.header("Content-type", "application/json")
				.body(team.toJSONString())
				.when()
				.post("http://localhost:8080/teams")
				.then()
				.statusCode(201);
	}

	@Test
	public void modifyTeam()
	{
		JSONObject team = new JSONObject();
		team.put("id", 11);
		team.put("name", "Japan");
		team.put("league", "East");

		RestAssured.given()
				.header("Content-type", "application/json")
				.body(team.toJSONString())
				.when()
				.put("http://localhost:8080/teams/3")
				.then()
				.statusCode(204);
	}

	@Test
	public void deleteTeam()
	{
		RestAssured.given()
				.when()
				.delete("http://localhost:8080/teams/3")
				.then()
				.statusCode(204);
	}
}
