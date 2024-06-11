package demowebshop_GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import demowebshop_GenericUtility.JavaUtilityDemoshop;
import demowebshop_GenericUtility.PropertyUtilityDemoshop;
import demowebshop_GenericUtility.WebUtilityDemoshop;
import tricentis_ElementRepository.HomePage;
import tricentis_ElementRepository.LoginPage;

public class BaseClass_Demoshop {

	WebUtilityDemoshop webutil=new WebUtilityDemoshop();
	PropertyUtilityDemoshop putil=new PropertyUtilityDemoshop();
	JavaUtilityDemoshop jutil=new JavaUtilityDemoshop();

	
	public WebDriver driver=null;
	public static WebDriver sdriver;//Listeners
	
	@BeforeSuite
	public void beforeSuiteConfig() {
		System.out.println("database connection established");
	}
	//@Parameters("browsername")
	//@BeforeTest
	@BeforeClass
	public void beforeClassConfig() throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver(); 
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
	
		sdriver=driver;
		webutil.toMaximize(driver);
		System.out.println("browser got maximized");
		webutil.toWaitElement(driver);
		System.out.println("elements loaded");
		
		driver.get(URL);
	}
	
	@BeforeMethod
	public void beforeMethodConfig() throws IOException {
	    String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");
	    LoginPage lp= new LoginPage(driver);
	    lp.getUserTextfield().sendKeys(USERNAME);
	    lp.getPasswordTextfield().sendKeys(PASSWORD);
	    lp.getLoginButton().click();
	    System.out.println("successfully logged in");
	}
	
	@AfterMethod
	public void afterMethodConfig() {
		HomePage hp=new HomePage(driver);
		hp.getLogoutLink();
		System.out.println("successfully logged out");
	}
	//@AfterTest
	@AfterClass
	public void afterClassConfig() {
		webutil.toCloseBrowser(driver);
		System.out.println("Browser got closed");
	}
	
	@AfterSuite
	
	public void afterSuiteConfig() {
		System.out.println("Disconnect database");
	}
}
