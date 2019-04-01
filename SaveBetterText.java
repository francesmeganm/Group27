import java.util.Scanner;

public class SaveBetterText{
	Scanner keyboard = new Scanner(System.in);
	TextLogin login = new TextLogin();

	public void getUser(){
		login.displayOptions();
		int input = keyboard.nextInt();
		boolean result = login.getLoginOption(input);
		while(result == false){
			login.displayOptions();
			input = keyboard.nextInt();
			result = login.getLoginOption(input);
		}
	}

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
		
		sb.getUser();

		sb.displayMenu();
		Integer choice = keyboard.nextInt();

		while(choice != null){
			if (choice == 1){
				//when they chose user info
				userInfo.getAndUpdateUserInfo();
				sb.displayMenu();

			}
			else if (choice == 2){
				//when they chose budget info
				budgetInfo.textComputeBudgetInfo();
				sb.displayMenu();

			}
			else if (choice == 3){
				//when they chose budget breakdown 
				budgetBreakdown.textBudgetBreakdown();
				sb.displayMenu();

			}
			else if (choice == 4){
				System.out.println("Logged out.");
				sb.getUser();
			}
			else{
				System.out.println("That is an invalid option. Please try again.");
				sb.displayMenu();

			}
			choice = keyboard.nextInt();
		}
	}
}