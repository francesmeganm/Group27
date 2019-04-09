import static org.junit.Assert.*;
import org.junit.Test;

public class BudgetBreakdownTest extends FormatTester{

	public static final String CLASSNAME = "BudgetBreakdown";
	public static final String FILENAME = CLASSNAME + ".java";

	protected UserInfo u = new UserInfo(1000, 50, 50, 50, 50);

	public BudgetBreakdownTest(){
		super("BudgetBreakdown", false);
	}

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
		assertEquals("Unexpected transportation expense", 50.0, bb.getTransport(), 0.00001);

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

		assertEquals("Unexpected extra money balance", 0.0, bb.getAmountExtra(), 0.00001);

		bb.setAmountForMiscellaneous(25.0);
		bb.setAmountForEntertainment(25.0);
		bb.setAmountExtra();

		assertEquals("Unexpected extra money balance", 0.0, bb.getAmountExtra(), 0.00001);
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

}