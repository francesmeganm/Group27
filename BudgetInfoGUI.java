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
import java.lang.Math.*;

/**
The class UserInfoGUI handles events of getting and setting variables that are in 
 the UserInfo class
 It has 6 instance variables that all hold values of TextField inputed by the 
 user in the GUI
*/
public class BudgetInfoGUI extends Application{
	Stage window;
	private UserInfo currentAccount = new UserInfo();
	private BudgetInfo account = new BudgetInfo(currentAccount);
	private TextField percentage;
	private TextField goalCost;

	class HandlePercentage implements EventHandler<ActionEvent>{
		private Label input1;
		public HandlePercentage(Label aLabel){
			input1 = aLabel;
		}
		public void handle(ActionEvent event){
			String per = percentage.getText();
			double per1 = Double.parseDouble(per);
			double per2 = account.getAmountToSave(per1);
			String per3 = per2 + "";
			System.out.println(per3);
			input1.setText(per3);
		}
	}
	class HandleGoal implements EventHandler<ActionEvent>{
		private Label input2;
		public HandleGoal(Label aLabel){
			input2 = aLabel;
		}
		public void handle(ActionEvent event){
			String goal = goalCost.getText();
			System.out.println(goal);
			double goal1 = Double.parseDouble(goal);
			System.out.println(goal1);
			Date due = account.getDateGoalCompleted(goal1);
			System.out.println(due);
			SimpleDateFormat format = new SimpleDateFormat();
			String date1 = format.format(due);
			System.out.println(date1);
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
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);

		Label header = new Label("Quick Budgeting Analysis");
		GridPane.setConstraints(header, 1, 0);
		//header.setFont(Font.font("Helvetica", FontWeight.BOLD, 10));
		//setFont(Font.BOLD, header);
		//String mg = "Quick Budgeting Analysis";
		//header.setFont(Font.font("Times", BOLD, 12));
		grid.getChildren().add(header);


		//AMOUNT AVALIABLE TO SAVE EACH MONTH
		//BOLD
		Label a = new Label("Avaliable funds to save each month");
		GridPane.setConstraints(a, 1, 1);
		grid.getChildren().add(a);
		//a.setStyle("-fx-font-weight: bold");

		Label b = new Label("Monthly income less monthly expenses: ");
		GridPane.setConstraints(b, 1, 2);
		grid.getChildren().add(b);

		//BOLD
		Label c = new Label(Double.toString(account.getRemainingMoney()));
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

		

		//BOLD
		Label input1 = new Label("0.00");
		GridPane.setConstraints(input1, 2, 6);
		grid.getChildren().add(input1);


		Button g = new Button("Compute");
		GridPane.setConstraints(g, 3, 5);
		grid.getChildren().add(g);
		g.setOnAction(new HandlePercentage(input1));

		//MONTHS UNTIL GOAL
		//BOLD
		Label i = new Label("Goal to save towards");
		GridPane.setConstraints(i, 1, 8);
		grid.getChildren().add(i);

		Label j = new Label("Cost of given goal: ");
		GridPane.setConstraints(j, 1, 9);
		grid.getChildren().add(j);

		goalCost = new TextField("0.00");
		GridPane.setConstraints(goalCost, 2, 9);
		grid.getChildren().add(goalCost);

		Date t1 = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String date1 = format.format(t1);

		Label input2 = new Label(format.format(t1));
		GridPane.setConstraints(input2, 2, 10);
		grid.getChildren().add(input2);

		Button k = new Button("Compute");
		GridPane.setConstraints(k, 3, 9);
		grid.getChildren().add(k);
		k.setOnAction(new HandleGoal(input2));

		Label l = new Label("Date goal is completed: ");
		GridPane.setConstraints(l, 1, 10);
		grid.getChildren().add(l);


		//BOLD

		

		Button back = new Button("Back to main menu");
		GridPane.setConstraints(back, 3, 11);
		grid.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());
		
		Scene scene = new Scene(grid, 650, 400);
		window.setScene(scene);

		window.show();
	}
}