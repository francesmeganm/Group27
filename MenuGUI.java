import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.text.*; 
import javafx.scene.paint.Color;

public class MenuGUI extends Application{
	Stage window;
	BudgetTool budgetTool;

	public MenuGUI(BudgetTool bt){
		this.budgetTool = bt;
	}
	class HandleUpdateUserInfo implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new UserInfoGUI(budgetTool).start(s);
			window.close();
		}
	}
	class HandleSimpleBudget implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new BudgetInfoGUI(budgetTool).start(s);
			window.close();
		}
	}
	class HandleRemainingBudget implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new BudgetBreakdownGUI(budgetTool).start(s);
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
		root.setSpacing(100);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: LIMEGREEN;");

		
		Image userIcon = new Image(getClass().getResourceAsStream("user.png"));
		ImageView userIconView = new ImageView(userIcon);
		userIconView.setFitHeight(35);
		userIconView.setFitWidth(40);
		Button userInfo = new Button("User Info");
		userInfo.setGraphic(userIconView);
		userInfo.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
		userInfo.setStyle("-fx-font-size: 2em; ");
		userInfo.setPrefWidth(300);
		userInfo.setPrefHeight(35);
		userInfo.setOnAction(new HandleUpdateUserInfo());
		root.getChildren().add(userInfo);


		Image simpleBudgetIcon = new Image(getClass().getResourceAsStream("simple.png"));
		ImageView simpleBudgetView = new ImageView(simpleBudgetIcon);
		simpleBudgetView.setFitHeight(35);
		simpleBudgetView.setFitWidth(40);
		Button simpleBudget = new Button("Budget Information");
		simpleBudget.setGraphic(simpleBudgetView);
		simpleBudget.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
		simpleBudget.setStyle("-fx-font-size: 2em; ");
		simpleBudget.setPrefWidth(300);
		simpleBudget.setPrefHeight(35);
		simpleBudget.setOnAction(new HandleSimpleBudget());
		root.getChildren().add(simpleBudget);


		Image remainingeBudgetIcon = new Image(getClass().getResourceAsStream("complex.png"));
		ImageView remainingBudgetView = new ImageView(remainingeBudgetIcon);
		remainingBudgetView.setFitHeight(35);
		remainingBudgetView.setFitWidth(40);
		Button remainingBudget = new Button("Budget Breakdown");
		remainingBudget.setGraphic(remainingBudgetView);
		remainingBudget.setStyle("-fx-background-color: white; -fx-text-fill: black;"); 
		remainingBudget.setStyle("-fx-font-size: 2em; ");
		remainingBudget.setPrefWidth(300);
		remainingBudget.setPrefHeight(35);
		remainingBudget.setOnAction(new HandleRemainingBudget());
		root.getChildren().add(remainingBudget);



		Image logoutIcon = new Image(getClass().getResourceAsStream("logout.png"));
		ImageView logoutView = new ImageView(logoutIcon);
		logoutView.setFitHeight(35);
		logoutView.setFitWidth(40);
		Button logout = new Button("Logout");
		logout.setGraphic(logoutView);
		logout.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		logout.setStyle("-fx-font-size: 2em; ");
		logout.setPrefWidth(300);
		logout.setPrefHeight(35);
		logout.setOnAction(new HandleLogout());
		root.getChildren().add(logout);


		Scene scene = new Scene (root, 1366, 768);
		//primaryStage.setMaximized(true);
		primaryStage.setTitle("Save Better");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}