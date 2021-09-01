package selectClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class AlertHandling {
	public void UserSucessfullyAdd() throws Exception{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Offline%20Website/Offline%20Website/pages/examples/add_user.html?gender=Female");
		/*driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/a/span")).click();
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/div/div/div/div[1]/a/button")).click();
	    driver.findElement(By.id("username")).sendKeys("Manashri");
	    driver.findElement(By.id("mobile")).sendKeys("8483860062");
	    driver.findElement(By.id("email")).sendKeys("manashribhojane167@gmail.com");
	    driver.findElement(By.id("course")).sendKeys("Java");
	    driver.findElement(By.id("Female")).click();
	    */
		
		
		
	    Select state = new Select(driver.findElement(By.xpath("//select")));
	    state.selectByVisibleText("Maharashtra"); 
		Thread.sleep(3000);
		state.selectByValue("HP");
	    driver.findElement(By.id("password")).sendKeys("12345655");
	    driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		 Alert alert =  driver.switchTo().alert();  
      String actual =  driver.switchTo().alert().getText();
      String expected = "User Added Successfully. You can not see added user.";
      Thread.sleep(2000);
      driver.switchTo().alert().accept();
		Assert.assertEquals(actual, expected);

}}
