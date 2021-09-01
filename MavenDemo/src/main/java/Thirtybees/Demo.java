package Thirtybees;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {
	WebDriver driver;

	@BeforeMethod
	
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://javabykiran.in/Other/thbees/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public boolean checkSequanceOfinformationCols(){
		
		ArrayList<String> expList = new ArrayList<String>();
	    DataFormatter df = new DataFormatter();
		FileInputStream fis;
		Workbook wb = null;

		try {
			fis = new FileInputStream("Thirtybees.xlsx");
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet("footer");
		int rowNum = sh.getLastRowNum();
		//int colnum=sh.getRow(0).getLastCellNum();
		//System.out.println(rowNum);
		for (int i = 1; i <=rowNum; i++) {
			//Cell cell=sh.getRow(0).getCell(i);
			Row row = sh.getRow(i);
			Cell cell = row.getCell(0);
			String celldata = df.formatCellValue(cell);
			//System.out.println(cell);
		expList.add(celldata);
	        }
		//System.out.println(expList);	
		
		ArrayList<String> actList = new ArrayList<String>();
		List<WebElement> listOfInformationblock = driver.findElements(By.xpath("//*[@id='blockcms-footer']/nav/ul/li"));
		
		for(WebElement list : listOfInformationblock){
			String value = list.getText();
			actList.add(value);
			
		}
		if (expList.equals(actList)) {
			System.out.println("The list data are correct");
			return true;
		} else {
			System.out.println("The list data are mismatch");
			return false;
		}
	}
	
	
	
	
	
		@Test
	public void checkSequanceOfMyAccountCols() {

	/*	ArrayList<String> expList = new ArrayList<String>();
		DataFormatter df = new DataFormatter();
		FileInputStream fis;
		Workbook wb = null;

		try {
			fis = new FileInputStream("Thirtybees.xlsx");
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sh = wb.getSheet("footer");
		int rowNum = sh.getLastRowNum();
		for (int i = 1; i <= rowNum; i++) {
			Row row = sh.getRow(i);
			Cell cell = row.getCell(1);
			String celldata = df.formatCellValue(cell);

			expList.add(celldata);
		}
		 System.out.println(expList);*/

		ArrayList<String> actList = new ArrayList<String>();
		List<WebElement> listOfInformationblock = driver.findElements(By.xpath("//*[@id='blockmyaccountfooter']/ul/li"));

		for (WebElement list : listOfInformationblock) {
			String value = list.getText();
			actList.add(value);
		}
		
		System.out.println(actList);
		/*if (expList.equals(actList)) {
			System.out.println("The list data are correct");
			return true;
		} else {
			System.out.println("The list data are mismatch");
			return false;
		}*/
	}	
		
		
@Test	
public void clickOnElement_newProducts(){
 JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(2000);
	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@title='New products']")));
	driver.findElement(By.xpath("//a[@title='New products']"));
	driver.findElement(By.xpath("//a[@title='New products']")).click();
		 String actTitle =driver.getTitle();
		 System.out.println(actTitle);
	    String expTitle = "New products - BEE";     
}
		

@Test	
public void clickOnElement_topSellers(){
 JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(2000);
	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@title='Top sellers']")));
	driver.findElement(By.xpath("//a[@title='Top sellers']"));
	driver.findElement(By.xpath("//a[@title='Top sellers']")).click();
		 String actTitle =driver.getTitle();
		 System.out.println(actTitle);
	    String expTitle = "Top sellers - BEE";     
}

@Test	
public void clickOnElement_ourStore(){
 JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(2000);
	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@title='Our stores']")));
	driver.findElement(By.xpath("//a[@title='Our stores']"));
	driver.findElement(By.xpath("//a[@title='Our stores']")).click();
		 String actTitle =driver.getTitle();
		 System.out.println(actTitle);
	    String expTitle = "Our stores - BEE";     
		
}


@Test	
public void clickOnElement_Sitemap(){
 JavascriptExecutor js = (JavascriptExecutor)driver;
	//Thread.sleep(2000);
	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@title='Sitemap']")));
	driver.findElement(By.xpath("//a[@title='Sitemap']"));
	driver.findElement(By.xpath("//a[@title='Sitemap']")).click();
		 String actTitle =driver.getTitle();
		 System.out.println(actTitle);
	    String expTitle = "Sitemap - BEE";     


}

@Test
public void demo() throws Exception{

	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 Thread.sleep(2000);
	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@title='Facebook']")));	
    driver.findElement(By.xpath("//a[@title='Facebook']")).click();
         String mainwindow  =  driver.getWindowHandle();
      Set<String> set =driver.getWindowHandles();
		 // Using Iterator to iterate with in windows
		 Iterator<String> itr= set.iterator();
		 while(itr.hasNext()){
		  String childWindow=itr.next();
		    // Compare whether the main windows is not equal to child window. If not equal, we will switch.
		 if(!mainwindow.equals(childWindow)){
			
		 driver.switchTo().window(childWindow);
		 Thread.sleep(2000);
             driver.findElement(By.id("email")).sendKeys("manu@gmail.com");
             driver.findElement(By.id("pass")).sendKeys("123456");
             driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
             
             Thread.sleep(2000);
             driver.switchTo().window(mainwindow);
             
}

		 }
}	 
	@Test	 
     public boolean alreadyRegister_newsletter(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("newsletter-input")));	
		
	driver.findElement(By.id("newsletter-input")).sendKeys("bhagyashri@gmail.com");
	
	driver.findElement(By.xpath("//button[@aria-label='Sign up']")).click();
	
	 WebElement value  = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
	 String actText =value.getText();
         System.out.println(actText);
         String expText = "This email address is already registered.";
            return true;
         
	}	
	
	
public boolean newRegistration_newsletter(){
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("newsletter-input")));	
		driver.findElement(By.id("newsletter-input"));
	driver.findElement(By.id("newsletter-input")).sendKeys("guru99@gmail.com");
	
	driver.findElement(By.xpath("//button[@aria-label='Sign up']")).click();
	
	 WebElement value  = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
	 String actText =value.getText();
         System.out.println(actText);
         String expText = "You have successfully subscribed to this newsletter.";
            return true;	
	
	
	
	
	
	
	
	
	}
	//*[@id="blocknewsletter"]/form/div/div/span
	//submitNewsletter
		 //alert alert-success
}





