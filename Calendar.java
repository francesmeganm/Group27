import java.util.*

public class Calendar extends BudgetInfo {

	public static void main(String[] args) {
	
		BudgetInfo b = new BudgetInfo(); // Create a BudgetInfo object 
		
		Scanner keyboard = new Scanner(System.in); // Create a Scanner object 
		
		System.out.println("Enter the Year you would like to create a budget for (YYYY): ");
		int year = keyboard.nextLine(); // Read user input
		
		System.out.println("Enter the Month you would like to create a budget for (MM): ");
		int month = keyboard.nextLine(); // Read user input
		
		System.out.println("Creating budget for:" + month + "/" + year ); // Message
		
		
		// In this section get budget details by calling methods in the parent class, BudgetInfo
		
		double p = b.getPercentToSave();
		double c = b.getGoalCost();
		String g = b.getGoal();
		
		super(double p, double c, String g); 
		
		displayMonthlyBudget();
	}
		
	public void displayMonthlyBudget() {	// Display the budget for the selected month
		
		System.out.println("Here is an overview of your budget for" + "" + month + "/" + year);
	
		System.out.println("Your Goal: " + g + "\n" + "Percent to Save: " + p + "\n" + "Goal Cost: " + c);
		
	}
}
