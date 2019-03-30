public class TextBudgetInfo(){
	BudgetTool tool = new BudgetTool();
	Scanner keyboard = new Scanner(System.in);

	public void textGetRemainingMoney(){
		System.out.println("This is your simple budget breakdown.")

		System.out.println("Your remaining money for the month is: " + tool.gettingTheRemainingMoney());

		System.out.println("What is the percent of your remaining money do you want to save: ");
		double percent = keyboard.nextInt();
		tool.settingTheAmountToSave(percent);
		double amountToSave = tool.gettingTheAmountToSave();
		System.out.println("The amount you shoud save per month is: " + amountToSave);

		System.out.println("How much does your goal cost: ");
		double goalCost = keyboard.nextInt();
		Date goalCompletionDate = tool.gettingDateGoalCompleted(goalCost);
		System.out.println("You are scheduled to complete your goal: " + goalCompletionDate);


	}


}