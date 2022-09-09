package com.khauminhduy;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

class LiveTest {

	private static String APP_ROOT = "http://localhost:8001";

	@Test
	void givenUser_whenResourceCreatedWithNullName_then400BadRequest() {
		Response response = givenAuth("user", "pass").contentType(MediaType.APPLICATION_JSON.toString())
				.body(resourceWithNullName()).post(APP_ROOT + "/foos");
		assertEquals(400, response.getStatusCode());
	}

	@Test
	void givenUser_whenResourceCreated_then201Created() {
		final Response response = givenAuth("user", "pass").contentType(MediaType.APPLICATION_JSON.toString())
				.body(resourceString()).post(APP_ROOT + "/foos");
		assertEquals(201, response.getStatusCode());
	}

	private final String resourceWithNullName() {
		return "{\"name\":null}";
	}

	private final String resourceString() {
		return "{\"name\":\"" + randomAlphabetic(8) + "\"}";
	}

	private final RequestSpecification givenAuth(String username, String password) {
		return RestAssured.given().auth().preemptive().basic(username, password);
	}

}
