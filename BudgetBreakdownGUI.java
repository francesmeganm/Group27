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

/**
 * BudgetBreakdown GUI class creates a functioning interface for the BudgetBreakdown class.  
 * It creates an instance of BudgetTool, handles various budget-related events such as creating
 * a pie chart that serves as a visual for the data collected, and creates a scene graph to create 
 * a functioning budget window. 
 */
public class BudgetBreakdownGUI extends Application{
	
	Stage window; // Sets the window as the primary stage
	
	/** These are instance variables **/
	private BudgetTool budgetTool;
	private Label error;
	private double extra; 
	private TextField entText;
	private TextField persText;
	private TextField foodText;
	private TextField shopText;
	private TextField miscText;
	
	
	/** 
	* Constructor that takes a BudgetTool reference and the stage as arguments 
	*/
	public BudgetBreakdownGUI(BudgetTool bt, Stage win){
		this.budgetTool = bt;
		this.window = win;
	}
	/** 
	* HandleSetBudget class handles the event created when the user enters their information for the different categories 
	*/ 
	class HandleSetBudget implements EventHandler<ActionEvent>{
		/**
		Method gets the text entered by the user and assigns them to budget categories.
		*/
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
					error.setText("You have "+extra+"% left to input. That's: " + budgetTool.gettingExtra() + " extra dollars.");
					}else{
						error.setText("");
					}
			}
			
			
		}
	}
	/**
	* HandlePieChart creates a pie chart when the user clicks the 'Compute Graph' button
	**/
	class HandlePieChart implements EventHandler<ActionEvent>{
		/**
		* Method collects the data for the different categories in the budget breakdown and creates a chart for it.
		* If the total percentage allocated is greater than 100 or less than 0, an error message will be displayed.
		**/
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
	
	/** HandleBackToMenu class allows the user to go back to the main menu by clicking the 'Logout' button **/
	class HandleBackToMenu implements EventHandler<ActionEvent>{
		/**
		* Method creates a new MenuGUI instance that takes a reference of the BudgetTool class and the stage
		* in order to go back to the main menu.
		*/
		public void handle(ActionEvent event){
			new MenuGUI(budgetTool, window).start(window);
		}
	}
	/** Launches the current window **/
	public static void main(String[] args){
		launch(args);
	}
	
	/** 
	* Method creates a functioning GUI for the BudgetBreakdown class 
	* @param primaryStage
	*/
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

		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setAlignment(Pos.CENTER);
		root.getChildren().add(gp);

		

		//ENTERTAINMENT ROW
		Label ent = new Label("Entertainment? (ie.movies, games etc.)");
		entText = new TextField();
		entText.setPromptText("0-100%");

		gp.add(ent, 0, 0);
		gp.add(entText, 1, 0);

		
		//PERSONAL CARE ROW
		Label pers = new Label("Personal care? (ie. hair cuts, salons etc.)");
		persText = new TextField();
		persText.setPromptText("0-100%");

		gp.add(pers, 0, 1);
		gp.add(persText, 1, 1);

		//FOOD AND GROCERIES 
		Label food = new Label("Food and Groceries (including dining out)");
		foodText = new TextField();
		foodText.setPromptText("0-100%");
		
		gp.add(food, 0, 2);
		gp.add(foodText, 1, 2);

		//SHOPPING ROW
		Label shop = new Label("Shopping? (ie. clothing, shoes etc.)");
		shopText = new TextField();
		shopText.setPromptText("0-100%");

		gp.add(shop, 0,3);
		gp.add(shopText, 1, 3);

		//MISCELLANEOUS ROW
		Label misc = new Label("Miscellaneous? (ie. birthday gifts)");
		miscText = new TextField();
		miscText.setPromptText("0-100%");
		
		gp.add(misc, 0, 4);
		gp.add(miscText, 1, 4);
		
		//ERROR TEXT
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
