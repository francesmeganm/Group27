import java.util.Scanner;

/**
 * The class TextLogin is the main login part of the text based program. It includes creating account, 
 * login in, and displaying the login menu. All methods refer to the an instance of the BudgetTool
 * The class contains four instance variables: tool is a BudgetTool, loginOption is a String, 
 * keyboard is a Sanner, username is a String, and password is a String 
 */
public class TextLogin{
	BudgetTool tool;

	String loginOption = "\nCreate New Account[1] // Login[2]";
	Scanner keyboard = new Scanner(System.in);

	String username;
	String password;

	/**
	 * Constructor takes an instance of the BudgetTool that refers to the current user
	 * @param budgetTool 
	 */
	public TextLogin(BudgetTool budgetTool){
		this.tool = budgetTool;
	}

	/**
	 * This method diplays the String and instance variable loginOption
	 */
	public void displayOptions(){
		System.out.println(loginOption);
	}

	/**
	 * This method takes a int which is the choice for the login menu and either 1. Creates a new 
	 * account. 2. Allows user to login into a pre-existing account. 3. Allows user to try again if 
	 * they entered a non-vaild menu option.
	 * @param choice is the option of the login menu
	 */
	public boolean getLoginOption(int choice){
		boolean isLoggedIn = false;
		if (choice == 1){
			System.out.print("\nEnter a new unique username: ");
			keyboard.nextLine();
			username = keyboard.nextLine();
			boolean isUnique = tool.checkingUsername(username);
			while (isUnique == false){
				System.out.print("Sorry, that username is already taken. Please enter a new one: ");
				username = keyboard.nextLine();
				isUnique = tool.checkingUsername(username);
			}
			System.out.print("Enter a password: ");
			password = keyboard.nextLine();
			tool.makeAccount(username, password);
			System.out.println("Created new account.");
		}
		else if(choice == 2){
			System.out.print("\nEnter your username: ");
			keyboard.nextLine();
			username = keyboard.nextLine();
			System.out.print("Enter your password: ");
			password = keyboard.nextLine();
			while (!tool.checkingLogin(username, password)){
				System.out.print("Error. Incorrect username/password. Please try again.");
				System.out.print("Enter your username: ");
				username = keyboard.nextLine();
				System.out.print("Enter your password: ");
				password = keyboard.nextLine();
			}
			System.out.println("Logged in as " + username);
			isLoggedIn = true;
		}
		else{
			System.out.println("That is an invalid login option. Please try again.");
		}
		return isLoggedIn;
	}

	/**
	 * This method returns the current user, and checks the current login status. And prints the
	 * login menu
	 */
	public void getUser(){
		displayOptions();
		int input = keyboard.nextInt();
		boolean result = getLoginOption(input);
		while(result == false){
			displayOptions();
			input = keyboard.nextInt();
			result = getLoginOption(input);
		}
	}
}