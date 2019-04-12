package text;


import gui.*;
import calendar.*;
import logic.*;


import java.util.Scanner;


import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;

/**
* Class TextBudgetInfo refers to the "Create Simple Budget" option on the SaveBetter main menu.
* It allows the user to create a simple budget with goals and savings. 
* It has one instance variable, tool, of type BudgetTool. 
*/
public class TextBudgetInfo{
	private BudgetTool tool;
	private Scanner keyboard = new Scanner(System.in);

	/**
	* Constructor takes an instance of the BudgetTool that refers to the current user
	* @param budgetTool contains all the logic and methods behind each action the user may make
	*/
	public TextBudgetInfo(BudgetTool budgetTool){
		this.tool = budgetTool;
	}
	
	/**
	* Method textComputeBudgetInfo creates a "Simple Budget". Its features include: showing the remaining 
	* money you have to spend after your monthly expenses, as well as a savings calculator which forecasts 
	* how long it will take for you to reach your savings goal. 
	*/
	public void textComputeBudgetInfo(){
		try{
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

			System.out.print("When would you like to start saving for your goal (dd/MM/yyyy): ");
			String date = keyboard.next();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date chosen = dateFormat.parse(date);
			tool.settingDate(chosen);
			Date goalCompletionDate = tool.gettingDateGoalCompleted(goalCost);
			System.out.println("You are scheduled to complete your goal: " + goalCompletionDate);
		}
		catch(ParseException pe){}
		
	}
}