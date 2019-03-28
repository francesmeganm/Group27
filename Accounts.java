import java.util.Scanner;
import java.util.HashMap;
import javafx.application.Application;
import javafx.stage.Stage;

/**
Accounts class references a individual accounts that are stored in the hashmaps instance variables:
usernameAndPassword and usernameAndUserInfo. This class also extends from UserInfo which will hold the 
information contained in each account. 
*/


public class Accounts{
  protected static HashMap<String, String> usernameAndPassword = new HashMap<String, String>();
  protected static HashMap<String, UserInfo> usernameAndUserInfo = new HashMap<String, UserInfo>();


  /**
  Method createAccount creates a new user account containing a username and password, 
  which creates a new instance of a User (userInfo) and prompts them to enter the required info after calling the UserInfo class. 
  @param username unique username inputed from the user
  @param password unique password inputed from the user 
  */
	public void createAccount(String username, String password){
  	usernameAndPassword.put(username, password);
    UserInfo info = new UserInfo();
    usernameAndUserInfo.put(username, info);
  }

  /** 
  Method checkUsername checks the username inputed from the user to ensure that there is not an existing username in our database 
  with the same username. It ensures the username is unique. 
  @param username username inputed from the user to check
  @return a boolean value that results in true if the username is unique
  */
  public boolean checkUsername(String username){
    boolean isUnique = true;
    if (usernameAndPassword.containsKey(username)){
      isUnique = false;
    }
    return isUnique;
  }

  /**
  Method verifyUsernameAndPassword checks the hashmap usernameAndPassword to verify if the inputed username and password 
  are existing user accounts in the app. 
  @param username inputed username to check 
  @param password inputed password to check 
  @return a boolean value that results in true if the username and password are the correct credentials of an existinga account 
  */
  public boolean verifyUsernameAndPassword(String username, String password){
    boolean isCorrect = false;
    String p = usernameAndPassword.get(username);
    if (p.equals(password)){
      isCorrect = true;
    }
    return isCorrect;
  }
  
  /** 
  @return the hashmap containing the usernames and passwords of existing accounts 
  */
	public HashMap<String, String> getUsernameAndPassword(){
    return usernameAndPassword;
  }
  
  /** 
  @return the hashmap containing the usernames and user info of existing accounts 
  */
  public HashMap<String, UserInfo> getUsernameAndUserInfo(){
    return usernameAndUserInfo;
  }
}