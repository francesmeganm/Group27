import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.HashMap;

public class LoginGUI extends Application{
	private Accounts account = new Accounts();
	private TextField input1;
	private TextField input2;

	class HandleCreateAccount implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String username = input1.getText();
			String password = input2.getText();
			account.createAccount(username, password);
		}
	}

	class HandleLogin implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String username = input1.getText();
			String password = input2.getText();
			HashMap<String, String> usernameAndPassword = new HashMap<String, String >(account.getUsernameAndPassword());
			/*while (usernameAndPassword.get(username) != password){
				name.setLabel("You have entered an invalid username/password. Please try again.");
    		}*/
    	}
	}

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
		input2 = username;
		branchnode3.getChildren().add(password);

		HBox branchnode2 = new HBox();
		root.getChildren().add(branchnode2);
		branchnode2.setAlignment(Pos.CENTER);

		Button createAccount = new Button("Create Account");
		createAccount.setOnAction(new HandleCreateAccount());
		branchnode2.getChildren().add(createAccount);

		Button login = new Button("Login");
		login.setOnAction(new HandleLogin());
		branchnode2.getChildren().add(login);

		Scene scene = new Scene (root, 300, 200);
		primaryStage.setTitle("SAVEBETTER");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}