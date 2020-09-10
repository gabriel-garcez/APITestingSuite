package resources;

public class Path {

	public static String LoginPath() {
		
		String res = "/v1/orchestrator/login";
		return res;
	}
	
	public static String TransferPath() {
		 String res = "v1/orchestrator/transfer";
		return res;
	   }
  
	public static String ChallengePath() {
		 String res = "v1/orchestrator/challenge";
		return res;
	   }
	
	public static String ForgotPasswordPath() {
		 String res = "v1/orchestrator/password/forgotten";
		return res;
	   }
	
	public static String PaidAccountDisablePath() {
		 String res = "v1/orchestrator/paid-account/enable";
		return res;
	   }
	
	public static String LoanPath() {
		 String res = "v1/orchestrator/loan";
		return res;
	   }
	
	public static String PaymentPath() {
		 String res = "v1/orchestrator/payment";
		return res;
	   }
	
	public static String ChangeDevicePath() {
		 String res = "v1/orchestrator/change-device";
		return res;
	   }
	
	public static String ConsultBalancePath() {
		 String res = "v1/orchestrator/balance";
		return res;
	   }
	
	public static String ConsultStatementPath() {
		 String res = "v1/orchestrator/statement";
		return res;
	   }
	
}
