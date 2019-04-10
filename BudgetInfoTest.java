import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.Date;
import java.util.Calendar;

public class BudgetInfoTest{

	public static final String CLASSNAME = "BudgetInfo";
	public static final String FILENAME = CLASSNAME + ".java";

	protected UserInfo u = new UserInfo(1000, 50, 50, 50, 50);


	private void testInterface(){
		String[] instanceVars = {"double amountToSave", "double remainingMoney", "Date userDate", 
			"UserInfo user"};
		assertTrue("Instance variables should be private with correct name and signature.", instanceVariablesArePrivate(instanceVars));
	}

	//Test Constructor
	@Test
	public void test_constructor_new_user(){
		testInterface();
		UserInfo user = new UserInfo();
		BudgetInfo bi = new BudgetInfo(user);

		assertEquals("Unexpected remaining money", 0.0, bi.getRemainingMoney(), 0.00001);
		assertEquals("Unexpected date", new Date(), bi.getDate());
	}

	@Test
	public void test_get_setRemainingMoney(){
		BudgetInfo bi = new BudgetInfo(u);

		assertEquals("Unexpected remaining money", 800, bi.getRemainingMoney(), 0.00001);
	}

	@Test 
	public void test_getAmountToSave(){
		BudgetInfo bi = new BudgetInfo(u);
		double amt = 800*0.12;

		assertEquals("Unexpected amount to save)", amt, bi.getAmountToSave(12), 0.00001);
	}

	@Test
	public void test_getDate(){
		BudgetInfo bi = new BudgetInfo(u);

		assertEquals("Unexpected date", new Date(), bi.getDate());
	}

	@Test
	public void test_setDate(){
		BudgetInfo bi = new BudgetInfo(u);
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MONTH, 4);
		Date dd = cal.getTime();
		bi.setDate(dd);

		assertEquals("Unexpected Date", dd, bi.getDate());
	}

	@Test
	public void test_getDateGoalCompleted(){
		BudgetInfo bi = new BudgetInfo();
		bi.setAmountToSave(25);
		Date d = new Date();
		bi.setDate(d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MONTH, 4);
		Date dd = cal.getTime();

		assertEquals("Unexpected date", dd, bi.getDateGoalCompleted(100));
	}

	@Test 
	public void test_getDateGoalCompleted2(){
		BudgetInfo bi = new BudgetInfo();
		bi.setAmountToSave(20);
		Date d = new Date();
		bi.setDate(d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.DATE, 15);
		Date dd = cal.getTime();

		assertEquals("Unexpected date", dd, bi.getDateGoalCompleted(10));
	}

	// END OF TESTS 

	private boolean noDefaultConstructor(){
		boolean noDefault = true;
		String[] versions = new String[9];
		versions[0] = "public " + CLASSNAME + "()";
		versions[1] = "public " + CLASSNAME + " ()";
		versions[2] = "public " + CLASSNAME + " ( )";
		versions[3] = "protected " + CLASSNAME + "()";
		versions[4] = "protected " + CLASSNAME + " ()";
		versions[5] = "protected " + CLASSNAME + " ( )";
		versions[6] = CLASSNAME + "()";
		versions[7] = CLASSNAME + " ()";
		versions[8] = CLASSNAME + " ( )";

		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				for (String stmt : versions) {
					if (line.contains(stmt)) {
						noDefault = false;
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			noDefault = false;
		} catch (IOException e) {
			noDefault =  false;
		}
		return noDefault;
	}		

	private boolean instanceVariablesArePrivate(String[] instanceVars){
		boolean[] varsPrivate = new boolean[instanceVars.length];
		for (int index = 0; index < instanceVars.length; index++){
			varsPrivate[index] = false;
		}
		boolean allPrivate = true;


		try {
			BufferedReader in = new BufferedReader(new FileReader(FILENAME));
			String line = in.readLine();
			while (line != null) {
				if (line.contains("private")) {
					line = line.trim();
					for (int index = 0; index < instanceVars.length; index++){
						String stmt = "private " + instanceVars[index];
						if (line.length() >= stmt.length()){
							String subline = line.substring(0,stmt.length());
							if (subline.equals(stmt)){
								varsPrivate[index] = true;
							}
						}
					}
				}
				line = in.readLine();
			}
			in.close();
		} catch (FileNotFoundException e) {
			allPrivate = false;
		} catch (IOException e) {
			allPrivate =  false;
		}

		for (boolean b : varsPrivate) {
			allPrivate = allPrivate && b;
		}
		return allPrivate;
	}			

}