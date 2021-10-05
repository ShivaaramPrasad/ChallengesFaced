package challenges;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUpdate {
	
	public static WebDriver driver;
	public static int iBrtype=1;//1-Chrome,2-FF,3-IE, Unit Driver
	public static String sURL = "https://www.zoho.com/index1.html";

	public static void main(String[] args) {
		browserInvoke();
		changeBrowserSittings();
		navigateURL();
		getPageInfo();
	}
	
	public static void browserInvoke(){
		switch (iBrtype) {
		case 1:
			System.out.println("User Option is 1, So Invoking Chrome Browser");
			WebDriverManager.chromedriver().browserVersion("86.0.4240.22").setup();
			 driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Option is 2, So Invoking Firefox Browser");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case 3:
			System.out.println("User Option is 3, So Invoking Edge Browser");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.err.println("User Option is wrong, So Invoking default Chrome Browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		}
		
		
		
	}
	
	public static void changeBrowserSittings(){
		if(iBrtype==2){
			driver.manage().deleteAllCookies();
		}else{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		}
	}
	
	public static void navigateURL(){
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	public static void getPageInfo(){
		System.out.println("Page Title is : "+driver.getTitle());
		System.out.println("Page Current URL is : "+driver.getCurrentUrl());
	}
	public static void closeBrowser(){
		driver.close();
	}

}
