import java.util.Scanner;

public class SaveBetterText{

	public static void main(String[] args){
		TextLogin login = new TextLogin();
		TextUserInfo userInfo = new TextUserInfo();
		TextBudgetInfo budgetInfo = new TextBudgetInfo();
		TextBudgetBreakdown budgetBreakdown = new TextBudgetBreakdown();

		Scanner keyboard = new Scanner(System.in);

		//to get the user
		login.displayOptions();
		int input = keyboard.nextInt();
		boolean result = login.getLoginOption(input);
		while(!result){
			login.displayOptions();
			input = keyboard.nextInt();
			login.getLoginOption(input);
		}



		//when they chose user info
		userInfo.getAndUpdateUserInfo();

		//when they chose budget info
		budgetInfo.textComputeBudgetInfo();

		//when they chose budget breakdown 
		budgetBreakdown.textBudgetBreakdown();

	}
}