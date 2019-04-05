import java.util.Scanner;

/**
* Class TextUserInfo refers to the "Update User Info" option on the SaveBetter main menu.
* It has one instance variable, tool, which is a BudgetTool containing all the logic and methods behind each action.
*/
public class TextUserInfo{
	BudgetTool tool;
	Scanner keyboard = new Scanner(System.in);

	/**
	* Class TextUserInfo takes a budgetTool and initializes it as the tool 
	* @param budgetTool contains all the logic and methods behind each action the user may make
	*/
	public TextUserInfo(BudgetTool budgetTool){
		this.tool = budgetTool;
	}

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