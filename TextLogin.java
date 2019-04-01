import java.util.Scanner;

public class TextLogin extends BudgetTool{
	Accounts a = new Accounts();

	String loginOption = "\nCreate New Account[1] // Login[2]";
	Scanner keyboard = new Scanner(System.in);

	String username;
	String password;

	public void displayOptions(){
		System.out.println(loginOption);
	}

	public boolean getLoginOption(int choice){
		boolean isLoggedIn = false;
		if (choice == 1){
			System.out.println("Enter a new unique username: ");
			username = keyboard.nextLine();
			boolean isUnique = super.checkingUsername(username);
			while (isUnique == false){
				System.out.println("Sorry, that username is already taken. Please enter a new one: ");
				username = keyboard.nextLine();
				isUnique = super.checkingUsername(username);
			}
			System.out.println("Enter a password: ");
			password = keyboard.nextLine();
			super.makeAccount(username, password);
		}
		else if(choice == 2){
			System.out.println("Enter your username: ");
			username = keyboard.nextLine();
			System.out.println("Enter your password: ");
			password = keyboard.nextLine();
			while (!super.checkingLogin(username, password)){
				System.out.println("Error. Incorrect username/password. Please try again.");
				username = keyboard.nextLine();
				password = keyboard.nextLine();
			}
			System.out.println("Logged in as " + username);
			super.setUser(a.getUserInfo(username));
			isLoggedIn = true;
		}
		else{
			System.out.println("That is an invalid login option. Please try again.");
		}
		return isLoggedIn;
	}

	/*public static void main(String [] args){
		TextLogin l = new TextLogin();
		BudgetTool b = new BudgetTool();

		Scanner keyboard = new Scanner(System.in);

		l.displayOptions();

		int input = keyboard.nextInt();
		while (input != 0){
			l.getLoginOption(input);
		}
	}*/
}