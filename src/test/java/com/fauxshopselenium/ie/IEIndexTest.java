package com.fauxshopselenium.ie;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEIndexTest {	
	private static InternetExplorerDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void openBrowser(){
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}	
	
	@Test
	public void navigateToIndex(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("http://localhost:8080/fauxshop/");
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
		driver.get("http://localhost:8080/fauxshop/");
		try {
			element = driver.findElement(By.xpath(".//*[@id='bestSeller0']/a/img"));
		} catch (Exception e) {
		}
		Assert.assertEquals("img", element.getTagName());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void inspectBestSellerTxt(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("http://localhost:8080/fauxshop/");
		try {
			element = driver.findElement(By.xpath(".//*[@id='bestSeller0']/div/h5"));
		} catch (Exception e) {
		}
		Assert.assertNotNull(element.getText());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void loginClick(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("http://localhost:8080/fauxshop/");
		driver.findElement(By.xpath(".//*[@id='your-account']/div[1]/p/a")).sendKeys(Keys.ENTER);
		try {
			element = driver.findElement(By.id("createAnAccount"));
		} catch (Exception e) {
		}
		Assert.assertEquals("Create An Account", element.getText());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@Test
	public void bestSellerImgClick(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("http://localhost:8080/fauxshop/");
		driver.findElement(By.xpath(".//*[@id='bestSeller0']/a/img")).click();
		try {
			element = driver.findElement(By.id("productRow"));
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