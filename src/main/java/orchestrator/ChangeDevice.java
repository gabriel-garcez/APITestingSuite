package orchestrator;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.URLs;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ChangeDevice {

	
	@Test
	public void postLogin() {
		
		//Get URL
		RestAssured.baseURI="http://prf-orchestrator-login-microservice.prevencao-fraude.k8s-uat.bancomidway.io";
		
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
		
		JSONArray phonearray = new JSONArray();
		requestParams.put("phones", phonearray);
		
//		JSONObject list = new JSONObject();
//		list.put("countryCode", 55);
//		list.put("areaCode", 11);
//		list.put("number", "961114499");
//		list.put("type", "CELULAR");
 
		requestParams.put("flowType", "LOGIN");		 
		requestParams.put("channel", "MOBILE_APP");
		requestParams.put("sessionId", "12342130302139312");
		requestParams.put("loginResult",  "LOGIN_COM_SUCESSO");
		requestParams.put("email",  "fabiosm@midway.com.br");
		requestParams.put("intentionId",  "9874529798942967589");
		requestParams.put("accountScope",  "PESSOA_FISICA");
		requestParams.put("accountType",  "CONTA_PAGAMENTO");
		requestParams.put("userName",  "Fabio Massarotto");
		requestParams.put("cpf",  "75730928815");
		requestParams.put("userAgent",  "Android 2.2");
		requestParams.put("userId",  "1234");
		
		request.body(requestParams.toJSONString());
		
		//Do the Post
		Response response = request.post("/v1/orchestrator/login");
			
		//Show Response
		JsonPath jsonPathEvaluator = response.jsonPath();
		String responseString = response.asString();
		System.out.println(responseString);
		
		
		//Take the fields that you want to validate
		int statusCode = response.getStatusCode();
		
		//Validate them 
		Assert.assertEquals(statusCode, 200);
	
			
	}
}
