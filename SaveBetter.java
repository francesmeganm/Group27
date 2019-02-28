import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class SaveBetter extends UserData{
	String menuList = "Update Income		Update Expenses		Update Amount to Save		Show Budget Overview";
	
	public void displayMenu(){
		System.out.println(menuList);
	}

	Scanner keyboard = new Scanner(System.in);
	
	public void getMenuOption(String choice){
		if (choice == "Update Income"){
			System.out.print("Enter new Income: ");
			double updatedIncome = keyboard.nextInt();
			super.setMonthlyIncome(updatedIncome);
			System.out.println("Your new income is: " + updatedIncome);
		}
	}

	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		input = keyboard.newLine();
		while (input != ""){
			
		}
	}
}
