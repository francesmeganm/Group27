import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class SaveBetter extends UserData{
	String menuList = "Update Income // Update Expenses // Update Amount To Save // Show Budget Overview";
	
	Scanner keyboard = new Scanner(System.in);
	
	public double getMenuOption(int choice){
		double returnStatement = 0.0;
		if (choice == 0){
			System.out.print("Enter new Income: ");
			double updatedIncome = keyboard.nextInt();
			super.setMonthlyIncome(updatedIncome);
			System.out.println("Your new income is: " + updatedIncome);
			returnStatement = super.getMonthlyIncome();
		}

		if (choice == 1){
			System.out.print("Enter new expenses: ");
			double updatedExpenses = keyboard.nextInt();
			super.setMonthlyExpenses(updatedExpenses);
			System.out.println("Your new expenses is: " + updatedExpenses);
			returnStatement = super.getMonthlyExpenses();
		}

		if (choice == 2){
			System.out.print("Enter percentage of remaining income you would like to save: ");
			double updatedPercentToSave = keyboard.nextInt();
			super.setPercentToSave(updatedPercentToSave);
			System.out.println("Your new desired percentage of income to save: " + updatedPercentToSave);
			returnStatement = super.getPercentToSave();
		}

		/*
		this one is hard because there is a good chance that budget overview has more than 
		just number, and right now this method only returns double 

		if (choice == 3){
			System.out.print("This is your budget overview");

		}*/
		return returnStatement;
	}

	public void getBudgetOverview(){
		System.out.println("This is your budget overview: \n" +  
			"Desired amount to save a month: " + super.getAmountToSave() + "\n" + 
			"Money left to spend this month: " + super.getRemainingMoney());
	}

	public static void main(String[] args){
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Update Income");
		menu.add("Update Expenses");
		menu.add("Update Amount To Save");
		menu.add("Show Budget Overview");

		SaveBetter sb = new SaveBetter();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("To quite enter a blank line");
		System.out.println(sb.menuList);
		String input = keyboard.nextLine();

		while (!(input.isEmpty())){
			System.out.println(menu);
			int index = menu.indexOf(input);
			if (index == 0){
				sb.getMenuOption(index);
			}
			if (index == 1){
				sb.getMenuOption(index);
			}
			if (index == 2){
				sb.getMenuOption(index);
			}
			if (index == 3){
				sb.getBudgetOverview();
			}

			System.out.println(sb.menuList);
			input = keyboard.nextLine();
		}
	}
}