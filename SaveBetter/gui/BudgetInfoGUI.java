package gui;

import calendar.*;
import logic.*;
import text.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.Font.*;
import javafx.scene.text.TextFlow.*;
import javafx.scene.text.FontWeight;
import java.lang.Object.*;
import javafx.scene.text.Font; 
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Locale;

/**
The class UserInfoGUI handles events of getting and setting variables that are in 
 the UserInfo class
 It has 6 instance variables that all hold values of TextField inputed by the 
 user in the GUI
*/
public class BudgetInfoGUI extends Application{
	Stage window;
	private BudgetTool budgetTool;
	private TextField percentage;
	private TextField inputGoal;
	private Label input1;
	private Label input2;
	private Date startDate;
	private Label error;
	private Label error1;

	/**
	 * Constructor that takes a BudgetTool reference and the stage as arguments
	 * @param bt a BudgetTool reference
	 * @param win the current stage
	 */
	public BudgetInfoGUI(BudgetTool bt, Stage win){
		this.budgetTool = bt;
		this.window = win;
	}

	/**
	 * HandleBackToMenu class handles the event created when user enters the percentage of their remaining balance
	 * that they wish to save
	 */
	class HandlePercentage implements EventHandler<ActionEvent>{
		/**
		 * Method takes the amount to save, sets it, and computes the exact amount to save based on this percentage
		 @param event of pressing compute 
		 */
		public void handle(ActionEvent event){
			String per = percentage.getText();
			double per1 = Double.parseDouble(per);
			if ( per1 > 100){
					error.setText( per1 +"% .Percent cannot be greater than 100");
					input1.setText(" ");
			}
			else if (per1<0){
					error.setText(" Negative percentages not allowed.");
					input1.setText(" ");
			}
			else{
				error.setText("");
				budgetTool.settingTheAmountToSave(per1);
				double per2 = budgetTool.gettingTheAmountToSave(per1);
				input1.setText("$ " + per2 + "");
			}
		}
	}

	/**
	 * HandleGoal class handles the event created when the user enters the cost of a given goal
	 */
	class HandleGoal implements EventHandler<ActionEvent>{
		/**
		 * Method takes the cost of a goal entered by the user, sets it, and computes the date the goal is reached
		 @param event of pressing compute 
		 */
		public void handle(ActionEvent event){
			String goal = inputGoal.getText();
			double goal1 = Double.parseDouble(goal);
        	budgetTool.settingDate(startDate);
			Date due = budgetTool.gettingDateGoalCompleted(goal1);
			if ( goal1 <0){
				error1.setText( "Error, please enter a positive value.");
				input2.setText(" ");
			}
			else{
				input2.setText(due + "");
				error1.setText(" ");
			}
		}
	}

	/** 
	 * HandleBackToMenu class allows the user to go back to the main menu by clicking the 'Back to main menu' button
	 */
	class HandleBackToMenu implements EventHandler<ActionEvent>{
		/** 
		 * Method creates a new MenuGUI instance that takes a reference of the BudgetTool class and the current
		 * stage in order to go back to the main menu
		 * @param event of going back to the main menu 
		 */
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new MenuGUI(budgetTool, window).start(window);
		}
	}

	/**
	Method creates the GUI display for the user representing the UserInfo
	User can enter and update all their expenses and income
	@param primaryStage 
	*/
	public void start(Stage primaryStage){
		window = primaryStage;
		window.setTitle("SaveBetter");

		VBox root = new VBox();
		root.setSpacing(25);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: LIMEGREEN;");

		final DatePicker datePicker = new DatePicker();
        datePicker.localeProperty().set(Locale.US);

		Text title = new Text("Budget Infomation");
		title.setFont(Font.font("Courier", FontWeight.BOLD, 25));   
		title.setFill(Color.WHITE);
		root.getChildren().add(title);

		//AMOUNT AVALIABLE TO SAVE EACH MONTH
		HBox h1 = new HBox();
		root.getChildren().add(h1);
		h1.setSpacing(25);
		h1.setAlignment(Pos.CENTER);

		GridPane gp1 = new GridPane();
		gp1.setHgap(10);
		gp1.setVgap(10);
		h1.getChildren().add(gp1);

		//AVAILABLE FUNDS
		Label a = new Label("Avaliable funds to save each month: ");
		gp1.add(a, 0, 0);

		Label c = new Label("$" + Double.toString(budgetTool.gettingTheRemainingMoney()));
		gp1.add(c, 1, 0);

		//DESIRED % TO SAVE
		Label e = new Label("Desired percentage of remaining money to save: ");
		gp1.add(e, 0, 1);

		percentage = new TextField("0.0%");
		gp1.add(percentage, 1, 1);

		error = new Label();
		error.setWrapText(true);
		error.setTextFill(Color.web("#FF0000"));
		gp1.add(error, 1, 2);

		Button g = new Button("Compute");
		gp1.add(g, 2, 1);
		g.setOnAction(new HandlePercentage());

		//AMOUNT TO SAVE
		Label f = new Label("The amount to save is: ");
		gp1.add(f, 0, 2);

		input1 = new Label("" + "0.00");
		gp1.add(input1, 1, 2);

		//COST OF GOAL
		Label j = new Label("Cost of given goal: ");
		gp1.add(j, 0, 3);

		TextField goalCost = new TextField("0.00");
		inputGoal = goalCost;
		gp1.add(goalCost, 1, 3);

		error1 = new Label();
		error1.setWrapText(true);
		error1.setTextFill(Color.web("#FF0000"));
		gp1.add(error1, 1, 5);

		//DATE TO START SAVING
		Label what = new Label("Choose date to start Saving: ");
		gp1.add(what, 0, 4);

		gp1.add(datePicker, 1, 4);

        datePicker.selectedDateProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println(datePicker.selectedDateProperty().get());
                startDate = datePicker.selectedDateProperty().get();
            }
        });

        datePicker.setLocale(Locale.US);
        datePicker.getCalendarView().todayButtonTextProperty().set("Current Date");		

        Date goalEnds = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String date1 = format.format(goalEnds);

		Label how = new Label("Enter date manually or double click to see calendar.");
		gp1.add(how, 0, 5);

		//DATE COMPLETED
		Label l = new Label("Date goal is completed: ");
		gp1.add(l, 0, 6);

		input2 = new Label(format.format(goalEnds));
		gp1.add(input2, 1, 6);

		Button k = new Button("Compute");
		gp1.add(k, 2, 4);
		k.setOnAction(new HandleGoal());

		Button back = new Button("Back to main menu");
		root.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());
		
		Scene scene = new Scene(root, 1366, 768);
		scene.getStylesheets().add("calendarstyle.css");
		window.setScene(scene);

		window.show();
	}
}