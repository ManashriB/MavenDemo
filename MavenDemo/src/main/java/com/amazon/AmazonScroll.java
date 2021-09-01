package com.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AmazonScroll {

	WebDriver driver;
	@Test
public void javaScript() throws InterruptedException{

	System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.amazon.in/?ie=UTF8&ext_vrnc=hi&tag=googhydrabk-21&ascsubtag=_k_CjwKCAjwr56IBhAvEiwA1fuqGg7QWuQcNVS6m70t0_zq7T2x4a6pgBiAew9zf9buxT8S0hUj-8bLUxoCGbQQAvD_BwE_k_&ext_vrnc=hi&gclid=CjwKCAjwr56IBhAvEiwA1fuqGg7QWuQcNVS6m70t0_zq7T2x4a6pgBiAew9zf9buxT8S0hUj-8bLUxoCGbQQAvD_BwE");
	
	 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	 
	
	Thread.sleep(2000);
 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']")));
 Thread.sleep(2000);
 //driver.findElement(By.xpath("//div[@class='nav-logo-base nav-sprite']")).click();		
 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("nav-cart-count")));
driver.findElement(By.id("nav-cart-count")).click();
}}
