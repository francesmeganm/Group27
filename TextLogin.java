import java.util.Scanner;

public class TextLogin{
	public void login. 
}





public class SaveBetterText{
	String menuList = "\nUpdate User Info// Show Budget Overview";
	String updateList = "\nUpdate All // Update Income // Update Expenses // Update Amount To Save";
	
	Scanner keyboard = new Scanner(System.in);
	
	public void getMenuOption(int choice){
		double returnStatement = 0.0;
		if (choice == 0){
			System.out.print("Enter new income: ");
			double updatedIncome = keyboard.nextInt();
			super.setMonthlyIncome(updatedIncome);
			System.out.println("Your new income is: " + updatedIncome + "\n");
		}

		if (choice == 1){
			System.out.print("Enter new expenses: ");
			double updatedExpenses = keyboard.nextInt();
			super.setMonthlyExpenses(updatedExpenses);
			System.out.println("Your new expenses is: " + updatedExpenses + "\n");
		}

		if (choice == 2){
			System.out.print("Enter % of remaining income you would like to save: ");
			double updatedPercentToSave = keyboard.nextInt();
			super.setPercentToSave(updatedPercentToSave);
			System.out.println("Your new desired % of income to save: " + updatedPercentToSave + "\n");
		}
	}

	public void getBudgetOverview(){
		System.out.println("\nThis is your budget overview: \n" +  
			"Desired amount to save a month: " + super.getAmountToSave() + "\n" + 
			"Money left to spend this month: " + super.getRemainingMoney());
	}

	public static void main(String[] args){
		ArrayList<String> menu = new ArrayList<String>();
		menu.add("Update User Info");
		menu.add("Show Budget Overview");

		ArrayList<String> update = new ArrayList<String>();
		update.add("Update All");
		update.add("Update Income");
		update.add("Update Expenses");
		update.add("Update Amount To Save");

		SaveBetter sb = new SaveBetter();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("To quit enter a blank line");
		System.out.println(sb.menuList);
		String input = keyboard.nextLine();

		while (!(input.isEmpty())){
			int index = menu.indexOf(input);
			if (index == 0){
				System.out.println(sb.updateList);
				input = keyboard.nextLine();
				index = update.indexOf(input);
				if (index == 0){
					sb.getMenuOption(0);
					sb.getMenuOption(1);
					sb.getMenuOption(2);
				}
				else if (index == 1){
					sb.getMenuOption(0);
				}
				else if (index == 2){
					sb.getMenuOption(1);
				}
				else if (index == 3){
					sb.getMenuOption(2);
				}
			}
			else if (index == 1){
				sb.getBudgetOverview();
			}

			System.out.println(sb.menuList);
			input = keyboard.nextLine();
		}
	}
}

}