import java.util.Scanner;

public class TextBudgetBreakdown{
	BudgetTool tool;
	Scanner keyboard = new Scanner(System.in);

	public TextBudgetBreakdown(BudgetTool budgetTool){
		this.tool = budgetTool;
	}

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