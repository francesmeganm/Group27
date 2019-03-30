import java.util.Scanner;

public class SaveBetterText{
	private String loginList = "Create Account // Login"

	
	

	public SaveBetterText(){

	}




	public static void main(String[] args){
		TextUserInfo userInfo = new TextUserInfo();
		TextBudgetInfo budgetInfo = new TextBudgetInfo();
		TextBudgetBreakdown budgetBreakdown = new TextBudgetBreakdown();


		//when they chose user info
		userInfo.getAndUpdateUserInfo();

		//when they chose budget info
		budgetInfo.textComputeBudgetInfo();

		//when they chose budget breakdown 
		budgetBreakdown.textBudgetBreakdown();

	}
}