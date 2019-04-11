import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


//this file should connect to budget tool 
public class Piechat extends Application{
    Stage window;
    private BudgetTool budgetTool;
    private Paint WHITE;
	//private static final Paint WHITE = null;
	class HandleBackToMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new MenuGUI(budgetTool).start(s);
			window.close();
		}
	}

    public Piechat(BudgetTool bt){
        this.budgetTool = bt;
    }

	public static void main(String[] args) {
    	launch(args);
    }
	public void start(Stage primaryStage){
        window = primaryStage;

        PieChart pieChart = new PieChart();
        //these number should call budget tool
        PieChart.Data slice1 = new PieChart.Data("Entertainment", budgetTool.gettingEntertainment());
        PieChart.Data slice2 = new PieChart.Data("Personal Care"  , budgetTool.gettingPersonal());
        PieChart.Data slice3 = new PieChart.Data("Food and Groceries" , budgetTool.gettingFood());
        PieChart.Data slice4 = new PieChart.Data("Shopping", budgetTool.gettingShopping());
        PieChart.Data slice5 = new PieChart.Data("Miscellaneous", budgetTool.gettingMisc());
		PieChart.Data slice6 = new PieChart.Data("Extras", budgetTool.gettingExtra());

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);
		pieChart.getData().add(slice6);
        //if the title of pie chart need change 
        pieChart.setTitle("Budget Breakdown Analysis");
        pieChart.setLayoutX(350);
        pieChart.setLayoutY(100);
        
        Group root = new Group(pieChart);
        
        Rectangle whitebox = new Rectangle();
        whitebox.setX(1000);
        whitebox.setY(180);
        whitebox.setWidth(180);
        whitebox.setHeight(180);
        whitebox.setFill(Color.WHITE);
        whitebox.setStroke(Color.WHITE);
        root.getChildren().add(whitebox);
        
        //same , these number should call budget tool 
        Text Entertainment = new Text(1000, 200 , "Entertainment: $" + budgetTool.gettingEntertainment());
        Text PersonalCare = new Text(1000, 230 , "Personal Care: $" + budgetTool.gettingPersonal());
        Text FoodandGroceries = new Text(1000, 260 , "Food and Groceries: $" + budgetTool.gettingFood());
        Text Shopping = new Text(1000, 290 , "Shopping: $" + budgetTool.gettingShopping());
        Text Miscellaneous = new Text(1000, 320 , "Miscellaneous: $" + budgetTool.gettingMisc());
		Text Extra = new Text(1000, 350 , "Extra: $" + budgetTool.gettingExtra());
		
        //if the color change, delete below 
        Entertainment.setFill(Color.RED);
        PersonalCare.setFill(Color.ORANGE);
        FoodandGroceries.setFill(Color.FORESTGREEN);
        Shopping.setFill(Color.SKYBLUE);
        Miscellaneous.setFill(Color.DEEPSKYBLUE);
		Extra.setFill(Color.GREY);
        root.getChildren().add(Entertainment);
        root.getChildren().add(PersonalCare);
        root.getChildren().add(FoodandGroceries);
        root.getChildren().add(Shopping);
        root.getChildren().add(Miscellaneous);
		root.getChildren().add(Extra);
		
		Button back = new Button("Back to main menu");
		back.setStyle("-fx-background-color: white; -fx-text-fill: black;");
		back.setStyle("-fx-font-size: 1.1em; ");
		root.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());
        
        //if the title need change 
        window.setTitle("SAVEBETTER");
        Scene scene = new Scene(root, 1366, 786, Color.LIMEGREEN);
        window.setScene(scene);
        window.show();
    }
}