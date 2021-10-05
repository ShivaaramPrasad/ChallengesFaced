package accessProperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Property {
	public static WebDriver driver;
	public static Properties prop = new Properties();

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

	}
	
	public void setDataInPropertyFile(String value) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream("./src/main/resources/data.properties");
		prop.setProperty("Token", value);
		
		try {
			prop.store(fos, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getDataInPropertyFile() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("./src/main/resources/data.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (prop.getProperty("Token"));
	}

	
	public Property captureTokenNum() throws InterruptedException, IOException {

		Thread.sleep(5000);
		String bReturn = driver.findElement(By.xpath("//*[text()='Token No.']//following-sibling::")).getText();
		setDataInPropertyFile(bReturn);
		return this;
	}
	
	  public Property typeTokenNumber() throws InterruptedException, IOException {
			Thread.sleep(10000);
			String tokenNumber = getDataInPropertyFile();
			driver.findElement(By.xpath("//span[text()='Tasks']/following::input")).sendKeys(tokenNumber);;

			return this;
		}
	
}
