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

public class BudgetBreakdownGUI extends Application{
	Stage window;
	private UserInfo currentAccount = new UserInfo();
	private BudgetBreakdown bb = new BudgetBreakdown(currentAccount);
	private Label error;
	private double extra; 
	private TextField entText;
	private TextField persText;
	private TextField foodText;
	private TextField shopText;
	private TextField miscText;

	class HandleSetBudget implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			double entertainment = Double.parseDouble(entText.getText());
			bb.setAmountForEntertainment(entertainment);
			entText.setText(bb.getAmountForEntertainment()+"");

			double personalCare = Double.parseDouble(persText.getText());
			bb.setAmountForPersonalCare(personalCare);
			double foodGroceries = Double.parseDouble(foodText.getText());
			bb.setAmountForFoodAndGroceries(foodGroceries);
			double shopping = Double.parseDouble(shopText.getText());
			bb.setAmountForShopping(shopping);
			double miscellaneous = Double.parseDouble(miscText.getText());
			bb.setAmountForMiscellanous(miscellaneous);
			double total = entertainment + personalCare + foodGroceries + shopping + miscellaneous;

			if ( total > 100){
				error.setText("Error, these values add up to "+ total +". Total cannot be >100");
			}
			else if (entertainment < 0 || personalCare < 0 || foodGroceries < 0 || shopping < 0 || miscellaneous < 0){
				error.setText("Error, negative percentages not allowed.");
			}
			else{
				extra = (100 - total); 
				bb.setAmountExtra(extra);
			}
		}
	}

	class HandleBackToMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new MenuGUI(currentAccount).start(s);
			window.close();
		}
	}

	class HandleMakePieChart implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage ();
			new PieChartSample1().start(s);
			window.close();
		}
	}
	
	public BudgetBreakdownGUI(UserInfo user){
		currentAccount = new UserInfo(user);
		BudgetInfo b = new BudgetInfo(user);
		BudgetBreakdown bb = new BudgetBreakdown(b);
		}
	
	public static void main(String[] args){
		launch(args);
	}

	public void start(Stage primaryStage){
		window = primaryStage;
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(10);
		grid.setHgap(10);

		Label title = new Label("Customize Spendings"); 
		Label t = new Label("What % of your remaining money do you want to spend towards:");
		GridPane.setConstraints(title, 0, 0);
		grid.getChildren().add(title);
		GridPane.setConstraints(t, 0, 1);
		grid.getChildren().add(t);

		//ENTERTAINMENT ROW
		Label ent = new Label("Entertainment? (ie.movies, games etc.)");
		entText = new TextField(bb.getAmountForEntertainment() + "");
		GridPane.setConstraints(ent, 0, 2);
		GridPane.setConstraints(entText, 1, 2);
		grid.getChildren().add(ent);
		grid.getChildren().add(entText);

		//PERSONAL CARE ROW
		Label pers = new Label("Personal care? (ie. hair cuts, salons etc.)");
		persText = new TextField(bb.getAmountForPersonalCare() + "");
		GridPane.setConstraints(pers, 0, 3);
		GridPane.setConstraints(persText, 1, 3);
		grid.getChildren().add(pers);
		grid.getChildren().add(persText);

		//FOOD AND GROCERIES 
		Label food = new Label("Food and Groceries (including dining out)");
		foodText = new TextField(bb.getAmountForFoodAndGroceries() + "");
		GridPane.setConstraints(food, 0, 4);
		GridPane.setConstraints(foodText, 1, 4);
		grid.getChildren().add(food);
		grid.getChildren().add(foodText);

		//SHOPPING ROW
		Label shop = new Label("Shopping? (ie. clothing, shoes etc.)");
		shopText = new TextField(bb.getAmountForShopping() + "");
		GridPane.setConstraints(shop, 0, 5);
		GridPane.setConstraints(shopText, 1, 5);
		grid.getChildren().add(shop);
		grid.getChildren().add(shopText);

		//MISCELLANEOUS ROW
		Label misc = new Label("Miscellaneous? (ie. birthday gifts)");
		miscText = new TextField(bb.getAmountForMiscellaneous() + "");
		GridPane.setConstraints(misc, 0, 6);
		GridPane.setConstraints(miscText, 1, 6);
		grid.getChildren().add(misc);
		grid.getChildren().add(miscText);

		error = new Label();
		error.setWrapText(true);
		error.setTextFill(Color.web("#FF0000"));
		GridPane.setConstraints(error, 0, 7);
		grid.getChildren().add(error);

		Button update = new Button("Update All");
		GridPane.setConstraints(update, 1, 7);
		grid.getChildren().add(update);
		update.setOnAction(new HandleSetBudget());

		Button breakdown = new Button("Show budget breakdown");
		GridPane.setConstraints(breakdown, 1, 8);
		grid.getChildren().add(breakdown);
		breakdown.setOnAction(new HandleMakePieChart());

		Button back = new Button("Back to main menu");
		GridPane.setConstraints(back, 3, 8);
		grid.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());

		Scene scene = new Scene (grid, 800, 350);
		primaryStage.setTitle("SAVEBETTER");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}