package challenges;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CORS_AddExtention {
    @Test()
	public void login() {
    	// Cross-origin resource sharing (CORS)
		// Add Extension
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./data/extension_0_4_7_0.crx"));
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();	
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Interacting with ChromeExtension

		String URL = "chrome-extension://digfbfaphojjndkpccljibejjbppifbc/popup.html";
		driver.get(URL);
		driver.findElementByTagName("input").click();
		
		//Login to the application
		
		driver.navigate().to("https://www.google.com/");
		driver.findElementByXPath("//input[@title='Search']").sendKeys("Zoho",Keys.ENTER);
		
	}

}