import java.util.Date;
import java.util.Calendar;
import java.lang.Math.*;

public class BudgetInfo  extends UserInfo{
	private double amountToSave = 0.0;
	private double remainingMoney=0.0;

 	public BudgetInfo(UserInfo user){
 		super(user);
 		//this.remainingMoney = rem;
 	}

	public double getRemainingMoney(){
		remainingMoney = getMonthlyIncome() - getMonthlyExpenses();
		return remainingMoney;
	}

	public void setRemainingMoney(double remain){
		this.remainingMoney = remain;
	}

	public double getAmountToSave(double percentToSave){
			amountToSave = (super.getMonthlyIncome() - super.getMonthlyExpenses()) * (percentToSave / 100);
		return amountToSave;	
	}
	public void setAmountToSave(double amt){
		this.amountToSave = amt;
	}

	//YOU NEED TO CITE THIS SHIT!!
	public Date getDateGoalCompleted(double goalCost){

		double monthsTillGoal = goalCost / amountToSave;
		double months = Math.ceil(monthsTillGoal);
		Date d1 = new Date();
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		cal.add(Calendar.MONTH, (int) months);
		Date d2 = cal.getTime();
		return d2;
	}

}
