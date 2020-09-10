package challenge;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Path;
import resources.URLs;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class token {

	
	@Test
	public static int post(String orchestratorId) {
		
		//Get URL
		RestAssured.baseURI=URLs.baseURLChallenge();
		
		//Pass Header
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("deviceId", "4792E6D7D0CD14B2773283DFB41D769F");
		request.header("geolocation", "SP");
		request.header("malware", "false");
		request.header("root", "false");
		request.header("ip", "127.0.0.1");
		
		//Send Body
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("orchestratorId", orchestratorId);		 
		requestParams.put("deviceChallenge", "TOKEN_OTP");
		requestParams.put("deviceKey", "35449936001");
		requestParams.put("deviceValue",  "64afc363a6af4c84a2a8cd3cd0e86d3664afc363a6af4c84a2a8cd3cd0e86d36");
		
		request.body(requestParams.toJSONString());
		
		//Do the Post
		Response response = request.post(Path.ChallengePath());
			
		//Show Response
		JsonPath jsonPathEvaluator = response.jsonPath();
		String responseString = response.asString();
		System.out.println(responseString);
		
		
		//Take the fields that you want to validate
		int statusCode = response.getStatusCode();
		return statusCode;
	
			
	}
}
