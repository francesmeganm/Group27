import java.util.Scanner;

public class TextLogin extends BudgetTool{
	Accounts a = new Accounts();

	String loginOption = "\nCreate New Account[1] // Login[2]";
	Scanner keyboard = new Scanner(System.in);

	String username;
	String password;

	public String displayOptions(){
		System.out.println(loginOption);
		String input = keyboard.nextLine();
		return input;
	}

	public void getLoginOption(int choice){
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
			displayOptions();
			choice = keyboard.nextInt();
		}
		else if(choice == 2){
			System.out.println("Enter your username: ");
			username = keyboard.nextLine();
			password = keyboard.nextLine();
			while (!super.checkingLogin(username, password)){
				System.out.println("Error. Incorrect username/password. Please try again.");
				username = keyboard.nextLine();
				password = keyboard.nextLine();
			}
			super.setUser(a.getUserInfo(username));
		}
		else{
			System.out.println("That is an invalid login option. Please try again.");
			displayOptions();
			choice = keyboard.nextInt();
		}
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
