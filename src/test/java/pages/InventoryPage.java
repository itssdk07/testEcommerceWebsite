package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InventoryPage extends PageBase {
	By itemlist = By.className("inventory_item");
	By addtoCartBackPack = By.id("add-to-cart-sauce-labs-backpack");
	By removeBackPack = By.id("remove-sauce-labs-backpack");
	By addtoCartBikeLight = By.id("add-to-cart-sauce-labs-bike-light");
	By removeBikeLight = By.id("remove-sauce-labs-bike-light");
	By cartNoOfItems = By.xpath("//a[@class = 'shopping_cart_link']//span");
	By backPackProduct = By.xpath("//div[normalize-space()='Sauce Labs Backpack']");
	By cart = By.id("shopping_cart_container");
	By menuBtn = By.id("react-burger-menu-btn");
	By logOutBtn = By.id("logout_sidebar_link");
	
	public List <WebElement> itemslist(){
		return findElements(itemlist);
	}
	
	public boolean checkAllitemsloaded(int ExpectedNoOfItems) {
	waitForVisibility(backPackProduct, 5);
	List<WebElement> list = itemslist();  //itemlist is hardcoded
		return list.size() ==  ExpectedNoOfItems;
	}
	
	//To Add  items into the cart
	public void addtoCartBackPack() {
		click(addtoCartBackPack);
	}
	
	
	public void addtoCartBikeLight() {
			click(addtoCartBikeLight);
	}
			
			// click remove on inventory page
			public void removeBackPack() {
				click(removeBackPack);
			}
			public void removeBikeLight() {
				click(removeBikeLight);
			}
			
		
	
	//To Remove items from the Cart
	public void removeCartBackPack() {
		click(removeBackPack);
	}
	
	public void removeCartBikeLight() {
		click(removeBikeLight);
	}
	
	
	//To check after adding item to the cart remove button is visible or not
	public boolean removeBackpackIsDisplayed() {
		try {
	 waitForVisibility(removeBackPack, 5);
	 return true;
		}
		catch (Exception e) {
			System.out.println("Remove button not visible");
			return false;
		}
	}
	
	
	public boolean removeBikeLightIsDisplayed() {
			try {
		 waitForVisibility(removeBikeLight, 5);
		 return true;
			}
			catch (Exception e) {
				System.out.println("Remove button not visible");
				return false;
			}
	 
	}
	
		
	
	
	//To get How much items visible added into the cart
	
	public int cartNoOfItems() {
		String items=getText(cartNoOfItems);
		int itemcount = Integer.parseInt(items);
		return itemcount;
		
	}
	
	//to Open product details of BackPack product
	public void openBackPackProductDetails() {
		click(backPackProduct);
	}
	
	//to open cart
	public void openCart() {
		click(cart);
	}
	
	
	//clean up cart
	public void clearCart() {
		removeBackPack();
		removeBikeLight();
	}
	
	
	//open menu btn
	public void logOutApp() {
		click(menuBtn);
		try {
		waitForVisibility((logOutBtn), 5);
		click(logOutBtn);
		}
		catch(Exception e) {
			System.out.println("Logout button not visible");
		}
	}
	
	
//	//get current URL
//	public String getCurrentURL() {
//		return driver.getCurrentUrl();
//	}
	
	

}
