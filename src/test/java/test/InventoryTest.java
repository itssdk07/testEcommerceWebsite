package test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.InventoryPage;

public class InventoryTest extends TestBase {
	
	
	 InventoryPage inventory = new InventoryPage();
	

	
	@BeforeClass
	public void loadapp() {
	    requireLogin = true; 
	    super.loadapp();
	}

	@Test
	//TC_INV_01 : Login → Check expected number of items displayed
	public void testExpectedNoOfItems() throws IOException {
		int status =2; 
		try {
		softassert.assertTrue(inventory.checkAllitemsloaded(6));
		
		status = 1;
		softassert.assertAll();
		}
		catch(AssertionError | Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status,10);
		}
	}
	
	@Test
	//TC_INV_02	Add item to cart : Button changes to “Remove”, cart shows 2 item
	public void testAddItemToCart() throws IOException {
		int status =2; 
		try {
		inventory.addtoCartBackPack();
		softassert.assertTrue(inventory.removeBackpackIsDisplayed()); //after adding item remove button visible
		inventory.addtoCartBikeLight();
		softassert.assertTrue(inventory.removeBikeLightIsDisplayed()); //after adding item remove button visible
		int cart = inventory.cartNoOfItems();
		softassert.assertEquals(cart, 2, "Cart does not showing 2 item added");  //Cart showing 1 item added
		//clean up cart for another Test
		inventory.clearCart();
		status = 1;
		softassert.assertAll();
		}
		catch(AssertionError | Exception e) {
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status,11);
		}
	}
	
	//Everytime new browser login is not happening here it going with the flow please check !!!
	
	@Test
	//TC_INV_03: Item removed, cart count updated
	public void testRemoveItemCart() throws InterruptedException, IOException {
		int status=2;
		try {
		inventory.addtoCartBackPack();
		inventory.addtoCartBikeLight();
		inventory.removeBackPack();
		int cartCount = inventory.cartNoOfItems();
		softassert.assertEquals(cartCount, 1, "Cart No of items not equal to 1 after removing item" );
		
		//Clear cart for another test
		inventory.removeBikeLight();
		
		status =1;
		softassert.assertAll();
		}
		catch (AssertionError | Exception e) {
			
			status = 2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status,12);
		}
	
	}
	
	@Test
	//TC_INV_04: Redirected to product details
	public void testOpenProductDetails() throws IOException {
		int status=2;
		try {
		inventory.openBackPackProductDetails();
		String productDetailsLink = getCurrentURL();
		softassert.assertTrue(productDetailsLink.contains("item"));	
		
		//redirect to inventory page for another class
		navigateBack();
		
		
		status=1;
		softassert.assertAll();
		}
		catch(Exception e) {
			status =2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status,13);
		}
	}
	
	@Test
	//TC_INV_05: Redirected to cart
	public void testOpenCart() throws IOException {
		int status=2;
		try {
		inventory.openCart();
		String cartLink = getCurrentURL();
		softassert.assertTrue(cartLink.contains("cart"));
		
		//redirect to inventory page for another Tests
		navigateBack();
		status =1;
		softassert.assertAll();
		}
		catch(Exception e) {
			status =2;
			throw e;
		}
		finally {
		updateStatusIntoExcel(status,14);
		}
	}

}
