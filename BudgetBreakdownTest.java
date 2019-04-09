import static org.junit.Assert.*;
import org.junit.Test;

public class BudgetBreakdownTest extends FormatTester{

	public static final String CLASSNAME = "BudgetBreakdown";
	public static final String FILENAME = CLASSNAME + ".java";

	protected UserInfo u = new UserInfo();

	public BudgetBreakdownTest(){
		super("BudgetBreakdown", false);
	}

	public class MockBudgetBreakdown extends BudgetBreakdown{
		public MockBudgetBreakdown(UserInfo u){
			super(u);
		}

		double amountForEntertainment=0.0;
		double amountForPersonalCare=0.0;
		double amountForFoodAndGroceries=0.0;
		double amountForShopping=0.0;
		double amountForMiscellaneous =0.0;
		double amountExtra = 0.0;
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

		BudgetBreakdown bb = new MockBudgetBreakdown(u);

		assertEquals("Unexpected transport expense", 800.0, bb.getRemainingMoney(), 0.00001);

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
		BudgetBreakdown bb = new MockBudgetBreakdown(u);
		bb.setAmountForEntertainment(20.0);
		assertEquals("Unexpected entertainemnt balance", 20.0, bb.getAmountForEntertainment(), 0.00001);
		assertEquals("Unexpected amount extra balance", 620.0, bb.getAmountExtra(), 0.00001);
	}
}