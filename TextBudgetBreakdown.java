import java.util.Scanner;

public class TextBudgetBreakdown{
	BudgetTool tool;
	Scanner keyboard = new Scanner(System.in);

	public TextBudgetBreakdown(BudgetTool budgetTool){
		this.tool = budgetTool;
	}

	public void textBudgetBreakdown(){
		System.out.print("\nThis is your complex budget breakdown.");

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

		tool.settingBudgetBreakdown(ent, pers, food, shop, misc);

		System.out.println("\nThe amount to spend on entertainment is: " + tool.gettingEntertainment());
		System.out.println("The amount to spend on persoanl care is: " + tool.gettingPersonal());
		System.out.println("The amount to spend on food and groceries is: " + tool.gettingFood());
		System.out.println("The amount to spend on shopping is: " + tool.gettingShopping());
		System.out.println("The amount to spend on miscellaneous is: " + tool.gettingMisc());
	}
}