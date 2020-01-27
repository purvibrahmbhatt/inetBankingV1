package com.inetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "C:\\QA DOCS\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();	
		 driver.get("http://demo.nopcommerce.com/");  //open url
			

	}

}
