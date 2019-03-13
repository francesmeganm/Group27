import java.util.Scanner;

public class BudgetInfo  extends UserInfo{
	private double percentToSave = 0.0;
	private double amountToSave = 0.0;
	private double goalCost =0.0;
	private String goal;
	private double monthsTillGoal=0.0;
	private double remainingMoney=0.0;
	
	Scanner keyboard = new Scanner(System.in);
	public BudgetInfo(double psave, double cost, String agoal){
    	setPercentToSave(psave);
    	setGoalCost(cost);
		setGoal(agoal);
  	}
  	public BudgetInfo(BudgetInfo toCopy){
    	BudgetInfo budget = new BudgetInfo(toCopy);
  	}
 	public BudgetInfo(){}

	
	public double getAmountToSave(){
		System.out.print("What percentage of your salary would you like to save?");
		double percentToSave = keyboard.nextDouble();
		while(percentToSave < 0 || percentToSave > 100){
			System.out.println("That is not a valid percent. Please re-enter a valid percent(between 0 and 100(inclusive)).");
			getAmountToSave();
			percentToSave = keyboard.nextDouble();
		}
			amountToSave = (getMonthlyIncome() - getMonthlyExpenses()) * (percentToSave/100);
			return amountToSave;	
	}
	
		public double getPercentToSave(){
		while(percentToSave < 0 || percentToSave > 100){
			System.out.println("That is not a valid percent. Please re-enter a valid percent(between 0 and 100(inclusive)).");
			getPercentToSave();
			percentToSave = keyboard.nextDouble();
		}
			return percentToSave;	
	}

	public String getGoal(){
		System.out.print("Enter what you would like to save towards(ie. car, house, trip): ");
		goal = keyboard.nextLine();
		return goal;
	}
	
	public double getGoalCost(){	
		System.out.print("How much does what you would like to save towards cost?");
		goalCost = keyboard.nextDouble();
		return goalCost;
	}	
	
	public double getMonthsTillGoal(){
		monthsTillGoal=goalCost/amountToSave;
		return monthsTillGoal;
	}
	
	public double getRemainingMoney(){
		remainingMoney=getMonthlyIncome() - getMonthlyExpenses() - amountToSave;
		return remainingMoney;
	}
	
	public void setGoal(String agoal){
		goal=agoal;
	}
	public void setGoalCost(double cost ){
		goalCost=cost;
	} 
	public void setPercentToSave(double save ){
		percentToSave=save;
	} 

}
	
	
		
		
		//String savingInfo= "If you save "+Double.toString(monthlySavings)+"$ a month, It will take"+Double.toString(monthsToSave)+"months for you have saved enough money"   ;
		//return savingInfo;
		
	
	
	