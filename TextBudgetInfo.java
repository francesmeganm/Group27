import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;

public class TextBudgetInfo{
	BudgetTool tool;
	Scanner keyboard = new Scanner(System.in);

	public TextBudgetInfo(BudgetTool budgetTool){
		this.tool = budgetTool;
	}
	//@throws ParseException
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

			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			//String dateFormat = "dd/MM/yyyy";

			System.out.print("When would you like to start saving for your goal (dd/MM/yyyy): ");
			//String date1 = keyboard.nextLine();
			//Date date = new SimpleDateFormat(dateFormat).parse(date1); 
			//tool.settingDate(date);
			System.out.println("1");
			String date = keyboard.nextLine();
			System.out.println("2");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date chosen = dateFormat.parse(date);
			tool.settingDate(chosen);
			System.out.println("3");
			Date goalCompletionDate = tool.gettingDateGoalCompleted(goalCost);
			System.out.println("You are scheduled to complete your goal: " + goalCompletionDate);
		}
		catch(ParseException pe){}
		
	}
}