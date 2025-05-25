package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.apache.poi.ss.usermodel.Cell;
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
	
	public void pullIntoExcel(String path, int rowIndex, int column, String input) throws IOException {
		FileInputStream file = new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }

        Cell cell = row.getCell(column);
        if (cell == null) {
            cell = row.createCell(column);
        }
        
        cell.setCellValue(input);
        file.close();
        
        FileOutputStream outFile = new FileOutputStream(new File(path));
        workbook.write(outFile);
        outFile.close();
        workbook.close();

        System.out.println("updated successfully!");

	}
	
	public void updateStatusIntoExcel(int result, int rowNo) throws IOException {
		if (result == 1) {
			pullIntoExcel("C:\\Users\\HP\\eclipse-workspace\\testng\\ecommerce\\src\\test\\resources\\TestCases.xlsx", rowNo, 9, "Passed");
		}	
		
		if (result == 2) {
			pullIntoExcel("C:\\Users\\HP\\eclipse-workspace\\testng\\ecommerce\\src\\test\\resources\\TestCases.xlsx", rowNo,9,  "Failed");
		}	
	}
	
	public void updateCommentIntoExcel(String message, int rowNo) throws IOException {
		pullIntoExcel("C:\\Users\\HP\\eclipse-workspace\\testng\\ecommerce\\src\\test\\resources\\TestCases.xlsx", rowNo, 11, message);
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
