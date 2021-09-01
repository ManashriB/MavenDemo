package makeMyTrip;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Demo {
	WebDriver driver;
	@Test
	public void demo(){
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		 driver = new ChromeDriver();
		// driver.manage().window().maximize();
		 driver.get("https://www.makemytrip.com/flights/");	
		
		 driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		 WebDriverWait wait = new WebDriverWait(driver,200);
		 wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"))));
		 
		 
		 ArrayList<String> list = new ArrayList<String>();
		List<WebElement> element = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		 for(WebElement g1 :element){
			 String text = g1.getText();
			 list.add(text);
			 System.out.println(text);
		 }
		
		
	}
	
}
