import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class SaveBetter extends UserData{
	String menuList = "Update Income // Update Expenses // Update Amount To Save // Show Budget Overview";
	
	Scanner keyboard = new Scanner(System.in);
	
	public double getMenuOption(int choice){
		double returnStatement = 0.0;
		if (choice == 0){
			System.out.println("Enter new Income: ");
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
			System.out.print("Enter new amount to save: ");
			double updatedAmountToSave = keyboard.nextInt();
			super.setAmountToSave(updatedAmountToSave);
			System.out.println("Your new amount to save is: " + updatedAmountToSave);
			returnStatement = super.getAmountToSave();
		}

		/*
		this one is hard because there is a good chance that budget overview has more than 
		just number, and right now this method only returns double 

		if (choice == 3){
			System.out.print("This is your budget overview");

		}*/
		return returnStatement;
	}

	public String getBudgetOverview(){
		String returnStatement = "xx";
		System.out.print("This is your budget overview");
		return returnStatement;

	}

	public static void main(String[] args){
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Update Income");
		menu.add("Update Expenses");
		menu.add("Update Amount To Save");
		menu.add("Show Budget Overview");

		SaveBetter sb = new SaveBetter();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("To quite enter \"exit\" to quit program");
		System.out.println(sb.menuList);
		String input = keyboard.nextLine();

		while (!(input.isEmpty())){
			System.out.println(menu);
			int index = menu.indexOf(input);
			System.out.println(index);
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

			System.out.print(menu);
			input = keyboard.nextLine();
		}
	}
}