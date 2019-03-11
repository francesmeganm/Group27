import java.util.Scanner;
import java.util.HashMap;

public class Login extends Accounts{
  
  //main method runs the program
  public static void main(String[] args){
    String username;
    String password;

    String loginMenu = "Login [1] Create Account [2]";
    
    Accounts acct = new Accounts();

    usernameAndPassword = acct.getUsernameAndPassword();
    Scanner keyboard = new Scanner(System.in);

    System.out.println(loginMenu);
    int input = keyboard.nextInt();
  
    while (input != 1 && input != 2){
      System.out.println("That is not a valid option. Please re-enter a valid menu option.");
      System.out.println(loginMenu);
      input = keyboard.nextInt();
    }
    
    if (input == 1){
      System.out.print("Enter a new username: ");
      username = keyboard.nextLine();
      
      while (usernameAndPassword.containsKey(username)){
        System.out.print("Sorry that username is already taken, please try another: ");
        System.out.print("Enter a new username");
        username = keyboard.nextLine();
      } 
      System.out.println("Enter a new password: ");
      password = keyboard.nextLine();
      acct.createAccount(username, password);
    }

    else if (input == 2){
      System.out.print("Enter username: ");
      username = keyboard.nextLine();
      System.out.print("Enter password: ");
      password = keyboard.nextLine();
      
      while (usernameAndPassword.get(username) != password){
        System.out.println("You have entered an invalid username/password. Please try again.");
        System.out.print("Enter username: ");
        username = keyboard.nextLine();
        System.out.print("Enter password: ");
        password = keyboard.nextLine();   
      }

      if (usernameAndPassword.get(username) == password){
        //need a copy constructor for userinfo to copy their information - OOL 
        UserInfo currentAccount = new UserInfo(usernameAndUserInfo.get(username));
      }
    }
  } 
}