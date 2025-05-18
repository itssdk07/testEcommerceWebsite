package test;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
public class LoginTest extends TestBase {
	
	
	protected LoginPage testlogin = new LoginPage();
	
	
	//Test TC_LOGIN_01 : Login with valid username password
	@Test
	
	public void LoginValidTest() {
		testlogin.login("standard_user","secret_sauce");
		String currenturl = getCurrentURL();
		softassert.assertTrue(currenturl.contains("inventory"));
		softassert.assertAll();
	}
	
	//TC_LOGIN_02: Invalid login username password
	
	@Test
	
	public void LoginInvalidTest() throws InterruptedException {
		testlogin.login("invalidusrm", "invalidpwd");
			String errormessage = testlogin.geterrormsg();
			softassert.assertTrue(errormessage.contains("do not match"));
			softassert.assertAll();
		}
	
	//TC_LOGIN_03: Locked out login username password
	@Test
	public void LoginLockedoutUser() throws InterruptedException {
		testlogin.login("locked_out_user", "secret_sauce");
			String errormessage = testlogin.geterrormsg();
			softassert.assertTrue(errormessage.contains("locked out"));
			softassert.assertAll();
		}
	
	//TC_LOGIN_04: Empty fields log in 
	@Test
	
	public void LoginEmptyUser() throws InterruptedException {
		testlogin.clickLogin();;
			String errormessage = testlogin.geterrormsg();
			softassert.assertTrue(errormessage.contains("required"),"Error message is wrong !");
			softassert.assertAll();
		}
	
	
	
	
	}


