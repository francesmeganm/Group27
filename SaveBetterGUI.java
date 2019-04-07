import javafx.application.Application;

public class SaveBetterGUI{
	private BudgetTool budgetTool;
	private TextLogin login;
	private TextUserInfo userInfo;
	private TextBudgetInfo budgetInfo;
	private TextBudgetBreakdown budgetBreakdown;

	public SaveBetterGUI(BudgetTool budgetTool){
		this.budgetTool = budgetTool;
		//login = new TextLogin(budgetTool);
		//userInfo = new TextUserInfo(budgetTool);
		//budgetInfo = new TextBudgetInfo(budgetTool);
		//budgetBreakdown = new TextBudgetBreakdown(budgetTool);
	}

	public static void main(String[] args){		
		Application.launch(LoginGUI.class, args);
	}

}