package challenges;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation {

	public static void main(String[] args) {
		
	    WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	   // 21.1487° N, 79.1285° E
	   // 13.1339° s, 27.8493° e
	    Map <String, Object>coordinates = new HashMap<String, Object>();
	    		coordinates.put("latitude", 30.3079823);
	    		coordinates.put("longitude", -97.893803);
	    		coordinates.put("accuracy", 10);
	   
		           // driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

	            driver.navigate().to("https://oldnavy.gap.com/stores");

}}
