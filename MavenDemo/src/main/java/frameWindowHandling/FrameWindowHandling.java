package frameWindowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameWindowHandling {

@Test	
public void test01() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.get("https://www.redbus.in/");
	
	
	 driver.findElement(By.id("i-icon-profile")).click();
	 driver.findElement(By.id("signInLink")).click();
	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='modalIframe']")));
	 driver.findElement(By.id("mobileNoInp")).sendKeys("8483860062");
     
	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		Thread.sleep(5000);
		driver.findElement(By.id("recaptcha-anchor")).click();
	 
		//driver.findElement(By.xpath("//span[@class='f-w-b']")).click();
	 
	
      
      
      
 }
	        
}
	
	
	

