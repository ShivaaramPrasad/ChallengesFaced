package challenges;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication {

	public static void main(String[] args) throws MalformedURLException {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("./data/MultiPass-for-HTTP-basic-authentication.crx"));
		new DesiredCapabilities();
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN10);
		options.merge(dc);

		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.30:5566/wd/hub"), options);

		String URL = "chrome-extension://enhldmjbphoeibbpdhmjkchohnidgnah/options.html";
		driver.get(URL);

		driver.findElement(By.id("url")).sendKeys(".*.the-internet.herokuapp.com/basic_auth");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();

		driver.get("http://the-internet.herokuapp.com/basic_auth");

	}

}
