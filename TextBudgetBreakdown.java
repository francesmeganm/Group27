import java.util.Scanner;

/** 
* Class TextBudgetBreakdown refers to the "Create Budget Breakdown" option on the SaveBetter main menu.
* This class displays to the user a breakdown of their remaining money to how they would like to spend it. 
* It has one instance varibale, tool, which is a BudgetTool containing all the logic and methods behind each action.
*/
public class TextBudgetBreakdown{
	BudgetTool tool;
	Scanner keyboard = new Scanner(System.in);

	/**
	* This constructor takes a budgetTool and initializes it as the tool 
	* @param budgetTool contains all the logic and methods behind each action the user may make
	*/
	public TextBudgetBreakdown(BudgetTool budgetTool){
		this.tool = budgetTool;
	}

	/** 
	* Method textBudgetBreakdown is what will be displayed to teh user when they choose
	* to compute a budget breakdown. It will first prompt the user to enter percentages
	* for each category, then it will compute the exact amount of your spending money that
	* can be used for each category. 
	*/
	public void textBudgetBreakdown(){
		System.out.println("\nThis is your complex budget breakdown.");
		System.out.println("Based on these 5 spending categories, allocate a percentage of your spendings towards each category.");

		System.out.print("\nEnter the percent to spend on entertainment: ");
		double ent = tool.checkIfValidPercent(keyboard.nextInt());

		System.out.print("Enter the percent to spend on personal care: ");
		double pers = tool.checkIfValidPercent(keyboard.nextInt());

		System.out.print("Enter the percent to spend on food and groceries: ");
		double food = tool.checkIfValidPercent(keyboard.nextInt());

		System.out.print("Enter the percent to spend on shopping: ");
		double shop = tool.checkIfValidPercent(keyboard.nextInt());

		System.out.print("Enter the percent to spend on miscellaneous: ");
		double misc = tool.checkIfValidPercent(keyboard.nextInt());

		if (ent + pers + food + shop + misc > 100 || ent + pers + food + shop + misc < 0){
			System.out.println("Error. These percents sum to " + (ent + pers + food + shop + misc) + ". Please re-enter so that the total is between 0 and 100%.");
			textBudgetBreakdown();
		}
		tool.settingBudgetBreakdown(ent, pers, food, shop, misc);

		System.out.println("\nBased on your " + tool.gettingTheRemainingMoney() +" left for spending money...");
		System.out.println("The amount to spend on entertainment is: " + tool.gettingEntertainment());
		System.out.println("The amount to spend on persoanl care is: " + tool.gettingPersonal());
		System.out.println("The amount to spend on food and groceries is: " + tool.gettingFood());
		System.out.println("The amount to spend on shopping is: " + tool.gettingShopping());
		System.out.println("The amount to spend on miscellaneous is: " + tool.gettingMisc());
		if (tool.gettingExtra() != 0){
			System.out.println("You have " + tool.gettingExtra() + " to spend on anything else extra.");
		}
	}
}