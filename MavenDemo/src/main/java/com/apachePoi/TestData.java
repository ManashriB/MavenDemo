package com.apachePoi;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class TestData {

	WebDriver driver;
public void readExcel() throws Exception{
		DataFormatter df = new DataFormatter(); 
FileInputStream fis = new FileInputStream ("TestData1.xlsx");
Workbook wb = WorkbookFactory.create(fis);

	Sheet sh = wb.getSheet("Sheet1");
	int rows = sh.getLastRowNum();//6
	for(int i = 0;i<=rows;i++){
		int cols = sh.getRow(i).getLastCellNum();//row=0..cols-3/row-1..cols-4
		for(int j = 0;j<cols;j++){
		Cell c= sh.getRow(i).getCell(j);
		String value =df.formatCellValue(c);
		System.out.println(value);
		
	    }
		System.out.println();
       } 
	 }

public String readCell(int row,int col) throws Exception{
	
	DataFormatter df = new DataFormatter(); 
    FileInputStream fis = new FileInputStream ("TestData1.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh = wb.getSheet("Sheet1");
	Cell c = sh.getRow(row).getCell(col);
	return df.formatCellValue(c);
}
 public void writeCell(int row,int col,String text) throws Exception{
	  
	    FileInputStream fis = new FileInputStream ("TestData1.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Sheet1");
	  sh.getRow(row).createCell(col).setCellValue(text);
	  FileOutputStream fos = new FileOutputStream("TestData1.xlsx");
	  wb.write(fos);
	  wb.close();
 }
 

     @Test
   public void test01() throws Exception{
    	 System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 for(int i=1;i<=5;i++){
		 driver.get("file:///D:/Offline%20Website/Offline%20Website/index.html");
		 driver.findElement(By.id("email")).sendKeys(readCell(i, 0));
		 driver.findElement(By.id("password")).sendKeys(readCell(i, 1));
		 driver.findElement(By.xpath("//*[@id=\"form\"]/div[3]/div/button")).click();
		 if(driver.getTitle().equals("JavaByKiran | Dashboard")){
			 writeCell(i, 2, "PASS");
			 driver.findElement(By.linkText("LOGOUT")).click();
			  }
		      else{
		    	  
		          writeCell(i, 2, "FAIL");
		          driver.navigate().refresh();
		 
             }
		   }
         }
}
