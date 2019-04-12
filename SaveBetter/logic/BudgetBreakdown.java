package logic;


import gui.*;
import calendar.*;
import text.*;

/**
 * The classs BudgetBreakdown extends BudgetInfo which extends UserInfo
 * This class calulcates the users budget to a more complex degree that Budget Info
 * BudgetBreakdown calucates amount the users should spend in various not essential categories
 * There are six instance variables in this class: amountForEntertainment is a double, 
 * amountForPersonalCare is a double, amountForFoodAndGroceries is a double, 
 * amountForShopping is a double, amountForMiscellaneous is a double, and lastly 
 * amountExtra is also a double 
 */
public class BudgetBreakdown extends BudgetInfo{
	private double amountForEntertainment=0.0;
	private double amountForPersonalCare=0.0;
	private double amountForFoodAndGroceries=0.0;
	private double amountForShopping=0.0;
	private double amountForMiscellaneous =0.0;
	private double amountExtra = 0.0;

	/**
	 * Constructor set the instance variable user in BudgetInfo class by using 
	 * "super" and called the parent method
	 * @param user sets UserInfo user
	 */
	public BudgetBreakdown(UserInfo user){
		super(user);
	}

	/**
	 * This method calclates the amount for entertainment by converting the whole percent 
	 * to a decimal and multiplying by the users remaining money
	 * The methods set this calulated value to the instance variable amountForEnterainment
	 * @param e is the percent to spend on entertainment
	 */
	public void setAmountForEntertainment(double e){
		e /= 100;
		amountForEntertainment = e * super.getRemainingMoney();
	}
	
	/**
	 * This is a get method
	 * @return amountForEntertainment is the amount to spend on entertianment
	 */
	public double getAmountForEntertainment(){
		return amountForEntertainment;
	}

	/**
	 * This method calclates the amount for personal care by converting the whole percent 
	 * to a decimal and multiplying by the users remaining money
	 * The methods set this calulated value to the instance variable amountForPersonalCare
	 * @param p is the percent to spend on personal care
	 */
	public void setAmountForPersonalCare(double p){
		p /= 100;
		amountForPersonalCare = p * super.getRemainingMoney();
	}

	/**
	 * This is a get method
	 * @return amountForPersonalCare is the amount to spend on personal care
	 */
	public double getAmountForPersonalCare(){
		return amountForPersonalCare;
	}

	/**
	 * This method calclates the amount for food and groceries by converting the whole percent 
	 * to a decimal and multiplying by the users remaining money
	 * The methods set this calulated value to the instance variable amountForFoodAndGroceries
	 * @param f is the percent to spend on food and groceries
	 */
	public void setAmountForFoodAndGroceries(double f){
		f /= 100;
		amountForFoodAndGroceries = f * super.getRemainingMoney();
	}

	/**
	 * This is a get method
	 * @return amountForFoodAndGroceries is the amount to spend on food and groceries
	 */
	public double getAmountForFoodAndGroceries(){
		return amountForFoodAndGroceries;
	}

	/**
	 * This method calclates the amount for shopping by converting the whole percent 
	 * to a decimal and multiplying by the users remaining money
	 * The methods set this calulated value to the instance variable amountForShopping
	 * @param s is the percent to spend on shopping
	 */
	public void setAmountForShopping(double s){
		s /= 100;
		amountForShopping = s * super.getRemainingMoney();
	}

	/**
	 * This is a get method
	 * @return amountForShopping is the amount to spend on shopping
	 */
	public double getAmountForShopping(){
		return amountForShopping;
	}

	/**
	 * This method calclates the amount for michellaneous by converting the whole percent 
	 * to a decimal and multiplying by the users remaining money
	 * The methods set this calulated value to the instance variable amountForMicellaneous
	 * @param m is the percent to spend on shopping
	 */
	public void setAmountForMiscellaneous(double m){
		m /= 100;
		amountForMiscellaneous = m * super.getRemainingMoney();
	}

	/**
	 * This is a get method
	 * @return amountForMicellaneous is the amount to spend on miscellaneous
	 */
	public double getAmountForMiscellaneous(){
		return amountForMiscellaneous;
	}

	/**
	 * This method caulcates the money left for the user in remaining money if 100% percent is not allocated  
	 * between the five different areas
	 */
	public void setAmountExtra(){
		if ((amountForMiscellaneous + amountForShopping + amountForEntertainment + 
			amountForPersonalCare + amountForFoodAndGroceries) != super.getRemainingMoney()){
			amountExtra = super.getRemainingMoney() - ((amountForMiscellaneous + amountForShopping + amountForEntertainment + 
				amountForPersonalCare + amountForFoodAndGroceries)); 

		}
	}

	/**
	 * This is a get method
	 * @return amountExtra
	 */ 
	public double getAmountExtra(){
		return amountExtra;
	}
}
	
	
	
	
	