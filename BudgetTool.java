public class BudgetTool{
	//inputing user info // no this is in the GUI
	//does things that you know need to be completed from interaction from the user

	private UserInfo user;
	private BudgetInfo smallBudget;
	private BudgetBreakdown largeBudget;
	private Accounts account;//do we need this??

	public BudgetTool(){
		account = new Accounts();
		user = new UserInfo();
		smallBudget = new BudgetInfo(user);
		largeBudget = new BudgetBreakdown(user);
	
	}

	public void checkingUsername(username){
		user.checkUsername(username);
	}

	public void makeAccount(String username, String password){
		//need to make a constructor to attach account and to user info, not sure
		//how to do this but should not combine the two 

		account.createAccount(username, password);
	}

	public void login()


	public boolean (String username, String password){
		boolean verify = account.verifyUsernameAndPassword();
		return verify;
	}

	public computeSmallBudget(){

	}

	public computeLargeBudget(){

	}
}