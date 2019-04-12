

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class BudgetBreakdownTest{

	public static final String CLASSNAME = "BudgetBreakdown";
	public static final String FILENAME = CLASSNAME + ".java";

	protected UserInfo u = new UserInfo(1000, 50, 50, 50, 50);


	private void testInterface(){
		String[] instanceVars = {"double amountForEntertainment", "double amountForPersonalCare", "double amountForFoodAndGroceries", 
			"double amountForShopping", "double amountForMiscellaneous", "double amountForMiscellaneous"};
		assertTrue("Instance variables should be private with correct name and signature.", instanceVariablesArePrivate(instanceVars));
		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
	}

	//Test Constructor
	@Test
	public void test_constructor_new_user(){
		testInterface();
		UserInfo user = new UserInfo();
		BudgetBreakdown bb = new BudgetBreakdown(user);

		assertEquals("Unexpected remaining money", 0.0, bb.getRemainingMoney(), 0.00001);

		assertEquals("Unexpected entertainment balance", 0.0, bb.getAmountForEntertainment(), 0.00001);
		assertEquals("Unexpected personal care balance", 0.0, bb.getAmountForPersonalCare(), 0.00001);
		assertEquals("Unexpected food and groceries balance", 0.0, bb.getAmountForFoodAndGroceries(), 0.00001);
		assertEquals("Unexpected shopping balance", 0.0, bb.getAmountForShopping(), 0.00001);
		assertEquals("Unexpected miscellaneous balance", 0.0, bb.getAmountForMiscellaneous(), 0.00001);
		assertEquals("Unexpected extra balance", 0.0, bb.getAmountExtra(), 0.00001);
	}

	@Test
	public void test_constructor_existing_user(){
		testInterface();

		BudgetBreakdown bb = new BudgetBreakdown(u);

		assertEquals("Unexpected remaining money", 800.0, bb.getRemainingMoney(), 0.00001);
		assertEquals("Unexpected transportation expense", 50.0, u.getTransport(), 0.00001);

		assertEquals("Unexpected entertainment balance", 0.0, bb.getAmountForEntertainment(), 0.00001);
		assertEquals("Unexpected personal care balance", 0.0, bb.getAmountForPersonalCare(), 0.00001);
		assertEquals("Unexpected food and groceries balance", 0.0, bb.getAmountForFoodAndGroceries(), 0.00001);
		assertEquals("Unexpected shopping balance", 0.0, bb.getAmountForShopping(), 0.00001);
		assertEquals("Unexpected miscellaneous balance", 0.0, bb.getAmountForMiscellaneous(), 0.00001);
		assertEquals("Unexpected extra balance", 0.0, bb.getAmountExtra(), 0.00001);
	}

	//Test Setters and Getters 
	@Test
	public void test_setAmountForEntertainment(){
		BudgetBreakdown bb = new BudgetBreakdown(u);

		bb.setAmountForEntertainment(20.0);
		bb.setAmountExtra();

		assertEquals("Unexpected entertainment balance", 160.0, bb.getAmountForEntertainment(), 0.00001);
		assertEquals("Unexpected amount extra balance", 640.0, bb.getAmountExtra(), 0.00001);
	}

	@Test
	public void test_setAmountForPersonalCare(){
		BudgetBreakdown bb = new BudgetBreakdown(u);

		bb.setAmountForPersonalCare(25.0);
		bb.setAmountExtra();

		assertEquals("Unexpected personal care balance", 200.0, bb.getAmountForPersonalCare(), 0.00001);
		assertEquals("Unexpected amount extra balance", 600.0, bb.getAmountExtra(), 0.00001);
	}

	@Test
	public void test_setAmountForFoodAndGroceries(){
		BudgetBreakdown bb = new BudgetBreakdown(u);

		bb.setAmountForFoodAndGroceries(10.0);
		bb.setAmountExtra();

		assertEquals("Unexpected food and groceries balance", 80.0, bb.getAmountForFoodAndGroceries(), 0.00001);
		assertEquals("Unexpected amount extra balance", 720.0, bb.getAmountExtra(), 0.00001);
	}

	@Test
	public void test_setAmountForShopping(){
		BudgetBreakdown bb = new BudgetBreakdown(u);

		bb.setAmountForShopping(75.0);
		bb.setAmountExtra();

		assertEquals("Unexpected entertainment balance", 600.0, bb.getAmountForShopping(), 0.00001);
		assertEquals("Unexpected amount extra balance", 200.0, bb.getAmountExtra(), 0.00001);
	}

	@Test
	public void test_setAmountForMiscellaneous(){
		BudgetBreakdown bb = new BudgetBreakdown(u);

		bb.setAmountForMiscellaneous(5.0);
		bb.setAmountExtra();

		assertEquals("Unexpected entertainment balance", 40.0, bb.getAmountForMiscellaneous(), 0.00001);
		assertEquals("Unexpected amount extra balance", 760.0, bb.getAmountExtra(), 0.00001);
	}

	@Test
	public void test_setAmountExtra_noExtraMoney(){
		BudgetBreakdown bb = new BudgetBreakdown(u);

		bb.setAmountForMiscellaneous(50.0);
		bb.setAmountForShopping(50.0);
		bb.setAmountExtra();

		assertEquals("Spending money fully distributed", 0.0, bb.getAmountExtra(), 0.00001);

		bb.setAmountForMiscellaneous(25.0);
		bb.setAmountForEntertainment(25.0);
		bb.setAmountExtra();

		assertEquals("Spending money fully distributed", 0.0, bb.getAmountExtra(), 0.00001);
	}

	@Test
	public void test_setAmountExtra_extraMoney(){
		BudgetBreakdown bb = new BudgetBreakdown(u);

		bb.setAmountForMiscellaneous(50.0);
		bb.setAmountForShopping(25.0);
		bb.setAmountExtra();

		assertEquals("Unexpected extra money balance", 200.0, bb.getAmountExtra(), 0.00001);

		bb.setAmountForMiscellaneous(25.0);
		bb.setAmountExtra();

		assertEquals("Unexpected extra money balance", 400.0, bb.getAmountExtra(), 0.00001);
	}

	@Test public void test_getAmountExtra_notUpdated(){
		BudgetBreakdown bb = new BudgetBreakdown(u);

		bb.setAmountForMiscellaneous(50.0);
		bb.setAmountForShopping(25.0);

		assertEquals("Amount extra was not updated", 0.0, bb.getAmountExtra(), 0.00001);

		bb.setAmountExtra();
		assertEquals("Amount extra should have updated", 200.0, bb.getAmountExtra(), 0.00001);
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