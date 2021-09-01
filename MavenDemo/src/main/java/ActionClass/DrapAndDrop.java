package ActionClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DrapAndDrop {

	WebDriver driver;
	Action act;
	Actions acts;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");	
		
	}
	
 @Test
public void mouseHover()throws Exception {
System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
driver = new ChromeDriver();
driver.manage().window().maximize();
 driver.get("http://javabykiran.com/playground/");
 //mouse hover on drag and drop menu
 //driver.findElement(By.xpath("//a[@href='drag-and-drop']")).click();
//List<WebElement> list = driver.findElements(By.xpath("//div[@class='dd-handle']"));
 
List<WebElement> list = driver.findElements(By.xpath("//a[@class='nav-link']"));	
Actions action = new Actions(driver);
for(WebElement w1:list){
action.moveToElement(w1).pause(2000).build().perform();
			
		  }
 }
@Test
public void dragAndDrop(){
			
driver.findElement(By.xpath("//a[@href='drag-and-drop']")).click();
 WebElement src = driver.findElement(By.xpath("//li[@data-name='About Us']"));	
  WebElement destn = driver.findElement(By.xpath("//li[@data-name='Contact Us']"));
Actions action = new Actions(driver);
action.dragAndDrop(src,destn).perform();
action.contextClick().perform();
}
@Test
public void login(){
driver.findElement(By.xpath("//a[@href='login']")).click();
WebElement uname = driver.findElement(By.xpath("//input[@placeholder='Email']"));
WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
WebElement butn = driver.findElement(By.xpath("//button[@type='submit']"));
Actions action = new Actions(driver);
action.click(uname).sendKeys("manashribhojane@gmail.com").perform();
action.click(password).sendKeys("123456").perform();
action.click(butn).perform();

driver.navigate().to("file:///D:/Offline%20Website/Offline%20Website/index.html");
driver.navigate().back();


	}
}
		
