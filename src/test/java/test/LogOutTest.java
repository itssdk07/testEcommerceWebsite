package test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.InventoryPage;

public class LogOutTest extends TestBase {
	InventoryPage inventory = new InventoryPage();
	
	@BeforeClass
	public void loadapp() {
	    requireLogin = true; 
	    super.loadapp(); } 
	
	@Test
	//TC_LOGOUT_01: Logout from menu
	public void testLogOut() throws InterruptedException, IOException {
		int status=2;
		try {
		inventory.logOutApp();
		String link = getCurrentURL();
		softassert.assertTrue(link.equals("https://www.saucedemo.com/"),"After logut not redirecting to login Page");
		status = 1;
		softassert.assertAll();
		}
		catch(Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status,25);
		}
	}
	
	
}
