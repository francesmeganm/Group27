import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashMap;

public class AccountsTest{
	String filename = "Accounts.java";

	@Test
	public void createAccount_getUsernameAndPassword_newAccount(){
		Accounts a = new Accounts();

		a.createAccount("john", "123");

		HashMap<String, String> list = new HashMap<String, String>(a.getUsernameAndPassword());
		assertTrue("Checking for name in the HashMap",list.containsKey("john"));
		assertEquals("Checking for correct password in list", "123", list.get("john"));
	}

	@Test 
	public void createAccount_and_getUsernameAndPassword_multipleAccounts(){
		Accounts a = new Accounts();

		a.createAccount("john", "123");
		a.createAccount("Abby", "abc");

		HashMap<String, String> list = new HashMap<String, String>(a.getUsernameAndPassword());
		assertTrue("Checking for name in the HashMap",list.containsKey("john"));
		assertEquals("Checking for correct password in list", "123", list.get("john"));
		assertTrue("Checking for name in the HashMap", list.containsKey("Abby"));
		assertEquals("Checking for correct password in list", "abc", list.get("Abby"));
	}

	@Test
	public void checkUsername_uniqueUsername(){
		Accounts a = new Accounts();

		a.createAccount("Abby", "abc");

		assertTrue("Checking unqiue username jim", a.checkUsername("jim"));
	}

	@Test
	public void checkUsername_replicatedUsername(){
		Accounts a = new Accounts();

		a.createAccount("Abby", "abc");

		assertFalse("Checking unqiue username Abby", a.checkUsername("Abby"));
	}

	@Test 
	public void verifyUsernameAndPassword_correctUsernameAndPassword(){
		Accounts a = new Accounts();

		a.createAccount("Abby", "abc");

		assertTrue("Checking correct username and password", a.verifyUsernameAndPassword("Abby", "abc"));
	}

	@Test 
	public void verifyUsernameAndPassword_correctUsernameAndIncorrectPassword(){
		Accounts a = new Accounts();

		a.createAccount("Abby", "abc");

		assertFalse("Checking correct username with incorrect password", a.verifyUsernameAndPassword("Abby", "123"));
	}

	@Test 
	public void getUserInfo(){
		Accounts a = new Accounts();

		a.createAccount("Abby", "abc");

		HashMap<String, UserInfo> list = new HashMap<String, UserInfo>(a.getUsernameAndUserInfo());
		UserInfo u = list.get("Abby");
		assertEquals("Testing the return of a UserInfo", u, a.getUserInfo("Abby"));
	}

	@Test
	public void getUsernameAndUserInfo(){
		Accounts a = new Accounts();

		a.createAccount("Abby", "abc");
		HashMap<String, UserInfo> list = new HashMap<String, UserInfo>(a.getUsernameAndUserInfo());
		UserInfo u = a.getUserInfo("Abby");

		assertEquals("Testing the return of a UserInfo in a list", u, list.get("Abby"));

	}
}