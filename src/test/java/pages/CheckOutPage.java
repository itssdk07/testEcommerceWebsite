package pages;

import org.openqa.selenium.By;

public class CheckOutPage extends PageBase {
	
	CartPage cart = new CartPage();
	
	By firstName = By.id("first-name");
	By lastName = By.id("last-name");
	By postalCode = By.id("postal-code");
	By proceed = By.id("continue");
	By cancelbtn = By.id("cancel");
	By placeOrder = By.id("finish");
	By completeMessage = By.className("complete-header");
	By errorMessage = By.xpath("//div[@class= \"error-message-container error\"]//h3");
	
	public void completeOrder() {
		find(firstName).sendKeys("First Name");
		find(lastName).sendKeys("Last Name");
		find(postalCode).sendKeys("123456");
		click(proceed);
		click(placeOrder);
	}
	
	public void enterValidData() {
		find(firstName).sendKeys("First Name");
		find(lastName).sendKeys("Last Name");
		find(postalCode).sendKeys("123456");
	}
	
	
	public void placeOrder() {
		click(placeOrder);
	}
	
	public boolean isCompleteMessageDisplayed() {
		try {
			waitForVisibility(By.className("complete-header"), 2);
			return true;
		}
		catch(Exception e) {return false;}
		
	}
	
	public void clickcontinue() {
		click(proceed);
	}
	
	public void clickCancel() {
		click(cancelbtn);
	}	
	
	public void enterFirstName(String Name) {
		find(firstName).sendKeys(Name);
	}
	
	public void enterLastName(String Name) {
		find(lastName).sendKeys(Name);
	}
	
	public void enterPostalCode(String code) {
		find(postalCode).sendKeys(code);
	}
	
	public void openCheckOutPage() {
		cart.additemsAndOpenCart();
		openCheckOut();
	}
	
	public String getErrorMessage() {
		return find(errorMessage).getText();
	}
	
	public void openCheckOut() {
		cart.clickCheckoutbtn();
	}
	
	public void backToCartAndClear() {
		clickCancel();
		cart.clearCart();
	}
	
	public void removeItemsFromCart() {
		cart.clearCart();
	}
	

}
