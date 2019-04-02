import java.util.Scanner;

public class TextLogin{
	BudgetTool tool;

	String loginOption = "\nCreate New Account[1] // Login[2]";
	Scanner keyboard = new Scanner(System.in);

	String username;
	String password;

	public TextLogin(BudgetTool budgetTool){
		this.tool = budgetTool;
	}

	public void displayOptions(){
		System.out.println(loginOption);
	}

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