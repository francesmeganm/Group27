import java.util.Scanner;

public class UserInfo{

	Scanner keyboard = new Scanner(System.in);
	
	private double monthlyExpenses = 0.0;
	private double monthlyIncome = 0.0;
	
	public UserInfo(){}
	
  	public UserInfo(double exp, double inc){
	    setMonthlyIncome(inc);
	    setMonthlyExpenses(exp);
 	 }
 	 public UserInfo(UserInfo toCopy){
   		UserInfo user = new UserInfo(toCopy);
 	 }

	public double getMonthlyExpenses() {
	
		System.out.println("Enter expense for Transportation: ");
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
		System.out.println("Enter income: ");
		monthlyIncome = keyboard.nextInt();
		return monthlyIncome;
	}
	
	public void setMonthlyIncome(double income) {
		monthlyIncome = income;
	}

	public void setMonthlyExpenses(double expenses){
		monthlyExpenses = expenses;
	}
}