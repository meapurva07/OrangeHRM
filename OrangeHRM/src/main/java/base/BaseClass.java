package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import functions.Function;
import utility.ExtentManager;
//import utility.ExtentManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	//public Properties dataProp;
	
	@BeforeSuite
	public void BeforeSuite() {
		ExtentManager.setExtent();
		
	}

	@BeforeTest
	public void loadConfig() {
		
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream
					(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(fis);
			
			System.out.println(prop.getProperty("browser"));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
}
	
	//@BeforeClass
	public static void launchApp() {
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			driver =new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Function.implicitWait(driver, 10);
		Function.pageLoadTimeOut(driver, 30);
		driver.get(prop.getProperty("url"));
		
		
	}


	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
}
