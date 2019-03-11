import java.util.Scanner;

public class UserInfo{

	private double monthlyExpenses = 0.0;
	private double monthlyIncome = 0.0;

	Scanner keyboard = new Scanner(System.in);
	
 	public UserInfo(double exp, double inc){
    	setMonthlyIncome(inc);
    	setMonthlyExpenses(exp);
  	}
  	public UserInfo(UserInfo toCopy){
    	UserInfo user = new UserInfo(toCopy);
  	}
 	public UserInfo(){}
  
	public double getMonthlyExpenses() {
	
		System.out.print("Enter expense for Transportation: ");
		double transportCost = keyboard.nextDouble();
	
		System.out.print("Enter expense for Food & Drink: ");
		double foodCost = keyboard.nextDouble();
	
		System.out.print("Enter expense for Entertainment: ");
		double entertainmentCost = keyboard.nextDouble();
	
		System.out.print("Enter expense for Rent: ");
		double rentCost = keyboard.nextDouble();
	
		System.out.print("Enter expense for Other: ");
		double otherCost = keyboard.nextDouble();
		
		monthlyExpenses = transportCost + foodCost + entertainmentCost + rentCost + otherCost;
	
		return monthlyExpenses;
	}
	
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	
	public void setMonthlyIncome(double income) {
		monthlyIncome = income;
	}

	public void setMonthlyExpenses(double expenses){
		monthlyExpenses = expenses;
	}
}
