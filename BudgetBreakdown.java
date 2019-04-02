import java.util.Scanner;

public class BudgetBreakdown extends BudgetInfo{
	private double amountForEntertainment=0.0;
	private double amountForPersonalCare=0.0;
	private double amountForFoodAndGroceries=0.0;
	private double amountForShopping=0.0;
	private double amountForMiscellaneous =0.0;
	private double amountExtra = 0.0;

	public BudgetBreakdown(UserInfo user){
		super(user);
	}

	public void setAmountForEntertainment(double e){
		e /= 100;
		amountForEntertainment = e * super.getRemainingMoney();
	}
	
	public double getAmountForEntertainment(){
		return amountForEntertainment;
	}

	public void setAmountForPersonalCare(double p){
		p /= 100;
		amountForPersonalCare = p * super.getRemainingMoney();
	}

	public double getAmountForPersonalCare(){
		return amountForPersonalCare;
	}

	public void setAmountForFoodAndGroceries(double f){
		f /= 100;
		amountForFoodAndGroceries = f * super.getRemainingMoney();
	}

	public double getAmountForFoodAndGroceries(){
		return amountForFoodAndGroceries;
	}

	public void setAmountForShopping(double s){
		s /= 100;
		amountForShopping = s * super.getRemainingMoney();
	}

	public double getAmountForShopping(){
		return amountForShopping;
	}

	public void setAmountForMiscellaneous(double m){
		m /= 100;
		amountForMiscellaneous = m * super.getRemainingMoney();
	}

	public double getAmountForMiscellaneous(){
		return amountForMiscellaneous;
	}

	public void setAmountExtra(){
		if ((amountForMiscellaneous + amountForShopping + amountForEntertainment + amountForPersonalCare + amountForFoodAndGroceries) != super.getRemainingMoney()){
			amountExtra = 1 - ((amountForMiscellaneous + amountForShopping + amountForEntertainment + amountForPersonalCare + amountForFoodAndGroceries) / super.getRemainingMoney()) * 
				super.getRemainingMoney(); 

		}
	}

	public double getAmountExtra(){
		return amountExtra;
	}
}
	
	
	
	
	