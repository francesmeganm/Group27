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

	public UserInfoGUI(BudgetTool bt, Stage win){
		this.budgetTool = bt;
		this.window = win;
	}

	class HandleUpdating implements EventHandler<ActionEvent>{
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

	class HandleBackToMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			new MenuGUI(budgetTool, window).start(window);
		}
	}

	public static void main(String[] args){
		launch(args);
	}

	/**
	Method creates the GUI display for the user representing the UserInfo
	User can enter and update all their expenses and income
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
		

		//ENTER INCOME COLUMN
		HBox income = new HBox();
		income.setSpacing(20);
		income.setAlignment(Pos.CENTER);
		root.getChildren().add(income);

		Label enterIncome = new Label("Update Income: ");
		income.getChildren().add(enterIncome);

		input1 = new TextField(Double.toString(budgetTool.gettingMonthlyIncome()));
		income.getChildren().add(input1);

		//ENTER TRANSPORTATION COLUMN
		HBox trans = new HBox();
		trans.setSpacing(20);
		trans.setAlignment(Pos.CENTER);
		root.getChildren().add(trans);

		Label enterTrans = new Label("Update Transportation: ");
		trans.getChildren().add(enterTrans);

		input2 = new TextField(Double.toString(budgetTool.gettingTransport()));
		trans.getChildren().add(input2);

		//ENTER UTILITY COLUMN
		HBox utility = new HBox();
		utility.setSpacing(20);
		utility.setAlignment(Pos.CENTER);
		root.getChildren().add(utility);

		Label enterUtility = new Label("Update Utility: ");
		utility.getChildren().add(enterUtility);

		input3 = new TextField(Double.toString(budgetTool.gettingUtility()));
		utility.getChildren().add(input3);

		//ENTER RENT COLUMN 
		HBox rent = new HBox();
		rent.setSpacing(20);
		rent.setAlignment(Pos.CENTER);
		root.getChildren().add(rent);

		Label enterRent = new Label("Update Rent: ");
		rent.getChildren().add(enterRent);

		input5 = new TextField(Double.toString(budgetTool.gettingRent()));
		rent.getChildren().add(input5);

		//ENTER OTHER COLUMN 
		HBox other = new HBox();
		other.setSpacing(20);
		other.setAlignment(Pos.CENTER);
		root.getChildren().add(other);

		Label enterOther = new Label("Update Other: ");
		other.getChildren().add(enterOther);

		input6 = new TextField(Double.toString(budgetTool.gettingOther()));
		other.getChildren().add(input6);

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
