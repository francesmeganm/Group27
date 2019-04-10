import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class UserInfoTest{

	public static final String CLASSNAME = "UserInfo";
	public static final String FILENAME = CLASSNAME + ".java";

	private void testInterface(){
		String[] instanceVars = {"double monthlyExpenses", "double monthlyIncome", "double transportCost", "double utilityCost", "double otherCost",
			"double rentCost", "UserInfo user"};
		assertTrue("Instance variables should be private with correct name and signature.", instanceVariablesArePrivate(instanceVars));
		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
	}

	//Test Constructors 
	@Test
	public void test_constructor_default(){
		UserInfo u = new UserInfo();

		assertEquals("Unexpected monthly expenses", 0.0, u.getMonthlyExpenses(), 0.00001);
		assertEquals("unexpected monthly income", 0.0, u.getMonthlyIncome(), 0.00001);
		assertEquals("Unexpected transport cost", 0.0, u.getTransport(), 0.00001);
		assertEquals("Unexpected utility cost", 0.0, u.getUtility(), 0.00001);
		assertEquals("Unexpected other cost", 0.0, u.getOther(), 0.00001);
		assertEquals("Unexpected rent cost", 0.0, u.getOther(), 0.00001);
	}

	@Test 
	public void test_constructor_toCopy(){
		UserInfo copy = new UserInfo(1000, 20, 20, 20, 20);

		UserInfo u = new UserInfo(copy);

		assertEquals("Unexpected monthly expenses", 80.0, u.getMonthlyExpenses(), 0.00001);
		assertEquals("unexpected monthly income", 1000.0, u.getMonthlyIncome(), 0.00001);
		assertEquals("Unexpected transport cost", 20.0, u.getTransport(), 0.00001);
		assertEquals("Unexpected utility cost", 20.0, u.getUtility(), 0.00001);
		assertEquals("Unexpected other cost", 20.0, u.getOther(), 0.00001);
		assertEquals("Unexpected rent cost", 20.0, u.getOther(), 0.00001);
	}

	@Test
	public void test_constructor_manualSet(){
		UserInfo u = new UserInfo(1000, 20, 20, 20, 20);

		assertEquals("Unexpected monthly expenses", 80.0, u.getMonthlyExpenses(), 0.00001);
		assertEquals("unexpected monthly income", 1000.0, u.getMonthlyIncome(), 0.00001);
		assertEquals("Unexpected transport cost", 20.0, u.getTransport(), 0.00001);
		assertEquals("Unexpected utility cost", 20.0, u.getUtility(), 0.00001);
		assertEquals("Unexpected other cost", 20.0, u.getOther(), 0.00001);
		assertEquals("Unexpected rent cost", 20.0, u.getOther(), 0.00001);
	}

	//Test Stters and Getters
	@Test
	public void test_setTransport(){
		UserInfo u = new UserInfo();

		u.setTransport(20.0);
		assertEquals("Unexpected transport cost", 20.0, u.getTransport(), 0.00001);

		u.setTransport(20.0);
		assertEquals("Transport cost should remain unchanged", 20.0, u.getTransport(), 0.00001);
	}

	@Test
	public void test_setUtility(){
		UserInfo u = new UserInfo();

		u.setUtility(30.0);
		assertEquals("Unexpected utility cost", 30.0, u.getUtility(), 0.00001);

		u.setUtility(30.0);
		assertEquals("Utility cost should remain unchanged", 30.0, u.getUtility(), 0.00001);
	}

	@Test
	public void test_setOther(){
		UserInfo u = new UserInfo();

		u.setOther(20.0);
		assertEquals("Unexpected other cost", 20.0, u.getOther(), 0.00001);

		u.setOther(20.0);
		assertEquals("Other cost should remain unchanged", 20.0, u.getOther(), 0.00001);
	}

	@Test
	public void test_setRent(){
		UserInfo u = new UserInfo();

		u.setRent(30.0);
		assertEquals("Unexpected rent cost", 30.0, u.getRent(), 0.00001);

		u.setRent(30.0);
		assertEquals("Rent cost should remain unchanged", 30.0, u.getRent(), 0.00001);
	}

	@Test
	public void test_setMonthlyIncome(){
		UserInfo u = new UserInfo();

		u.setMonthlyIncome(100);
		assertEquals("Unexpected monthly income", 100.0, u.getMonthlyIncome(), 0.00001);

		u.setMonthlyIncome(100);
		assertEquals("Monthly Income should remain unchanged", 100.0, u.getMonthlyIncome(), 0.00001);
	}

	@Test 
	public void test_getMonthlyIncome(){
		UserInfo u = new UserInfo(0, 50, 50, 50, 50);
		assertEquals("Unexpected monthly expenses", 200.0, u.getMonthlyExpenses(), 0.00001);

		u.setTransport(0);
		assertEquals("Unexpected monthly expenses", 150.0, u.getMonthlyExpenses(), 0.00001);
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