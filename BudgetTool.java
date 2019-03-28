public class BudgetTool{
	//inputing user info // no this is in the GUI
	//does things that you know need to be completed from interaction from the user

	private UserInfo user;
	private BudgetInfo smallBudget;
	private BudgetBreakdown largeBudget;
	private Accounts account;//do we need this??

	public BudgetTool(){
		account = new Accounts();
		user = new UserInfo();
		smallBudget = new BudgetInfo(user);
		largeBudget = new BudgetBreakdown(user);
	}

	public boolean checkingUsername(username){
		boolean choice = user.checkUsername(username);
    return choice;
	} 

	public void makeAccount(String username, String password){
		//need to make a constructor to attach account and to user info, not sure
		//how to do this but should not combine the two 	
		account.createAccount(username, password);
	}

	public boolean checkingLogin(String username, String password){
		boolean verify = account.verifyUsernameAndPassword();
		return verify;
	}

  public void updateUserInfo(double trans, double uti, double oth, double rent, double inc){
    if (trans != 0){
      user.setTrasport(trans);
    }
    if (uti != 0){
      user.setUtility(uti);
    }
    if (oth != 0){
      user.setOther(oth);
    }
    if (rent != 0){
      user.setRentRent(rent);
    }
    if (inc != 0){
      user.setMonthlyIncome(inc);
    }
  }
  
  public void month(String month){
    //method choocse which month you are in
  }
  
  public double gettingTheRemainingMoney(){
    user.getRemainingMoney(remain);
  }
	
  public double gettingTheAmountToSave(){
    return user.getAmountToSave();
  }
  
  public void settingTheAmountToSave(double save){
    user.setAmountToSave(save);
  }
  
  public Date gettingDateGoalCompleted(double goalCost){
    return user.getDateGoalCompleted(goalCost);
  }
  
  public void settingBudgetBreakdown(double ent, pers, food, shop, misc){
    if (ent != 0){
      user.setAmountForEntertainment(ent);
    }
    if (pers != 0){
      user.setAmountForPersonalCare(pers);
    }
    if (food != 0){
      user.getAmountForFoodAndGroceries(food);
    }
    if (shop != 0){
      user.setAmountForShopping(shop);
    }
    if (misc != 0){
      user.setAmountForMiscellaneous(misc);
    }
  }
	
  public double gettingEntertainment(){
    return user.getAmountForEntertainment();
  }
  
  public double gettingPersonal(){
		return user.getAmountForPersonalCare();
  }
  
  public double gettingFood(){
    return user.getAmountForFoodAndGroceries();
  }
  
  public double gettingShopping(){
    return user.getAmountForShopping();
  }
  
  public double gettingMisc(){
    return user.getAmountForMiscellaneous();
  }
	
}