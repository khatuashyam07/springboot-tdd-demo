package com.shyam.springboottdddemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import net.minidev.json.JSONObject;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTddDemoApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(value={"classpath:application.properties"})
class SpringbootTddDemoApplicationTests {

	@Value("${server.port}")   // 6
    int port;
	
	@Test
	void contextLoads() {
	}

	@Before
	public void setBaseUri () {

		 RestAssured.port = port;
		 RestAssured.baseURI = "http://localhost"; // replace as appropriate
	}
	@Test
	public void findMatchingPatternTest() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("text", "AABAACAADAABAABAA"); 
		requestBody.put("pattern", "AABA");
		Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/string/pattern")
                .then()
                .extract().response();
		Assert.assertNotNull(response);
	    Assert.assertNotNull(response.getBody());
	    Assert.assertEquals(200, response.statusCode());
        
	}

	@Test
	public void isPalindromeTest() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("text", "RADAR"); 
		requestBody.put("pattern", "");
		Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/string/palindrome")
                .then()
                .extract().response();

		Assert.assertNotNull(response);
	    Assert.assertNotNull(response.getBody());
	    Assert.assertEquals(200, response.statusCode());
	}
}
