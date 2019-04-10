import java.util.Date;
import java.util.Calendar;
import java.lang.Math.*;
/** The class BudgetInfo extends from UserInfo. This class contains all calculations to do with 
 * the "simple" budget aspect of SaveBetter
 * There a three instance variables: remaining money is a double, amountToSave is a double, and 
 * user which is an instance of UserInfo
 */
public class BudgetInfo extends UserInfo{
	private double amountToSave = 0.0;
	private double remainingMoney;
	private Date userDate = new Date();
	private UserInfo user;

	/**
	 *Default Contructor - takes no arguments 
	 */
	public BudgetInfo(){}

	/**
	 * Contrustor takes a UserInfor and set the instance variable user 
	 * @param user is a instance of UserInfo
	 */
 	public BudgetInfo(UserInfo user){
 		this.user = user; 
 	}

 	/**
 	 * Method calculates the remaining money by subtracting the users monthly expenses 
 	 * from the users monthly income
 	 *@return remainingMoney for the month
 	 */
	public double getRemainingMoney(){
		setRemainingMoney(user.getMonthlyIncome() - user.getMonthlyExpenses());
		return remainingMoney;
	}

	/**
	 * Method sets the remainingMoney instance variable
	 * @param remain is the remaining money
	 */
	public void setRemainingMoney(double remain){
		this.remainingMoney = remain;
	}

	/**
	 * This method calculates how much the users needs to save of their remaining money to 
	 * save an ideal percent they decide 
	 * @param percentToSave is percent of the users remaining money they would like to save 
	 * this is expressed in a whole number percent 
	 * @return amountToSave which is the dollar amount the user needs to save to reach their 
	 * ideal percent to save of remaining money
	 */
	public double getAmountToSave(double percentToSave){
		amountToSave = (user.getMonthlyIncome() - user.getMonthlyExpenses()) * (percentToSave / 100);
		return amountToSave;	
	}

	/**
	 * This is a setting method
	 * *param amt is the amount to save 
	 */
	public void setAmountToSave(double amt){
		this.amountToSave = amt;
	}

	/**
	 * This is a setting method for the date the user wants to use
	 * @param date is the date the user would like to make a budget for
	 */
	public void setDate(Date date){
		this.userDate = date;
	}

	/**
	 *This is a getter method that returns the userDate
	 *@return userDate
	 */
	public Date getDate(){
		return userDate;
	}

	/**
	 * This method take the cost of a goal and calulates how long it is going to take
	 * to complete this goal given their monthly income, expense,the day they
	 * choose to start, and how much they are trying 
	 * to save each month
	 * @param goalCost is the total cost of the goal the user is saving towards 
	 * @return d2 is the date the goal will be completed by 
	 */
	public Date getDateGoalCompleted(double goalCost){
		double daysTillGoal = goalCost / amountToSave * 30;
		double days = Math.ceil(daysTillGoal);
		Date d1 = getDate();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		if (days > 365){
			int year = (int) days / 365;
			days -= (year * 365);
			int month = (int)days / 30;
			days = days % 30;
			cal.add(Calendar.YEAR, year);
			cal.add(Calendar.DATE, (int) days);
			cal.add(Calendar.MONTH, month);
		}
		else if (days > 30){
			int month = (int)days / 30;
			days = days % 30;
			cal.add(Calendar.DATE, (int) days);
			cal.add(Calendar.MONTH, (int) month);
		}
		else{
			cal.add(Calendar.DAY_OF_MONTH, (int) days);
		}
		Date d2 = cal.getTime();
		return d2;
	}
}
