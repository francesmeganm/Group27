import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class SaveBetter extends UserData{
	String menuList = "Update Income(0)		Update Expenses(1)		Update Amount to Save(2)		Show Budget Overview(3)";
	List<String> menu = new ArrayList<String>();
	String zero = "Update Income";
	String one = "Update Expenses";
	String two = "Update Amount to Save";
	String three = "Show Budget Overview";
	menu.add(zero);
	menu.add(one);
	menu.add(two);
	menu.add(three);

	
	public void displayMenu(){
		System.out.println(menuList);
	}
	
	public void getMenuOption(String s){
	}
	
	public static void main(String[] args){
	}
}
