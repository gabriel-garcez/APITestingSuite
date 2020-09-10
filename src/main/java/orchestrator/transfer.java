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
import resources.Path;
import resources.URLs;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class transfer {

	@Test
	public static String post(String bank) {
		
		//Get URL
		RestAssured.baseURI=URLs.baseURLTransfer();
		
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
 
		requestParams.put("channel", "MOBILE_APP");
		requestParams.put("email", "joao@dominio.com");
		requestParams.put("intentionId","71b44af3");
		requestParams.put("transactionId", "d1bc8d3ba4afc7e109612cb73acbdddac052c93025aa1f82942edabb7deb82a1");
		requestParams.put("sessionId", "9ceece10cf8b97d1f1924dae5d14c137fd144ce999ede85f48be6d7582e2dd23");
		requestParams.put("transactionDate", "2017-06-16T19:20:12.123000-03:00");
		requestParams.put("transactionValue", 6050.10);
		requestParams.put("accountScope", "PESSOA_FISICA");
		requestParams.put("accountType", "CONTA_PAGAMENTO");
		requestParams.put("userName", "Joao do Carmo");
		requestParams.put("cpf", "27725725770");
		requestParams.put("cnpj", "VAZIO");
		requestParams.put("recipientInstitutionInfo", bank);
		requestParams.put("recipientUser", "Joao do Carmo");
		requestParams.put("recipientIdNumber", "37836982809");
		requestParams.put("recipientBranch", "432-1");
		requestParams.put("recipientAccountNumber", "5432-1");
		requestParams.put("recipientAccountType", "CONTA_CORRENTE");
		requestParams.put("recipientAccountScope", "PESSOA_FISICA");
		requestParams.put("referer", "VAZIO");
		
		JSONObject list = new JSONObject();
			list.put("latitude", -23.0923);
			list.put("longitude", -47.1939);
			list.put("timestamp", 1278303);
			list.put("accuracy", 30);
        requestParams.put("location", list);
		
		
		requestParams.put("vipLevel",1);
		requestParams.put("userId","12345");
		requestParams.put("recipientUserName","Daniel Barreto");
		
		request.body(requestParams.toJSONString());
		
		//Do the Post
		Response response = request.post(Path.TransferPath());
			
		//Show Response
		JsonPath jsonPathEvaluator = response.jsonPath();
		String responseString = response.asString();
		System.out.print(responseString);
		
		
		//Take the fields that you want to validate
		int statusCode = response.getStatusCode();
		String orchestratorId = jsonPathEvaluator.get("orchestratorId");
		
		return orchestratorId;
	
			
	}
}
