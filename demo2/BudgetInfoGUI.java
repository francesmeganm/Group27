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
import javafx.scene.text.Font;

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
	private BudgetInfo account = new BudgetInfo();
	private UserInfo currentAccount;
	private TextField percentage;
	private TextField goalCost;
	private Label input1;
	private Label input2;

	class HandlePercentage implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String per = percentage.getText();
			double per1 = Double.parseDouble(per);
			double per2 = account.getAmountToSave(per1);
			String per3 = per2 + "";
			input1.setText(per3);
		}
	}
	class HandleGoal implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String goal = goalCost.getText();
			double goal1 = Double.parseDouble(goal);
			Date due = account.getDateGoalCompleted(goal1);
			SimpleDateFormat format = new SimpleDateFormat();
			String date1 = format.format(due);
			input2.setText(date1);
		}
	}

	class HandleBackToMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new MenuGUI(account).start(s);
			window.close();
		}
	}

	public BudgetInfoGUI(UserInfo user){
		currentAccount = new UserInfo(user);
		account = new BudgetInfo(currentAccount);
	}
	/**
	Method creates the GUI display for the user representing the UserInfo
	User can enter and update all their expenses and income
	*/
	public void start(Stage primaryStage){
		window = primaryStage;
		window.setTitle("SaveBetter");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(25,25,25,25));
		grid.setVgap(25);
		grid.setHgap(25);
		final DatePicker datePicker = new DatePicker();
        datePicker.localeProperty().set(Locale.US);

		Label header = new Label("Quick Budgeting Analysis");
		header.setFont(Font.font("Helvetica", FontWeight.BOLD, 25));
		GridPane.setConstraints(header, 1, 0);
		
		//setFont(Font.BOLD, header);
		//String mg = "Quick Budgeting Analysis";
		//header.setFont(Font.font("Times", BOLD, 12));
		grid.getChildren().add(header);


		//AMOUNT AVALIABLE TO SAVE EACH MONTH
		//BOLD
		Label a = new Label("Avaliable funds to save each month:");
		a.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(a, 1, 1);
		grid.getChildren().add(a);
		//a.setStyle("-fx-font-weight: bold");

		Label b = new Label("Monthly income less monthly expenses: ");
		b.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(b, 1, 2);
		grid.getChildren().add(b);

		//BOLD
		Label c = new Label(Double.toString(account.getRemainingMoney()));
		c.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(c, 2, 2);
		grid.getChildren().add(c);

		//AMOUNT TO SAVE FROM PERCENTAGE
		//BOLD
		Label d = new Label("Amount of income to save a given percentage");
		d.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(d, 1, 4);
		grid.getChildren().add(d);

		Label e = new Label("Desired percentage of income to save: ");
		e.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(e, 1, 5);
		grid.getChildren().add(e);

		percentage = new TextField("0.0%");
		GridPane.setConstraints(percentage, 2, 5);
		grid.getChildren().add(percentage);

		Label f = new Label("The amount to save is: ");
		f.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(f, 1, 6);
		grid.getChildren().add(f);

		Button g = new Button("Compute");
		GridPane.setConstraints(g, 3, 5);
		grid.getChildren().add(g);
		g.setOnAction(new HandlePercentage());

		//BOLD
		Label input1 = new Label("0.00");
		GridPane.setConstraints(input1, 2, 6);
		grid.getChildren().add(input1);

		//MONTHS UNTIL GOAL
		//BOLD
		Label i = new Label("Goal to save towards");
		i.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(i, 1, 8);
		grid.getChildren().add(i);

		Label j = new Label("Cost of given goal: ");
		j.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(j, 1, 9);
		grid.getChildren().add(j);

		TextField goalCost = new TextField("0.00");
		GridPane.setConstraints(goalCost, 2, 9);
		grid.getChildren().add(goalCost);

		Button k = new Button("Compute");
		GridPane.setConstraints(k, 3, 9);
		grid.getChildren().add(k);
		k.setOnAction(new HandleGoal());

		Label l = new Label("Date goal is completed: ");
		l.setFont(Font.font ("Verdana", 15));
		GridPane.setConstraints(l, 1, 10);
		grid.getChildren().add(l);


		HBox hBox = new HBox();
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.setSpacing(10);
		GridPane.setConstraints(hBox, 2, 10);
       
        hBox.getChildren().add(datePicker);
		grid.getChildren().add(hBox);
		
		Date selected=datePicker.selectedDateProperty().get();

        datePicker.selectedDateProperty().addListener(new InvalidationListener() {
            @Override
           public void invalidated(Observable observable) {
            System.out.println(datePicker.selectedDateProperty().get());
            }
        });

        datePicker.setLocale(Locale.US);
        datePicker.getCalendarView().todayButtonTextProperty().set("Current Date");
        //datePicker.getCalendarView().setShowWeeks(false);
		//BOLD

		Date t1 = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String date1 = format.format(t1);

		Label input2 = new Label(format.format(t1));
		GridPane.setConstraints(input2, 2, 11);
		grid.getChildren().add(input2);

		Button back = new Button("Back to main menu");
		GridPane.setConstraints(back, 3, 12);
		grid.getChildren().add(back);
		
		//grid.setSpacing(20);
		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-background-color: lightgreen;");
		Scene scene = new Scene(grid, 1366, 768);
		window.setScene(scene);
		
		scene.getStylesheets().add("calendarstyle.css");
		

		window.show();
	}
}