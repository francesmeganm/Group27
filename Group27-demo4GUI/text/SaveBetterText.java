package text;


import gui.*;
import calendar.*;
import logic.*;


import java.util.Scanner;

/**
* This class SaveBetterText is where the whole program runs through. 
* It contains the prompts to display the login menu, main menu, 
* and all the subsequent methods that come with choosng an action, 
* which the user would be inputting from the console. 
* It has several instance variables such as the budgetTool, login, userInfo, 
* budgetInfo, and budgetBreakdown which all contain the logic to run chosen languages. 
*/
public class SaveBetterText{
	private Scanner keyboard = new Scanner(System.in);
	private BudgetTool budgetTool;
	private TextLogin login;
	private TextUserInfo userInfo;
	private TextBudgetInfo budgetInfo;
	private TextBudgetBreakdown budgetBreakdown;

	/**
	* Constructor makes new instances of the login, userInfo, budgetInfo, and budgetBreakdown 
	* which will all reference the budgetTool and assigns them to the instance variables. 
	* @param budgetTool holds all the methods that controls every action the user may make
	*/
	public SaveBetterText(BudgetTool budgetTool){
		this.budgetTool = budgetTool;
		login = new TextLogin(budgetTool);
		userInfo = new TextUserInfo(budgetTool);
		budgetInfo = new TextBudgetInfo(budgetTool);
		budgetBreakdown = new TextBudgetBreakdown(budgetTool);
	}

	/** 
	* Method displayMenu prints the main menu that will be displayed once the user has logged in. 
	*/
	public void displayMenu(){
		System.out.println("\nUpdate User Info [1] // Create Simple Budget[2] // Create Budget Breakdown[3] // Logout[4]");
	}

	/** 
	* Method loginMenu calls the method getUser from the class Login to display the login menu 
	* which gives the user the options to create an account or login with an existing account.
	*/
	public void loginMenu(){
		login.getUser();
	}

	/**
	* Method mainMenu takes the input from the user and runs the correlating method for
	* each menu option. If the user inputs an invalid choice, then it will re-display the menu, 
	* reprompting the user. 
	* @param choice the input from the user for which menu option they would like to do
	*/
	public void mainMenu(Integer choice){
			if (choice == 1){
				userInfo.getAndUpdateUserInfo();
			}
			else if (choice == 2){
				budgetInfo.textComputeBudgetInfo();
			}
			else if (choice == 3){
				budgetBreakdown.textBudgetBreakdown();
			}
			else if (choice == 4){
				System.out.println("Logged out.");
			}
			else{
				System.out.println("That is an invalid option. Please try again.");
				displayMenu();
			}
	}

	/** 
	* The main method runs the whole SaveBetter program. It starts by displaying a welcome message, 
	* then displays the login menu. Once the user has logged in the program will run on a loop 
	* going from the main menu and its subsequent methods to the login menu every time the user logs out 
	* and/or logs as a different user. 
	*/
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		
		BudgetTool budgetTool = new BudgetTool();

		SaveBetterText saveBetter = new SaveBetterText(budgetTool);

		System.out.println("\nWelcome to SaveBetter!");
		saveBetter.loginMenu();
		saveBetter.displayMenu();

		Integer choice = keyboard.nextInt();

		while(choice != null){
			saveBetter.mainMenu(choice);
			if(choice == 4){
				saveBetter.loginMenu();
			}
			saveBetter.displayMenu();
			choice = keyboard.nextInt();
		}
	}
}