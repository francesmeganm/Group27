import java.util.Scanner;
import java.util.HashMap;

public class Accounts extends UserInfo{
  protected static HashMap<String, String> usernameAndPassword = new HashMap<String, String>();
  protected static HashMap<String, UserInfo> usernameAndUserInfo = new HashMap<String, UserInfo>();
  
  public void createAccount(String username, String password){
    usernameAndPassword.put(username, password);
    UserInfo info = new UserInfo();
    usernameAndUserInfo.put(username, info);
    info.getMonthlyExpenses();
    info.getMonthlyIncome();
  }
  
  public HashMap<String, String> getUsernameAndPassword(){
    return usernameAndPassword;
  }
  
  public HashMap<String, UserInfo> getUsernameAndUserInfo(){
    return usernameAndUserInfo;
  }
}