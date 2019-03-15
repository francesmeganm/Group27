import java.util.Date;
import java.util.Calendar;

public class BudgetInfo  extends UserInfo{
	private double amountToSave = 0.0;
	private double remainingMoney=0.0;

	public BudgetInfo(double amountToSave, double remainingMoney){
    	setRemainingMoney(remainingMoney);
    	setAmountToSave(amountToSave);

  	}

 	public BudgetInfo(){}

 	public BudgetInfo(UserInfo user){
 		super(user);
 	}

	public double getRemainingMoney(){
		remainingMoney = getMonthlyIncome() - getMonthlyExpenses() - amountToSave;
		return remainingMoney;
	}

	public void setRemainingMoney(double remain){
		this.remainingMoney = remain;
	}

	public double getAmountToSave(double percentToSave){
		while(percentToSave < 0 && percentToSave > 100){
			amountToSave = (super.getMonthlyIncome() - super.getMonthlyExpenses()) * (percentToSave / 100);
		}
		return amountToSave;	
	}
	public void setAmountToSave(double amt){
		this.amountToSave = amt;
	}

	//YOU NEED TO CITE THIS SHIT!!
	public Date getDateGoalCompleted(double goalCost){
		double monthsTillGoal = goalCost / amountToSave;

		Date d1 = new Date();
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.YEAR, 1);
		Date d2 = cal.getTime();
		return d2;
	}

}