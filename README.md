# Group27 SaveBetter

#References 
* https://stackoverflow.com/questions/4905416/how-do-i-add-one-month-to-current-date-in-java Referenced in BudgetInfo.java Lines 34 -38 
* http://tutorials.jenkov.com/javafx/piechart.html Referenced in PieChartSample1.java throughout whole class with slight modifications 
* Lecture 12 Event Handling Class Examples HandleButtonClicked.java Referenced in UserInfoGUI.java, BudgetBreakdownGUI.java, and MenuGUI.java 
* http://myjavafx.blogspot.com/2012/01/javafx-calendar-control.html Referenced in Date Picker.java Caledarstyle, throughout the whole Calendar class with modifications.

#Where to find: All files found in master branch of Group27 repository. Download zip file. 

#Compiling & Running: 
* Use command prompt to go to directory inside of downloaded zip file, go into master(or downloaded file), go into SaveBetter

* To compile and run the Textbased version: 
	* to compile use the command: javac text/SaveBetterText.java
	* to run the program use the command: java text.SaveBetterText


* In complie and run the GUI version:
	* to compile use command: javac gui/SaveBetterGUI.java
	* to run use command: java gui.SaveBetterGUI

To use, you must create an account, which you would then be able to log out of and re-login to to access your personal budgets and 
expenses and income information that you have entered. From the main menu you will then be given several options for updating your 
budget/user info to making simple budgets or displaying spending graphics.


//TESTDOCUMENT.md

*Use command prompt to go to directory inside of downloaded zip file, go into master(or downloaded file), go into JUnitTests
*To compile all files use command: javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
*Run each logic test individually
	*To test Accounts use command: java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore AccountsTest
  *To test BudgetBreakdown use command: java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore BudgetBreakdownTest
  *To test BudgetInfo use command: java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore BudgetInfoTest
  *To test UserInfo use command: java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore UserInfoTest
