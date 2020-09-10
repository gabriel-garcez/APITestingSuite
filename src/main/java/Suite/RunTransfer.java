package Suite;

import org.testng.Assert;
import org.testng.annotations.Test;

import challenge.token;
import orchestrator.transfer;

public class RunTransfer {
	
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
	
	

}
