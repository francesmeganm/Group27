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
 * MenuGUI class displays a functioning interface for the Menu class. It creates an instance 
 * of BudgetTool, handles various budget-related events and creates a scene graph to incorporate 
 * all of the necessary aesthetics and functionality needed to create a typical menu. 
 */
public class MenuGUI extends Application {
	
	Stage window;	// Sets the window as the primary stage
	
	private BudgetTool budgetTool;
	
	/** 
	 * Constructor that takes a BudgetTool reference and the stage as arguments 
	 * @param bt a BudgetTool reference
	 * @param win the current stage
	 */
	public MenuGUI(BudgetTool bt, Stage win){
		this.budgetTool = bt;
		this.window = win;
	}
	
	/**
	 * HandleUpdateUserInfo class handles the event created when the user clicks the 'User Info' button in the main menu
	 */
	class HandleUpdateUserInfo implements EventHandler<ActionEvent>{
		/**
		 * Method creates a new stage instance as well as a new UserInfoGUI instance that takes a BudgetTool reference
		 * and the current window as parameters in order to switch over to the UserInfoGUI window when that option is
		 * clicked.
		 */
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new UserInfoGUI(budgetTool, window).start(window);
		}
	}
	
	/**
	 * HandleSimpleBudget class handles the event created when the user clicks the 'Budget Information' button in the main
	 * menu.
	 */
	class HandleSimpleBudget implements EventHandler<ActionEvent>{
		/**
		 * Method creates a new BudgetInfoGUI instance that takes a BudgetTool reference
		 * and the current window as parameters in order to switch over to the BudgetInfoGUI window when that option is
		 * clicked.
		 */
		public void handle(ActionEvent event){
			new BudgetInfoGUI(budgetTool, window).start(window);
		}
	}
	
	/**
	 * HandleRemainingBudget class handles the event created when the user clicks the 'Budget Breakdown' button in the 
	 * main menu.
	 */
	class HandleRemainingBudget implements EventHandler<ActionEvent>{
		/**
		 * Method creates a new stage instance as well as a new BudgetBreakdownGUI instance that takes a BudgetTool 
		 * reference and the current window as parameters in order to switch over to the BudgetBreakdownGUI window 
		 * when that option is clicked.
		 */
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new BudgetBreakdownGUI(budgetTool, window).start(window);
		}
	}
	
	/** 
	 * HandleLogout class allows the user to log out of the main menu.
	 */
	class HandleLogout implements EventHandler<ActionEvent>{
		/**
		 * Method creates a new LoginGUI instance that takes launches the login window again
		 */
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new LoginGUI().start(window);
		}
	}
	
	/**
	 * Method creates and organizes the GUI component for the Menu class.
	 * @param primaryStage
	 */
	public void start(Stage primaryStage){
	
		VBox root = new VBox();
		root.setSpacing(100);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: LIMEGREEN;");
	
		Image userIcon = new Image(getClass().getResourceAsStream("user.png"));
		ImageView userIconView = new ImageView(userIcon);
		userIconView.setFitHeight(35);
		userIconView.setFitWidth(40);
		Button userInfo = new Button("User Info");
		userInfo.setGraphic(userIconView);
		userInfo.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
		userInfo.setStyle("-fx-font-size: 2em; ");
		userInfo.setPrefWidth(300);
		userInfo.setPrefHeight(35);
		userInfo.setOnAction(new HandleUpdateUserInfo());
		root.getChildren().add(userInfo);

		Image simpleBudgetIcon = new Image(getClass().getResourceAsStream("simple.png"));
		ImageView simpleBudgetView = new ImageView(simpleBudgetIcon);
		simpleBudgetView.setFitHeight(35);
		simpleBudgetView.setFitWidth(40);
		Button simpleBudget = new Button("Budget Information");
		simpleBudget.setGraphic(simpleBudgetView);
		simpleBudget.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
		simpleBudget.setStyle("-fx-font-size: 2em; ");
		simpleBudget.setPrefWidth(300);
		simpleBudget.setPrefHeight(35);
		simpleBudget.setOnAction(new HandleSimpleBudget());
		root.getChildren().add(simpleBudget);

		Image remainingeBudgetIcon = new Image(getClass().getResourceAsStream("complex.png"));
		ImageView remainingBudgetView = new ImageView(remainingeBudgetIcon);
		remainingBudgetView.setFitHeight(35);
		remainingBudgetView.setFitWidth(40);
		Button remainingBudget = new Button("Budget Breakdown");
		remainingBudget.setGraphic(remainingBudgetView);
		remainingBudget.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
		remainingBudget.setStyle("-fx-font-size: 2em; ");
		remainingBudget.setPrefWidth(300);
		remainingBudget.setPrefHeight(35);
		remainingBudget.setOnAction(new HandleRemainingBudget());
		root.getChildren().add(remainingBudget);

		Image logoutIcon = new Image(getClass().getResourceAsStream("logout.png"));
		ImageView logoutView = new ImageView(logoutIcon);
		logoutView.setFitHeight(35);
		logoutView.setFitWidth(40);
		Button logout = new Button("Logout");
		logout.setGraphic(logoutView);
		logout.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		logout.setStyle("-fx-font-size: 2em; ");
		logout.setPrefWidth(300);
		logout.setPrefHeight(35);
		logout.setOnAction(new HandleLogout());
		root.getChildren().add(logout);

		Scene scene = new Scene (root, 1366, 768);
		primaryStage.setTitle("Save Better");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
