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

	public BudgetBreakdownGUI(BudgetTool bt, Stage win){
		this.budgetTool = bt;
		this.window = win;
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
				
					error.setText("Error, these values add up to "+ total +"% . Total cannot be greater than 100");
			}
			else if (entertainment < 0 || personalCare < 0 || foodGroceries < 0 || shopping < 0 || miscellaneous < 0){
					
					
					error.setText("Error, negative percentages not allowed.");
			}
			else{
					extra = (100 - total); 
					if (extra>0){
					error.setText("You have "+extra+"% left to input. That's:" + budgetTool.gettingExtra() + " extra dollars.");
					}else{
						error.setText("");
					}
			}
			
			
		}
	}

	class HandlePieChart implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent event){
			double entertainment = Double.parseDouble(entText.getText());
			double personalCare = Double.parseDouble(persText.getText());
			double foodGroceries = Double.parseDouble(foodText.getText());
			double shopping = Double.parseDouble(shopText.getText());
			double miscellaneous = Double.parseDouble(miscText.getText());
			double total = entertainment + personalCare + foodGroceries + shopping + miscellaneous;

			budgetTool.settingBudgetBreakdown(entertainment, personalCare, foodGroceries, shopping, miscellaneous);
			
			
			if ( total > 100){
				error.setText("Error, these values add up to "+ total +"% . Total cannot be greater than 100");
			}
			else if (entertainment < 0 || personalCare < 0 || foodGroceries < 0 || shopping < 0 || miscellaneous < 0){
					
				error.setText("Error, negative percentages not allowed.");
			
			}
			else{
				
				new Piechat(budgetTool, window).start(window);
		}
	}
	}

	class HandleBackToMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			new MenuGUI(budgetTool, window).start(window);
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
		//budgetTool.checkIfValidPercent(entText);
		
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
		/*if (Double.parseDouble(shopText.getText()) < 0 || Double.parseDouble(shopText.getText()) > 100){
			error.setText("That is an invlaid percent. Please enter a percent between 0 and 100%: ");
		}*/
		rowSho.getChildren().add(shop);
		rowSho.getChildren().add(shopText);

		//MISCELLANEOUS ROW
		HBox rowMis = new HBox();
		root.getChildren().add(rowMis);
		rowMis.setSpacing(25);
		rowMis.setAlignment(Pos.CENTER);
		Label misc = new Label("Miscellaneous? (ie. birthday gifts)");
		miscText = new TextField(budgetTool.gettingShopping() + "");
		
		rowMis.getChildren().add(misc);
		rowMis.getChildren().add(miscText);
		
	
		
		HBox errorText = new HBox();
		root.getChildren().add(errorText);
		errorText.setAlignment(Pos.CENTER);
		
		
		error = new Label();
		error.setWrapText(true);
		error.setTextFill(Color.web("#FF0000"));
		errorText.getChildren().add(error);
		


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