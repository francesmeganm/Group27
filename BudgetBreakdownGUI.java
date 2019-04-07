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
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;

public class BudgetBreakdownGUI extends Application{
	Stage window;
	private BudgetTool budgetTool;
	private Label error;
	private double extra; 
	private TextField entText;
	private TextField persText;
	private TextField foodText;
	private TextField shopText;
	private TextField miscText;

	public BudgetBreakdownGUI(BudgetTool bt){
		this.budgetTool = bt;
	}

	class HandleSetBudget implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			double entertainment = Double.parseDouble(entText.getText());
			double personalCare = Double.parseDouble(persText.getText());
			double foodGroceries = Double.parseDouble(foodText.getText());
			double shopping = Double.parseDouble(shopText.getText());
			double miscellaneous = Double.parseDouble(miscText.getText());
			double total = entertainment + personalCare + foodGroceries + shopping + miscellaneous;

			budgetTool.settingBudgetBreakdown(entertainment, personalCare, foodGroceries, shopping, miscellaneous);

			if ( total > 100){
				error.setText("Error, these values add up to "+ total +". Total cannot be >100");
			}
			else if (entertainment < 0 || personalCare < 0 || foodGroceries < 0 || shopping < 0 || miscellaneous < 0){
				error.setText("Error, negative percentages not allowed.");
			}
			else{
				extra = (100 - total); 
				error.setText("You have" + budgetTool.gettingExtra() + " to spend.");
			}
		}
	}

	class HandlePieChart implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new Piechat(budgetTool).start(s);
			window.close();
		}
	}

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

	public void start(Stage primaryStage){
		window = primaryStage;

		VBox root = new VBox();
		root.setSpacing(25);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: LIMEGREEN;");


		Text title = new Text();
		title.setText("Budget Breakdown");
		title.setFont(Font.font("Courier", FontWeight.BOLD, 25));   
		title.setFill(Color.WHITE);

		Label t = new Label("What % of your remaining money do you want to spend towards:");
		root.getChildren().add(title);
		root.getChildren().add(t);

		//ENTERTAINMENT ROW
		HBox rowEnt = new HBox();
		root.getChildren().add(rowEnt);
		rowEnt.setSpacing(25);
		rowEnt.setAlignment(Pos.CENTER);
		Label ent = new Label("Entertainment? (ie.movies, games etc.)");
		entText = new TextField(budgetTool.gettingEntertainment() + "");
		rowEnt.getChildren().add(ent);
		rowEnt.getChildren().add(entText);

		//PERSONAL CARE ROW
		HBox rowPer = new HBox();
		root.getChildren().add(rowPer);
		rowPer.setSpacing(25);
		rowPer.setAlignment(Pos.CENTER);
		Label pers = new Label("Personal care? (ie. hair cuts, salons etc.)");
		persText = new TextField(budgetTool.gettingPersonal() + "");
		rowPer.getChildren().add(pers);
		rowPer.getChildren().add(persText);

		//FOOD AND GROCERIES 
		HBox rowFoo = new HBox();
		root.getChildren().add(rowFoo);
		rowFoo.setSpacing(25);
		rowFoo.setAlignment(Pos.CENTER);
		Label food = new Label("Food and Groceries (including dining out)");
		foodText = new TextField(budgetTool.gettingFood() + "");
		rowFoo.getChildren().add(food);
		rowFoo.getChildren().add(foodText);

		//SHOPPING ROW
		HBox rowSho = new HBox();
		root.getChildren().add(rowSho);
		rowSho.setSpacing(25);
		rowSho.setAlignment(Pos.CENTER);
		Label shop = new Label("Shopping? (ie. clothing, shoes etc.)");
		shopText = new TextField(budgetTool.gettingShopping() + "");
		rowSho.getChildren().add(shop);
		rowSho.getChildren().add(shopText);

		//MISCELLANEOUS ROW
		HBox rowMis = new HBox();
		root.getChildren().add(rowMis);
		rowMis.setSpacing(25);
		rowMis.setAlignment(Pos.CENTER);
		Label misc = new Label("Miscellaneous? (ie. birthday gifts)");
		miscText = new TextField(budgetTool.gettingMisc() + "");
		rowMis.getChildren().add(misc);
		rowMis.getChildren().add(miscText);

		Label error = new Label();
		error.setWrapText(true);
		error.setTextFill(Color.web("#FF0000"));
		root.getChildren().add(error);

		HBox rowUp = new HBox();
		root.getChildren().add(rowUp);
		rowUp.setSpacing(25);
		rowUp.setAlignment(Pos.CENTER);
		Button update = new Button("Update All");
		update.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		update.setStyle("-fx-font-size: 1.1em; ");
		rowUp.getChildren().add(update);
		update.setOnAction(new HandleSetBudget());

		Button compute = new Button("Compute Graph");
		compute.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		compute.setStyle("-fx-font-size: 1.1em; ");
		rowUp.getChildren().add(compute);
		compute.setOnAction(new HandlePieChart());

		Button back = new Button("Back to main menu");
		back.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		back.setStyle("-fx-font-size: 1.1em; ");
		root.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());

		Scene scene = new Scene (root, 1366, 768);
		window.setTitle("SAVEBETTER");
		window.setScene(scene);
		window.show();

	}
	
}