package challenges;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Grid2 {

	public static String sUrl;
	public static String sHubUrl;
	public static String sHubPort;
	public static Properties prop;
	public static String browser;


//Hub= java -jar D:\Software\seleniumServer.jar -role hub

//node= java -Dwebdriver.chrome.driver="D:\Software\chrome\chromedriver.exe" -jar seleniumServer.jar -role node -hub http://192.168.29.124:4444/grid/register
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
		sHubUrl = prop.getProperty("HUB");
		sHubPort = prop.getProperty("PORT");
		sUrl = prop.getProperty("URL");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName(browser);
		dc.setPlatform(Platform.WINDOWS);
		// this is for grid run
		WebDriverManager.chromedriver().setup();
		driver = (ChromeDriver) new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(sUrl);
	     System.out.println(driver.getTitle());
			
	}

}
