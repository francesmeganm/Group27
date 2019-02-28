public class UserData{
	private double monthlyExpenses = 0.0;
	private double monthlyIncome = 0.0;
	private double amountToSave = 0.0;
	
	
	public UserInfo(double expenses, double income, double save){
		monthlyExpenses = expenses;
		monthlyIncome = setMonthlyIncome();
		amountToSave = save; 
	}
	
	public void setMonthlyIncome(double income){
		if (income > 0){
			monthlyIncome = income;
		}
	}
	
	public void setAmountToSave(double save){
		if (save > 0){
			amountToSave = save;
		}
	}
	
	public void setMonthlyExpenses(double expenses){
		if (expenses > 0){
			monthlyExpenses = expenses;
		}
	}
	
	public double getMonthlyIncome(){
		return monthlyIncome;
	}
	
	public double getAmountToSave(){
		return amountToSave;
	}
	
	public double getMonthlyExpenses(){
		return monthlyExpenses;
}
	
	
	
	
