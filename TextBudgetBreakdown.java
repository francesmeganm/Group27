import java.util.Scanner;

public class TextBudgetBreakdown{
	Scanner keyboard = new Scanner(System.in);

	public void textBudgetBreakdown(BudgetTool bt){
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

		bt.settingBudgetBreakdown(ent, pers, food, shop, misc);

		System.out.println("The amount to spend on entertainment is: " + bt.gettingEntertainment());
		System.out.println("The amount to spend on persoanl care is: " + bt.gettingPersonal());
		System.out.println("The amount to spend on food and groceries is: " + bt.gettingFood());
		System.out.println("The amount to spend on shopping is: " + bt.gettingShopping());
		System.out.println("The amount to spend on miscellaneous is: " + bt.gettingMisc());
	}
}