package pages;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	static WebDriver driver;
	
	public void SetDriver(WebDriver driver) {
		PageBase.driver = driver;
	}
	
	protected void waitForVisibility(By locator, int timeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	protected WebElement find(By locator ) {
		return driver.findElement(locator );
	}
	
	protected List<WebElement> findElements(By locator) {
		return  driver.findElements(locator);
	}
	
	protected void click(By locator) {
		find(locator).click();
	}
	
	protected String getText(By locator) {
		
	return find(locator).getText();
	}
	
	public void openInventoryPage() {
		driver.get("https://www.saucedemo.com/inventory.html");
	}
	
	public void openCartPage() {
		driver.get("https://www.saucedemo.com/cart.html");
	}
}
