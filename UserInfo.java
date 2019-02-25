public class UserInfo{
	private String name = "";
	private double monthlyIncome;
	private double amountToSave;
	
	public UserInfo(String n, double income, double save){
		name = n;
		monthlyIncome = setMonthlyIncome();
		amountToSave = save; 
	}
	
	public void setMonthlyIncome(double income){
		if (income > 0){
			monthlyIncome = income;
		}
		else{
			monthlyIncome = 0.0;
		}
	}
	
	public vois setAmountToSave(double save){
		if (save > 0){
			amountToSave = save;
		}
		else{
			amountToSave = 0.0;
		}
	}
	
	public double getMonthlyIncome(){
		return monthlyIncome;
	}
	
	public double getAmountToSave(){
		return amountToSave;
	}
	
	public double getName(){
		return name;
	}
	
}
