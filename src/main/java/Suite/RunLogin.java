package Suite;

import org.testng.Assert;
import org.testng.annotations.Test;

import challenge.token;
import orchestrator.login;
import orchestrator.transfer;

public class RunLogin {
	
	@Test
	public void LoginSuccess() {
		
		int statusCode = login.post();
		Assert.assertEquals(statusCode, 200);
	
	}	
	

}
