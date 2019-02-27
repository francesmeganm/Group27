/**

*/
public class Expenses extends UserInfo{
	private double rent = 0.0;
	private double food = 0.0;
	private double transportation = 0.0; 
	private double utilities = 0.0;
	
	/**
	Defualt constructor- no parmerters 
	*/
	public Expenses(){
	}
	
	/**
	Constructor initializes all private instance variables 
	*/
	public Expenses(double rent, double food, double transportation, double utilities){
		this.rent = rent;
		this.food = food;
		this.transportation = transportation;
		this.utilities = utilties;
	}
	
	/**
	Method sets up the value of rent, with the condition that the rent is a non-negitive number
	@param rentCost the cost of rent to be set 
	*/
	public void setRent(double rentCost){
		if (rent >= 0){
			this.rent = rentCost;
		}
		else{
			this.rent = 0.0;
	}
	
	/**
	@return the value of the instance variable rent 
	*/
	pubic double getRent(){
		return rent;
	}
	
	/**
	Method sets up the value of food, with the condition that the food is a non-negitive number
	@param foodCost the cost of food to be set 
	*/
	public void setFood(double foodCost){
		if (food >= 0){
			this.food = foodCost;
		}
		else{
			this.food = 0.0;
	}
	
	/**
	@return the value of the instance variable food
	*/
	pubic double getFood(){
		return food;
	}
	
	/**
	Method sets up the value of transporation, with the condition that the transporation is a non-negitive number
	@param transporationCost the cost of transporation to be set 
	*/
	public void setTransportation(double transportationCost){
		if (transporation >= 0){
			this.transportation = transportationCost;
		}
		else{
			this.transportation = transporatation;
	}
	
	/**
	@return the value of the instance variable transporation
	*/
	pubic double getTransporation(){
		return transporation;
	}
	
	/**
	Method sets up the value of utilities, with the condition that the utilities is a non-negitive number
	@param utilitiesCost the cost of utilities to be set 
	*/
	public void setUtilities(double utilitiesCost){
		if (utilities >= 0){
			this.utilities = utilitiesCost;
		}
		else{
			this.utilities = utilities;
	}
	
	/**
	@return the value of the instance variable utilities
	*/
	pubic double getUtilities(){
		return utilities;
	}
	
	/**
	Method sums all the expenses up to get total expenses of the user for the month 
	@return the total value of all the expenses
	*/
	public double getTotalExpenses(){
		double total = rent + food + transportation + utilities;
		return total;
	}
}
