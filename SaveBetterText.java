import java.util.Scanner;

public class SaveBetterText{
	Scanner keyboard = new Scanner(System.in);
	TextLogin login = new TextLogin();

	public UserInfo loginUser(){
		login.displayOptions();
		int input = keyboard.nextInt();
		boolean result = login.getLoginOption(input);
		while(result == false){
			login.displayOptions();
			input = keyboard.nextInt();
			result = login.getLoginOption(input);
		}
		return login.currentUser();
	}

	public void displayMenu(){
		System.out.println("Update User Info [1] // Create Simple Budget[2] // Create Budget Breakdown[3] // Logout[4]");
	}

	public static void main(String[] args){
		SaveBetterText sb = new SaveBetterText();
		TextLogin login = new TextLogin();

		Scanner keyboard = new Scanner(System.in);

		UserInfo currentUser = sb.loginUser();
		
		BudgetTool bt = new BudgetTool(currentUser);
		TextUserInfo userInfo = new TextUserInfo();
		TextBudgetInfo budgetInfo = new TextBudgetInfo();
		TextBudgetBreakdown budgetBreakdown = new TextBudgetBreakdown();

		sb.displayMenu();
		Integer choice = keyboard.nextInt();

		while(choice != null){
			if (choice == 1){
				//when they chose user info
				userInfo.getAndUpdateUserInfo(bt);
				sb.displayMenu();

			}
			else if (choice == 2){
				//when they chose budget info
				budgetInfo.textComputeBudgetInfo(bt);
				sb.displayMenu();

			}
			else if (choice == 3){
				//when they chose budget breakdown 
				budgetBreakdown.textBudgetBreakdown(bt);
				sb.displayMenu();

			}
			else if (choice == 4){
				System.out.println("Logged out.");
				sb.loginUser();
			}
			else{
				System.out.println("That is an invalid option. Please try again.");
				sb.displayMenu();

			}
			choice = keyboard.nextInt();
		}
	}
}