import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.awt.Font.*;
import javafx.scene.text.TextFlow.*;
import javafx.scene.text.FontWeight;
import java.lang.Object.*;
import javafx.scene.text.Font; 
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.Locale;

/**
The class UserInfoGUI handles events of getting and setting variables that are in 
 the UserInfo class
 It has 6 instance variables that all hold values of TextField inputed by the 
 user in the GUI
*/
public class BudgetInfoGUI extends Application{
	Stage window;
	private BudgetTool budgetTool;
	private TextField percentage;
	private TextField inputGoal;
	private Label input1;
	private Label input2;
	private Date startDate;
	private Label error;
	private Label error2;

	public BudgetInfoGUI(BudgetTool bt, Stage win){
		this.budgetTool = bt;
		this.window = win;
	}

	class HandlePercentage implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String per = percentage.getText();
			double per1 = Double.parseDouble(per);
			
			if ( per1 > 100){
					error.setText( per1 +"% .Percent cannot be greater than 100");
					input1.setText(" ");
			}
			else if (per1<0){
					error.setText(" Negative percentages not allowed.");
					input1.setText(" ");
			}
			else{
				error.setText("");
				budgetTool.settingTheAmountToSave(per1);
				double per2 = budgetTool.gettingTheAmountToSave(per1);
				input1.setText("$ " + per2 + "");
			}
		}
	}

	class HandleGoal implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			String goal = inputGoal.getText();
			double goal1 = Double.parseDouble(goal);
			System.out.println(goal1);
        	budgetTool.settingDate(startDate);
			Date due = budgetTool.gettingDateGoalCompleted(goal1);
			if ( goal1 <0){
				error2.setText( "Error, please enter a positive value.");
				input2.setText(" ");
			}
			else{
			
			System.out.println(startDate);
			System.out.println(due);
			input2.setText(due + "");
			error2.setText(" ");
		}
	}
	}

	class HandleBackToMenu implements EventHandler<ActionEvent>{
		public void handle(ActionEvent event){
			Stage s = new Stage();
			new MenuGUI(budgetTool, window).start(window);
		}
	}

	/**
	Method creates the GUI display for the user representing the UserInfo
	User can enter and update all their expenses and income
	*/
	public void start(Stage primaryStage){
		window = primaryStage;
		window.setTitle("SaveBetter");

		VBox root = new VBox();
		root.setSpacing(25);
		root.setAlignment(Pos.CENTER);
		root.setStyle("-fx-background-color: LIMEGREEN;");
		

		final DatePicker datePicker = new DatePicker();
        datePicker.localeProperty().set(Locale.US);

		Text title = new Text("Budget Infomation");
		title.setFont(Font.font("Courier", FontWeight.BOLD, 25));   
		title.setFill(Color.WHITE);
		root.getChildren().add(title);

		//AMOUNT AVALIABLE TO SAVE EACH MONTH
		//BOLD
		HBox h1 = new HBox();
		root.getChildren().add(h1);
		h1.setSpacing(25);
		h1.setAlignment(Pos.CENTER);
		Label a = new Label("Avaliable funds to save each month: ");
		h1.getChildren().add(a);

		Label c = new Label("$" + Double.toString(budgetTool.gettingTheRemainingMoney()));
		h1.getChildren().add(c);

		//AMOUNT TO SAVE FROM PERCENTAGE
		//BOLD
		HBox h2 = new HBox();
		root.getChildren().add(h2);
		h2.setSpacing(25);
		h2.setAlignment(Pos.CENTER);

		Label e = new Label("Desired percentage of remaining money to save: ");
		h2.getChildren().add(e);

		percentage = new TextField("0.0%");
		h2.getChildren().add(percentage);
			
		HBox errorText = new HBox();
		root.getChildren().add(errorText);
		errorText.setAlignment(Pos.CENTER);
		
		
		error = new Label();
		error.setWrapText(true);
		error.setTextFill(Color.web("#FF0000"));
		errorText.getChildren().add(error);
		
		Button g = new Button("Compute");
		h2.getChildren().add(g);
		g.setOnAction(new HandlePercentage());

		HBox h3 = new HBox();
		root.getChildren().add(h3);
		h3.setSpacing(25);
		h3.setAlignment(Pos.CENTER);

		Label f = new Label("The amount to save is: ");
		h3.getChildren().add(f);

		input1 = new Label("" + "0.00");
		h3.getChildren().add(input1);

		//MONTHS UNTIL GOAL
		//BOLD
		HBox h4 = new HBox();
		root.getChildren().add(h4);
		h4.setSpacing(25);
		h4.setAlignment(Pos.CENTER);

		Label j = new Label("Cost of given goal: ");
		h4.getChildren().add(j);

		TextField goalCost = new TextField("0.00");
		inputGoal = goalCost;
		h4.getChildren().add(goalCost);
		
		HBox errorText2 = new HBox();
		root.getChildren().add(errorText2);
		errorText2.setAlignment(Pos.CENTER);
		
		
		error2 = new Label();
		error2.setWrapText(true);
		error2.setTextFill(Color.web("#FF0000"));
		errorText2.getChildren().add(error2);
		
		//BOLD
		HBox h5 = new HBox();
		root.getChildren().add(h5);
		h5.setSpacing(25);
		h5.setAlignment(Pos.CENTER);

		Label what = new Label("Choose date to start Saving: ");
		h5.getChildren().add(what);

		h5.getChildren().add(datePicker);


        datePicker.selectedDateProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println(datePicker.selectedDateProperty().get());
                startDate = datePicker.selectedDateProperty().get();
            }
        });

        datePicker.setLocale(Locale.US);
        datePicker.getCalendarView().todayButtonTextProperty().set("Current Date");		

        Date goalEnds = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String date1 = format.format(goalEnds);

		HBox h6 = new HBox();
		root.getChildren().add(h6);
		h6.setSpacing(25);
		h6.setAlignment(Pos.CENTER);

		Label l = new Label("Date goal is completed: ");
		h6.getChildren().add(l);

		input2 = new Label(format.format(goalEnds));
		h6.getChildren().add(input2);

		Button k = new Button("Compute");
		h5.getChildren().add(k);
		k.setOnAction(new HandleGoal());

		Button back = new Button("Back to main menu");
		root.getChildren().add(back);
		back.setOnAction(new HandleBackToMenu());
		
		
		
		Scene scene = new Scene(root, 1366, 768);
		scene.getStylesheets().add("calendarstyle.css");
		window.setScene(scene);

		window.show();
	}
}