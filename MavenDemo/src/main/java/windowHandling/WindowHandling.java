package windowHandling;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandling {

	WebDriver driver;
	
	@Test
	public void windowHandling(){
	     System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
		 driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
		 driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("123456");
         driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		
         List<WebElement> links = driver.findElements(By.partialLinkText("info"));
	     String mainwindow  =  driver.getWindowHandle();
		
	     for(WebElement link:links)
	     link.click();
	     Set<String> windows = driver.getWindowHandles();
		 for(String win : windows){
		 System.out.println(win);
		 if(!win.equalsIgnoreCase(mainwindow)){
		 driver.switchTo().window(win); 
         System.out.println(driver.getCurrentUrl().contains("python"));
         driver.close();
         
		     }
	       } 
	     }   
       }
	
	
	
	   
		    	  
		
		
	

