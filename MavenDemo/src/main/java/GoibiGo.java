import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoibiGo {

	@Test
public void demo() throws Exception{
	
	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!ETA!108599293!6504095653!491718594877!e!goibibo!c!&ef_id=Cj0KCQjw6s2IBhCnARIsAP8RfAhDjyTHlK5N-lGxKLIvHqYIlBCsPICZrRmjEfASG88RFs1lYFNOPbUaApuREALw_wcB:G:s&gclid=Cj0KCQjw6s2IBhCnARIsAP8RfAhDjyTHlK5N-lGxKLIvHqYIlBCsPICZrRmjEfASG88RFs1lYFNOPbUaApuREALw_wcB");
	
	
	 WebDriverWait wait = new WebDriverWait(driver,90);
	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='October 2021']"))));
	
	WebElement from = driver.findElement(By.id("gosuggest_inputSrc"));
	Thread.sleep(5000);
	from.sendKeys("Mumbai");
	Thread.sleep(2000);
    from.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	from.sendKeys(Keys.ENTER);
	
	
	Thread.sleep(2000);
	WebElement from1 = driver.findElement(By.id("gosuggest_inputDest"));
	Thread.sleep(2000);
	from1.sendKeys("Delhi");
	Thread.sleep(2000);
	from1.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
    from1.sendKeys(Keys.ENTER);
    
   // driver.findElement(By.id("departureCalendar")).click();
    
    Thread.sleep(5000);
    
    while(!driver.findElement(By.xpath("//div[text()='October 2021']")).getText().contains("October"))
    {
    	
    	  driver.findElement(By.id("departureCalendar")).click();
    }
    
    List<WebElement> al = driver.findElements(By.className("calDate"));
    for(int i=0;i<al.size();i++){
	  
	  String value =al.get(i).getText();
	  if(value.equalsIgnoreCase("16")) {
		  
		  al.get(i).click();
		  break;
		  
	  }
   }
}
	
}	
	
	
	
	
	

	
	
	
	
	

