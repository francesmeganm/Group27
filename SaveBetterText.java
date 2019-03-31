import java.util.Scanner;

public class SaveBetterText{

	public static void main(String[] args){
		TextLogin login = new TextLogin();
		TextUserInfo userInfo = new TextUserInfo();
		TextBudgetInfo budgetInfo = new TextBudgetInfo();
		TextBudgetBreakdown budgetBreakdown = new TextBudgetBreakdown();

		//to get the user
		login.main();

		//when they chose user info
		userInfo.getAndUpdateUserInfo();

		//when they chose budget info
		budgetInfo.textComputeBudgetInfo();

		//when they chose budget breakdown 
		budgetBreakdown.textBudgetBreakdown();

	}
}