package alternateFunction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fileupload {
	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

	WebDriverManager.chromedriver().setup();

	ChromeDriver driver = new ChromeDriver();
	
	
	WebElement upload_file = driver.findElement(By.xpath("//input[@id='file_up']"));

	upload_file.sendKeys("C:/Users/Sonali/Desktop/upload.png");
	
	
	
	
	
	//Using robot class 
    //open upload window

	upload_file.click();
	
    //put path to your image in a clipboard

	StringSelection path = new StringSelection(System.getProperty("user.dir")+"\\imgdata\\MyQRCode");
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
     

	// Paste it using Robot class
	Robot robot = new Robot();
	
    //imitate mouse events like ENTER, CTRL+C, CTRL+V

	// Enter to confirm it is uploaded
	robot.keyPress(KeyEvent.VK_CONTROL);
	robot.keyPress(KeyEvent.VK_V);

	robot.keyRelease(KeyEvent.VK_V);
	robot.keyRelease(KeyEvent.VK_CONTROL);

	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	


	/*
	         robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);

	 */
	
	
/////java
    
    driver.findElement(By.id("uploadbutton")).click(); // open the Upload window using selenium    
	Thread.sleep(5000); // wait for page load     
    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Documents and Settings\\new.exe"); // Give  path where the exe is saved.

	}
}
