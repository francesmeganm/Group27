import java.util.Scanner;

public class SaveBetterText{

	public void displayMenu(){
		System.out.println("Update User Info [1] // Create Simple Budget[2] // Create Budget Breakdown[3] // Logout[4]");
	}

	public static void main(String[] args){
		SaveBetterText sb = new SaveBetterText();
		TextLogin login = new TextLogin();
		TextUserInfo userInfo = new TextUserInfo();
		TextBudgetInfo budgetInfo = new TextBudgetInfo();
		TextBudgetBreakdown budgetBreakdown = new TextBudgetBreakdown();

		Scanner keyboard = new Scanner(System.in);

		//to get the user
		login.displayOptions();
		int input = keyboard.nextInt();
		boolean result = login.getLoginOption(input);
		while(result == false){
			login.displayOptions();
			input = keyboard.nextInt();
			login.getLoginOption(input);
		}

		sb.displayMenu();
		int choice = keyboard.nextInt();

		if (choice == 1){
			//when they chose user info
			userInfo.getAndUpdateUserInfo();
		}
		else if (choice == 2){
			//when they chose budget info
			budgetInfo.textComputeBudgetInfo();
		}
		else if (choice == 3){
			//when they chose budget breakdown 
			budgetBreakdown.textBudgetBreakdown();
		}
		else if (choice == 4){
			new SaveBetterText();
		}
		else{
			System.out.println("That is an invalid option. Please try again.");
		}
	}
}