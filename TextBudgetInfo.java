import java.util.Date;
import java.util.Scanner;

public class TextBudgetInfo{
	Scanner keyboard = new Scanner(System.in);

	public void textComputeBudgetInfo(BudgetTool bt){
		System.out.println("This is your simple budget breakdown.");

		System.out.println("Your remaining money for the month is: " + bt.gettingTheRemainingMoney());

		System.out.println("What is the percent of your remaining money do you want to save: ");
		double percent = keyboard.nextInt();
		bt.settingTheAmountToSave(percent);
		double amountToSave = bt.gettingTheAmountToSave(percent);
		System.out.println("The amount you shoud save per month is: " + amountToSave);

		System.out.println("How much does your goal cost: ");
		double goalCost = keyboard.nextInt();
		Date goalCompletionDate = bt.gettingDateGoalCompleted(goalCost);
		System.out.println("You are scheduled to complete your goal: " + goalCompletionDate);
	}
}