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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IELoginTest {	
	private static InternetExplorerDriver driver;
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 40);
	
	@BeforeClass
	public static void openBrowser(){
		driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}	
		
	@Test
	public void loginTest(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("http://localhost:8080/fauxshop/login");
		try {
			driver.findElement(By.name("user_login")).sendKeys("zuk");
			driver.findElement(By.name("password")).sendKeys("pass");
			driver.findElement(By.id("logInSubmit")).submit();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("home-slider")));
			element = driver.findElement(By.xpath(".//*[@id='your-account']/div[1]/p"));
		} catch (Exception e) {
		}		
		Assert.assertEquals("Welcome, zuk", element.getText());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}	
	
	@Test
	public void newRegistrationTest(){
		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("http://localhost:8080/fauxshop/login");
		try {
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys("test@test.com");
			driver.findElement(By.id("submitRegistration")).submit();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("firstName"))));
			element = driver.findElement(By.id("personalInformation"));
		} catch (Exception e) {
		}		
		Assert.assertEquals("Personal Information", element.getText());
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}		
	
	@AfterClass
	public static void closeBrowser(){
		driver.quit();
	}	
}