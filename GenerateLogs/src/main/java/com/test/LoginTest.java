package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	// what is log? -> capturing info/activities at the time of execution
	// types of logs:
		//1. info
		//2. warn
		//4. error
		//5. fatal
	// how to generate the logs? -> use Apache log4j API (log4j.jar)
	// how it works? -> it reads log4j configuration from log4j.properties file
	// where to create log4j.properties file? -> create inside resource folder
	
	WebDriver driver;
	org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LoginTest.class);
	
	@Test
	public void googleSearch() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();  //launch chrome
		log.info("Launching Chrome Browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("***********************************starting Test Case**********************************");
		log.info("**************************Google Search Test*****************************************");
		driver.get("https://www.google.co.in");
		log.info("Entering application Google");
		driver.findElement(By.name("q")).sendKeys("eclipse");
		driver.findElement(By.name("btnK")).click();
		String expected = "eclipse - Google Search";
		log.info("Page title is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), expected);
		log.warn("Hey this is just a warning message");
		log.fatal("Hey this is just a fatal error message");
		log.debug("this is just a debug message");
		log.info("##################################### ending Test case ######################################");
	}
}
// Change 29 April 1:47 PM
// Change 29 April 11:59 PM
// Committing to test CI
// Commit 123
