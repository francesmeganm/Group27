
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieChartSample1 extends Application {
    private UserInfo currentAccount = new UserInfo();
    private BudgetBreakdown n = new BudgetBreakdown(currentAccount);

    public void start(Stage primaryStage){
        primaryStage.setTitle("SAVEBETTER");

        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Entertainment", n.getAmountForEntertainment());
        PieChart.Data slice2 = new PieChart.Data("Personal Care"  , n.getAmountForPersonalCare());
        PieChart.Data slice3 = new PieChart.Data("Food and Groceries" , n.getAmountForFoodAndGroceries());
        PieChart.Data slice4 = new PieChart.Data("Shopping", n.getAmountForShopping());
        PieChart.Data slice5 = new PieChart.Data("Miscellaneous", n.getAmountForMiscellaneous());

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);
        pieChart.getData().add(slice4);
        pieChart.getData().add(slice5);

        VBox vbox = new VBox(pieChart);

        Scene scene = new Scene(vbox, 200, 300);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(1200);

        primaryStage.show();
    }

    public static void main(String[] args) {
    	launch(args);
    }
}