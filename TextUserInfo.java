import java.util.Scanner;

public class TextUserInfo{
	BudgetTool tool = new BudgetTool();
	Scanner keyboard = new Scanner(System.in);


	public void getAndUpdateUserInfo(){
		System.out.println("Updating your monthly income and expenses.");

		System.out.println("Enter monthly income: ");
		double inc = keyboard.nextInt();

		System.out.println("Enter monthly trasporation cost: ");
		double trans = keyboard.nextInt();

		System.out.println("Enter monthly utility cost: ");
		double uti = keyboard.nextInt();

		System.out.println("Enter monthly rent cost: ");
		double rent = keyboard.nextInt();

		System.out.println("Enter monthly other: ");
		double oth = keyboard.nextInt();

		tool.updateUserInfo(trans, uti, oth, rent, inc);
	}
}