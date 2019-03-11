import java.util.Scanner;
import java.util.HashMap;

public class Login extends Accounts{

  private static String loginMenu = "Login [1] Create Account [2]";

  public static void getLoginMenu(){
    System.out.println(loginMenu);
  }

  //main method runs the program
  public static void main(String[] args){
    String username;
    String password;

    Accounts acct = new Accounts();
    Scanner keyboard = new Scanner(System.in);

    getLoginMenu();
    int input = keyboard.nextInt();
  
    while (input != 1 && input != 2){
      System.out.println("That is not a valid option. Please re-enter a valid menu option.");
      getLoginMenu();
      input = keyboard.nextInt();
    }
    
    if (input == 2){
      System.out.print("Enter a new username: ");
      username = keyboard.next();
      
      while (!acct.checkUsername(username)){
        acct.checkUsername(username);
      } 

      System.out.print("Enter a new password: ");
      password = keyboard.next();
      acct.createAccount(username, password);
    }

    else if (input == 1){
      System.out.print("Enter username: ");
      username = keyboard.next();
      System.out.print("Enter password: ");
      password = keyboard.next();
      
      while (!acct.verifyUsernameAndPassword(username, password)){
        acct.verifyUsernameAndPassword(username, password); 
      }

      UserInfo currentAccount = new UserInfo(usernameAndUserInfo.get(username));
    }
  } 
}