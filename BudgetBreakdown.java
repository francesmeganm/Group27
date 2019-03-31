import java.util.Scanner;

public class BudgetBreakdown extends BudgetInfo{
	private double amountExtra=0.0; 
	private double amountForEntertainment=0.0;
	private double amountForPersonalCare=0.0;
	private double amountForFoodAndGroceries=0.0;
	private double amountForShopping=0.0;
	private double amountForMiscellaneous =0.0;
	private double percentExtra=0.0;

	public BudgetBreakdown(UserInfo user){
		super(user);
	}

	public void setAmountForEntertainment(double e){
		amountForEntertainment = e * super.getRemainingMoney();
	}
	
	public double getAmountForEntertainment(){
		return amountForEntertainment;
	}

	public void setAmountForPersonalCare(double p){
		amountForPersonalCare = p * super.getRemainingMoney();
	}

	public double getAmountForPersonalCare(){
		return amountForPersonalCare;
	}

	public void setAmountForFoodAndGroceries(double f){
		amountForFoodAndGroceries = f * super.getRemainingMoney();
	}

	public double getAmountForFoodAndGroceries(){
		return amountForFoodAndGroceries;
	}

	public void setAmountForShopping(double s){
		amountForShopping = s * super.getRemainingMoney();
	}

	public double getAmountForShopping(){
		return amountForShopping;
	}

	public void setAmountForMiscellaneous(double m){
		amountForMiscellaneous = m * super.getRemainingMoney();
	}

	public double getAmountForMiscellaneous(){
		return amountForMiscellaneous;
	}

	public double setAmountExtra(double e){
			amountExtra = (e * super.getRemainingMoney());
			return amountExtra;	
	}
}
	
	
	
	
	