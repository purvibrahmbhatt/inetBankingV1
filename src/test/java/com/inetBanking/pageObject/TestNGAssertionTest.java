package com.inetBanking.pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertionTest {
	SoftAssert softAssert1 = new SoftAssert();	
	SoftAssert softAssert2 = new SoftAssert();	
	
	@Test
  
  public void loginTest() {
	  
	System.setProperty("webdriver.chrome.driver", "C:\\QA DOCS\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");  //open url
		
		WebElement usernametxt =driver.findElement(By.name("userName"));
		WebElement passwordtxt =driver.findElement(By.name("password"));
		
		//this is to check whether the textbox is displayed or not
		//test will only continue, if the below statement is true
		
		
		  Assert.assertTrue(usernametxt.isDisplayed());
		  usernametxt.sendKeys("mercury");
		  
		  Assert.assertTrue(passwordtxt.isDisplayed());
		  passwordtxt.sendKeys("mercury");
		 
		
		
		
		/*
		 * Assert.assertFalse(usernametxt.isDisplayed());
		 * usernametxt.sendKeys("mercury");
		 * 
		 * Assert.assertFalse(passwordtxt.isDisplayed());
		 * passwordtxt.sendKeys("mecury");
		 */
		
		driver.findElement(By.name("login")).click();
		
		//Validation
		
		String ExpTitle = "Find a Flight: Mercury Tours:";
		Assert.assertEquals(ExpTitle, driver.getTitle());
		
		
		driver.quit();
		
		
		
		
		//Soft Assertion
		
	
		
		
  }	
		



  @Test

  

  	void Demo1() {
  	
  		softAssert1.assertEquals("Welcome", "welcome");  // false - failed
  		softAssert1.assertAll();
  	
  }
 
  @Test
  
  	void Demo2() {
	  
	  softAssert2.assertEquals("Welcome", "Welcome"); //true passed
	  softAssert2.assertAll();
  }
  
  
  
  
  
  
  
 
}
