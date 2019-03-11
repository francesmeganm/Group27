import java.util.Scanner;
import java.util.HashMap;

public class Accounts extends UserInfo{
  protected static HashMap<String, String> usernameAndPassword = new HashMap<String, String>();
  protected static HashMap<String, UserInfo> usernameAndUserInfo = new HashMap<String, UserInfo>();

  Scanner keyboard = new Scanner(System.in);
  
	public void createAccount(String username, String password){
  	usernameAndPassword.put(username, password);
    UserInfo info = new UserInfo();
    usernameAndUserInfo.put(username, info);
    info.getMonthlyExpenses();
  }

  public boolean checkUsername(String username){
    boolean isUnique = true;
    if (usernameAndPassword.containsKey(username)){
      isUnique = false;
      System.out.println("Sorry that username is already taken, please try another: ");
      System.out.print("Enter a new username");
      username = keyboard.next();
    }
    return isUnique;
  }

  public boolean verifyUsernameAndPassword(String username, String password){
    boolean isCorrect = true;
    if (usernameAndPassword.get(username) != password){
      System.out.println("You have entered an invalid username/password. Please try again.");
      isCorrect = false;
      System.out.print("Enter username: ");
      username = keyboard.next();
      System.out.print("Enter password: ");
      password = keyboard.next(); 
    }
    return isCorrect;
  }
  
	public HashMap<String, String> getUsernameAndPassword(){
    return usernameAndPassword;
  }
  
  public HashMap<String, UserInfo> getUsernameAndUserInfo(){
    return usernameAndUserInfo;
  }
}