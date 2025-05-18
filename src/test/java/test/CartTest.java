package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends TestBase {
	
	CartPage cart = new CartPage();
	
	
	@BeforeClass
	public void loadapp() {
	    requireLogin = true; 
	    super.loadapp(); } 
	    
	@Test
	//TC_CART_01: Cart page shows added items
	public void checkItemsAddedCart() {
		cart.additemsAndOpenCart();
		softassert.assertTrue(cart.isBackPackInCart(), "Back Pack is not in the Cart"); //added backpack item is in the cart or not
		softassert.assertTrue(cart.isBikeLightInCart(), "Bike Light is not in the cart"); //added Bikelight item is the cart or not
		
		//clear the cart for another Tests
		cart.clearCart();
		softassert.assertAll();
		
	}
	
	@Test
	//TC_CART_02: Check item is removed
	public void isItemBackPackRemoved() {
		cart.additemsAndOpenCart();
		cart.removeBackPackCart();
		boolean backPackvisibilty = cart.isBackPackInCart();
		softassert.assertFalse(backPackvisibilty, "Back Pack is not removed from the cart");
		
		//clear cart for other test
		cart.removeBikeLightCart();
		softassert.assertAll();
	}
	
	
	@Test
	//TC_CART_03: Click “Continue Shopping”	Returns to inventory page
	public void testContinueShopping() {
		cart.additemsAndOpenCart();
		cart.clickContinueShopping();
		String link = getCurrentURL();
		softassert.assertTrue(link.contains("inventory"), "Not redirecting to inventory page");
		
		//clear cart for another tests
		cart.clearCart();
		softassert.assertAll();
	}
	
	@Test
	
	//TC_CART_04: click "CheckOut" Redirects to Checkout page
	
	public void testCheckOutbtn() {
		cart.openCartPage();
		cart.clickCheckOut();
		String link = getCurrentURL();
		softassert.assertTrue(link.contains("checkout"), "Not redirecting to checkout page");
		
	}
	
}
