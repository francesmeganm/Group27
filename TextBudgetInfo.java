import java.util.Date;
import java.util.Scanner;

public class TextBudgetInfo{
	BudgetTool tool;
	Scanner keyboard = new Scanner(System.in);

	public TextBudgetInfo(BudgetTool budgetTool){
		this.tool = budgetTool;
	}

	public void textComputeBudgetInfo(){
		System.out.println("\nThis is your simple budget breakdown.");

		System.out.println("Your remaining money for the month is: " + tool.gettingTheRemainingMoney());

		System.out.print("What is the percent of your remaining money do you want to save: ");
		double percent = keyboard.nextInt();
		while (percent < 0 || percent > 100){
			System.out.print("That is not a valid percent. Please enter a percent between 0 and 100%: ");
			percent = keyboard.nextInt();
		}
		tool.settingTheAmountToSave(percent);
		double amountToSave = tool.gettingTheAmountToSave(percent);
		System.out.println("The amount you should save per month is: " + amountToSave);

		System.out.print("How much does your goal cost: ");
		double goalCost = keyboard.nextInt();
		Date goalCompletionDate = tool.gettingDateGoalCompleted(goalCost);
		System.out.println("You are scheduled to complete your goal: " + goalCompletionDate);
	}
}