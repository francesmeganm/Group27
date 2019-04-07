import javafx.application.Application;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.HashMap;
import javafx.scene.paint.*;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.*;


/** 
LoginGUI class references the login page that will run in the MySaver App. It contains instance variables:
acoount, input1 textfield for the usernmae, input2 textfield for the password, and an output label thats display any errors. 
*/
public class LoginGUI extends Application{

	Stage window;
	
	private BudgetTool budgetTool = new BudgetTool();
	private TextField input1;
	private TextField input2;
	private Label output;
	private Stage s = new Stage();

	public LoginGUI(){
		//this.budgetTool = bt;
	}

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
				output.setText("Please enter a new username and password for your account.");
			}
			else if (!budgetTool.checkingUsername(username)){
				output.setText("Sorry, that username is already taken, please try another.");
			}
			else{
				budgetTool.makeAccount(username, password);
				output.setText("Created New Account");
				
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
			if (!budgetTool.checkingLogin(username, password)){
				output.setText("You have entered an invalid username/password. Please try again.");
			}
			else{
				//UserInfo currentAccount = new UserInfo(account.usernameAndUserInfo.get(username));
				new MenuGUI(budgetTool).start(s);
				window.close();
			}
    	}
	}

	/** 
	Method start creates the GUI display for the user, representing the login window. This window includes textfields allowing the 
	user to enter usernames and passwords and the option to create an account or login.
	@param primaryStage
	*/
	public void start(Stage primaryStage) {
	
		window = primaryStage;
		
		
		VBox root = new VBox();
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: LIMEGREEN;");

		Text text = new Text();
		text.setText("$aveBetter");
		text.setX(50);
		text.setY(50);
		root.getChildren().add(text);
		text.setFont(Font.font("Courier", FontWeight.BOLD, 45));   
		text.setFill(Color.WHITE);

		HBox branchnode1 = new HBox();
		root.getChildren().add(branchnode1);
		branchnode1.setAlignment(Pos.CENTER);

		Label usernameLabel = new Label("Username: ");
		branchnode1.getChildren().add(usernameLabel);

		TextField username = new TextField();
		username.setPromptText("Enter your username.");
		input1 = username;
		branchnode1.getChildren().add(username);

		HBox branchnode3 = new HBox();
		root.getChildren().add(branchnode3);
		branchnode3.setAlignment(Pos.CENTER);

		Label passwordLabel = new Label("Password: ");

		branchnode3.getChildren().add(passwordLabel);

		PasswordField password = new PasswordField();
		password.setPromptText("Enter your password.");
		input2 = password;
		
		branchnode3.getChildren().add(password);

		HBox branchnode4 = new HBox();
		root.getChildren().add(branchnode4);
		branchnode4.setAlignment(Pos.CENTER);

		output = new Label();
		output.setWrapText(true);
		output.setTextFill(Color.web("#FF0000"));
		branchnode4.getChildren().add(output);

		HBox branchnode2 = new HBox(15);
		root.getChildren().add(branchnode2);
		branchnode2.setAlignment(Pos.CENTER);

		Button createAccount = new Button("Create Account");
		createAccount.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
		createAccount.setOnAction(new HandleCreateAccount());
		//ProgressIndicator progressIndicator = new ProgressIndicator();
		//branchnode2.getChildren().addAll(progressIndicator);
		branchnode2.getChildren().add(createAccount);
	

		Button login = new Button("Login");
		login.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
		login.setOnAction(new HandleLogin());
		branchnode2.getChildren().add(login);

		Scene scene = new Scene (root, 1366, 768);
		primaryStage.setTitle("Save Better");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}