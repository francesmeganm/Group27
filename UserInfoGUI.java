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
	//private UserInfo account = new UserInfo();
	private BudgetTool budgetTool;
	private TextField input1;
	private TextField input2;
	private TextField input3;
	private TextField input5;
	private TextField input6;

	public UserInfoGUI(BudgetTool bt){
		this.budgetTool = bt;
	}

	class HandleUpdating implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			//income
			String newIncome = input1.getText();
			double newIncome1 = Double.parseDouble(newIncome);
			//account.setMonthlyIncome(newIncome1);
			String stringIncome = newIncome1 + "";
			input1.setText(stringIncome);

			//transporation
			String newTrans = input2.getText();
			double newTrans1 = Double.parseDouble(newTrans);
			//account.setTransport(newTrans1);
			String stringTrans = newTrans1 + "";
			input2.setText(stringTrans);

			//utility
			String newUtility = input3.getText();
			double newUtility1 = Double.parseDouble(newUtility);
			//account.setUtility(newUtility1);
			String stringUtility = newUtility1 + "";
			input3.setText(stringUtility);

			//rent 
			String newRent = input5.getText();
			double newRent1 = Double.parseDouble(newRent);
			//account.setRent(newRent1);
			String stringRent = newRent1 + "";
			input5.setText(stringRent);

			//other
			String newOther = input6.getText();
			double newOther1 = Double.parseDouble(newOther);
			//account.setOther(newOther1);
			String stringOther = newOther1 + "";
			input6.setText(stringOther);

			budgetTool.updateUserInfo(newTrans1, newUtility1, newOther1, newRent1, newIncome1);
		}
	}

	/**
	The class HandleIncome set income in the class UserInfo and then shows
	the new monthly income to the user
	*/
	/*class HandleIncome implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newIncome = input1.getText();
			double newIncome1 = Double.parseDouble(newIncome);
			account.setMonthlyIncome(newIncome1);
			String stringIncome = account.getMonthlyIncome() + "";
			input1.setText(stringIncome);
		}
	}*/
	/**
	The class HandleTransportation sets the transporation expense in the class
	UserInfo and then shows the new monthly transporation cost to the user
	*/
	/*class HandleTransportation implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newTrans = input2.getText();
			double newTrans1 = Double.parseDouble(newTrans);
			account.setTransport(newTrans1);
			String stringTrans = account.getTransport() + "";
			input2.setText(stringTrans);
		}
	}*/

	/**
	The class HandleUtility sets the utility expense in the class
	UserInfo and then shows the new monthly utility expense to the user
	*/
	/*class HandleUtility implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newUtility = input3.getText();
			double newUtility1 = Double.parseDouble(newUtility);
			account.setUtility(newUtility1);
			String stringUtility = account.getUtility() + "";
			input3.setText(stringUtility);
		}
	}*/

	/**
	The class HandleRent sets the rent exepense in the class UserInfo and then
	shows the new monthly rent expense to the user 
	*/
	/*class HandleRent implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newRent = input5.getText();
			double newRent1 = Double.parseDouble(newRent);
			account.setRent(newRent1);
			String stringRent = account.getRent() + "";
			input5.setText(stringRent);
		}
	}*/

	/**
	The class HandleOther sets the other expense in the class UserInfo and then 
	shows the new monthly other expense to the user
	*/
	/*class HandleOther implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String newOther = input6.getText();
			double newOther1 = Double.parseDouble(newOther);
			account.setOther(newOther1);
			String stringOther = account.getOther() + "";
			input6.setText(stringOther);
		}
	}*/

	/**
	The class HandleAll updates all expenses and income inputed by the users, and
	shows the updated amounts 
	*/
	/*class HandleAll implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			new HandleOther().handle(event);
			new HandleRent().handle(event);
			new HandleIncome().handle(event);
			new HandleTransportation().handle(event);
			new HandleUtility().handle(event);
			window.close();
		}
	}*/

	class HandleBackToMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new MenuGUI(budgetTool).start(s);
			window.close();
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

		input1 = new TextField(Double.toString(budgetTool.gettingMonthlyIncome()));
		GridPane.setConstraints(input1, 2, 1);
		grid.getChildren().add(input1);

		/*Button mIncome = new Button("Update");
		GridPane.setConstraints(mIncome, 3, 1);
		grid.getChildren().add(mIncome);
		mIncome.setOnAction(new HandleIncome());*/

		//ENTER TRANSPORTATION COLUMN
		Label enterTrans = new Label("Update Transportation: ");
		GridPane.setConstraints(enterTrans, 1, 2);
		grid.getChildren().add(enterTrans);

		input2 = new TextField(Double.toString(budgetTool.gettingTransport()));
		GridPane.setConstraints(input2, 2, 2);
		grid.getChildren().add(input2);

		/*Button mTrans = new Button("Update");
		GridPane.setConstraints(mTrans, 3, 2);
		grid.getChildren().add(mTrans);
		mTrans.setOnAction(new HandleTransportation());*/

		//ENTER UTILITY COLUMN
		Label enterUtility = new Label("Update Utility: ");
		GridPane.setConstraints(enterUtility, 1, 3);
		grid.getChildren().add(enterUtility);

		input3 = new TextField(Double.toString(budgetTool.gettingUtility()));
		GridPane.setConstraints(input3, 2, 3);
		grid.getChildren().add(input3);

		/*Button mUtility = new Button("Update");
		GridPane.setConstraints(mUtility, 3, 3);
		grid.getChildren().add(mUtility);
		mUtility.setOnAction(new HandleUtility());*/

		//ENTER RENT COLUMN 
		Label enterRent = new Label("Update Rent: ");
		GridPane.setConstraints(enterRent, 1, 4);
		grid.getChildren().add(enterRent);

		input5 = new TextField(Double.toString(budgetTool.gettingRent()));
		GridPane.setConstraints(input5, 2, 4);
		grid.getChildren().add(input5);

		/*Button mRent = new Button("Update");
		GridPane.setConstraints(mRent, 3, 4);
		grid.getChildren().add(mRent);
		mRent.setOnAction(new HandleRent());*/

		//ENTER OTHER COLUMN 
		Label enterOther = new Label("Update Other: ");
		GridPane.setConstraints(enterOther, 1, 5);
		grid.getChildren().add(enterOther);

		input6 = new TextField(Double.toString(budgetTool.gettingOther()));
		GridPane.setConstraints(input6, 2, 5);
		grid.getChildren().add(input6);

		/*Button mOther = new Button("Update");
		GridPane.setConstraints(mOther, 3, 5);
		grid.getChildren().add(mOther);
		mOther.setOnAction(new HandleOther());*/

		//UPDATE ALL
		Button mAll = new Button("Update All & Continue");
		GridPane.setConstraints(mAll, 2, 6);
		grid.getChildren().add(mAll);
		mAll.setOnAction(new HandleUpdating());

		//BACK TO MENU 
		Button back = new Button("Back to main menu");
		GridPane.setConstraints(back, 3, 7);
		grid.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());
		
		Scene scene = new Scene(grid, 600, 300);
		window.setScene(scene);

		window.show();
		
	}
}
