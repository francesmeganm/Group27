import java.util.Date;
import java.util.Scanner;

public class BudgetTool{
	//inputing user info // no this is in the GUI
	//does things that you know need to be completed from interaction from the user

	private UserInfo user = new UserInfo();
	private BudgetInfo smallBudget;
	private BudgetBreakdown largeBudget;
	private Accounts account;//do we need this??
  private Scanner keyboard = new Scanner(System.in);

	public BudgetTool(){
		account = new Accounts();
		//setUser(currentUser);

		smallBudget = new BudgetInfo(user);
		largeBudget = new BudgetBreakdown(user);
	}

 // public void setUser(UserInfo userInfo)

	public boolean checkingUsername(String username){
		boolean choice = account.checkUsername(username);
    return choice;
	} 

	public void makeAccount(String username, String password){
		//need to make a constructor to attach account and to user info, not sure
		//how to do this but should not combine the two 	
		account.createAccount(username, password);
	}

	public boolean checkingLogin(String username, String password){
		boolean verify = account.verifyUsernameAndPassword(username, password);
		return verify;
	}

  public void setUser(UserInfo currentUser){
    user = currentUser;
  }

  public UserInfo getCurrentUser(){
    return user;
  }

  public double checkIfValidPercent(double percent){
    while (percent < 0 || percent > 100){
      System.out.print("That is an invlaid percent. Please enter a percent between 0 and 100%: ");
      percent = keyboard.nextInt();
    }
    return percent;
  }

  public void updateUserInfo(double trans, double uti, double oth, double rent, double inc){
    if (trans != 0){
      user.setTransport(trans);
    }
    if (uti != 0){
      user.setUtility(uti);
    }
    if (oth != 0){
      user.setOther(oth);
    }
    if (rent != 0){
      user.setRent(rent);
    }
    if (inc != 0){
      user.setMonthlyIncome(inc);
    }
  }
  
  public void month(String month){
    //method choocse which month you are in
  }
  
  public double gettingTheRemainingMoney(){
    return smallBudget.getRemainingMoney();
  }
	
  public double gettingTheAmountToSave(double percent){
    return smallBudget.getAmountToSave(percent);
  }
  
  public void settingTheAmountToSave(double save){
    smallBudget.setAmountToSave(save);
  }
  
  public Date gettingDateGoalCompleted(double goalCost){
    return smallBudget.getDateGoalCompleted(goalCost);
  }
  
  public void settingBudgetBreakdown(double ent, double pers, double food, double shop, double misc){
    if (ent != 0){
      largeBudget.setAmountForEntertainment(ent);
    }
    if (pers != 0){
      largeBudget.setAmountForPersonalCare(pers);
    }
    if (food != 0){
      largeBudget.setAmountForFoodAndGroceries(food);
    }
    if (shop != 0){
      largeBudget.setAmountForShopping(shop);
    }
    if (misc != 0){
      largeBudget.setAmountForMiscellaneous(misc);
    }
    largeBudget.setAmountExtra();
  }
	
  public double gettingEntertainment(){
    return largeBudget.getAmountForEntertainment();
  }
  
  public double gettingPersonal(){
		return largeBudget.getAmountForPersonalCare();
  }
  
  public double gettingFood(){
    return largeBudget.getAmountForFoodAndGroceries();
  }
  
  public double gettingShopping(){
    return largeBudget.getAmountForShopping();
  }
  
  public double gettingMisc(){
    return largeBudget.getAmountForMiscellaneous();
  }	

  public double gettingExtra(){
    return largeBudget.getAmountExtra();
  }
}