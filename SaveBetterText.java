import java.util.Scanner;

public class SaveBetterText{
	Scanner keyboard = new Scanner(System.in);



	public void displayMenu(){
		System.out.println("Update User Info [1] // Create Simple Budget[2] // Create Budget Breakdown[3] // Logout[4]");
	}

	public static void main(String[] args){
		BudgetTool budgetTool = new BudgetTool();
		SaveBetterText sb = new SaveBetterText();
		TextLogin login = new TextLogin(budgetTool);
		TextUserInfo userInfo = new TextUserInfo(budgetTool);
		TextBudgetInfo budgetInfo = new TextBudgetInfo(budgetTool);
		TextBudgetBreakdown budgetBreakdown = new TextBudgetBreakdown(budgetTool);

		Scanner keyboard = new Scanner(System.in);
		
		login.getUser();
		//YOU NEED TO MAKE A LARGER LOOP FOR LOGING IN AND OUT 
		//SO THAT THE PROGRAM NEVER ENDS 

		sb.displayMenu();
		Integer choice = keyboard.nextInt();
		//while(choice != null){}

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
				login.getUser();
			}
			else{
				System.out.println("That is an invalid option. Please try again.");
				sb.displayMenu();
			}
			choice = keyboard.nextInt();
		}
	}
}