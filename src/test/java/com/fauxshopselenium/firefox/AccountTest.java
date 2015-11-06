package com.fauxshopselenium.firefox;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.thoughtworks.selenium.webdriven.commands.Click;

public class AccountTest {	
	private static FirefoxDriver driver;
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 40);

	@BeforeClass
	public static void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}					

	@Test
	public void newAccountFromLoginTest(){		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("localhost:8080/fauxshop/login");
		try {
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys("test@test.com");
			driver.findElement(By.xpath(".//*[@id='submitRegistration']")).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("firstName"))));
			driver.findElement(By.name("userLogin")).sendKeys("userloginselenium1");
			driver.findElement(By.name("firstName")).sendKeys("firstnameselenium");
			driver.findElement(By.name("lastName")).sendKeys("lastnameselenium");
			driver.findElement(By.name("email")).sendKeys("email@email.com");
			driver.findElement(By.name("password")).sendKeys("password");
			driver.findElement(By.name("address")).sendKeys("address");
			driver.findElement(By.name("address2")).sendKeys("address2");
			driver.findElement(By.name("city")).sendKeys("city");
			driver.findElement(By.name("country")).sendKeys("country");
			driver.findElement(By.name("state")).sendKeys("VA");
			driver.findElement(By.name("zip")).sendKeys("12345");
			driver.findElement(By.name("phoneNumber")).sendKeys("1234567890");
			driver.findElement(By.id("login2register")).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("logInSubmit"))));
			driver.findElement(By.name("user_login")).sendKeys("userloginselenium1");
			driver.findElement(By.name("password")).sendKeys("password");
			driver.findElement(By.id("logInSubmit")).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("home-slider")));
			element = driver.findElement(By.xpath(".//*[@id='your-account']/div[1]/p"));
		} catch (Exception e) {
		}		
		Assert.assertEquals("Welcome, userloginselenium1", element.getText());
		
		// Log out so that the next tests can run correctly
		driver.findElement(By.id("logOut")).submit();
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@Test
	public void newAccountFromAccountTest(){		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		driver.get("localhost:8080/fauxshop/account");
		try {
			driver.findElement(By.name("userLogin")).sendKeys("userloginselenium2");
			driver.findElement(By.name("firstName")).sendKeys("firstnameselenium");
			driver.findElement(By.name("lastName")).sendKeys("lastnameselenium");
			driver.findElement(By.name("email")).sendKeys("email@email.com");
			driver.findElement(By.name("password")).sendKeys("password");
			driver.findElement(By.name("address")).sendKeys("address");
			driver.findElement(By.name("address2")).sendKeys("address2");
			driver.findElement(By.name("city")).sendKeys("city");
			driver.findElement(By.name("country")).sendKeys("country");
			driver.findElement(By.name("state")).sendKeys("VA");
			driver.findElement(By.name("zip")).sendKeys("12345");
			driver.findElement(By.name("phoneNumber")).sendKeys("1234567890");
			driver.findElement(By.id("login2register")).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("logInSubmit"))));
			driver.findElement(By.name("user_login")).sendKeys("userloginselenium2");
			driver.findElement(By.name("password")).sendKeys("password");
			driver.findElement(By.id("logInSubmit")).sendKeys(Keys.ENTER);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("home-slider")));
			element = driver.findElement(By.xpath(".//*[@id='your-account']/div[1]/p"));
		} catch (Exception e) {
		}		
		Assert.assertEquals("Welcome, userloginselenium2", element.getText());
		
		// Log out
		driver.findElement(By.id("logOut")).submit();
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}			

	@AfterClass
	public static void closeBrowser(){
		driver.quit();
	}	
}