package alternateFunction;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class type {
	

	public static void main(String[] args) throws AWTException {

	
	WebDriverManager.chromedriver().setup();

	ChromeDriver driver = new ChromeDriver();
	
	//Javascript type
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	WebElement email = driver.findElement(By.name("username"));
	js.executeScript("arguments[0].value='thriveoptim@gmail.com'", email);	
	
	// sendkeys
	
	driver.findElement(By.id("username")).sendKeys("admin");
	
	// Action Class 
	
	Actions performAct = new Actions(driver); 
	performAct.sendKeys(email, "thriveoptim@gmail.com").build().perform(); 
	
	// Robot class 
    Robot robot = new Robot(); 
    
	robot.keyPress(KeyEvent.VK_O); 
    robot.keyRelease(KeyEvent.VK_O); 
 
 
    robot.keyPress(KeyEvent.VK_P); 
    robot.keyRelease(KeyEvent.VK_P); 
 
    robot.keyPress(KeyEvent.VK_T); 
    robot.keyRelease(KeyEvent.VK_T); 
 
    robot.keyPress(KeyEvent.VK_I); 
    robot.keyRelease(KeyEvent.VK_I); 
 
    robot.keyPress(KeyEvent.VK_M); 
    robot.keyRelease(KeyEvent.VK_M); 

}
}