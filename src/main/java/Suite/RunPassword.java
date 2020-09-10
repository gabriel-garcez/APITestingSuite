package Suite;

import org.testng.Assert;
import org.testng.annotations.Test;

import challenge.biometric;
import challenge.token;
import orchestrator.ForgotPassword;
import orchestrator.transfer;

public class RunPassword {
	
	@Test
	public void ForgotPassword() {
		
		String challenge = ForgotPassword.post();
		int statusCode = biometric.post(challenge);
		Assert.assertEquals(statusCode, 200);
		
	}	
	

}
