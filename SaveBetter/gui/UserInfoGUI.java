package gui;

import calendar.*;
import logic.*;
import text.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

/**
The class UserInfoGUI handles events of getting and setting variables that are in 
 the UserInfo class
 It has 6 instance variables that all hold values of TextField inputed by the 
 user in the GUI
*/
public class UserInfoGUI extends Application{
	Stage window;
	private BudgetTool budgetTool;
	private TextField input1;
	private TextField input2;
	private TextField input3;
	private TextField input5;
	private TextField input6;

	/**
	 * Constructor that takes a BudgetTool reference and the stage as arguments
	 * @param bt a BudgetTool reference
	 * @param win the current stage
	 */
	public UserInfoGUI(BudgetTool bt, Stage win){
		this.budgetTool = bt;
		this.window = win;
	}

	/**
	 * HandleUpdating class handles the event created when the user inputs their income and expense related information
	 * and updates them by clicking the 'Update All' button.
	 */
	class HandleUpdating implements EventHandler<ActionEvent>{
		/**
		 * Method takes the total income and expenses entered by the user and sets them
		 */
		public void handle(ActionEvent event){
			//income
			String newIncome = input1.getText();
			double newIncome1 = Double.parseDouble(newIncome);
			String stringIncome = newIncome1 + "";
			input1.setText(stringIncome);

			//transporation
			String newTrans = input2.getText();
			double newTrans1 = Double.parseDouble(newTrans);
			String stringTrans = newTrans1 + "";
			input2.setText(stringTrans);

			//utility
			String newUtility = input3.getText();
			double newUtility1 = Double.parseDouble(newUtility);
			String stringUtility = newUtility1 + "";
			input3.setText(stringUtility);

			//rent 
			String newRent = input5.getText();
			double newRent1 = Double.parseDouble(newRent);
			String stringRent = newRent1 + "";
			input5.setText(stringRent);

			//other
			String newOther = input6.getText();
			double newOther1 = Double.parseDouble(newOther);
			String stringOther = newOther1 + "";
			input6.setText(stringOther);

			budgetTool.updateUserInfo(newTrans1, newUtility1, newOther1, newRent1, newIncome1);
		}
	}

	/**
	 * HandleBackToMenu class allows the user to go back to main menu by clicking the 'Back to main menu' button
	 */
	class HandleBackToMenu implements EventHandler<ActionEvent>{
		/**
		 * Method creates a new MenuGUI instance that takes a reference of the BudgetTool class and the current stage
		 * in order to go back to the main menu.
		 * @param event of going back to menu 
		 */
		public void handle(ActionEvent event){
			new MenuGUI(budgetTool, window).start(window);
		}
	}

	/** Launches the current window */
	public static void main(String[] args){
		launch(args);
	}

	/**
	 * Method creates the GUI display for the user representing the UserInfo
	 * User can enter and update all their expenses and income
	*/
	public void start(Stage primaryStage){
		window = primaryStage;
		window.setTitle("SaveBetter");

		VBox root = new VBox();
		root.setStyle("-fx-background-color: LIMEGREEN;");
		root.setSpacing(30);
		root.setAlignment(Pos.CENTER);

		Text header = new Text();
		header.setText("Update Monthly Income and Expenses");
		header.setFont(Font.font("Courier", FontWeight.BOLD, 25));   
		header.setFill(Color.WHITE);
		root.getChildren().add(header);
		
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setAlignment(Pos.CENTER);
		root.getChildren().add(gp);

		//ENTER INCOME COLUMN

		Label enterIncome = new Label("Update Income: ");
		gp.add(enterIncome, 0, 0);

		input1 = new TextField(Double.toString(budgetTool.gettingMonthlyIncome()));
		gp.add(input1, 1, 0);

		//ENTER TRANSPORTATION COLUMN
		Label enterTrans = new Label("Update Transportation: ");
		gp.add(enterTrans, 0, 1);

		input2 = new TextField(Double.toString(budgetTool.gettingTransport()));
		gp.add(input2, 1, 1);

		//ENTER UTILITY COLUMN
		Label enterUtility = new Label("Update Utility: ");
		gp.add(enterUtility, 0, 2);

		input3 = new TextField(Double.toString(budgetTool.gettingUtility()));
		gp.add(input3, 1, 2);

		//ENTER RENT COLUMN 
		Label enterRent = new Label("Update Rent: ");
		gp.add(enterRent, 0, 3);

		input5 = new TextField(Double.toString(budgetTool.gettingRent()));
		gp.add(input5, 1, 3);

		//ENTER OTHER COLUMN 
		Label enterOther = new Label("Update Other: ");
		gp.add(enterOther, 0, 4);

		input6 = new TextField(Double.toString(budgetTool.gettingOther()));
		gp.add(input6, 1, 4);

		//UPDATE ALL 
		HBox updateAndClose = new HBox();
		updateAndClose.setSpacing(20);
		updateAndClose.setAlignment(Pos.CENTER);
		root.getChildren().add(updateAndClose);

		Button mAll = new Button("Update All");
		mAll.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		mAll.setStyle("-fx-font-size: 1.1em; ");
		updateAndClose.getChildren().add(mAll);
		mAll.setOnAction(new HandleUpdating());

		//BACK TO MENU 
		Button back = new Button("Back to Main Menu");
		back.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		back.setStyle("-fx-font-size: 1.1em; ");
		updateAndClose.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());
		
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 1366, 768);
		window.setScene(scene);

		window.show();
		
	}
}