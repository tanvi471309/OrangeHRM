package com.orangehrm.driverscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.utilities.ExcelReader;


public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static ExcelReader excel = new ExcelReader(".\\TestData\\RegisterDemoTestData.xlsx");
	public static WebDriverWait wait;	
	public static Properties config = new Properties();

	@BeforeSuite
	public WebDriver setUp() throws IOException{

		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\orangehrm\\driverscript\\configuration.properties");
			config.load(fis);
			Reporter.log("Configuration File Loaded Successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if(config.getProperty("browser").equalsIgnoreCase("firefox"))			
		{
			System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}			
		else if(config.getProperty("browser").equalsIgnoreCase("chrome"))	
		{
			System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");	
			driver = new ChromeDriver();
		}
		else if(config.getProperty("browser").equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",".\\Drivers\\msedgedriver.exe");	
			driver = new EdgeDriver();
		}

		// implicit wait statement
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicitWait")), TimeUnit.SECONDS);
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		return driver;				
	}

	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
			Reporter.log("Application Closed Successfully");
		}

	}
}
