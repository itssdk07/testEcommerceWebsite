package pages;

import org.openqa.selenium.By;

public class LoginPage extends PageBase {
		
	By username = By.id("user-name");
	By password = By.id("password");
	By loginbtn = By.id("login-button");
	By errormessage = By.xpath("//div[@class = 'error-message-container error']//h3");
	
	
	
	
	public void enterusername(String user) {
		find(username).sendKeys(user);
	}
	
	public void enterpassword(String pwd) {
		find(password).sendKeys(pwd);
	}
	
	public void clickLogin() {
		click(loginbtn);
	}
	
	public void login(String user, String pwd) {
		enterusername(user);
		enterpassword(pwd);
		clickLogin();
		
	}
	
	public void standardLogin() {
		
		login("standard_user","secret_sauce");
	}
	
	public String geterrormsg() {
	waitForVisibility(errormessage, 5);
	return	getText(errormessage);
	}
	
	
	
//	 public String getCurrentURL() {
//		 return driver.getCurrentUrl();
 //  } ---------Added in TestBase class directly---------------
//	
}
