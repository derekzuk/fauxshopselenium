package com.fauxshopselenium.firefox;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenshotTest {	
	private static FirefoxDriver driver;
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 40);
	
	@BeforeClass
	public static void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
	}
	
	@Test
	public void retrieveScreenshots(){		
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());		
		try {			
			driver.get("localhost:8080/fauxshop/about");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
			FileUtils.copyFile(scrFile, new File("c:\\tmp\\about_firefox.png"));			
			driver.get("localhost:8080/fauxshop/account");
			File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
			FileUtils.copyFile(scrFile2, new File("c:\\tmp\\account_firefox.png"));			
			driver.get("localhost:8080/fauxshop/cart");
			File scrFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);			
			FileUtils.copyFile(scrFile3, new File("c:\\tmp\\cart_firefox.png"));
			driver.get("localhost:8080/fauxshop/categories/101");
			File scrFile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);						
			FileUtils.copyFile(scrFile4, new File("c:\\tmp\\categories_firefox.png"));
			driver.get("localhost:8080/fauxshop/contact");
			File scrFile5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);						
			FileUtils.copyFile(scrFile5, new File("c:\\tmp\\contact_firefox.png"));
			driver.get("localhost:8080/fauxshop/index");
			File scrFile6 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);						
			FileUtils.copyFile(scrFile6, new File("c:\\tmp\\index_firefox.png"));
			driver.get("localhost:8080/fauxshop/login");
			File scrFile7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);						
			FileUtils.copyFile(scrFile7, new File("c:\\tmp\\login_firefox.png"));
			driver.get("localhost:8080/fauxshop/product_detail/-114?color=Red");
			File scrFile8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);						
			FileUtils.copyFile(scrFile8, new File("c:\\tmp\\product_detail_firefox.png"));			
		} catch (Exception e) {
		}				
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}
	
	@AfterClass
	public static void closeBrowser(){
		driver.quit();
	}	
}