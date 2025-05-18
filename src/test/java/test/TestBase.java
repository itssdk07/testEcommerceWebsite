package test;
import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.PageBase;




public class TestBase {
	
	public WebDriver driver;
	protected PageBase pagebase;
	private final String URL = "https://www.saucedemo.com/";
	protected boolean requireLogin = false;
	protected SoftAssert softassert = new SoftAssert();
	
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void reload() {
		driver.navigate().refresh();
		
	}
	
		
	@BeforeClass
	
	public void setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	
	public void quit() {
		
		driver.quit();}
	
	
	@BeforeMethod
	
	public void loadapp() {
		
		driver.get(URL);
		pagebase = new PageBase();
		pagebase.SetDriver(driver);
		
		if(requireLogin) {
			LoginPage login = new LoginPage();
			login.standardLogin();
			}
		}
		
	
	@AfterMethod
	
	public void takescreenshotForFailures(ITestResult testResult) {
		if(ITestResult.FAILURE == testResult.getStatus()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir") + ("./test/resources")+ 
					testResult.getName()+ ".png");	
			try {
			FileHandler.copy(source, destination);
				
			}
			catch(IOException exception) {
				exception.printStackTrace();
				
			}
			
		}
	}
	
}
