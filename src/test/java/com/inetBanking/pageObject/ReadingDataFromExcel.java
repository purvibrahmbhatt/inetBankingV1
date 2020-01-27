package com.inetBanking.pageObject;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\QA DOCS\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		
		
		
		
		FileInputStream file = new FileInputStream("C:\\QA DOCS\\datadriven.xls");
		
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		
		HSSFSheet sheet = workbook.getSheet("Sheet3");
		
		//XSSFSheet sheet = workbook.getSheet("Sheet1");//providing sheetname
		
		//for loop to read number of rows and column
		
		int rowcount = sheet.getLastRowNum();   //find number of rows
		System.out.println("No of records : "+ rowcount);
		
		//int cellcount = sheet.getRow(0).getLastCellNum(); //find number of column
		
		for (int row = 1; row < rowcount; row++) {
			
			HSSFRow currentrow = sheet.getRow(row); //focus on current row
			
			/*
			for (int j = 0; j < cellcount; j++) {
				
			String value =	currentrow.getCell(j).toString();  //read value from Cell
				
			System.out.print("  "+ value);
			*/
		
			
			String First_Name = currentrow.getCell(0).getStringCellValue();
			String Last_Name = currentrow.getCell(1).getStringCellValue();
			//String Phone = currentrow.getCell(2).getStringCellValue();
			HSSFCell phone = currentrow.getCell(2);
			int Phone = (int)phone.getNumericCellValue();
			//String Phone = currentrow.getCell(2).getStringCellValue();
			String Email = currentrow.getCell(3).getStringCellValue();
			String Address = currentrow.getCell(4).getStringCellValue();
			String City = currentrow.getCell(5).getStringCellValue();
			String State = currentrow.getCell(6).getStringCellValue();
			
			HSSFCell postc = currentrow.getCell(7);
			int PostalCode = (int)postc.getNumericCellValue();
			//String PostalCode = currentrow.getCell(7).getStringCellValue();
			String Country = currentrow.getCell(8).getStringCellValue();
			String Username = currentrow.getCell(9).getStringCellValue();
			String Password = currentrow.getCell(10).getStringCellValue();
			
			//Registration process
			
			driver.findElement(By.linkText("REGISTER")).click();
			
			//Entering contact info
			
			driver.findElement(By.name("firstName")).sendKeys(First_Name);
			driver.findElement(By.name("lastName")).sendKeys(Last_Name);
			driver.findElement(By.name("phone")).sendKeys(String.valueOf(Phone));
			driver.findElement(By.name("userName")).sendKeys(Email);
			
			//Entering mailing information
			
			driver.findElement(By.name("address1")).sendKeys(Address);
			driver.findElement(By.name("address2")).sendKeys(Address);
			driver.findElement(By.name("city")).sendKeys(City);
			driver.findElement(By.name("state")).sendKeys(State);
			driver.findElement(By.name("postalCode")).sendKeys(String.valueOf(PostalCode));
			
			//County Selection
			
			Select dropcountry = new Select(driver.findElement(By.name("country")));
			dropcountry.selectByVisibleText(Country);
			
			//Entering user information
			
			driver.findElement(By.name("email")).sendKeys(Username);  //username
			driver.findElement(By.name("password")).sendKeys(Password);   //password
			driver.findElement(By.name("confirmPassword")).sendKeys(Password);
			
			//Submitting Form
			
			driver.findElement(By.name("register")).click();
			
			if (driver.getPageSource().contains("Thank you for registering")) {
				
				System.out.println("Registration Completed for "+ row + "record");
				
			} else {
				
				System.out.println("Registration failed for" + row + "record");
			}
			
			
		}
			
			System.out.println("DataDriven Test Completed");
			
			
			driver.quit();
		}
		
		
		
		
		
		
		

	}


