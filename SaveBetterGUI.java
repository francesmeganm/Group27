import javafx.application.Application;

public class SaveBetterGUI{
	private BudgetTool budgetTool;

	public SaveBetterGUI(BudgetTool budgetTool){
		this.budgetTool = budgetTool;
	}

	public static void main(String[] args){		
		Application.launch(LoginGUI.class, args);
	}

}