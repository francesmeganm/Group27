import java.util.Scanner;

public class SaveBetterText{
	Scanner keyboard = new Scanner(System.in);

	BudgetTool budgetTool;
	TextLogin login;
	TextUserInfo userInfo;
	TextBudgetInfo budgetInfo;
	TextBudgetBreakdown budgetBreakdown;


	public SaveBetterText(BudgetTool budgetTool){
		this.budgetTool = budgetTool;
		login = new TextLogin(budgetTool);
		userInfo = new TextUserInfo(budgetTool);
		budgetInfo = new TextBudgetInfo(budgetTool);
		budgetBreakdown = new TextBudgetBreakdown(budgetTool);
	}

	public void displayMenu(){
		System.out.println("Update User Info [1] // Create Simple Budget[2] // Create Budget Breakdown[3] // Logout[4]");
	}

	public void loginMenu(){
		login.getUser();
		displayMenu();
	}

	public void mainMenu(Integer choice){
			if (choice == 1){
				//when they chose user info
				userInfo.getAndUpdateUserInfo();
				displayMenu();
			}
			else if (choice == 2){
				//when they chose budget info
				budgetInfo.textComputeBudgetInfo();
				displayMenu();
			}
			else if (choice == 3){
				//when they chose budget breakdown 
				budgetBreakdown.textBudgetBreakdown();
				displayMenu();
			}
			else if (choice == 4){
				System.out.println("Logged out.");
			}
			else{
				System.out.println("That is an invalid option. Please try again.");
				displayMenu();
			}
	}

	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		BudgetTool budgetTool = new BudgetTool();

		SaveBetterText saveBetter = new SaveBetterText(budgetTool);

		saveBetter.loginMenu();
		saveBetter.displayMenu();

		Integer choice = keyboard.nextInt();

		while(choice != null){
			saveBetter.mainMenu(choice);
			if(choice == 4){
				saveBetter.loginMenu();
			}
			choice = keyboard.nextInt();
		}
	}
}