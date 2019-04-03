import java.util.Date;
import java.util.Scanner;

/**
* The class BudgetTool serves as a intermediary between the logic and what the user intracts with. 
* This class had methods of all the function the user could poentially use when running the program. 
* There are four instance variables which are are instances of logic classes: user is of type UserInfo, 
* smallBudget is of type BudgetInfo, largeBudget is of type BudgetBreakdown, account is of type 
* Accounts. The last instance variable is keyboard which is of type Scanner imported from Java.util.
*/
public class BudgetTool{
	private UserInfo user = new UserInfo();
	private BudgetInfo smallBudget;
	private BudgetBreakdown largeBudget;
	private Accounts account;
  private Scanner keyboard = new Scanner(System.in);

  /**
   * Constructor take no arguments 
   * Makes a new instance of Accounts, BudgetInfo, and BudgetBreakdown and 
   * assignd them to the proper instance variables
   */
	public BudgetTool(){
		account = new Accounts();
		smallBudget = new BudgetInfo(user);
		largeBudget = new BudgetBreakdown(user);
	}

  /**
   * This method checks when a user is creating an account if the username in already
   * taken. Returns false if the username is not avalible.
   * @param username 
   * @return choice is a boolean value if the user matched previously created user
   */
	public boolean checkingUsername(String username){
		boolean choice = account.checkUsername(username);
    return choice;
	} 

  /**
   * This method creates an account for the user in the Accounts class
   * @param username the user inputs
   * @param password the user inputs 
   */
	public void makeAccount(String username, String password){
		account.createAccount(username, password);
	}

  /** 
   * This method checks whether the username and password entered by the user are
   * valid. This is done by checking the usernameAndPassword HashMap in Accounts.
   * If the username and password are in the hashmap the boolean value ture will be returned 
   * @param username the user inputs 
   * @param username the user inputs 
   * @return verify a boolean value 
   */
	public boolean checkingLogin(String username, String password){
		boolean verify = account.verifyUsernameAndPassword(username, password);
		return verify;
	}

  /**
   * Sets the UserInfo user
   * @param currentUser
   */
  public void setUser(UserInfo currentUser){
    user = currentUser;
  }

  /**
   * Returns the current user  
   * @return user is the current UserInfo
   */
  public UserInfo getCurrentUser(){
    return user;
  }

  /**
   * This methods checks if the user inputed a vaild percentage in whole numbers 
   * must be a value between 0 and 100
   * @param percent is the percent entered by user 
   * @return percent if it is with the values 
   */
  public double checkIfValidPercent(double percent){
    while (percent < 0 || percent > 100){
      System.out.print("That is an invlaid percent. Please enter a percent between 0 and 100%: ");
      percent = keyboard.nextInt();
    }
    return percent;
  }

  /**
   * This method updates all the user info in UserInfo user, will only update if the value is not equaly to zero
   * @param trans is the monthly trasnporation cost
   * @param uti is the monthly utility cost
   * @param oth is the monthly other cost
   * @param rent is the monthly rent cost
   * @param inc is the monthly inc cost
   */
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
  

  /**
   * Method sets the date the user is making a budget for 
   * @para date is the users desired date
   */
  public void month(Date date){
    //method choocse which month you are in
  }
  
  /**
   * Is a get method for the remaining money
   * Using methods in the BudgetInfo class
   * @return remainingMoney of the user
   */
  public double gettingTheRemainingMoney(){
    return smallBudget.getRemainingMoney();
  }
	
  /**
   * Is a get method for the amount to save 
   * Using methods in the BudgetInfo class
   * @return amountToSave of the user
   */
  public double gettingTheAmountToSave(double percent){
    return smallBudget.getAmountToSave(percent);
  }
  
  /**
   * Sets the amount of money to save of remaining moeny 
   * Using methhods fron the BudgetInfo class
   * @para save is the amount the user wants to save
   */
  public void settingTheAmountToSave(double save){
    smallBudget.setAmountToSave(save);
  }
  
  /** 
   * When the user inputs a goal to save for computes when the user will 
   * accmplish this goal given the date they have previously inputed or default
   * to the current date
   * @param goalCost is the total cost of a goal for the user
   * @return d2 is the date the goal is expected to completed 
   */
  public Date gettingDateGoalCompleted(double goalCost){
    return smallBudget.getDateGoalCompleted(goalCost);
  }
  
  /** 
   * This method sets all the percentanges that the user would like to spend their remaining money on. 
   * All percentages are in whole numbers. Does not set the percentage if the value is 0.
   * This is using methods from the BudgetBreakdown class
   * @param ent is the percent for entertainment
   * @param pers is the percent for personal care
   * @param food is the percent for food and groceries 
   * @param shop is the percent for shopping 
   * @param misc is the percent for miscellanoues
   */
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
	
  /** 
   * This is a getter method. Uses methods from the BudgetBreakdown class
   * @return amountForEntertainment in dollar amount
   */
  public double gettingEntertainment(){
    return largeBudget.getAmountForEntertainment();
  }
  
  /** 
   * This is a getter method. Uses methods from the BudgetBreakdownclass
   * @return amountForPersonal in dollar amount
   */
  public double gettingPersonal(){
		return largeBudget.getAmountForPersonalCare();
  }
  
  /**
   * This is a getter method. Uses methods from the BudgetBreakdown class
   * @return amountForFood in dollar amount
   */
  public double gettingFood(){
    return largeBudget.getAmountForFoodAndGroceries();
  }
  
  /**
   * This is a getter method. Uses methods from the BudgetBreakdown class
   * @return amountForShopping in dollar amount
   */
  public double gettingShopping(){
    return largeBudget.getAmountForShopping();
  }
  
  /**
   * This is a getter method. Uses methods from the BudgetBreakdown class
   * @return amountForMiscellaneous in dollar amount
   */
  public double gettingMisc(){
    return largeBudget.getAmountForMiscellaneous();
  }	

  /**
   * This is a getter method. Uses methods from the BudgetBreakdown class
   * @return amountExtra in dollar amount
   */
  public double gettingExtra(){
    return largeBudget.getAmountExtra();
  }
}