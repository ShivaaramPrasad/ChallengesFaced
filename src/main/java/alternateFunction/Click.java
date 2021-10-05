package alternateFunction;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Click {


	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		WebElement login = driver.findElement(By.name("username"));
		// 1)  Normal click
		login.click();
		login.submit();

		// 2)  Using the send keys keyboard actions

		login.sendKeys(Keys.ENTER);;

		//3 Javascript click 

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", login);
		
        // 4 Actions Class
		
	    Actions actions = new Actions(driver);  
	    actions.click(login).perform();

	    actions.moveToElement(login).click().perform();

	    actions.clickAndHold(login).release().perform();

	    actions.sendKeys(login, Keys.RETURN).perform();


	}

}
