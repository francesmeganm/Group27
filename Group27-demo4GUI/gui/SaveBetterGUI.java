package gui;

import calendar.*;
import logic.*;
import text.*;

import javafx.application.Application;

/**
 * 
 * A functioning GUI-based version that creates an instance of BudgetTool and launches the SaveBetter app.
 *
 */
public class SaveBetterGUI{
	private BudgetTool budgetTool;

	public SaveBetterGUI(BudgetTool budgetTool){
		this.budgetTool = budgetTool;
	}

	public static void main(String[] args){		
		Application.launch(LoginGUI.class, args);
	}

}
