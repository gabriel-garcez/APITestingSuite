package Suite;

import org.testng.Assert;
import org.testng.annotations.Test;

import challenge.biometric;
import challenge.token;
import orchestrator.ForgotPassword;
import orchestrator.login;
import orchestrator.transfer;

public class RunAll {
	
	@Test
	public void TransferMidwaytoMidway() {
		
		String challenge = transfer.post("121");
		int statusCode = token.post(challenge);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void TransferMidwaytoSantander() {
		
		String challenge = transfer.post("77");
		int statusCode = token.post(challenge);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void TransferMidwaytoBanks() {
		
		String challenge = transfer.post("341");
		int statusCode = token.post(challenge);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void LoginSuccess() {
		
		int statusCode = login.post();
		Assert.assertEquals(statusCode, 200);
	
	}
	
	@Test
	public void ForgotPassword() {
		
		String challenge = ForgotPassword.post();
		int statusCode = biometric.post(challenge);
		Assert.assertEquals(statusCode, 200);
		
	}	
	
	

}
