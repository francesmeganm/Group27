import java.util.Scanner;

public class UserInfo{

	private double monthlyExpenses = 0.0;
	private double monthlyIncome = 0.0;
	private double transportCost = 0.0;
	private double foodCost = 0.0;
	private double entertainmentCost = 0.0;
	private double otherCost = 0.0;
	private double rentCost = 0.0;

	Scanner keyboard = new Scanner(System.in);
	
 	public UserInfo(double exp, double inc, double t, double f, double e, double o, double r){
    	setMonthlyIncome(inc);
    	setMonthlyExpenses(exp);
    	setTransport(t);
    	setFood(f);
    	setEntertainment(e);
    	setOther(o);
    	setRent(r);
  	}
  	public UserInfo(UserInfo toCopy){
    	UserInfo user = new UserInfo(toCopy);
  	}
 	public UserInfo(){}

 	public void setTransport(double t){
 		this.transportCost = t;
 	}

 	public double getTransport(){
 		return transportCost;
 	}

 	public void setFood(double f){
 		this.foodCost = f;
 	}

 	public double getFood(){
 		return foodCost;
 	}

 	public void setEntertainment(double e){
 		this.entertainmentCost = e;
 	}

 	public double getEntertainment(){
 		return entertainmentCost;
 	}

 	public void setOther(double o){
 		this.otherCost = o;
 	}

 	public double getOther(){
 		return otherCost;
 	}

 	public void setRent(double r){
 		this.rentCost = r;
 	}

 	public double getRent(){
 		return rentCost;
 	}
  
	public double getMonthlyExpenses() {
		monthlyExpenses = transportCost + foodCost + entertainmentCost + rentCost + otherCost;
		return monthlyExpenses;
	}
	
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	
	public void setMonthlyIncome(double income) {
		monthlyIncome = income;
	}

	public void setMonthlyExpenses(double expenses){
		monthlyExpenses = expenses;
	}
}
