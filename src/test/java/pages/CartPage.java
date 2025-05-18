package pages;

import org.openqa.selenium.By;

public class CartPage extends PageBase {
	
	By backPackInCart = By.id("item_4_title_link");
	By bikeLightInCart = By.id("item_0_title_link");
	By removeBackPackCart = By.id("remove-sauce-labs-backpack");
	By removeBikeLightCart = By.id("remove-sauce-labs-bike-light");
	By checkOutButton = By.id("checkout");
	By continueShopping = By.id("continue-shopping");
	
	//Check added items showing in cart or not
	public boolean isBackPackInCart() {
		try {
			waitForVisibility(backPackInCart, 1);
			return true;
		}
		catch(Exception e) {
			System.out.println("BackPack not visible in the cart");
			return false;
		}
		}
	
	public boolean isBikeLightInCart() {
		try {
			waitForVisibility(bikeLightInCart, 1);
			return true;
		}
		catch(Exception e) {
			System.out.println("BackPack not visible in the cart");
			return false;
		}
		}
	
	
	//remove items from cart
	
	public void removeBackPackCart() {
		click(removeBackPackCart);
	}
	public void removeBikeLightCart() {
		click(removeBikeLightCart);
	}
	
	
	
	public void clickCheckOut() {
		click(checkOutButton);
	}
	
	//click continue shopping 
	public void clickContinueShopping() {
		click(continueShopping);
	}
	
	//click checkout button
	public void clickCheckoutbtn() {
		click(checkOutButton);
	}
	
	//add two items and open the cart
	public void additemsAndOpenCart() {
		InventoryPage inventory = new InventoryPage();
		openInventoryPage();
		inventory.addtoCartBackPack();
		inventory.addtoCartBikeLight();
		inventory.openCart();
		
	}
	
	public void clearCart() {
		removeBackPackCart();
		removeBikeLightCart();
	}
	
}
