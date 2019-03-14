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

public class MenuGUI extends Application{
	Stage window;

	class HandleUpdateUserInfo implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new UserInfoGUI().start(s);
			window.close();
		}
	}
	class HandleSimpleBudget implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new BudgetInfoGUI().start(s);
			window.close();
		}
	}
	class HandleRemainingBudget implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new BudgetBreakdownGUI().start(s);
			window.close();
		}
	}
	class HandleLogout implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new LoginGUI().start(s);
			window.close();
		}
	}

	public void start(Stage primaryStage){
		VBox root = new VBox();
		root.setSpacing(15);
		root.setAlignment(Pos.CENTER);

		Label title = new Label("Save Better");
		root.getChildren().add(title);

		Button userInfo = new Button("Update User Info");
		userInfo.setOnAction(new HandleUpdateUserInfo());
		root.getChildren().add(userInfo);

		Button simpleBudget = new Button("Simple Budget");
		simpleBudget.setOnAction(new HandleSimpleBudget());
		root.getChildren().add(simpleBudget);

		Button remainingBudget = new Button("Budget for remaining money");
		remainingBudget.setOnAction(new HandleRemainingBudget());
		root.getChildren().add(remainingBudget);

		Button logout = new Button("Logout");
		logout.setOnAction(new HandleLogout());
		root.getChildren().add(logout);

		Scene scene = new Scene (root, 300, 200);
		primaryStage.setTitle("Save Better");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}