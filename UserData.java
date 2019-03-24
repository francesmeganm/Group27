public class UserData{
	private double monthlyExpenses = 0.0;
	private double monthlyIncome = 0.0;
	private double percentToSave = 0.0;
	private double amountToSave = 0.0;
	
	public UserData(){};
	
	public UserData(double expenses, double income, double save){
		setMonthlyExpenses(expenses);
		setMonthlyIncome(income);
		setPercentToSave(save); 

	}
	
	public void setMonthlyIncome(double income){
		if (income > 0){
			monthlyIncome = income;
		}
	}
	
	public void setPercentToSave(double save){
		if (save > 0 && save < 100){
			amountToSave = (monthlyIncome - monthlyExpenses) * (save/100);
			percentToSave = save;
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
	
	public double getPercentToSave(){
		return percentToSave;
	}
	
	public double getMonthlyExpenses(){
		return monthlyExpenses;
	}

	public double getAmountToSave(){
		return amountToSave;
	}

	public double getRemainingMoney(){
		return monthlyIncome - monthlyExpenses - amountToSave;
	}
}
	
	
	
	
