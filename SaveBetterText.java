import java.util.Scanner;

public class SaveBetterText{
	private String loginList = "Create Account // Login"
	//private BugetTool tool;
	

	public SaveBetterText(){

	}




	public static void main(String[] args){
		BudgetTool tool = new BudgetTool();

		Scanner keyboard = new Scanner(System.in);

		System.out.println(loginList);

		String input = keyboard.nextLine();
		if (input == "Create Account" || input == "Login"){
			if (input == "Create Account"){
				System.out.println("Enter new username: ");
				String newUsername = keyboard.nextLine();
				System.out.println("Enter new password: ");
				String newPassword = keyboard.nextLine();
				tool.makeAccount(newUsername, newPassword);

			}
		}
	}
}