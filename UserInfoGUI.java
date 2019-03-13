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

/**
The class UserInfoGUI handles events of getting and setting variables that are in 
 the UserInfo class
 It has 6 instance variables that all hold values of TextField inputed by the 
 user in the GUI
*/
public class UserInfoGUI extends Application{
	Stage window;
	private UserInfo account = new UserInfo();
	private TextField input1;
	private TextField input2;
	private TextField input3;
	private TextField input4;
	private TextField input5;
	private TextField input6;

	/**
	The class HandleIncome set income in the class UserInfo and then shows
	the new monthly income to the user
	*/
	class HandleIncome implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newIncome = input1.getText();
			double newIncome1 = Double.parseDouble(newIncome);
			account.setMonthlyIncome(newIncome1);
			String stringIncome = account.getMonthlyIncome() + "";
			input1.setText(stringIncome);
		}
	}
	/**
	The class HandleTransportation sets the transporation expense in the class
	UserInfo and then shows the new monthly transporation cost to the user
	*/
	class HandleTransportation implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newTrans = input2.getText();
			double newTrans1 = Double.parseDouble(newTrans);
			account.setTransport(newTrans1);
			String stringTrans = account.getTransport() + "";
			input2.setText(stringTrans);
		}
	}

	/**
	The class HandleFoodAndDrink sets the food and drink expense in the class
	UserInfo and then shows the new monthly food and drink expense to the user
	*/
	class HandleFoodAndDrink implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newFood = input3.getText();
			double newFood1 = Double.parseDouble(newFood);
			account.setFood(newFood1);
			String stringFood = account.getFood() + "";
			input3.setText(stringFood);
		}
	}

	/**
	The class HandleEntertainment sets the entertainment expense in the class
	UserInfo and then shows the new monthly entertainment expense to the user 
	*/
	class HandleEntertainment implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newEnt = input4.getText();
			double newEnt1 = Double.parseDouble(newEnt);
			account.setEntertainment(newEnt1);
			String stringEnt = account.getEntertainment() + "";
			input4.setText(stringEnt);
		}
	}

	/**
	The class HandleRent sets the rent exepense in the class UserInfo and then
	shows the new monthly rent expense to the user 
	*/
	class HandleRent implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newRent = input5.getText();
			double newRent1 = Double.parseDouble(newRent);
			account.setRent(newRent1);
			String stringRent = account.getRent() + "";
			input5.setText(stringRent);
		}
	}

	/**
	The class HandleOther sets the other expense in the class UserInfo and then 
	shows the new monthly other expense to the user
	*/
	class HandleOther implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newOther = input6.getText();
			double newOther1 = Double.parseDouble(newOther);
			account.setOther(newOther1);
			String stringOther = account.getOther() + "";
			input6.setText(stringOther);
		}
	}

	/**
	The class HandleAll updates all expenses and income inputed by the users, and
	shows the updated amounts 
	*/
	class HandleAll implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newIncome = input1.getText();
			double newIncome1 = Double.parseDouble(newIncome);
			account.setMonthlyIncome(newIncome1);
			String stringIncome = account.getMonthlyIncome() + "";
			input1.setText(stringIncome);

			String newTrans = input2.getText();
			double newTrans1 = Double.parseDouble(newTrans);
			account.setTransport(newTrans1);
			String stringTrans = account.getTransport() + "";
			input2.setText(stringTrans);

			String newFood = input3.getText();
			double newFood1 = Double.parseDouble(newFood);
			account.setFood(newFood1);
			String stringFood = account.getFood() + "";
			input3.setText(stringFood);

			String newEnt = input4.getText();
			double newEnt1 = Double.parseDouble(newEnt);
			account.setEntertainment(newEnt1);
			String stringEnt = account.getEntertainment() + "";
			input4.setText(stringEnt);

			String newRent = input5.getText();
			double newRent1 = Double.parseDouble(newRent);
			account.setRent(newRent1);
			String stringRent = account.getRent() + "";
			input5.setText(stringRent);

			String newOther = input6.getText();
			double newOther1 = Double.parseDouble(newOther);
			account.setOther(newOther1);
			String stringOther = account.getOther() + "";
			input6.setText(stringOther);
		}
	}

	/**
	Main function
	*/
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

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);

		Label header = new Label("Update Monthly Income and Expenses");
		GridPane.setConstraints(header, 1, 0);
		grid.getChildren().add(header);

		//ENTER INCOME COLUMN
		Label enterIncome = new Label("Update Income: ");
		GridPane.setConstraints(enterIncome, 1, 1);
		grid.getChildren().add(enterIncome);

		input1 = new TextField(Double.toString(account.getMonthlyIncome()));
		GridPane.setConstraints(input1, 2, 1);
		grid.getChildren().add(input1);

		Button mIncome = new Button("Update");
		GridPane.setConstraints(mIncome, 3, 1);
		grid.getChildren().add(mIncome);
		mIncome.setOnAction(new HandleIncome());

		//ENTER TRANSPORTATION COLUMN
		Label enterTrans = new Label("Update Transportation: ");
		GridPane.setConstraints(enterTrans, 1, 2);
		grid.getChildren().add(enterTrans);

		input2 = new TextField(Double.toString(account.getTransport()));
		GridPane.setConstraints(input2, 2, 2);
		grid.getChildren().add(input2);

		Button mTrans = new Button("Update");
		GridPane.setConstraints(mTrans, 3, 2);
		grid.getChildren().add(mTrans);
		mTrans.setOnAction(new HandleTransportation());

		//ENTER FOOD AND DRINK COLUMN
		Label enterFood = new Label("Update Food and Drink: ");
		GridPane.setConstraints(enterFood, 1, 3);
		grid.getChildren().add(enterFood);

		input3 = new TextField(Double.toString(account.getTransport()));
		GridPane.setConstraints(input3, 2, 3);
		grid.getChildren().add(input3);

		Button mFood = new Button("Update");
		GridPane.setConstraints(mFood, 3, 3);
		grid.getChildren().add(mFood);
		mFood.setOnAction(new HandleFoodAndDrink());

		//ENTER ENTAINTMENT COLUMN 
		Label enterEnt = new Label("Update Entertainment: ");
		GridPane.setConstraints(enterEnt, 1, 4);
		grid.getChildren().add(enterEnt);

		input4 = new TextField(Double.toString(account.getEntertainment()));
		GridPane.setConstraints(input4, 2, 4);
		grid.getChildren().add(input4);

		Button mEnt = new Button("Update");
		GridPane.setConstraints(mEnt, 3, 4);
		grid.getChildren().add(mEnt);
		mEnt.setOnAction(new HandleEntertainment());

		//ENTER RENT COLUMN 
		Label enterRent = new Label("Update Rent: ");
		GridPane.setConstraints(enterRent, 1, 5);
		grid.getChildren().add(enterRent);

		input5 = new TextField(Double.toString(account.getRent()));
		GridPane.setConstraints(input5, 2, 5);
		grid.getChildren().add(input5);

		Button mRent = new Button("Update");
		GridPane.setConstraints(mRent, 3, 5);
		grid.getChildren().add(mRent);
		mRent.setOnAction(new HandleRent());

		//ENTER OTHER COLUMN 
		Label enterOther = new Label("Update Other: ");
		GridPane.setConstraints(enterOther, 1, 6);
		grid.getChildren().add(enterOther);

		input6 = new TextField(Double.toString(account.getOther()));
		GridPane.setConstraints(input6, 2, 6);
		grid.getChildren().add(input6);

		Button mOther = new Button("Update");
		GridPane.setConstraints(mOther, 3, 6);
		grid.getChildren().add(mOther);
		mOther.setOnAction(new HandleOther());

		//UPDATE ALL
		Label updateAll = new Label("Update all: ");
		GridPane.setConstraints(updateAll, 1, 7);
		grid.getChildren().add(updateAll);

		Button mAll = new Button("Update");
		GridPane.setConstraints(mAll, 3, 7);
		grid.getChildren().add(mAll);
		mAll.setOnAction(new HandleAll());
		
		Scene scene = new Scene(grid, 600, 300);
		window.setScene(scene);

		window.show();
		
	}
}