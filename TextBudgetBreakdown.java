import java.util.Scanner;

public class TextBudgetBreakdown{
	BudgetTool tool = new BudgetTool();
	Scanner keyboard = new Scanner(System.in);

	public void textBudgetBreakdown(){
		System.out.println("This is your complex budget breakdown.");

		System.out.println("Enter the percent to spend on entertainment: ");
		double ent = keyboard.nextInt();

		System.out.println("Enter the percent to spend on personal care: ");
		double pers = keyboard.nextInt();

		System.out.println("Enter the percent to spend on food and groceries: ");
		double food = keyboard.nextInt();

		System.out.println("Enter the percent to spend on shopping: ");
		double shop = keyboard.nextInt();

		System.out.println("Enter the percent to spend on miscellaneous: ");
		double misc = keyboard.nextInt();

		tool.settingBudgetBreakdown(ent, pers, food, shop, misc);

		System.out.println("The amount to spend on entertainment is: " + tool.gettingEntertainment());
		System.out.println("The amount to spend on persoanl care is: " + tool.gettingPersonal());
		System.out.println("The amount to spend on food and groceries is: " + tool.gettingFood());
		System.out.println("The amount to spend on shopping is: " + tool.gettingShopping());
		System.out.println("The amount to spend on miscellaneous is: " + tool.gettingMisc());
	}
}