package test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CheckOutPage;

public class CheckOutTest extends TestBase {
	
	CheckOutPage checkout = new CheckOutPage(); 
	@BeforeClass
	public void loadapp() {
	    requireLogin = true; 
	    super.loadapp(); } 
	
	@Test
	//TC_CHECKOUT_01: Enter valid data: Check Complete message shown
	public void testCompleteMessage() throws IOException {
		int status=2;
		try {
			checkout = new CheckOutPage();
			checkout.openCheckOutPage();
			checkout.completeOrder();
			softassert.assertTrue(checkout.isCompleteMessageDisplayed(), "Complete message is displayed");
			//Back to cart so other tests should run properly
			navigateBack();
			navigateBack();

			

			status = 1;
			softassert.assertAll();
		} catch(Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status, 19);
		}
	}

	@Test
	//TC_CHECKOUT_02: Keep first name empty check correct error message displayed
	public void testEmptyFirstName() throws IOException {
		int status=2;
		try {
			checkout.openCheckOutPage();
			checkout.enterLastName("Lastname");
			checkout.enterPostalCode("123456");
			checkout.clickcontinue();
			String errormessage = checkout.getErrorMessage();
			softassert.assertTrue(errormessage.contains("First Name is required"), "First Name is required error message showing wrong");

			//Back to cart so other tests should run properly
			checkout.backToCartAndClear();
			status = 1;
			softassert.assertAll();
			
		} catch(Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status, 20);
		}
	}

	@Test
	//TC_CHECKOUT_03: Keep last name empty check correct error message displayed
	public void testEmptyLastName() throws IOException {
		int status=2;
		try {
			checkout.openCheckOutPage();
			checkout.enterFirstName("Firstname");
			checkout.enterPostalCode("123456");
			checkout.clickcontinue();
			String errormessage = checkout.getErrorMessage();
			softassert.assertTrue(errormessage.contains("Last Name is required"), "last Name is required error message showing wrong");

			//Back to cart so other tests should run properly
			checkout.backToCartAndClear();
			
			status = 1;
			softassert.assertAll();
			
		} catch(Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status, 21);
		}
	}

	@Test
	//TC_CHECKOUT_04: Keep postal code empty check correct error message displayed
	public void testEmptyPostalCode() throws IOException {
		int status=2;
		try {
			checkout.openCheckOutPage();
			checkout.enterFirstName("Firistname");
			checkout.enterLastName("LastName");
			checkout.clickcontinue();
			String errormessage = checkout.getErrorMessage();
			softassert.assertTrue(errormessage.contains("Postal Code is required"), "Postal Code is required error message showing wrong");

			//Back to cart so other tests should run properly
			checkout.backToCartAndClear();
			
			status = 1;
			softassert.assertAll();
			
		} catch(Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status, 22);
		}
	}

	@Test
	//TC_CHECKOUT_05: All empty check correct error message displayed
	public void testAllEmpty() throws IOException {
		int status=2;
		try {
			checkout.openCheckOutPage();
			checkout.clickcontinue();
			String errormessage = checkout.getErrorMessage();
			softassert.assertTrue(errormessage.contains("First Name is required"), "First Name is required error message showing wrong");

			//Back to cart so other tests should run properly
			checkout.backToCartAndClear();
			
			status = 1;
			softassert.assertAll();
			
		} catch(Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status, 23);
		}
	}

	@Test
	//TC_CHECKOUT_06: Cancel Checkout
	public void testCancelCheckOut() throws IOException {
		int status=2;
		try {
			checkout.openCheckOutPage();
			checkout.clickCancel();
			String link = getCurrentURL();
			softassert.assertTrue(link.contains("cart"), "after cancel checkout not redirecting to cart again");

			//Back to cart so other tests should run properly
			checkout.removeItemsFromCart();
			
			status = 1;
			softassert.assertAll();
		} catch(Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status, 24);}
	}
		
}
