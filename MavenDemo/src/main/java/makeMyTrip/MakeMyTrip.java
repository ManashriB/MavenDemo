package makeMyTrip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MakeMyTrip {
	WebDriver driver;
	
	@Test/*(expectedExceptions = {SocketTimeoutException.class,ElementClickInterceptedException.class})*/
	public void test01() throws Exception {
		
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	 driver = new ChromeDriver();
	// driver.manage().window().maximize();
	 driver.get("https://www.makemytrip.com/flights/");	
	
	 driver.manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	 
	 WebDriverWait wait = new WebDriverWait(driver,90);
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='From']"))));
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='From']"))));
	 
	 
	 Wait w = new FluentWait(driver)
			 .withTimeout(30,TimeUnit.SECONDS)
			 .ignoring(NoSuchElementException.class)
			 .pollingEvery(3,TimeUnit.SECONDS);
			 w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='From']"))));
			 
	// driver.findElement(By.xpath("//li[@data-cy='menu_Flights']")).click();
	 driver.findElement(By.xpath("//span[text()='From']")).click();
	 WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
	 Thread.sleep(5000);
	 from.sendKeys("Mumbai");
	 Thread.sleep(2000);
	 from.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	from.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	WebElement from1 = driver.findElement(By.xpath("//input[@placeholder='To']"));
	Thread.sleep(2000);
	from1.sendKeys("Delhi");
	Thread.sleep(2000);
	from1.sendKeys(Keys.ARROW_DOWN);
    from1.sendKeys(Keys.ENTER);
     
  
    
    driver.findElement(By.xpath("//span[contains(text(),'DEPARTURE')]")).click();
    //Thread.sleep(2000);
    //driver.findElement(By.xpath("//div[@aria-label='Wed Aug 11 2021']")).click();
    Thread.sleep(2000);
    String flag = "False";
    while(flag=="False"){
    if(driver.findElements(By.xpath("//div[@aria-label='Thu Dec 16 2021']")).size() > 0) {
    	
    	driver.findElement(By.xpath("//div[@aria-label='Thu Dec 16 2021']")).click();
    	
    	flag="true";
    	
    }
    else {
    	Thread.sleep(5000);
    	driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
    }
    
    
}
    System.out.println("test case is pass");
driver.close();		


	}

	
	}
	



