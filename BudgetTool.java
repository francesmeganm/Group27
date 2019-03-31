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

	public boolean checkingUsername(String username){
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

  public void setUser(User currentUser){
    user = currentUser;
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


	
}