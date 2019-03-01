import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class SaveBetter extends UserData{
	String menuList = "Update Income		Update Expenses		Update Amount to Save		Show Budget Overview";
	
	Scanner keyboard = new Scanner(System.in);
	
	public double getMenuOption(double choice){
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

	public static void main(String[] args){
		SaveBetter sb = new SaveBetter();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("To quite return 11");
		System.out.println(sb.menuList);
		double input = keyboard.nextInt();

		while (input != 11){
			sb.getMenuOption(input);
			input = keyboard.nextInt();
		}
	}
}