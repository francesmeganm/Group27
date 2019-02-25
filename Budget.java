public class Budget extends Expenses{
	private double monthlyExpenses = 0.0;
	private double monthylIncome = 0.0;
	
	public Budget(expenses, income){
		monthlyExpenses = super.getTotalExpenses();
		monthlyIncome = super.getMonthlyIncome();
	}
		
	public double remainingMoney(){
		double remaining = monthlyIncome - monthlyExpenses;
		return remaining;
	}
}
