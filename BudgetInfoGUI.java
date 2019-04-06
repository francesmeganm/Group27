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
	private TextField goalCost;
	private Label input1;
	private Label input2;

	public BudgetInfoGUI(BudgetTool bt){
		this.budgetTool = bt;
	}

	class HandlePercentage implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String per = percentage.getText();
			double per1 = Double.parseDouble(per);
			System.out.println(per1);
			budgetTool.settingTheAmountToSave(per1);
			double per2 = budgetTool.gettingTheAmountToSave(per1);
			System.out.println(per2);
			input1.setText(per2 + "");
		}
	}
	class HandleGoal implements EventHandler<ActionEvent>{
		public HandleGoal(Label aLabel){
			input2 = aLabel;
		}

		public void handle(ActionEvent event){
			String goal = goalCost.getText();
			double goal1 = Double.parseDouble(goal);
			Date due = budgetTool.gettingDateGoalCompleted(goal1);
			SimpleDateFormat format = new SimpleDateFormat();
			String date1 = format.format(due);
			input2.setText(date1);
		}
	}

	class HandleBackToMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new MenuGUI(budgetTool).start(s);
			window.close();
		}
	}

	/**
	Method creates the GUI display for the user representing the UserInfo
	User can enter and update all their expenses and income
	*/
	public void start(Stage primaryStage){
		window = primaryStage;
		window.setTitle("SaveBetter");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);

		final DatePicker datePicker = new DatePicker();
        datePicker.localeProperty().set(Locale.US);

		Label header = new Label("Quick Budgeting Analysis");
		GridPane.setConstraints(header, 1, 0);
		grid.getChildren().add(header);


		//AMOUNT AVALIABLE TO SAVE EACH MONTH
		//BOLD
		Label a = new Label("Avaliable funds to save each month");
		GridPane.setConstraints(a, 1, 1);
		grid.getChildren().add(a);

		Label b = new Label("Monthly income less monthly expenses: ");
		GridPane.setConstraints(b, 1, 2);
		grid.getChildren().add(b);

		//BOLD
		Label c = new Label(Double.toString(budgetTool.gettingTheRemainingMoney()));
		GridPane.setConstraints(c, 2, 2);
		grid.getChildren().add(c);

		//AMOUNT TO SAVE FROM PERCENTAGE
		//BOLD
		Label d = new Label("Amount of income to save a given percentage");
		GridPane.setConstraints(d, 1, 4);
		grid.getChildren().add(d);

		Label e = new Label("Desired percentage of income to save: ");
		GridPane.setConstraints(e, 1, 5);
		grid.getChildren().add(e);

		percentage = new TextField("0.0%");
		GridPane.setConstraints(percentage, 2, 5);
		grid.getChildren().add(percentage);

		Label f = new Label("The amount to save is: ");
		GridPane.setConstraints(f, 1, 6);
		grid.getChildren().add(f);

		Button g = new Button("Compute");
		GridPane.setConstraints(g, 3, 5);
		grid.getChildren().add(g);
		g.setOnAction(new HandlePercentage());

		//BOLD
		input1 = new Label("0.00");
		GridPane.setConstraints(input1, 2, 6);
		grid.getChildren().add(input1);

		//MONTHS UNTIL GOAL
		//BOLD
		Label i = new Label("Goal to save towards");
		GridPane.setConstraints(i, 1, 8);
		grid.getChildren().add(i);

		Label j = new Label("Cost of given goal: ");
		GridPane.setConstraints(j, 1, 9);
		grid.getChildren().add(j);

		TextField goalCost = new TextField("0.00");
		GridPane.setConstraints(goalCost, 2, 9);
		grid.getChildren().add(goalCost);

		//BOLD
		Label what = new Label("Choose date to start Saving: ");
		GridPane.setConstraints(what, 1, 10);
		grid.getChildren().add(what);

		HBox hBox = new HBox();
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.setSpacing(10);
		GridPane.setConstraints(hBox, 2, 10);
       
     	hBox.getChildren().add(datePicker);
        grid.getChildren().add(hBox);


        datePicker.selectedDateProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println(datePicker.selectedDateProperty().get());
            }
        });

        datePicker.setLocale(Locale.US);
        datePicker.getCalendarView().todayButtonTextProperty().set("Current Date");		

		Date dateStart = datePicker.selectedDateProperty().get();
        budgetTool.settingDate(dateStart);

        //Date goalEnds = budgetTool.gettingDateGoalCompleted();
        Date goalEnds = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String date1 = format.format(goalEnds);

		Label input2 = new Label(format.format(goalEnds));
		GridPane.setConstraints(input2, 2, 11);
		grid.getChildren().add(input2);


		Button k = new Button("Compute");
		GridPane.setConstraints(k, 3, 10);
		grid.getChildren().add(k);
		k.setOnAction(new HandleGoal(input2));

		Label l = new Label("Date goal is completed: ");
		GridPane.setConstraints(l, 1, 11);
		grid.getChildren().add(l);

		Button back = new Button("Back to main menu");
		GridPane.setConstraints(back, 3, 11);
		grid.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());
		
		Scene scene = new Scene(grid, 650, 400);
		window.setScene(scene);

		window.show();
	}
}