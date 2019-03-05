

import java.util.Scanner;

public class UserInfo extends Account {

	private double monthlyExpenses;
	private double monthlyIncome;
	
	
	public double getMonthlyExpenses() {
	
	
		Scanner keyboard = new Scanner(System.in);
	
		ystem.out.println("Enter expense for Transportation: ");
		double transportCost = keyboard.nextInt();
	
		System.out.println("Enter expense for Food & Drink: ");
		double foodCost = keyboard.nextInt();
	
		System.out.println("Enter expense for Entertainment: ");
		double entertainmentCost = keyboard.nextInt();
	
		System.out.println("Enter expense for Rent: ");
		double rentCost = keyboard.nextInt();
	
		System.out.println("Enter expense for Other: ");
		double otherCost = keyboard.nextInt();
		
		monthlyExpenses = transportCost + foodCost + entertainmentCost + rentCost + otherCost;
	
		return monthlyExpenses;
	
	}
	
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	
	public void setMonthlyIncome(income) {
		monthlyIncome = income;
	}
	
}