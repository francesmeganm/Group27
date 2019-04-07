import java.util.Scanner;

/**
* Class TextUserInfo refers to the "Update User Info" option on the SaveBetter main menu. 
* It allows the user to update their monthly expenses and income. 
* It has one instance variable, tool of type BudgetTool. 
*/
public class TextUserInfo{
	private BudgetTool tool;
	private Scanner keyboard = new Scanner(System.in);

	/**
	* Constructor takes an instance of the BudgetTool that refers to the current user
	* @param budgetTool contains all the logic and methods behind each action the user may make
	*/
	public TextUserInfo(BudgetTool budgetTool){
		this.tool = budgetTool;
	}

	/**
	 * This method takes input from the user about their monthly income and expenses. It goes through 
	 * budgetTool and updates all user information to UserInfo
	 */
	public void getAndUpdateUserInfo(){
		System.out.println("Updating your monthly income and expenses.");

		System.out.print("Enter monthly income: ");
		double inc = keyboard.nextInt();

		System.out.print("Enter monthly trasporation cost: ");
		double trans = keyboard.nextInt();

		System.out.print("Enter monthly utility cost: ");
		double uti = keyboard.nextInt();

		System.out.print("Enter monthly rent cost: ");
		double rent = keyboard.nextInt();

		System.out.print("Enter monthly other: ");
		double oth = keyboard.nextInt();

		tool.updateUserInfo(trans, uti, oth, rent, inc);
		System.out.println("Update your user info.");
	}
}