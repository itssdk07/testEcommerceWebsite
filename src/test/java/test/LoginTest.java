package test;
import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTest extends TestBase {
	
	
	protected LoginPage testlogin = new LoginPage();
	
	
	//Test TC_LOGIN_01 : Login with valid username password
	@Test
	
	public void LoginValidTest() throws IOException {	
		 int status =2; 
		 String comment ="Login with Valid username password failed !!!" ;
	try {
		testlogin.login("standard_user","secret_sauce");
		String currenturl = getCurrentURL();
		softassert.assertTrue(currenturl.contains("inventory"));
		
		status = ITestResult.SUCCESS;
		comment = "Login with Valid username password Passed !!!";
		navigateBack();
		softassert.assertAll();
		}
	catch (AssertionError | Exception e) {
		comment = "Login with Valid username password failed !!!";
		status = ITestResult.FAILURE;
		throw e;
	}
	finally {
	updateStatusIntoExcel(status, 6);
	updateCommentIntoExcel(comment, 6);
	}
	}
	
	//TC_LOGIN_02: Invalid login username password
	
	@Test
	
	public void LoginInvalidTest() throws InterruptedException, IOException {
		int status = 2;
		try {
		testlogin.login("invalidusrm", "invalidpwd");
			String errormessage = testlogin.geterrormsg();
			softassert.assertTrue(errormessage.contains("do not match"));
			
			status = ITestResult.SUCCESS;
			softassert.assertAll();
			}
		catch (AssertionError | Exception e) {
			status = ITestResult.FAILURE;
			throw e;
		}	
		finally {updateStatusIntoExcel(status, 7);}
		
	}
			
	//TC_LOGIN_03: Locked out login username password
	@Test
	public void LoginLockedoutUser() throws InterruptedException, IOException {
		int status=2;
		try {
		testlogin.login("locked_out_user", "secret_sauce");
			String errormessage = testlogin.geterrormsg();
			softassert.assertTrue(errormessage.contains("locked out"));
			
			status =ITestResult.SUCCESS;
			softassert.assertAll();
		}
		catch(AssertionError | Exception e) {
			status = ITestResult.FAILURE;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status, 8);
		}
	}
	
	
	//TC_LOGIN_04: Empty fields log in 
	@Test
	
	public void LoginEmptyUser() throws InterruptedException, IOException {
		    int status=2;
		    try {
			testlogin.clickLogin();;
			String errormessage = testlogin.geterrormsg();
			softassert.assertTrue(errormessage.contains("required"),"Error message is wrong !");
			
			status = ITestResult.SUCCESS;
			softassert.assertAll();
		}
		    catch(AssertionError | Exception e) {
		    	status = ITestResult.FAILURE;
		    	throw e;
		    }
		    finally {
		    updateStatusIntoExcel(status,9);
		    }
	}
	
	}


