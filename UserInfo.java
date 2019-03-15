import java.util.Scanner;
/**
Class contains all the montary related infomation about the user that they can change 
Has 7 instance variables, they are all type double: monthlyExpenses, monthlyIncome, 
transportCost, foodCost, otherCost, and rentCost 
*/
public class UserInfo{
	private double monthlyExpenses = 0.0;
	private double monthlyIncome = 0.0;
	private double transportCost = 0.0;
	private double utilityCost = 0.0; 
	private double otherCost = 0.0;
	private double rentCost = 0.0;
	
  	/**
  	Constructor that copies values in another UserInfo into the current UserInfo
  	@param toCopy is the account to copy from 
  	*/
  	public UserInfo(UserInfo toCopy){
    	setMonthlyExpenses(toCopy.getMonthlyExpenses());
    	setMonthlyIncome(toCopy.getMonthlyIncome());
    	setTransport(toCopy.getTransport());
    	setUtility(toCopy.getUtility());
    	setOther(toCopy.getUtility());
    	setRent(toCopy.getRent());
  	}

  	/**
  	Default constructor
  	*/
 	public UserInfo(){}
 	/**
 	Method sets a expense to transportation expense 
 	@param t is the transportation expense
 	*/

 	public void setTransport(double t){
 		this.transportCost = t;
 	}
 	
 	/**
 	@return the expense for transportation
 	*/
 	public double getTransport(){
 		return transportCost;
 	}

 	/**
 	Method sets a expense to utility expense 
 	@param u is the food expense 
 	*/
 	public void setUtility(double u){
 		this.utilityCost = u;
 	}

 	/**
 	@return the expense for utility  
 	*/
 	public double getUtility(){
 		return utilityCost;
 	}

 	/**
 	Method sets a expense for other expenses 
 	@param 0 is the other expense 
 	*/
 	public void setOther(double o){
 		this.otherCost = o;
 	}

 	/**
 	@return the expense for other expenses 
 	*/
 	public double getOther(){
 		return otherCost;
 	}

 	/**
 	Methods sets a expense for rent expense
 	@param r is the rent expense 
 	*/
 	public void setRent(double r){
 		this.rentCost = r;
 	}

 	/**
 	@return the expense for rent 
 	*/
 	public double getRent(){
 		return rentCost;
 	}
  
  	/**
  	Method adds all the expenses together to get total monthly expense 
  	@return monthlyExpenses 
  	*/
	public double getMonthlyExpenses() {
		monthlyExpenses = transportCost + utilityCost + rentCost + otherCost;
		return monthlyExpenses;
	}
	
	/**
	@return the monthly income 
	*/
	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	/**
	Method sets the income for the month
	@param income is the income for the month 
	*/
	public void setMonthlyIncome(double income) {
		monthlyIncome = income;
	}

	/**
	Method sets the monthly expenses 
	@param expenses is the monthly expenses 
	*/
	public void setMonthlyExpenses(double expenses){
		monthlyExpenses = expenses;
	}
}
