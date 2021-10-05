package challenges;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PostMan {
	
	
	public RemoteWebDriver driver;

	@Test
	public void launchDesktop() throws InterruptedException {	
	//	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();		
		options.setBinary("C:\\Users\\Admin\\AppData\\Local\\WhatsApp\\app-2.2134.10\\WhatsApp.exe");
		options.addArguments("–no-sandbox");
		options.addArguments("–disable-dev-shm-usage");
		options.setExperimentalOption("useAutomationExtension", false);
		Thread.sleep(2000);
		ChromeDriverService chromeservices = new ChromeDriverService.Builder().build();
		WebDriver driver = new ChromeDriver(chromeservices, options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.modal-header-close-button-wrapper>i>svg")).click();

		/*JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("document.getElementById('close').click()");*/
		//	driver.executeScript("document.getElementsByClassName('modal-header-close-button-wrapper').click()")
	}

	//@Test
	public void sampleDesktop() throws InterruptedException {	
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeDriverService chromeservices = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("C:\\Users\\Admin\\AppData\\Local\\WhatsApp\\app-2.2134.10\\WhatsApp.exe"))
				.usingAnyFreePort()				
				.withVerbose(true).build();
		Thread.sleep(5000);
		driver = new ChromeDriver(chromeservices);
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("document.getElementById('close').click()");
		Thread.sleep(2000);
		System.out.println("Hi");
	}
	//Runtime.getRuntime().exec("C:\\Users\\Gopinath Jayakumar\\AppData\\Local\\Postman\\app-6.3.0\\Postman.exe");

}
