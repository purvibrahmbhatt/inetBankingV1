package pageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegistrationTest {
	
	
	@Test
	public void verifyFlightReg() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\QA DOCS\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();	
		 
		// RegistrationPage2 RGPage = new RegistrationPage2(driver);
		 
		 RegistrationPage RGPage = new RegistrationPage(driver);
		 
		 
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 driver.get("http://newtours.demoaut.com/");
		 
		 RGPage.clickRegLink();
		 RGPage.setFirstName("purvi");
		 RGPage.setLastName("brahmmbhatt");
		 RGPage.setPhone("9405445789");
		 RGPage.setEmail("purvi@gmail.com");
		 RGPage.setAddress1("kndiieke");
		 RGPage.setAddress2("kkdii12");
		 RGPage.setCity("Ahmedabad");
		 RGPage.setState("Gujarat");
		 RGPage.setPostalCode("380001");
		 RGPage.setCountry("India");
		 RGPage.setUsername("purvibrhambhatt");
		 RGPage.setPassword("1234");
		 RGPage.setConfirmpassword("1234");
		 
		 RGPage.clickRegister();
		 
		 //Validation
		 
		 if (driver.getPageSource().contains("Thank you for registering.")) {
			
		} else {
			
			System.out.println("Your Registration failed");

		}
		
		driver.close();
	}
	

}
