public class Expenses extends UserInfo{
	private double rent = 0.0;
	private double food = 0.0;
	private double transportation = 0.0; 
	private double utilities = 0.0;

	public double totalExpenses(){
		double total = rent + food + transportation + utilities;
		return total;
	}
}