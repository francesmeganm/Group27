public class Budget extends Account {

	private double percentToSave;
	private double amountToSave;
	
	

	public void setPercentToSave(double save){

		if (save > 0 && save < 100){

			amountToSave = (monthlyIncome - monthlyExpenses) * (save/100);

			percentToSave = save;

		}
		
	