package challenges;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Grid {




//Hub= java -jar D:\Software\seleniumServer.jar -role hub

//node= java -Dwebdriver.chrome.driver="D:\Software\chrome\chromedriver.exe" -jar seleniumServer.jar -role node -hub http://192.168.29.124:4444/grid/register

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WIN10);

		ChromeOptions options = new ChromeOptions();
		options.merge(dc);
		//WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.29.124:4444/wd/hub"), options);

		driver.get("https://www.google.com/");
	     System.out.println(driver.getTitle());
			
	}

}
