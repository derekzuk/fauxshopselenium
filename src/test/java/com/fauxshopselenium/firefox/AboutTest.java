package com.fauxshopselenium.firefox;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutTest {	
	private static FirefoxDriver driver;
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 40);
	
	@BeforeClass
	public static void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}
	
	@Test
	public void aboutScreenshot(){		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		// Solution taken from the following stackoverflow reply:
		// http://stackoverflow.com/questions/3422262/take-a-screenshot-with-selenium-webdriver
		driver.get("localhost:8080/fauxshop/about");
		try {			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\about_firefox.png"));		
		} catch (Exception e) {
		}				
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}		
		
	@Test
	public void aboutTest(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("localhost:8080/fauxshop/about");
		try {
			element = driver.findElement(By.id("pageContent"));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));			
		} catch (Exception e) {
		}		
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='pageContent']/div/div/div/h2")).getText().contains("About Us"));
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@AfterClass
	public static void closeBrowser(){
		driver.quit();
	}	
}