package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {

	static WebDriver driver;
	WebElement element;
	@Test
public void javaScript(){

	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("http://javabykiran.com/playground/");
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	 
	 element=driver.findElement(By.xpath("//a[@href='tables']"));
	 scrollUpToVisibility( element);
	 //js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@href='tables']")));
	 
	  driver.findElement(By.xpath("//a[@href='tables']")).click();	
	 
	  WebElement footer = driver.findElement(By.xpath("//a[@class='text-light']"));
	
	//js.executeScript("arguments[0].scrollIntoView(true);",footer);
	
	
}
	
	public static void scrollUpToVisibility(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		
	}
	
	
}
