import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.HashMap;

/** 
LoginGUI class references the login page that will run in the SaveBetter App. It contains instance variables:
acoount, input1 textfield for the usernmae, input2 textfield for the password, and an output label that display any errors. 
This class also extends Application. 
*/
public class LoginGUI extends Application{
	private Accounts account = new Accounts();
	private TextField input1;
	private TextField input2;
	private Label output;
	private Stage s = new Stage();

	/** 
	HandleCreateAccount class handles the event when a user presses the "Create Account" button and extends EventHandler.
	*/
	class HandleCreateAccount implements EventHandler<ActionEvent>{
		/** 
		Method takes the input from the username and password textboxes. If the user has not entered a new username or password to set,
		the program will display an error. Additionally, if the username entered is not unique another error will appear. 
		Otherwise, it will create a new account and run the UserInfoGUI which initalizes the users info. 
		@param event of pressing "Create Account" button 
		*/
		public void handle(ActionEvent event){
			String username = input1.getText();
			String password = input2.getText();
			if (username.isEmpty() || password.isEmpty()){
				output.setText("Please enter a new username and password for your new account.");
			}
			else if (!account.checkUsername(username)){
				output.setText("Sorry that username is already taken, please try another.");
			}
			else{
				account.createAccount(username, password);
				new UserInfoGUI(account.getUsernameAndUserInfo().get(username)).start(s);
				output.setText("");
			}
		}
	}

	/**
	HandleLogin class handles the event when a user presses the "Login" button and extends EventHandler.
	*/
	class HandleLogin implements EventHandler<ActionEvent>{
		/**
		Method takes the input from the username and password textboxes. If the username and password are 
		valid credentials of an existing account, the program will create a new instance of that account and its
		user info. Otherwise, an error will be displayed. 
		@param event of pressing "Login" button 
		*/
		public void handle(ActionEvent event){
			String username = input1.getText();
			String password = input2.getText();
			if (!account.verifyUsernameAndPassword(username, password)){
				output.setText("You have entered an invalid username/password. Please try again.");
			}
			else{
				UserInfo currentAccount = new UserInfo(account.usernameAndUserInfo.get(username));
				new MenuGUI(currentAccount).start(s);
			}
    	}
	}

	/** 
	Method start creates the GUI display for the user, represntingthe login window. This window includes textfields allowing the 
	user to enter usernames and passwords and the option to create an account or login.
	@param primaryStage
	*/
	public void start(Stage primaryStage){
		VBox root = new VBox();
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);

		Label name = new Label("SaveBetter");
		root.getChildren().add(name);

		HBox branchnode1 = new HBox();
		root.getChildren().add(branchnode1);
		branchnode1.setAlignment(Pos.CENTER);

		Label usernameLabel = new Label("Enter username: ");
		branchnode1.getChildren().add(usernameLabel);

		TextField username = new TextField();
		input1 = username;
		branchnode1.getChildren().add(username);

		HBox branchnode3 = new HBox();
		root.getChildren().add(branchnode3);
		branchnode3.setAlignment(Pos.CENTER);

		Label passwordLabel = new Label("Enter password: ");
		branchnode3.getChildren().add(passwordLabel);

		TextField password = new TextField();
		input2 = password;
		branchnode3.getChildren().add(password);

		HBox branchnode4 = new HBox();
		root.getChildren().add(branchnode4);
		branchnode4.setAlignment(Pos.CENTER);

		output = new Label();
		output.setWrapText(true);
		output.setTextFill(Color.web("#FF0000"));
		branchnode4.getChildren().add(output);

		HBox branchnode2 = new HBox();
		root.getChildren().add(branchnode2);
		branchnode2.setAlignment(Pos.CENTER);

		Button createAccount = new Button("Create Account");
		createAccount.setOnAction(new HandleCreateAccount());
		branchnode2.getChildren().add(createAccount);

		Button login = new Button("Login");
		login.setOnAction(new HandleLogin());
		branchnode2.getChildren().add(login);

		Scene scene = new Scene (root, 600, 300);
		primaryStage.setTitle("SAVEBETTER");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}