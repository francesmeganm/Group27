import java.util.Scanner;
/**
Class contains all the montary related infomation about the user that they can change 
Has 7 instance variables, they are all type double: monthlyExpenses, monthlyIncome, 
transportCost, foodCost, entertainmentCost, otherCost, and rentCost 
*/
public class UserInfo{
	private double monthlyExpenses = 0.0;
	private double monthlyIncome = 0.0;
	private double transportCost = 0.0;
	private double foodCost = 0.0;
	private double entertainmentCost = 0.0;
	private double otherCost = 0.0;
	private double rentCost = 0.0;
	Scanner keyboard = new Scanner(System.in);

	/**
	Constructor that sets all instance variables 
	@param exp is the monthly expenses 
	@param inc is the monthly income
	@param t is the monthly transporatation expense 
	@param f is the monthly food expense
	@param e is the monthly entertainment expesnse 
	@param o is the monthly other expense 
	@param r is the monthly rent cost
	*/

 	public UserInfo(double exp, double inc, double t, double f, double e, double o, double r){
    	setMonthlyIncome(inc);
    	setMonthlyExpenses(exp);
    	setTransport(t);
    	setFood(f);
    	setEntertainment(e);
    	setOther(o);
    	setRent(r);
  	}
  	/**
  	Constructor that copies values in another UserInfo into the current UserInfo
  	@param toCopy is the account to copy from 
  	*/
  	public UserInfo(UserInfo toCopy){
    	UserInfo user = new UserInfo(toCopy);
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
 	Method sets a expense to food expense 
 	@param f is the food expense 
 	*/
 	public void setFood(double f){
 		this.foodCost = f;
 	}

 	/**
 	@return the expense for food  
 	*/
 	public double getFood(){
 		return foodCost;
 	}

 	/**
 	Method sets a expense for entertainment expense 
 	@param e is the entertainment expense 
 	*/
 	public void setEntertainment(double e){
 		this.entertainmentCost = e;
 	}

 	/**
 	@return the expense for food 
 	*/
 	public double getEntertainment(){
 		return entertainmentCost;
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
		monthlyExpenses = transportCost + foodCost + entertainmentCost + rentCost + otherCost;
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
