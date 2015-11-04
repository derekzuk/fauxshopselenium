package com.fauxshopselenium;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndexTest {	
	private static FirefoxDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}	
	
	@Test
	public void navigateToIndex(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("localhost:8080/fauxshop/");
		driver.findElement(By.xpath(".//*[@id='your-account']/div[1]/p/a"));
		try {
			element = driver.findElement(By.xpath(".//*[@id='your-account']/div[1]/p/a"));
		} catch (Exception e) {
		}
		Assert.assertEquals("Log in", element.getText());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void inspectBestSellerImage(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("localhost:8080/fauxshop/");
		driver.findElement(By.xpath("html/body/div[1]/div[5]/div[1]/div/a/img"));
		try {
			element = driver.findElement(By.xpath("html/body/div[1]/div[5]/div[1]/div/a/img"));
		} catch (Exception e) {
		}
		Assert.assertEquals("img", element.getTagName());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void inspectBestSellerTxt(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("localhost:8080/fauxshop/");
		driver.findElement(By.xpath("html/body/div[1]/div[5]/div[1]/div/div/h5"));
		try {
			element = driver.findElement(By.xpath("html/body/div[1]/div[5]/div[1]/div/div/h5"));
		} catch (Exception e) {
		}
		Assert.assertNotNull(element.getText());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void loginClick(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("localhost:8080/fauxshop/");
		driver.findElement(By.xpath(".//*[@id='your-account']/div[1]/p/a")).click();
		try {
			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/h3"));
		} catch (Exception e) {
		}
		Assert.assertEquals("Create An Account", element.getText());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void bestSellerImgClick(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("localhost:8080/fauxshop/");
		driver.findElement(By.xpath("html/body/div[1]/div[5]/div[1]/div/a/img")).click();
		try {
			element = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[2]/div/div[1]/h2/span[1]"));
		} catch (Exception e) {
		}
		Assert.assertNotNull(element.getText());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@AfterClass
	public static void closeBrowser(){
		driver.quit();
	}	
}