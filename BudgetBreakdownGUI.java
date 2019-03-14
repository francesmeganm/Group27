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
	private BudgetBreakdown b = new BudgetBreakdown();
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
			b.setAmountForEntertainment(entertainment);
			double personalCare = Double.parseDouble(persText.getText());
			b.setAmountForPersonalCare(personalCare);
			double foodGroceries = Double.parseDouble(foodText.getText());
			b.setAmountForFoodAndGroceries(foodGroceries);
			double shopping = Double.parseDouble(shopText.getText());
			b.setAmountForShopping(shopping);
			double miscellaneous = Double.parseDouble(miscText.getText());
			b.setAmountForMiscellanous(miscellaneous);
			double total = entertainment + personalCare + foodGroceries + shopping + miscellaneous;

			if ( total > 100){
				error.setText("Error, these values add up to "+ total +". Total cannot be >100");
			}
			else if (entertainment < 0 || personalCare < 0 || foodGroceries < 0 || shopping < 0 || miscellaneous < 0){
				error.setText("Error, negative percentages not allowed.");
			}
			else{
				extra = (100 - total); 
				b.setAmountExtra(extra);
			}
		}
	}

	public BudgetBreakdownGUI(BudgetBreakdown bb){
		b = new BudgetBreakdown(bb);
	}

	public BudgetBreakdownGUI(){}

	public static void main(String[] args){
		launch(args);
	}

	public void start(Stage primaryStage){
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
		entText = new TextField(b.getAmountForEntertainment() + "");
		GridPane.setConstraints(ent, 0, 2);
		GridPane.setConstraints(entText, 1, 2);
		grid.getChildren().add(ent);
		grid.getChildren().add(entText);

		//PERSONAL CARE ROW
		Label pers = new Label("Personal care? (ie. hair cuts, salons etc.)");
		persText = new TextField(b.getAmountForPersonalCare() + "");
		GridPane.setConstraints(pers, 0, 3);
		GridPane.setConstraints(persText, 1, 3);
		grid.getChildren().add(pers);
		grid.getChildren().add(persText);

		//FOOD AND GROCERIES 
		Label food = new Label("Food and Groceries (including dining out)");
		foodText = new TextField(b.getAmountForFoodAndGroceries() + "");
		GridPane.setConstraints(food, 0, 4);
		GridPane.setConstraints(foodText, 1, 4);
		grid.getChildren().add(food);
		grid.getChildren().add(foodText);

		//SHOPPING ROW
		Label shop = new Label("Shopping? (ie. clothing, shoes etc.)");
		shopText = new TextField(b.getAmountForShopping() + "");
		GridPane.setConstraints(shop, 0, 5);
		GridPane.setConstraints(shopText, 1, 5);
		grid.getChildren().add(shop);
		grid.getChildren().add(shopText);

		//MISCELLANEOUS ROW
		Label misc = new Label("Miscellaneous? (ie. birthday gifts)");
		miscText = new TextField(b.getAmountForMiscellaneous() + "");
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

		Scene scene = new Scene (grid, 600, 300);
		primaryStage.setTitle("SAVEBETTER");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
}